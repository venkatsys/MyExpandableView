package com.receipt.myexpandableview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ExpandableListView.OnChildClickListener{
    public AnimatedExpandableListView mListView;
    private ReceiptAdapter mAdapter;
    private List<SectionDatas> msectionDatas;
    private List<SectionValues> msectionValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expandable_layout);

        this.mListView = (AnimatedExpandableListView) this.findViewById(R.id.apppexpandableview);
        toInitListValues();
    }

    /**
     * Method to Init Values
     */
    private void toInitListValues() {
        this.msectionDatas = new ArrayList<>();
        this.msectionValues = new ArrayList<>();
        for(int i = 0 ; i < 10 ; i++){
            SectionDatas sectionDatas = new SectionDatas();
            sectionDatas.setmTitle("Section Title" + i);
            sectionDatas.setmDesc("Section Description" + i);
            for(int j = 0 ; j < 1 ; j++){
                SectionValues sectionValues = new SectionValues();
                sectionValues.setmTitle("Section Value Title" + i);
                sectionValues.setmDesc("Section Description Title" + j + 1);
                msectionValues.add(sectionValues);
            }
            sectionDatas.setSectionValues(msectionValues);
            msectionDatas.add(sectionDatas);
        }
        this.mAdapter = new ReceiptAdapter(this,msectionDatas);
        this.mListView.setAdapter(this.mAdapter);
        this.mListView.setOnGroupClickListener(new ExpandableGroupClick(this));
        this.mListView.setOnGroupExpandListener((new ExpandableGroupExpand(this)));
        this.mListView.setOnChildClickListener(this);
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        SectionValues msectionValues = (SectionValues) msectionDatas.get(groupPosition).getSectionValues().get(childPosition);
        Log.i("childclick","click" + msectionValues.getmTitle() + msectionValues.getmDesc());
        return false;
    }
}
