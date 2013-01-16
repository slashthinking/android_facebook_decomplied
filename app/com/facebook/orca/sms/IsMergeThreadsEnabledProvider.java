package com.facebook.orca.sms;

import com.facebook.orca.app.IntendedAudience;
import com.facebook.orca.app.OrcaAppType;
import com.facebook.orca.prefs.GkPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.PrefKey;
import javax.inject.Inject;
import javax.inject.Provider;

public class IsMergeThreadsEnabledProvider
  implements Provider<Boolean>
{
  public static final PrefKey a = GkPrefKeys.a("messenger_merge_threads_android");
  private final OrcaSharedPreferences b;
  private final OrcaAppType c;

  @Inject
  public IsMergeThreadsEnabledProvider(OrcaSharedPreferences paramOrcaSharedPreferences, OrcaAppType paramOrcaAppType)
  {
    this.b = paramOrcaSharedPreferences;
    this.c = paramOrcaAppType;
  }

  public Boolean a()
  {
    boolean bool1 = this.b.a(a, false);
    boolean bool2 = false;
    if (bool1)
    {
      IntendedAudience localIntendedAudience1 = this.c.h();
      IntendedAudience localIntendedAudience2 = IntendedAudience.PUBLIC;
      bool2 = false;
      if (localIntendedAudience1 != localIntendedAudience2)
        bool2 = true;
    }
    return Boolean.valueOf(bool2);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.IsMergeThreadsEnabledProvider
 * JD-Core Version:    0.6.0
 */