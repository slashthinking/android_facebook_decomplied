package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Collection;

final class Collections2$1
  implements Function<Object, Object>
{
  Collections2$1(Collection paramCollection)
  {
  }

  public Object apply(Object paramObject)
  {
    if (paramObject == this.a)
      paramObject = "(this Collection)";
    return paramObject;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Collections2.1
 * JD-Core Version:    0.6.2
 */