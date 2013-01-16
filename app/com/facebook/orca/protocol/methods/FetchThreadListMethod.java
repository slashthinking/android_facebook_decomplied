package com.facebook.orca.protocol.methods;

import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.notify.NotificationSetting;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.FetchThreadListParams;
import com.facebook.orca.server.FetchThreadListResult;
import com.facebook.orca.server.FetchThreadListResultBuilder;
import com.facebook.orca.threads.FolderCounts;
import com.facebook.orca.threads.FolderName;
import com.facebook.orca.threads.FolderType;
import com.facebook.orca.threads.ThreadsCollection;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class FetchThreadListMethod
  implements ApiMethod<FetchThreadListParams, FetchThreadListResult>
{
  private static final Class<?> a = FetchThreadListMethod.class;
  private final FetchThreadsFqlHelper b;

  public FetchThreadListMethod(FetchThreadsFqlHelper paramFetchThreadsFqlHelper)
  {
    this.b = paramFetchThreadsFqlHelper;
  }

  private String b(FetchThreadListParams paramFetchThreadListParams)
  {
    FolderName localFolderName = paramFetchThreadListParams.b();
    FqlMultiQueryHelper localFqlMultiQueryHelper = new FqlMultiQueryHelper();
    this.b.a(localFqlMultiQueryHelper);
    this.b.a(localFqlMultiQueryHelper, localFolderName);
    FetchThreadsFqlHelper localFetchThreadsFqlHelper = this.b;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = localFolderName.a().a();
    localFetchThreadsFqlHelper.a(localFqlMultiQueryHelper, StringLocaleUtil.a("folder='%1$s' AND archived=0", arrayOfObject), "timestamp DESC", 1 + paramFetchThreadListParams.d(), false);
    return localFqlMultiQueryHelper.a().toString();
  }

  private String c(FetchThreadListParams paramFetchThreadListParams)
  {
    FolderName localFolderName = paramFetchThreadListParams.b();
    FqlMultiQueryHelper localFqlMultiQueryHelper = new FqlMultiQueryHelper();
    this.b.a(localFqlMultiQueryHelper);
    this.b.a(localFqlMultiQueryHelper, localFolderName);
    FetchThreadsFqlHelper localFetchThreadsFqlHelper = this.b;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = localFolderName.a().a();
    arrayOfObject[1] = Long.valueOf(paramFetchThreadListParams.c());
    localFetchThreadsFqlHelper.a(localFqlMultiQueryHelper, StringLocaleUtil.a("folder='%1$s' AND action_id > %2$d", arrayOfObject), "timestamp DESC", 100, true);
    return localFqlMultiQueryHelper.a().toString();
  }

  public ApiRequest a(FetchThreadListParams paramFetchThreadListParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    if (paramFetchThreadListParams.c() == -1L)
      localArrayList.add(new BasicNameValuePair("q", b(paramFetchThreadListParams)));
    while (true)
    {
      return new ApiRequest("fetchThreads", "GET", "fql", localArrayList, ApiResponseType.JSON);
      localArrayList.add(new BasicNameValuePair("q", c(paramFetchThreadListParams)));
    }
  }

  public FetchThreadListResult a(FetchThreadListParams paramFetchThreadListParams, ApiResponse paramApiResponse)
  {
    boolean bool1 = true;
    FqlResultHelper localFqlResultHelper = new FqlResultHelper(paramApiResponse.c());
    boolean bool2;
    FetchThreadsFqlHelper.ThreadsResult localThreadsResult;
    if (paramFetchThreadListParams.c() != -1L)
    {
      bool2 = bool1;
      int i = paramFetchThreadListParams.d();
      localThreadsResult = this.b.a(localFqlResultHelper, bool2, i);
      if ((bool2) || (localThreadsResult.e >= 1 + paramFetchThreadListParams.d()))
        break label206;
    }
    while (true)
    {
      ThreadsCollection localThreadsCollection = new ThreadsCollection(localThreadsResult.a, bool1);
      FolderName localFolderName = this.b.c(localFqlResultHelper);
      FolderCounts localFolderCounts = this.b.d(localFqlResultHelper);
      NotificationSetting localNotificationSetting = this.b.e(localFqlResultHelper);
      return FetchThreadListResult.newBuilder().a(DataFreshnessResult.FROM_SERVER).a(localFolderName).a(localThreadsCollection).a(localThreadsResult.d).a(localThreadsResult.b).b(localThreadsResult.c).a(localFolderCounts).a(localNotificationSetting).a(bool2).a(System.currentTimeMillis()).b(Math.max(paramFetchThreadListParams.c(), localThreadsResult.f)).o();
      bool2 = false;
      break;
      label206: bool1 = false;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.FetchThreadListMethod
 * JD-Core Version:    0.6.0
 */