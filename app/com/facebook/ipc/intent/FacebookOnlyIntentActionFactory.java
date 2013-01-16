package com.facebook.ipc.intent;

import com.facebook.orca.common.util.StringLocaleUtil;

public class FacebookOnlyIntentActionFactory
{
  private final String a;

  public FacebookOnlyIntentActionFactory(String paramString)
  {
    this.a = paramString;
  }

  public String a(String paramString)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.a;
    arrayOfObject[1] = paramString;
    return StringLocaleUtil.a("com.facebook.%s.intent.action.%s", arrayOfObject);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.ipc.intent.FacebookOnlyIntentActionFactory
 * JD-Core Version:    0.6.0
 */