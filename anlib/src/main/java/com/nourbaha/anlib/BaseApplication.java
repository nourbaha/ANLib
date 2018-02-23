package com.nourbaha.anlib;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by Nourbaha on 2/23/2018.
 */

public class BaseApplication extends Application{
    public static Typeface typeface;

    @Override
    public void onCreate() {
        super.onCreate();

        setTypeface(this);

    }

    public void setTypeface(Context mContext) {
        if (typeface == null)
            typeface = Typeface.createFromAsset(mContext.getAssets(), Constants.fontName);

    }
}
