package com.facebook.widget.tagging;

import java.util.regex.Pattern;

public class TaggingProfile
{
  private static final Pattern g = Pattern.compile(" +");
  private final String a;
  private final long b;
  private final String c;
  private final String d;
  private final TaggingProfile.Type e;
  private final String f;

  public TaggingProfile(String paramString1, long paramLong, String paramString2, TaggingProfile.Type paramType)
  {
    this(paramString1, paramLong, paramString2, paramType, null);
  }

  public TaggingProfile(String paramString1, long paramLong, String paramString2, TaggingProfile.Type paramType, String paramString3)
  {
    this.a = paramString1;
    this.b = paramLong;
    this.c = paramString2;
    this.e = paramType;
    this.d = paramString3;
    this.f = this.a.toLowerCase();
  }

  public String a()
  {
    return this.a;
  }

  public boolean a(String paramString)
  {
    boolean bool;
    if (!paramString.contains(" "))
      bool = this.f.contains(paramString);
    while (true)
    {
      return bool;
      String[] arrayOfString = g.split(paramString);
      int i = arrayOfString.length;
      int j = 0;
      int k = 0;
      while (true)
      {
        if (j >= i)
          break label89;
        String str = arrayOfString[j];
        int m = this.f.indexOf(str, k);
        bool = false;
        if (m == -1)
          break;
        k = m + str.length();
        j++;
      }
      label89: bool = true;
    }
  }

  public long b()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }

  public TaggingProfile.Type d()
  {
    return this.e;
  }

  public String e()
  {
    return this.d;
  }

  public String toString()
  {
    return this.a;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.tagging.TaggingProfile
 * JD-Core Version:    0.6.2
 */