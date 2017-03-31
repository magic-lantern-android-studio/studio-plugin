// Declare Package
package com.wizzer.tools.idea.npw;

// Import IntelliJ plugin packages.
import com.android.tools.idea.npw.NewProjectWizardDynamic;
import com.android.tools.idea.wizard.dynamic.AndroidStudioWizardPath;
import com.android.tools.idea.wizard.dynamic.DynamicWizardHost;
import com.android.tools.idea.wizard.dynamic.DynamicWizardPath;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiTreeChangeEvent;
import com.intellij.psi.PsiTreeChangeListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

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

    @Override
    protected void doFinish() throws IOException {
        super.doFinish();

        // Add listener for when PSI files change.
        Project project = this.getProject();
        PsiManager.getInstance(project).addPsiTreeChangeListener(new MagicLanternPsiTreeChangeListener());
    }

    class MagicLanternPsiTreeChangeListener implements PsiTreeChangeListener {
        public void beforeChildAddition(@NotNull PsiTreeChangeEvent event) {
            //System.out.println("MagicLantern: beforeChildAddition().");
        }

        public void beforeChildRemoval(@NotNull PsiTreeChangeEvent event) {
            //System.out.println("MagicLantern: beforeChildRemoval().");
        }

        public void beforeChildReplacement(@NotNull PsiTreeChangeEvent event) {
            //System.out.println("MagicLantern: beforeChildReplacement().");
        }

        public void beforeChildMovement(@NotNull PsiTreeChangeEvent event) {
            //System.out.println("MagicLantern: beforeChildMovement().");
        }

        public void beforeChildrenChange(@NotNull PsiTreeChangeEvent event) {
            //System.out.println("MagicLantern: beforeChildChange().");
        }

        public void beforePropertyChange(@NotNull PsiTreeChangeEvent event) {
            //System.out.println("MagicLantern: beforePropertyChange().");
        }

        public void childAdded(@NotNull PsiTreeChangeEvent event) {
            //System.out.println("MagicLantern: childAdded().");
        }

        public void childRemoved(@NotNull PsiTreeChangeEvent event) {
            //System.out.println("MagicLantern: childRemoved().");
        }

        public void childReplaced(@NotNull PsiTreeChangeEvent event) {
            //System.out.println("MagicLantern: childReplaced().");
        }

        public void childrenChanged(@NotNull PsiTreeChangeEvent event) {
            //System.out.println("MagicLantern: childChanged().");
        }

        public void childMoved(@NotNull PsiTreeChangeEvent event) {
            //System.out.println("MagicLantern: childMoved().");
        }

        public void propertyChanged(@NotNull PsiTreeChangeEvent event) {
            //System.out.println("MagicLantern: propertyChanged().");
        }
    }
}
