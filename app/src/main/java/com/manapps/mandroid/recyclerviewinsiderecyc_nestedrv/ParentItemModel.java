package com.manapps.mandroid.recyclerviewinsiderecyc_nestedrv;

import java.util.List;

public class ParentItemModel {

    private String section;

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public List<ChildItemModel> getChildItemsList() {
        return childItemsList;
    }

    public void setChildItemsList(List<ChildItemModel> childItemsList) {
        this.childItemsList = childItemsList;
    }

    private List<ChildItemModel> childItemsList = null;

}
