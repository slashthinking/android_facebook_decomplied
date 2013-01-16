package com.facebook.app;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Process;
import com.facebook.common.util.Log;
import com.facebook.common.util.ProcessUtil;
import com.facebook.orca.annotations.ForUiThread;
import com.facebook.orca.app.FbAppInitializer;
import com.facebook.orca.debug.Tracer;
import com.facebook.orca.inject.ContextScope;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.inject.Module;
import com.google.common.base.FinalizableReferenceQueue;
import com.google.common.util.concurrent.Futures;
import com.google.inject.util.Providers;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Provider;

public abstract class ApplicationLike
{
  private static final String a = ApplicationLike.class.getName();
  private final Application b;
  private FbInjector c;

  public ApplicationLike(Application paramApplication)
  {
    this.b = paramApplication;
  }

  private String e()
  {
    Application localApplication = this.b;
    ActivityManager localActivityManager = (ActivityManager)localApplication.getSystemService("activity");
    Provider localProvider = Providers.a(Integer.valueOf(Process.myPid()));
    return new ProcessUtil(this.b, localActivityManager, localProvider).a();
  }

  private void f()
  {
    Log.d(a, "Forcing initialization of AsyncTask");
    try
    {
      Class.forName("android.os.AsyncTask");
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      while (true)
        Log.b(a, "Exception trying to initialize AsyncTask", localClassNotFoundException);
    }
  }

  public Application a()
  {
    return this.b;
  }

  protected abstract List<Module> a(String paramString, ContextScope paramContextScope);

  public void b()
  {
    Logger.getLogger(FinalizableReferenceQueue.class.getName()).setLevel(Level.SEVERE);
    Tracer.b(5L);
    Tracer localTracer = Tracer.a("Application startup");
    f();
    String str = e();
    monitorenter;
    try
    {
      this.c = FbInjector.a(a(str, new ContextScope()));
      notifyAll();
      monitorexit;
      Futures.a(((FbAppInitializer)this.c.a(FbAppInitializer.class)).a(), new ApplicationLike.1(this, localTracer), (Executor)this.c.a(Executor.class, ForUiThread.class));
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void c()
  {
  }

  public final FbInjector d()
  {
    monitorenter;
    try
    {
      while (this.c == null)
        wait();
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new RuntimeException(localInterruptedException);
    }
    finally
    {
      monitorexit;
    }
    FbInjector localFbInjector = this.c;
    monitorexit;
    return localFbInjector;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.app.ApplicationLike
 * JD-Core Version:    0.6.0
 */