package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.katana.Constants.URL;
import java.util.Map;

public class FqlQuery extends ApiMethod
{
  public FqlQuery(Context paramContext, Intent paramIntent, String paramString1, String paramString2, ServiceOperationListener paramServiceOperationListener)
  {
    super(paramContext, paramIntent, "GET", "fql.query", Constants.URL.c(paramContext), paramServiceOperationListener);
    this.e.put("call_id", "" + System.currentTimeMillis());
    this.e.put("query", paramString2);
    if (paramString1 != null)
      this.e.put("session_key", paramString1);
  }

  public String i()
  {
    return (String)this.e.get("query");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlQuery
 * JD-Core Version:    0.6.0
 */