package com.nourbaha.anlib.views;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.nourbaha.anlib.BaseApplication;

/**
 * Created by Nourbaha on 2/23/2018.
 */

public class ANTextView extends AppCompatTextView {

    public ANTextView(Context context) {
        super(context);
        if (!isInEditMode())
            this.setTypeface(BaseApplication.typeface);
    }

    public ANTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode())
            this.setTypeface(BaseApplication.typeface);
    }
}
