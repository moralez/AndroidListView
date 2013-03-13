package com.brg.androidlistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CheckableRelativeLayout extends RelativeLayout implements Checkable {

	public ImageView leftImage;
	public TextView	textView;
	
	public CheckableRelativeLayout(Context context) {
		super(context);
	}
	
	public CheckableRelativeLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	public CheckableRelativeLayout(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
	}

	private boolean checked = false;

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        
        this.setFocusable(false);
    }
    
    @Override
    public boolean isChecked() {
        return checked;
    }

    @Override
    public void setChecked(boolean checked) {
        this.checked = checked;
        
        leftImage = (ImageView)findViewById(R.id.imageView1);
        
        if (checked) {
        	leftImage.setVisibility(View.VISIBLE);
		} else {
			leftImage.setVisibility(View.INVISIBLE);
		}
    }

    @Override
    public void toggle() {
        setChecked(!checked);
    }
}
