package com.nourbaha.anlib;

import android.content.Context;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

/**
 * Created by Nourbaha on 2/23/2018.
 */

public class AN {
    public static void showToast(Context mContext,String message)
    {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    public static void loadImage(Context mContext, String url, ImageView img) {
        if (url != null)
            Glide.with(mContext).load(url).into(img);
    }
}
