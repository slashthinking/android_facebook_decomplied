package com.facebook.katana;

import android.content.Context;
import android.preference.Preference;
import android.preference.PreferenceCategory;

class SettingsActivity$DynamicPreferenceCategory extends PreferenceCategory
{
  Preference a;
  Preference[] b;

  public SettingsActivity$DynamicPreferenceCategory(Context paramContext)
  {
    super(paramContext);
  }

  public void setEnabled(boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean)
    {
      if (this.b != null)
      {
        Preference[] arrayOfPreference = this.b;
        int j = arrayOfPreference.length;
        while (i < j)
        {
          Preference localPreference = arrayOfPreference[i];
          localPreference.setEnabled(true);
          addPreference(localPreference);
          i++;
        }
      }
    }
    else
    {
      if (this.b == null)
      {
        this.a = getPreference(0);
        this.b = new Preference[-1 + getPreferenceCount()];
        while (i < this.b.length)
        {
          this.b[i] = getPreference(i + 1);
          i++;
        }
      }
      removeAll();
      addPreference(this.a);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.SettingsActivity.DynamicPreferenceCategory
 * JD-Core Version:    0.6.0
 */