package com.wizzer.dwp;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import com.wizzer.dwp.psi.DigitalWorkprintTypes;
import org.jetbrains.annotations.NotNull;

/**
 * Created by msm on 4/3/17.
 */
public class DigitalWorkprintCompletionContributor extends CompletionContributor {
    public DigitalWorkprintCompletionContributor() {
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement(DigitalWorkprintTypes.VALUE).withLanguage(DigitalWorkprintLanguage.INSTANCE),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("Hello"));
                    }
                }
        );
    }
}
