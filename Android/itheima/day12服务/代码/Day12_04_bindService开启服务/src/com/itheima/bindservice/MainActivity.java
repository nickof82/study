package com.itheima.bindservice;

import com.itheima.bindservice.BindService.MyBinder;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	private MyConnection conn;
	private MyBinder myBinder;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void start(View v) {
		Intent service = new Intent(this,BindService.class);
		conn = new MyConnection();
		//通过bind方式开启service
		//第一个参数 intent 
		//第二个参数   ServiceConnection 接口 通过这个接口可以接受服务开启或者停止的消息
		//第三个参数 开启服务时候 操作的选项 一般传入BIND_AUTO_CREATE 自动创建service
		bindService(service, conn, BIND_AUTO_CREATE);
	}

	public void stop(View v) {
		//使用bindService开启的服务要用Unbind来停止
		unbindService(conn);
	}
	
	public void callServiceMethod(View v){
//		BindService service = new BindService();
//		service.showToast("hello");
		myBinder.callShowToast("hello");
		myBinder.showToast2("hello hello");
	}

	private class MyConnection implements ServiceConnection{
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			//只有当 service的onbind方法返回值不为null 才会调用onServiceConnected
			System.out.println("onServiceConnected");
			myBinder = (MyBinder) service;
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			//当服务正常退出的时候不会调用onServiceDisconnected
			System.out.println("onServiceDisconnected");
		}
		
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		//把service关闭 解除跟当前activity的绑定
		unbindService(conn);
	}
}
