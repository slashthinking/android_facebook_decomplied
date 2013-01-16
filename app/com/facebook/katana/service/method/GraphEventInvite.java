package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.common.json.jsonmirror.types.JMBase;
import com.facebook.debug.Assert;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookSessionInfo;
import com.fasterxml.jackson.core.JsonParser;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.simple.JSONArray;

public class GraphEventInvite extends GraphApiMethod
  implements ApiMethodCallback
{
  private boolean a = false;
  private long f = -1L;

  public GraphEventInvite(Context paramContext, String paramString, long paramLong, long[] paramArrayOfLong)
  {
    super(paramContext, paramString, "POST", "invited", a(paramContext, paramLong));
    this.f = paramLong;
    JSONArray localJSONArray = new JSONArray();
    int i = paramArrayOfLong.length;
    for (int j = 0; j < i; j++)
      localJSONArray.add(Long.valueOf(paramArrayOfLong[j]));
    this.e.put("users", localJSONArray.toString());
  }

  private static String a(Context paramContext, long paramLong)
  {
    return Constants.URL.d(paramContext) + paramLong + "/";
  }

  public static String a(Context paramContext, long paramLong, long[] paramArrayOfLong)
  {
    boolean bool;
    AppSession localAppSession;
    String str;
    if ((paramArrayOfLong != null) && (paramArrayOfLong.length > 0))
    {
      bool = true;
      Assert.b(bool);
      localAppSession = AppSession.b(paramContext, false);
      str = null;
      if (localAppSession != null)
        break label41;
    }
    while (true)
    {
      return str;
      bool = false;
      break;
      label41: str = localAppSession.a(paramContext, new GraphEventInvite(paramContext, localAppSession.b().oAuthToken, paramLong, paramArrayOfLong), 1001, 1020, null);
    }
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    if (!this.a);
    for (int i = 0; ; i = paramInt)
    {
      Iterator localIterator = paramAppSession.d().iterator();
      while (localIterator.hasNext())
        ((AppSessionListener)localIterator.next()).b(paramAppSession, paramString1, i, paramString2, paramException, this.f);
      return;
    }
  }

  protected void a(JsonParser paramJsonParser)
  {
    Object localObject = JMParser.a(paramJsonParser, JMBase.b);
    if ((localObject != null) && ((localObject instanceof Boolean)))
      this.a = ((Boolean)localObject).booleanValue();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.GraphEventInvite
 * JD-Core Version:    0.6.0
 */