package com.facebook.orca.prefs;

import com.facebook.orca.presence.PresenceManager;
import javax.inject.Inject;
import javax.inject.Provider;

public class IsMobileOnlineAvailabilityPermittedProvider
  implements Provider<Boolean>
{
  private final PresenceManager a;

  @Inject
  public IsMobileOnlineAvailabilityPermittedProvider(PresenceManager paramPresenceManager)
  {
    this.a = paramPresenceManager;
  }

  public Boolean a()
  {
    return Boolean.valueOf(this.a.f());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.IsMobileOnlineAvailabilityPermittedProvider
 * JD-Core Version:    0.6.0
 */