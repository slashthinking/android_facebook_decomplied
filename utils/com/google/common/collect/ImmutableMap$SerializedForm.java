package com.google.common.collect;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map.Entry;

class ImmutableMap$SerializedForm
  implements Serializable
{
  private static final long serialVersionUID;
  private final Object[] keys;
  private final Object[] values;

  ImmutableMap$SerializedForm(ImmutableMap<?, ?> paramImmutableMap)
  {
    this.keys = new Object[paramImmutableMap.size()];
    this.values = new Object[paramImmutableMap.size()];
    Iterator localIterator = paramImmutableMap.a().iterator();
    for (int i = 0; localIterator.hasNext(); i++)
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      this.keys[i] = localEntry.getKey();
      this.values[i] = localEntry.getValue();
    }
  }

  Object a(ImmutableMap.Builder<Object, Object> paramBuilder)
  {
    for (int i = 0; i < this.keys.length; i++)
      paramBuilder.b(this.keys[i], this.values[i]);
    return paramBuilder.b();
  }

  Object readResolve()
  {
    return a(new ImmutableMap.Builder());
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableMap.SerializedForm
 * JD-Core Version:    0.6.2
 */