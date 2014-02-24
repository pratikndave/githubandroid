package com.example.ilpapp;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ilpapp.beans.DailySchedule;

public class DailyScheduleAdapter extends ArrayAdapter<DailySchedule> {

	ArrayList<DailySchedule> objects;
	
	public DailyScheduleAdapter(Context context, int resource,
			ArrayList<DailySchedule> objects) {
		
		super(context, resource, objects);
		this.objects = objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View scheduleView = convertView;
		
		if (scheduleView == null) {
			LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			scheduleView = inflater.inflate(R.layout.activity_sample_schedule, null);
		}
		
		DailySchedule dailySchedule = objects.get(position);
		
		if(dailySchedule != null)
		{
			TextView scheduleDate = (TextView)scheduleView.findViewById(R.id.tvScheduleDate);
			TextView slotA = (TextView)scheduleView.findViewById(R.id.tvSlotA);
			TextView slotB = (TextView)scheduleView.findViewById(R.id.tvSlotB);
			TextView slotC = (TextView)scheduleView.findViewById(R.id.tvSlotC);
			TextView slotD = (TextView)scheduleView.findViewById(R.id.tvSlotD);
			
			scheduleDate.setText(dailySchedule.getDate()+"");
			slotA.setText(dailySchedule.getSlotA().getSessionName());
			slotB.setText(dailySchedule.getSlotB().getSessionName());
			slotC.setText(dailySchedule.getSlotC().getSessionName());
			slotD.setText(dailySchedule.getSlotD().getSessionName());
			
		}
		
		return scheduleView;
	}
	
	

}
