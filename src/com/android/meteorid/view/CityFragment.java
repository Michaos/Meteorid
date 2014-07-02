package com.android.meteorid.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.meteorid.R;
import com.android.meteorid.dao.City;

public class CityFragment extends Fragment{
	
	// ce fragment est appeler par CityPagerActivity
	
	// affiche les infos de la ville das le header 
	// + un viewpager avec les temperatures < aujourdhui  -  semaine >
	// via fragment TemperaturesFragment
	
	private static City myCity;
	
	public static CityFragment newInstance(City city) {
		CityFragment fragment = new CityFragment();
		myCity = city;
		/*Bundle bundle = new Bundle();
		bundle.putSerializable("nav", naav);
		bundle.putSerializable("title", name);
		fragment.setArguments(bundle);*/
		return fragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_city, container, false);
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		System.out.println(myCity.getName());
		((TextView) view.findViewById(R.id.city)).setText(myCity.getName());
		//((TextView) view.findViewById(R.id.temp)).setText(myCity.getDayList().get(0).getTempDay());
		
		super.onViewCreated(view, savedInstanceState);
	}
}
