package org.acra;

import android.content.Context;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.util.Log;
import java.lang.reflect.Field;

public class SettingsCollector
{
  public static String collectSecureSettings(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Field[] arrayOfField = Settings.Secure.class.getFields();
    int i = arrayOfField.length;
    int j = 0;
    while (true)
      if (j < i)
      {
        Field localField = arrayOfField[j];
        if ((!localField.isAnnotationPresent(Deprecated.class)) && (localField.getType() == String.class) && (isAuthorized(localField)));
        try
        {
          String str = Settings.Secure.getString(paramContext.getContentResolver(), (String)localField.get(null));
          if (str != null)
            localStringBuilder.append(localField.getName()).append("=").append(str).append("\n");
          j++;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          while (true)
            Log.w(ACRA.LOG_TAG, "Error : ", localIllegalArgumentException);
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          while (true)
            Log.w(ACRA.LOG_TAG, "Error : ", localIllegalAccessException);
        }
      }
    return localStringBuilder.toString();
  }

  public static String collectSystemSettings(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Field[] arrayOfField = Settings.System.class.getFields();
    int i = arrayOfField.length;
    int j = 0;
    while (true)
      if (j < i)
      {
        Field localField = arrayOfField[j];
        if ((!localField.isAnnotationPresent(Deprecated.class)) && (localField.getType() == String.class));
        try
        {
          String str = Settings.System.getString(paramContext.getContentResolver(), (String)localField.get(null));
          if (str != null)
            localStringBuilder.append(localField.getName()).append("=").append(str).append("\n");
          j++;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          while (true)
            Log.w(ACRA.LOG_TAG, "Error : ", localIllegalArgumentException);
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          while (true)
            Log.w(ACRA.LOG_TAG, "Error : ", localIllegalAccessException);
        }
      }
    return localStringBuilder.toString();
  }

  private static boolean isAuthorized(Field paramField)
  {
    if ((paramField == null) || (paramField.getName().startsWith("WIFI_AP")));
    for (int i = 0; ; i = 1)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     org.acra.SettingsCollector
 * JD-Core Version:    0.6.0
 */