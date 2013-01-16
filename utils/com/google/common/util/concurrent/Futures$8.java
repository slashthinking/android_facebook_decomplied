package com.google.common.util.concurrent;

import com.google.common.base.Function;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;

final class Futures$8
  implements Function<Constructor<?>, Boolean>
{
  public Boolean a(Constructor<?> paramConstructor)
  {
    return Boolean.valueOf(Arrays.asList(paramConstructor.getParameterTypes()).contains(String.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.util.concurrent.Futures.8
 * JD-Core Version:    0.6.2
 */