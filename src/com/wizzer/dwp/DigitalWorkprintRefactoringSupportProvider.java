package com.wizzer.dwp;

import com.intellij.lang.refactoring.RefactoringSupportProvider;
import com.intellij.psi.PsiElement;
import com.wizzer.dwp.psi.DwpProperty;

/**
 * Created by msm on 4/3/17.
 */
public class DigitalWorkprintRefactoringSupportProvider extends RefactoringSupportProvider {
    @Override
    public boolean isMemberInplaceRenameAvailable(PsiElement element, PsiElement context) {
        return element instanceof DwpProperty;
    }
}
