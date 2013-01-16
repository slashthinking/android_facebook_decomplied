package org.acra;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.util.Log;

final class ACRA$1
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    boolean bool = true;
    Object localObject;
    if (("acra.disable".equals(paramString)) || ("acra.enable".equals(paramString)))
      localObject = Boolean.valueOf(false);
    try
    {
      if (!paramSharedPreferences.getBoolean("acra.enable", true))
      {
        Boolean localBoolean = Boolean.valueOf(paramSharedPreferences.getBoolean("acra.disable", bool));
        localObject = localBoolean;
        label56: if (!((Boolean)localObject).booleanValue())
          break label76;
        ErrorReporter.getInstance().disable();
      }
      while (true)
      {
        return;
        bool = false;
        break;
        try
        {
          label76: ACRA.access$000();
        }
        catch (ACRAConfigurationException localACRAConfigurationException)
        {
          Log.w(ACRA.LOG_TAG, "Error : ", localACRAConfigurationException);
        }
      }
    }
    catch (Exception localException)
    {
      break label56;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     org.acra.ACRA.1
 * JD-Core Version:    0.6.0
 */