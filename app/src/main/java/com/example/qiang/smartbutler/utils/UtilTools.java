package com.example.qiang.smartbutler.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

public class UtilTools {

    public static void setFont(Context context, TextView view) {
        Typeface fromAsset = Typeface.createFromAsset(context.getAssets(), "fonts/FONT.otf");
        view.setTypeface(fromAsset);
    }
}
