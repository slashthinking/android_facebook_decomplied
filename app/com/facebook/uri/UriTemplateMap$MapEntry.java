package com.facebook.uri;

import android.os.Bundle;
import com.facebook.common.util.Tuple;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class UriTemplateMap$MapEntry
{
  List<Tuple<Class<?>, String>> a = new ArrayList();
  private final Map<String, UriTemplateMap<T>.QueryParameter> c = new HashMap();
  private final Pattern d;
  private final T e;

  UriTemplateMap$MapEntry(String paramString, T paramT)
  {
    Object localObject1;
    this.e = localObject1;
    String[] arrayOfString = UriTemplateMap.b(paramT);
    String str1 = arrayOfString[0];
    String str2 = arrayOfString[1];
    Matcher localMatcher1 = UriTemplateMap.a().matcher(str1);
    if (str1.endsWith("/"))
      str1 = str1.substring(0, -1 + str1.length());
    HashSet localHashSet = new HashSet();
    if (localMatcher1.find())
    {
      String str6 = localMatcher1.group(0);
      boolean bool = localMatcher1.group(1).equals("#");
      if (bool);
      for (Object localObject2 = Long.class; ; localObject2 = String.class)
      {
        String str7 = localMatcher1.group(2);
        this.a.add(new Tuple(localObject2, str7));
        if (localHashSet.add(str7))
          break;
        throw new UriTemplateMap.InvalidUriTemplateException("Duplicate template key");
      }
      if (bool);
      for (String str8 = "(-?[0-9]+)"; ; str8 = "([^/]+)")
      {
        str1 = str1.replace(str6, str8);
        break;
      }
    }
    this.d = Pattern.compile(str1 + "[/]?");
    Iterator localIterator = UriTemplateMap.c(str2).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Matcher localMatcher2 = UriTemplateMap.b().matcher((CharSequence)localEntry.getValue());
      if (!localMatcher2.matches())
        throw new UriTemplateMap.InvalidUriTemplateException("Query parameter does not match templating syntax");
      UriTemplateMap.TemplateValueType localTemplateValueType = UriTemplateMap.TemplateValueType.STRING;
      if ("#".equals(localMatcher2.group(1)))
        localTemplateValueType = UriTemplateMap.TemplateValueType.LONG;
      String str3;
      String str4;
      String str5;
      while (true)
      {
        str3 = localMatcher2.group(2);
        str4 = localMatcher2.group(3);
        str5 = (String)localEntry.getKey();
        if (localHashSet.add(str5))
          break;
        throw new UriTemplateMap.InvalidUriTemplateException("Duplicate template key");
        if (!"!".equals(localMatcher2.group(1)))
          continue;
        localTemplateValueType = UriTemplateMap.TemplateValueType.BOOLEAN;
      }
      this.c.put(str5, new UriTemplateMap.QueryParameter(paramString, str3, localTemplateValueType, str4));
    }
  }

  UriTemplateMap.UriMatch<T> a(String paramString)
  {
    String[] arrayOfString = UriTemplateMap.b(paramString);
    String str1 = arrayOfString[0];
    String str2 = arrayOfString[1];
    Matcher localMatcher = this.d.matcher(str1);
    UriTemplateMap.UriMatch localUriMatch;
    if (!localMatcher.matches())
      localUriMatch = null;
    while (true)
    {
      return localUriMatch;
      Bundle localBundle = new Bundle();
      int i = 0;
      if (i < this.a.size())
      {
        Tuple localTuple = (Tuple)this.a.get(i);
        if (localTuple.a == Long.class)
          localBundle.putLong((String)localTuple.b, Long.parseLong(localMatcher.group(i + 1)));
        while (true)
        {
          i++;
          break;
          localBundle.putString((String)localTuple.b, localMatcher.group(i + 1));
        }
      }
      Map localMap = UriTemplateMap.c(str2);
      Iterator localIterator = this.c.entrySet().iterator();
      while (true)
      {
        if (!localIterator.hasNext())
          break label351;
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str3 = (String)localEntry.getKey();
        UriTemplateMap.QueryParameter localQueryParameter = (UriTemplateMap.QueryParameter)localEntry.getValue();
        String str4 = localQueryParameter.c;
        if ((localQueryParameter.a) && (!localMap.containsKey(str3)))
        {
          localUriMatch = null;
          break;
        }
        if (localMap.containsKey(str3));
        for (String str5 = (String)localMap.get(str3); ; str5 = localQueryParameter.b)
        {
          if (localQueryParameter.d != UriTemplateMap.TemplateValueType.LONG)
            break label310;
          localBundle.putLong(str4, Long.parseLong(str5));
          break;
        }
        label310: if (localQueryParameter.d == UriTemplateMap.TemplateValueType.BOOLEAN)
        {
          localBundle.putBoolean(str4, Boolean.valueOf(str5).booleanValue());
          continue;
        }
        localBundle.putString(str4, str5);
      }
      label351: localUriMatch = new UriTemplateMap.UriMatch(this.e, localBundle);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.uri.UriTemplateMap.MapEntry
 * JD-Core Version:    0.6.0
 */