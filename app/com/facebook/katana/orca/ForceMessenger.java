package com.facebook.katana.orca;

import android.content.Context;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.analytics.InteractionLogger;
import com.facebook.common.util.TriState;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.katana.util.ApplicationUtils;
import com.facebook.katana.util.MessengerUserUtils;
import com.facebook.katana.util.MessengerUserUtils.UserStatus;
import com.facebook.orca.annotations.MeUserId;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import javax.inject.Provider;

public class ForceMessenger
{
  private final Context a;
  private final OrcaSharedPreferences b;
  private final InteractionLogger c;

  public ForceMessenger(Context paramContext, OrcaSharedPreferences paramOrcaSharedPreferences)
  {
    this.a = paramContext;
    this.b = paramOrcaSharedPreferences;
    this.c = new InteractionLogger(paramContext);
  }

  private void a(long paramLong)
  {
    this.b.b().a(ForceMessengerPrefKeys.b, paramLong).a();
  }

  private void b(long paramLong)
  {
    this.b.b().a(ForceMessengerPrefKeys.c, paramLong).a();
  }

  private void b(ForceMessenger.Stage paramStage)
  {
    this.b.b().a(ForceMessengerPrefKeys.a, paramStage.toString()).a();
  }

  private long d()
  {
    return this.b.a(ForceMessengerPrefKeys.b, -1L);
  }

  private long e()
  {
    return this.b.a(ForceMessengerPrefKeys.c, -1L);
  }

  public void a(ForceMessenger.Stage paramStage)
  {
    long l1;
    long l2;
    if (paramStage == ForceMessenger.Stage.INSTALL_LATER)
    {
      l1 = d();
      l2 = System.currentTimeMillis();
      if (l1 != -1L)
        break label59;
      a(604800000L + l2);
    }
    while (true)
    {
      b(l2);
      if (ApplicationUtils.c(this.a))
        b(ForceMessenger.Stage.INSTALLED);
      return;
      label59: if (l2 < l1)
        continue;
      b(ForceMessenger.Stage.INSTALL_NOW);
      a(-1L);
    }
  }

  public boolean a()
  {
    String str = (String)FbInjector.a(this.a).b(String.class, MeUserId.class).b();
    MessengerUserUtils.UserStatus localUserStatus = MessengerUserUtils.a(this.a, str);
    int i;
    if (localUserStatus.a())
      i = 1;
    while (true)
    {
      return i;
      if (localUserStatus.c() == TriState.NO)
      {
        i = 1;
        continue;
      }
      i = 0;
    }
  }

  public boolean a(Context paramContext)
  {
    boolean bool1 = b(paramContext);
    int i = 0;
    if (!bool1);
    while (true)
    {
      return i;
      if ((c() == ForceMessenger.Stage.INSTALLED) || (c() == ForceMessenger.Stage.INSTALL_NOW))
      {
        i = 1;
        continue;
      }
      long l = e();
      if (l == -1L)
      {
        i = 1;
        continue;
      }
      boolean bool2 = System.currentTimeMillis() - l < 86400000L;
      i = 0;
      if (bool2)
        continue;
      i = 1;
    }
  }

  public void b()
  {
    String str = (String)FbInjector.a(this.a).b(String.class, MeUserId.class).b();
    MessengerUserUtils.UserStatus localUserStatus = MessengerUserUtils.a(this.a, str);
    HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent("panama_messenger_user_status");
    localHoneyClientEvent.a("logged_in", localUserStatus.a());
    localHoneyClientEvent.b("other_logged_in", localUserStatus.c().toString());
    this.c.a(localHoneyClientEvent);
  }

  public boolean b(Context paramContext)
  {
    return Boolean.TRUE.equals(Gatekeeper.a(paramContext, "orca_disabled_in_main_app_android"));
  }

  public ForceMessenger.Stage c()
  {
    ForceMessenger.Stage localStage = ForceMessenger.Stage.valueOf(this.b.a(ForceMessengerPrefKeys.a, ForceMessenger.Stage.INSTALL_LATER.toString()));
    if ((localStage == ForceMessenger.Stage.INSTALLED) && (!ApplicationUtils.a(this.a, "com.facebook.orca")))
    {
      localStage = ForceMessenger.Stage.INSTALL_NOW;
      b(localStage);
    }
    return localStage;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.ForceMessenger
 * JD-Core Version:    0.6.0
 */