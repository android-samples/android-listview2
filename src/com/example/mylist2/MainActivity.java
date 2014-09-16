package com.example.mylist2;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {
	ListView mListView;
	ArrayList<HashMap<String, String>> mData = new ArrayList<HashMap<String, String>>();
	SimpleAdapter mAdapter;
	int mCount = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// ListView
		mListView = (ListView)findViewById(R.id.listView1);
		
		// データ準備
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("VALUE1", "ABC");
		map.put("VALUE2", "DEF");
		mData.add(map);
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("VALUE1", "XXX");
		map2.put("VALUE2", "YYY");
		mData.add(map2);

		// アダプタ
		mAdapter = new SimpleAdapter(
				this,
				mData,
				android.R.layout.simple_list_item_2,
				new String[]{"VALUE1", "VALUE2"},
				new int[]{android.R.id.text1, android.R.id.text2}
		);
		mListView.setAdapter(mAdapter);
	}
	
	public void buttonMethodAdd(View button){
		mCount++;
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("VALUE1", "VVV" + mCount / 10);
		map2.put("VALUE2", "WWW" + mCount % 10);
		mData.add(map2);
		mAdapter.notifyDataSetChanged();
	}
	
	public void buttonMethodRemove(View button){
		if(mData.size() == 0)return;
		mData.remove(mData.size() - 1);
		mAdapter.notifyDataSetChanged();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
