package com.facebook.orca.merge;

import android.os.Bundle;
import com.facebook.contacts.data.DbFetchContactHandler;
import com.facebook.login.ContextAwareAuthTokenStringSupplier;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.AbstractOrcaServiceHandlerFilter;
import com.facebook.orca.server.DataFreshnessParam;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.FetchMoreMessagesParams;
import com.facebook.orca.server.FetchMoreMessagesResult;
import com.facebook.orca.server.FetchMoreThreadsParams;
import com.facebook.orca.server.FetchMoreThreadsResult;
import com.facebook.orca.server.FetchMultipleThreadsParams;
import com.facebook.orca.server.FetchMultipleThreadsResult;
import com.facebook.orca.server.FetchThreadListParams;
import com.facebook.orca.server.FetchThreadListParamsBuilder;
import com.facebook.orca.server.FetchThreadListResult;
import com.facebook.orca.server.FetchThreadListResultBuilder;
import com.facebook.orca.server.FetchThreadParams;
import com.facebook.orca.server.FetchThreadParamsBuilder;
import com.facebook.orca.server.FetchThreadResult;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.ThreadCriteria;
import com.facebook.orca.threads.FolderCounts;
import com.facebook.orca.threads.FolderName;
import com.facebook.orca.threads.MessagesCollection;
import com.facebook.orca.threads.MessagingIdUtil;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.threads.ThreadsCollection;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserKey;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javax.inject.Provider;

public class MergeServiceHandler extends AbstractOrcaServiceHandlerFilter
{
  private static final Class<?> a = MergeServiceHandler.class;
  private final ExecutorService b;
  private final ContextAwareAuthTokenStringSupplier c;
  private final DbFetchContactHandler d;
  private final Provider<Boolean> e;
  private final Provider<Boolean> f;

  public MergeServiceHandler(ExecutorService paramExecutorService, ContextAwareAuthTokenStringSupplier paramContextAwareAuthTokenStringSupplier, DbFetchContactHandler paramDbFetchContactHandler, Provider<Boolean> paramProvider1, Provider<Boolean> paramProvider2)
  {
    super("MergeServiceHandler");
    this.b = paramExecutorService;
    this.c = paramContextAwareAuthTokenStringSupplier;
    this.d = paramDbFetchContactHandler;
    this.e = paramProvider1;
    this.f = paramProvider2;
  }

  private MergeServiceHandler.CallableWithFolder G(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return new MergeServiceHandler.1(this, paramOperationParams, paramOrcaServiceHandler);
  }

  private MergeServiceHandler.CallableWithFolder H(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return new MergeServiceHandler.2(this, paramOperationParams, paramOrcaServiceHandler);
  }

  private MergeServiceHandler.CallableWithFolder I(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return new MergeServiceHandler.3(this, paramOperationParams, paramOrcaServiceHandler);
  }

  private FetchMultipleThreadsParams a(FetchMultipleThreadsParams paramFetchMultipleThreadsParams)
  {
    ImmutableList localImmutableList = paramFetchMultipleThreadsParams.b();
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator = localImmutableList.iterator();
    while (localIterator.hasNext())
    {
      FetchThreadParams localFetchThreadParams = (FetchThreadParams)localIterator.next();
      ThreadCriteria localThreadCriteria = localFetchThreadParams.a();
      if (localThreadCriteria.b() != null)
      {
        if (localThreadCriteria.b().a() != User.Type.FACEBOOK)
          continue;
        localBuilder.b(localFetchThreadParams);
        continue;
      }
      if (MessagingIdUtil.g(localThreadCriteria.a()))
        continue;
      localBuilder.b(localFetchThreadParams);
    }
    return new FetchMultipleThreadsParams(FolderName.b, localBuilder.b());
  }

  private FetchMultipleThreadsParams a(FolderName paramFolderName, FetchMultipleThreadsParams paramFetchMultipleThreadsParams)
  {
    boolean bool;
    if ((paramFolderName == FolderName.b) || (paramFolderName == FolderName.d))
    {
      bool = true;
      Preconditions.checkArgument(bool);
      if (paramFolderName != FolderName.b)
        break label42;
    }
    label42: for (FetchMultipleThreadsParams localFetchMultipleThreadsParams = a(paramFetchMultipleThreadsParams); ; localFetchMultipleThreadsParams = b(paramFetchMultipleThreadsParams))
    {
      return localFetchMultipleThreadsParams;
      bool = false;
      break;
    }
  }

