package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.FacebookSessionInfo;
import com.fasterxml.jackson.core.JsonParser;
import java.util.List;
import java.util.Map;

public class GraphApiExchangeSession extends GraphApiMethod
  implements ApiMethodCallback
{
  protected String a;

  private GraphApiExchangeSession(Context paramContext, String paramString)
  {
    super(paramContext, "POST", "oauth/exchange_sessions", Constants.URL.d(paramContext));
    this.e.put("sessions", paramString);
    this.e.put("client_id", Long.toString(350685531728L));
    this.e.put("client_secret", "62f8ce9f74b12f84c123cc23437a4a32");
  }

  public static String a(Context paramContext)
  {
    AppSession localAppSession = AppSession.a(paramContext, false);
    return localAppSession.a(paramContext, new GraphApiExchangeSession(paramContext, localAppSession.b().sessionKey), 1001, 1020, null);
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    if (paramInt == 200)
      paramAppSession.a(paramContext, new FacebookSessionInfo(paramAppSession.b(), this.a));
  }

  protected void a(JsonParser paramJsonParser)
  {
    List localList = JMParser.b(paramJsonParser, FacebookSessionInfo.class);
    if (localList.size() == 1)
      this.a = ((FacebookSessionInfo)localList.get(0)).oAuthToken;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.GraphApiExchangeSession
 * JD-Core Version:    0.6.0
 */