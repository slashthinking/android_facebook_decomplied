package com.facebook.feed.ui;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import java.util.ArrayList;

public class AlertDialogMenuBuilder extends AlertDialog.Builder
{
  private ArrayList<String> a = new ArrayList();
  private ArrayList<DialogInterface.OnClickListener> b = new ArrayList();

  public AlertDialogMenuBuilder(Context paramContext)
  {
    super(paramContext);
  }

  public AlertDialogMenuBuilder a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.a.add(paramString);
    this.b.add(paramOnClickListener);
    return this;
  }

  public AlertDialog show()
  {
    setItems((String[])(String[])this.a.toArray(new String[this.a.size()]), new AlertDialogMenuBuilder.1(this));
    this.a = null;
    AlertDialog localAlertDialog = super.show();
    localAlertDialog.setCanceledOnTouchOutside(true);
    return localAlertDialog;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.AlertDialogMenuBuilder
 * JD-Core Version:    0.6.0
 */