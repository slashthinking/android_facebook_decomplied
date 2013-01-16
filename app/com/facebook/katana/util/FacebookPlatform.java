package com.facebook.katana.util;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.FacebookSessionInfo;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FacebookPlatform
{
  public static String a(Context paramContext, String paramString)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    TreeMap localTreeMap = new TreeMap();
    localTreeMap.put("api_key", "882a8490361da98702bf97a021ddc14d");
    localTreeMap.put("t", String.valueOf(System.currentTimeMillis() / 1000L));
    localTreeMap.put("uid", String.valueOf(localAppSession.b().userId));
    localTreeMap.put("url", paramString);
    localTreeMap.put("session_key", localAppSession.b().sessionKey);
    try
    {
      localTreeMap.put("sig", a(localTreeMap, localAppSession.b().sessionSecret));
      Uri.Builder localBuilder = Uri.parse(Constants.URL.l(paramContext)).buildUpon();
      localBuilder.encodedQuery(URLQueryBuilder.a(localTreeMap).toString());
      str = localBuilder.build().toString();
      return str;
    }
    catch (Throwable localThrowable)
    {
      while (true)
        String str = null;
    }
  }

  protected static String a(String paramString)
  {
    int i = 0;
    MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
    localMessageDigest.reset();
    byte[] arrayOfByte1 = paramString.getBytes("UTF-8");
    localMessageDigest.update(arrayOfByte1, 0, arrayOfByte1.length);
    byte[] arrayOfByte2 = localMessageDigest.digest();
    StringBuilder localStringBuilder = new StringBuilder(2 * arrayOfByte2.length);
    while (i < arrayOfByte2.length)
    {
      int j = 0xFF & arrayOfByte2[i];
      if (j < 16)
        localStringBuilder.append("0");
      localStringBuilder.append(Integer.toHexString(j).toLowerCase());
      i++;
    }
    return localStringBuilder.toString();
  }

  public static String a(Map<String, String> paramMap, String paramString)
  {
    return a(b(paramMap, paramString));
  }

  protected static List<String> a(Map<String, String> paramMap)
  {
    ArrayList localArrayList = new ArrayList(new HashSet(paramMap.keySet()));
    Collections.sort(localArrayList);
    return localArrayList;
  }

  protected static String b(Map<String, String> paramMap, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    Iterator localIterator = a(paramMap).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder.append(str).append("=").append((String)paramMap.get(str));
    }
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.FacebookPlatform
 * JD-Core Version:    0.6.0
 */