package com.nourbaha.anlib.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import com.nourbaha.anlib.BaseApplication;
import com.nourbaha.anlib.R;

/**
 * Created by Nourbaha on 2/23/2018.
 */

public class ANButton extends AppCompatButton
{
    public ANButton(Context context) {
        super(context);
        if(!isInEditMode())
            this.setTypeface(BaseApplication.typeface);
        setRipple(context);
    }

    public ANButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        if(!isInEditMode())
            this.setTypeface(BaseApplication.typeface);
        setRipple(context);
    }

    void setRipple(Context mContext) {
        int[] attrs_ = new int[]{R.attr.selectableItemBackground};
        TypedArray typedArray = mContext.obtainStyledAttributes(attrs_);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            this.setForeground(typedArray.getDrawable(0));
            typedArray.recycle();
        }
    }
}
