package com.facebook.orca.notify;

import com.facebook.orca.annotations.MeUser;
import com.facebook.orca.prefs.GkPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.PrefKey;
import com.facebook.orca.users.User;
import javax.inject.Inject;
import javax.inject.Provider;

public class InAppNotificationEnabledProvider
  implements Provider<Boolean>
{
  public static final PrefKey a = GkPrefKeys.a("messenger_inapp_notify_android");
  private final OrcaSharedPreferences b;
  private final Provider<User> c;

  @Inject
  public InAppNotificationEnabledProvider(OrcaSharedPreferences paramOrcaSharedPreferences, @MeUser Provider<User> paramProvider)
  {
    this.b = paramOrcaSharedPreferences;
    this.c = paramProvider;
  }

  public Boolean a()
  {
    if (this.c.b() != null);
    for (Boolean localBoolean = Boolean.valueOf(this.b.a(a, false)); ; localBoolean = Boolean.valueOf(false))
      return localBoolean;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.notify.InAppNotificationEnabledProvider
 * JD-Core Version:    0.6.0
 */