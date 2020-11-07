package com.itheima.remotemethod;

import com.itheima.remotemethod.IService.Stub;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class RemoteService extends Service{

	@Override
	public IBinder onBind(Intent intent) {
		return new MyBinder();
	}
	public class MyBinder extends Stub{
		public void callRemoteMethod(){
			remoteMethod();
		}
	}

	public void remoteMethod(){
		System.out.println("remoteMethod is called");
	}
	
	
}
