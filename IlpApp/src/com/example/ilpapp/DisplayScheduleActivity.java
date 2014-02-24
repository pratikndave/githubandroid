package com.example.ilpapp;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;

import com.ilpapp.beans.DailySchedule;

public class DisplayScheduleActivity extends ListActivity {
	
	private ArrayList<DailySchedule> scheduleValues = new ArrayList<DailySchedule>();
	private DailyScheduleAdapter scheduleAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		Bundle extras = getIntent().getExtras();
		
		if(extras != null)
		{
			DailySchedule dailySchedule = (DailySchedule)extras.get("schedule");
			scheduleValues.add(dailySchedule);
			
		}
		
		
		setContentView(R.layout.list_schedule);
		
		scheduleAdapter = new DailyScheduleAdapter(this, R.layout.list_schedule, scheduleValues);

		setListAdapter(scheduleAdapter);
		
	}
	
	
	/*@Override
	public void finish() {
		// TODO Auto-generated method stub
		super.finish();
		
		Intent intent = new Intent();
		intent.putExtra("returnString", "I am giving data from subactivity to activity");
		
		setResult(RESULT_OK, intent);
	}*/

}
