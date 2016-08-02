package com.hys.yipei.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.hys.yipei.adapter.FragmentTabAdapter;
import com.hys.yipei.ui.HomeFragment;
import com.hys.yipei.ui.TabCFm;
import com.wythe.mall.R;
import com.hys.yipei.ui.CategoryFragment;
import com.hys.yipei.ui.CartFragment;
import com.hys.yipei.ui.PersonalFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity {
	public static final String TAG = MainActivity.class.getSimpleName();
	private RadioGroup radio_button_group;
	private FragmentTabAdapter tabAdapter;
	public List<Fragment> fragments = new ArrayList<Fragment>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Fresco.initialize(getApplicationContext());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	protected void initView() {
		radio_button_group = (RadioGroup) findViewById(R.id.radio_button_group);
		fragments.add(new HomeFragment());
		fragments.add(new CategoryFragment());
		fragments.add(new TabCFm());
		fragments.add(new CartFragment());
		fragments.add(new PersonalFragment());
		tabAdapter = new FragmentTabAdapter(this, fragments, R.id.fragment_content, radio_button_group);
//		tabAdapter.onCheckedChanged(radio_button_group,R.id.navigation_tab_cart);
//		((RadioButton)radio_button_group.getChildAt(3)).setChecked(true);
	}

	public void navigateTo(int index){
		((RadioButton)radio_button_group.getChildAt(index)).setChecked(true);
	}


}
