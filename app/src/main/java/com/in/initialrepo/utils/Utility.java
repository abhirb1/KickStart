package com.in.initialrepo.utils;

import android.content.Context;
import android.net.ConnectivityManager;

import com.afollestad.materialdialogs.MaterialDialog;

/**
 * Created by Abhishek on 21/6/2015.
 */

public class Utility {

    public static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static boolean isNetworkAvailable(Context context) {
        try {
            ConnectivityManager connManager = (ConnectivityManager) context.getSystemService
                    (Context.CONNECTIVITY_SERVICE);
            if (connManager.getActiveNetworkInfo() != null && connManager.getActiveNetworkInfo()
                    .isAvailable() && connManager.getActiveNetworkInfo().isConnected()) {
                return true;
            }
        } catch (Exception ex) {

            ex.printStackTrace();
            return false;
        }
        return false;
    }

    public static void showMaterialAlertOkButton(Context context, String title, String message,
                                                 String positiveText,Boolean isCancellable) {
        MaterialDialog dialog = new MaterialDialog.Builder(context)
                .title(title)
                .content(message)
                .positiveText(positiveText)
                .cancelable(isCancellable)
                .callback(new MaterialDialog.ButtonCallback() {
                    @Override
                    public void onPositive(MaterialDialog dialog) {

                    }
                }).build();
        dialog.show();
    }
}
