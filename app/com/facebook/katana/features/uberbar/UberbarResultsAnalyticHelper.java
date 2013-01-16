package com.facebook.katana.features.uberbar;

import com.facebook.analytics.HoneyClientEvent;
import com.facebook.analytics.InteractionLogger;
import com.facebook.ipc.data.uberbar.UberbarResult;
import com.facebook.ipc.data.uberbar.UberbarResult.Type;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.Modules;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UberbarResultsAnalyticHelper
{
  private String a;
  private InteractionLogger b;

  public UberbarResultsAnalyticHelper(InteractionLogger paramInteractionLogger)
  {
    this.b = paramInteractionLogger;
  }

  private HoneyClientEvent a(String paramString, UberbarResult paramUberbarResult)
  {
    return c(paramString).g(String.valueOf(paramUberbarResult.i)).b("result", a(paramUberbarResult).toString());
  }

  private HoneyClientEvent a(String paramString1, UberbarResult paramUberbarResult, String paramString2)
  {
    return a(paramString1, paramUberbarResult).b("query", paramString2);
  }

  private HoneyClientEvent a(String paramString1, UberbarResult paramUberbarResult, String paramString2, List<UberbarResult> paramList)
  {
    return a(paramString1, paramUberbarResult, paramString2, paramList, paramList.indexOf(paramUberbarResult));
  }

  private HoneyClientEvent a(String paramString1, UberbarResult paramUberbarResult, String paramString2, List<UberbarResult> paramList, int paramInt)
  {
    return a(paramString1, paramUberbarResult, paramString2).b("allResults", a(paramList)).b("resultPosition", String.valueOf(paramInt));
  }

  private HoneyClientEvent a(String paramString1, String paramString2)
  {
    return c(paramString1).b("query", paramString2);
  }

  private String a(List<UberbarResult> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      localJSONArray.put(a((UberbarResult)localIterator.next()));
    return localJSONArray.toString();
  }

  private JSONObject a(UberbarResult paramUberbarResult)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("fbid", paramUberbarResult.i);
      localJSONObject.put("type", paramUberbarResult.h.toString());
      label33: return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      break label33;
    }
  }

  private HoneyClientEvent c(String paramString)
  {
    HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent(paramString).d(FB4A_AnalyticEntities.Modules.h);
    if (this.a != null)
      localHoneyClientEvent.b("sessionID", this.a);
    return localHoneyClientEvent;
  }

  public void a()
  {
    this.a = UUID.randomUUID().toString();
    this.b.b(c("session_started"));
  }

  public void a(UberbarResult paramUberbarResult, String paramString, int paramInt, List<UberbarResult> paramList)
  {
    HoneyClientEvent localHoneyClientEvent = a("click", paramUberbarResult, paramString, paramList, paramInt);
    this.b.b(localHoneyClientEvent);
  }

  public void a(UberbarResult paramUberbarResult, String paramString, List<UberbarResult> paramList)
  {
    HoneyClientEvent localHoneyClientEvent = a("friend_request", paramUberbarResult, paramString, paramList);
    this.b.b(localHoneyClientEvent);
  }

  public void a(String paramString)
  {
    if (this.a == null);
    while (true)
    {
      return;
      this.b.b(a("session_end", paramString));
      this.a = null;
    }
  }

  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    HoneyClientEvent localHoneyClientEvent = a("search_edit", paramString).a("start", paramInt1).a("count", paramInt2).a("after", paramInt3);
    this.b.b(localHoneyClientEvent);
  }

  public void b(UberbarResult paramUberbarResult, String paramString, List<UberbarResult> paramList)
  {
    HoneyClientEvent localHoneyClientEvent = a("call_quick_action", paramUberbarResult, paramString, paramList);
    this.b.b(localHoneyClientEvent);
  }

  public void b(String paramString)
  {
    HoneyClientEvent localHoneyClientEvent = a("search_clear", paramString);
    this.b.b(localHoneyClientEvent);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.uberbar.UberbarResultsAnalyticHelper
 * JD-Core Version:    0.6.0
 */