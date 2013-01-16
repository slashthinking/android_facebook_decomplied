package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.support.v4.content.Loader.OnLoadCompleteListener;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

final class LoaderManagerImpl$LoaderInfo
  implements Loader.OnLoadCompleteListener<Object>
{
  final int a;
  final Bundle b;
  LoaderManager.LoaderCallbacks<Object> c;
  Loader<Object> d;
  boolean e;
  boolean f;
  Object g;
  boolean h;
  boolean i;
  boolean j;
  boolean k;
  boolean l;
  boolean m;
  LoaderInfo n;

  public LoaderManagerImpl$LoaderInfo(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<Object> paramLoaderCallbacks)
  {
    this.a = paramBundle;
    this.b = paramLoaderCallbacks;
    Object localObject;
    this.c = localObject;
  }

  void a()
  {
    if ((this.i) && (this.j))
      this.h = true;
    while (true)
    {
      return;
      if (!this.h)
      {
        this.h = true;
        if (LoaderManagerImpl.a)
          Log.v("LoaderManager", "  Starting: " + this);
        if ((this.d == null) && (this.c != null))
          this.d = this.c.a(this.a, this.b);
        if (this.d == null)
          continue;
        if ((this.d.getClass().isMemberClass()) && (!Modifier.isStatic(this.d.getClass().getModifiers())))
          throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.d);
        if (!this.m)
        {
          this.d.a(this.a, this);
          this.m = true;
        }
        this.d.n();
        continue;
      }
    }
  }

  public void a(Loader<Object> paramLoader, Object paramObject)
  {
    if (LoaderManagerImpl.a)
      Log.v("LoaderManager", "onLoadComplete: " + this);
    if (this.l)
      if (LoaderManagerImpl.a)
        Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
    while (true)
    {
      return;
      if (this.o.b.a(this.a) != this)
      {
        if (!LoaderManagerImpl.a)
          continue;
        Log.v("LoaderManager", "  Ignoring load complete -- not active");
        continue;
      }
      LoaderInfo localLoaderInfo1 = this.n;
      if (localLoaderInfo1 != null)
      {
        if (LoaderManagerImpl.a)
          Log.v("LoaderManager", "  Switching to pending loader: " + localLoaderInfo1);
        this.n = null;
        this.o.b.b(this.a, null);
        f();
        this.o.a(localLoaderInfo1);
        continue;
      }
      if ((this.g != paramObject) || (!this.e))
      {
        this.g = paramObject;
        this.e = true;
        if (this.h)
          b(paramLoader, paramObject);
      }
      LoaderInfo localLoaderInfo2 = (LoaderInfo)this.o.c.a(this.a);
      if ((localLoaderInfo2 != null) && (localLoaderInfo2 != this))
      {
        localLoaderInfo2.f = false;
        localLoaderInfo2.f();
        this.o.c.c(this.a);
      }
      if ((this.o.d == null) || (this.o.a()))
        continue;
      this.o.d.b.g();
    }
  }

  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mId=");
    paramPrintWriter.print(this.a);
    paramPrintWriter.print(" mArgs=");
    paramPrintWriter.println(this.b);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mCallbacks=");
    paramPrintWriter.println(this.c);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mLoader=");
    paramPrintWriter.println(this.d);
    if (this.d != null)
      this.d.a(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    if ((this.e) || (this.f))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mHaveData=");
      paramPrintWriter.print(this.e);
      paramPrintWriter.print("  mDeliveredData=");
      paramPrintWriter.println(this.f);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mData=");
      paramPrintWriter.println(this.g);
    }
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mStarted=");
    paramPrintWriter.print(this.h);
    paramPrintWriter.print(" mReportNextStart=");
    paramPrintWriter.print(this.k);
    paramPrintWriter.print(" mDestroyed=");
    paramPrintWriter.println(this.l);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mRetaining=");
    paramPrintWriter.print(this.i);
    paramPrintWriter.print(" mRetainingStarted=");
    paramPrintWriter.print(this.j);
    paramPrintWriter.print(" mListenerRegistered=");
    paramPrintWriter.println(this.m);
    if (this.n != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Pending Loader ");
      paramPrintWriter.print(this.n);
      paramPrintWriter.println(":");
      this.n.a(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }

  void b()
  {
    if (LoaderManagerImpl.a)
      Log.v("LoaderManager", "  Retaining: " + this);
    this.i = true;
    this.j = this.h;
    this.h = false;
    this.c = null;
  }

  void b(Loader<Object> paramLoader, Object paramObject)
  {
    String str2;
    if (this.c != null)
    {
      if (this.o.d == null)
        break label164;
      str2 = this.o.d.b.t;
      this.o.d.b.t = "onLoadFinished";
    }
    label164: for (String str1 = str2; ; str1 = null)
      try
      {
        if (LoaderManagerImpl.a)
          Log.v("LoaderManager", "  onLoadFinished in " + paramLoader + ": " + paramLoader.c(paramObject));
        this.c.a(paramLoader, paramObject);
        if (this.o.d != null)
          this.o.d.b.t = str1;
        this.f = true;
        return;
      }
      finally
      {
        if (this.o.d != null)
          this.o.d.b.t = str1;
      }
  }

  void c()
  {
    if (this.i)
    {
      if (LoaderManagerImpl.a)
        Log.v("LoaderManager", "  Finished Retaining: " + this);
      this.i = false;
      if ((this.h != this.j) && (!this.h))
        e();
    }
    if ((this.h) && (this.e) && (!this.k))
      b(this.d, this.g);
  }

  void d()
  {
    if ((this.h) && (this.k))
    {
      this.k = false;
      if (this.e)
        b(this.d, this.g);
    }
  }

  void e()
  {
    if (LoaderManagerImpl.a)
      Log.v("LoaderManager", "  Stopping: " + this);
    this.h = false;
    if ((!this.i) && (this.d != null) && (this.m))
    {
      this.m = false;
      this.d.a(this);
      this.d.p();
    }
  }

  void f()
  {
    if (LoaderManagerImpl.a)
      Log.v("LoaderManager", "  Destroying: " + this);
    this.l = true;
    boolean bool = this.f;
    this.f = false;
    String str2;
    if ((this.c != null) && (this.d != null) && (this.e) && (bool))
    {
      if (LoaderManagerImpl.a)
        Log.v("LoaderManager", "  Reseting: " + this);
      if (this.o.d == null)
        break label276;
      str2 = this.o.d.b.t;
      this.o.d.b.t = "onLoaderReset";
    }
    label276: for (String str1 = str2; ; str1 = null)
      try
      {
        this.c.a(this.d);
        if (this.o.d != null)
          this.o.d.b.t = str1;
        this.c = null;
        this.g = null;
        this.e = false;
        if (this.d != null)
        {
          if (this.m)
          {
            this.m = false;
            this.d.a(this);
          }
          this.d.s();
        }
        if (this.n != null)
          this.n.f();
        return;
      }
      finally
      {
        if (this.o.d != null)
          this.o.d.b.t = str1;
      }
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append("LoaderInfo{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" #");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" : ");
    DebugUtils.a(this.d, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.app.LoaderManagerImpl.LoaderInfo
 * JD-Core Version:    0.6.0
 */