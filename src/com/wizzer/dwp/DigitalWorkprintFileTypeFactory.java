package com.wizzer.dwp;

import com.intellij.openapi.fileTypes.FileTypeFactory;
import com.intellij.openapi.fileTypes.FileTypeConsumer;
import org.jetbrains.annotations.*;

/**
 * Created by msm on 3/31/17.
 */
public class DigitalWorkprintFileTypeFactory extends FileTypeFactory
{
    @Override
    public void createFileTypes(@NotNull FileTypeConsumer fileTypeConsumer) {
        fileTypeConsumer.consume(DigitalWorkprintFileType.INSTANCE, "dwp");
    }
}
