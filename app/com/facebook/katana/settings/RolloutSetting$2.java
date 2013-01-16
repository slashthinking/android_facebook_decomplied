package com.facebook.katana.settings;

import android.content.Context;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import com.facebook.katana.rollout.Rollout;

class RolloutSetting$2
  implements Preference.OnPreferenceChangeListener
{
  public boolean onPreferenceChange(Preference paramPreference, Object paramObject)
  {
    String str = (String)paramObject;
    Rollout.a(this.c.b, str);
    this.a.setSummary(this.c.b(this.b));
    this.c.a(this.b, str);
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.settings.RolloutSetting.2
 * JD-Core Version:    0.6.0
 */