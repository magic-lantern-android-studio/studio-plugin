package com.wizzer.dwp;

import com.intellij.lang.Language;

/**
 * Created by msm on 3/31/17.
 */
public class DigitalWorkprintLanguage extends Language
{
    public static final DigitalWorkprintLanguage INSTANCE = new DigitalWorkprintLanguage();

    private DigitalWorkprintLanguage() {
        super("DigitalWorkprint");
    }
}
