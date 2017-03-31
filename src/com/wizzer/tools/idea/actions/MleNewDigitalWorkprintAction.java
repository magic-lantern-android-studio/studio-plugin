// Declare package.
package com.wizzer.tools.idea.actions;

// Import IntelliJ plugin classes.
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.PsiManager;
import com.intellij.util.IncorrectOperationException;


/**
 * Created by msm on 3/21/17.
 */
public class MleNewDigitalWorkprintAction extends AnAction
{
    // If you register the actions from Java code, this constructor is used to set the menu item name
    // (optionally, you can specify the menu description and an icon to display next to the menu item).
    // You can omit this constructor when registering the actions in the plugin.xml file.
    public MleNewDigitalWorkprintAction()
    {
        // Set the menu item name.
        super("MleNewDigitalWorkprintMenu");
        // Set the menu item name, description and icon.
        // super("Text _Boxes","Item description",IconLoader.getIcon("/Mypackage/icon.png"));
    }

    public void actionPerformed(AnActionEvent event)
    {
        // Get the selected project context.
        Project project = event.getData(PlatformDataKeys.PROJECT);

        // Get selected file from Project.
        VirtualFile selection = DataKeys.VIRTUAL_FILE.getData(event.getDataContext());

        // Create a Simple.dwp file if the selection is a directory.
        if ((selection != null) && selection.isDirectory()) {
            PsiDirectory dest = PsiManager.getInstance(project).findDirectory(selection);
            // Writing to the PSI must be done within the UI thread.
            ApplicationManager.getApplication().runWriteAction(new CreateDWPRunnable(project, dest));
        } else {
            String msg = "Unable to create Digital Workprint: Invalid selection.";
            Messages.showMessageDialog(project, msg,"Warning", Messages.getWarningIcon());
        }
    }

    class CreateDWPRunnable implements Runnable
    {
        public Project m_project;
        public PsiDirectory m_directory;

        public CreateDWPRunnable(Project project, PsiDirectory directory)
        {
            m_project = project;
            m_directory = directory;
        }

        public void run()
        {
            createDWP(m_project, m_directory);
        }

        // Create a Simple.dwp file in the selected project.
        private VirtualFile createDWP(Project project, PsiDirectory dir) {
            String filename = "Simple.dwp";
            PsiFile newFile = null;

            try {
                // Check whether the new file can be created in the specified directory.
                dir.checkCreateFile(filename);

                // If we made it to here, we can create the Digital Workprint; otherwise an
                // IncorrectOperationException would have been thrown.
                newFile = PsiFileFactory.getInstance(project).createFileFromText(filename,
                        "Magic Lantern Digital Workprint.");

                // TODO: Add property on file here indicating that it was created
                // by the Magic Lantern plugin.

                // Add the new file to the folder and write it to disk.
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

        // Hide default constructor.
        private CreateDWPRunnable() {}
    }
}
