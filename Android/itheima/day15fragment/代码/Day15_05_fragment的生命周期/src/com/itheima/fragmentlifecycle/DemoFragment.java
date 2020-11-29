package com.itheima.fragmentlifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DemoFragment extends Fragment {
	@Override
	public void onAttach(Activity activity) {
		//当fragment 开始显示到activity上的时候(跟activity建立联系) 就会走这个方法
		System.out.println("onAttach");
		super.onAttach(activity);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		//当fragmetn创建的时候 走这个方法 可以在这里做数据初始化的操作
		System.out.println("onCreate");
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		System.out.println("onCreateView");
		View view = inflater.inflate(R.layout.fragment_demo, null);
		return view;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		System.out.println("onActivityCreated");
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onStart() {
		System.out.println("onStart");
		super.onStart();
	}
	
	@Override
	public void onResume() {
		System.out.println("onResume");
		super.onResume();
	}
	
	@Override
	public void onPause() {
		//走了这方法 fragment就看不到了  可以在这个方法中保寸需要显示的数据
		System.out.println("onPause");
		super.onPause();
	}
	
	@Override
	public void onStop() {
		System.out.println("onStop");
		super.onStop();
	}
	
	@Override
	public void onDestroyView() {
		System.out.println("onDestroyView");
		super.onDestroyView();
	}
	@Override
	public void onDestroy() {
		System.out.println("onDestroy");
		super.onDestroy();
	}
	
	@Override
	public void onDetach() {
		System.out.println("onDetach");
		super.onDetach();
	}
}
