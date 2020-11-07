package com.itheima.callremotemethod;

import com.itheima.remotemethod.IService;
import com.itheima.remotemethod.IService.Stub;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	private IService iService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent service = new Intent();
        //用隐式意图开启其他应用的service
        service.setAction("com.itheima.remoteservice");
        MyConnection conn = new MyConnection();
        //通过bindservice开启服务
		bindService(service, conn, BIND_AUTO_CREATE);
    }


   public void callremote(View v){
	   try {
		iService.callRemoteMethod();
	} catch (RemoteException e) {
		e.printStackTrace();
	}
   }
   
   private class MyConnection implements ServiceConnection{
	@Override
	public void onServiceConnected(ComponentName name, IBinder service) {
		iService = Stub.asInterface(service);
		
	}

	@Override
	public void onServiceDisconnected(ComponentName name) {
		// TODO Auto-generated method stub
		
	}
	   
   }
    
}
