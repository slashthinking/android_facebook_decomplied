package com.facebook.location;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.Set;

public class GetDeviceLocationParamsBuilder
{
  private long a = 5000L;
  private long b = 120000L;
  private float c = -1.0F;
  private long d = 250L;
  private float e = 10.0F;
  private long f = 120000L;
  private float g = 100.0F;
  private long h = 120000L;
  private float i = 200.0F;
  private Set<String> j = ImmutableSet.a("network", "gps", "passive");
  private boolean k = false;

  public long a()
  {
    return this.a;
  }

  public GetDeviceLocationParamsBuilder a(float paramFloat)
  {
    if ((paramFloat >= 0.0F) || (paramFloat == -1.0F));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.g = paramFloat;
      return this;
    }
  }

  public GetDeviceLocationParamsBuilder a(long paramLong)
  {
    if (paramLong >= 0L);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.a = paramLong;
      return this;
    }
  }

  public long b()
  {
    return this.b;
  }

  public float c()
  {
    return this.c;
  }

  public long d()
  {
    return this.d;
  }

  public float e()
  {
    return this.e;
  }

  public long f()
  {
    return this.f;
  }

  public float g()
  {
    return this.g;
  }

  public long h()
  {
    return this.h;
  }

  public float i()
  {
    return this.i;
  }

  public Set<String> j()
  {
    return this.j;
  }

  public boolean k()
  {
    return this.k;
  }

  public GetDeviceLocationParams l()
  {
    return new GetDeviceLocationParams(this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.location.GetDeviceLocationParamsBuilder
 * JD-Core Version:    0.6.0
 */