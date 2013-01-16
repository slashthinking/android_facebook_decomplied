package com.facebook.orca.prefs;

import com.facebook.orca.presence.PresenceManager;
import javax.inject.Inject;
import javax.inject.Provider;

public class IsMobileOnlineAvailabilityEnabledProvider
  implements Provider<Boolean>
{
  private final PresenceManager a;

  @Inject
  public IsMobileOnlineAvailabilityEnabledProvider(PresenceManager paramPresenceManager)
  {
    this.a = paramPresenceManager;
  }

  public Boolean a()
  {
    return Boolean.valueOf(this.a.g());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.IsMobileOnlineAvailabilityEnabledProvider
 * JD-Core Version:    0.6.0
 */