package org.acra;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class DeviceFeaturesCollector
{
  public static String getFeatures(Context paramContext)
  {
    String str1;
    if (Compatibility.getAPILevel() >= 5)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      try
      {
        PackageManager localPackageManager = paramContext.getPackageManager();
        Object[] arrayOfObject = (Object[])(Object[])PackageManager.class.getMethod("getSystemAvailableFeatures", (Class[])null).invoke(localPackageManager, new Object[0]);
        int i = arrayOfObject.length;
        int j = 0;
        if (j < i)
        {
          Object localObject = arrayOfObject[j];
          String str2 = (String)localObject.getClass().getField("name").get(localObject);
          if (str2 != null)
            localStringBuffer.append(str2);
          while (true)
          {
            localStringBuffer.append("\n");
            j++;
            break;
            String str3 = (String)localObject.getClass().getMethod("getGlEsVersion", (Class[])null).invoke(localObject, new Object[0]);
            localStringBuffer.append("glEsVersion = ");
            localStringBuffer.append(str3);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        Log.w(ACRA.LOG_TAG, "Couldn't retrieve device features for " + paramContext.getPackageName(), localThrowable);
        localStringBuffer.append("Could not retrieve data: ");
        localStringBuffer.append(localThrowable.getMessage());
        str1 = localStringBuffer.toString();
      }
    }
    while (true)
    {
      return str1;
      str1 = "Data available only with API Level > 5";
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     org.acra.DeviceFeaturesCollector
 * JD-Core Version:    0.6.0
 */