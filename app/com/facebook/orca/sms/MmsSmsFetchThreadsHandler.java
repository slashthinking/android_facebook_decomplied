package com.facebook.orca.sms;

import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.FetchMoreThreadsParams;
import com.facebook.orca.server.FetchMoreThreadsResult;
import com.facebook.orca.server.FetchThreadListParams;
import com.facebook.orca.server.FetchThreadListResult;
import com.facebook.orca.server.FetchThreadListResultBuilder;
import com.facebook.orca.threads.FolderCounts;
import com.facebook.orca.threads.FolderName;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.threads.ThreadsCollection;

public class MmsSmsFetchThreadsHandler
{
  private static final Class<?> a = MmsSmsFetchThreadsHandler.class;
  private final MmsSmsContentResolverHandler b;

  public MmsSmsFetchThreadsHandler(MmsSmsContentResolverHandler paramMmsSmsContentResolverHandler)
  {
    this.b = paramMmsSmsContentResolverHandler;
  }

  public FetchMoreThreadsResult a(FetchMoreThreadsParams paramFetchMoreThreadsParams)
  {
    FetchMmsSmsThreadListParams localFetchMmsSmsThreadListParams = FetchMmsSmsThreadListParams.b(paramFetchMoreThreadsParams.c(), paramFetchMoreThreadsParams.b());
    FetchMmsSmsThreadListResult localFetchMmsSmsThreadListResult = this.b.a(localFetchMmsSmsThreadListParams);
    return new FetchMoreThreadsResult(DataFreshnessResult.FROM_CACHE_UP_TO_DATE, FolderName.d, localFetchMmsSmsThreadListResult.a(), localFetchMmsSmsThreadListResult.b(), System.currentTimeMillis());
  }

  public FetchThreadListResult a(FetchThreadListParams paramFetchThreadListParams)
  {
    long l1 = paramFetchThreadListParams.c() / 1000000L;
    boolean bool;
    FetchMmsSmsThreadListResult localFetchMmsSmsThreadListResult;
    ThreadsCollection localThreadsCollection;
    FolderCounts localFolderCounts;
    long l2;
    long l3;
    if (paramFetchThreadListParams.c() != -1L)
    {
      bool = true;
      FetchMmsSmsThreadListParams localFetchMmsSmsThreadListParams = FetchMmsSmsThreadListParams.a(paramFetchThreadListParams.d(), l1);
      localFetchMmsSmsThreadListResult = this.b.a(localFetchMmsSmsThreadListParams);
      localThreadsCollection = localFetchMmsSmsThreadListResult.a();
      localFolderCounts = this.b.a();
      l2 = paramFetchThreadListParams.c();
      if (localThreadsCollection.e() <= 0)
        break label144;
      l3 = localThreadsCollection.a(0).b();
    }
    while (true)
    {
      return FetchThreadListResult.newBuilder().a(DataFreshnessResult.FROM_SERVER).a(FolderName.d).a(localThreadsCollection).a(localFetchMmsSmsThreadListResult.b()).a(localFolderCounts).a(bool).a(System.currentTimeMillis()).b(l3).o();
      bool = false;
      break;
      label144: l3 = l2;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.MmsSmsFetchThreadsHandler
 * JD-Core Version:    0.6.0
 */