package org.acra;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.acra.reporter.ReportsCrashes;

public class SharedPreferencesCollector
{
  public static String collect(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    TreeMap localTreeMap = new TreeMap();
    localTreeMap.put("default", PreferenceManager.getDefaultSharedPreferences(paramContext));
    String[] arrayOfString = ACRA.getConfig().additionalSharedPreferences();
    if (arrayOfString != null)
    {
      int i = arrayOfString.length;
      for (int j = 0; j < i; j++)
      {
        String str3 = arrayOfString[j];
        localTreeMap.put(str3, paramContext.getSharedPreferences(str3, 0));
      }
    }
    Iterator localIterator1 = localTreeMap.keySet().iterator();
    if (localIterator1.hasNext())
    {
      String str1 = (String)localIterator1.next();
      localStringBuilder.append(str1).append("\n");
      SharedPreferences localSharedPreferences = (SharedPreferences)localTreeMap.get(str1);
      if (localSharedPreferences != null)
      {
        Map localMap = localSharedPreferences.getAll();
        Iterator localIterator2;
        if ((localMap != null) && (localMap.size() > 0))
          localIterator2 = localMap.keySet().iterator();
        while (localIterator2.hasNext())
        {
          String str2 = (String)localIterator2.next();
          localStringBuilder.append(str2).append("=").append(localMap.get(str2).toString()).append("\n");
          continue;
          localStringBuilder.append("empty\n");
        }
      }
      while (true)
      {
        localStringBuilder.append("\n");
        break;
        localStringBuilder.append("null\n");
      }
    }
    return localStringBuilder.toString();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     org.acra.SharedPreferencesCollector
 * JD-Core Version:    0.6.0
 */