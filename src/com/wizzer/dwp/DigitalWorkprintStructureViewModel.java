package com.wizzer.dwp;

import com.intellij.ide.structureView.*;
import com.intellij.ide.util.treeView.smartTree.Sorter;
import com.intellij.psi.PsiFile;
import com.wizzer.dwp.psi.DigitalWorkprintFile;
import org.jetbrains.annotations.NotNull;

/**
 * Created by msm on 4/3/17.
 */
public class DigitalWorkprintStructureViewModel extends StructureViewModelBase implements
        StructureViewModel.ElementInfoProvider
{
    public DigitalWorkprintStructureViewModel(PsiFile psiFile) {
        super(psiFile, new DigitalWorkprintStructureViewElement(psiFile));
    }

    @NotNull
    public Sorter[] getSorters() {
        return new Sorter[]{Sorter.ALPHA_SORTER};
    }

    @Override
    public boolean isAlwaysShowsPlus(StructureViewTreeElement element) {
        return false;
    }

    @Override
    public boolean isAlwaysLeaf(StructureViewTreeElement element) {
        return element instanceof DigitalWorkprintFile;
    }
}
