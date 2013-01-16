package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.features.faceweb.FacewebComponentsStore;
import com.facebook.katana.model.FacebookSessionInfo;
import com.fasterxml.jackson.core.JsonParser;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FacewebComponentsStoreFetcher extends ApiMethod
  implements ApiMethodCallback
{
  private FacewebComponentsStore a;

  public FacewebComponentsStoreFetcher(Context paramContext, Intent paramIntent, String paramString)
  {
    super(paramContext, paramIntent, "GET", "fwcomponents.get", Constants.URL.b(paramContext), null);
    this.e.put("session_key", paramString);
    this.e.put("call_id", "" + System.currentTimeMillis());
  }

  public static void a(Context paramContext)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    if (localAppSession == null);
    while (true)
    {
      return;
      localAppSession.a(paramContext, new FacewebComponentsStoreFetcher(paramContext, null, localAppSession.b().sessionKey), 1001, 1020, null);
    }
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    Iterator localIterator = paramAppSession.d().iterator();
    while (localIterator.hasNext())
      ((AppSessionListener)localIterator.next()).a(paramAppSession, paramString1, paramInt, paramString2, paramException, this.a);
  }

  protected void a(JsonParser paramJsonParser)
  {
    this.a = FacewebComponentsStore.a(paramJsonParser);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FacewebComponentsStoreFetcher
 * JD-Core Version:    0.6.0
 */