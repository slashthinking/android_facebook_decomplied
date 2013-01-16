package com.google.inject.internal;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

public class MoreTypes$GenericArrayTypeImpl
  implements MoreTypes.CompositeType, Serializable, GenericArrayType
{
  private static final long serialVersionUID;
  private final Type componentType;

  public MoreTypes$GenericArrayTypeImpl(Type paramType)
  {
    this.componentType = MoreTypes.a(paramType);
  }

  public boolean a()
  {
    return MoreTypes.d(this.componentType);
  }

  public boolean equals(Object paramObject)
  {
    if (((paramObject instanceof GenericArrayType)) && (MoreTypes.a(this, (GenericArrayType)paramObject)));
    for (int i = 1; ; i = 0)
      return i;
  }

  public Type getGenericComponentType()
  {
    return this.componentType;
  }

  public int hashCode()
  {
    return this.componentType.hashCode();
  }

  public String toString()
  {
    return MoreTypes.c(this.componentType) + "[]";
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.inject.internal.MoreTypes.GenericArrayTypeImpl
 * JD-Core Version:    0.6.0
 */