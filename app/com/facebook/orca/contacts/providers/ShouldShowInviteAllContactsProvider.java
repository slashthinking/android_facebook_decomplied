package com.facebook.orca.contacts.providers;

import com.facebook.app.Product;
import com.facebook.orca.app.OrcaAppType;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.prefs.GkPrefKeys;
import com.facebook.orca.prefs.MessengerPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.PrefKey;
import javax.inject.Inject;
import javax.inject.Provider;

public class ShouldShowInviteAllContactsProvider
  implements Provider<Boolean>
{
  private static final PrefKey a = GkPrefKeys.a("messenger_contacts_invite_all_android");
  private final OrcaSharedPreferences b;
  private final OrcaAppType c;
  private final Clock d;

  @Inject
  public ShouldShowInviteAllContactsProvider(OrcaSharedPreferences paramOrcaSharedPreferences, OrcaAppType paramOrcaAppType, Clock paramClock)
  {
    this.b = paramOrcaSharedPreferences;
    this.c = paramOrcaAppType;
    this.d = paramClock;
  }

  public Boolean a()
  {
    boolean bool1 = this.b.a(MessengerPrefKeys.D, false);
    long l = this.b.a(MessengerPrefKeys.B, 0L);
    int i = this.b.a(MessengerPrefKeys.C, 0);
    Product localProduct1 = this.c.i();
    Product localProduct2 = Product.MESSENGER;
    boolean bool2 = false;
    if (localProduct1 == localProduct2)
    {
      boolean bool3 = this.b.a(a, false);
      bool2 = false;
      if (bool3)
      {
        bool2 = false;
        if (!bool1)
        {
          bool2 = false;
          if (i < 3)
          {
            boolean bool4 = this.d.a() - l < 1209600000L;
            bool2 = false;
            if (bool4)
              bool2 = true;
          }
        }
      }
    }
    return Boolean.valueOf(bool2);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.providers.ShouldShowInviteAllContactsProvider
 * JD-Core Version:    0.6.0
 */