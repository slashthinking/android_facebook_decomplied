package android.support.v4.content;

import java.util.concurrent.CountDownLatch;

final class AsyncTaskLoader$LoadTask extends ModernAsyncTask<Void, Void, D>
  implements Runnable
{
  D a;
  boolean b;
  private CountDownLatch e = new CountDownLatch(1);

  AsyncTaskLoader$LoadTask(AsyncTaskLoader paramAsyncTaskLoader)
  {
  }

  protected D a(Void[] paramArrayOfVoid)
  {
    this.a = this.c.e();
    return this.a;
  }

  protected void a()
  {
    try
    {
      this.c.a(this, this.a);
      return;
    }
    finally
    {
      this.e.countDown();
    }
    throw localObject;
  }

  protected void a(D paramD)
  {
    try
    {
      this.c.b(this, paramD);
      return;
    }
    finally
    {
      this.e.countDown();
    }
    throw localObject;
  }

  public void run()
  {
    this.b = false;
    this.c.c();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.content.AsyncTaskLoader.LoadTask
 * JD-Core Version:    0.6.0
 */