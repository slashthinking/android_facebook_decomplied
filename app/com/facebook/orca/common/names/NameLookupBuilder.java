package com.facebook.orca.common.names;

import java.util.Arrays;
import java.util.Iterator;

public abstract class NameLookupBuilder
{
  private static int[] e = { 4352, 4353, 0, 4354, 0, 0, 4355, 4356, 4357, 0, 0, 0, 0, 0, 0, 0, 4358, 4359, 4360, 0, 4361, 4362, 4363, 4364, 4365, 4366, 4367, 4368, 4369, 4370 };
  private static int f = 30;
  private final NameSplitter a;
  private String[][] b = new String[4][];
  private StringBuilder c = new StringBuilder();
  private String[] d = new String[10];

  public NameLookupBuilder(NameSplitter paramNameSplitter)
  {
    this.a = paramNameSplitter;
  }

  private void a(String paramString, int paramInt)
  {
    int i = 0;
    this.c.setLength(0);
    while (i < paramInt)
    {
      this.c.append(this.d[i]);
      i++;
    }
    a(paramString, 2, this.c.toString());
  }

  private void a(String paramString, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      String[] arrayOfString = this.b[paramInt1];
      if (arrayOfString != null)
      {
        String str = this.d[paramInt1];
        for (int i = 0; i < arrayOfString.length; i++)
        {
          this.d[paramInt1] = arrayOfString[i];
          a(paramString, 0, paramInt2, false, false);
          a(paramString, paramInt1 + 1, paramInt2);
        }
        this.d[paramInt1] = str;
      }
      paramInt1++;
    }
  }

  private void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = 0;
    this.c.setLength(0);
    while (i < paramInt1)
    {
      if (i != 0)
        this.c.append('.');
      this.c.append(this.d[i]);
      i++;
    }
    a(paramString, paramInt2, this.c.toString());
    if (paramBoolean)
      a(paramString, paramInt1);
  }

  private void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramInt1 == paramInt2)
    {
      if (paramBoolean1);
      for (int k = 0; ; k = 1)
      {
        a(paramString, paramInt2, k, paramBoolean2);
        return;
      }
    }
    String str = this.d[paramInt1];
    int i = paramInt1;
    label41: int j;
    if (i < paramInt2)
    {
      this.d[paramInt1] = this.d[i];
      this.d[i] = str;
      j = paramInt1 + 1;
      if ((!paramBoolean1) || (i != paramInt1))
        break label127;
    }
    label127: for (boolean bool = true; ; bool = false)
    {
      a(paramString, j, paramInt2, bool, paramBoolean2);
      this.d[i] = this.d[paramInt1];
      this.d[paramInt1] = str;
      i++;
      break label41;
      break;
    }
  }

  private void a(String paramString1, String paramString2)
  {
    int i = 0;
    int j = paramString2.length();
    this.c.setLength(0);
    int m;
    for (int k = 0; ; k = m)
    {
      m = k + 1;
      int n = paramString2.codePointAt(k);
      if (n == 32)
        if (m < j)
          continue;
      while (true)
      {
        label47: if (i > 1)
          a(paramString1, 7, b(this.c.toString()));
        return;
        if ((n < 4352) || ((n > 4370) && (n < 12593)) || ((n > 12622) && (n < 44032)) || (n > 55203))
          continue;
        if (n >= 44032)
          n = 4352 + (n - 44032) / 588;
        do
        {
          do
          {
            this.c.appendCodePoint(n);
            i++;
            break;
          }
          while (n < 12593);
          if (n - 12593 >= f)
            break label47;
          n = e[(n - 12593)];
        }
        while (n != 0);
      }
    }
  }

  private void b(String paramString1, String paramString2, int paramInt)
  {
    if (paramInt == 5)
      a(paramString1, paramString2);
  }

  private void c(String paramString1, String paramString2, int paramInt)
  {
    Iterator localIterator = ContactLocaleUtils.a().a(paramString2, paramInt);
    if (localIterator != null)
      while (localIterator.hasNext())
        a(paramString1, 6, b((String)localIterator.next()));
  }

  protected abstract void a(String paramString1, int paramInt, String paramString2);

  public void a(String paramString1, String paramString2, int paramInt)
  {
    int i = this.a.a(this.d, paramString2);
    if (i == 0);
    while (true)
    {
      return;
      a(paramString1, paramString2, this.d, i, paramInt);
    }
  }

  public void a(String paramString1, String paramString2, String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    int i = 4;
    this.d = paramArrayOfString;
    for (int j = 0; j < paramInt1; j++)
      this.d[j] = b(this.d[j]);
    int k;
    if (paramInt1 > i)
      k = 1;
    while (k != 0)
    {
      a(paramString1, paramInt1, 0, true);
      Arrays.sort(this.d, 0, paramInt1, new NameLookupBuilder.1(this));
      String str = this.d[0];
      int n = i;
      while (true)
        if (n < paramInt1)
        {
          this.d[0] = this.d[n];
          a(paramString1, i);
          n++;
          continue;
          k = 0;
          break;
        }
      this.d[0] = str;
    }
    while (true)
    {
      for (int m = 0; m < i; m++)
        this.b[m] = a(this.d[m]);
      if (k == 0);
      for (boolean bool = true; ; bool = false)
      {
        a(paramString1, 0, i, bool, true);
        a(paramString1, 0, i);
        c(paramString1, paramString2, paramInt2);
        b(paramString1, paramString2, paramInt2);
        return;
      }
      i = paramInt1;
    }
  }

  protected abstract String[] a(String paramString);

  protected String b(String paramString)
  {
    return NameNormalizer.a(paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.names.NameLookupBuilder
 * JD-Core Version:    0.6.0
 */