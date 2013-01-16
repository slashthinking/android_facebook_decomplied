package com.facebook.contacts.picker;

import com.facebook.app.Product;
import com.facebook.orca.annotations.IsContactsDownloadPermitted;
import com.facebook.orca.app.OrcaAppType;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.prefs.GkPrefKeys;
import com.facebook.orca.prefs.InternalPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.PrefKey;
import javax.inject.Inject;
import javax.inject.Provider;

public class IsRolodexPickerEnabledProvider
  implements Provider<Boolean>
{
  public static final PrefKey a;
  private static final Class<?> b = IsRolodexPickerEnabledProvider.class;
  private final OrcaSharedPreferences c;
  private final OrcaAppType d;
  private final Provider<Boolean> e;

  static
  {
    a = GkPrefKeys.a("messenger_use_rolodex_for_picker_android");
  }

  @Inject
  public IsRolodexPickerEnabledProvider(OrcaSharedPreferences paramOrcaSharedPreferences, OrcaAppType paramOrcaAppType, @IsContactsDownloadPermitted Provider<Boolean> paramProvider)
  {
    this.c = paramOrcaSharedPreferences;
    this.d = paramOrcaAppType;
    this.e = paramProvider;
  }

  public Boolean a()
  {
    boolean bool1;
    if (((this.c.a(InternalPrefKeys.b, false)) || (this.c.a(a, false))) && (this.d.i() == Product.MESSENGER))
    {
      bool1 = true;
      boolean bool2 = ((Boolean)this.e.b()).booleanValue();
      if ((!bool1) || (bool2))
        break label91;
      BLog.d(b, "Misconfigured gatekeepers: User wants Rolodex picker, but does not have contacts download permitted! Falling back to non-Rolodex picker.");
    }
    label91: for (Boolean localBoolean = Boolean.valueOf(false); ; localBoolean = Boolean.valueOf(bool1))
    {
      return localBoolean;
      bool1 = false;
      break;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.picker.IsRolodexPickerEnabledProvider
 * JD-Core Version:    0.6.0
 */