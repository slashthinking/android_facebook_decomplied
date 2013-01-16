package com.facebook.orca.contacts.providers;

import com.facebook.app.Product;
import com.facebook.orca.app.OrcaAppType;
import com.facebook.orca.prefs.GkPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.PrefKey;
import javax.inject.Inject;
import javax.inject.Provider;

public class IsContactsUploadPermittedProvider
  implements Provider<Boolean>
{
  private static final PrefKey a = GkPrefKeys.a("messenger_contacts_upload_android");
  private final OrcaSharedPreferences b;
  private final OrcaAppType c;

  @Inject
  public IsContactsUploadPermittedProvider(OrcaSharedPreferences paramOrcaSharedPreferences, OrcaAppType paramOrcaAppType)
  {
    this.b = paramOrcaSharedPreferences;
    this.c = paramOrcaAppType;
  }

  public Boolean a()
  {
    Product localProduct1 = this.c.i();
    Product localProduct2 = Product.MESSENGER;
    boolean bool1 = false;
    if (localProduct1 == localProduct2)
    {
      boolean bool2 = this.b.a(a, false);
      bool1 = false;
      if (bool2)
        bool1 = true;
    }
    return Boolean.valueOf(bool1);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.providers.IsContactsUploadPermittedProvider
 * JD-Core Version:    0.6.0
 */