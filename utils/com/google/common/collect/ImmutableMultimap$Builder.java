package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ImmutableMultimap$Builder<K, V>
{
  Multimap<K, V> a = new ImmutableMultimap.BuilderMultimap();
  Comparator<? super V> b;

  public Builder<K, V> a(K paramK, V paramV)
  {
    this.a.a(Preconditions.checkNotNull(paramK), Preconditions.checkNotNull(paramV));
    return this;
  }

  public ImmutableMultimap<K, V> a()
  {
    if (this.b != null)
    {
      Iterator localIterator = this.a.b().values().iterator();
      while (localIterator.hasNext())
        Collections.sort((List)localIterator.next(), this.b);
    }
    return ImmutableMultimap.b(this.a);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableMultimap.Builder
 * JD-Core Version:    0.6.2
 */