package com.facebook.orca.prefs;

import android.content.Context;
import com.facebook.orca.push.prefs.PushPrefKeys;

public class MobileOnlineAvailabilityPreference extends OrcaCheckBoxPreference
{
  public MobileOnlineAvailabilityPreference(Context paramContext)
  {
    super(paramContext);
    setKey(PushPrefKeys.a.a());
    setTitle(2131362625);
    setSummaryOff(2131362627);
    setSummaryOn(2131362626);
    setDefaultValue(Boolean.valueOf(true));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.MobileOnlineAvailabilityPreference
 * JD-Core Version:    0.6.0
 */