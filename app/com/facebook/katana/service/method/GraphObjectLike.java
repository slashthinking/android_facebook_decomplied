package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookSessionInfo;
import java.util.Iterator;
import java.util.Set;

public class GraphObjectLike extends GraphApiMethod
  implements ApiMethodCallback
{
  private final String a;
  private final GraphObjectLike.Operation f;

  private GraphObjectLike(Context paramContext, String paramString1, GraphObjectLike.Operation paramOperation, String paramString2, String paramString3, String paramString4)
  {
  }

  public static String a(Context paramContext, GraphObjectLike.Operation paramOperation, Long paramLong)
  {
    return a(paramContext, paramOperation, paramLong.toString());
  }

  public static String a(Context paramContext, GraphObjectLike.Operation paramOperation, String paramString)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    String str = Constants.URL.d(paramContext) + paramString + "/";
    return localAppSession.a(paramContext, new GraphObjectLike(paramContext, localAppSession.b().oAuthToken, paramOperation, "likes", str, paramString), 1001, 1020, null);
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    Iterator localIterator = paramAppSession.d().iterator();
    while (localIterator.hasNext())
      ((AppSessionListener)localIterator.next()).a(paramAppSession, paramString1, paramInt, paramString2, paramException, this.a, this.f);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.GraphObjectLike
 * JD-Core Version:    0.6.0
 */