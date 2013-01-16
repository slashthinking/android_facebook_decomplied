package android.support.v4.view;

class KeyEventCompat$BaseKeyEventVersionImpl
  implements KeyEventCompat.KeyEventVersionImpl
{
  private static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = 1;
    int j;
    int k;
    if ((paramInt2 & paramInt3) != 0)
    {
      j = i;
      k = paramInt4 | paramInt5;
      if ((paramInt2 & k) == 0)
        break label52;
    }
    while (true)
    {
      if (j == 0)
        break label67;
      if (i == 0)
        break label58;
      throw new IllegalArgumentException("bad arguments");
      j = 0;
      break;
      label52: i = 0;
    }
    label58: paramInt1 &= (k ^ 0xFFFFFFFF);
    while (true)
    {
      return paramInt1;
      label67: if (i == 0)
        continue;
      paramInt1 &= (paramInt3 ^ 0xFFFFFFFF);
    }
  }

  public int a(int paramInt)
  {
    if ((paramInt & 0xC0) != 0);
    for (int i = paramInt | 0x1; ; i = paramInt)
    {
      if ((i & 0x30) != 0)
        i |= 2;
      return i & 0xF7;
    }
  }

  public boolean a(int paramInt1, int paramInt2)
  {
    int i = 1;
    if (a(a(0xF7 & a(paramInt1), paramInt2, i, 64, 128), paramInt2, 2, 16, 32) == paramInt2);
    while (true)
    {
      return i;
      i = 0;
    }
  }

  public boolean b(int paramInt)
  {
    if ((0xF7 & a(paramInt)) == 0);
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.view.KeyEventCompat.BaseKeyEventVersionImpl
 * JD-Core Version:    0.6.0
 */