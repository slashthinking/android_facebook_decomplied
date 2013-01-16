package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.common.json.jsonmirror.types.JMBase;
import com.facebook.common.util.Log;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookApiException;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.orca.common.util.LocationUtils;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PlacesCreate extends ApiMethod
  implements ApiMethodCallback
{
  static final Class<?> a = PlacesCreate.class;
  public String b;
  public Location f;
  public List<Long> g;
  protected long h;

  public PlacesCreate(Context paramContext, Intent paramIntent, String paramString1, ServiceOperationListener paramServiceOperationListener, PlacesCreate.PlaceTagType paramPlaceTagType, String paramString2, Location paramLocation, List<Long> paramList1, String paramString3, String paramString4, PlacesCreate.HomePrivacyType paramHomePrivacyType, List<Long> paramList2)
  {
    super(paramContext, paramIntent, "POST", "places.create", Constants.URL.b(paramContext), paramServiceOperationListener);
    this.e.put("call_id", Long.toString(System.currentTimeMillis()));
    this.e.put("session_key", paramString1);
    this.e.put("name", paramString2);
    if (paramPlaceTagType != null)
      this.e.put("type", paramPlaceTagType.apiValue);
    if (paramHomePrivacyType != null)
      this.e.put("privacy", paramHomePrivacyType.apiValue);
    this.e.put("coords", LocationUtils.a(paramLocation));
    this.e.put("topics", a(paramList1));
    this.e.put("override_ids", a(paramList2));
    this.e.put("address", a(paramString3, paramString4));
    this.b = paramString2;
    this.f = paramLocation;
    this.g = paramList2;
    this.h = -1L;
  }

  public static String a(Context paramContext, String paramString1, Location paramLocation, List<Long> paramList1, String paramString2, String paramString3, PlacesCreate.HomePrivacyType paramHomePrivacyType, List<Long> paramList2)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    if (localAppSession == null);
    for (String str = null; ; str = localAppSession.a(paramContext, new PlacesCreate(paramContext, null, localAppSession.b().sessionKey, null, PlacesCreate.PlaceTagType.RESIDENCE, paramString1, paramLocation, paramList1, paramString2, paramString3, paramHomePrivacyType, paramList2), 1001, 0, null))
      return str;
  }

  public static String a(Context paramContext, String paramString1, Location paramLocation, List<Long> paramList1, String paramString2, String paramString3, List<Long> paramList2)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    if (localAppSession == null);
    for (String str = null; ; str = localAppSession.a(paramContext, new PlacesCreate(paramContext, null, localAppSession.b().sessionKey, null, null, paramString1, paramLocation, paramList1, paramString2, paramString3, null, paramList2), 1001, 0, null))
      return str;
  }

  public String a(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("city", paramString1);
      localJSONObject.put("street", paramString2);
      String str2 = localJSONObject.toString();
      str1 = str2;
      return str1;
    }
    catch (JSONException localJSONException)
    {
      while (true)
      {
        Log.a(a, "JSONException when ENCODING data: " + localJSONException.getMessage());
        String str1 = "";
      }
    }
  }

  protected String a(List<Long> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      localJSONArray.put(((Long)localIterator.next()).longValue());
    return localJSONArray.toString();
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    long l = g();
    Iterator localIterator = paramAppSession.d().iterator();
    while (localIterator.hasNext())
      ((AppSessionListener)localIterator.next()).c(paramAppSession, paramString1, paramInt, paramString2, paramException, l);
  }

  protected void a(JsonParser paramJsonParser)
  {
    if (paramJsonParser.getCurrentToken() == JsonToken.START_OBJECT)
      throw new PlacesCreateException(paramJsonParser);
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
 * Qualified Name:     com.facebook.katana.service.method.PlacesCreate
 * JD-Core Version:    0.6.0
 */