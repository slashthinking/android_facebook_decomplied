package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.ipc.katana.model.FacebookPage;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookSessionInfo;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.collect.ImmutableMap;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FqlGetPages extends FqlGeneratedQuery
  implements ApiMethodCallback
{
  private static final Class<?> a = FqlGetPages.class;
  private Map<Long, FacebookPage> b;
  private Class<? extends FacebookPage> f;

  public FqlGetPages(Context paramContext, Intent paramIntent, String paramString1, ServiceOperationListener paramServiceOperationListener, String paramString2, Class<? extends FacebookPage> paramClass)
  {
    super(paramContext, paramIntent, paramString1, paramServiceOperationListener, "page", paramString2, paramClass);
    this.f = paramClass;
  }

  public static <typeClass extends FacebookPage> String a(Context paramContext, String paramString, Class<typeClass> paramClass)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    String str = null;
    if (localAppSession == null);
    while (true)
    {
      return str;
      str = localAppSession.a(paramContext, new FqlGetPages(paramContext, null, localAppSession.b().sessionKey, null, paramString, paramClass), 1001, 1020, null);
    }
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    FacebookPage localFacebookPage = null;
    if (paramInt == 200)
    {
      Iterator localIterator2 = this.b.values().iterator();
      boolean bool = localIterator2.hasNext();
      localFacebookPage = null;
      if (bool)
        localFacebookPage = (FacebookPage)localIterator2.next();
    }
    Iterator localIterator1 = paramAppSession.d().iterator();
    while (localIterator1.hasNext())
    {
      AppSessionListener localAppSessionListener = (AppSessionListener)localIterator1.next();
      if (localFacebookPage != null)
      {
        localAppSessionListener.a(paramAppSession, paramString1, paramInt, paramString2, paramException, ((FacebookPage)localFacebookPage).mPageId, localFacebookPage);
        continue;
      }
      localAppSessionListener.a(paramAppSession, paramString1, paramInt, paramString2, paramException, -1L, null);
    }
  }

  protected void a(JsonParser paramJsonParser)
  {
    List localList = JMParser.b(paramJsonParser, this.f);
    if (localList != null)
    {
      this.b = new HashMap();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        FacebookPage localFacebookPage = (FacebookPage)localIterator.next();
        this.b.put(Long.valueOf(localFacebookPage.mPageId), localFacebookPage);
      }
    }
  }

  public Map<Long, FacebookPage> g()
  {
    if (this.b == null);
    for (Object localObject = ImmutableMap.j(); ; localObject = Collections.unmodifiableMap(this.b))
      return localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlGetPages
 * JD-Core Version:    0.6.0
 */