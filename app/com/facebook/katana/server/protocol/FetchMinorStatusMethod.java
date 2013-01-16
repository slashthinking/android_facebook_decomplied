package com.facebook.katana.server.protocol;

import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class FetchMinorStatusMethod
  implements ApiMethod<FetchMinorStatusMethod.Params, Boolean>
{
  public ApiRequest a(FetchMinorStatusMethod.Params paramParams)
  {
    String str = "SELECT is_minor FROM user WHERE uid=" + paramParams.a;
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("query", str));
    localArrayList.add(new BasicNameValuePair("format", "JSON"));
    return new ApiRequest("fetch_minor_status", "GET", "method/fql.query", localArrayList, ApiResponseType.JSON);
  }

  public Boolean a(FetchMinorStatusMethod.Params paramParams, ApiResponse paramApiResponse)
  {
    JsonNode localJsonNode = paramApiResponse.c();
    if (!localJsonNode.isArray())
      throw new Exception("Invalid response: array expected");
    if (localJsonNode.size() != 1)
      throw new Exception("Invalid response: 1 array element expected");
    return Boolean.valueOf(localJsonNode.get(0).get("is_minor").asBoolean());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.server.protocol.FetchMinorStatusMethod
 * JD-Core Version:    0.6.0
 */