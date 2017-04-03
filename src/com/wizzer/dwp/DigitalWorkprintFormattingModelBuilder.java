package com.wizzer.dwp;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.wizzer.dwp.psi.DigitalWorkprintTypes;
import org.jetbrains.annotations.*;

/**
 * Created by msm on 4/3/17.
 */
public class DigitalWorkprintFormattingModelBuilder  implements FormattingModelBuilder {
    @NotNull
    @Override
    public FormattingModel createModel(PsiElement element, CodeStyleSettings settings) {
        return FormattingModelProvider.createFormattingModelForPsiFile(element.getContainingFile(),
                new DigitalWorkprintBlock(element.getNode(),
                        Wrap.createWrap(WrapType.NONE,
                                false),
                        Alignment.createAlignment(),
                        createSpaceBuilder(settings)),
                settings);
    }

    private static SpacingBuilder createSpaceBuilder(CodeStyleSettings settings) {
        return new SpacingBuilder(settings, DigitalWorkprintLanguage.INSTANCE).
                around(DigitalWorkprintTypes.SEPARATOR)
                .spaceIf(settings.SPACE_AROUND_ASSIGNMENT_OPERATORS)
                .
                        before(DigitalWorkprintTypes.PROPERTY)
                .none();
    }

    @Nullable
    @Override
    public TextRange getRangeAffectingIndent(PsiFile file, int offset, ASTNode elementAtOffset) {
        return null;
    }
}
