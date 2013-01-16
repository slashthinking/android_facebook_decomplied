package com.facebook.composer.protocol;

import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class PostRecommendationMethod
  implements ApiMethod<PostRecommendationParams, String>
{
  public ApiRequest a(PostRecommendationParams paramPostRecommendationParams)
  {
    ArrayList localArrayList = Lists.a();
    Preconditions.checkNotNull(paramPostRecommendationParams);
    Preconditions.checkNotNull(paramPostRecommendationParams.b);
    Preconditions.checkNotNull(paramPostRecommendationParams.c);
    if (paramPostRecommendationParams.a > 0L);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      localArrayList.add(new BasicNameValuePair("message", paramPostRecommendationParams.b));
      localArrayList.add(new BasicNameValuePair("privacy", paramPostRecommendationParams.c));
      localArrayList.add(new BasicNameValuePair("format", "json"));
      return new ApiRequest("postRecommendation", "POST", paramPostRecommendationParams.a + "/recommendations", localArrayList, ApiResponseType.JSON);
    }
  }

  public String a(PostRecommendationParams paramPostRecommendationParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    return paramApiResponse.c().get("id").asText();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.composer.protocol.PostRecommendationMethod
 * JD-Core Version:    0.6.2
 */