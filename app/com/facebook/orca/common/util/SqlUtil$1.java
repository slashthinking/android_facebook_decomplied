package com.facebook.orca.common.util;

import com.google.common.base.Function;

final class SqlUtil$1
  implements Function<Object, String>
{
  public String a(Object paramObject)
  {
    return "\"" + paramObject + "\"";
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.util.SqlUtil.1
 * JD-Core Version:    0.6.0
 */