package com.itheima.fragmentcommunication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class LeftFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_left, null);
		Button btn_call = (Button) view.findViewById(R.id.btn_call);
		btn_call.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//①获取activity  getActivity
				//② 通过activity 获取fragmentManager
				//③ 通过fragmentManager 调用 findFragmentByTag方法 找到对应的fragment对象
				System.out.println("hello");
				RightFragment right = (RightFragment) getActivity().getFragmentManager().findFragmentByTag("right");
				//RightFragment rightFragment = new RightFragment();
				right.changeText("hello");
			}
		});
		return view;
	}

//	public void change(View v){
//		System.out.println("hello");
//	}
}
