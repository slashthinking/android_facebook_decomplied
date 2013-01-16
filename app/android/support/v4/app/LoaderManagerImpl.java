package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class LoaderManagerImpl extends LoaderManager
{
  static boolean a = false;
  final SparseArrayCompat<LoaderManagerImpl.LoaderInfo> b = new SparseArrayCompat();
  final SparseArrayCompat<LoaderManagerImpl.LoaderInfo> c = new SparseArrayCompat();
  FragmentActivity d;
  boolean e;
  boolean f;
  boolean g;

  LoaderManagerImpl(FragmentActivity paramFragmentActivity, boolean paramBoolean)
  {
    this.d = paramFragmentActivity;
    this.e = paramBoolean;
  }

  private LoaderManagerImpl.LoaderInfo c(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<Object> paramLoaderCallbacks)
  {
    LoaderManagerImpl.LoaderInfo localLoaderInfo = new LoaderManagerImpl.LoaderInfo(this, paramInt, paramBundle, paramLoaderCallbacks);
    localLoaderInfo.d = paramLoaderCallbacks.a(paramInt, paramBundle);
    return localLoaderInfo;
  }

  private LoaderManagerImpl.LoaderInfo d(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<Object> paramLoaderCallbacks)
  {
    try
    {
      this.g = true;
      LoaderManagerImpl.LoaderInfo localLoaderInfo = c(paramInt, paramBundle, paramLoaderCallbacks);
      a(localLoaderInfo);
      return localLoaderInfo;
    }
    finally
    {
      this.g = false;
    }
    throw localObject;
  }

  public <D> Loader<D> a(int paramInt)
  {
    if (this.g)
      throw new IllegalStateException("Called while creating a loader");
    LoaderManagerImpl.LoaderInfo localLoaderInfo = (LoaderManagerImpl.LoaderInfo)this.b.a(paramInt);
    Loader localLoader;
    if (localLoaderInfo != null)
      if (localLoaderInfo.n != null)
        localLoader = localLoaderInfo.n.d;
    while (true)
    {
      return localLoader;
      localLoader = localLoaderInfo.d;
      continue;
      localLoader = null;
    }
  }

  public <D> Loader<D> a(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks)
  {
    if (this.g)
      throw new IllegalStateException("Called while creating a loader");
    LoaderManagerImpl.LoaderInfo localLoaderInfo = (LoaderManagerImpl.LoaderInfo)this.b.a(paramInt);
    if (a)
      Log.v("LoaderManager", "initLoader in " + this + ": args=" + paramBundle);
    if (localLoaderInfo == null)
    {
      localLoaderInfo = d(paramInt, paramBundle, paramLoaderCallbacks);
      if (a)
        Log.v("LoaderManager", "  Created new loader " + localLoaderInfo);
    }
    while (true)
    {
      if ((localLoaderInfo.e) && (this.e))
        localLoaderInfo.b(localLoaderInfo.d, localLoaderInfo.g);
      return localLoaderInfo.d;
      if (a)
        Log.v("LoaderManager", "  Re-using existing loader " + localLoaderInfo);
      localLoaderInfo.c = paramLoaderCallbacks;
    }
  }

  void a(FragmentActivity paramFragmentActivity)
  {
    this.d = paramFragmentActivity;
  }

  void a(LoaderManagerImpl.LoaderInfo paramLoaderInfo)
  {
    this.b.b(paramLoaderInfo.a, paramLoaderInfo);
    if (this.e)
      paramLoaderInfo.a();
  }

  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int i = 0;
    if (this.b.a() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Active Loaders:");
      String str2 = paramString + "    ";
      for (int j = 0; j < this.b.a(); j++)
      {
        LoaderManagerImpl.LoaderInfo localLoaderInfo2 = (LoaderManagerImpl.LoaderInfo)this.b.f(j);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(this.b.e(j));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(localLoaderInfo2.toString());
        localLoaderInfo2.a(str2, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      }
    }
    if (this.c.a() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Inactive Loaders:");
      String str1 = paramString + "    ";
      while (i < this.c.a())
      {
        LoaderManagerImpl.LoaderInfo localLoaderInfo1 = (LoaderManagerImpl.LoaderInfo)this.c.f(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(this.c.e(i));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(localLoaderInfo1.toString());
        localLoaderInfo1.a(str1, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        i++;
      }
    }
  }

  public boolean a()
  {
    int i = this.b.a();
    int j = 0;
    int k = 0;
    if (j < i)
    {
      LoaderManagerImpl.LoaderInfo localLoaderInfo = (LoaderManagerImpl.LoaderInfo)this.b.f(j);
      if ((localLoaderInfo.h) && (!localLoaderInfo.f));
      for (int m = 1; ; m = 0)
      {
        k |= m;
        j++;
        break;
      }
    }
    return k;
  }

  public <D> Loader<D> b(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks)
  {
    if (this.g)
      throw new IllegalStateException("Called while creating a loader");
    LoaderManagerImpl.LoaderInfo localLoaderInfo1 = (LoaderManagerImpl.LoaderInfo)this.b.a(paramInt);
    if (a)
      Log.v("LoaderManager", "restartLoader in " + this + ": args=" + paramBundle);
    if (localLoaderInfo1 != null)
    {
      LoaderManagerImpl.LoaderInfo localLoaderInfo2 = (LoaderManagerImpl.LoaderInfo)this.c.a(paramInt);
      if (localLoaderInfo2 == null)
        break label312;
      if (!localLoaderInfo1.e)
        break label177;
      if (a)
        Log.v("LoaderManager", "  Removing last inactive loader: " + localLoaderInfo1);
      localLoaderInfo2.f = false;
      localLoaderInfo2.f();
      localLoaderInfo1.d.q();
      this.c.b(paramInt, localLoaderInfo1);
    }
    while (true)
    {
      for (Loader localLoader = d(paramInt, paramBundle, paramLoaderCallbacks).d; ; localLoader = localLoaderInfo1.n.d)
      {
        return localLoader;
        label177: if (!localLoaderInfo1.h)
        {
          if (a)
            Log.v("LoaderManager", "  Current loader is stopped; replacing");
          this.b.b(paramInt, null);
          localLoaderInfo1.f();
          break;
        }
        if (localLoaderInfo1.n != null)
        {
          if (a)
            Log.v("LoaderManager", "  Removing pending loader: " + localLoaderInfo1.n);
          localLoaderInfo1.n.f();
          localLoaderInfo1.n = null;
        }
        if (a)
          Log.v("LoaderManager", "  Enqueuing as new pending loader");
        localLoaderInfo1.n = c(paramInt, paramBundle, paramLoaderCallbacks);
      }
      label312: if (a)
        Log.v("LoaderManager", "  Making last loader inactive: " + localLoaderInfo1);
      localLoaderInfo1.d.q();
      this.c.b(paramInt, localLoaderInfo1);
    }
  }

  void b()
  {
    if (a)
      Log.v("LoaderManager", "Starting in " + this);
    if (this.e)
    {
      RuntimeException localRuntimeException = new RuntimeException("here");
      localRuntimeException.fillInStackTrace();
      Log.w("LoaderManager", "Called doStart when already started: " + this, localRuntimeException);
    }
    while (true)
    {
      return;
      this.e = true;
      for (int i = -1 + this.b.a(); i >= 0; i--)
        ((LoaderManagerImpl.LoaderInfo)this.b.f(i)).a();
    }
  }

  void c()
  {
    if (a)
      Log.v("LoaderManager", "Stopping in " + this);
    if (!this.e)
    {
      RuntimeException localRuntimeException = new RuntimeException("here");
      localRuntimeException.fillInStackTrace();
      Log.w("LoaderManager", "Called doStop when not started: " + this, localRuntimeException);
    }
    while (true)
    {
      return;
      for (int i = -1 + this.b.a(); i >= 0; i--)
        ((LoaderManagerImpl.LoaderInfo)this.b.f(i)).e();
      this.e = false;
    }
  }

  void d()
  {
    if (a)
      Log.v("LoaderManager", "Retaining in " + this);
    if (!this.e)
    {
      RuntimeException localRuntimeException = new RuntimeException("here");
      localRuntimeException.fillInStackTrace();
      Log.w("LoaderManager", "Called doRetain when not started: " + this, localRuntimeException);
    }
    while (true)
    {
      return;
      this.f = true;
      this.e = false;
      for (int i = -1 + this.b.a(); i >= 0; i--)
        ((LoaderManagerImpl.LoaderInfo)this.b.f(i)).b();
    }
  }

  void e()
  {
    if (this.f)
    {
      if (a)
        Log.v("LoaderManager", "Finished Retaining in " + this);
      this.f = false;
      for (int i = -1 + this.b.a(); i >= 0; i--)
        ((LoaderManagerImpl.LoaderInfo)this.b.f(i)).c();
    }
  }

  void f()
  {
    for (int i = -1 + this.b.a(); i >= 0; i--)
      ((LoaderManagerImpl.LoaderInfo)this.b.f(i)).k = true;
  }

  void g()
  {
    for (int i = -1 + this.b.a(); i >= 0; i--)
      ((LoaderManagerImpl.LoaderInfo)this.b.f(i)).d();
  }

  void h()
  {
    if (!this.f)
    {
      if (a)
        Log.v("LoaderManager", "Destroying Active in " + this);
      for (int j = -1 + this.b.a(); j >= 0; j--)
        ((LoaderManagerImpl.LoaderInfo)this.b.f(j)).f();
    }
    if (a)
      Log.v("LoaderManager", "Destroying Inactive in " + this);
    for (int i = -1 + this.c.a(); i >= 0; i--)
      ((LoaderManagerImpl.LoaderInfo)this.c.f(i)).f();
    this.c.b();
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("LoaderManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    DebugUtils.a(this.d, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.app.LoaderManagerImpl
 * JD-Core Version:    0.6.0
 */