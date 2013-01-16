package com.facebook.orca.protocol.methods;

import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.FetchMoreThreadsParams;
import com.facebook.orca.server.FetchMoreThreadsResult;
import com.facebook.orca.threads.FolderName;
import com.facebook.orca.threads.FolderType;
import com.facebook.orca.threads.ThreadsCollection;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class FetchMoreThreadsMethod
  implements ApiMethod<FetchMoreThreadsParams, FetchMoreThreadsResult>
{
  private static final Class<?> a = FetchMoreThreadsMethod.class;
  private final FetchThreadsFqlHelper b;

  public FetchMoreThreadsMethod(FetchThreadsFqlHelper paramFetchThreadsFqlHelper)
  {
    this.b = paramFetchThreadsFqlHelper;
  }

  private String b(FetchMoreThreadsParams paramFetchMoreThreadsParams)
  {
    FolderName localFolderName = paramFetchMoreThreadsParams.a();
    FqlMultiQueryHelper localFqlMultiQueryHelper = new FqlMultiQueryHelper();
    FetchThreadsFqlHelper localFetchThreadsFqlHelper = this.b;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = localFolderName.a().a();
    arrayOfObject[1] = Long.valueOf(paramFetchMoreThreadsParams.b());
    localFetchThreadsFqlHelper.a(localFqlMultiQueryHelper, StringLocaleUtil.a("folder='%1$s' AND archived=0 AND timestamp <= %2$d", arrayOfObject), "timestamp DESC", 1 + paramFetchMoreThreadsParams.c(), false);
    return localFqlMultiQueryHelper.a().toString();
  }

  public ApiRequest a(FetchMoreThreadsParams paramFetchMoreThreadsParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    localArrayList.add(new BasicNameValuePair("q", b(paramFetchMoreThreadsParams)));
    return new ApiRequest("fetchThreads", "GET", "fql", localArrayList, ApiResponseType.JSON);
  }

  public FetchMoreThreadsResult a(FetchMoreThreadsParams paramFetchMoreThreadsParams, ApiResponse paramApiResponse)
  {
    FqlResultHelper localFqlResultHelper = new FqlResultHelper(paramApiResponse.c());
    int i = paramFetchMoreThreadsParams.c();
    FetchThreadsFqlHelper.ThreadsResult localThreadsResult = this.b.a(localFqlResultHelper, false, i);
    int j = localThreadsResult.e;
    int k = 1 + paramFetchMoreThreadsParams.c();
    boolean bool = false;
    if (j < k)
      bool = true;
    ThreadsCollection localThreadsCollection = new ThreadsCollection(localThreadsResult.a, bool);
    return new FetchMoreThreadsResult(DataFreshnessResult.FROM_SERVER, paramFetchMoreThreadsParams.a(), localThreadsCollection, localThreadsResult.d, System.currentTimeMillis());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.FetchMoreThreadsMethod
 * JD-Core Version:    0.6.0
 */