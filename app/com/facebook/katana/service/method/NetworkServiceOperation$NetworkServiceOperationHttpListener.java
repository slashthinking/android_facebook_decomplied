package com.facebook.katana.service.method;

import com.facebook.common.util.Log;
import com.facebook.debug.Assert;
import com.facebook.katana.model.FacebookApiException;
import com.facebook.katana.net.HttpOperation;
import com.facebook.katana.net.HttpOperation.HttpOperationListener;
import com.facebook.katana.net.HttpOperation.ResponseInputStream;

public class NetworkServiceOperation$NetworkServiceOperationHttpListener
  implements HttpOperation.HttpOperationListener
{
  protected NetworkServiceOperation$NetworkServiceOperationHttpListener(NetworkServiceOperation paramNetworkServiceOperation)
  {
  }

  public void a(HttpOperation paramHttpOperation, int paramInt, String paramString, HttpOperation.ResponseInputStream paramResponseInputStream, Exception paramException)
  {
    if ((paramInt == 200) && (paramException == null))
      Assert.a(paramResponseInputStream);
    while (true)
    {
      try
      {
        this.a.a(paramResponseInputStream);
        this.a.a(paramInt, paramString, paramException);
        return;
      }
      catch (FacebookApiException paramException)
      {
        Log.a("NetworkServiceOperationHttpListener.onHttpOperationComplete", "FacebookApiException: " + paramException.a() + "/" + paramException.b());
        paramInt = 0;
        paramString = null;
        continue;
      }
      catch (Exception paramException)
      {
        paramException.printStackTrace();
        paramInt = 0;
        paramString = null;
        continue;
      }
      Log.a(NetworkServiceOperation.class.getSimpleName(), "There was an error in the NetworkService operation: " + paramString);
    }
  }

  public void a(HttpOperation paramHttpOperation, long paramLong1, long paramLong2)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.NetworkServiceOperation.NetworkServiceOperationHttpListener
 * JD-Core Version:    0.6.0
 */