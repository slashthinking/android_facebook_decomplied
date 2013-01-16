package com.facebook.common.util;

import android.app.ProgressDialog;
import android.content.Context;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Executor;

public class ExecutorWithProgressDialog
{
  private final Context a;
  private final ListeningExecutorService b;
  private final Executor c;

  public ExecutorWithProgressDialog(Context paramContext, ListeningExecutorService paramListeningExecutorService, Executor paramExecutor)
  {
    this.a = paramContext;
    this.b = paramListeningExecutorService;
    this.c = paramExecutor;
  }

  public void a(int paramInt1, int paramInt2, Runnable paramRunnable)
  {
    a(this.a.getString(paramInt1), this.a.getString(paramInt2), paramRunnable);
  }

  public void a(String paramString1, String paramString2, Runnable paramRunnable)
  {
    ProgressDialog localProgressDialog = ProgressDialog.show(this.a, paramString1, paramString2, true);
    Futures.a(this.b.a(paramRunnable), new ExecutorWithProgressDialog.1(this, localProgressDialog), this.c);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.common.util.ExecutorWithProgressDialog
 * JD-Core Version:    0.6.2
 */