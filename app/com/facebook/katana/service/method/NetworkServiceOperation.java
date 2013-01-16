package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.facebook.katana.net.HttpOperation;
import com.facebook.katana.net.HttpOperation.HttpOperationListener;
import com.facebook.katana.net.HttpOperation.ResponseInputStream;

public abstract class NetworkServiceOperation extends ServiceOperation
{
  private boolean a;
  protected final String k;
  protected HttpOperation l;
  protected HttpOperation.HttpOperationListener m;

  public NetworkServiceOperation(Context paramContext, Intent paramIntent, String paramString, ServiceOperationListener paramServiceOperationListener)
  {
    super(paramContext, paramIntent, paramServiceOperationListener);
    this.k = paramString;
    this.a = true;
  }

  protected void a(int paramInt, String paramString, Exception paramException)
  {
    if (this.q != null)
    {
      this.q.b(this, paramInt, paramString, paramException);
      if (!n())
        break label50;
      NetworkServiceOperation.1 local1 = new NetworkServiceOperation.1(this, paramInt, paramString, paramException);
      n.post(local1);
    }
    while (true)
    {
      return;
      label50: if (this.l != null)
      {
        this.l = null;
        a(this, paramInt, paramString, paramException);
        continue;
      }
    }
  }

  protected abstract void a(HttpOperation.ResponseInputStream paramResponseInputStream);

  protected boolean n()
  {
    return this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.NetworkServiceOperation
 * JD-Core Version:    0.6.0
 */