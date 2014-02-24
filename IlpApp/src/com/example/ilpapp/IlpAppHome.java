package com.example.ilpapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ilpapp.beans.DailySchedule;
import com.ilpapp.beans.Slot;

public class IlpAppHome extends Activity {

	TextView tvDisplay; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ilp_app_home);

		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();
		StrictMode.setThreadPolicy(policy);

		tvDisplay = (TextView)findViewById(R.id.tvDisplay);
		Button bAdd = (Button) findViewById(R.id.bAddEvent);

		bAdd.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				/*
				 * Intent calendarIntent = new Intent(Intent.ACTION_INSERT);
				 * calendarIntent.setType("vnd.android.cursor.item/event");
				 * calendarIntent.putExtra(Events.TITLE, "TCOC");
				 * calendarIntent.putExtra(Events.EVENT_LOCATION, "ODC33A");
				 * calendarIntent.putExtra(Events.DESCRIPTION,
				 * "Tata Code of Conduct");
				 * calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY,
				 * true);
				 * 
				 * GregorianCalendar calendar = new
				 * GregorianCalendar(2014,02,11);
				 * 
				 * startActivity(calendarIntent);
				 */
				
				DailySchedule dailySchedule = new DailySchedule();
				dailySchedule.setDate(new Date());
				
				Slot slotA = new Slot("TCOC","Pratik Dave", "ODC 33A");
				Slot slotB = new Slot("Exception Handling - Custom Exception","Sunny Joshi", "LR 3E");
				Slot slotC = new Slot("WS - Email Etiquettes","Ameesh Dave", "ODC 33A");
				Slot slotD = new Slot("ISU 1 - Customer Centricity","Pratik Dave", "Auditorium");
				
				dailySchedule.setSlotA(slotA);
				dailySchedule.setSlotB(slotB);
				dailySchedule.setSlotC(slotC);
				dailySchedule.setSlotD(slotD);

				Intent sampleSchedule = new Intent(getApplication(),
						DisplayScheduleActivity.class);
				
				sampleSchedule.putExtra("schedule", dailySchedule);
				startActivity(sampleSchedule);
				
				//startActivityForResult(sampleSchedule, 1);
				//new GetFacultySchedule().execute();

			}

		});

		
	}
	
	/*@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		Bundle dataFromSubActivity = data.getExtras();
		
		String returnString = dataFromSubActivity.getString("returnString");
	}*/
	

	private class GetFacultySchedule extends AsyncTask<Void, Void, String> {
		
		@Override
		protected String doInBackground(Void... params) {
			// TODO Auto-generated method stub
			
			String jsonDailyScheduleResponse = null;
			HttpClient httpClient = new DefaultHttpClient();
			HttpGet httpget = new HttpGet(
					"http://192.168.1.10:8080/BookMansApp/CustomerServlet?facName=Pratik");
			// HttpGet httpget = new
			// HttpGet("https://www.google.co.in/#q=nokia+lumia");
			try {
				HttpResponse response = httpClient.execute(httpget);
				if (response != null) {
					
					String line = "";
					InputStream inputstream = response.getEntity().getContent();

					StringBuilder total = new StringBuilder();
					BufferedReader rd = new BufferedReader(
							new InputStreamReader(inputstream));
					
					while ((line = rd.readLine()) != null)
						total.append(line);
					
					jsonDailyScheduleResponse = total.toString();
					
					
					
					

					//Toast.makeText(IlpAppHome.this, line, Toast.LENGTH_SHORT)
						//	.show();
				} else {
					Toast.makeText(IlpAppHome.this,
							"Unable to complete your request",
							Toast.LENGTH_LONG).show();
				}
			} catch (ClientProtocolException e) {
				Toast.makeText(IlpAppHome.this,
						"Caught ClientProtocolException", Toast.LENGTH_SHORT)
						.show();
			} catch (IOException e) {
				Toast.makeText(IlpAppHome.this, "Caught IOException",
						Toast.LENGTH_SHORT).show();
			} catch (Exception e) {
				e.printStackTrace();
				Toast.makeText(IlpAppHome.this, e.getClass().getName(),
						Toast.LENGTH_SHORT).show();
			}

			return jsonDailyScheduleResponse;
		}
		
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			
			try {
				JSONObject jsonObject = new JSONObject(result);
				String scheduleDate = jsonObject.getString("date");
				
				JSONObject slotA = jsonObject.getJSONObject("slotA");
				String slotASession = slotA.getString("sessionName");
				String slotAFaculty = slotA.getString("allocatedFaculty");
				String slotARoom = slotA.getString("allocatedRoom");
				
				JSONObject slotB = jsonObject.getJSONObject("slotB");
				String slotBSession = slotB.getString("sessionName");
				String slotBFaculty = slotB.getString("allocatedFaculty");
				String slotBRoom = slotB.getString("allocatedRoom");
				
				JSONObject slotC = jsonObject.getJSONObject("slotC");
				String slotCSession = slotC.getString("sessionName");
				String slotCFaculty = slotC.getString("allocatedFaculty");
				String slotCRoom = slotC.getString("allocatedRoom");
				
				JSONObject slotD = jsonObject.getJSONObject("slotD");
				String slotDSession = slotD.getString("sessionName");
				String slotDFaculty = slotD.getString("allocatedFaculty");
				String slotDRoom = slotD.getString("allocatedRoom");
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			tvDisplay.setText(result);
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ilp_app_home, menu);
		return true;
	}

}
