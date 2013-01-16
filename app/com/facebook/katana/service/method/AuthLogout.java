package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.katana.Constants.URL;
import java.util.Map;

public class AuthLogout extends ApiMethod
{
  public AuthLogout(Context paramContext, Intent paramIntent, String paramString1, ServiceOperationListener paramServiceOperationListener, String paramString2)
  {
    super(paramContext, paramIntent, "GET", "auth.logout", Constants.URL.b(paramContext), null);
    this.q = paramServiceOperationListener;
    this.e.put("call_id", Long.toString(System.currentTimeMillis()));
    this.e.put("session_key", paramString1);
    this.e.put("reason", paramString2);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.AuthLogout
 * JD-Core Version:    0.6.0
 */