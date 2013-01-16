package com.facebook.common.util;

public class Tuple<T0, T1>
{
  public final T0 a;
  public final T1 b;

  public Tuple(T0 paramT0, T1 paramT1)
  {
    this.a = paramT0;
    this.b = paramT1;
  }

  public boolean equals(Object paramObject)
  {
    int i = 0;
    if (paramObject != null)
    {
      boolean bool1 = paramObject instanceof Tuple;
      i = 0;
      if (bool1)
        break label19;
    }
    while (true)
    {
      return i;
      label19: Tuple localTuple = (Tuple)paramObject;
      if ((this.a != localTuple.a) && (this.a != null))
      {
        boolean bool3 = this.a.equals(localTuple.a);
        i = 0;
        if (!bool3)
          continue;
      }
      if ((this.b != localTuple.b) && (this.b != null))
      {
        boolean bool2 = this.b.equals(localTuple.b);
        i = 0;
        if (!bool2)
          continue;
      }
      i = 1;
    }
  }

  public int hashCode()
  {
    Object localObject = this.a;
    int i = 0;
    if (localObject != null)
      i = 0x0 ^ this.a.hashCode();
    if (this.b != null)
      i ^= this.b.hashCode();
    return i;
  }

  public String toString()
  {
    String str1 = "<";
    if (this.a != null)
      str1 = str1 + this.a;
    String str2 = str1 + ":";
    if (this.b != null)
      str2 = str2 + this.b;
    return str2 + ">";
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.common.util.Tuple
 * JD-Core Version:    0.6.0
 */