package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.facebook.debug.Assert;
import com.google.common.base.Preconditions;

public abstract class ServiceOperation
{
  protected static final Handler n = new Handler(Looper.getMainLooper());
  protected final Context o;
  protected Intent p;
  protected ServiceOperationListener q;

  public ServiceOperation(Context paramContext, Intent paramIntent, ServiceOperationListener paramServiceOperationListener)
  {
    this.o = ((Context)Preconditions.checkNotNull(paramContext));
    this.p = paramIntent;
    this.q = paramServiceOperationListener;
  }

  public final void a(Intent paramIntent, ServiceOperationListener paramServiceOperationListener)
  {
    boolean bool1 = true;
    boolean bool2;
    if ((this.p == null) && (this.q == null))
    {
      bool2 = bool1;
      Assert.b(bool2);
      if ((paramIntent == null) || (paramServiceOperationListener == null))
        break label53;
    }
    while (true)
    {
      Assert.b(bool1);
      this.p = paramIntent;
      this.q = paramServiceOperationListener;
      return;
      bool2 = false;
      break;
      label53: bool1 = false;
    }
  }

  protected void a(ServiceOperation paramServiceOperation, int paramInt, String paramString, Exception paramException)
  {
    this.q.a_(paramServiceOperation, paramInt, paramString, paramException);
  }

  public abstract void a(boolean paramBoolean);

  public abstract void b();

  public Intent o()
  {
    return this.p;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.ServiceOperation
 * JD-Core Version:    0.6.0
 */