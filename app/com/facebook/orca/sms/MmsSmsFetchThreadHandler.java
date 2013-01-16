package com.facebook.orca.sms;

import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.FetchMoreMessagesParams;
import com.facebook.orca.server.FetchMoreMessagesResult;
import com.facebook.orca.server.FetchThreadParams;
import com.facebook.orca.server.FetchThreadResult;
import com.facebook.orca.server.ThreadCriteria;
import com.facebook.orca.threads.MessagesCollection;
import com.facebook.orca.threads.MessagingIdUtil;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.users.User;
import com.facebook.orca.users.UserKey;
import com.google.common.collect.ImmutableList;

public class MmsSmsFetchThreadHandler
{
  private static final Class<?> a = MmsSmsFetchThreadsHandler.class;
  private final MmsSmsContentResolverHandler b;
  private MmsSmsUserUtils c;

  public MmsSmsFetchThreadHandler(MmsSmsContentResolverHandler paramMmsSmsContentResolverHandler, MmsSmsUserUtils paramMmsSmsUserUtils)
  {
    this.b = paramMmsSmsContentResolverHandler;
    this.c = paramMmsSmsUserUtils;
  }

  public FetchMoreMessagesResult a(FetchMoreMessagesParams paramFetchMoreMessagesParams)
  {
    ThreadCriteria localThreadCriteria = paramFetchMoreMessagesParams.a();
    long l = paramFetchMoreMessagesParams.c();
    int i = paramFetchMoreMessagesParams.d();
    DataFreshnessResult localDataFreshnessResult = DataFreshnessResult.FROM_CACHE_UP_TO_DATE;
    String str1 = localThreadCriteria.a();
    if (localThreadCriteria.b() != null)
    {
      String str2 = localThreadCriteria.b().b();
      str1 = MessagingIdUtil.a(this.b.b(str2));
    }
    if (str1 == null)
      throw new Exception("Trying to fetch an unknown MmsSms thread");
    FetchMmsSmsMessagesParams localFetchMmsSmsMessagesParams = FetchMmsSmsMessagesParams.b(MessagingIdUtil.c(str1), i, l);
    return new FetchMoreMessagesResult(localDataFreshnessResult, this.b.a(localFetchMmsSmsMessagesParams), -1L);
  }

  public FetchThreadResult a(FetchThreadParams paramFetchThreadParams)
  {
    ThreadCriteria localThreadCriteria = paramFetchThreadParams.a();
    DataFreshnessResult localDataFreshnessResult1 = DataFreshnessResult.NO_DATA;
    ImmutableList.d();
    long l2;
    FetchMmsSmsThreadResult localFetchMmsSmsThreadResult2;
    Object localObject;
    ImmutableList localImmutableList;
    if (localThreadCriteria.a() != null)
    {
      l2 = MessagingIdUtil.c(localThreadCriteria.a());
      localFetchMmsSmsThreadResult2 = this.b.a(l2);
      localObject = localFetchMmsSmsThreadResult2.a();
      localImmutableList = localFetchMmsSmsThreadResult2.b();
      if (localFetchMmsSmsThreadResult2.b().size() != 1)
        break label318;
    }
    label173: label310: label318: for (User localUser2 = (User)localFetchMmsSmsThreadResult2.b().get(0); ; localUser2 = null)
    {
      User localUser1 = localUser2;
      String str;
      ThreadSummary localThreadSummary;
      long l1;
      if ((localObject == null) && (localThreadCriteria.b() == null))
      {
        throw new Exception("Couldn't find thread");
        if (localThreadCriteria.b() != null)
        {
          str = localThreadCriteria.b().b();
          FetchMmsSmsThreadResult localFetchMmsSmsThreadResult1 = this.b.a(str);
          localThreadSummary = localFetchMmsSmsThreadResult1.a();
          localImmutableList = localFetchMmsSmsThreadResult1.b();
          if (localFetchMmsSmsThreadResult1.b().size() == 1)
          {
            localUser1 = (User)localFetchMmsSmsThreadResult1.b().get(0);
            if (localThreadSummary == null)
              break label310;
            l1 = MessagingIdUtil.c(localThreadSummary.a());
          }
        }
      }
      while (true)
      {
        l2 = l1;
        localObject = localThreadSummary;
        break;
        localUser1 = this.c.a(str);
        break label173;
        throw new Exception("Trying to fetch an MmsSms thread without a threadId or a phone number");
        MessagesCollection localMessagesCollection;
        DataFreshnessResult localDataFreshnessResult2;
        if ((localObject != null) && (l2 != -1L))
        {
          long l3 = paramFetchThreadParams.g();
          int i = paramFetchThreadParams.f();
          DataFreshnessResult localDataFreshnessResult3 = DataFreshnessResult.FROM_CACHE_UP_TO_DATE;
          FetchMmsSmsMessagesParams localFetchMmsSmsMessagesParams = FetchMmsSmsMessagesParams.a(l2, i, l3);
          localMessagesCollection = this.b.a(localFetchMmsSmsMessagesParams);
          localDataFreshnessResult2 = localDataFreshnessResult3;
        }
        while (true)
        {
          return new FetchThreadResult(localDataFreshnessResult2, (ThreadSummary)localObject, localMessagesCollection, localImmutableList, localUser1, System.currentTimeMillis());
          localDataFreshnessResult2 = localDataFreshnessResult1;
          localMessagesCollection = null;
        }
        l1 = -1L;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.MmsSmsFetchThreadHandler
 * JD-Core Version:    0.6.0
 */