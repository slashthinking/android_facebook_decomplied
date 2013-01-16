package com.facebook.katana;

import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.widget.Toast;

class SettingsActivity$4
  implements Preference.OnPreferenceChangeListener
{
  public boolean onPreferenceChange(Preference paramPreference, Object paramObject)
  {
    int i;
    if (((paramObject instanceof String)) && ((paramPreference instanceof EditTextPreference)))
    {
      String str2 = (String)paramObject;
      String str3 = Constants.URL.d(str2);
      EditTextPreference localEditTextPreference = (EditTextPreference)paramPreference;
      if (!str3.equals(str2))
      {
        localEditTextPreference.setText(str3);
        i = 0;
        return i;
      }
    }
    boolean bool = "facebook.com".equals(paramObject);
    this.a.setChecked(bool);
    if (this.b.getOnPreferenceChangeListener().onPreferenceChange(this.b, "cache"))
      this.b.setValue("cache");
    if (bool);
    for (String str1 = "Cache cleared and SSL checking turned on"; ; str1 = "Cache cleared and SSL checking turned off")
    {
      Toast.makeText(this.c, str1, 0).show();
      i = 1;
      break;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.SettingsActivity.4
 * JD-Core Version:    0.6.0
 */