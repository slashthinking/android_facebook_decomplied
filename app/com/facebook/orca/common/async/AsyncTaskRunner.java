package com.facebook.orca.common.async;

import android.os.AsyncTask;

public class AsyncTaskRunner
{
  private final AsyncTask<Void, Void, Void> a;

  public AsyncTaskRunner(Runnable paramRunnable)
  {
    this.a = new AsyncTaskRunner.1(this, paramRunnable);
  }

  public void a()
  {
    AsyncTask localAsyncTask = this.a;
    Void[] arrayOfVoid = new Void[1];
    arrayOfVoid[0] = ((Void)null);
    localAsyncTask.execute(arrayOfVoid);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.async.AsyncTaskRunner
 * JD-Core Version:    0.6.0
 */