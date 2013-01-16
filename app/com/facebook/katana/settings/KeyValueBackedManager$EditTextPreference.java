package com.facebook.katana.settings;

import android.content.Context;
import android.preference.EditTextPreference;
import com.facebook.katana.provider.KeyValueManager;

public class KeyValueBackedManager$EditTextPreference extends EditTextPreference
{
  public KeyValueBackedManager$EditTextPreference(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext);
    setKey(paramString1);
    super.setDefaultValue(KeyValueManager.a(paramContext, paramString1, paramString2));
  }

  public void onDialogClosed(boolean paramBoolean)
  {
    super.onDialogClosed(paramBoolean);
    KeyValueManager.a(getContext(), getKey(), getText());
  }

  public void setText(String paramString)
  {
    super.setText(paramString);
    KeyValueManager.a(getContext(), getKey(), paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.settings.KeyValueBackedManager.EditTextPreference
 * JD-Core Version:    0.6.0
 */