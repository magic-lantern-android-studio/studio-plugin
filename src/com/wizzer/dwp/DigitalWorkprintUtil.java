package com.wizzer.dwp;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.*;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.indexing.FileBasedIndex;
import com.wizzer.dwp.psi.*;

import java.util.*;

/**
 * Created by msm on 4/3/17.
 */
public class DigitalWorkprintUtil
{
    public static List<DwpProperty> findProperties(Project project, String key) {
        List<DwpProperty> result = null;
        Collection<VirtualFile> virtualFiles =
                FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, DigitalWorkprintFileType.INSTANCE,
                        GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            DigitalWorkprintFile dwpFile = (DigitalWorkprintFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (dwpFile != null) {
                DwpProperty[] properties = PsiTreeUtil.getChildrenOfType(dwpFile, DwpProperty.class);
                if (properties != null) {
                    for (DwpProperty property : properties) {
                        if (key.equals(property.getKey())) {
                            if (result == null) {
                                result = new ArrayList<DwpProperty>();
                            }
                            result.add(property);
                        }
                    }
                }
            }
        }
        return result != null ? result : Collections.<DwpProperty>emptyList();
    }

    public static List<DwpProperty> findProperties(Project project) {
        List<DwpProperty> result = new ArrayList<DwpProperty>();
        Collection<VirtualFile> virtualFiles =
                FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, DigitalWorkprintFileType.INSTANCE,
                        GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            DigitalWorkprintFile dwpFile = (DigitalWorkprintFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (dwpFile != null) {
                DwpProperty[] properties = PsiTreeUtil.getChildrenOfType(dwpFile, DwpProperty.class);
                if (properties != null) {
                    Collections.addAll(result, properties);
                }
            }
        }
        return result;
    }
}
