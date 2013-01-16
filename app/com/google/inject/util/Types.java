package com.google.inject.util;

import com.google.inject.internal.MoreTypes.ParameterizedTypeImpl;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.inject.Provider;

public final class Types
{
  public static ParameterizedType a(Type paramType)
  {
    return a(Provider.class, new Type[] { paramType });
  }

  public static ParameterizedType a(Type paramType1, Type paramType2, Type[] paramArrayOfType)
  {
    return new MoreTypes.ParameterizedTypeImpl(paramType1, paramType2, paramArrayOfType);
  }

  public static ParameterizedType a(Type paramType, Type[] paramArrayOfType)
  {
    return a(null, paramType, paramArrayOfType);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.inject.util.Types
 * JD-Core Version:    0.6.0
 */