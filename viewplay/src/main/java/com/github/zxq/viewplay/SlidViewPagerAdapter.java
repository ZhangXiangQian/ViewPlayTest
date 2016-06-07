package com.github.zxq.viewplay;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

public class SlidViewPagerAdapter extends PagerAdapter {
	private Context mContext;
	/** The m list views. */
	private ArrayList<View> mListViews = null;
	/** The m views. */
	private HashMap<Integer, View> mViews = null;

	public SlidViewPagerAdapter(Context context, ArrayList<View> mListViews) {
		this.mContext = context;
		this.mListViews = mListViews;
		this.mViews = new HashMap<Integer, View>();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mListViews.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == (arg1);
	}

	@Override
	public Object instantiateItem(View container, int position) {
		// TODO Auto-generated method stub
		View v = mListViews.get(position);
		((ViewPager) container).addView(v);
		return v;
	}

	/**
	 * 移除View.
	 * 
	 */
	@Override
	public void destroyItem(View container, int position, Object object) {
		((ViewPager) container).removeView((View) object);
	}

	/**
	 * 很重要，否则不能notifyDataSetChanged.
	 * 
	 */
	@Override
	public int getItemPosition(Object object) {
		return POSITION_NONE;
	}
}
