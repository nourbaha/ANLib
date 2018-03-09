package com.nourbaha.anlib.views;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nourbaha.anlib.R;

/**
 * Created by Nourbaha on 3/9/2018.
 */

public class FragWaiting extends DialogFragment {

    private static FragWaiting fragWaiting;
    BroadcastReceiver dismissReceiver;

    public static FragWaiting getInstance() {
        if (fragWaiting == null)
            fragWaiting = new FragWaiting();
        return fragWaiting;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dismissReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                dismiss();
            }
        };
        IntentFilter intentFilter = new IntentFilter("dismiss");
        getActivity().registerReceiver(dismissReceiver, intentFilter);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.waiting, container);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getActivity().unregisterReceiver(dismissReceiver);
    }

}
