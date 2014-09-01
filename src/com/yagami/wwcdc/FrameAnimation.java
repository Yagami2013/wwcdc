package com.yagami.wwcdc;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class FrameAnimation extends Activity {
	private FrameView startView;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		startView=new FrameView(this);
		setContentView(startView);
	}
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		startView.frameAnimation.start();
	}
	public boolean onKeyDown(int keyCode,KeyEvent event){
		if (startView==null) {
			return false;
		}
		if (keyCode==KeyEvent.KEYCODE_BACK) {
			this.finish();
			return true;
		}
		return super.onKeyDown(keyCode, event);
		
		
	}
	public class FrameView extends View{
		private AnimationDrawable frameAnimation=null;
		Context mContext=null;

		public FrameView(Context context) {
			super(context);
			mContext=context;
			
			ImageView img=new ImageView(mContext);
			img.setBackgroundResource(R.anim.frame);
			frameAnimation=(AnimationDrawable)img.getBackground();
			this.setBackground(frameAnimation);
		}
		public boolean onTouchEvent(MotionEvent event) {
			if (event.getPointerCount()==1) {
				frameAnimation.start();
			}else if (event.getPointerCount()==2) {
				frameAnimation.stop();
			}
			return true;
			
			
		}
		
	}
	

}
