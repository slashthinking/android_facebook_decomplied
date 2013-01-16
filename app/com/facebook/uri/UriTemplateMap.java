package com.facebook.uri;

import android.net.Uri;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UriTemplateMap<T>
{
  private static final Pattern b = Pattern.compile("\\{([#]?)([^ }]+)\\}");
  private static final Pattern c = Pattern.compile("\\{([#!]?)([^ }]+)(?: ([^}]+))?\\}");
  private static final Pattern d = Pattern.compile("&?([^=]+)=([^&]+)");
  private final List<UriTemplateMap<T>.MapEntry> a = new ArrayList();

  private static Map<String, String> d(String paramString)
  {
    HashMap localHashMap = new HashMap();
    Matcher localMatcher = d.matcher(paramString);
    while (localMatcher.find())
      localHashMap.put(Uri.decode(localMatcher.group(1)), Uri.decode(localMatcher.group(2)));
    return localHashMap;
  }

  private static String[] e(String paramString)
  {
    int i = 0;
    int j = 0;
    String[] arrayOfString2;
    if (i < paramString.length())
    {
      switch (paramString.charAt(i))
      {
      default:
      case '{':
      case '}':
      case '?':
      }
      do
        while (true)
        {
          i++;
          break;
          j = 1;
          continue;
          j = 0;
        }
      while (j != 0);
      arrayOfString2 = new String[2];
      arrayOfString2[0] = paramString.substring(0, i);
      arrayOfString2[1] = paramString.substring(i + 1);
    }
    for (String[] arrayOfString1 = arrayOfString2; ; arrayOfString1 = new String[] { paramString, "" })
      return arrayOfString1;
  }

  public UriTemplateMap.UriMatch<T> a(String paramString)
  {
    if (paramString == null)
      throw new UriTemplateMap.InvalidUriException("Key may not be null");
    Iterator localIterator = this.a.iterator();
    UriTemplateMap.UriMatch localUriMatch;
    do
    {
      if (!localIterator.hasNext())
        break;
      localUriMatch = ((UriTemplateMap.MapEntry)localIterator.next()).a(paramString);
    }
    while (localUriMatch == null);
    while (true)
    {
      return localUriMatch;
      localUriMatch = null;
    }
  }

  public void a(String paramString, T paramT)
  {
    if (paramString == null)
      throw new UriTemplateMap.InvalidUriTemplateException("Key template may not be null");
    this.a.add(new UriTemplateMap.MapEntry(this, paramString, paramT));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.uri.UriTemplateMap
 * JD-Core Version:    0.6.0
 */