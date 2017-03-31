package com.wizzer.dwp.psi;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.*;

import com.wizzer.dwp.DigitalWorkprintLanguage;

/**
 * Created by msm on 3/31/17.
 */
public class DigitalWorkprintElementType extends IElementType
{
    public DigitalWorkprintElementType(@NotNull @NonNls String debugName)
    {
        super(debugName, DigitalWorkprintLanguage.INSTANCE);
    }
}
