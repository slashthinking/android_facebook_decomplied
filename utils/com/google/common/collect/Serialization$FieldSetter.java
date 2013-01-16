package com.google.common.collect;

import java.lang.reflect.Field;

final class Serialization$FieldSetter<T>
{
  private final Field a;

  private Serialization$FieldSetter(Field paramField)
  {
    this.a = paramField;
    paramField.setAccessible(true);
  }

  void a(T paramT, int paramInt)
  {
    try
    {
      this.a.set(paramT, Integer.valueOf(paramInt));
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new AssertionError(localIllegalAccessException);
    }
  }

  void a(T paramT, Object paramObject)
  {
    try
    {
      this.a.set(paramT, paramObject);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new AssertionError(localIllegalAccessException);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Serialization.FieldSetter
 * JD-Core Version:    0.6.2
 */