package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.ipc.katana.model.FacebookPlace;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookSessionInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;

public class PlacesFlag extends ApiMethod
  implements ApiMethodCallback
{
  public List<FacebookPlace> a;
  protected PlacesFlag.FlagType b;

  public PlacesFlag(Context paramContext, Intent paramIntent, String paramString, ServiceOperationListener paramServiceOperationListener, List<FacebookPlace> paramList, PlacesFlag.FlagType paramFlagType)
  {
    super(paramContext, paramIntent, "GET", "places.setFlag", Constants.URL.b(paramContext), paramServiceOperationListener);
    this.a = paramList;
    this.b = paramFlagType;
    this.e.put("call_id", "" + System.currentTimeMillis());
    this.e.put("session_key", paramString);
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      localJSONArray.put(((FacebookPlace)localIterator.next()).mPageId);
    this.e.put("page_ids", localJSONArray.toString());
    this.e.put("flag", this.b.mArgVal);
    this.e.put("value", "1");
  }

  public static String a(AppSession paramAppSession, Context paramContext, List<FacebookPlace> paramList, PlacesFlag.FlagType paramFlagType)
  {
    return paramAppSession.a(paramContext, new PlacesFlag(paramContext, null, paramAppSession.b().sessionKey, null, paramList, paramFlagType), 1001, 505, null);
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    switch (paramIntent.getIntExtra("extended_type", -1))
    {
    default:
    case 505:
    }
    while (true)
    {
      return;
      Iterator localIterator = paramAppSession.d().iterator();
      while (localIterator.hasNext())
        ((AppSessionListener)localIterator.next()).g(paramAppSession, paramString1, paramInt, paramString2, paramException);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.PlacesFlag
 * JD-Core Version:    0.6.0
 */