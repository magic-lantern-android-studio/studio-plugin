package com.wizzer.dwp.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.wizzer.dwp.psi.DigitalWorkprintNamedElement;
import org.jetbrains.annotations.NotNull;

/**
 * Created by msm on 3/31/17.
 */
public abstract class DigitalWorkprintNamedElementImpl extends ASTWrapperPsiElement implements DigitalWorkprintNamedElement
{
    public DigitalWorkprintNamedElementImpl(@NotNull ASTNode node)
    {
        super(node);
    }
}
