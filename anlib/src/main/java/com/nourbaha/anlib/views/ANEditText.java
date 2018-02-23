package com.nourbaha.anlib.views;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

import com.nourbaha.anlib.BaseApplication;

/**
 * Created by Nourbaha on 2/23/2018.
 */

public class ANEditText extends AppCompatEditText {
    public ANEditText(Context context) {
        super(context);
        if(!isInEditMode())
            this.setTypeface(BaseApplication.typeface);
    }

    public ANEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        if(!isInEditMode())
            this.setTypeface(BaseApplication.typeface);
    }

    public String text()
    {
        return (this.getText() != null ? this.getText().toString() : "");
    }
}
