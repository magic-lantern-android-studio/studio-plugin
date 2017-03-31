package com.wizzer.dwp.psi;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.*;

import com.wizzer.dwp.DigitalWorkprintLanguage;


/**
 * Created by msm on 3/31/17.
 */
public class DigitalWorkprintTokenType extends IElementType
{
    public DigitalWorkprintTokenType(@NotNull @NonNls String debugName)
    {
        super(debugName, DigitalWorkprintLanguage.INSTANCE);
    }

    @Override
    public String toString()
    {
        return "DigitalWorkprintTokenType." + super.toString();
    }
}
