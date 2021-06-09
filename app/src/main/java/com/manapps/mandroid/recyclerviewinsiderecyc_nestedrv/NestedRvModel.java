package com.manapps.mandroid.recyclerviewinsiderecyc_nestedrv;

import java.util.List;

public class NestedRvModel {
    public List<ParentItemModel> getParentItemList() {
        return parentItemList;
    }

    public void setParentItemList(List<ParentItemModel> parentItemList) {
        this.parentItemList = parentItemList;
    }

    private List<ParentItemModel> parentItemList = null;
}
