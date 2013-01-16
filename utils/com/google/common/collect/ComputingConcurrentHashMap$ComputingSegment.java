package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReferenceArray;

final class ComputingConcurrentHashMap$ComputingSegment<K, V> extends CustomConcurrentHashMap.Segment<K, V>
{
  ComputingConcurrentHashMap$ComputingSegment(CustomConcurrentHashMap<K, V> paramCustomConcurrentHashMap, int paramInt1, int paramInt2)
  {
    super(paramCustomConcurrentHashMap, paramInt1, paramInt2);
  }

  V a(K paramK, int paramInt, Function<? super K, ? extends V> paramFunction)
  {
    while (true)
    {
      label36: Object localObject7;
      try
      {
        localObject2 = a(paramK, paramInt);
        if (localObject2 != null)
        {
          localObject4 = f((CustomConcurrentHashMap.ReferenceEntry)localObject2);
          if (localObject4 != null)
          {
            a((CustomConcurrentHashMap.ReferenceEntry)localObject2);
            return localObject4;
          }
        }
        if ((localObject2 != null) && (((CustomConcurrentHashMap.ReferenceEntry)localObject2).getValueReference().b()))
          break label439;
        lock();
        try
        {
          o();
          int i = -1 + this.count;
          AtomicReferenceArray localAtomicReferenceArray = this.table;
          int j = paramInt & -1 + localAtomicReferenceArray.length();
          CustomConcurrentHashMap.ReferenceEntry localReferenceEntry1 = (CustomConcurrentHashMap.ReferenceEntry)localAtomicReferenceArray.get(j);
          localReferenceEntry2 = localReferenceEntry1;
          if (localReferenceEntry2 == null)
            break label505;
          Object localObject6 = localReferenceEntry2.getKey();
          if ((localReferenceEntry2.getHash() != paramInt) || (localObject6 == null) || (!this.map.keyEquivalence.equivalent(paramK, localObject6)))
            break label407;
          if (localReferenceEntry2.getValueReference().b())
          {
            k = 0;
            if (k == 0)
              break label495;
            localComputingValueReference = new ComputingConcurrentHashMap.ComputingValueReference(paramFunction);
            if (localReferenceEntry2 != null)
              break label419;
            localReferenceEntry3 = a(paramK, paramInt, localReferenceEntry1);
            localReferenceEntry3.setValueReference(localComputingValueReference);
            localAtomicReferenceArray.set(j, localReferenceEntry3);
            unlock();
            p();
            if (k == 0)
              break label435;
            Object localObject5 = a(paramK, paramInt, localReferenceEntry3, localComputingValueReference);
            localObject4 = localObject5;
            n();
            continue;
          }
          localObject7 = localReferenceEntry2.getValueReference().get();
          if (localObject7 == null)
          {
            a(localObject6, paramInt, localObject7, MapMaker.RemovalCause.COLLECTED);
            this.evictionQueue.remove(localReferenceEntry2);
            this.expirationQueue.remove(localReferenceEntry2);
            this.count = i;
            k = 1;
            continue;
          }
          if ((this.map.b()) && (this.map.c(localReferenceEntry2)))
          {
            a(localObject6, paramInt, localObject7, MapMaker.RemovalCause.EXPIRED);
            continue;
          }
        }
        finally
        {
          unlock();
        }
      }
      finally
      {
        n();
      }
      b(localReferenceEntry2);
      unlock();
      p();
      n();
      Object localObject4 = localObject7;
      continue;
      label407: CustomConcurrentHashMap.ReferenceEntry localReferenceEntry2 = localReferenceEntry2.getNext();
      continue;
      label419: localReferenceEntry2.setValueReference(localComputingValueReference);
      CustomConcurrentHashMap.ReferenceEntry localReferenceEntry3 = localReferenceEntry2;
      continue;
      label435: Object localObject2 = localReferenceEntry3;
      label439: if (!Thread.holdsLock(localObject2));
      for (boolean bool = true; ; bool = false)
      {
        Preconditions.checkState(bool, "Recursive computation");
        localObject4 = ((CustomConcurrentHashMap.ReferenceEntry)localObject2).getValueReference().c();
        if (localObject4 == null)
          break;
        a((CustomConcurrentHashMap.ReferenceEntry)localObject2);
        n();
        break label36;
      }
      label495: localReferenceEntry3 = localReferenceEntry2;
      ComputingConcurrentHashMap.ComputingValueReference localComputingValueReference = null;
      continue;
      label505: int k = 1;
    }
  }

