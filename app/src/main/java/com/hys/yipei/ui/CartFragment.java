package com.hys.yipei.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.hys.yipei.utils.GotoActivity;
import com.hys.yipei.utils.UserManager;
import com.wythe.mall.R;
import com.hys.yipei.activity.LoginActivity;

public class CartFragment extends Fragment implements View.OnClickListener{

    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_cart, container, false);
        view.findViewById(R.id.cart_login).setOnClickListener(this);
        ((TextView)view.findViewById(R.id.titleText)).setText(R.string.cart);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        //登录未登录界面切换
        if (UserManager.getInstance().isLogin()){
            view.findViewById(R.id.cart_for_not_login).setVisibility(View.GONE);
            view.findViewById(R.id.cart_for_login).setVisibility(View.VISIBLE);
        } else {
            view.findViewById(R.id.cart_for_not_login).setVisibility(View.VISIBLE);
            view.findViewById(R.id.cart_for_login).setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cart_login:{
                GotoActivity.gotoActiviy(this.getActivity(), LoginActivity.class);
                break;
            }
            case R.id.title_left_button:{
                Toast.makeText(getActivity(),"去哪儿？",Toast.LENGTH_LONG).show();
                break;
            }
        }
    }
}
