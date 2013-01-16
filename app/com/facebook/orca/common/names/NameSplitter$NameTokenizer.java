package com.facebook.orca.common.names;

import java.util.StringTokenizer;

class NameSplitter$NameTokenizer extends StringTokenizer
{
  private final String[] a = new String[10];
  private int b;
  private int c;
  private int d;
  private int e;

  public NameSplitter$NameTokenizer(String paramString)
  {
    super(paramString, " .,", true);
    while ((hasMoreTokens()) && (this.e < 10))
    {
      String str = nextToken();
      if ((str.length() > 0) && (str.charAt(0) == ' '))
        continue;
      if ((this.e > 0) && (str.charAt(0) == '.'))
      {
        this.b |= 1 << -1 + this.e;
        continue;
      }
      if ((this.e > 0) && (str.charAt(0) == ','))
      {
        this.c |= 1 << -1 + this.e;
        continue;
      }
      this.a[this.e] = str;
      this.e = (1 + this.e);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.names.NameSplitter.NameTokenizer
 * JD-Core Version:    0.6.0
 */