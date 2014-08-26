package com.yagami.wwcdc;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.widget.FrameLayout;

public class MainActivity extends Activity {
	FrameLayout frame=null;
	private boolean flag=true;
	
	class MyHandler extends Handler{
		int i=0;
		public void handleMessage(Message msg) {
			
			show(i);
			i++;
			sleep(1000);
			
		}
		public void sleep(long delayMillis) {
			if (flag) {
				sendMessageDelayed(obtainMessage(0),delayMillis);
			}
		}
	}
	void show(int j){
		Drawable a=getResources().getDrawable(R.drawable.icon);
		Drawable b=getResources().getDrawable(R.drawable.start2);
		Drawable c=getResources().getDrawable(R.drawable.start3);
		switch (j) {
		case 0:
			frame.setForeground(a);
			break;
		case 1:
			frame.setForeground(b);
			break;
		case 2:
			frame.setForeground(c);
			break;
		default:
			break;
		}

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		frame=(FrameLayout)findViewById(R.id.mFrame);
		
		final MyHandler myHandler=new MyHandler();
		myHandler.sleep(100);

		
	}

}
