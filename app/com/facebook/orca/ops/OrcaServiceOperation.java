package com.facebook.orca.ops;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
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
import java.util.Map;

public class OrcaServiceOperation
{
  public static final Map<Object, String> a;
  private static final Class<?> b = OrcaServiceOperation.class;
  private static final WtfToken c = new WtfToken();
  private final Context d;
  private final OrcaServiceRegistry e;
  private final OrcaServiceOperation.OrcaServiceConnection f;
  private final AndroidThreadUtil g;
  private Handler h;
  private IOrcaService i;
  private OrcaServiceOperation.OnCompletedListener j;
  private OrcaServiceOperation.OnProgressListener k;
  private boolean l;
  private boolean m;
  private boolean n;
  private OperationProgressIndicator o;
  private OrcaServiceOperation.State p = OrcaServiceOperation.State.INIT;
  private String q;
  private Bundle r;
  private String s;
  private boolean t;
  private boolean u;
  private boolean v;

  static
  {
    a = Maps.c();
  }

  public OrcaServiceOperation(Context paramContext, OrcaServiceRegistry paramOrcaServiceRegistry, AndroidThreadUtil paramAndroidThreadUtil)
  {
    this.d = paramContext;
    this.f = new OrcaServiceOperation.OrcaServiceConnection(this, null);
    this.e = paramOrcaServiceRegistry;
    this.g = paramAndroidThreadUtil;
  }

  private void a(ServiceException paramServiceException)
  {
    this.p = OrcaServiceOperation.State.COMPLETED;
    this.s = null;
    j();
    boolean bool1 = this.d instanceof FbActivityish;
    boolean bool2 = false;
    if (bool1)
      bool2 = ((FbActivityish)this.d).a(paramServiceException);
    if (this.l)
      d();
    if ((!bool2) && (this.j != null))
      this.j.a(paramServiceException);
    if (this.m)
      a();
  }

  private void a(OperationResult paramOperationResult)
  {
    if (this.n)
      a();
    while (true)
    {
      return;
      a(new OrcaServiceOperation.2(this, paramOperationResult));
    }
  }

  private void a(Runnable paramRunnable)
  {
    if (this.h != null)
      this.h.post(paramRunnable);
    while (true)
    {
      return;
      this.g.c(paramRunnable);
    }
  }

  private void b(OperationResult paramOperationResult)
  {
    if (this.k != null)
      this.k.a(paramOperationResult);
  }

  private void c(OperationResult paramOperationResult)
  {
    if (paramOperationResult.c())
      d(paramOperationResult);
    while (true)
    {
      return;
      a(new ServiceException(paramOperationResult));
    }
  }

  private void d(OperationResult paramOperationResult)
  {
    this.p = OrcaServiceOperation.State.COMPLETED;
    this.s = null;
    j();
    if (this.l)
      d();
    if (this.j != null)
      this.j.a(paramOperationResult);
    if (this.m)
      a();
  }

  private void e()
  {
    if (this.t);
    try
    {
      this.d.unbindService(this.f);
      this.t = false;
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (true)
        BLog.a(c, b, "Exception unbinding " + this.q, localIllegalArgumentException);
    }
  }

  private void f()
  {
    if (this.i != null)
      g();
    while (true)
    {
      return;
      if (!this.t)
      {
        Class localClass = this.e.b(this.q);
        if (localClass == null)
        {
          a(OperationResult.a(ErrorCode.ORCA_SERVICE_IPC_FAILURE, "Unknown operation type"));
          continue;
        }
        Intent localIntent = new Intent(this.d, localClass);
        if (this.d.bindService(localIntent, this.f, 1))
        {
          this.t = true;
          continue;
        }
        a(OperationResult.a(ErrorCode.ORCA_SERVICE_IPC_FAILURE, "Bind to OrcaService failed"));
        continue;
      }
    }
  }

