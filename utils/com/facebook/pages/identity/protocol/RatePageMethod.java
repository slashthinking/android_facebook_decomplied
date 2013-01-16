package com.facebook.pages.identity.protocol;

import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class RatePageMethod
  implements ApiMethod<RatePageParams, Void>
{
  public ApiRequest a(RatePageParams paramRatePageParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("rating", String.valueOf(paramRatePageParams.b())));
    Preconditions.checkNotNull(paramRatePageParams.a(), "Invalid page id!");
    return new ApiRequest("savePageRating", "POST", paramRatePageParams.a() + "/ratings", localArrayList, ApiResponseType.JSON);
  }

  public Void a(RatePageParams paramRatePageParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    return null;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.protocol.RatePageMethod
 * JD-Core Version:    0.6.2
 */