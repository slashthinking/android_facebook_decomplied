package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookGeolocation;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.fasterxml.jackson.core.JsonParser;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FqlGetGeolocations extends FqlGeneratedQuery
  implements ApiMethodCallback
{
  private static final String a = FqlGetGeolocations.class.getSimpleName();
  private FacebookGeolocation b;

  public FqlGetGeolocations(Context paramContext, Intent paramIntent, String paramString, ServiceOperationListener paramServiceOperationListener, Location paramLocation)
  {
    super(paramContext, paramIntent, paramString, paramServiceOperationListener, "geolocation", a(paramLocation.getLatitude(), paramLocation.getLongitude()), FacebookGeolocation.class);
  }

  private static String a(double paramDouble1, double paramDouble2)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Double.valueOf(paramDouble1);
    arrayOfObject[1] = Double.valueOf(paramDouble2);
    return StringLocaleUtil.a("distance(latitude, longitude, \"%f\", \"%f\") > 0", arrayOfObject);
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    Iterator localIterator = paramAppSession.d().iterator();
    while (localIterator.hasNext())
      ((AppSessionListener)localIterator.next()).a(paramAppSession, paramString1, paramInt, paramString2, paramException, this.b);
  }

  protected void a(JsonParser paramJsonParser)
  {
    super.a(paramJsonParser);
    List localList = JMParser.b(paramJsonParser, FacebookGeolocation.class);
    if ((localList != null) && (!localList.isEmpty()))
      this.b = ((FacebookGeolocation)localList.get(0));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlGetGeolocations
 * JD-Core Version:    0.6.0
 */