  private void g()
  {
    boolean bool1 = true;
    boolean bool2;
    boolean bool3;
    if (this.p == OrcaServiceOperation.State.READY_TO_QUEUE)
      if (this.q != null)
      {
        bool2 = bool1;
        Preconditions.checkState(bool2, "Null operation type");
        if (this.s != null)
          break label113;
        bool3 = bool1;
        label37: Preconditions.checkState(bool3, "Non-null operation id");
        if (this.u)
          break label119;
        label51: Preconditions.checkState(bool1, "Registered for completion and haven't yet sent");
        try
        {
          this.s = this.i.a(this.q, this.r);
          if (this.i == null)
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
        h();
        this.p = OrcaServiceOperation.State.OPERATION_QUEUED;
      }
    while (this.p != OrcaServiceOperation.State.OPERATION_QUEUED);
    if (this.s != null);
    while (true)
    {
      while (true)
      {
        Preconditions.checkState(bool1, "null operation id");
        if (this.u)
          break;
        try
        {
          h();
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

  private void h()
  {
    if (this.i.a(this.s, new OrcaServiceOperation.1(this)))
      this.u = true;
    while (true)
    {
      return;
      a(OperationResult.a(ErrorCode.ORCA_SERVICE_IPC_FAILURE, "Unknown operation: " + this.s));
    }
  }

  private void i()
  {
    if (this.o != null)
      this.o.a();
  }

  private void j()
  {
    if (this.o != null)
      this.o.b();
  }

  public void a()
  {
    this.v = true;
    e();
    this.i = null;
    this.k = null;
    this.j = null;
    j();
  }

  public void a(Bundle paramBundle)
  {
    paramBundle.putSerializable("operationState", this.p);
    paramBundle.putString("type", this.q);
    paramBundle.putParcelable("param", this.r);
    paramBundle.putString("operationId", this.s);
  }

  public void a(OperationProgressIndicator paramOperationProgressIndicator)
  {
    if ((this.p == OrcaServiceOperation.State.READY_TO_QUEUE) || (this.p == OrcaServiceOperation.State.OPERATION_QUEUED))
      j();
    this.o = paramOperationProgressIndicator;
    if ((this.p == OrcaServiceOperation.State.READY_TO_QUEUE) || (this.p == OrcaServiceOperation.State.OPERATION_QUEUED))
      i();
  }

  public void a(OrcaServiceOperation.OnCompletedListener paramOnCompletedListener)
  {
    this.j = paramOnCompletedListener;
  }

  public void a(OrcaServiceOperation.OnProgressListener paramOnProgressListener)
  {
    this.k = paramOnProgressListener;
  }

  public void a(String paramString, Bundle paramBundle)
  {
    boolean bool1 = true;
    boolean bool2;
    if (this.p == OrcaServiceOperation.State.INIT)
    {
      bool2 = bool1;
      Preconditions.checkState(bool2, "Incorrect operation state");
      if (this.q != null)
        break label94;
    }
    while (true)
    {
      Preconditions.checkState(bool1, "Initially operationType should be null");
      Preconditions.checkNotNull(paramString, "non-null operationType");
      this.p = OrcaServiceOperation.State.READY_TO_QUEUE;
      this.q = paramString;
      this.r = paramBundle;
      if (Looper.myLooper() != null)
        this.h = new Handler();
      i();
      f();
      return;
      bool2 = false;
      break;
      label94: bool1 = false;
    }
  }

  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }

  public void b(Bundle paramBundle)
  {
    this.p = ((OrcaServiceOperation.State)paramBundle.getSerializable("operationState"));
    this.r = ((Bundle)paramBundle.getParcelable("param"));
    this.q = paramBundle.getString("type");
    this.s = paramBundle.getString("operationId");
    if (Looper.myLooper() != null)
      this.h = new Handler();
    if (this.p == OrcaServiceOperation.State.INIT);
    while (true)
    {
      return;
      if (this.p == OrcaServiceOperation.State.READY_TO_QUEUE)
      {
        i();
        f();
        continue;
      }
      if (this.p == OrcaServiceOperation.State.OPERATION_QUEUED)
      {
        i();
        f();
        continue;
      }
      if (this.p != OrcaServiceOperation.State.COMPLETED)
        continue;
    }
  }

  public void b(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }

  public boolean b()
  {
    if ((this.p != OrcaServiceOperation.State.INIT) && (this.p != OrcaServiceOperation.State.COMPLETED));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public OrcaServiceOperation.State c()
  {
    return this.p;
  }

  public void c(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }

  public void d()
  {
    if ((this.p == OrcaServiceOperation.State.INIT) || (this.p == OrcaServiceOperation.State.COMPLETED));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool);
      this.p = OrcaServiceOperation.State.INIT;
      this.q = null;
      this.r = null;
      this.s = null;
      this.u = false;
      e();
      this.i = null;
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.ops.OrcaServiceOperation
 * JD-Core Version:    0.6.0
 */