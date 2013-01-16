package com.facebook.katana.util;

import android.os.Bundle;
import com.facebook.common.util.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class URLQueryBuilder
{
  public static Bundle a(String paramString)
  {
    if (paramString == null);
    Bundle localBundle;
    for (Object localObject = new Bundle(); ; localObject = localBundle)
    {
      return localObject;
      localBundle = new Bundle();
      String[] arrayOfString1 = paramString.split("&");
      int i = arrayOfString1.length;
      int j = 0;
      if (j >= i)
        continue;
      String[] arrayOfString2 = arrayOfString1[j].split("=");
      String str1 = URLDecoder.decode(arrayOfString2[0]);
      if (arrayOfString2.length > 1);
      for (String str2 = URLDecoder.decode(arrayOfString2[1]); ; str2 = "")
      {
        localBundle.putString(str1, str2);
        j++;
        break;
      }
    }
  }

  public static StringBuilder a(Bundle paramBundle)
  {
    TreeMap localTreeMap = new TreeMap();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localTreeMap.put(str, paramBundle.getString(str));
    }
    return a(localTreeMap);
  }

  public static StringBuilder a(Map<String, String> paramMap)
  {
    Object localObject;
    if (paramMap == null)
      localObject = new StringBuilder("");
    while (true)
    {
      return localObject;
      StringBuilder localStringBuilder1 = new StringBuilder();
      Iterator localIterator = paramMap.keySet().iterator();
      int i = 1;
      while (true)
      {
        if (!localIterator.hasNext())
          break label164;
        String str1 = (String)localIterator.next();
        int j;
        label67: String str2;
        if (i != 0)
        {
          j = 0;
          str2 = (String)paramMap.get(str1);
        }
        try
        {
          StringBuilder localStringBuilder2 = localStringBuilder1.append(URLEncoder.encode(str1, "UTF-8")).append("=");
          if (str2 != null);
          for (String str3 = URLEncoder.encode(str2, "UTF-8"); ; str3 = "")
          {
            localStringBuilder2.append(str3);
            i = j;
            break;
            localStringBuilder1.append("&");
            j = i;
            break label67;
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          Log.a("URLQueryBuilder", "UTF-8 encoding not supported on this system.", localUnsupportedEncodingException);
          localObject = null;
        }
      }
      continue;
      label164: localObject = localStringBuilder1;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.URLQueryBuilder
 * JD-Core Version:    0.6.0
 */