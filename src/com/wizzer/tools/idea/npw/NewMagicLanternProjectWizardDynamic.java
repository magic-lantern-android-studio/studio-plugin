// Declare Package
package com.wizzer.tools.idea.npw;

// Import IntelliJ plugin packages.
import com.android.tools.idea.npw.NewProjectWizardDynamic;
import com.android.tools.idea.wizard.dynamic.AndroidStudioWizardPath;
import com.android.tools.idea.wizard.dynamic.DynamicWizardHost;
import com.android.tools.idea.wizard.dynamic.DynamicWizardPath;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by msm on 3/28/17.
 */
public class NewMagicLanternProjectWizardDynamic extends NewProjectWizardDynamic
{
    public NewMagicLanternProjectWizardDynamic(@Nullable Project project, @Nullable Module module) {
        super(project, module);
        setTitle("Create New Magic Lantern Project");
    }

    public NewMagicLanternProjectWizardDynamic(@Nullable Project project,
                                               @Nullable Module module,
                                               @NotNull DynamicWizardHost host) {
        super(project, module, host);
        setTitle("Create New Magic Lantern Project");
    }

    @Override
    public void init() {
        super.init();

        AndroidStudioWizardPath path = getCurrentPath();
        if (path instanceof DynamicWizardPath) {
            // Add a step for configuring Magic Lantern Modules
            ((DynamicWizardPath) path).addStep(new ConfigureMagicLanternProjectStep(this.getDisposable()));
        }
    }
}
