package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

abstract class Multimaps$Keys<K, V> extends AbstractMultiset<K>
{
  private Set<Multiset.Entry<K>> a;

  public int a(Object paramObject)
  {
    int j;
    try
    {
      boolean bool = e().d(paramObject);
      i = 0;
      if (!bool)
        break label82;
      Collection localCollection = (Collection)e().b().get(paramObject);
      if (localCollection == null)
      {
        j = 0;
      }
      else
      {
        int k = localCollection.size();
        j = k;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      i = 0;
      break label82;
    }
    catch (ClassCastException localClassCastException)
    {
      i = 0;
      break label82;
    }
    int i = j;
    label82: return i;
  }

  public Set<Multiset.Entry<K>> a()
  {
    Set localSet;
    if (this.a == null)
    {
      localSet = g();
      this.a = localSet;
    }
    while (true)
    {
      return localSet;
      localSet = this.a;
    }
  }

  public int b(Object paramObject, int paramInt)
  {
    boolean bool;
    int i;
    if (paramInt >= 0)
    {
      bool = true;
      Preconditions.checkArgument(bool);
      if (paramInt != 0)
        break label29;
      i = a(paramObject);
    }
    while (true)
    {
      return i;
      bool = false;
      break;
      try
      {
        label29: Collection localCollection = (Collection)e().b().get(paramObject);
        i = 0;
        if (localCollection != null)
        {
          int j = localCollection.size();
          if (paramInt >= j)
            localCollection.clear();
          while (true)
          {
            i = j;
            break;
            Iterator localIterator = localCollection.iterator();
            while (i < paramInt)
            {
              localIterator.next();
              localIterator.remove();
              i++;
            }
          }
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        i = 0;
      }
      catch (ClassCastException localClassCastException)
      {
        i = 0;
      }
    }
  }

  Iterator<Multiset.Entry<K>> b()
  {
    return new Multimaps.Keys.1(this, e().b().entrySet().iterator());
  }

  int c()
  {
    return e().b().size();
  }

  public void clear()
  {
    e().f();
  }

  public boolean contains(Object paramObject)
  {
    return e().d(paramObject);
  }

  abstract Multimap<K, V> e();

  public Set<K> f()
  {
    return e().g();
  }

  Set<Multiset.Entry<K>> g()
  {
    return new Multimaps.Keys.KeysEntrySet(this);
  }

  public Iterator<K> iterator()
  {
    return Iterators.a(e().i().iterator(), new Multimaps.Keys.2(this));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Multimaps.Keys
 * JD-Core Version:    0.6.2
 */