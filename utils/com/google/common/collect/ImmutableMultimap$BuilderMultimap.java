package com.google.common.collect;

import java.util.Collection;
import java.util.LinkedHashMap;

class ImmutableMultimap$BuilderMultimap<K, V> extends AbstractMultimap<K, V>
{
  private static final long serialVersionUID;

  ImmutableMultimap$BuilderMultimap()
  {
    super(new LinkedHashMap());
  }

  Collection<V> c()
  {
    return Lists.a();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableMultimap.BuilderMultimap
 * JD-Core Version:    0.6.2
 */