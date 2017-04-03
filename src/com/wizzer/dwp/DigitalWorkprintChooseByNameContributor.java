package com.wizzer.dwp;

import com.intellij.navigation.*;
import com.intellij.openapi.project.Project;
import com.wizzer.dwp.psi.DwpProperty;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * Created by msm on 4/3/17.
 */
public class DigitalWorkprintChooseByNameContributor implements ChooseByNameContributor {
    @NotNull
    @Override
    public String[] getNames(Project project, boolean includeNonProjectItems) {
        List<DwpProperty> properties = DigitalWorkprintUtil.findProperties(project);
        List<String> names = new ArrayList<String>(properties.size());
        for (DwpProperty property : properties) {
            if (property.getKey() != null && property.getKey().length() > 0) {
                names.add(property.getKey());
            }
        }
        return names.toArray(new String[names.size()]);
    }

    @NotNull
    @Override
    public NavigationItem[] getItemsByName(String name, String pattern, Project project, boolean includeNonProjectItems) {
        // TODO: include non project items
        List<DwpProperty> properties = DigitalWorkprintUtil.findProperties(project, name);
        return properties.toArray(new NavigationItem[properties.size()]);
    }
}
