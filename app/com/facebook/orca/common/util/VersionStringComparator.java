package com.facebook.orca.common.util;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VersionStringComparator
  implements Comparator<String>
{
  private static final Pattern a = Pattern.compile("(\\d*)(\\D*)");

  int a(int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt1 < paramInt2)
      i = -1;
    while (true)
    {
      return i;
      if (paramInt1 > paramInt2)
      {
        i = 1;
        continue;
      }
      i = 0;
    }
  }

  int a(String paramString, int paramInt)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      paramInt = i;
      label9: return paramInt;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      break label9;
    }
  }

  public int a(String paramString1, String paramString2)
  {
    String[] arrayOfString1 = paramString1.trim().split("\\.");
    String[] arrayOfString2 = paramString2.trim().split("\\.");
    int i = Math.max(arrayOfString1.length, arrayOfString2.length);
    int j = 0;
    int k = 0;
    String str1;
    label62: String str2;
    label77: Matcher localMatcher1;
    Matcher localMatcher2;
    int m;
    if ((k == 0) && (j < i))
      if (j < arrayOfString1.length)
      {
        str1 = arrayOfString1[j];
        if (j >= arrayOfString2.length)
          break label142;
        str2 = arrayOfString2[j];
        localMatcher1 = a.matcher(str1);
        localMatcher2 = a.matcher(str2);
        m = k;
      }
    label142: label167: label185: label318: label323: 
    while (true)
    {
      boolean bool1 = localMatcher1.find();
      boolean bool2 = localMatcher2.find();
      if ((!bool1) && (!bool2))
      {
        j++;
        k = m;
        break;
        str1 = "";
        break label62;
        str2 = "";
        break label77;
      }
      int n;
      int i1;
      int i2;
      String str3;
      label213: String str4;
      if (bool1)
      {
        n = a(localMatcher1.group(1), 0);
        if (!bool2)
          break label273;
        i1 = a(localMatcher2.group(1), 0);
        i2 = a(n, i1);
        if (i2 != 0)
          break label318;
        if (!bool1)
          break label279;
        str3 = localMatcher1.group(2);
        if (!bool2)
          break label286;
        str4 = localMatcher2.group(2);
        label226: if ((str3.length() != 0) || (str4.length() <= 0))
          break label293;
        i2 = 1;
        label245: if (i2 != 0)
          break label318;
      }
      for (m = str3.compareTo(str4); ; m = i2)
      {
        if (m == 0)
          break label323;
        break;
        n = 0;
        break label167;
        i1 = 0;
        break label185;
        str3 = "";
        break label213;
        str4 = "";
        break label226;
        if ((str4.length() != 0) || (str3.length() <= 0))
          break label245;
        i2 = -1;
        break label245;
        return k;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.util.VersionStringComparator
 * JD-Core Version:    0.6.0
 */