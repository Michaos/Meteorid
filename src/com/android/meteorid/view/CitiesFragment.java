package com.android.meteorid.view;

import com.android.meteorid.R;
import com.android.meteorid.adapter.ListCitiesAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class CitiesFragment extends Fragment{
	
	// ici c'est la liste des villes de l'acceuil ( tous & favoris )
	
	private static final String ARG_SECTION_NUMBER = "section_number";

	public static CitiesFragment newInstance(int sectionNumber) {
		CitiesFragment fragment = new CitiesFragment();
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		fragment.setArguments(args);
		return fragment;
	}
	
	public CitiesFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container,	false);
		
		// la je recupere dans quel catégorie on est ( tous == 1 , favoris == 2)
		getArguments().getInt(ARG_SECTION_NUMBER);
		
		ListView lv = (ListView) rootView.findViewById(R.id.listview);
		lv.setAdapter(new ListCitiesAdapter(getActivity()));
		
		return rootView;
	}
}
