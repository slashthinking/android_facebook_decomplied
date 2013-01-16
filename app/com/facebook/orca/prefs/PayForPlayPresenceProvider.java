package com.facebook.orca.prefs;

import com.facebook.orca.presence.PresenceManager;
import javax.inject.Inject;
import javax.inject.Provider;

public class PayForPlayPresenceProvider
  implements Provider<PayForPlayPresence>
{
  private final PresenceManager a;

  @Inject
  public PayForPlayPresenceProvider(PresenceManager paramPresenceManager)
  {
    this.a = paramPresenceManager;
  }

  public PayForPlayPresence a()
  {
    return this.a.h();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.PayForPlayPresenceProvider
 * JD-Core Version:    0.6.0
 */