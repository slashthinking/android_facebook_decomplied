package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReferenceArray;

abstract class CustomConcurrentHashMap$HashIterator
{
  int b;
  int c;
  CustomConcurrentHashMap.Segment<K, V> d;
  AtomicReferenceArray<CustomConcurrentHashMap.ReferenceEntry<K, V>> e;
  CustomConcurrentHashMap.ReferenceEntry<K, V> f;
  CustomConcurrentHashMap<K, V>.WriteThroughEntry g;
  CustomConcurrentHashMap<K, V>.WriteThroughEntry h;

  CustomConcurrentHashMap$HashIterator(CustomConcurrentHashMap paramCustomConcurrentHashMap)
  {
    this.b = (-1 + paramCustomConcurrentHashMap.c.length);
    this.c = -1;
    b();
  }

  boolean a(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    try
    {
      Object localObject2 = paramReferenceEntry.getKey();
      Object localObject3 = this.i.b(paramReferenceEntry);
      if (localObject3 != null)
      {
        this.g = new CustomConcurrentHashMap.WriteThroughEntry(this.i, localObject2, localObject3);
        bool = true;
        return bool;
      }
      this.d.n();
      boolean bool = false;
    }
    finally
    {
      this.d.n();
    }
  }

  final void b()
  {
    this.g = null;
    if (c())
    {
      return;
      break label20;
    }
    while (true)
      if (!d())
        label20: if (this.b >= 0)
        {
          CustomConcurrentHashMap.Segment[] arrayOfSegment = this.i.c;
          int j = this.b;
          this.b = (j - 1);
          this.d = arrayOfSegment[j];
          if (this.d.count == 0)
            break;
          this.e = this.d.table;
          this.c = (-1 + this.e.length());
          if (!d())
            break;
        }
  }

  boolean c()
  {
    if (this.f != null)
    {
      this.f = this.f.getNext();
      if (this.f != null)
        if (!a(this.f));
    }
    for (boolean bool = true; ; bool = false)
    {
      return bool;
      this.f = this.f.getNext();
      break;
    }
  }

  boolean d()
  {
    CustomConcurrentHashMap.ReferenceEntry localReferenceEntry;
    do
    {
      if (this.c < 0)
        break;
      AtomicReferenceArray localAtomicReferenceArray = this.e;
      int j = this.c;
      this.c = (j - 1);
      localReferenceEntry = (CustomConcurrentHashMap.ReferenceEntry)localAtomicReferenceArray.get(j);
      this.f = localReferenceEntry;
    }
    while ((localReferenceEntry == null) || ((!a(this.f)) && (!c())));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  CustomConcurrentHashMap<K, V>.WriteThroughEntry e()
  {
    if (this.g == null)
      throw new NoSuchElementException();
    this.h = this.g;
    b();
    return this.h;
  }

  public boolean hasNext()
  {
    if (this.g != null);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public void remove()
  {
    if (this.h != null);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool);
      this.i.remove(this.h.getKey());
      this.h = null;
      return;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.CustomConcurrentHashMap.HashIterator
 * JD-Core Version:    0.6.2
 */