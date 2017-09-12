package me.ashif.locationshift.utils;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Ashif on 12/9/17,September,2017
 * github.com/SheikhZayed
 */

public class DialogUtils {

  private ProgressDialog mProgressDialog;
  private AlertDialog.Builder mAlertDialog;
  private Context mContext;

  public DialogUtils(Context context) {
    mProgressDialog = new ProgressDialog(context);
    mAlertDialog = new AlertDialog.Builder(context);
    this.mContext = context;
  }

  @SuppressLint("NewApi") public void ShowProgressDialog(String message) {
    mProgressDialog.setMessage(message);
    mProgressDialog.setIndeterminate(true);
    mProgressDialog.create();
    mProgressDialog.show();
  }

  public void dismissProgress(){
    mProgressDialog.dismiss();
  }

  public void showETADetails(String distance,String time){
    mAlertDialog
        .setMessage("Shift Distance : " + distance + "\n" + "Shift ETA : " + time)
        .setTitle("ETA Details")
        .setPositiveButton("OK",null)
        .create().show();
  }

  public void showGenericDialog(String message,String title,DialogInterface.OnClickListener clickListener){
    mAlertDialog.setMessage(message)
        .setTitle(title)
        .setCancelable(false)
        .setPositiveButton("OPEN SETTINGS",clickListener)
        .create().show();

  }

  public void showToast(String message) {
    Toast.makeText(mContext,message,Toast.LENGTH_SHORT).show();
  }
}