  private FetchMultipleThreadsResult a(Collection<UserKey> paramCollection, FetchThreadParams paramFetchThreadParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    if (paramCollection.isEmpty());
    Bundle localBundle;
    for (FetchMultipleThreadsResult localFetchMultipleThreadsResult = FetchMultipleThreadsResult.a; ; localFetchMultipleThreadsResult = (FetchMultipleThreadsResult)A(new OperationParams("fetch_multiple_threads", localBundle), paramOrcaServiceHandler).h())
    {
      return localFetchMultipleThreadsResult;
      ImmutableList.Builder localBuilder = ImmutableList.e();
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
      {
        UserKey localUserKey = (UserKey)localIterator.next();
        localBuilder.b(new FetchThreadParamsBuilder().a(paramFetchThreadParams).a(ThreadCriteria.a(localUserKey)).h());
      }
      FetchMultipleThreadsParams localFetchMultipleThreadsParams = new FetchMultipleThreadsParams(FolderName.e, localBuilder.b());
      localBundle = new Bundle();
      localBundle.putParcelable("fetchMultipleThreadsParams", localFetchMultipleThreadsParams);
    }
  }

  private FetchThreadResult a(FetchThreadParams paramFetchThreadParams, Collection<FetchThreadResult> paramCollection)
  {
    Object localObject1 = null;
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator = paramCollection.iterator();
    if (localIterator.hasNext())
    {
      Object localObject2 = (FetchThreadResult)localIterator.next();
      ThreadSummary localThreadSummary = ((FetchThreadResult)localObject2).a();
      if ((localObject1 == null) && (!MessagingIdUtil.g(localThreadSummary.a())));
      while (true)
      {
        localObject1 = localObject2;
        break;
        localBuilder.b(localObject2);
        localObject2 = localObject1;
      }
    }
    return (FetchThreadResult)MergingUtil.a(paramFetchThreadParams.f(), localObject1, localBuilder.b());
  }

