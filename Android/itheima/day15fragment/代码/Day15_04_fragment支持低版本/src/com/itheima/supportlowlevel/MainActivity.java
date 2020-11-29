package com.itheima.supportlowlevel;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class MainActivity extends FragmentActivity {
	//要动态加载v4包中的fragment 必须继承FragmentActivity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取fragmentManager
//        FragmentManager fragmentManager = getFragmentManager();
        //FragmentManager 也要使用v4包中的  v4包中 获取 FragmentManager 要用 getSupportFragmentManager
        // getSupportFragmentManager这个方法 实在v4包的 FragmentActivity中才可以使用
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        //开始fragment事务
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        //替换fragment
        transaction.replace(R.id.fragment_container, new DemoFragment());
        //提交事务
        transaction.commit();
    }
}
