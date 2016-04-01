package com.receipt.myexpandableview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venkat on 31-03-2016.
 */
public class SectionDatas {

    private String mTitle;
    private String mDesc;
    private List<SectionValues> sectionValues = new ArrayList<>();

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmDesc() {
        return mDesc;
    }

    public void setmDesc(String mDesc) {
        this.mDesc = mDesc;
    }

    public List<SectionValues> getSectionValues() {
        return sectionValues;
    }

    public void setSectionValues(List<SectionValues> sectionValues) {
        this.sectionValues = sectionValues;
    }

}
