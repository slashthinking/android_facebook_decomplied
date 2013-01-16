package com.facebook.orca.ops;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.facebook.dispose.Disposable;
import com.facebook.orca.activity.FbActivityish;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.WtfToken;
import com.facebook.orca.server.ErrorCode;
import com.facebook.orca.server.IOrcaService;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceRegistry;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;

public class OrcaServiceOperationFactory$OrcaServiceOperation
{
  public static final Map<Object, String> a;
  private static final Class<?> b = OrcaServiceOperation.class;
  private static final WtfToken c = new WtfToken();
  private String d;
  private Bundle e;
  private final Context f;
  private final OrcaServiceOperationFactory.OrcaServiceOperation.OrcaServiceConnection g;
  private final OrcaServiceRegistry h;
  private final AndroidThreadUtil i;
  private final OrcaServiceOperationFactory.OrcaServiceOperation.ThreadCheckingFuture<OperationResult> j;
  private Handler k;
  private IOrcaService l;
  private boolean m;
  private OperationProgressIndicator n;
  private OrcaServiceOperationFactory.OrcaServiceOperation.State o = OrcaServiceOperationFactory.OrcaServiceOperation.State.INIT;
  private String p;
  private boolean q;
  private boolean r;
  private Disposable s;

  static
  {
    a = Maps.c();
  }

  public OrcaServiceOperationFactory$OrcaServiceOperation(String paramString, Bundle paramBundle, Context paramContext, OrcaServiceRegistry paramOrcaServiceRegistry, AndroidThreadUtil paramAndroidThreadUtil)
  {
    this.d = paramString;
    this.e = new Bundle(paramBundle);
    this.f = paramContext;
    this.g = new OrcaServiceOperationFactory.OrcaServiceOperation.OrcaServiceConnection(this, null);
    this.h = paramOrcaServiceRegistry;
    this.i = paramAndroidThreadUtil;
    this.j = new OrcaServiceOperationFactory.OrcaServiceOperation.ThreadCheckingFuture(this, null);
    this.s = new OrcaServiceOperationFactory.OrcaServiceOperation.1(this);
  }

  private void a(ServiceException paramServiceException)
  {
    this.o = OrcaServiceOperationFactory.OrcaServiceOperation.State.COMPLETED;
    this.p = null;
    k();
    boolean bool1 = this.f instanceof FbActivityish;
    boolean bool2 = false;
    if (bool1)
      bool2 = ((FbActivityish)this.f).a(paramServiceException);
    if (!bool2)
      this.j.a_(paramServiceException);
    a();
  }

  private void a(OperationResult paramOperationResult)
  {
    if (this.m)
      a();
    while (true)
    {
      return;
      a(new OrcaServiceOperationFactory.OrcaServiceOperation.4(this, paramOperationResult));
    }
  }

  private void a(Runnable paramRunnable)
  {
    if (this.k != null)
      this.k.post(paramRunnable);
    while (true)
    {
      return;
      this.i.c(paramRunnable);
    }
  }

  private void b(OperationResult paramOperationResult)
  {
    if (paramOperationResult.c())
      c(paramOperationResult);
    while (true)
    {
      return;
      a(new ServiceException(paramOperationResult));
    }
  }

  private void c(OperationResult paramOperationResult)
  {
    this.o = OrcaServiceOperationFactory.OrcaServiceOperation.State.COMPLETED;
    this.p = null;
    k();
    this.j.a_(paramOperationResult);
    a();
  }

  private void f()
  {
    if (this.q);
    try
    {
      this.f.unbindService(this.g);
      this.q = false;
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (true)
        BLog.a(c, b, "Exception unbinding: " + this.d, localIllegalArgumentException);
    }
  }

  private void g()
  {
    if (this.l != null)
      h();
    while (true)
    {
      return;
      if (!this.q)
      {
        Intent localIntent = this.h.a(this.d, this.f);
        if (localIntent == null)
        {
          a(OperationResult.a(ErrorCode.ORCA_SERVICE_IPC_FAILURE, "Unknown operation type: " + this.d));
          continue;
        }
        if (this.f.bindService(localIntent, this.g, 1))
        {
          this.q = true;
          continue;
        }
        a(OperationResult.a(ErrorCode.ORCA_SERVICE_IPC_FAILURE, "Bind to OrcaService failed"));
        continue;
      }
    }
  }

