package com.facebook.composer.protocol;

import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;

public class PublishPostMethod
  implements ApiMethod<PublishPostParams, String>
{
  private static final Class<?> a = PublishPostMethod.class;

  public ApiRequest a(PublishPostParams paramPublishPostParams)
  {
    BLog.a(a, "Publishing post using publish post method.");
    List localList = PublishHelper.a(paramPublishPostParams);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Long.valueOf(paramPublishPostParams.b);
    return new ApiRequest("graphObjectPosts", "POST", StringUtil.a("%s/feed", arrayOfObject), localList, ApiResponseType.JSON);
  }

  public String a(PublishPostParams paramPublishPostParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    return paramApiResponse.c().get("id").asText();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.composer.protocol.PublishPostMethod
 * JD-Core Version:    0.6.2
 */