// Declare package.
package com.wizzer.tools.idea.actions;

// Import IntelliJ plugin classes.
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;


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
        VirtualFile selection[] = DataKeys.VIRTUAL_FILE_ARRAY.getData(event.getDataContext());
        // Get the selected file's parent folder.
        //VirtualFile folder = file.getParent();

        // Display some information about the selection.
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
            selectionList += "  ";
            selectionList += selection[i].getName();
            if (selection[i].isDirectory())
                selectionList += " (folder)";
            selectionList += "\n";
        }

        return selectionList;
    }
}
