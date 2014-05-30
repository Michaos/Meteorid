package com.android.meteorid.manager;

import android.content.Context;

public class DataManager {
	
	// ici on gere tout le traitement de donné ( recuperer les jsons)

	private static DataManager instance;
	private static Context mContext;
	
	private DataManager(){
	}

	public static DataManager getInstance(Context context){
		if(context != null){
			mContext = context;
		}
		if(instance == null){
			instance = new DataManager();
		}
		return instance;
	}
}