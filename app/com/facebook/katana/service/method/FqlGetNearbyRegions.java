package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.model.GeoRegion;
import com.fasterxml.jackson.core.JsonParser;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FqlGetNearbyRegions extends FqlGeneratedQuery
  implements ApiMethodCallback
{
  protected static final String a = FqlGetNearbyRegions.class.getSimpleName();
  public List<GeoRegion> b;

  public FqlGetNearbyRegions(Context paramContext, Intent paramIntent, String paramString1, ServiceOperationListener paramServiceOperationListener, String paramString2)
  {
    super(paramContext, paramIntent, paramString1, paramServiceOperationListener, "geo_region", paramString2, GeoRegion.class);
  }

  public static String a(Context paramContext, String paramString)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    String str = null;
    if (localAppSession == null);
    while (true)
    {
      return str;
      str = localAppSession.a(paramContext, new FqlGetNearbyRegions(paramContext, null, localAppSession.b().sessionKey, null, paramString), 1001, 1020, null);
    }
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    Iterator localIterator = paramAppSession.d().iterator();
    while (localIterator.hasNext())
      ((AppSessionListener)localIterator.next()).a(paramAppSession, paramString1, paramInt, paramString2, paramException, this.b);
  }

  protected void a(JsonParser paramJsonParser)
  {
    this.b = JMParser.b(paramJsonParser, GeoRegion.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlGetNearbyRegions
 * JD-Core Version:    0.6.0
 */