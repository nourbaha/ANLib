package com.nourbaha.anlib;

import android.content.Context;

import com.orhanobut.hawk.Hawk;

/**
 * Created by Nourbaha on 3/9/2018.
 */

public class Shared {

    public static final String isRegistered = "isRegistered";
    public static final String isVerified = "isVerified";
    public static final String passport = "passport";
    public static final String tokenFCM = "tokenFCM";
    public static final String mobileNumber = "mobileNo";
    public static final String clientPassIV = "clientPassIV";
    public static final String clientPassKey = "clientPassKey";

    public static void init(Context context) {

        Hawk.init(context).build();
    }

    public static <T> void set(String key, T value) {
        Hawk.put(key, value);
    }

    public static <T> T get(String key) {
        return Hawk.get(key);
    }

    public static Boolean contains(String key) {
        return Hawk.contains(key);
    }
}