  private void h()
  {
    boolean bool1 = true;
    boolean bool2;
    boolean bool3;
    if (this.o == OrcaServiceOperationFactory.OrcaServiceOperation.State.READY_TO_QUEUE)
      if (this.d != null)
      {
        bool2 = bool1;
        Preconditions.checkState(bool2, "Null operation type");
        if (this.p != null)
          break label113;
        bool3 = bool1;
        label37: Preconditions.checkState(bool3, "Non-null operation id");
        if (this.r)
          break label119;
        label51: Preconditions.checkState(bool1, "Registered for completion and haven't yet sent");
        try
        {
          this.p = this.l.a(this.d, this.e);
          if (this.l == null)
            throw new RemoteException();
        }
        catch (RemoteException localRemoteException2)
        {
          a(OperationResult.a(ErrorCode.ORCA_SERVICE_IPC_FAILURE, "OrcaService.<method> or registerCompletionHandler failed"));
        }
      }
    label113: label119: 
    do
      while (true)
      {
        return;
        bool2 = false;
        break;
        bool3 = false;
        break label37;
        bool1 = false;
        break label51;
        i();
        this.o = OrcaServiceOperationFactory.OrcaServiceOperation.State.OPERATION_QUEUED;
      }
    while (this.o != OrcaServiceOperationFactory.OrcaServiceOperation.State.OPERATION_QUEUED);
    if (this.p != null);
    while (true)
    {
      while (true)
      {
        Preconditions.checkState(bool1, "null operation id");
        if (this.r)
          break;
        try
        {
          i();
        }
        catch (RemoteException localRemoteException1)
        {
          a(OperationResult.a(ErrorCode.ORCA_SERVICE_IPC_FAILURE, "OrcaService.registerCompletionHandler failed"));
        }
      }
      break;
      bool1 = false;
    }
  }

  private void i()
  {
    if (this.l.a(this.p, new OrcaServiceOperationFactory.OrcaServiceOperation.3(this)))
      this.r = true;
    while (true)
    {
      return;
      a(OperationResult.a(ErrorCode.ORCA_SERVICE_IPC_FAILURE, "Unknown operation: " + this.p));
    }
  }

  private void j()
  {
    if (this.n != null)
      this.n.a();
  }

  private void k()
  {
    if (this.n != null)
      this.n.b();
  }

  public void a()
  {
    this.s.a();
  }

  public void a(OperationProgressIndicator paramOperationProgressIndicator)
  {
    if ((this.o == OrcaServiceOperationFactory.OrcaServiceOperation.State.READY_TO_QUEUE) || (this.o == OrcaServiceOperationFactory.OrcaServiceOperation.State.OPERATION_QUEUED))
      k();
    this.n = paramOperationProgressIndicator;
    if ((this.o == OrcaServiceOperationFactory.OrcaServiceOperation.State.READY_TO_QUEUE) || (this.o == OrcaServiceOperationFactory.OrcaServiceOperation.State.OPERATION_QUEUED))
      j();
  }

  public void a(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }

  public boolean b()
  {
    return this.s.c();
  }

  public boolean c()
  {
    if ((this.o != OrcaServiceOperationFactory.OrcaServiceOperation.State.INIT) && (this.o != OrcaServiceOperationFactory.OrcaServiceOperation.State.COMPLETED));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public ListenableFuture<OperationResult> d()
  {
    if (this.o == OrcaServiceOperationFactory.OrcaServiceOperation.State.INIT);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool, "Incorrect operation state");
      this.o = OrcaServiceOperationFactory.OrcaServiceOperation.State.READY_TO_QUEUE;
      if (Looper.myLooper() != null)
        this.k = new Handler();
      j();
      g();
      return this.j;
    }
  }

  public ListenableFuture<OperationResult> e()
  {
    if (this.o == OrcaServiceOperationFactory.OrcaServiceOperation.State.INIT);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool, "Incorrect operation state");
      this.o = OrcaServiceOperationFactory.OrcaServiceOperation.State.READY_TO_QUEUE;
      this.k = new Handler(Looper.getMainLooper());
      j();
      a(new OrcaServiceOperationFactory.OrcaServiceOperation.2(this));
      return this.j;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation
 * JD-Core Version:    0.6.0
 */