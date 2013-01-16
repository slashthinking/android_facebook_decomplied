package com.google.inject;

import com.google.common.base.Preconditions;
import com.google.inject.internal.MoreTypes;
import java.lang.reflect.Type;

public class TypeLiteral<T>
{
  final Class<? super T> b;
  final Type c;
  final int d;

  protected TypeLiteral()
  {
    this.c = a(getClass());
    this.b = MoreTypes.b(this.c);
    this.d = this.c.hashCode();
  }

  TypeLiteral(Type paramType)
  {
    this.c = MoreTypes.a((Type)Preconditions.checkNotNull(paramType, "type"));
    this.b = MoreTypes.b(this.c);
    this.d = this.c.hashCode();
  }

  public static TypeLiteral<?> a(Type paramType)
  {
    return new TypeLiteral(paramType);
  }

  static Type a(Class<?> paramClass)
  {
    Type localType = paramClass.getGenericSuperclass();
    if ((localType instanceof Class))
      throw new RuntimeException("Missing type parameter.");
    return MoreTypes.a(((java.lang.reflect.ParameterizedType)localType).getActualTypeArguments()[0]);
  }

  static TypeLiteral<?> b(Class<?> paramClass)
  {
    return new TypeLiteral(a(paramClass));
  }

  public static <T> TypeLiteral<T> c(Class<T> paramClass)
  {
    return new TypeLiteral(paramClass);
  }

  public final Class<? super T> a()
  {
    return this.b;
  }

  public final Type b()
  {
    return this.c;
  }

  public final boolean equals(Object paramObject)
  {
    if (((paramObject instanceof TypeLiteral)) && (MoreTypes.a(this.c, ((TypeLiteral)paramObject).c)));
    for (int i = 1; ; i = 0)
      return i;
  }

  public final int hashCode()
  {
    return this.d;
  }

  public final String toString()
  {
    return MoreTypes.c(this.c);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.inject.TypeLiteral
 * JD-Core Version:    0.6.0
 */