package com.facebook.orca.push.mqtt;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.GkPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.PrefKey;
import javax.inject.Inject;

public class IsPersistentPushServiceEnabledForUserProvider extends AbstractProvider<Boolean>
{
  public static final PrefKey a = GkPrefKeys.a("android_persistent_push_service");
  private final OrcaSharedPreferences b;

  @Inject
  public IsPersistentPushServiceEnabledForUserProvider(OrcaSharedPreferences paramOrcaSharedPreferences)
  {
    this.b = paramOrcaSharedPreferences;
  }

  public Boolean a()
  {
    return Boolean.valueOf(this.b.a(a, false));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.mqtt.IsPersistentPushServiceEnabledForUserProvider
 * JD-Core Version:    0.6.0
 */