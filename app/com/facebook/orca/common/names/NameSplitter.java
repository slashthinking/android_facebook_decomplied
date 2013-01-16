package com.facebook.orca.common.names;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

public class NameSplitter
{
  private static final String a = Locale.JAPANESE.getLanguage().toLowerCase();
  private static final String b = Locale.KOREAN.getLanguage().toLowerCase();
  private static final String c = Locale.CHINESE.getLanguage().toLowerCase();
  private final HashSet<String> d;
  private final HashSet<String> e;
  private final int f;
  private final HashSet<String> g;
  private final HashSet<String> h;
  private final Locale i;
  private final String j;

  public NameSplitter(String paramString1, String paramString2, String paramString3, String paramString4, Locale paramLocale)
  {
    this.d = a(paramString1);
    this.g = a(paramString2);
    this.e = a(paramString3);
    this.h = a(paramString4);
    int k;
    label74: String str;
    if (paramLocale != null)
    {
      this.i = paramLocale;
      this.j = this.i.getLanguage().toLowerCase();
      Iterator localIterator = this.e.iterator();
      k = 0;
      if (!localIterator.hasNext())
        break label128;
      str = (String)localIterator.next();
      if (str.length() <= k)
        break label135;
    }
    label128: label135: for (int m = str.length(); ; m = k)
    {
      k = m;
      break label74;
      paramLocale = Locale.getDefault();
      break;
      this.f = k;
      return;
    }
  }

  private static HashSet<String> a(String paramString)
  {
    HashSet localHashSet = new HashSet();
    if (paramString != null)
    {
      String[] arrayOfString = paramString.split(",");
      for (int k = 0; k < arrayOfString.length; k++)
        localHashSet.add(arrayOfString[k].trim().toUpperCase());
    }
    return localHashSet;
  }

  public int a(int paramInt)
  {
    if (paramInt == 0)
      if (a.equals(this.j))
        paramInt = 4;
    while (true)
    {
      return paramInt;
      if (b.equals(this.j))
      {
        paramInt = 5;
        continue;
      }
      if (c.equals(this.j))
      {
        paramInt = 3;
        continue;
      }
      paramInt = 1;
      continue;
      if (paramInt != 2)
        continue;
      if (a.equals(this.j))
      {
        paramInt = 4;
        continue;
      }
      if (b.equals(this.j))
      {
        paramInt = 5;
        continue;
      }
      paramInt = 3;
    }
  }

  public int a(String[] paramArrayOfString, String paramString)
  {
    int k = 0;
    if (paramString == null);
    while (true)
    {
      return k;
      NameSplitter.NameTokenizer localNameTokenizer = new NameSplitter.NameTokenizer(paramString);
      int m = NameSplitter.NameTokenizer.a(localNameTokenizer);
      int n = NameSplitter.NameTokenizer.b(localNameTokenizer);
      k = 0;
      if (m == n)
        continue;
      String str = NameSplitter.NameTokenizer.c(localNameTokenizer)[NameSplitter.NameTokenizer.a(localNameTokenizer)];
      if (this.d.contains(str.toUpperCase()))
        NameSplitter.NameTokenizer.d(localNameTokenizer);
      int i1 = NameSplitter.NameTokenizer.a(localNameTokenizer);
      while (i1 < NameSplitter.NameTokenizer.b(localNameTokenizer))
      {
        int i2 = k + 1;
        paramArrayOfString[k] = NameSplitter.NameTokenizer.c(localNameTokenizer)[i1];
        i1++;
        k = i2;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.names.NameSplitter
 * JD-Core Version:    0.6.0
 */