package com.facebook.device_id;

import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;

public class UniqueDeviceId
{
  private final String a;
  private final long b;

  public UniqueDeviceId(String paramString, long paramLong)
  {
    this.a = paramString;
    this.b = paramLong;
  }

  public String a()
  {
    return this.a;
  }

  public long b()
  {
    return this.b;
  }

  public String toString()
  {
    return Objects.toStringHelper(UniqueDeviceId.class).add("id", this.a).add("timestamp", Long.valueOf(this.b)).toString();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.device_id.UniqueDeviceId
 * JD-Core Version:    0.6.0
 */