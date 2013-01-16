package com.facebook.zero.protocol.methods;

import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class ValidateZeroTokenMethod
  implements ApiMethod<ValidateZeroTokenMethod.Params, Boolean>
{
  public ApiRequest a(ValidateZeroTokenMethod.Params paramParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("token", ValidateZeroTokenMethod.Params.a(paramParams)));
    localArrayList.add(new BasicNameValuePair("format", "json"));
    return new ApiRequest("validateZeroToken", "GET", "method/mobile.zeroIsTokenValid", localArrayList, ApiResponseType.JSON);
  }

  public Boolean a(ValidateZeroTokenMethod.Params paramParams, ApiResponse paramApiResponse)
  {
    JsonNode localJsonNode = paramApiResponse.c();
    if ((localJsonNode != null) && (localJsonNode.has("is_valid")) && (localJsonNode.get("is_valid").asBoolean()));
    for (boolean bool = true; ; bool = false)
      return Boolean.valueOf(bool);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.zero.protocol.methods.ValidateZeroTokenMethod
 * JD-Core Version:    0.6.2
 */