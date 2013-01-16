package com.facebook.katana;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.facebook.katana.activity.BaseFacebookActivity;

public class WidgetActivity extends BaseFacebookActivity
{
  private boolean n = true;
  private BroadcastReceiver o;
  private String p;

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.o = new WidgetActivity.1(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.facebook.katana.widget.publish.result");
    registerReceiver(this.o, localIntentFilter);
  }

  protected Dialog onCreateDialog(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    default:
      localObject = super.onCreateDialog(paramInt);
    case 1:
    case 2:
    }
    while (true)
    {
      return localObject;
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
      View localView = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2130903548, null);
      localBuilder.setView(localView);
      localBuilder.setTitle(2131363210);
      TextView localTextView = (TextView)localView.findViewById(2131297098);
      if (this.p != null)
        localTextView.setText(this.p);
      localBuilder.setPositiveButton(getString(2131363209), new WidgetActivity.2(this, localTextView));
      localBuilder.setNegativeButton(getString(2131362848), new WidgetActivity.3(this));
      localBuilder.setOnCancelListener(new WidgetActivity.4(this));
      localObject = localBuilder.create();
      continue;
      localObject = new ProgressDialog(this);
      ((ProgressDialog)localObject).setProgressStyle(0);
      ((ProgressDialog)localObject).setMessage(getText(2131363207));
      ((ProgressDialog)localObject).setIndeterminate(true);
      ((ProgressDialog)localObject).setCancelable(false);
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (this.o != null)
      unregisterReceiver(this.o);
  }

  public void onResume()
  {
    super.onResume();
    if (this.n)
    {
      this.n = false;
      showDialog(1);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.WidgetActivity
 * JD-Core Version:    0.6.0
 */