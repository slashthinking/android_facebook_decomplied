package com.facebook.katana.util.logging;

import android.content.Context;
import com.facebook.common.util.Log;
import com.facebook.katana.Constants.URL;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class DataCounterNames
{
  private static Class<?> a = DataCounterNames.class;
  private static String b = "fbcdn";
  private static String c = "fbexternal";
  private static HashMap<String, String> d;
  private static String e = "_received";
  private static String f = "_sent";
  private static String g = "api";
  private static String h = "api_video";
  private static String i = "graph";
  private static String j = "crash_report";
  private static String k = "log";
  private static String l = "cdn";
  private static String m = "deal";
  private static String n = "other_fb";
  private static String o = "uncategorized";

  public static String a(URI paramURI)
  {
    return b(paramURI) + f;
  }

  public static String a(URI paramURI, String paramString)
  {
    String str = "";
    if (paramString != null)
    {
      int i1 = paramString.indexOf("/");
      if (i1 > 0)
        str = "_" + paramString.substring(0, i1);
    }
    return b(paramURI) + str + e;
  }

  static void a(Context paramContext)
  {
    d = new LinkedHashMap();
    a(Constants.URL.i(paramContext), g);
    a(Constants.URL.c(paramContext), g);
    a(Constants.URL.b(paramContext), g);
    a(Constants.URL.g(paramContext), h);
    a(Constants.URL.d(paramContext), i);
    a(Constants.URL.m(paramContext), j);
    a(Constants.URL.h(paramContext), k);
    a(Constants.URL.j(paramContext), m);
  }

  private static void a(String paramString1, String paramString2)
  {
    d.put(paramString1, paramString2);
  }

  private static String b(URI paramURI)
  {
    String str1 = paramURI.toString();
    Iterator localIterator = d.entrySet().iterator();
    String str3;
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (!str1.startsWith((String)localEntry.getKey()))
        continue;
      str3 = (String)localEntry.getValue();
    }
    while (true)
    {
      return str3;
      String str2 = paramURI.getAuthority();
      if ((str2 != null) && ((str2.contains(b)) || (str2.contains(c))))
      {
        str3 = l;
        continue;
      }
      if (Constants.URL.a(paramURI.toString()))
      {
        str3 = n;
        continue;
      }
      Log.d(a, "Uncategorized Uri: " + paramURI.toString());
      str3 = o;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.logging.DataCounterNames
 * JD-Core Version:    0.6.0
 */