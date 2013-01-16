package com.facebook.katana.service.method;

import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.provider.KeyValueManager;
import com.facebook.katana.util.StringUtils;
import java.util.Map;

class AuthLogin$LoginListener
  implements ServiceOperationListener
{
  private AuthLogin$LoginListener(AuthLogin paramAuthLogin)
  {
  }

  public void a(ServiceOperation paramServiceOperation, long paramLong1, long paramLong2)
  {
  }

  public void a_(ServiceOperation paramServiceOperation, int paramInt, String paramString, Exception paramException)
  {
    new AuthLogin.ClearAccountDataTask(this.a, (String)this.a.e.get("email"), paramInt, paramString, paramException).c();
  }

  public void b(ServiceOperation paramServiceOperation, int paramInt, String paramString, Exception paramException)
  {
    FacebookSessionInfo localFacebookSessionInfo;
    if (paramInt == 200)
    {
      localFacebookSessionInfo = this.a.g();
      if (localFacebookSessionInfo != null)
        break label22;
    }
    while (true)
    {
      return;
      label22: String str = localFacebookSessionInfo.machineID;
      if (StringUtils.c(str))
        continue;
      KeyValueManager.a(this.a.o, "machine_id", str);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.AuthLogin.LoginListener
 * JD-Core Version:    0.6.0
 */