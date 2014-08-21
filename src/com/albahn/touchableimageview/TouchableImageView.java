package com.albahn.touchableimageview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

public class TouchableImageView extends ImageView {

	private ColorFilter filter = new LightingColorFilter(Color.GRAY, 0);

	public TouchableImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public TouchableImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public TouchableImageView(Context context) {
		super(context);
	}
	
	public void setOverlayColorFilter(ColorFilter filter) {
		this.filter = filter;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			
			if (this.isClickable()) {
				this.setColorFilter(filter);
			}
			break;

		case MotionEvent.ACTION_UP:
		case MotionEvent.ACTION_CANCEL:
			this.clearColorFilter(); 
			break;
		}
		
		return super.onTouchEvent(event);
	}

}
