package com.wizzer.dwp.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.wizzer.dwp.psi.DigitalWorkprintElementFactory;
import com.wizzer.dwp.psi.DigitalWorkprintNamedElement;
import com.wizzer.dwp.psi.DigitalWorkprintTypes;
import com.wizzer.dwp.psi.DwpProperty;
import org.jetbrains.annotations.NotNull;

/**
 * Created by msm on 3/31/17.
 */
public class DigitalWorkprintNamedElementImpl extends ASTWrapperPsiElement implements DigitalWorkprintNamedElement
{
    public DigitalWorkprintNamedElementImpl(@NotNull ASTNode node)
    {
        super(node);
    }

    public static String getName(DwpProperty element)
    {
        return getKey(element);
    }

    public static PsiElement setName(DwpProperty element, String newName) {
        ASTNode keyNode = element.getNode().findChildByType(DigitalWorkprintTypes.KEY);
        if (keyNode != null) {

            DwpProperty property = DigitalWorkprintElementFactory.createProperty(element.getProject(), newName);
            ASTNode newKeyNode = property.getFirstChild().getNode();
            element.getNode().replaceChild(keyNode, newKeyNode);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(DwpProperty element) {
        ASTNode keyNode = element.getNode().findChildByType(DigitalWorkprintTypes.KEY);
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }
}
