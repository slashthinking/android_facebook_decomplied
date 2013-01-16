package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.binding.NetworkRequestCallback;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.katana.model.FacebookApiException;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.model.GatekeeperSetting;
import com.facebook.katana.util.StringUtils;
import com.facebook.orca.inject.FbInjector;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FqlGetGatekeeperSettings extends FqlGeneratedQuery
  implements ApiMethodCallback
{
  private static final Class<?> g = FqlGetGatekeeperSettings.class;
  protected NetworkRequestCallback<String, Boolean> a;
  protected Map<String, Boolean> b = new HashMap();
  protected Context f;

  public FqlGetGatekeeperSettings(Context paramContext, Intent paramIntent, String paramString, ServiceOperationListener paramServiceOperationListener, Set<String> paramSet, NetworkRequestCallback<String, Boolean> paramNetworkRequestCallback)
  {
    super(paramContext, paramIntent, paramString, paramServiceOperationListener, "project_gating", a(paramSet), GatekeeperSetting.class);
    this.a = paramNetworkRequestCallback;
    this.f = paramContext;
  }

  public static String a(Context paramContext, Set<String> paramSet, NetworkRequestCallback<String, Boolean> paramNetworkRequestCallback)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    String str = null;
    if (localAppSession != null)
    {
      boolean bool = localAppSession.a(402);
      str = null;
      if (!bool)
        break label33;
    }
    while (true)
    {
      return str;
      label33: FacebookSessionInfo localFacebookSessionInfo = localAppSession.b();
      str = null;
      if (localFacebookSessionInfo == null)
        continue;
      str = localAppSession.a(paramContext, new FqlGetGatekeeperSettings(paramContext, null, localFacebookSessionInfo.sessionKey, null, paramSet, paramNetworkRequestCallback), 1001, 401, null);
    }
  }

  protected static String a(Set<String> paramSet)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("project_name IN(");
    StringUtils.a(localStringBuilder, ",", StringUtils.a, new Object[] { paramSet });
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    switch (paramIntent.getIntExtra("extended_type", -1))
    {
    default:
    case 402:
    case 401:
    }
    String str1;
    Iterator localIterator1;
    do
    {
      return;
      if (paramInt == 200)
        Gatekeeper.a(paramContext, this.b);
      Iterator localIterator3 = paramAppSession.d().iterator();
      while (localIterator3.hasNext())
      {
        AppSessionListener localAppSessionListener = (AppSessionListener)localIterator3.next();
        Iterator localIterator4 = this.b.entrySet().iterator();
        while (localIterator4.hasNext())
        {
          Map.Entry localEntry2 = (Map.Entry)localIterator4.next();
          localAppSessionListener.a(paramAppSession, paramString1, paramInt, paramString2, paramException, (String)localEntry2.getKey(), ((Boolean)localEntry2.getValue()).booleanValue());
        }
      }
      str1 = null;
      localIterator1 = this.b.entrySet().iterator();
    }
    while (!localIterator1.hasNext());
    Map.Entry localEntry1 = (Map.Entry)localIterator1.next();
    String str2 = (String)localEntry1.getKey();
    Boolean localBoolean = (Boolean)localEntry1.getValue();
    if ((paramInt == 200) && (str2 != null) && (localBoolean != null));
    for (boolean bool1 = true; ; bool1 = false)
    {
      boolean bool2 = false;
      if (localBoolean != null)
      {
        str1 = localBoolean.toString();
        bool2 = localBoolean.booleanValue();
      }
      this.a.a(paramContext, bool1, str2, str1, localBoolean);
      Iterator localIterator2 = paramAppSession.d().iterator();
      while (localIterator2.hasNext())
        ((AppSessionListener)localIterator2.next()).a(paramAppSession, paramString1, paramInt, paramString2, paramException, str2, bool2);
      break;
    }
  }

  protected void a(JsonParser paramJsonParser)
  {
    if (paramJsonParser.getCurrentToken() == JsonToken.START_OBJECT)
    {
      String str = new FacebookApiException(paramJsonParser).b();
      ((FbErrorReporter)FbInjector.a(this.f).a(FbErrorReporter.class)).a("FqlGetGatekeeperSettings", str, true);
    }
    while (true)
    {
      return;
      List localList = JMParser.b(paramJsonParser, GatekeeperSetting.class);
      if (localList == null)
        continue;
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        GatekeeperSetting localGatekeeperSetting = (GatekeeperSetting)localIterator.next();
        this.b.put(localGatekeeperSetting.mProjectName, Boolean.valueOf(localGatekeeperSetting.mEnabled));
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlGetGatekeeperSettings
 * JD-Core Version:    0.6.0
 */