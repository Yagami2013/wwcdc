package com.yagami.wwcdc;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;

public class TweenActivity extends Activity {
	private View mStartView;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mStartView=new StartView(this);
		//mStartView.setBackgroundResource(R.drawable.test_backgroud);
		setContentView(mStartView);
	}
	public boolean onKeyUp(int keyCode,KeyEvent event) {
		if (mStartView==null) {
			return false;
		}
		mStartView.onKeyUp(keyCode, event);
		return true;
	}
	public boolean onKeyDown(int keyCode,KeyEvent event) {
		if (mStartView==null) {
			return false;
		}
		if (keyCode==KeyEvent.KEYCODE_BACK) {
			this.finish();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
	public void onWindowFocusChanged(boolean hasFocus) {
		
		super.onWindowFocusChanged(hasFocus);
		mStartView.onKeyUp(KeyEvent.KEYCODE_0, null);
	}
	public class StartView extends View{
		
		private Animation mAnimationAlpha=null;
		private Animation mAnimationScale=null;
		private Animation mAnimationTranslate=null;
		private Animation mAnimationRotate=null;
		private AnimationSet as=null;
		Bitmap mBitmap=null;

		public StartView(Context context) {
			super(context);
			
			mBitmap=((BitmapDrawable)getResources().getDrawable(R.drawable.icon)).getBitmap();
			
			mAnimationAlpha=AnimationUtils.loadAnimation(TweenActivity.this, R.anim.alpha_animation);
			mAnimationAlpha.setDuration(1000*4);
			
			mAnimationScale=AnimationUtils.loadAnimation(TweenActivity.this, R.anim.scale_animation);
			mAnimationScale.setDuration(1000*6);
			
			mAnimationTranslate=AnimationUtils.loadAnimation(TweenActivity.this, R.anim.translate_animation);
			mAnimationTranslate.setDuration(1000*6);
			
			mAnimationRotate=AnimationUtils.loadAnimation(TweenActivity.this, R.anim.rotate_animation);
			mAnimationRotate.setDuration(1000*4);
			
			as=(AnimationSet) AnimationUtils.loadAnimation(TweenActivity.this, R.anim.com);

		}
		public void onDraw(Canvas canvas) {
			super.onDraw(canvas);
			canvas.drawBitmap(mBitmap, 0, 0,null);
		}
		public boolean onKeyUp(int keyCode,KeyEvent event) {
			/*switch (keyCode) {
			case KeyEvent.KEYCODE_DPAD_UP:
				this.startAnimation(mAnimationScale);
				break;

			case KeyEvent.KEYCODE_DPAD_DOWN:
				this.startAnimation(mAnimationTranslate);
				break;
				
			case KeyEvent.KEYCODE_DPAD_LEFT:
				this.startAnimation(mAnimationAlpha);
				break;
				
			case KeyEvent.KEYCODE_DPAD_RIGHT:
				this.startAnimation(mAnimationRotate);
				break;
			
			case KeyEvent.KEYCODE_DPAD_CENTER:
				this.startAnimation(as);
				break;
			}*/
			this.startAnimation(as);
			//this.startAnimation(mAnimationTranslate);
			//this.startAnimation(mAnimationScale);
			return true;
		}
	}

}
