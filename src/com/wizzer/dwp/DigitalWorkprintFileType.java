package com.wizzer.dwp;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.*;

import javax.swing.*;

/**
 * Created by msm on 3/31/17.
 */
public class DigitalWorkprintFileType extends LanguageFileType
{
    public static final DigitalWorkprintFileType INSTANCE = new DigitalWorkprintFileType();

    private DigitalWorkprintFileType() {
        super(DigitalWorkprintLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Digital Workprint file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Digital Workprint language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "dwp";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return DigitalWorkprintIcons.FILE;
    }
}
