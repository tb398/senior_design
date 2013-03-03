package com.example.seniordesignapp;

import java.util.ArrayList;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.ToggleButton;

public class HomePageActivity extends Fragment{
	
	ExpandableListView lv;
	ToggleButton tButton;
    
    	class MyExpandableListAdapter extends BaseExpandableListAdapter {

        
    	private String[] groups =  setGroupData();
    	private String[][] children = setChildGroupData();
    	
    	
      public String[] setGroupData() {//WIP - Hard Code for Now..
    	  	ArrayList<String> groupItem = new ArrayList<String>();
	  		  groupItem.add("10:00 Ran for 30 minutes");
		  	  groupItem.add("11:35 Ate 1 Hamburger");
		  	  groupItem.add("4:00 Biked for 20 minutes");
		  	  groupItem.add("5:21 Climed 2 flights of stairs");
		  	  
			  String[] stockArr = new String[groupItem.size()];
			  stockArr = groupItem.toArray(stockArr);
			  
		  	  return stockArr;
  	         }
  
	  public String[][] setChildGroupData() { //WIP - hard coding
//	  	  /**
//	  	   * Add Data For activity1
//	  	   */
//		  ArrayList<Object> childItem = new ArrayList<Object>();
//	  	  ArrayList<String> child = new ArrayList<String>();
//	  	  child.add("Accelerometer Data");
//	  	  child.add("9:30 - 10:00");
//	  	  childItem.add(child);
//	
//	  	  /**
//	  	   * Add Data For activity2
//	  	   */
//	  	  child = new ArrayList<String>();
//	  	  child.add("Manual Input Data");
//	  	  child.add("11:35");
//	  	  childItem.add(child);
//	  	  /**
//	  	   * Add Data For activity3
//	  	   */
//	  	  child = new ArrayList<String>();
//	  	  child.add("Accelerometer Data");
//	  	  child.add("3:40 - 4:00");
//	  	  childItem.add(child);
//	  	  /**
//	  	   * Add Data For activity4
//	  	   */
//	  	  child = new ArrayList<String>();
//	  	  child.add("Accelerometer Data");
//	  	  child.add("5:20 - 5:21");
//	  	  childItem.add(child);
//	  	  
	  	  String[][] childItem ={
	  			  {"Accelerometer Data","9:30 - 10:00"},
	  			  {"Voice Input Data","11:35"},
	  			  {"Accelerometer Data","3:40 - 4:00"},
	  			  {"Accelerometer Data","5:20 - 5:21"}
	  	  };
	  	  return childItem;
	  	 }
        
        
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.activity_home_page, menu);
//        return true;
//    }

    public Object getChild(int groupPosition, int childPosition) {
        return children[groupPosition][childPosition];
    }

    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    public int getChildrenCount(int groupPosition) {
        return children[groupPosition].length;
    }

    public TextView getGenericView() {
        // Layout parameters for the ExpandableListView
        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 64);

        TextView textView = new TextView(HomePageActivity.this.getActivity());
        textView.setLayoutParams(lp);
        // Center the text vertically
        textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
        // Set the text starting position
        textView.setPadding(36, 0, 0, 0);
        return textView;
    }



    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, 
            View convertView, ViewGroup parent) {
   	 View childView = convertView;
     if (childView == null) {
         LayoutInflater vi = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         childView = vi.inflate(R.layout.childrow, null);
     }
             TextView childText = (TextView) childView.findViewById(R.id.child_name);
             if (childText != null) {
            	 childText.setText(getChild(groupPosition,childPosition).toString());                     
             }

    return childText;

    }

    public Object getGroup(int groupPosition) {
        return groups[groupPosition];
    }

    public int getGroupCount() {
        return groups.length;
    }

    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
    	 View parentView = convertView;
         if (parentView == null) {
             LayoutInflater vi = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
             parentView = vi.inflate(R.layout.grouprow, null);
         }
                 TextView parentText = (TextView) parentView.findViewById(R.id.group_name);
                 if (parentText != null) {
                       parentText.setText(getGroup(groupPosition).toString());                     
                 }

        return parentText;

    }

    public boolean hasStableIds() {
        return true;
    }

    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
    
    
    }
    	public View onCreateView(LayoutInflater inflater, ViewGroup container,
    			Bundle savedInstanceState) {
    		if (container == null) {
                // We have different layouts, and in one of them this
                // fragment's containing frame doesn't exist.  The fragment
                // may still be created from its saved state, but there is
                // no reason to try to create its view hierarchy because it
                // won't be displayed.  Note this is not needed -- we could
                // just run the code below, where we would create and return
                // the view hierarchy; it would just never be used.
                return null;
            }
    		LinearLayout mlinearLayout = (LinearLayout)inflater.inflate(R.layout.activity_home_page, container, false);
    	
    		tButton = (ToggleButton) mlinearLayout.findViewById(R.id.toggleButton1);
            
            tButton.setOnCheckedChangeListener(new OnCheckedChangeListener() {
    
            	   @Override
            	   public void onCheckedChanged(CompoundButton buttonView,
            	     boolean isChecked) {
            	    
//            	    if(isChecked){
//            	     tvStateofToggleButton.setText("ON");
//            	    }else{
//            	     tvStateofToggleButton.setText("OFF");
//            	    }
    
            	   }
            	  });
            
            lv = (ExpandableListView) mlinearLayout.findViewById(R.id.log_list);
            MyExpandableListAdapter expandableAdapter = new MyExpandableListAdapter();
            lv.setAdapter(expandableAdapter);
    		return mlinearLayout;
   }
}