package android.support.v4.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.util.TimeUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class AsyncTaskLoader<D> extends Loader<D>
{
  volatile AsyncTaskLoader<D>.LoadTask a;
  volatile AsyncTaskLoader<D>.LoadTask b;
  long c;
  long d = -10000L;
  Handler e;

  public AsyncTaskLoader(Context paramContext)
  {
    super(paramContext);
  }

  protected void a()
  {
    super.a();
    b();
    this.a = new AsyncTaskLoader.LoadTask(this);
    c();
  }

  void a(AsyncTaskLoader<D>.LoadTask paramAsyncTaskLoader, D paramD)
  {
    a(paramD);
    if (this.b == paramAsyncTaskLoader)
    {
      this.d = SystemClock.uptimeMillis();
      this.b = null;
      c();
    }
  }

  public void a(D paramD)
  {
  }

  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.a(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    if (this.a != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mTask=");
      paramPrintWriter.print(this.a);
      paramPrintWriter.print(" waiting=");
      paramPrintWriter.println(this.a.b);
    }
    if (this.b != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mCancellingTask=");
      paramPrintWriter.print(this.b);
      paramPrintWriter.print(" waiting=");
      paramPrintWriter.println(this.b.b);
    }
    if (this.c != 0L)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mUpdateThrottle=");
      TimeUtils.a(this.c, paramPrintWriter);
      paramPrintWriter.print(" mLastLoadCompleteTime=");
      TimeUtils.a(this.d, SystemClock.uptimeMillis(), paramPrintWriter);
      paramPrintWriter.println();
    }
  }

  void b(AsyncTaskLoader<D>.LoadTask paramAsyncTaskLoader, D paramD)
  {
    if (this.a != paramAsyncTaskLoader)
      a(paramAsyncTaskLoader, paramD);
    while (true)
    {
      return;
      if (l())
      {
        a(paramD);
        continue;
      }
      this.d = SystemClock.uptimeMillis();
      this.a = null;
      b(paramD);
    }
  }

  public boolean b()
  {
    AsyncTaskLoader.LoadTask localLoadTask = this.a;
    boolean bool = false;
    if (localLoadTask != null)
    {
      if (this.b == null)
        break label54;
      if (this.a.b)
      {
        this.a.b = false;
        this.e.removeCallbacks(this.a);
      }
      this.a = null;
    }
    while (true)
    {
      return bool;
      label54: if (this.a.b)
      {
        this.a.b = false;
        this.e.removeCallbacks(this.a);
        this.a = null;
        bool = false;
        continue;
      }
      bool = this.a.a(false);
      if (bool)
        this.b = this.a;
      this.a = null;
    }
  }

  void c()
  {
    if ((this.b == null) && (this.a != null))
    {
      if (this.a.b)
      {
        this.a.b = false;
        this.e.removeCallbacks(this.a);
      }
      if ((this.c <= 0L) || (SystemClock.uptimeMillis() >= this.d + this.c))
        break label98;
      this.a.b = true;
      this.e.postAtTime(this.a, this.d + this.c);
    }
    while (true)
    {
      return;
      label98: this.a.a(ModernAsyncTask.d, (Void[])null);
    }
  }

  public abstract D d();

  protected D e()
  {
    return d();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.content.AsyncTaskLoader
 * JD-Core Version:    0.6.0
 */