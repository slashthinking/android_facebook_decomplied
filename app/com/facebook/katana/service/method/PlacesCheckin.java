package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.common.json.jsonmirror.types.JMBase;
import com.facebook.hardware.WifiDiagnosticsSerializer;
import com.facebook.ipc.katana.model.FacebookPlace;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.katana.model.FacebookApiException;
import com.facebook.orca.inject.FbInjector;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class PlacesCheckin extends ApiMethod
{
  private static final Class<?> j;
  public FacebookPlace a;
  public Location b;
  public String f;
  public Set<Long> g;
  protected long h;

  static
  {
    if (!PlacesCheckin.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      i = bool;
      j = PlacesCheckin.class;
      return;
    }
  }

  public PlacesCheckin(Context paramContext, Intent paramIntent, String paramString1, ServiceOperationListener paramServiceOperationListener, FacebookPlace paramFacebookPlace, Location paramLocation, String paramString2, Set<Long> paramSet, String paramString3)
  {
    super(paramContext, paramIntent, "GET", "places.checkin", Constants.URL.b(paramContext), paramServiceOperationListener);
    WifiDiagnosticsSerializer localWifiDiagnosticsSerializer = (WifiDiagnosticsSerializer)FbInjector.a(paramContext).a(WifiDiagnosticsSerializer.class);
    this.e.put("call_id", "" + System.currentTimeMillis());
    this.e.put("session_key", paramString1);
    this.e.put("page_id", Long.toString(paramFacebookPlace.mPageId));
    this.e.put("coords", a(paramLocation));
    if (paramString2 != null)
      this.e.put("message", paramString2);
    if ((paramSet != null) && (paramSet.size() != 0))
      this.e.put("tagged_uids", new JSONArray(paramSet).toString());
    if (paramString3 != null)
      this.e.put("privacy", new JSONObject(paramString3).toString());
    if (Gatekeeper.a(paramContext, "android_checkin_log_wifi") == Boolean.TRUE)
    {
      JsonNode localJsonNode = localWifiDiagnosticsSerializer.a();
      if (localJsonNode != null)
        this.e.put("wifi", localJsonNode.toString());
    }
    this.a = paramFacebookPlace;
    if ((!i) && (paramFacebookPlace.a() == null))
      throw new AssertionError();
    this.b = paramLocation;
    this.f = paramString2;
    this.g = paramSet;
    this.h = -1L;
  }

  protected String a(Location paramLocation)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("latitude", paramLocation.getLatitude());
    localJSONObject.put("longitude", paramLocation.getLongitude());
    if (paramLocation.hasAccuracy())
      localJSONObject.put("accuracy", paramLocation.getAccuracy());
    if (paramLocation.hasAltitude())
      localJSONObject.put("altitude", paramLocation.getAltitude());
    if (paramLocation.hasBearing())
      localJSONObject.put("heading", paramLocation.getBearing());
    if (paramLocation.hasSpeed())
      localJSONObject.put("speed", paramLocation.getSpeed());
    return localJSONObject.toString();
  }

  protected void a(JsonParser paramJsonParser)
  {
    if (paramJsonParser.getCurrentToken() == JsonToken.START_OBJECT)
      throw new FacebookApiException(paramJsonParser);
    Object localObject = JMParser.a(paramJsonParser, JMBase.c);
    if ((localObject != null) && ((localObject instanceof Long)))
    {
      this.h = ((Long)localObject).longValue();
      return;
    }
    throw new FacebookApiException(-1, "unexpected value in response");
  }

  public long g()
  {
    return this.h;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.PlacesCheckin
 * JD-Core Version:    0.6.0
 */