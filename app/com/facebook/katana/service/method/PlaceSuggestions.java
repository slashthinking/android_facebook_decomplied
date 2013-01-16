package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import com.facebook.apache.http.entity.mime.FormBodyPart;
import com.facebook.common.util.Log;
import com.facebook.debug.Assert;
import com.facebook.ipc.katana.model.FacebookPage;
import com.facebook.ipc.katana.model.FacebookPlace;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookPageFull;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.model.PageTopic;
import com.facebook.katana.util.StringUtils;
import com.facebook.orca.entity.mime.content.InputStreamBodyWithSize;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PlaceSuggestions extends GraphApiMethod
  implements ApiMethodCallback
{
  private static final Class<?> a = PlaceSuggestions.class;
  private FacebookPlace f;
  private String g;
  private String h;
  private String i;
  private Location j;
  private Set<PageTopic> r;
  private List<FacebookPlace> s;
  private File t;
  private int u = -1;

  public PlaceSuggestions(Context paramContext, String paramString, FacebookPlace paramFacebookPlace)
  {
    super(paramContext, paramString, "POST", "suggestions", Constants.URL.d(paramContext) + paramFacebookPlace.mPageId + "/");
    this.f = paramFacebookPlace;
  }

  public static PlaceSuggestions a(Context paramContext, FacebookPlace paramFacebookPlace)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    if (localAppSession == null);
    for (PlaceSuggestions localPlaceSuggestions = null; ; localPlaceSuggestions = new PlaceSuggestions(paramContext, localAppSession.b().oAuthToken, paramFacebookPlace))
      return localPlaceSuggestions;
  }

  public PlaceSuggestions a(Location paramLocation)
  {
    this.j = paramLocation;
    return this;
  }

  public PlaceSuggestions a(List<FacebookPlace> paramList)
  {
    if (paramList == null);
    while (true)
    {
      return this;
      this.s = paramList;
    }
  }

  public PlaceSuggestions a(Set<PageTopic> paramSet)
  {
    if (paramSet == null)
      return this;
    FacebookPage localFacebookPage = this.f.a();
    if ((localFacebookPage == null) || ((localFacebookPage instanceof FacebookPageFull)));
    for (boolean bool = true; ; bool = false)
    {
      Assert.b("Topics are only supported for FacebookPageFull", bool);
      this.r = paramSet;
      break;
    }
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    Iterator localIterator = paramAppSession.d().iterator();
    while (localIterator.hasNext())
      ((AppSessionListener)localIterator.next()).b(paramAppSession, paramString1, paramInt, paramString2, paramException, this.u);
  }

  public boolean a(File paramFile)
  {
    int k = 0;
    if (paramFile == null);
    while (true)
    {
      return k;
      this.t = paramFile;
      String str = StringUtils.a(8) + ".jpg";
      try
      {
        FileInputStream localFileInputStream = new FileInputStream(this.t);
        this.b.add(new FormBodyPart("media", new InputStreamBodyWithSize(localFileInputStream, "image/jpeg", str, paramFile.length())));
        this.m = new PlaceSuggestions.PlacePictureUploadHttpListener(this);
        k = 1;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        k = 0;
      }
    }
  }

  public PlaceSuggestions e(String paramString)
  {
    if (paramString == null);
    while (true)
    {
      return this;
      this.g = paramString.trim();
    }
  }

  public PlaceSuggestions f(String paramString)
  {
    if (paramString == null);
    while (true)
    {
      return this;
      this.h = paramString.trim();
    }
  }

  public PlaceSuggestions g(String paramString)
  {
    if (paramString == null);
    while (true)
    {
      return this;
      this.i = paramString.trim();
    }
  }

  public String i()
  {
    if (this.g != null)
      this.e.put("name", this.g);
    for (int k = 1; ; k = 0)
    {
      JSONObject localJSONObject1;
      if (this.h != null)
        localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2;
      try
      {
        localJSONObject1.put("address", this.h);
        this.e.put("location", localJSONObject1.toString());
        k = 1;
        if (this.i != null)
        {
          this.e.put("phone", this.i);
          k = 1;
        }
        if (this.r != null)
        {
          localJSONArray1 = new JSONArray();
          Iterator localIterator1 = this.r.iterator();
          while (localIterator1.hasNext())
            localJSONArray1.put(((PageTopic)localIterator1.next()).id);
        }
      }
      catch (JSONException localJSONException1)
      {
        JSONArray localJSONArray1;
        while (true)
          Log.a(a, "JSONException on encoding");
        this.e.put("categories", localJSONArray1.toString());
        k = 1;
        if ((this.s != null) && (this.s.size() > 0))
        {
          JSONArray localJSONArray2 = new JSONArray();
          Iterator localIterator2 = this.s.iterator();
          while (localIterator2.hasNext())
            localJSONArray2.put(((FacebookPlace)localIterator2.next()).mPageId);
          this.e.put("duplicates", localJSONArray2.toString());
          k = 1;
        }
        if (this.j != null)
          localJSONObject2 = new JSONObject();
      }
      try
      {
        localJSONObject2.put("latitude", this.j.getLatitude());
        localJSONObject2.put("longitude", this.j.getLongitude());
        this.e.put("coordinates", localJSONObject2.toString());
        k = 1;
        str = null;
        if (k == 0)
          return str;
      }
      catch (JSONException localJSONException2)
      {
        while (true)
        {
          Log.a(a, "JSONException on encoding");
          continue;
          AppSession localAppSession = AppSession.b(this.o, false);
          if (localAppSession == null)
          {
            Log.a(a, "null AppSession, could not save suggestions");
            str = null;
            continue;
          }
          String str = localAppSession.a(this.o, this, 1001, 1020, null);
        }
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.PlaceSuggestions
 * JD-Core Version:    0.6.0
 */