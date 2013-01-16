package com.facebook.orca.threadview;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;

class ThreadNamePicker$3
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ThreadNamePicker.b(this.a).hideSoftInputFromWindow(this.a.getWindow().getDecorView().getWindowToken(), 0);
    this.a.dismiss();
    if (ThreadNamePicker.c(this.a) != null)
      ThreadNamePicker.c(this.a).a(ThreadNamePicker.Result.CHANGE, null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadNamePicker.3
 * JD-Core Version:    0.6.0
 */