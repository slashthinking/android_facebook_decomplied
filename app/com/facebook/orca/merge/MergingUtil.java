package com.facebook.orca.merge;

import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.FetchMoreMessagesResult;
import com.facebook.orca.server.FetchThreadResult;
import com.facebook.orca.threads.FolderCounts;
import com.facebook.orca.threads.FolderName;
import com.facebook.orca.threads.MessagesCollection;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.threads.ThreadSummaryBuilder;
import com.facebook.orca.threads.ThreadsCollection;
import com.facebook.orca.users.UserKey;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.PeekingIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MergingUtil
{
  public static long a(Long[] paramArrayOfLong)
  {
    return g(Arrays.asList(paramArrayOfLong));
  }

  public static DataFreshnessResult a(DataFreshnessResult[] paramArrayOfDataFreshnessResult)
  {
    return d(Arrays.asList(paramArrayOfDataFreshnessResult));
  }

  public static FetchMoreMessagesResult a(int paramInt, FetchMoreMessagesResult paramFetchMoreMessagesResult, Collection<FetchMoreMessagesResult> paramCollection)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(paramFetchMoreMessagesResult);
    localArrayList.addAll(paramCollection);
    MessagesCollection localMessagesCollection = a(paramFetchMoreMessagesResult.a().a(), paramInt, a(new MergingUtil.GetMessagesCollectionFromFetchMoreMessagesResultFunction(null), localArrayList));
    long l = g(a(new MergingUtil.GetClientTimeMsFromFetchMoreMessagesResultFunction(null), localArrayList));
    return new FetchMoreMessagesResult(paramFetchMoreMessagesResult.e(), localMessagesCollection, l);
  }

  public static FetchThreadResult a(int paramInt, FetchThreadResult paramFetchThreadResult, Collection<FetchThreadResult> paramCollection)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(paramFetchThreadResult);
    localArrayList.addAll(paramCollection);
    ThreadSummary localThreadSummary = a(paramFetchThreadResult.a(), a(new MergingUtil.GetThreadSummaryFunction(null), paramCollection));
    MessagesCollection localMessagesCollection = a(paramFetchThreadResult.a().a(), paramInt, a(new MergingUtil.GetMessagesCollectionFunction(null), localArrayList));
    long l = g(a(new MergingUtil.GetClientTimeMsFunction(null), localArrayList));
    return new FetchThreadResult(paramFetchThreadResult.e(), localThreadSummary, localMessagesCollection, paramFetchThreadResult.c(), paramFetchThreadResult.d(), l);
  }

  public static FolderCounts a(FolderCounts[] paramArrayOfFolderCounts)
  {
    return e(Arrays.asList(paramArrayOfFolderCounts));
  }

  public static MessagesCollection a(String paramString, int paramInt, Collection<MessagesCollection> paramCollection)
  {
    Collection localCollection = Collections2.a(paramCollection, new MergingUtil.2());
    Iterator localIterator = localCollection.iterator();
    int i = 0;
    while (localIterator.hasNext())
      i += ((Collection)localIterator.next()).size();
    ImmutableList localImmutableList = a(paramInt, new MergingUtil.MessageByDateComparator(), localCollection);
    int j = localImmutableList.size();
    boolean bool = false;
    if (j == i)
      bool = b(paramCollection);
    return new MessagesCollection(paramString, localImmutableList, bool);
  }

  public static ThreadSummary a(ThreadSummary paramThreadSummary, Collection<ThreadSummary> paramCollection)
  {
    if (paramThreadSummary.x() == FolderName.b);
    for (boolean bool1 = true; ; bool1 = false)
    {
      Preconditions.checkArgument(bool1);
      Preconditions.checkArgument(paramThreadSummary.g());
      if ((paramCollection != null) && (!paramCollection.isEmpty()))
        break;
      return paramThreadSummary;
    }
    Iterator localIterator1 = paramCollection.iterator();
    if (localIterator1.hasNext())
    {
      ThreadSummary localThreadSummary = (ThreadSummary)localIterator1.next();
      if (localThreadSummary.x() == FolderName.d);
      for (boolean bool2 = true; ; bool2 = false)
      {
        Preconditions.checkArgument(bool2);
        Preconditions.checkArgument(localThreadSummary.g());
        break;
      }
    }
    Iterator localIterator2 = paramCollection.iterator();
    Object localObject1 = paramThreadSummary;
    label117: Object localObject2;
    if (localIterator2.hasNext())
    {
      localObject2 = (ThreadSummary)localIterator2.next();
      if (((ThreadSummary)localObject1).b() >= ((ThreadSummary)localObject2).b())
        break label324;
    }
    while (true)
    {
      localObject1 = localObject2;
      break label117;
      ThreadSummaryBuilder localThreadSummaryBuilder = new ThreadSummaryBuilder();
      localThreadSummaryBuilder.a(paramThreadSummary).a(FolderName.e);
      if (paramThreadSummary != localObject1)
        localThreadSummaryBuilder.c(((ThreadSummary)localObject1).b()).a(((ThreadSummary)localObject1).c()).b(((ThreadSummary)localObject1).d()).d(((ThreadSummary)localObject1).k()).c(((ThreadSummary)localObject1).m()).a(((ThreadSummary)localObject1).o()).d(((ThreadSummary)localObject1).n());
      ArrayList localArrayList = Lists.a();
      localArrayList.add(paramThreadSummary);
      localArrayList.addAll(paramCollection);
      localThreadSummaryBuilder.b(b(new MergingUtil.GetUnreadFunction(null), localArrayList)).e(b(new MergingUtil.GetHasFailedMessageSendFunction(null), localArrayList)).e(ImmutableList.a(paramCollection)).y();
      paramThreadSummary = localThreadSummaryBuilder.y();
      break;
      label324: localObject2 = localObject1;
    }
  }

  public static ThreadsCollection a(int paramInt, Collection<ThreadsCollection> paramCollection)
  {
    Collection localCollection = Collections2.a(paramCollection, new MergingUtil.3());
    Iterator localIterator = localCollection.iterator();
    int i = 0;
    while (localIterator.hasNext())
      i += ((Collection)localIterator.next()).size();
    ImmutableList localImmutableList = a(paramInt, new MergingUtil.ThreadSummaryByDateComparator(), localCollection);
    int j = localImmutableList.size();
    boolean bool = false;
    if (j == i)
      bool = c(paramCollection);
    return new ThreadsCollection(localImmutableList, bool);
  }

  public static ThreadsCollection a(int paramInt, ThreadsCollection[] paramArrayOfThreadsCollection)
  {
    return a(paramInt, Arrays.asList(paramArrayOfThreadsCollection));
  }

  public static <T> ImmutableList<T> a(int paramInt, Comparator<T> paramComparator, Collection<Collection<T>> paramCollection)
  {
    MergingUtil.1 local1 = new MergingUtil.1(paramComparator);
    ArrayList localArrayList = Lists.a();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      PeekingIterator localPeekingIterator2 = Iterators.g(((Collection)localIterator.next()).iterator());
      if (!localPeekingIterator2.hasNext())
        continue;
      localArrayList.add(localPeekingIterator2);
    }
    Collections.sort(localArrayList, local1);
    ImmutableList.Builder localBuilder = ImmutableList.e();
    int i = 0;
    while ((localArrayList.size() > 0) && (((PeekingIterator)localArrayList.get(0)).hasNext()) && (i < paramInt))
    {
      PeekingIterator localPeekingIterator1 = (PeekingIterator)localArrayList.remove(0);
      localBuilder.b(localPeekingIterator1.next());
      i++;
      if (!localPeekingIterator1.hasNext())
        continue;
      int j = Collections.binarySearch(localArrayList, localPeekingIterator1, local1);
      if (j < 0)
      {
        localArrayList.add(-1 + -j, localPeekingIterator1);
        continue;
      }
      localArrayList.add(j, localPeekingIterator1);
    }
    return localBuilder.b();
  }

  public static <T> ImmutableList<T> a(Collection<Collection<T>> paramCollection)
  {
    Object localObject1 = null;
    int i = 0;
    Iterator localIterator1 = paramCollection.iterator();
    Object localObject2;
    int j;
    if (localIterator1.hasNext())
    {
      Collection localCollection = (Collection)localIterator1.next();
      if ((localCollection == null) || (localCollection.size() <= 0))
        break label146;
      int k = i + 1;
      localObject2 = localCollection;
      j = k;
    }
    while (true)
    {
      localObject1 = localObject2;
      i = j;
      break;
      ImmutableList localImmutableList;
      if (i == 0)
        localImmutableList = ImmutableList.d();
      while (true)
      {
        return localImmutableList;
        if (i == 1)
        {
          localImmutableList = ImmutableList.a(localObject1);
          continue;
        }
        ImmutableList.Builder localBuilder = ImmutableList.e();
        Iterator localIterator2 = paramCollection.iterator();
        while (localIterator2.hasNext())
          localBuilder.b((Collection)localIterator2.next());
        localImmutableList = localBuilder.b();
      }
      label146: j = i;
      localObject2 = localObject1;
    }
  }

  public static <T> ImmutableList<T> a(Comparator<T> paramComparator, Collection<T>[] paramArrayOfCollection)
  {
    return a(2147483647, paramComparator, Arrays.asList(paramArrayOfCollection));
  }

  public static <T> ImmutableList<T> a(Collection<T>[] paramArrayOfCollection)
  {
    return a(Arrays.asList(paramArrayOfCollection));
  }

  public static ImmutableMap<UserKey, ThreadSummary> a(Map<UserKey, ThreadSummary> paramMap, Multimap<UserKey, UserKey> paramMultimap)
  {
    ImmutableMap.Builder localBuilder = ImmutableMap.k();
    Iterator localIterator1 = paramMultimap.g().iterator();
    while (localIterator1.hasNext())
    {
      UserKey localUserKey = (UserKey)localIterator1.next();
      ThreadSummary localThreadSummary1 = (ThreadSummary)paramMap.get(localUserKey);
      if (localThreadSummary1 == null)
        continue;
      Collection localCollection = paramMultimap.b(localUserKey);
      ArrayList localArrayList = Lists.a();
      Iterator localIterator2 = localCollection.iterator();
      while (localIterator2.hasNext())
      {
        ThreadSummary localThreadSummary3 = (ThreadSummary)paramMap.get((UserKey)localIterator2.next());
        if (localThreadSummary3 == null)
          continue;
        localArrayList.add(localThreadSummary3);
      }
      if (localArrayList.isEmpty())
        continue;
      ThreadSummary localThreadSummary2 = a(localThreadSummary1, localArrayList);
      localBuilder.b(localUserKey, localThreadSummary2);
      Iterator localIterator3 = localArrayList.iterator();
      while (localIterator3.hasNext())
        localBuilder.b(((ThreadSummary)localIterator3.next()).h(), localThreadSummary2);
    }
    return localBuilder.b();
  }

  private static <K, V> Collection<V> a(Function<K, V> paramFunction, Collection<K> paramCollection)
  {
    return Collections2.a(paramCollection, new MergingUtil.5(paramFunction));
  }

  public static boolean a(ThreadsCollection[] paramArrayOfThreadsCollection)
  {
    return c(Arrays.asList(paramArrayOfThreadsCollection));
  }

  public static boolean a(Boolean[] paramArrayOfBoolean)
  {
    return f(Arrays.asList(paramArrayOfBoolean));
  }

  private static boolean b(Function<ThreadSummary, Boolean> paramFunction, Collection<ThreadSummary> paramCollection)
  {
    return f(Collections2.a(paramCollection, new MergingUtil.6(paramFunction)));
  }

  static boolean b(Collection<MessagesCollection> paramCollection)
  {
    Iterator localIterator = paramCollection.iterator();
    do
      if (!localIterator.hasNext())
        break;
    while (((MessagesCollection)localIterator.next()).d());
    for (int i = 0; ; i = 1)
      return i;
  }

  public static boolean c(Collection<ThreadsCollection> paramCollection)
  {
    Iterator localIterator = paramCollection.iterator();
    do
      if (!localIterator.hasNext())
        break;
    while (((ThreadsCollection)localIterator.next()).c());
    for (int i = 0; ; i = 1)
      return i;
  }

  public static DataFreshnessResult d(Collection<DataFreshnessResult> paramCollection)
  {
    DataFreshnessResult localDataFreshnessResult = DataFreshnessResult.FROM_SERVER;
    Iterator localIterator = paramCollection.iterator();
    Object localObject1 = localDataFreshnessResult;
    if (localIterator.hasNext())
    {
      Object localObject2 = (DataFreshnessResult)localIterator.next();
      if (localObject2 == DataFreshnessResult.NO_DATA)
        localObject2 = DataFreshnessResult.NO_DATA;
      while (true)
      {
        localObject1 = localObject2;
        break;
        if ((localObject2 == DataFreshnessResult.FROM_CACHE_INCOMPLETE) && (localObject1 != DataFreshnessResult.NO_DATA))
        {
          localObject2 = DataFreshnessResult.FROM_CACHE_INCOMPLETE;
          continue;
        }
        if ((localObject2 == DataFreshnessResult.FROM_CACHE_STALE) && (localObject1 != DataFreshnessResult.NO_DATA) && (localObject1 != DataFreshnessResult.FROM_CACHE_INCOMPLETE))
        {
          localObject2 = DataFreshnessResult.FROM_CACHE_STALE;
          continue;
        }
        if (localObject1 == DataFreshnessResult.FROM_SERVER)
          continue;
        localObject2 = localObject1;
      }
    }
    return (DataFreshnessResult)(DataFreshnessResult)localObject1;
  }

  public static FolderCounts e(Collection<FolderCounts> paramCollection)
  {
    int i = 0;
    long l1 = 9223372036854775807L;
    long l2 = -9223372036854775808L;
    Iterator localIterator = paramCollection.iterator();
    int j = 0;
    while (localIterator.hasNext())
    {
      FolderCounts localFolderCounts = (FolderCounts)localIterator.next();
      if (localFolderCounts == null)
        continue;
      j += localFolderCounts.a();
      i += localFolderCounts.b();
      l1 = Math.min(l1, localFolderCounts.c());
      l2 = Math.max(l2, localFolderCounts.d());
    }
    return new FolderCounts(j, i, l1, l2);
  }

  public static boolean f(Collection<Boolean> paramCollection)
  {
    Iterator localIterator = paramCollection.iterator();
    do
      if (!localIterator.hasNext())
        break;
    while (!((Boolean)localIterator.next()).booleanValue());
    for (int i = 1; ; i = 0)
      return i;
  }

  public static long g(Collection<Long> paramCollection)
  {
    Iterator localIterator = paramCollection.iterator();
    long l = -9223372036854775808L;
    while (localIterator.hasNext())
      l = Math.max(l, ((Long)localIterator.next()).longValue());
    return l;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.merge.MergingUtil
 * JD-Core Version:    0.6.0
 */