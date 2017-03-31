package com.wizzer.dwp.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.wizzer.dwp.DigitalWorkprintFileType;
import com.wizzer.dwp.DigitalWorkprintLanguage;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * Created by msm on 3/31/17.
 */
public class DigitalWorkprintFile extends PsiFileBase
{
    public DigitalWorkprintFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, DigitalWorkprintLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return DigitalWorkprintFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Digital Workprint File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}
