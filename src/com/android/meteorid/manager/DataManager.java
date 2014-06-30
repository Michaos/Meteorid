package com.android.meteorid.manager;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.android.meteorid.dao.City;
import com.android.meteorid.dao.Day;
import com.android.meteorid.utils.Utils;

public class DataManager {

	private static final String TAG = "DataManager";
	// ici on gÃ¨re tout le traitement de donnÃ©es ( Get jsons)

	private static DataManager instance;
	private static Context mContext;

	private DataManager() {
	}

	public static DataManager getInstance(Context context) {
		if (context != null) {
			mContext = context;
		}
		if (instance == null) {
			instance = new DataManager();
		}
		return instance;
	}

	// une fonction qui utilise Utils.execute pour lancer une class asynctask.
	public void launchTask() {
		Utils.execute(new getJson());
		Log.v(TAG, "launchTask()");
	}

	// une class asynctask que tu doit creer dans laquelle tu apelle APIMANAGER
	// pour recuperer le json
	private class getJson extends AsyncTask<Integer, Object, Boolean> {

		@Override
		protected Boolean doInBackground(Integer... params) {
			
			for (int i = 0; i < MappingManager.CITIES.length; i++) {
				String urlApi = FluxManager.URL_API.replace("__ID__", MappingManager.CITIES[i]);
				
				JSONObject jsonFlux = ApiManager.callAPI(urlApi);
				
				// check if json no null
				if(jsonFlux != null){
					try {
						
						JSONArray jsonArray = jsonFlux.getJSONArray("list");
						
						ArrayList<Day> dayList = new ArrayList<Day>();
						
						for (int j = 0; j < jsonArray.length(); j++) {
							dayList.add(new Day(jsonArray.getJSONObject(j)));
						}
						
						JSONObject jsonObject = jsonFlux.getJSONObject("city");
						City city = new City(jsonObject, dayList);
						
					} catch (JSONException e) {
						e.printStackTrace();
					}
					
				}
			}
			
			return false;
		}

	}
}
