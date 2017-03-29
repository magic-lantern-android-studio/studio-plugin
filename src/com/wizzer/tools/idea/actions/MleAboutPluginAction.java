// Declare package.
package com.wizzer.tools.idea.actions;

// Import IntelliJ plugin classes.
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;


/**
 * Created by msm on 3/21/17.
 */
public class MleAboutPluginAction extends AnAction
{
    // If you register the actions from Java code, this constructor is used to set the menu item name
    // (optionally, you can specify the menu description and an icon to display next to the menu item).
    // You can omit this constructor when registering the actions in the plugin.xml file.
    public MleAboutPluginAction()
    {
        // Set the menu item name.
        super("MleAboutPluginMenu");
        // Set the menu item name, description and icon.
        // super("Text _Boxes","Item description",IconLoader.getIcon("/Mypackage/icon.png"));
    }

    public void actionPerformed(AnActionEvent event)
    {
        Project project = event.getData(PlatformDataKeys.PROJECT);
        Messages.showMessageDialog(project, "Magic Lantern Plugin\nProof of Concept", "Information",
                Messages.getInformationIcon());
    }
}
