package com.facebook.bugreporter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.google.common.util.concurrent.ListenableFuture;

class BugReporter$4
  implements DialogInterface.OnDismissListener
{
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!this.a.isDone())
      this.a.cancel(false);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.bugreporter.BugReporter.4
 * JD-Core Version:    0.6.0
 */