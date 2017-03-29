/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wizzer.tools.idea.actions;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.wm.impl.welcomeScreen.NewWelcomeScreen;
import com.wizzer.tools.idea.npw.NewMagicLanternProjectWizardDynamic;
import org.jetbrains.annotations.NotNull;

public class MleNewProjectAction extends AnAction implements DumbAware {
  public MleNewProjectAction() {
    this("New Project...");
  }

  public MleNewProjectAction(@NotNull String text) {
    super(text);
  }

  @Override
  public void update(@NotNull AnActionEvent e) {
    if (NewWelcomeScreen.isNewWelcomeScreen(e)) {
      e.getPresentation().setIcon(AllIcons.Welcome.CreateNewProject);
    }
  }

  @Override
  public void actionPerformed(AnActionEvent e) {
    NewMagicLanternProjectWizardDynamic dialog;
    try {
      dialog = new NewMagicLanternProjectWizardDynamic(null, null);
      dialog.init();
    }
    catch (IllegalStateException error) {
      Logger.getInstance(com.android.tools.idea.actions.AndroidNewProjectAction.class).warn("Unable to launch New Project Wizard", error);
      return;
    }

    dialog.show();
  }
}
