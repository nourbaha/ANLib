package com.nourbaha.anlib;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Nourbaha on 2/23/2018.
 */

public class BaseActivity extends AppCompatActivity {
    public Context mContext;
    public Activity mActivity;

    public ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        mActivity = this;
        progressDialog = new ProgressDialog(this);
    }

    public void onProgress(Boolean show)
    {
        if (show)
            progressDialog.show();
        else
            progressDialog.dismiss();
    }

}
