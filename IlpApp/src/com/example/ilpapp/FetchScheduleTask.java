package com.example.ilpapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;
import android.widget.Toast;

public class FetchScheduleTask extends AsyncTask<String, Void, Void>{
	
	
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
	}
	
	@Override
	protected Void doInBackground(String... params) {

		/*
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet("http://192.168.1.10:8080/BookMansApp/CustomerServlet?facName=Pratik");
		//HttpGet httpget = new HttpGet("https://www.google.co.in/#q=nokia+lumia");
		try {
		    HttpResponse response = httpClient.execute(httpget);
		    if(response != null) {
		        String line = "";
		        InputStream inputstream = response.getEntity().getContent();
		        line = convertStreamToString(inputstream);
		        Toast.makeText(R.IlpAppHome.class, line, Toast.LENGTH_SHORT).show();
		    } else {
		        Toast.makeText(IlpAppHome.this, "Unable to complete your request", Toast.LENGTH_LONG).show();
		    }
		} catch (ClientProtocolException e) {
		    Toast.makeText(IlpAppHome.this, "Caught ClientProtocolException", Toast.LENGTH_SHORT).show();
		} catch (IOException e) {
		    Toast.makeText(IlpAppHome.this, "Caught IOException", Toast.LENGTH_SHORT).show();
		} catch (Exception e) {
			e.printStackTrace();
		    Toast.makeText(IlpAppHome.this, e.getClass().getName(), Toast.LENGTH_SHORT).show();
		}*/
		return null;
	}
	
	
	private String convertStreamToString(InputStream is) {
	    String line = "";
	    StringBuilder total = new StringBuilder();
	    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
	    try {
	        while ((line = rd.readLine()) != null) {
	            total.append(line);
	        }
	    } catch (Exception e) {
	        //Toast.makeText(this, "Stream Exception", Toast.LENGTH_SHORT).show();
	    }
	    return total.toString();
	}
	
	@Override
	protected void onPostExecute(Void result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
	}

}
