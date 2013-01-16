package org.acra;

import android.content.Context;
import android.text.format.Time;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.acra.reporter.ReportsCrashes;

class DropBoxCollector
{
  private static final String[] SYSTEM_TAGS = { "system_app_anr", "system_app_wtf", "system_app_crash", "system_server_anr", "system_server_wtf", "system_server_crash", "BATTERY_DISCHARGE_INFO", "SYSTEM_RECOVERY_LOG", "SYSTEM_BOOT", "SYSTEM_LAST_KMSG", "APANIC_CONSOLE", "APANIC_THREADS", "SYSTEM_RESTART", "SYSTEM_TOMBSTONE", "data_app_strictmode" };

  public static String read(Context paramContext, String[] paramArrayOfString)
  {
    try
    {
      String str1 = Compatibility.getDropBoxServiceName();
      if (str1 != null)
      {
        localStringBuilder = new StringBuilder();
        Object localObject2 = paramContext.getSystemService(str1);
        Class localClass1 = localObject2.getClass();
        Class[] arrayOfClass1 = new Class[2];
        arrayOfClass1[0] = String.class;
        arrayOfClass1[1] = Long.TYPE;
        Method localMethod1 = localClass1.getMethod("getNextEntry", arrayOfClass1);
        if (localMethod1 == null)
          break label567;
        Time localTime = new Time();
        localTime.setToNow();
        localTime.minute -= ACRA.getConfig().dropboxCollectionMinutes();
        localTime.normalize(false);
        long l1 = localTime.toMillis(false);
        if (ACRA.getConfig().includeDropBoxSystemTags());
        for (ArrayList localArrayList = new ArrayList(Arrays.asList(SYSTEM_TAGS)); ; localArrayList = new ArrayList())
        {
          if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
            localArrayList.addAll(Arrays.asList(paramArrayOfString));
          if (localArrayList.size() <= 0)
            break label559;
          Iterator localIterator = localArrayList.iterator();
          while (true)
          {
            if (!localIterator.hasNext())
              break label567;
            String str3 = (String)localIterator.next();
            localStringBuilder.append("Tag: ").append(str3).append('\n');
            Object[] arrayOfObject1 = new Object[2];
            arrayOfObject1[0] = str3;
            arrayOfObject1[1] = Long.valueOf(l1);
            Object localObject3 = localMethod1.invoke(localObject2, arrayOfObject1);
            if (localObject3 == null)
              break label529;
            Class localClass2 = localObject3.getClass();
            Class[] arrayOfClass2 = new Class[1];
            arrayOfClass2[0] = Integer.TYPE;
            Method localMethod2 = localClass2.getMethod("getText", arrayOfClass2);
            Method localMethod3 = localObject3.getClass().getMethod("getTimeMillis", (Class[])null);
            Method localMethod4 = localObject3.getClass().getMethod("close", (Class[])null);
            while (localObject3 != null)
            {
              long l2 = ((Long)localMethod3.invoke(localObject3, (Object[])null)).longValue();
              localTime.set(l2);
              localStringBuilder.append("@").append(localTime.format2445()).append('\n');
              Object[] arrayOfObject2 = new Object[1];
              arrayOfObject2[0] = Integer.valueOf(500);
              String str4 = (String)localMethod2.invoke(localObject3, arrayOfObject2);
              if (str4 == null)
                break label499;
              localStringBuilder.append("Text: ").append(str4).append('\n');
              localMethod4.invoke(localObject3, (Object[])null);
              Object[] arrayOfObject3 = new Object[2];
              arrayOfObject3[0] = str3;
              arrayOfObject3[1] = Long.valueOf(l2);
              localObject3 = localMethod1.invoke(localObject2, arrayOfObject3);
            }
          }
        }
      }
    }
    catch (SecurityException localSecurityException)
    {
      while (true)
      {
        Log.i(ACRA.LOG_TAG, "DropBoxManager not available.");
        localObject1 = "N/A";
        return localObject1;
        localStringBuilder.append("Not Text!").append('\n');
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      while (true)
      {
        Log.i(ACRA.LOG_TAG, "DropBoxManager not available.");
        continue;
        localStringBuilder.append("Nothing.").append('\n');
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (true)
      {
        StringBuilder localStringBuilder;
        Log.i(ACRA.LOG_TAG, "DropBoxManager not available.");
        continue;
        localStringBuilder.append("No tag configured for collection.");
        String str2 = localStringBuilder.toString();
        Object localObject1 = str2;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      while (true)
        Log.i(ACRA.LOG_TAG, "DropBoxManager not available.");
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      while (true)
        Log.i(ACRA.LOG_TAG, "DropBoxManager not available.");
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      label529: label559: label567: 
      while (true)
        label499: Log.i(ACRA.LOG_TAG, "DropBoxManager not available.");
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     org.acra.DropBoxCollector
 * JD-Core Version:    0.6.0
 */