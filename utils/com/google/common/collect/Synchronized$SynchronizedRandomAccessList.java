package com.google.common.collect;

import java.util.List;
import java.util.RandomAccess;

class Synchronized$SynchronizedRandomAccessList<E> extends Synchronized.SynchronizedList<E>
  implements RandomAccess
{
  private static final long serialVersionUID;

  Synchronized$SynchronizedRandomAccessList(List<E> paramList, Object paramObject)
  {
    super(paramList, paramObject);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Synchronized.SynchronizedRandomAccessList
 * JD-Core Version:    0.6.2
 */