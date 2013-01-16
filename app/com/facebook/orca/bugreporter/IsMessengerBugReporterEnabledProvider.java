package com.facebook.orca.bugreporter;

import com.facebook.app.Product;
import com.facebook.orca.prefs.GkPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.PrefKey;
import javax.inject.Inject;
import javax.inject.Provider;

public class IsMessengerBugReporterEnabledProvider
  implements Provider<Boolean>
{
  private static final PrefKey a = GkPrefKeys.a("messenger_bug_reporter_android");
  private final Product b;
  private final OrcaSharedPreferences c;

  @Inject
  public IsMessengerBugReporterEnabledProvider(Product paramProduct, OrcaSharedPreferences paramOrcaSharedPreferences)
  {
    this.b = paramProduct;
    this.c = paramOrcaSharedPreferences;
  }

  public Boolean a()
  {
    Product localProduct1 = this.b;
    Product localProduct2 = Product.MESSENGER;
    boolean bool1 = false;
    if (localProduct1 == localProduct2)
    {
      boolean bool2 = this.c.a(a, false);
      bool1 = false;
      if (bool2)
        bool1 = true;
    }
    return Boolean.valueOf(bool1);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.bugreporter.IsMessengerBugReporterEnabledProvider
 * JD-Core Version:    0.6.0
 */