  private OperationResult a(OperationParams paramOperationParams, FolderName paramFolderName, OrcaServiceHandler paramOrcaServiceHandler)
  {
    try
    {
      OperationResult localOperationResult2 = a(paramOperationParams, paramFolderName, Optional.absent(), paramOrcaServiceHandler);
      localOperationResult1 = localOperationResult2;
      return localOperationResult1;
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        if (!((FetchThreadListParams)paramOperationParams.b().getParcelable("fetchThreadListParams")).e())
          throw localIOException;
        FetchThreadListResult localFetchThreadListResult = (FetchThreadListResult)a(paramOperationParams, paramFolderName, Optional.of(DataFreshnessParam.DO_NOT_CHECK_SERVER), paramOrcaServiceHandler).h();
        OperationResult localOperationResult1 = OperationResult.a(FetchThreadListResult.newBuilder().a(localFetchThreadListResult).a(ServiceException.a(localIOException)).o());
      }
    }
  }

  private OperationResult a(OperationParams paramOperationParams, FolderName paramFolderName, Optional<DataFreshnessParam> paramOptional, OrcaServiceHandler paramOrcaServiceHandler)
  {
    String str = paramOperationParams.a();
    Bundle localBundle1 = paramOperationParams.b();
    FetchThreadListParams localFetchThreadListParams1 = (FetchThreadListParams)localBundle1.getParcelable("fetchThreadListParams");
    FetchThreadListParams localFetchThreadListParams2 = FetchThreadListParams.newBuilder().a(localFetchThreadListParams1).a(paramFolderName).a((DataFreshnessParam)paramOptional.or(localFetchThreadListParams1.a())).f();
    Bundle localBundle2 = (Bundle)localBundle1.clone();
    localBundle2.putParcelable("fetchThreadListParams", localFetchThreadListParams2);
    return paramOrcaServiceHandler.a(new OperationParams(str, localBundle2));
  }

  private ImmutableList<ThreadSummary> a(DataFreshnessParam paramDataFreshnessParam, OrcaServiceHandler paramOrcaServiceHandler, Collection<ThreadSummary> paramCollection)
  {
    HashMap localHashMap = Maps.a();
    Iterator localIterator1 = paramCollection.iterator();
    while (localIterator1.hasNext())
    {
      ThreadSummary localThreadSummary4 = (ThreadSummary)localIterator1.next();
      if (!localThreadSummary4.g())
        continue;
      localHashMap.put(localThreadSummary4.h(), localThreadSummary4);
    }
    ImmutableMultimap localImmutableMultimap = this.d.a(localHashMap.keySet());
    HashSet localHashSet1 = Sets.a();
    Iterator localIterator2 = localImmutableMultimap.l().iterator();
    while (localIterator2.hasNext())
    {
      UserKey localUserKey4 = (UserKey)localIterator2.next();
      if (localHashMap.keySet().contains(localUserKey4))
        continue;
      localHashSet1.add(localUserKey4);
    }
    Iterator localIterator3 = localImmutableMultimap.p().iterator();
    while (localIterator3.hasNext())
    {
      UserKey localUserKey3 = (UserKey)localIterator3.next();
      if (localHashMap.keySet().contains(localUserKey3))
        continue;
      localHashSet1.add(localUserKey3);
    }
    FetchMultipleThreadsResult localFetchMultipleThreadsResult = a(localHashSet1, new FetchThreadParamsBuilder().a(0).a(paramDataFreshnessParam).h(), paramOrcaServiceHandler);
    ImmutableList.Builder localBuilder1 = ImmutableList.e();
    a(localBuilder1, localFetchMultipleThreadsResult.a());
    Iterator localIterator4 = localBuilder1.b().iterator();
    while (localIterator4.hasNext())
    {
      ThreadSummary localThreadSummary3 = ((FetchThreadResult)localIterator4.next()).a();
      localHashMap.put(localThreadSummary3.h(), localThreadSummary3);
    }
    ImmutableMap localImmutableMap = MergingUtil.a(localHashMap, localImmutableMultimap);
    HashSet localHashSet2 = Sets.a();
    ImmutableList.Builder localBuilder2 = ImmutableList.e();
    Iterator localIterator5 = paramCollection.iterator();
    while (localIterator5.hasNext())
    {
      ThreadSummary localThreadSummary1 = (ThreadSummary)localIterator5.next();
      UserKey localUserKey1 = localThreadSummary1.h();
      if ((localUserKey1 != null) && (localImmutableMap.containsKey(localUserKey1)))
      {
        ThreadSummary localThreadSummary2 = (ThreadSummary)localImmutableMap.get(localUserKey1);
        UserKey localUserKey2 = localThreadSummary2.h();
        if (localHashSet2.contains(localUserKey2))
          continue;
        localBuilder2.b(localThreadSummary2);
        localHashSet2.add(localUserKey2);
        continue;
      }
      localBuilder2.b(localThreadSummary1);
    }
    return localBuilder2.b();
  }

  private <T> ImmutableMap<FolderName, T> a(MergeServiceHandler.CallableWithFolder paramCallableWithFolder, ImmutableList<FolderName> paramImmutableList)
  {
    String str = this.c.c();
    ArrayList localArrayList = Lists.a();
    Iterator localIterator = paramImmutableList.iterator();
    while (localIterator.hasNext())
      localArrayList.add(new MergeServiceHandler.5(this, (FolderName)localIterator.next(), str, paramCallableWithFolder));
    ImmutableMap.Builder localBuilder = ImmutableMap.k();
    List localList = this.b.invokeAll(localArrayList);
    int i = 0;
    while (i < paramImmutableList.size())
      try
      {
        localBuilder.b(paramImmutableList.get(i), ((Future)localList.get(i)).get());
        i++;
      }
      catch (ExecutionException localExecutionException)
      {
        Throwable localThrowable = localExecutionException.getCause();
        Throwables.propagateIfPossible(localThrowable, Exception.class);
        throw Throwables.propagate(localThrowable);
      }
    return localBuilder.b();
  }

  private List<FetchMoreMessagesResult> a(Collection<UserKey> paramCollection, OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    FetchMoreMessagesParams localFetchMoreMessagesParams1 = (FetchMoreMessagesParams)paramOperationParams.b().getParcelable("fetchMoreMessagesParams");
    ArrayList localArrayList = Lists.a();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      FetchMoreMessagesParams localFetchMoreMessagesParams2 = new FetchMoreMessagesParams(ThreadCriteria.a((UserKey)localIterator.next()), localFetchMoreMessagesParams1.b(), localFetchMoreMessagesParams1.c(), localFetchMoreMessagesParams1.d());
      paramOperationParams.b().putParcelable("fetchMoreMessagesParams", localFetchMoreMessagesParams2);
      localArrayList.add((FetchMoreMessagesResult)paramOrcaServiceHandler.a(paramOperationParams).h());
    }
    return localArrayList;
  }

  private void a(ImmutableList.Builder<FetchThreadResult> paramBuilder, List<FetchThreadResult> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      FetchThreadResult localFetchThreadResult = (FetchThreadResult)localIterator.next();
      if (localFetchThreadResult.a() == null)
        continue;
      paramBuilder.b(localFetchThreadResult);
    }
  }

  private FetchMultipleThreadsParams b(FetchMultipleThreadsParams paramFetchMultipleThreadsParams)
  {
    ImmutableList localImmutableList = paramFetchMultipleThreadsParams.b();
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator = localImmutableList.iterator();
    while (localIterator.hasNext())
    {
      FetchThreadParams localFetchThreadParams = (FetchThreadParams)localIterator.next();
      ThreadCriteria localThreadCriteria = localFetchThreadParams.a();
      if (localThreadCriteria.b() != null)
      {
        if (localThreadCriteria.b().a() != User.Type.PHONE_NUMBER)
          continue;
        localBuilder.b(localFetchThreadParams);
        continue;
      }
      if (!MessagingIdUtil.g(localThreadCriteria.a()))
        continue;
      localBuilder.b(localFetchThreadParams);
    }
    return new FetchMultipleThreadsParams(FolderName.d, localBuilder.b());
  }

  private OperationResult b(OperationParams paramOperationParams, FolderName paramFolderName, OrcaServiceHandler paramOrcaServiceHandler)
  {
    String str = paramOperationParams.a();
    Bundle localBundle1 = paramOperationParams.b();
    FetchMoreThreadsParams localFetchMoreThreadsParams1 = (FetchMoreThreadsParams)localBundle1.getParcelable("fetchMoreThreadsParams");
    FetchMoreThreadsParams localFetchMoreThreadsParams2 = new FetchMoreThreadsParams(paramFolderName, localFetchMoreThreadsParams1.b(), localFetchMoreThreadsParams1.c());
    Bundle localBundle2 = (Bundle)localBundle1.clone();
    localBundle2.putParcelable("fetchMoreThreadsParams", localFetchMoreThreadsParams2);
    return paramOrcaServiceHandler.a(new OperationParams(str, localBundle2));
  }

  private OperationResult c(OperationParams paramOperationParams, FolderName paramFolderName, OrcaServiceHandler paramOrcaServiceHandler)
  {
    String str = paramOperationParams.a();
    Bundle localBundle1 = paramOperationParams.b();
    FetchMultipleThreadsParams localFetchMultipleThreadsParams = a(paramFolderName, (FetchMultipleThreadsParams)localBundle1.getParcelable("fetchMultipleThreadsParams"));
    if (localFetchMultipleThreadsParams.b().size() == 0);
    Bundle localBundle2;
    for (OperationResult localOperationResult = OperationResult.a(FetchMultipleThreadsResult.a); ; localOperationResult = paramOrcaServiceHandler.a(new OperationParams(str, localBundle2)))
    {
      return localOperationResult;
      localBundle2 = (Bundle)localBundle1.clone();
      localBundle2.putParcelable("fetchMultipleThreadsParams", localFetchMultipleThreadsParams);
    }
  }

  protected OperationResult A(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    paramOperationParams.a();
    if (((FetchMultipleThreadsParams)paramOperationParams.b().getParcelable("fetchMultipleThreadsParams")).a() != FolderName.e);
    Collection[] arrayOfCollection;
    for (OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams); ; localOperationResult = OperationResult.a(new FetchMultipleThreadsResult(MergingUtil.a(arrayOfCollection))))
    {
      return localOperationResult;
      ImmutableMap localImmutableMap = a(I(paramOperationParams, paramOrcaServiceHandler), ImmutableList.a(FolderName.b, FolderName.d));
      FetchMultipleThreadsResult localFetchMultipleThreadsResult1 = (FetchMultipleThreadsResult)localImmutableMap.get(FolderName.b);
      FetchMultipleThreadsResult localFetchMultipleThreadsResult2 = (FetchMultipleThreadsResult)localImmutableMap.get(FolderName.d);
      arrayOfCollection = new Collection[2];
      arrayOfCollection[0] = localFetchMultipleThreadsResult1.a();
      arrayOfCollection[1] = localFetchMultipleThreadsResult2.a();
    }
  }

  protected OperationResult c(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    paramOperationParams.a();
    FetchThreadListParams localFetchThreadListParams = (FetchThreadListParams)paramOperationParams.b().getParcelable("fetchThreadListParams");
    FolderName localFolderName = localFetchThreadListParams.b();
    OperationResult localOperationResult;
    if (localFolderName != FolderName.e)
    {
      localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
      return localOperationResult;
    }
    ImmutableMap localImmutableMap1 = a(G(paramOperationParams, paramOrcaServiceHandler), ImmutableList.a(FolderName.b, FolderName.d));
    FetchThreadListResult localFetchThreadListResult1 = (FetchThreadListResult)localImmutableMap1.get(FolderName.b);
    FetchThreadListResult localFetchThreadListResult2 = (FetchThreadListResult)localImmutableMap1.get(FolderName.d);
    ImmutableMap localImmutableMap2 = ImmutableMap.a(FolderName.b, localFetchThreadListResult1, FolderName.d, localFetchThreadListResult2);
    if ((localFetchThreadListResult1.n() != null) || (localFetchThreadListResult2.n() != null));
    for (boolean bool1 = true; ; bool1 = false)
    {
      ThreadsCollection localThreadsCollection2;
      ThreadsCollection localThreadsCollection3;
      ImmutableList localImmutableList2;
      ImmutableList localImmutableList3;
      int j;
      if (((Boolean)this.e.b()).booleanValue())
      {
        localThreadsCollection2 = localFetchThreadListResult1.b();
        localThreadsCollection3 = localFetchThreadListResult2.b();
        MergingUtil.ThreadSummaryByDateComparator localThreadSummaryByDateComparator = new MergingUtil.ThreadSummaryByDateComparator();
        Collection[] arrayOfCollection4 = new Collection[2];
        arrayOfCollection4[0] = localThreadsCollection2.b();
        arrayOfCollection4[1] = localThreadsCollection3.b();
        ImmutableList localImmutableList1 = MergingUtil.a(localThreadSummaryByDateComparator, arrayOfCollection4);
        localImmutableList2 = a(localFetchThreadListParams.a(), paramOrcaServiceHandler, localImmutableList1);
        if (localImmutableList2.size() <= localFetchThreadListParams.d())
          break label686;
        localImmutableList3 = localImmutableList2.a(0, localFetchThreadListParams.d());
        j = 0;
      }
      while (true)
      {
        boolean bool2;
        if ((MergingUtil.a(new ThreadsCollection[] { localThreadsCollection2, localThreadsCollection3 })) && (j == 0))
          bool2 = true;
        label276: int i;
        ThreadsCollection[] arrayOfThreadsCollection;
        for (ThreadsCollection localThreadsCollection1 = new ThreadsCollection(localImmutableList3, bool2); ; localThreadsCollection1 = MergingUtil.a(i, arrayOfThreadsCollection))
        {
          FetchThreadListResultBuilder localFetchThreadListResultBuilder1 = FetchThreadListResult.newBuilder();
          DataFreshnessResult[] arrayOfDataFreshnessResult = new DataFreshnessResult[2];
          arrayOfDataFreshnessResult[0] = localFetchThreadListResult1.e();
          arrayOfDataFreshnessResult[1] = localFetchThreadListResult2.e();
          FetchThreadListResultBuilder localFetchThreadListResultBuilder2 = localFetchThreadListResultBuilder1.a(MergingUtil.a(arrayOfDataFreshnessResult)).a(localFolderName).a(localThreadsCollection1);
          Collection[] arrayOfCollection1 = new Collection[2];
          arrayOfCollection1[0] = localFetchThreadListResult1.c();
          arrayOfCollection1[1] = localFetchThreadListResult2.c();
          FetchThreadListResultBuilder localFetchThreadListResultBuilder3 = localFetchThreadListResultBuilder2.a(MergingUtil.a(arrayOfCollection1));
          Collection[] arrayOfCollection2 = new Collection[2];
          arrayOfCollection2[0] = localFetchThreadListResult1.d();
          arrayOfCollection2[1] = localFetchThreadListResult2.d();
          FetchThreadListResultBuilder localFetchThreadListResultBuilder4 = localFetchThreadListResultBuilder3.a(MergingUtil.a(arrayOfCollection2));
          Collection[] arrayOfCollection3 = new Collection[2];
          arrayOfCollection3[0] = localFetchThreadListResult1.g();
          arrayOfCollection3[1] = localFetchThreadListResult2.g();
          FetchThreadListResultBuilder localFetchThreadListResultBuilder5 = localFetchThreadListResultBuilder4.b(MergingUtil.a(arrayOfCollection3));
          FolderCounts[] arrayOfFolderCounts = new FolderCounts[2];
          arrayOfFolderCounts[0] = localFetchThreadListResult1.h();
          arrayOfFolderCounts[1] = localFetchThreadListResult2.h();
          FetchThreadListResultBuilder localFetchThreadListResultBuilder6 = localFetchThreadListResultBuilder5.a(MergingUtil.a(arrayOfFolderCounts)).a(localFetchThreadListResult1.i());
          Boolean[] arrayOfBoolean = new Boolean[2];
          arrayOfBoolean[0] = Boolean.valueOf(localFetchThreadListResult1.j());
          arrayOfBoolean[1] = Boolean.valueOf(localFetchThreadListResult2.j());
          FetchThreadListResultBuilder localFetchThreadListResultBuilder7 = localFetchThreadListResultBuilder6.a(MergingUtil.a(arrayOfBoolean));
          Long[] arrayOfLong1 = new Long[2];
          arrayOfLong1[0] = Long.valueOf(localFetchThreadListResult1.f());
          arrayOfLong1[1] = Long.valueOf(localFetchThreadListResult2.f());
          FetchThreadListResultBuilder localFetchThreadListResultBuilder8 = localFetchThreadListResultBuilder7.a(MergingUtil.a(arrayOfLong1));
          Long[] arrayOfLong2 = new Long[2];
          arrayOfLong2[0] = Long.valueOf(localFetchThreadListResult1.k());
          arrayOfLong2[1] = Long.valueOf(localFetchThreadListResult2.k());
          localOperationResult = OperationResult.a(localFetchThreadListResultBuilder8.b(MergingUtil.a(arrayOfLong2)).b(bool1).a(localImmutableMap2).o());
          break;
          bool2 = false;
          break label276;
          i = localFetchThreadListParams.d();
          arrayOfThreadsCollection = new ThreadsCollection[2];
          arrayOfThreadsCollection[0] = localFetchThreadListResult1.b();
          arrayOfThreadsCollection[1] = localFetchThreadListResult2.b();
        }
        label686: j = 1;
        localImmutableList3 = localImmutableList2;
      }
    }
  }

  protected OperationResult d(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    paramOperationParams.a();
    FetchMoreThreadsParams localFetchMoreThreadsParams = (FetchMoreThreadsParams)paramOperationParams.b().getParcelable("fetchMoreThreadsParams");
    FolderName localFolderName = localFetchMoreThreadsParams.a();
    OperationResult localOperationResult;
    if (localFolderName != FolderName.e)
    {
      localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
      return localOperationResult;
    }
    ImmutableMap localImmutableMap = a(H(paramOperationParams, paramOrcaServiceHandler), ImmutableList.a(FolderName.b, FolderName.d));
    FetchMoreThreadsResult localFetchMoreThreadsResult1 = (FetchMoreThreadsResult)localImmutableMap.get(FolderName.b);
    FetchMoreThreadsResult localFetchMoreThreadsResult2 = (FetchMoreThreadsResult)localImmutableMap.get(FolderName.d);
    ImmutableList localImmutableList4;
    boolean bool;
    if (((Boolean)this.e.b()).booleanValue())
    {
      ThreadsCollection localThreadsCollection2 = localFetchMoreThreadsResult1.b();
      ThreadsCollection localThreadsCollection3 = localFetchMoreThreadsResult2.b();
      MergingUtil.ThreadSummaryByDateComparator localThreadSummaryByDateComparator = new MergingUtil.ThreadSummaryByDateComparator();
      Collection[] arrayOfCollection2 = new Collection[2];
      arrayOfCollection2[0] = localThreadsCollection2.b();
      arrayOfCollection2[1] = localThreadsCollection3.b();
      ImmutableList localImmutableList2 = MergingUtil.a(localThreadSummaryByDateComparator, arrayOfCollection2);
      ImmutableList localImmutableList3 = a(DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE, paramOrcaServiceHandler, localImmutableList2);
      Iterator localIterator = localImmutableList3.iterator();
      for (int j = 0; (localIterator.hasNext()) && (((ThreadSummary)localIterator.next()).k() > localFetchMoreThreadsParams.b()); j++);
      int k = 1;
      int m = j + localFetchMoreThreadsParams.c();
      if (localImmutableList3.size() < m)
      {
        k = 0;
        m = localImmutableList3.size();
      }
      localImmutableList4 = localImmutableList3.a(j, m);
      if ((MergingUtil.a(new ThreadsCollection[] { localThreadsCollection2, localThreadsCollection3 })) && (k == 0))
        bool = true;
    }
    label300: int i;
    ThreadsCollection[] arrayOfThreadsCollection;
    for (ThreadsCollection localThreadsCollection1 = new ThreadsCollection(localImmutableList4, bool); ; localThreadsCollection1 = MergingUtil.a(i, arrayOfThreadsCollection))
    {
      DataFreshnessResult[] arrayOfDataFreshnessResult = new DataFreshnessResult[2];
      arrayOfDataFreshnessResult[0] = localFetchMoreThreadsResult1.e();
      arrayOfDataFreshnessResult[1] = localFetchMoreThreadsResult2.e();
      DataFreshnessResult localDataFreshnessResult = MergingUtil.a(arrayOfDataFreshnessResult);
      Collection[] arrayOfCollection1 = new Collection[2];
      arrayOfCollection1[0] = localFetchMoreThreadsResult1.c();
      arrayOfCollection1[1] = localFetchMoreThreadsResult2.c();
      ImmutableList localImmutableList1 = MergingUtil.a(arrayOfCollection1);
      Long[] arrayOfLong = new Long[2];
      arrayOfLong[0] = Long.valueOf(localFetchMoreThreadsResult1.f());
      arrayOfLong[1] = Long.valueOf(localFetchMoreThreadsResult2.f());
      localOperationResult = OperationResult.a(new FetchMoreThreadsResult(localDataFreshnessResult, localFolderName, localThreadsCollection1, localImmutableList1, MergingUtil.a(arrayOfLong), localImmutableMap));
      break;
      bool = false;
      break label300;
      i = localFetchMoreThreadsParams.c();
      arrayOfThreadsCollection = new ThreadsCollection[2];
      arrayOfThreadsCollection[0] = localFetchMoreThreadsResult1.b();
      arrayOfThreadsCollection[1] = localFetchMoreThreadsResult2.b();
    }
  }

  protected OperationResult e(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    Object localObject;
    if ((!((Boolean)this.e.b()).booleanValue()) || (!((Boolean)this.f.b()).booleanValue()))
      localObject = paramOrcaServiceHandler.a(paramOperationParams);
    while (true)
    {
      return localObject;
      OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
      FetchThreadResult localFetchThreadResult = (FetchThreadResult)localOperationResult.h();
      ThreadSummary localThreadSummary = localFetchThreadResult.a();
      if ((localThreadSummary == null) || (!localThreadSummary.g()))
      {
        localObject = localOperationResult;
        continue;
      }
      FetchThreadParams localFetchThreadParams = (FetchThreadParams)paramOperationParams.b().getParcelable("fetchThreadParams");
      UserKey localUserKey = localFetchThreadResult.a().h();
      ImmutableMultimap localImmutableMultimap = this.d.b(localUserKey);
      HashSet localHashSet = Sets.a();
      localHashSet.addAll(localImmutableMultimap.l());
      localHashSet.addAll(localImmutableMultimap.p());
      localHashSet.remove(localUserKey);
      if (localHashSet.size() == 0)
      {
        localObject = localOperationResult;
        continue;
      }
      FetchMultipleThreadsResult localFetchMultipleThreadsResult = a(localHashSet, localFetchThreadParams, paramOrcaServiceHandler);
      ImmutableList.Builder localBuilder = ImmutableList.e();
      localBuilder.b(localFetchThreadResult);
      a(localBuilder, localFetchMultipleThreadsResult.a());
      ImmutableList localImmutableList = localBuilder.b();
      if (localImmutableList.size() > 1)
      {
        localObject = OperationResult.a(a(localFetchThreadParams, localImmutableList));
        continue;
      }
      localObject = localOperationResult;
    }
  }

  protected OperationResult q(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    String str = paramOperationParams.a();
    Bundle localBundle = paramOperationParams.b();
    if ((FolderName)localBundle.getParcelable("folderName") != FolderName.e);
    for (OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams); ; localOperationResult = OperationResult.b())
    {
      return localOperationResult;
      a(new MergeServiceHandler.4(this, localBundle, str, paramOrcaServiceHandler), ImmutableList.a(FolderName.b, FolderName.d));
    }
  }

  protected OperationResult v(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    OperationResult localOperationResult;
    if ((!((Boolean)this.e.b()).booleanValue()) || (!((Boolean)this.f.b()).booleanValue()))
    {
      localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
      return localOperationResult;
    }
    FetchMoreMessagesParams localFetchMoreMessagesParams = (FetchMoreMessagesParams)paramOperationParams.b().getParcelable("fetchMoreMessagesParams");
    FetchThreadParams localFetchThreadParams = new FetchThreadParamsBuilder().a(DataFreshnessParam.STALE_DATA_OKAY).a(localFetchMoreMessagesParams.a()).a(0).h();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("fetchThreadParams", localFetchThreadParams);
    FetchThreadResult localFetchThreadResult = (FetchThreadResult)paramOrcaServiceHandler.a(new OperationParams("fetch_thread", localBundle)).h();
    List localList;
    FetchMoreMessagesResult localFetchMoreMessagesResult;
    if (localFetchThreadResult.a().g())
    {
      UserKey localUserKey = localFetchThreadResult.a().h();
      ImmutableMultimap localImmutableMultimap = this.d.b(localUserKey);
      HashSet localHashSet = Sets.a();
      localHashSet.addAll(localImmutableMultimap.o());
      localHashSet.addAll(localImmutableMultimap.p());
      localList = a(localHashSet, paramOperationParams, paramOrcaServiceHandler);
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        localFetchMoreMessagesResult = (FetchMoreMessagesResult)localIterator.next();
        String str = localFetchMoreMessagesResult.a().a();
        if ((str == null) || (MessagingIdUtil.g(str)))
          continue;
        localList.remove(localFetchMoreMessagesResult);
      }
    }
    while (true)
    {
      localOperationResult = OperationResult.a(MergingUtil.a(localFetchMoreMessagesParams.d(), localFetchMoreMessagesResult, localList));
      break;
      localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
      break;
      localFetchMoreMessagesResult = null;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.merge.MergeServiceHandler
 * JD-Core Version:    0.6.0
 */