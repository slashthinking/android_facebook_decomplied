package com.facebook.composer.protocol;

import com.facebook.graphql.model.Shareable;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Preconditions;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class PublishShareMethod
  implements ApiMethod<PublishPostParams, String>
{
  private static final Class<?> a = PublishShareMethod.class;

  public ApiRequest a(PublishPostParams paramPublishPostParams)
  {
    if (paramPublishPostParams.b > 0L);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      Preconditions.checkNotNull(paramPublishPostParams.l);
      Preconditions.checkNotNull(paramPublishPostParams.l.id);
      BLog.a(a, "Publishing share using publish share method.");
      List localList = PublishHelper.a(paramPublishPostParams);
      localList.add(new BasicNameValuePair("to", String.valueOf(paramPublishPostParams.b)));
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramPublishPostParams.l.id;
      return new ApiRequest("graphObjectShare", "POST", StringUtil.a("%s/sharedposts", arrayOfObject), localList, ApiResponseType.JSON);
    }
  }

  public String a(PublishPostParams paramPublishPostParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    return paramApiResponse.c().get("id").asText();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.composer.protocol.PublishShareMethod
 * JD-Core Version:    0.6.2
 */