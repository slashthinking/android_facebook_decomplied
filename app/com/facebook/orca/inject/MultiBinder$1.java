package com.facebook.orca.inject;

import com.google.common.collect.Sets;
import com.google.inject.Key;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.inject.Provider;

class MultiBinder$1
  implements Provider<Set<T>>
{
  public Set<T> a()
  {
    LinkedHashSet localLinkedHashSet = Sets.b();
    Iterator localIterator = MultiBinder.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      Key localKey = (Key)localIterator.next();
      localLinkedHashSet.add(MultiBinder.b(this.a).a(localKey));
    }
    return localLinkedHashSet;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.inject.MultiBinder.1
 * JD-Core Version:    0.6.0
 */