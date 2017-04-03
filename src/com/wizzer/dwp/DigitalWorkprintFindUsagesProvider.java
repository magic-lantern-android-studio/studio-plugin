package com.wizzer.dwp;

import com.intellij.lang.cacheBuilder.*;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.*;
import com.intellij.psi.tree.TokenSet;
import com.wizzer.dwp.psi.*;
import org.jetbrains.annotations.*;

/**
 * Created by msm on 4/3/17.
 */
public class DigitalWorkprintFindUsagesProvider implements FindUsagesProvider {
    @Nullable
    @Override
    public WordsScanner getWordsScanner() {
        return new DefaultWordsScanner(new DigitalWorkprintLexerAdapter(),
                TokenSet.create(DigitalWorkprintTypes.KEY),
                TokenSet.create(DigitalWorkprintTypes.COMMENT),
                TokenSet.EMPTY);
    }

    @Override
    public boolean canFindUsagesFor(@NotNull PsiElement psiElement) {
        return psiElement instanceof PsiNamedElement;
    }

    @Nullable
    @Override
    public String getHelpId(@NotNull PsiElement psiElement) {
        return null;
    }

    @NotNull
    @Override
    public String getType(@NotNull PsiElement element) {
        if (element instanceof DwpProperty) {
            return "dwp property";
        } else {
            return "";
        }
    }

    @NotNull
    @Override
    public String getDescriptiveName(@NotNull PsiElement element) {
        if (element instanceof DwpProperty) {
            return ((DwpProperty) element).getKey();
        } else {
            return "";
        }
    }

    @NotNull
    @Override
    public String getNodeText(@NotNull PsiElement element, boolean useFullName) {
        if (element instanceof DwpProperty) {
            return ((DwpProperty) element).getKey() + ":" + ((DwpProperty) element).getValue();
        } else {
            return "";
        }
    }
}
