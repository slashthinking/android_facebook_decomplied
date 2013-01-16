package com.facebook.katana.binding;

import android.content.Context;
import android.content.Intent;
import com.facebook.analytics.InteractionLogger;
import com.facebook.base.BuildConstants;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.ipc.katana.model.FacebookUser;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.katana.model.FacebookAffiliation;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.provider.UserValuesManager;
import com.facebook.katana.service.FacebookService;
import com.facebook.katana.service.method.GraphApiExchangeSession;
import com.facebook.orca.inject.FbInjector;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class AppSessionManager
{
  private final Map<String, AppSession> a = Maps.a();
  private String b;

  AppSession a(Context paramContext, boolean paramBoolean)
  {
    monitorenter;
    while (true)
    {
      FacebookSessionInfo localFacebookSessionInfo;
      try
      {
        if (this.b == null)
          continue;
        localAppSession1 = (AppSession)this.a.get(this.b);
        if ((!paramBoolean) || (localAppSession1 == null) || (!localAppSession1.c()) || (!BuildConstants.a()))
          continue;
        Boolean localBoolean = Gatekeeper.a(paramContext, "android_beta");
        if ((localBoolean == null) || (localBoolean.booleanValue()))
          continue;
        FacebookAffiliation.e(paramContext);
        localAppSession1 = null;
        AppSession localAppSession2 = localAppSession1;
        return localAppSession2;
        String str = UserValuesManager.d(paramContext);
        if (str == null)
          break label374;
        try
        {
          localFacebookSessionInfo = FacebookSessionInfo.a(str);
          if (FacebookSessionInfo.a(localFacebookSessionInfo))
            break label265;
          ((FbErrorReporter)FbInjector.a(paramContext).a(FbErrorReporter.class)).a("CorruptedSessionOnDisk", "Forcing a logout due to a deserialized bad session: " + str);
          localAppSession2 = null;
        }
        catch (Exception localException)
        {
          this.a.remove(this.b);
          this.b = null;
        }
        if (this.b == null)
          break label368;
        localAppSession1 = (AppSession)this.a.get(this.b);
        if (localAppSession1 == null)
          continue;
        FacebookUser localFacebookUser = localAppSession1.b().a();
        if ((localFacebookUser == null) || (localFacebookUser.a().length() != 0))
          continue;
        AppSession.a(paramContext, localAppSession1);
        if (localAppSession1.b().oAuthToken != null)
          continue;
        GraphApiExchangeSession.a(paramContext);
        continue;
      }
      finally
      {
        monitorexit;
      }
      label265: if (localFacebookSessionInfo.sessionSecret == null)
        continue;
      AppSession localAppSession3 = new AppSession();
      Intent localIntent = new Intent(paramContext, FacebookService.class);
      localIntent.putExtra("type", 1);
      localIntent.putExtra("rid", AppSession.m());
      localIntent.putExtra("sid", localAppSession3.a());
      localIntent.putExtra("fake_login", true);
      AppSession.a(paramContext, localIntent, 200, "Ok", null, localFacebookSessionInfo, null);
      new InteractionLogger(paramContext.getApplicationContext()).a();
      continue;
      label368: AppSession localAppSession1 = null;
      continue;
      label374: localAppSession1 = null;
    }
  }

  String a()
  {
    monitorenter;
    try
    {
      String str = this.b;
      monitorexit;
      return str;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  void a(AppSession paramAppSession)
  {
    monitorenter;
    try
    {
      this.a.put(paramAppSession.a(), paramAppSession);
      this.b = paramAppSession.a();
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  void a(String paramString)
  {
    monitorenter;
    try
    {
      this.a.remove(paramString);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  AppSession b(String paramString)
  {
    monitorenter;
    try
    {
      AppSession localAppSession = (AppSession)this.a.get(paramString);
      monitorexit;
      return localAppSession;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  boolean b()
  {
    monitorenter;
    try
    {
      boolean bool = this.a.isEmpty();
      monitorexit;
      return bool;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  Set<String> c()
  {
    monitorenter;
    try
    {
      HashSet localHashSet = Sets.a(this.a.keySet());
      monitorexit;
      return localHashSet;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.binding.AppSessionManager
 * JD-Core Version:    0.6.0
 */