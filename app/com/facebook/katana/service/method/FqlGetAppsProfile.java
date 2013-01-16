package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.common.util.Log;
import com.facebook.katana.model.FacebookApp;
import com.fasterxml.jackson.core.JsonParser;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FqlGetAppsProfile extends FqlGeneratedQuery
{
  private final Map<Long, FacebookApp> a = new HashMap();

  public FqlGetAppsProfile(Context paramContext, Intent paramIntent, String paramString1, ServiceOperationListener paramServiceOperationListener, String paramString2)
  {
    super(paramContext, paramIntent, paramString1, paramServiceOperationListener, "application", paramString2, FacebookApp.class);
  }

  protected void a(JsonParser paramJsonParser)
  {
    List localList = JMParser.b(paramJsonParser, FacebookApp.class);
    if (localList != null)
    {
      Iterator localIterator2 = localList.iterator();
      while (localIterator2.hasNext())
      {
        FacebookApp localFacebookApp2 = (FacebookApp)localIterator2.next();
        this.a.put(Long.valueOf(localFacebookApp2.mAppId), localFacebookApp2);
      }
    }
    Iterator localIterator1 = this.a.keySet().iterator();
    FacebookApp localFacebookApp1 = null;
    while (localIterator1.hasNext())
    {
      Long localLong = (Long)localIterator1.next();
      if (this.a.get(localLong) != null)
        continue;
      Log.b("FqlGetAppsProfile", "App not found: " + localLong);
      if (localFacebookApp1 == null)
        localFacebookApp1 = new FacebookApp(localLong.longValue(), "", null);
      this.a.put(localLong, localFacebookApp1);
    }
  }

  public Map<Long, FacebookApp> g()
  {
    return Collections.unmodifiableMap(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlGetAppsProfile
 * JD-Core Version:    0.6.0
 */