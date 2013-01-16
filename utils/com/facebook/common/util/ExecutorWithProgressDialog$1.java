package com.facebook.common.util;

import android.app.ProgressDialog;
import com.google.common.util.concurrent.FutureCallback;

class ExecutorWithProgressDialog$1
  implements FutureCallback<Object>
{
  ExecutorWithProgressDialog$1(ExecutorWithProgressDialog paramExecutorWithProgressDialog, ProgressDialog paramProgressDialog)
  {
  }

  public void a(Object paramObject)
  {
    this.a.dismiss();
  }

  public void a(Throwable paramThrowable)
  {
    this.a.dismiss();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.common.util.ExecutorWithProgressDialog.1
 * JD-Core Version:    0.6.2
 */