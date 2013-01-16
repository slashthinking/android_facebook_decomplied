package com.facebook.katana.settings;

import android.content.Context;
import android.preference.CheckBoxPreference;
import com.facebook.katana.provider.KeyValueManager;

public class KeyValueBackedManager$CheckBoxPreference extends CheckBoxPreference
{
  public KeyValueBackedManager$CheckBoxPreference(Context paramContext, String paramString, boolean paramBoolean)
  {
    super(paramContext);
    setKey(paramString);
    setDefaultValue(Boolean.valueOf(KeyValueManager.a(paramContext, paramString, paramBoolean)));
  }

  public void setChecked(boolean paramBoolean)
  {
    super.setChecked(paramBoolean);
    KeyValueManager.a(getContext(), getKey(), Boolean.valueOf(paramBoolean));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.settings.KeyValueBackedManager.CheckBoxPreference
 * JD-Core Version:    0.6.0
 */