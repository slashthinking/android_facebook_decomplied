package com.facebook.orca.protocol.methods;

import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.FetchThreadParams;
import com.facebook.orca.server.FetchThreadResult;
import com.facebook.orca.server.ThreadCriteria;
import com.facebook.orca.threads.MessagesCollection;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.users.User;
import com.facebook.orca.users.UserKey;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class FetchThreadMethod
  implements ApiMethod<FetchThreadParams, FetchThreadResult>
{
  private static final Class<?> a = FetchThreadMethod.class;
  private final FetchThreadsFqlHelper b;

  public FetchThreadMethod(FetchThreadsFqlHelper paramFetchThreadsFqlHelper)
  {
    this.b = paramFetchThreadsFqlHelper;
  }

  private String b(FetchThreadParams paramFetchThreadParams)
  {
    FqlMultiQueryHelper localFqlMultiQueryHelper = new FqlMultiQueryHelper();
    this.b.a(localFqlMultiQueryHelper, "thread_id='" + paramFetchThreadParams.a().a() + "'", "timestamp DESC", 1, false, true);
    if (paramFetchThreadParams.f() != 0)
      this.b.a(localFqlMultiQueryHelper, "thread_id='" + paramFetchThreadParams.a().a() + "'", "timestamp DESC", 1 + paramFetchThreadParams.f());
    return localFqlMultiQueryHelper.a().toString();
  }

  private String c(FetchThreadParams paramFetchThreadParams)
  {
    FqlMultiQueryHelper localFqlMultiQueryHelper = new FqlMultiQueryHelper();
    this.b.a(localFqlMultiQueryHelper, "thread_id='" + paramFetchThreadParams.a().a() + "'", "timestamp DESC", 1, false, true);
    if (paramFetchThreadParams.f() != 0)
    {
      FetchThreadsFqlHelper localFetchThreadsFqlHelper = this.b;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramFetchThreadParams.a().a();
      arrayOfObject[1] = Long.valueOf(paramFetchThreadParams.g());
      localFetchThreadsFqlHelper.a(localFqlMultiQueryHelper, StringLocaleUtil.a("thread_id='%1$s' AND timestamp > %2$d", arrayOfObject), "timestamp DESC", 1 + paramFetchThreadParams.f());
    }
    return localFqlMultiQueryHelper.a().toString();
  }

  private String d(FetchThreadParams paramFetchThreadParams)
  {
    FqlMultiQueryHelper localFqlMultiQueryHelper = new FqlMultiQueryHelper();
    this.b.b(localFqlMultiQueryHelper, paramFetchThreadParams.a().b().b());
    this.b.a(localFqlMultiQueryHelper, "single_recipient='" + paramFetchThreadParams.a().b().b() + "'", "timestamp DESC", 1, false, true);
    if (paramFetchThreadParams.f() != 0)
      this.b.a(localFqlMultiQueryHelper, "thread_id IN (SELECT thread_id FROM #threads)", "timestamp DESC", 1 + paramFetchThreadParams.f());
    return localFqlMultiQueryHelper.a().toString();
  }

  public ApiRequest a(FetchThreadParams paramFetchThreadParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    if (paramFetchThreadParams.a().b() != null)
      localArrayList.add(new BasicNameValuePair("q", d(paramFetchThreadParams)));
    while (true)
    {
      return new ApiRequest("fetchThread", "GET", "fql", localArrayList, ApiResponseType.JSON);
      if (paramFetchThreadParams.g() == -1L)
      {
        localArrayList.add(new BasicNameValuePair("q", b(paramFetchThreadParams)));
        continue;
      }
      localArrayList.add(new BasicNameValuePair("q", c(paramFetchThreadParams)));
    }
  }

  public FetchThreadResult a(FetchThreadParams paramFetchThreadParams, ApiResponse paramApiResponse)
  {
    int i = 1;
    FqlResultHelper localFqlResultHelper = new FqlResultHelper(paramApiResponse.c());
    FetchThreadsFqlHelper.ThreadsResult localThreadsResult = this.b.a(localFqlResultHelper, false, i);
    User localUser;
    if (paramFetchThreadParams.a().b() != null)
    {
      localUser = this.b.a(localFqlResultHelper);
      if (localUser == null)
        throw new Exception("Couldn't find canonical user");
    }
    else
    {
      localUser = null;
    }
    FetchThreadResult localFetchThreadResult;
    if (localThreadsResult.a.size() == 0)
    {
      if (paramFetchThreadParams.a().b() == null)
        throw new Exception("Couldn't find thread");
      localFetchThreadResult = new FetchThreadResult(DataFreshnessResult.FROM_SERVER, null, null, null, localUser, System.currentTimeMillis());
      return localFetchThreadResult;
    }
    if (localThreadsResult.a.size() > i)
      throw new Exception("Invalid api response - multiple threads in fetchThread");
    ThreadSummary localThreadSummary = (ThreadSummary)localThreadsResult.a.get(0);
    FetchThreadsFqlHelper.MessagesResult localMessagesResult = this.b.a(localFqlResultHelper, paramFetchThreadParams.f());
    if ((paramFetchThreadParams.g() < 0L) && (localMessagesResult.b < paramFetchThreadParams.f()));
    while (true)
    {
      MessagesCollection localMessagesCollection = new MessagesCollection(localThreadSummary.a(), localMessagesResult.a, i);
      localFetchThreadResult = new FetchThreadResult(DataFreshnessResult.FROM_SERVER, localThreadSummary, localMessagesCollection, localThreadsResult.d, localUser, System.currentTimeMillis());
      break;
      int j = 0;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.FetchThreadMethod
 * JD-Core Version:    0.6.0
 */