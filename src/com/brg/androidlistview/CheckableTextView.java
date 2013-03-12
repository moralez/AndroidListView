package com.brg.androidlistview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.TextView;

public class CheckableTextView extends TextView implements Checkable {

	public CheckableTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	public CheckableTextView(Context context) {
		super(context);
	}

	private boolean checked = false;

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }
    @Override
    public boolean isChecked() {
        return checked;
    }

    @Override
    public void setChecked(boolean checked) {
        this.checked = checked;
        if (checked) {
			setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_launcher, 0);
		} else {
			setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_launcher, 0, 0, 0);
		}
    }

    @Override
    public void toggle() {
        setChecked(!checked);
    }
}
