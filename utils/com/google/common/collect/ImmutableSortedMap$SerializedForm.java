package com.google.common.collect;

import java.util.Comparator;

class ImmutableSortedMap$SerializedForm extends ImmutableMap.SerializedForm
{
  private static final long serialVersionUID;
  private final Comparator<Object> comparator;

  ImmutableSortedMap$SerializedForm(ImmutableSortedMap<?, ?> paramImmutableSortedMap)
  {
    super(paramImmutableSortedMap);
    this.comparator = paramImmutableSortedMap.comparator();
  }

  Object readResolve()
  {
    return a(new ImmutableSortedMap.Builder(this.comparator));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableSortedMap.SerializedForm
 * JD-Core Version:    0.6.2
 */