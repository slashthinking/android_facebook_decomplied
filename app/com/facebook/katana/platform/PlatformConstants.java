package com.facebook.katana.platform;

import java.util.Arrays;
import java.util.List;

public class PlatformConstants
{
  public static final List<Integer> a;

  static
  {
    Integer[] arrayOfInteger = new Integer[1];
    arrayOfInteger[0] = Integer.valueOf(20121101);
    a = Arrays.asList(arrayOfInteger);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.PlatformConstants
 * JD-Core Version:    0.6.0
 */