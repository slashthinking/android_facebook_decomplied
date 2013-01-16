package com.facebook.feed.protocol.coupons;

import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class ClaimCouponMethod
  implements ApiMethod<ClaimCouponParams, Boolean>
{
  public ApiRequest a(ClaimCouponParams paramClaimCouponParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("offer_id", paramClaimCouponParams.a));
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramClaimCouponParams.b;
    return new ApiRequest("graphObjectCouponClaim", "POST", StringUtil.a("me/%s", arrayOfObject), localArrayList, ApiResponseType.JSON);
  }

  public Boolean a(ClaimCouponParams paramClaimCouponParams, ApiResponse paramApiResponse)
  {
    return Boolean.valueOf(paramApiResponse.c().asBoolean());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.coupons.ClaimCouponMethod
 * JD-Core Version:    0.6.0
 */