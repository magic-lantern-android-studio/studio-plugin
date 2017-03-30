// Declare package.
package com.wizzer.tools.idea.actions;

// Import IntelliJ plugin classes.
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileSystem;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.PsiManager;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * Created by msm on 3/21/17.
 */
public class MleInspectFileAction extends AnAction
{
    // If you register the actions from Java code, this constructor is used to set the menu item name
    // (optionally, you can specify the menu description and an icon to display next to the menu item).
    // You can omit this constructor when registering the actions in the plugin.xml file.
    public MleInspectFileAction()
    {
        // Set the menu item name.
        super("MleInspectFileMenu");
        // Set the menu item name, description and icon.
        // super("Text _Boxes","Item description",IconLoader.getIcon("/Mypackage/icon.png"));
    }

    public void actionPerformed(AnActionEvent event)
    {
        // Get the selected project context.
        Project project = event.getData(PlatformDataKeys.PROJECT);

        // Get selected file from Project.
        //VirtualFile file = DataKeys.VIRTUAL_FILE.getData(event.getDataContext());

        // Better way to do this if multiple selections were made.
        VirtualFile selection[] = DataKeys.VIRTUAL_FILE_ARRAY.getData(event.getDataContext());

        // Get the selected file's parent folder.
        //VirtualFile folder = file.getParent();

        // Example on how to get a handle to the PSI file from the event. Note that null will be returned
        // if multiple selections were made.
        //PsiFile file = event.getData(LangDataKeys.PSI_FILE);

        // Display some information about the selection.
        displaySelection(project, selection);

        // Create a Readme.txt file if the selection is a directory.
        if (selection[0].isDirectory()) {
            PsiDirectory dest = PsiManager.getInstance(project).findDirectory(selection[0]);
            createFile(project, dest);
        }
    }

    // Display the selected VirtualFiles.
    private void displaySelection(Project project, VirtualFile[] selection)
    {
        String msg;
        if (selection != null)
            msg = buildSelectionList(selection);
        else
            msg = "Unable to process selection.";
        Messages.showMessageDialog(project, "Virtual File(s) selected:\n" + msg + "\n",
                "Information", Messages.getInformationIcon());
    }

    // Build up a string containing information about the selection.
    private String buildSelectionList(VirtualFile[] selection)
    {
        String selectionList = new String();
        for (int i = 0; i < selection.length; i++) {
            selectionList += "    ";
            selectionList += selection[i].getName();
            if (selection[i].isDirectory())
                selectionList += " (folder)";
            selectionList += "\n";
        }

        return selectionList;
    }

    // Create a Readme.txt file in the selected project.
    private VirtualFile createFile(Project project, PsiDirectory dir)
    {
        String filename = "Readme.txt";
        PsiFile newFile = null;

        try {
            dir.checkCreateFile(filename);

            // If we made it to here, we can create the file.
            newFile = PsiFileFactory.getInstance(project).createFileFromText("Readme.txt",
                    "This file was created by the Magic Lantern Plugin.");
            dir.add(newFile);
        } catch (IncorrectOperationException ex) {
            Messages.showMessageDialog(project, ex.getMessage(),
                    "Error", Messages.getErrorIcon());
        }

        if (newFile != null)
            return newFile.getVirtualFile();
        else
            return null;
    }
}
