package com.wizzer.dwp;

import com.intellij.codeInsight.lookup.*;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.wizzer.dwp.psi.DwpProperty;
import org.jetbrains.annotations.*;

import java.util.*;
/**
 * Created by msm on 4/3/17.
 */
public class DigitalWorkprintReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {
    private String key;

    public DigitalWorkprintReference(@NotNull PsiElement element, TextRange textRange) {
        super(element, textRange);
        key = element.getText().substring(textRange.getStartOffset(), textRange.getEndOffset());
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        Project project = myElement.getProject();
        final List<DwpProperty> properties = DigitalWorkprintUtil.findProperties(project, key);
        List<ResolveResult> results = new ArrayList<ResolveResult>();
        for (DwpProperty property : properties) {
            results.add(new PsiElementResolveResult(property));
        }
        return results.toArray(new ResolveResult[results.size()]);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        Project project = myElement.getProject();
        List<DwpProperty> properties = DigitalWorkprintUtil.findProperties(project);
        List<LookupElement> variants = new ArrayList<LookupElement>();
        for (final DwpProperty property : properties) {
            if (property.getKey() != null && property.getKey().length() > 0) {
                variants.add(LookupElementBuilder.create(property).
                        withIcon(DigitalWorkprintIcons.FILE).
                        withTypeText(property.getContainingFile().getName())
                );
            }
        }
        return variants.toArray();
    }
}
