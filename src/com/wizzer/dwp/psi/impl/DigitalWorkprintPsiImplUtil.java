package com.wizzer.dwp.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.*;
import com.wizzer.dwp.DigitalWorkprintIcons;
import com.wizzer.dwp.psi.*;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by msm on 4/3/17.
 */
public class DigitalWorkprintPsiImplUtil
{
    public static String getKey(DwpProperty element) {
        ASTNode keyNode = element.getNode().findChildByType(DigitalWorkprintTypes.KEY);
        if (keyNode != null) {
            // IMPORTANT: Convert embedded escaped spaces to simple spaces
            return keyNode.getText().replaceAll("\\\\ ", " ");
        } else {
            return null;
        }
    }

    public static String getValue(DwpProperty element) {
        ASTNode valueNode = element.getNode().findChildByType(DigitalWorkprintTypes.VALUE);
        if (valueNode != null) {
            return valueNode.getText();
        } else {
            return null;
        }
    }

    public static String getName(DwpProperty element) {
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

    public static ItemPresentation getPresentation(final DwpProperty element) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return element.getKey();
            }

            @Nullable
            @Override
            public String getLocationString() {
                PsiFile containingFile = element.getContainingFile();
                return containingFile == null ? null : containingFile.getName();
            }

            @Nullable
            @Override
            public Icon getIcon(boolean unused) {
                return DigitalWorkprintIcons.FILE;
            }
        };
    }
}
