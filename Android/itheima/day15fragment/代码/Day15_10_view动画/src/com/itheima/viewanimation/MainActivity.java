package com.itheima.viewanimation;

import javax.crypto.spec.IvParameterSpec;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ImageView iv_image;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iv_image = (ImageView) findViewById(R.id.iv_image);
		iv_image.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "点不到我", Toast.LENGTH_SHORT).show();
				
			}
		});
	}

	public void alpha(View v) {
		//AlphaAnimation 透明度动画
		//构造传入两个参数  第一个参数 动画开始时的透明度
		//第二个参数 动画结束时的透明度   1.0完全不透明  0.0 透明
//		AlphaAnimation animation = new AlphaAnimation(1.0f, 0.0f);
//		//设置动画执行的时间
//		animation.setDuration(2000);
//		//设置重复的模式  Animation.REVERSE 反向执行
//		//Animation.RESTART 重复来一次
//		animation.setRepeatMode(Animation.REVERSE);
//		//设置重复的次数 如果重复次数为0 那么 只会执行一次动画, 如果重复次数>0 setRepeatMode才会有效
//		animation.setRepeatCount(0);
//		//设置动画执行之后 执行动画的控件 停留在结束的状态上
//		//默认是false也就是 执行完了恢复到初始状态
//		animation.setFillAfter(true);
		//AnimationUtils 通过这个类来加载xml方式定义的动画
		Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
		//把当前动画设置到imageview上
		iv_image.setAnimation(animation);
		//让动画执行起来
		animation.start();
	}

	public void rotate(View v) {
		//第一个参数 动画开始的时候 处于的角度
		//第二个参数 动画结束时的角度
		RotateAnimation animation = new RotateAnimation(0, 360);
		float fromDegrees = 0;
		float toDegrees = 360;
		//旋转中心点x坐标的类型 可以是 Animation.RELATIVE_TO_PARENT
		//Animation.RELATIVE_TO_SELF 相对于自己
		//Animation.Animation.ABSOLUTE
		int pivotXType = Animation.RELATIVE_TO_PARENT;
		//旋转中心点x坐标的值 如果是相对自己 或者相对父容器 可以是一个小数 1.0代表100%
		
		float pivotXValue = 0.5f;
		//旋转中心点Y坐标的类型
		int pivotYType = Animation.RELATIVE_TO_PARENT; //相对父容器
		//旋转中心点y坐标的值
		float pivotYValue = 0.5f;
		animation = new RotateAnimation(fromDegrees, toDegrees, pivotXType, pivotXValue, pivotYType, pivotYValue);
		//设置执行的市场
		animation.setDuration(1000);
		//设置重复模式
		animation.setRepeatMode(Animation.RESTART);
		//设置重复次数
		animation.setRepeatCount(1);
		//设置停留到结束状态
		animation.setFillAfter(true);
		animation = (RotateAnimation) AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
		iv_image.setAnimation(animation);
		animation.start();
	}

	public void scale(View v) {
		ScaleAnimation animation = new ScaleAnimation(1, 2, 1, 2);
		int pivotXType = Animation.RELATIVE_TO_SELF;
		float pivotXValue = 0.5f;
		int pivotYType = Animation.RELATIVE_TO_SELF;
		float pivotYValue = 0.5f;
		animation = new ScaleAnimation(1, 2, 1, 2, pivotXType, pivotXValue, pivotYType, pivotYValue);
		animation.setDuration(1000);
		animation.setRepeatCount(1);
		animation.setRepeatMode(Animation.REVERSE);
		animation.setFillAfter(true);
		animation = (ScaleAnimation) AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);
		iv_image.setAnimation(animation);
		animation.start();
	}

	public void translate(View v) {
		TranslateAnimation animation = new TranslateAnimation(10, 100, 10, 100);
		//起始x坐标的类型
		int fromXType = Animation.RELATIVE_TO_PARENT;
		//起始x坐标的值
		float fromXValue = -0.5f;
		//结束点X坐标的类型
		int toXType = Animation.RELATIVE_TO_PARENT;
		//结束点X坐标的值
		float toXValue = 0.5f;
		//起始y坐标的类型
		int fromYType = Animation.RELATIVE_TO_PARENT;
		//起始y坐标的值
		float fromYValue = -0.5f;
		//结束Y坐标的类型
		int toYType = Animation.RELATIVE_TO_PARENT;
		//结束Y坐标的值
		float toYValue  = 0.5f;
		animation = new TranslateAnimation(fromXType, fromXValue, toXType, toXValue, fromYType, fromYValue, toYType, toYValue);
		animation.setDuration(3000);
		animation.setRepeatMode(Animation.RESTART);
		animation.setRepeatCount(1);
		animation.setFillAfter(true);
		//设置一个动画插入器 通过这个动画插入器 可以在执行的过程中加入 加速 减速 重复这样的效果
		//接受参数 Interpolator动画插入器  可以去找系统已经实现好的对象
		animation.setInterpolator(new BounceInterpolator());
		animation = (TranslateAnimation) AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate);
		iv_image.setAnimation(animation);
		animation.start();

	}

	public void set(View v) {
		//动画集合
		AnimationSet animSet = new AnimationSet(false);
		
		AlphaAnimation animation = new AlphaAnimation(1.0f, 0.5f);
		//设置动画执行的时间
		animation.setDuration(2000);
		//设置重复的模式  Animation.REVERSE 反向执行
		//Animation.RESTART 重复来一次
		animation.setRepeatMode(Animation.REVERSE);
		//设置重复的次数 如果重复次数为0 那么 只会执行一次动画, 如果重复次数>0 setRepeatMode才会有效
		animation.setRepeatCount(0);
		//设置动画执行之后 执行动画的控件 停留在结束的状态上
		//默认是false也就是 执行完了恢复到初始状态
		animation.setFillAfter(true);
		animSet.addAnimation(animation);
		
		
		float fromDegrees = 0;
		float toDegrees = 360;
		//旋转中心点x坐标的类型 可以是 Animation.RELATIVE_TO_PARENT
		//Animation.RELATIVE_TO_SELF 相对于自己
		//Animation.Animation.ABSOLUTE
		int pivotXType = Animation.RELATIVE_TO_PARENT;
		//旋转中心点x坐标的值 如果是相对自己 或者相对父容器 可以是一个小数 1.0代表100%
		
		float pivotXValue = 0.5f;
		//旋转中心点Y坐标的类型
		int pivotYType = Animation.RELATIVE_TO_PARENT; //相对父容器
		//旋转中心点y坐标的值
		float pivotYValue = 0.5f;
		RotateAnimation ra= new RotateAnimation(fromDegrees, toDegrees, pivotXType, pivotXValue, pivotYType, pivotYValue);
		//设置执行的市场
		ra.setDuration(1000);
		//设置重复模式
		ra.setRepeatMode(Animation.RESTART);
		//设置重复次数
		ra.setRepeatCount(1);
		//设置停留到结束状态
		ra.setFillAfter(true);
		
		animSet.addAnimation(ra);
		
		
		ScaleAnimation sa = new ScaleAnimation(1, 2, 1, 2);
		sa.setDuration(1000);
		sa.setRepeatCount(1);
		sa.setRepeatMode(Animation.REVERSE);
		sa.setFillAfter(true);
		
		animSet.addAnimation(sa);
		
		
		TranslateAnimation ta = new TranslateAnimation(10, 100, 10, 100);
		//起始x坐标的类型
		int fromXType = Animation.RELATIVE_TO_PARENT;
		//起始x坐标的值
		float fromXValue = -0.5f;
		//结束点X坐标的类型
		int toXType = Animation.RELATIVE_TO_PARENT;
		//结束点X坐标的值
		float toXValue = 0.5f;
		//起始y坐标的类型
		int fromYType = Animation.RELATIVE_TO_PARENT;
		//起始y坐标的值
		float fromYValue = -0.5f;
		//结束Y坐标的类型
		int toYType = Animation.RELATIVE_TO_PARENT;
		//结束Y坐标的值
		float toYValue  = 0.5f;
		ta = new TranslateAnimation(fromXType, fromXValue, toXType, toXValue, fromYType, fromYValue, toYType, toYValue);
		ta.setDuration(3000);
		ta.setRepeatMode(Animation.RESTART);
		ta.setRepeatCount(1);
		ta.setFillAfter(true);
		//设置一个动画插入器 通过这个动画插入器 可以在执行的过程中加入 加速 减速 重复这样的效果
		//接受参数 Interpolator动画插入器  可以去找系统已经实现好的对象
		ta.setInterpolator(new BounceInterpolator());
		
		animSet.addAnimation(ta);
		animSet = (AnimationSet) AnimationUtils.loadAnimation(getApplicationContext(), R.anim.set);
		iv_image.setAnimation(animSet);
		animSet.start();
	}

}
