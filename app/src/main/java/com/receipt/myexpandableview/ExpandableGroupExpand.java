package com.receipt.myexpandableview;

import android.widget.ExpandableListView.OnGroupExpandListener;

public class ExpandableGroupExpand implements OnGroupExpandListener {

	private MainActivity a;
	private int lastExpandedPosition = -1;

	public ExpandableGroupExpand(MainActivity b) {
		this.a = b;
	}

	@Override
	public void onGroupExpand(int groupPosition) {
		if (lastExpandedPosition != -1 && groupPosition != lastExpandedPosition) {
			this.a.mListView.collapseGroup(lastExpandedPosition);
		}
		lastExpandedPosition = groupPosition;
	}
}
