package com.facebook.megaphone.api;

import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.graphql.model.MegaphoneStory;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.server.DataFreshnessResult;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FetchMegaphoneMethod
  implements ApiMethod<FetchMegaphoneParams, FetchMegaphoneResult>
{
  private GraphQLHelper a;

  public FetchMegaphoneMethod(GraphQLHelper paramGraphQLHelper)
  {
    this.a = paramGraphQLHelper;
  }

  public FetchMegaphoneResult a(FetchMegaphoneParams paramFetchMegaphoneParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    JsonParser localJsonParser = this.a.a("fetch_megaphone", 2, paramApiResponse.d());
    return new FetchMegaphoneResult((MegaphoneStory)((ObjectMapper)localJsonParser.getCodec()).readValue(localJsonParser, MegaphoneStory.class), DataFreshnessResult.FROM_SERVER, System.currentTimeMillis());
  }

  public ApiRequest a(FetchMegaphoneParams paramFetchMegaphoneParams)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramFetchMegaphoneParams.a;
    arrayOfObject[1] = Integer.valueOf(paramFetchMegaphoneParams.b);
    String str = StringUtil.a("me() {megaphone.location(%s) {id,action{style,title,url},content,close_label,location,title,image.size(%d),is_persistent}}", arrayOfObject);
    return this.a.a("fetch_megaphone", str);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.megaphone.api.FetchMegaphoneMethod
 * JD-Core Version:    0.6.2
 */