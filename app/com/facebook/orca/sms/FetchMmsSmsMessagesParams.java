package com.facebook.orca.sms;

import com.google.common.base.Preconditions;

class FetchMmsSmsMessagesParams
{
  private final long a;
  private final int b;
  private final Long c;
  private final Long d;

  private FetchMmsSmsMessagesParams(long paramLong, int paramInt, Long paramLong1, Long paramLong2)
  {
    if (paramInt >= 0);
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
      this.a = paramLong;
      this.b = paramInt;
      this.c = paramLong1;
      this.d = paramLong2;
      return;
    }
  }

  static FetchMmsSmsMessagesParams a(long paramLong1, int paramInt, long paramLong2)
  {
    return new FetchMmsSmsMessagesParams(paramLong1, paramInt, Long.valueOf(paramLong2), null);
  }

  static FetchMmsSmsMessagesParams b(long paramLong1, int paramInt, long paramLong2)
  {
    return new FetchMmsSmsMessagesParams(paramLong1, paramInt, null, Long.valueOf(paramLong2));
  }

  long a()
  {
    return this.a;
  }

  int b()
  {
    return this.b;
  }

  Long c()
  {
    return this.c;
  }

  Long d()
  {
    return this.d;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.FetchMmsSmsMessagesParams
 * JD-Core Version:    0.6.0
 */