package com.google.inject.internal;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

public class MoreTypes$WildcardTypeImpl
  implements MoreTypes.CompositeType, Serializable, WildcardType
{
  private static final long serialVersionUID;
  private final Type lowerBound;
  private final Type upperBound;

  public MoreTypes$WildcardTypeImpl(Type[] paramArrayOfType1, Type[] paramArrayOfType2)
  {
    if (paramArrayOfType2.length <= i)
    {
      int k = i;
      Preconditions.checkArgument(k, "Must have at most one lower bound.");
      if (paramArrayOfType1.length != i)
        break label98;
      int n = i;
      label31: Preconditions.checkArgument(n, "Must have exactly one upper bound.");
      if (paramArrayOfType2.length != i)
        break label109;
      Preconditions.checkNotNull(paramArrayOfType2[0], "lowerBound");
      MoreTypes.a(paramArrayOfType2[0], "wildcard bounds");
      if (paramArrayOfType1[0] != Object.class)
        break label104;
      label69: Preconditions.checkArgument(i, "bounded both ways");
      this.lowerBound = MoreTypes.a(paramArrayOfType2[0]);
    }
    for (this.upperBound = Object.class; ; this.upperBound = MoreTypes.a(paramArrayOfType1[0]))
    {
      return;
      int m = 0;
      break;
      label98: int i1 = 0;
      break label31;
      label104: int j = 0;
      break label69;
      label109: Preconditions.checkNotNull(paramArrayOfType1[0], "upperBound");
      MoreTypes.a(paramArrayOfType1[0], "wildcard bounds");
      this.lowerBound = null;
    }
  }

  public boolean a()
  {
    if ((MoreTypes.d(this.upperBound)) && ((this.lowerBound == null) || (MoreTypes.d(this.lowerBound))));
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean equals(Object paramObject)
  {
    if (((paramObject instanceof WildcardType)) && (MoreTypes.a(this, (WildcardType)paramObject)));
    for (int i = 1; ; i = 0)
      return i;
  }

  public Type[] getLowerBounds()
  {
    Type[] arrayOfType;
    if (this.lowerBound != null)
    {
      arrayOfType = new Type[1];
      arrayOfType[0] = this.lowerBound;
    }
    while (true)
    {
      return arrayOfType;
      arrayOfType = MoreTypes.a;
    }
  }

  public Type[] getUpperBounds()
  {
    Type[] arrayOfType = new Type[1];
    arrayOfType[0] = this.upperBound;
    return arrayOfType;
  }

  public int hashCode()
  {
    if (this.lowerBound != null);
    for (int i = 31 + this.lowerBound.hashCode(); ; i = 1)
      return i ^ 31 + this.upperBound.hashCode();
  }

  public String toString()
  {
    String str;
    if (this.lowerBound != null)
      str = "? super " + MoreTypes.c(this.lowerBound);
    while (true)
    {
      return str;
      if (this.upperBound == Object.class)
      {
        str = "?";
        continue;
      }
      str = "? extends " + MoreTypes.c(this.upperBound);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.inject.internal.MoreTypes.WildcardTypeImpl
 * JD-Core Version:    0.6.0
 */