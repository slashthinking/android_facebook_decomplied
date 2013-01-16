package com.facebook.orca.sms;

import com.google.common.base.Preconditions;

class FetchMmsSmsThreadListParams
{
  private final int a;
  private final Long b;
  private final Long c;

  private FetchMmsSmsThreadListParams(int paramInt, Long paramLong1, Long paramLong2)
  {
    if (paramInt > 0);
    for (boolean bool1 = true; ; bool1 = false)
    {
      Preconditions.checkArgument(bool1);
      boolean bool2;
      if (paramLong1 == null)
      {
        bool2 = false;
        if (paramLong2 == null);
      }
      else
      {
        bool2 = true;
      }
      Preconditions.checkArgument(bool2);
      this.a = paramInt;
      this.b = paramLong1;
      this.c = paramLong2;
      return;
    }
  }

  static FetchMmsSmsThreadListParams a(int paramInt, long paramLong)
  {
    return new FetchMmsSmsThreadListParams(paramInt, Long.valueOf(paramLong), null);
  }

  static FetchMmsSmsThreadListParams b(int paramInt, long paramLong)
  {
    return new FetchMmsSmsThreadListParams(paramInt, null, Long.valueOf(paramLong));
  }

  int a()
  {
    return this.a;
  }

  Long b()
  {
    return this.b;
  }

  Long c()
  {
    return this.c;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.FetchMmsSmsThreadListParams
 * JD-Core Version:    0.6.0
 */