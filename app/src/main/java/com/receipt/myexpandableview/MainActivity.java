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
        Log.i("childclick", "click" + msectionValues.getmTitle() + msectionValues.getmDesc());
        return false;
    }

    private void updateCall(){
        /*Uri todoUri = null;
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_TASKNAME, this.taskName.getText().toString());
        cv.put(DatabaseHelper.COLUMN_CREATEDBY, getPref.getString("UserGUID", "-1"));
        if(dataResult.get("taskeditID") != null){
            todoUri = Uri.parse("content://com.tasks/task/"+dataResult.get("taskeditID")+"/update");
            getApplicationContext().getContentResolver().update(todoUri, cv, null, null);
        }
        private static final int TASKUPDATECODE=103;
        matcher.addURI(AUTHORITY, "task*//*//*update", TASKUPDATECODE);
        @Override
        public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
            int row = 0;
            int matched = uriMatcher.match(uri);
            TaskId = null;
            if( matched == TASKUPDATECODE){
                TaskId = uri.getPathSegments().get(1);
                String where = DatabaseHelper.COLUMN_TASKID + " = '" + TaskId + "'";
                row = getDb().update(DatabaseHelper.DONE_TASKINFO, values, where, null);
            }
            if (row > 0) {
                getContext().getContentResolver().notifyChange(Uri.parse("content://com.tasks/task/get"), null);
            }
            return row;
        }*/
    }
}