  // ERROR //
  V a(K paramK, int paramInt, CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry, ComputingConcurrentHashMap.ComputingValueReference<K, V> paramComputingValueReference)
  {
    // Byte code:
    //   0: invokestatic 168	java/lang/System:nanoTime	()J
    //   3: pop2
    //   4: aload_3
    //   5: monitorenter
    //   6: aload 4
    //   8: aload_1
    //   9: iload_2
    //   10: invokevirtual 171	com/google/common/collect/ComputingConcurrentHashMap$ComputingValueReference:a	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   13: astore 15
    //   15: aload 15
    //   17: astore 10
    //   19: invokestatic 168	java/lang/System:nanoTime	()J
    //   22: lstore 16
    //   24: lload 16
    //   26: lstore 8
    //   28: aload_3
    //   29: monitorexit
    //   30: aload 10
    //   32: ifnull +26 -> 58
    //   35: aload_0
    //   36: aload_1
    //   37: iload_2
    //   38: aload 10
    //   40: iconst_1
    //   41: invokevirtual 174	com/google/common/collect/ComputingConcurrentHashMap$ComputingSegment:a	(Ljava/lang/Object;ILjava/lang/Object;Z)Ljava/lang/Object;
    //   44: ifnull +14 -> 58
    //   47: aload_0
    //   48: aload_1
    //   49: iload_2
    //   50: aload 10
    //   52: getstatic 177	com/google/common/collect/MapMaker$RemovalCause:REPLACED	Lcom/google/common/collect/MapMaker$RemovalCause;
    //   55: invokevirtual 120	com/google/common/collect/ComputingConcurrentHashMap$ComputingSegment:a	(Ljava/lang/Object;ILjava/lang/Object;Lcom/google/common/collect/MapMaker$RemovalCause;)V
    //   58: lload 8
    //   60: lconst_0
    //   61: lcmp
    //   62: ifne +7 -> 69
    //   65: invokestatic 168	java/lang/System:nanoTime	()J
    //   68: pop2
    //   69: aload 10
    //   71: ifnonnull +12 -> 83
    //   74: aload_0
    //   75: aload_1
    //   76: iload_2
    //   77: aload 4
    //   79: invokevirtual 180	com/google/common/collect/ComputingConcurrentHashMap$ComputingSegment:b	(Ljava/lang/Object;ILcom/google/common/collect/CustomConcurrentHashMap$ValueReference;)Z
    //   82: pop
    //   83: aload 10
    //   85: areturn
    //   86: astore 14
    //   88: aconst_null
    //   89: astore 10
    //   91: lconst_0
    //   92: lstore 8
    //   94: aload_3
    //   95: monitorexit
    //   96: aload 14
    //   98: athrow
    //   99: astore 7
    //   101: lload 8
    //   103: lconst_0
    //   104: lcmp
    //   105: ifne +7 -> 112
    //   108: invokestatic 168	java/lang/System:nanoTime	()J
    //   111: pop2
    //   112: aload 10
    //   114: ifnonnull +12 -> 126
    //   117: aload_0
    //   118: aload_1
    //   119: iload_2
    //   120: aload 4
    //   122: invokevirtual 180	com/google/common/collect/ComputingConcurrentHashMap$ComputingSegment:b	(Ljava/lang/Object;ILcom/google/common/collect/CustomConcurrentHashMap$ValueReference;)Z
    //   125: pop
    //   126: aload 7
    //   128: athrow
    //   129: astore 7
    //   131: lconst_0
    //   132: lstore 8
    //   134: aconst_null
    //   135: astore 10
    //   137: goto -36 -> 101
    //   140: astore 14
    //   142: lconst_0
    //   143: lstore 8
    //   145: goto -51 -> 94
    //   148: astore 14
    //   150: goto -56 -> 94
    //
    // Exception table:
    //   from	to	target	type
    //   6	15	86	finally
    //   35	58	99	finally
    //   96	99	99	finally
    //   4	6	129	finally
    //   19	24	140	finally
    //   28	30	148	finally
    //   94	96	148	finally
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ComputingConcurrentHashMap.ComputingSegment
 * JD-Core Version:    0.6.2
 */