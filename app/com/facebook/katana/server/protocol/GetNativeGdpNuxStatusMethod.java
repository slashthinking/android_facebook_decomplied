package com.facebook.katana.server.protocol;

import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class GetNativeGdpNuxStatusMethod
  implements ApiMethod<Void, Integer>
{
  public ApiRequest a(Void paramVoid)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    localArrayList.add(new BasicNameValuePair("query", "SELECT extra_data FROM user_nux_status WHERE  nux_id=\"public_info_gdp_wizard\""));
    return new ApiRequest("get_native_gdp_nux_status_method", "GET", "method/fql.query", localArrayList, ApiResponseType.JSON);
  }

  public Integer a(Void paramVoid, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    JsonNode localJsonNode = paramApiResponse.c();
    if (!localJsonNode.isArray())
      throw new IOException("Result must be an array");
    return Integer.valueOf(localJsonNode.get(0).get("extra_data").get("count").asInt());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.server.protocol.GetNativeGdpNuxStatusMethod
 * JD-Core Version:    0.6.0
 */