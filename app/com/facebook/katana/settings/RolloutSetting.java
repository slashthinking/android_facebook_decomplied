package com.facebook.katana.settings;

import android.content.Context;
import android.preference.ListPreference;
import android.preference.Preference;
import com.facebook.katana.rollout.Rollout;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RolloutSetting<T extends Enum<T>>
{
  public static Set<RolloutSetting<?>> a = new RolloutSetting.1();
  Class<T> b;

  public Preference a(Context paramContext)
  {
    ListPreference localListPreference = new ListPreference(paramContext);
    HashMap localHashMap = Maps.a();
    for (Enum localEnum2 : (Enum[])this.b.getEnumConstants())
      localHashMap.put(localEnum2.name(), a(localEnum2));
    Enum localEnum1 = Rollout.a(paramContext, this.b);
    if (localEnum1 != null);
    for (String str = localEnum1.name(); ; str = null)
    {
      localListPreference.setEntries((CharSequence[])localHashMap.values().toArray(new String[localHashMap.values().size()]));
      localListPreference.setEntryValues((CharSequence[])localHashMap.keySet().toArray(new String[localHashMap.values().size()]));
      localListPreference.setDefaultValue(str);
      localListPreference.setDialogTitle(a());
      localListPreference.setTitle(c(paramContext));
      localListPreference.setSummary(b(paramContext));
      localListPreference.setOnPreferenceChangeListener(new RolloutSetting.2(this, localListPreference, paramContext));
      return localListPreference;
    }
  }

  protected String a()
  {
    return "Select a condition";
  }

  protected String a(T paramT)
  {
    return paramT.name();
  }

  protected void a(Context paramContext, String paramString)
  {
  }

  protected String b(Context paramContext)
  {
    return "Current value: " + Rollout.a(paramContext, this.b);
  }

  protected String c(Context paramContext)
  {
    return this.b.getSimpleName() + " Experiment";
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.settings.RolloutSetting
 * JD-Core Version:    0.6.0
 */