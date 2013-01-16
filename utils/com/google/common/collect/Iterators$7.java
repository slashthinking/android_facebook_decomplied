package com.google.common.collect;

import com.google.common.base.Predicate;
import java.util.Iterator;

final class Iterators$7 extends AbstractIterator<T>
{
  Iterators$7(Iterator paramIterator, Predicate paramPredicate)
  {
  }

  protected T a()
  {
    Object localObject;
    do
    {
      if (!this.a.hasNext())
        break;
      localObject = this.a.next();
    }
    while (!this.b.apply(localObject));
    while (true)
    {
      return localObject;
      localObject = b();
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Iterators.7
 * JD-Core Version:    0.6.2
 */