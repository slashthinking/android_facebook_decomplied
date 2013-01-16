package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.common.json.jsonmirror.types.JMBase;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.FacebookSessionInfo;
import com.fasterxml.jackson.core.JsonParser;
import java.util.Map;

public class MarkJewelSeen extends GraphApiMethod
  implements ApiMethodCallback
{
  protected boolean a;

  private MarkJewelSeen(Context paramContext, String paramString, long paramLong, MarkJewelSeen.Jewel paramJewel)
  {
    super(paramContext, paramString, "POST", paramLong + "/" + a(paramJewel), Constants.URL.d(paramContext));
    this.e.put("seen", "true");
  }

  public static String a(Context paramContext, MarkJewelSeen.Jewel paramJewel)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    String str = null;
    if (localAppSession == null);
    while (true)
    {
      return str;
      str = localAppSession.a(paramContext, new MarkJewelSeen(paramContext, localAppSession.b().oAuthToken, localAppSession.b().userId, paramJewel), 1001, 1020, null);
    }
  }

  private static String a(MarkJewelSeen.Jewel paramJewel)
  {
    String str;
    switch (MarkJewelSeen.1.a[paramJewel.ordinal()])
    {
    default:
      throw new RuntimeException("Impossible exception: invalid jewel type.");
    case 1:
      str = "inbox";
    case 2:
    case 3:
    }
    while (true)
    {
      return str;
      str = "friendrequests";
      continue;
      str = "notifications";
    }
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
  }

  protected void a(JsonParser paramJsonParser)
  {
    Object localObject = JMParser.a(paramJsonParser, JMBase.b);
    if ((localObject != null) && ((localObject instanceof Boolean)))
      this.a = ((Boolean)localObject).booleanValue();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.MarkJewelSeen
 * JD-Core Version:    0.6.0
 */