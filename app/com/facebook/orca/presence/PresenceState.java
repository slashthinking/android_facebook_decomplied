package com.facebook.orca.presence;

public class PresenceState
{
  public static PresenceState a = new PresenceState(Availability.NONE, false, false);
  private final Availability b;
  private final boolean c;
  private final boolean d;

  public PresenceState(Availability paramAvailability, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.b = paramAvailability;
    this.c = paramBoolean1;
    this.d = paramBoolean2;
  }

  public Availability a()
  {
    return this.b;
  }

  public boolean b()
  {
    return this.c;
  }

  public boolean c()
  {
    return this.d;
  }

  public boolean equals(Object paramObject)
  {
    int i = 1;
    if (this == paramObject);
    while (true)
    {
      return i;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
      {
        i = 0;
        continue;
      }
      PresenceState localPresenceState = (PresenceState)paramObject;
      if (this.c != localPresenceState.c)
      {
        i = 0;
        continue;
      }
      if (this.d != localPresenceState.d)
      {
        i = 0;
        continue;
      }
      if (this.b == localPresenceState.b)
        continue;
      i = 0;
    }
  }

  public int hashCode()
  {
    int i = 1;
    int j;
    int m;
    label32: int n;
    if (this.b != null)
    {
      j = this.b.hashCode();
      int k = j * 31;
      if (!this.c)
        break label58;
      m = i;
      n = 31 * (m + k);
      if (!this.d)
        break label64;
    }
    while (true)
    {
      return n + i;
      j = 0;
      break;
      label58: m = 0;
      break label32;
      label64: i = 0;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.presence.PresenceState
 * JD-Core Version:    0.6.0
 */