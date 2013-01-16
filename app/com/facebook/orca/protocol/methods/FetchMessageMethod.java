package com.facebook.orca.protocol.methods;

import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.FetchMessageResult;
import com.facebook.orca.threads.Message;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class FetchMessageMethod
  implements ApiMethod<String, FetchMessageResult>
{
  private final FetchThreadsFqlHelper a;

  public FetchMessageMethod(FetchThreadsFqlHelper paramFetchThreadsFqlHelper)
  {
    this.a = paramFetchThreadsFqlHelper;
  }

  private String b(String paramString)
  {
    FqlMultiQueryHelper localFqlMultiQueryHelper = new FqlMultiQueryHelper();
    this.a.b(localFqlMultiQueryHelper, StringLocaleUtil.a("message_id='%1s'", new Object[] { paramString }), "timestamp DESC", 1);
    return localFqlMultiQueryHelper.a().toString();
  }

  public ApiRequest a(String paramString)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    localArrayList.add(new BasicNameValuePair("queries", b(paramString)));
    return new ApiRequest("fetchMoreMessages", "GET", "method/fql.multiquery", localArrayList, ApiResponseType.JSON);
  }

  public FetchMessageResult a(String paramString, ApiResponse paramApiResponse)
  {
    FqlResultHelper localFqlResultHelper = new FqlResultHelper(paramApiResponse.c());
    FetchThreadsFqlHelper.MessagesResult localMessagesResult = this.a.b(localFqlResultHelper, 1);
    DataFreshnessResult localDataFreshnessResult = DataFreshnessResult.FROM_SERVER;
    if (localMessagesResult.a.isEmpty());
    for (Message localMessage = null; ; localMessage = (Message)localMessagesResult.a.get(0))
      return new FetchMessageResult(localDataFreshnessResult, localMessage, System.currentTimeMillis());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.FetchMessageMethod
 * JD-Core Version:    0.6.0
 */