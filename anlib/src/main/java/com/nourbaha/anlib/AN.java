package com.nourbaha.anlib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.nourbaha.anlib.views.FragWaiting;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import ir.hamsaa.persiandatepicker.util.PersianCalendar;

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
    public static String getShamsiDate() {
        PersianCalendar pc = new PersianCalendar();
        return pc.getPersianShortDate();
    }

    public static String decimalsCorrect(int num) {
        if (num < 10)
            return "0" + num;
        return num + "";
    }
    public static Date daysAgo(int daysAgo) {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, daysAgo * -1);
        return cal.getTime();
    }

    public static void showLoading(Context mContext) {
        hideLoading(mContext);
        FragWaiting fa = new FragWaiting();
        fa.show(((AppCompatActivity) mContext).getSupportFragmentManager(), randString());
    }

    public static String randString() {
        return UUID.randomUUID().toString();
    }

    public static void hideLoading(Context mContext) {
        mContext.sendBroadcast(new Intent("dismiss"));
    }

    //call in onCreate if have any edittext in activity to prevent auto open keyboard
    public static void hideKeyBoardOnStartActivity(Activity mActivity) {
        mActivity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    public static void CallIntent(Context mContext, String number) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:" + number));
        mContext.startActivity(callIntent);
    }

    public static void direction(Context mContext, String lat, String lon, String title) {
        String uri = String.format(Locale.ENGLISH, "geo:%f,%f?z=%d&q=%f,%f (%s)",
                Float.parseFloat(lat), Float.parseFloat(lon), 15, Float.parseFloat(lat), Float.parseFloat(lon), title);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        mContext.startActivity(intent);
    }

    public static int getVersionCode(Context mContext) {
        String versionName = "";
        int versionCode = -1;
        try {
            PackageInfo packageInfo = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0);
            versionName = packageInfo.versionName;
            versionCode = packageInfo.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return versionCode;
    }

    public static void openURLinWebBrowser(Context mContext, String url) {
        mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    }
}
