package com.android.meteorid.adapter;

import java.util.List;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class FragmentAdapter extends FragmentStatePagerAdapter{
    private List<Fragment> listFrag;

    public FragmentAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        listFrag = list;
    }

    @Override
    public Fragment getItem(int position) {
    	return listFrag.get(position);
    }

    @Override
    public int getCount() {
        return listFrag.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
      return listFrag.get(position).getArguments().getString("title");
    }
}