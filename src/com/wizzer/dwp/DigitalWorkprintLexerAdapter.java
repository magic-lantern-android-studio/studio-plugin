package com.wizzer.dwp;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

/**
 * Created by msm on 3/31/17.
 */
public class DigitalWorkprintLexerAdapter extends FlexAdapter
{
    public DigitalWorkprintLexerAdapter() {
        super(new DigitalWorkprintLexer((Reader) null));
    }
}
