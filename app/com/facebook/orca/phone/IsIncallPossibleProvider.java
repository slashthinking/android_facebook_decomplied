package com.facebook.orca.phone;

import android.content.Context;
import android.content.pm.PackageManager;
import com.facebook.app.Product;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.app.OrcaAppType;
import javax.inject.Inject;
import javax.inject.Provider;

public class IsIncallPossibleProvider
  implements Provider<Boolean>
{
  private final OrcaAppType a;
  private final Context b;

  @Inject
  public IsIncallPossibleProvider(OrcaAppType paramOrcaAppType, @FromApplication Context paramContext)
  {
    this.a = paramOrcaAppType;
    this.b = paramContext;
  }

  private boolean a(String paramString)
  {
    if (this.b.checkCallingOrSelfPermission(paramString) == 0);
    for (int i = 1; ; i = 0)
      return i;
  }

  public Boolean a()
  {
    if ((this.a.i() == Product.MESSENGER) && (a("android.permission.CALL_PHONE")) && (a("android.permission.GET_TASKS")) && (a("android.permission.PROCESS_OUTGOING_CALLS")) && (this.b.getPackageManager().hasSystemFeature("android.hardware.telephony")));
    for (boolean bool = true; ; bool = false)
      return Boolean.valueOf(bool);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.phone.IsIncallPossibleProvider
 * JD-Core Version:    0.6.0
 */