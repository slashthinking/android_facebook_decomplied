package com.facebook.orca.server.handlers;

import android.os.Bundle;

public class ApiMethodServiceHandler$BaseParamGetter<P>
  implements ApiMethodServiceHandler.ParamGetter<P>
{
  private final String a;

  public ApiMethodServiceHandler$BaseParamGetter(String paramString)
  {
    this.a = paramString;
  }

  public P b(Bundle paramBundle)
  {
    return paramBundle.get(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.handlers.ApiMethodServiceHandler.BaseParamGetter
 * JD-Core Version:    0.6.0
 */