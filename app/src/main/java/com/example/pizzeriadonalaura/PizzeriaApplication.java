package com.example.pizzeriadonalaura;

import android.app.Application;
import android.content.Context;

//PARA USAR EL CONTEXTO EN ZONAS DONDE NO SON VISTA. hAY QUE MODIFICAR EL MANIFEST (ANDROID:NAME)
public class PizzeriaApplication extends Application {

    private static Context mContext;

    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
