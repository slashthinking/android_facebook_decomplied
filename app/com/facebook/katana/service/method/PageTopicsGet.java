package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.UserAgent;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.binding.ManagedDataStore;
import com.facebook.katana.binding.ManagedDataStore.Mode;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.model.PageTopic;
import com.facebook.katana.net.HttpOperation.ResponseInputStream;
import com.facebook.katana.provider.KeyValueManager;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;

public class PageTopicsGet extends GraphApiMethod
  implements ApiMethodCallback
{
  private static final Class<?> a = PageTopicsGet.class;
  private static PageTopicsGet.PageTopicsManagedStoreClient f;
  private static ManagedDataStore<String, List<PageTopic>> g;
  private static final long[] h = { 133436743388217L, 188662441155211L, 192119584190796L, 165679780146824L, 197289820310880L, 354275401259620L, 272705352802676L, 176831012360626L, 192049437499122L, 200600219953504L, 128232937246338L };
  private static final long[] i = { 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L };
  private static final int[] j = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
  private static List<PageTopic> r = null;
  private static String[] s = null;

  private PageTopicsGet(Context paramContext, String paramString, long paramLong)
  {
    super(paramContext, paramString, "GET", "search", Constants.URL.d(paramContext));
    this.e.put("locale", UserAgent.e(this.o));
    this.e.put("type", "placetopic");
    this.e.put("topic_filter", "all");
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put("id");
    localJSONArray.put("parent_ids");
    localJSONArray.put("name");
    localJSONArray.put("count");
    this.e.put("fields", localJSONArray.toString());
    this.e.put("topics_version", String.valueOf(paramLong));
  }

  private static String a(Context paramContext, long paramLong)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    String str = null;
    if (localAppSession == null);
    while (true)
    {
      return str;
      str = localAppSession.a(paramContext, new PageTopicsGet(paramContext, localAppSession.b().oAuthToken, paramLong), 1001, 1020, null);
    }
  }

  public static List<PageTopic> a(Context paramContext)
  {
    List localList = (List)d(paramContext).a("page_topics");
    if ((localList == null) || (localList.size() == 0) || (e(paramContext)))
      localList = f(paramContext);
    return localList;
  }

  public static String b(Context paramContext)
  {
    return a(paramContext, -1L);
  }

  public static void c(Context paramContext)
  {
    if (e(paramContext))
      b(paramContext);
    while (true)
    {
      return;
      a(paramContext, KeyValueManager.a(paramContext, "page_topic_version", 0L));
    }
  }

  private static ManagedDataStore<String, List<PageTopic>> d(Context paramContext)
  {
    monitorenter;
    try
    {
      if (g == null)
      {
        f = new PageTopicsGet.PageTopicsManagedStoreClient();
        g = new ManagedDataStore(f, ManagedDataStore.Mode.SINGLE_REQUEST, paramContext);
      }
      ManagedDataStore localManagedDataStore = g;
      monitorexit;
      return localManagedDataStore;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  private static boolean e(Context paramContext)
  {
    if (!KeyValueManager.a(paramContext, "page_topic_locale", "").equals(UserAgent.e(paramContext)));
    for (int k = 1; ; k = 0)
      return k;
  }

  private static PageTopicsGet.PageTopicsGetResponse f(String paramString)
  {
    return (PageTopicsGet.PageTopicsGetResponse)JMParser.a(new JsonFactory().createJsonParser(paramString), PageTopicsGet.PageTopicsGetResponse.class);
  }

  private static List<PageTopic> f(Context paramContext)
  {
    if ((s == null) || (r == null))
    {
      String[] arrayOfString = new String[11];
      arrayOfString[0] = paramContext.getString(2131363476);
      arrayOfString[1] = paramContext.getString(2131363477);
      arrayOfString[2] = paramContext.getString(2131363478);
      arrayOfString[3] = paramContext.getString(2131363484);
      arrayOfString[4] = paramContext.getString(2131363479);
      arrayOfString[5] = paramContext.getString(2131363480);
      arrayOfString[6] = paramContext.getString(2131363481);
      arrayOfString[7] = paramContext.getString(2131363482);
      arrayOfString[8] = paramContext.getString(2131363483);
      arrayOfString[9] = paramContext.getString(2131363485);
      arrayOfString[10] = paramContext.getString(2131363486);
      s = arrayOfString;
      r = new ArrayList();
      for (int k = 0; k < s.length; k++)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Long.valueOf(i[k]));
        r.add(new PageTopic(h[k], s[k], null, localArrayList, j[k]));
      }
    }
    return r;
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    if (paramInt == 200)
    {
      Iterator localIterator = paramAppSession.d().iterator();
      while (localIterator.hasNext())
        ((AppSessionListener)localIterator.next()).h(paramAppSession, paramString1, paramInt, paramString2, paramException);
    }
  }

  protected void a(HttpOperation.ResponseInputStream paramResponseInputStream)
  {
    String str = paramResponseInputStream.b();
    PageTopicsGet.PageTopicsGetResponse localPageTopicsGetResponse = f(str);
    if (localPageTopicsGetResponse != null)
    {
      List localList = localPageTopicsGetResponse.data;
      long l = localPageTopicsGetResponse.summary.topicsVersion;
      if ((l != -1L) && (!localList.isEmpty()))
      {
        d(this.o).a(this.o, true, "page_topics", str, localList);
        KeyValueManager.a(this.o, "page_topic_version", Long.valueOf(l));
      }
      KeyValueManager.a(this.o, "page_topic_locale", UserAgent.e(this.o));
      return;
    }
    throw new JsonParseException("Invalid Page Topics", null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.PageTopicsGet
 * JD-Core Version:    0.6.0
 */