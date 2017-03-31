package com.wizzer.dwp.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import com.wizzer.dwp.DigitalWorkprintFileType;

/**
 * Created by msm on 3/31/17.
 */
public class DigitalWorkprintElementFactory
{
    public static DwpProperty createProperty(Project project, String name, String value) {
        final DigitalWorkprintFile file = createFile(project, name + " = " + value);
        return (DwpProperty) file.getFirstChild();
    }

    public static DwpProperty createProperty(Project project, String name) {
        final DigitalWorkprintFile file = createFile(project, name);
        return (DwpProperty) file.getFirstChild();
    }

    public static PsiElement createCRLF(Project project) {
        final DigitalWorkprintFile file = createFile(project, "\n");
        return file.getFirstChild();
    }

    public static DigitalWorkprintFile createFile(Project project, String text) {
        String name = "dummy.dwp";
        return (DigitalWorkprintFile) PsiFileFactory.getInstance(project).
                createFileFromText(name, DigitalWorkprintFileType.INSTANCE, text);
    }
}
