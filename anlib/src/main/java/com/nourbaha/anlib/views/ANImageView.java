package com.nourbaha.anlib.views;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.nourbaha.anlib.AN;

/**
 * Created by Nourbaha on 2/23/2018.
 */

public class ANImageView extends AppCompatImageView {
    Context mContext;

    public ANImageView(Context context) {
        super(context);
        this.mContext = context;
    }

    public ANImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
    }

    public void loadURL(String url) {
        AN.loadImage(mContext, url, this);
    }
}
