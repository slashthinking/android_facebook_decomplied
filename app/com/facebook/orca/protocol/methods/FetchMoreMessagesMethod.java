package com.facebook.orca.protocol.methods;

import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.FetchMoreMessagesParams;
import com.facebook.orca.server.FetchMoreMessagesResult;
import com.facebook.orca.server.ThreadCriteria;
import com.facebook.orca.threads.MessagesCollection;
import com.facebook.orca.users.UserKey;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class FetchMoreMessagesMethod
  implements ApiMethod<FetchMoreMessagesParams, FetchMoreMessagesResult>
{
  private final FetchThreadsFqlHelper a;

  public FetchMoreMessagesMethod(FetchThreadsFqlHelper paramFetchThreadsFqlHelper)
  {
    this.a = paramFetchThreadsFqlHelper;
  }

  private String b(FetchMoreMessagesParams paramFetchMoreMessagesParams)
  {
    ThreadCriteria localThreadCriteria = paramFetchMoreMessagesParams.a();
    FqlMultiQueryHelper localFqlMultiQueryHelper = new FqlMultiQueryHelper();
    if (paramFetchMoreMessagesParams.c() == -1L)
    {
      FetchThreadsFqlHelper localFetchThreadsFqlHelper2 = this.a;
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = localThreadCriteria.a();
      arrayOfObject2[1] = Long.valueOf(paramFetchMoreMessagesParams.b());
      localFetchThreadsFqlHelper2.a(localFqlMultiQueryHelper, StringLocaleUtil.a("thread_id = '%1$s' AND timestamp >= %2$d", arrayOfObject2), "timestamp DESC", 1 + paramFetchMoreMessagesParams.d());
    }
    while (true)
    {
      return localFqlMultiQueryHelper.a().toString();
      FetchThreadsFqlHelper localFetchThreadsFqlHelper1 = this.a;
      Object[] arrayOfObject1 = new Object[3];
      arrayOfObject1[0] = localThreadCriteria.a();
      arrayOfObject1[1] = Long.valueOf(paramFetchMoreMessagesParams.b());
      arrayOfObject1[2] = Long.valueOf(paramFetchMoreMessagesParams.c());
      localFetchThreadsFqlHelper1.a(localFqlMultiQueryHelper, StringLocaleUtil.a("thread_id = '%1$s' AND timestamp >= %2$d AND timestamp <= %3$d", arrayOfObject1), "timestamp DESC", 1 + paramFetchMoreMessagesParams.d());
    }
  }

  private String c(FetchMoreMessagesParams paramFetchMoreMessagesParams)
  {
    ThreadCriteria localThreadCriteria = paramFetchMoreMessagesParams.a();
    FqlMultiQueryHelper localFqlMultiQueryHelper = new FqlMultiQueryHelper();
    this.a.a(localFqlMultiQueryHelper, localThreadCriteria.b().b());
    if (paramFetchMoreMessagesParams.c() == -1L)
    {
      FetchThreadsFqlHelper localFetchThreadsFqlHelper2 = this.a;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Long.valueOf(paramFetchMoreMessagesParams.b());
      localFetchThreadsFqlHelper2.a(localFqlMultiQueryHelper, StringLocaleUtil.a("thread_id IN (SELECT thread_id FROM #canonical_thread_id) AND timestamp >= %1$d", arrayOfObject2), "timestamp DESC", 1 + paramFetchMoreMessagesParams.d());
    }
    while (true)
    {
      return localFqlMultiQueryHelper.a().toString();
      FetchThreadsFqlHelper localFetchThreadsFqlHelper1 = this.a;
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = Long.valueOf(paramFetchMoreMessagesParams.b());
      arrayOfObject1[1] = Long.valueOf(paramFetchMoreMessagesParams.c());
      localFetchThreadsFqlHelper1.a(localFqlMultiQueryHelper, StringLocaleUtil.a("thread_id IN (SELECT thread_id FROM #canonical_thread_id) AND timestamp >= %1$d AND timestamp <= %2$d", arrayOfObject1), "timestamp DESC", 1 + paramFetchMoreMessagesParams.d());
    }
  }

  public ApiRequest a(FetchMoreMessagesParams paramFetchMoreMessagesParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    if (paramFetchMoreMessagesParams.a().a() != null)
      localArrayList.add(new BasicNameValuePair("q", b(paramFetchMoreMessagesParams)));
    while (true)
    {
      return new ApiRequest("fetchMoreMessages", "GET", "fql", localArrayList, ApiResponseType.JSON);
      localArrayList.add(new BasicNameValuePair("q", c(paramFetchMoreMessagesParams)));
    }
  }

  public FetchMoreMessagesResult a(FetchMoreMessagesParams paramFetchMoreMessagesParams, ApiResponse paramApiResponse)
  {
    ThreadCriteria localThreadCriteria = paramFetchMoreMessagesParams.a();
    FqlResultHelper localFqlResultHelper = new FqlResultHelper(paramApiResponse.c());
    String str = localThreadCriteria.a();
    if (str == null)
      str = this.a.b(localFqlResultHelper);
    FetchThreadsFqlHelper.MessagesResult localMessagesResult = this.a.a(localFqlResultHelper, paramFetchMoreMessagesParams.d());
    boolean bool1 = paramFetchMoreMessagesParams.b() < 0L;
    boolean bool2 = false;
    if (!bool1)
    {
      int i = localMessagesResult.b;
      int j = 1 + paramFetchMoreMessagesParams.d();
      bool2 = false;
      if (i < j)
        bool2 = true;
    }
    MessagesCollection localMessagesCollection = new MessagesCollection(str, localMessagesResult.a, bool2);
    return new FetchMoreMessagesResult(DataFreshnessResult.FROM_SERVER, localMessagesCollection, System.currentTimeMillis());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.FetchMoreMessagesMethod
 * JD-Core Version:    0.6.0
 */