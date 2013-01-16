package com.facebook.orca.common.util;

import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import java.util.Arrays;

public class SqlUtil
{
  public static String a(Iterable<Long> paramIterable)
  {
    return "(" + Joiner.on(',').join(paramIterable) + ")";
  }

  public static String a(String[] paramArrayOfString)
  {
    return b(Arrays.asList(paramArrayOfString));
  }

  public static String b(Iterable<?> paramIterable)
  {
    Iterable localIterable = Iterables.a(paramIterable, new SqlUtil.1());
    return "(" + Joiner.on(',').join(localIterable) + ")";
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.util.SqlUtil
 * JD-Core Version:    0.6.0
 */