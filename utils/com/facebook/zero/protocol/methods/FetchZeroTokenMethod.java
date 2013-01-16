package com.facebook.zero.protocol.methods;

import android.text.TextUtils;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.zero.protocol.CarrierMccMnc;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class FetchZeroTokenMethod
  implements ApiMethod<CarrierMccMnc, FetchZeroTokenResult>
{
  public ApiRequest a(CarrierMccMnc paramCarrierMccMnc)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("mcc", paramCarrierMccMnc.a()));
    localArrayList.add(new BasicNameValuePair("mnc", paramCarrierMccMnc.b()));
    localArrayList.add(new BasicNameValuePair("format", "json"));
    return new ApiRequest("fetchZeroToken", "GET", "method/mobile.zeroGenerateToken", localArrayList, ApiResponseType.JSON);
  }

  public FetchZeroTokenResult a(CarrierMccMnc paramCarrierMccMnc, ApiResponse paramApiResponse)
  {
    JsonNode localJsonNode = paramApiResponse.c();
    if (localJsonNode == null)
      throw new Exception("Expected response to be a struct");
    boolean bool1 = localJsonNode.has("token");
    String str = null;
    if (bool1)
    {
      boolean bool2 = TextUtils.isEmpty(localJsonNode.get("token").asText());
      str = null;
      if (!bool2)
        str = localJsonNode.get("token").asText();
    }
    return new FetchZeroTokenResult(str);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.zero.protocol.methods.FetchZeroTokenMethod
 * JD-Core Version:    0.6.2
 */