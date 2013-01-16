package com.google.inject.internal;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

public class MoreTypes$ParameterizedTypeImpl
  implements MoreTypes.CompositeType, Serializable, ParameterizedType
{
  private static final long serialVersionUID;
  private final Type ownerType;
  private final Type rawType;
  private final Type[] typeArguments;

  public MoreTypes$ParameterizedTypeImpl(Type paramType1, Type paramType2, Type[] paramArrayOfType)
  {
    boolean bool1;
    boolean bool2;
    if ((paramType2 instanceof Class))
    {
      Class localClass = (Class)paramType2;
      if ((paramType1 != null) || (localClass.getEnclosingClass() == null))
      {
        bool1 = true;
        Preconditions.checkArgument(bool1, "No owner type for enclosed %s", new Object[] { paramType2 });
        if ((paramType1 != null) && (localClass.getEnclosingClass() == null))
          break label176;
        bool2 = true;
        label65: Preconditions.checkArgument(bool2, "Owner type for unenclosed %s", new Object[] { paramType2 });
      }
    }
    else
    {
      if (paramType1 != null)
        break label182;
    }
    label176: label182: for (Type localType = null; ; localType = MoreTypes.a(paramType1))
    {
      this.ownerType = localType;
      this.rawType = MoreTypes.a(paramType2);
      this.typeArguments = ((Type[])paramArrayOfType.clone());
      while (i < this.typeArguments.length)
      {
        Preconditions.checkNotNull(this.typeArguments[i], "type parameter");
        MoreTypes.a(this.typeArguments[i], "type parameters");
        this.typeArguments[i] = MoreTypes.a(this.typeArguments[i]);
        i++;
      }
      bool1 = false;
      break;
      bool2 = false;
      break label65;
    }
  }

  public boolean a()
  {
    int i;
    if (this.ownerType != null)
    {
      boolean bool3 = MoreTypes.d(this.ownerType);
      i = 0;
      if (bool3);
    }
    while (true)
    {
      return i;
      boolean bool1 = MoreTypes.d(this.rawType);
      i = 0;
      if (!bool1)
        continue;
      Type[] arrayOfType = this.typeArguments;
      int j = arrayOfType.length;
      for (int k = 0; ; k++)
      {
        if (k >= j)
          break label80;
        boolean bool2 = MoreTypes.d(arrayOfType[k]);
        i = 0;
        if (!bool2)
          break;
      }
      label80: i = 1;
    }
  }

  public boolean equals(Object paramObject)
  {
    if (((paramObject instanceof ParameterizedType)) && (MoreTypes.a(this, (ParameterizedType)paramObject)));
    for (int i = 1; ; i = 0)
      return i;
  }

  public Type[] getActualTypeArguments()
  {
    return (Type[])this.typeArguments.clone();
  }

  public Type getOwnerType()
  {
    return this.ownerType;
  }

  public Type getRawType()
  {
    return this.rawType;
  }

  public int hashCode()
  {
    return Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode() ^ MoreTypes.a(this.ownerType);
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(30 * (1 + this.typeArguments.length));
    localStringBuilder.append(MoreTypes.c(this.rawType));
    if (this.typeArguments.length == 0);
    for (String str = localStringBuilder.toString(); ; str = ">")
    {
      return str;
      localStringBuilder.append("<").append(MoreTypes.c(this.typeArguments[0]));
      for (int i = 1; i < this.typeArguments.length; i++)
        localStringBuilder.append(", ").append(MoreTypes.c(this.typeArguments[i]));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.inject.internal.MoreTypes.ParameterizedTypeImpl
 * JD-Core Version:    0.6.0
 */