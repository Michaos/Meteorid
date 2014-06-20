package com.android.meteorid.manager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.android.meteorid.utils.Utils;

public class DataManager {

	private static final String TAG = "DataManager";
	// ici on gère tout le traitement de données ( Get jsons)

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
			String urlApi = FluxManager.URL_API.replace("__ID__", "2988507");
			
			JSONObject jsonFlux = ApiManager.callAPI(urlApi);
			
			// check if json no null
			if(jsonFlux != null){
				Log.v(TAG, "JSONLFUX : " + jsonFlux.toString());
			} else {
				Log.v(TAG, "Pas de JsonFlux");
			}
			
			try {
				JSONArray jsonArr = jsonFlux.getJSONArray("list");
				Log.v(TAG, "jsonArray: " + jsonArr);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				Log.v(TAG, "JSONParse EXCEPTION: " + e.getMessage());
				e.printStackTrace();
			}
			
			return false;
		}

	}
}