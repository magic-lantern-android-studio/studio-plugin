package com.wizzer.dwp;

import com.intellij.lang.ParserDefinition;
import com.intellij.lang.*;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.psi.tree.*;
import org.jetbrains.annotations.NotNull;

import com.wizzer.dwp.parser.DigitalWorkprintParser;
import com.wizzer.dwp.psi.DigitalWorkprintFile;
import com.wizzer.dwp.psi.DigitalWorkprintTypes;

/**
 * Created by msm on 3/31/17.
 */
public class DigitalWorkprintParserDefinition implements ParserDefinition
{
    public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
    public static final TokenSet COMMENTS = TokenSet.create(DigitalWorkprintTypes.COMMENT);

    public static final IFileElementType FILE = new IFileElementType(DigitalWorkprintLanguage.INSTANCE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new DigitalWorkprintLexerAdapter();
    }

    @NotNull
    public TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }

    @NotNull
    public TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @NotNull
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    public PsiParser createParser(final Project project) {
        return new DigitalWorkprintParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    public PsiFile createFile(FileViewProvider viewProvider) {
        return new DigitalWorkprintFile(viewProvider);
    }

    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }

    @NotNull
    public PsiElement createElement(ASTNode node) {
        return DigitalWorkprintTypes.Factory.createElement(node);
    }
}
