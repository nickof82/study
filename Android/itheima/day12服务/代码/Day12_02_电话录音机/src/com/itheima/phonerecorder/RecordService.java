package com.itheima.phonerecorder;

import java.io.IOException;

import android.app.Service;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

public class RecordService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		//创建一个电话管理器对象 通过这个对象可以监听电话的状态
		TelephonyManager manager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
		// PhoneStateListener 电话状态监听器
		MyPhoneStateListener listener = new MyPhoneStateListener();
		//调用电话管理器的listen方法 注册监听
		manager.listen(listener, PhoneStateListener.LISTEN_CALL_STATE);
	}

	private class MyPhoneStateListener extends PhoneStateListener {
		private MediaRecorder recorder;

		@Override
		public void onCallStateChanged(int state, String incomingNumber) {
			switch (state) {
			case TelephonyManager.CALL_STATE_IDLE:
				System.out.println("空闲状态"+"录音结束");
				if(recorder != null){
					//停止当前录音
					try {
						 recorder.stop();
						 //重置recorder
						 recorder.reset();   // You can reuse the object by going back to setAudioSource() step
						 recorder.release(); // Now the object cannot be reused
					} catch (Exception e) {
						// TODO: handle exception
					}
					
				}
			
				break;
			case TelephonyManager.CALL_STATE_RINGING:
				System.out.println("响铃"+incomingNumber+"准备一个录音机");
				recorder = new MediaRecorder();
				//设置音频的输入源 MIC 只能录自己的声音  voice_call 录双方的声音
				 recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
				 //设置音频输出的格式 3gp
				 recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
				 //设置音频编码 amr 早期彩屏彩铃手机上使用的音频格式 一般用作手机铃声 NB narrow Band 窄带 WB wide band
				 recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
				 //设置输入之后文件保存的路径
				 recorder.setOutputFile(getCacheDir()+"/"+incomingNumber+".3gp");
				 //录音机开始准备
				 try {
					recorder.prepare();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case TelephonyManager.CALL_STATE_OFFHOOK:
				System.out.println("接电话了"+incomingNumber+"开始录音");
				 recorder.start();   // Recording is now started
				break;

			}
		}
	}
}
