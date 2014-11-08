package com.cyf.challengeyourfriends;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ChallengeFriend extends Activity implements OnItemClickListener{
	private ListView mLvMenu;
	private ArrayList<String> mStringMenuElems;
	private ArrayAdapter mMenuAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		mStringMenuElems = new ArrayList<String>();
		//
		//add code to parse friends list here
		//
		ListView mLvMenu = (ListView)findViewById(R.id.mainmenu_listview);
		mMenuAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStringMenuElems);
		mLvMenu.setAdapter(mMenuAdapter);
		mLvMenu.setOnItemClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.view_challenges, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		
	}
}