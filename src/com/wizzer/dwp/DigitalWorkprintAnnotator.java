package com.wizzer.dwp;

import com.intellij.lang.annotation.*;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.wizzer.dwp.psi.DwpProperty;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Created by msm on 4/3/17.
 */
public class DigitalWorkprintAnnotator implements Annotator {
    @Override
    public void annotate(@NotNull final PsiElement element, @NotNull AnnotationHolder holder) {
        if (element instanceof PsiLiteralExpression) {
            PsiLiteralExpression literalExpression = (PsiLiteralExpression) element;
            String value = literalExpression.getValue() instanceof String ? (String) literalExpression.getValue() : null;

            if (value != null && value.startsWith("dwp" + ":")) {
                Project project = element.getProject();
                String key = value.substring(4);
                List<DwpProperty> properties = DigitalWorkprintUtil.findProperties(project, key);
                if (properties.size() == 1) {
                    TextRange range = new TextRange(element.getTextRange().getStartOffset() + 4,
                            element.getTextRange().getStartOffset() + 4);
                    Annotation annotation = holder.createInfoAnnotation(range, null);
                    annotation.setTextAttributes(DefaultLanguageHighlighterColors.LINE_COMMENT);
                } else if (properties.size() == 0) {
                    TextRange range = new TextRange(element.getTextRange().getStartOffset() + 5,
                            element.getTextRange().getEndOffset());
                    holder.createErrorAnnotation(range, "Unresolved property").
                            registerFix(new CreatePropertyQuickFix(key));
                }
            }
        }
    }
}
