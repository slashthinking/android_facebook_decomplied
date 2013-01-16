package com.google.common.collect;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ImmutableListMultimap<K, V> extends ImmutableMultimap<K, V>
  implements ListMultimap<K, V>
{
  private static final long serialVersionUID;

  ImmutableListMultimap(ImmutableMap<K, ImmutableList<V>> paramImmutableMap, int paramInt)
  {
    super(paramImmutableMap, paramInt);
  }

  public static <K, V> ImmutableListMultimap<K, V> a()
  {
    return EmptyImmutableListMultimap.a;
  }

  public static <K, V> ImmutableListMultimap<K, V> a(Multimap<? extends K, ? extends V> paramMultimap)
  {
    ImmutableListMultimap localImmutableListMultimap;
    if (paramMultimap.e())
      localImmutableListMultimap = a();
    do
    {
      return localImmutableListMultimap;
      if (!(paramMultimap instanceof ImmutableListMultimap))
        break;
      localImmutableListMultimap = (ImmutableListMultimap)paramMultimap;
    }
    while (!localImmutableListMultimap.k());
    ImmutableMap.Builder localBuilder = ImmutableMap.k();
    Iterator localIterator = paramMultimap.b().entrySet().iterator();
    int i = 0;
    label61: ImmutableList localImmutableList;
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localImmutableList = ImmutableList.a((Collection)localEntry.getValue());
      if (localImmutableList.isEmpty())
        break label150;
      localBuilder.b(localEntry.getKey(), localImmutableList);
    }
    label150: for (int j = i + localImmutableList.size(); ; j = i)
    {
      i = j;
      break label61;
      localImmutableListMultimap = new ImmutableListMultimap(localBuilder.b(), i);
      break;
    }
  }

  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    paramObjectInputStream.defaultReadObject();
    int i = paramObjectInputStream.readInt();
    if (i < 0)
      throw new InvalidObjectException("Invalid key count " + i);
    ImmutableMap.Builder localBuilder = ImmutableMap.k();
    int j = 0;
    int k = 0;
    while (j < i)
    {
      Object localObject = paramObjectInputStream.readObject();
      int m = paramObjectInputStream.readInt();
      if (m <= 0)
        throw new InvalidObjectException("Invalid value count " + m);
      Object[] arrayOfObject = new Object[m];
      for (int n = 0; n < m; n++)
        arrayOfObject[n] = paramObjectInputStream.readObject();
      localBuilder.b(localObject, ImmutableList.a(arrayOfObject));
      k += m;
      j++;
    }
    try
    {
      ImmutableMap localImmutableMap = localBuilder.b();
      ImmutableMultimap.FieldSettersHolder.a.a(this, localImmutableMap);
      ImmutableMultimap.FieldSettersHolder.b.a(this, k);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw ((InvalidObjectException)new InvalidObjectException(localIllegalArgumentException.getMessage()).initCause(localIllegalArgumentException));
    }
  }

  private void writeObject(ObjectOutputStream paramObjectOutputStream)
  {
    paramObjectOutputStream.defaultWriteObject();
    Serialization.a(this, paramObjectOutputStream);
  }

  public ImmutableList<V> a(K paramK)
  {
    ImmutableList localImmutableList = (ImmutableList)this.b.get(paramK);
    if (localImmutableList == null)
      localImmutableList = ImmutableList.d();
    return localImmutableList;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableListMultimap
 * JD-Core Version:    0.6.2
 */