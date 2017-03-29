// Declare package.
package com.wizzer.tools.idea.npw;

import com.android.tools.idea.wizard.dynamic.DynamicWizardStepWithHeaderAndDescription;
import com.intellij.openapi.Disposable;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * Created by msm on 3/29/17.
 */
public class ConfigureMagicLanternProjectStep  extends DynamicWizardStepWithHeaderAndDescription
{
    private JPanel myPanel;
    private JTextField myAppName;

    public ConfigureMagicLanternProjectStep(@NotNull Disposable disposable) {
        this("Magic Lantern Configuration", disposable);
    }

    public ConfigureMagicLanternProjectStep(String title, Disposable parentDisposable) {
        super(title, null, parentDisposable);
        setBodyComponent(myPanel);
    }

    @NotNull
    @Override
    public String getStepName() {
        return "Configure Magic Lantern Project";
    }

    @Override
    public JComponent getPreferredFocusedComponent() {
        return myAppName;
    }
}
