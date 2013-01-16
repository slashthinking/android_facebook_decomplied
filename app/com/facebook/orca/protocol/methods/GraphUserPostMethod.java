package com.facebook.orca.protocol.methods;

import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.server.GraphUserPostParams;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class GraphUserPostMethod
  implements ApiMethod<GraphUserPostParams, Boolean>
{
  public ApiRequest a(GraphUserPostParams paramGraphUserPostParams)
  {
    ArrayList localArrayList = Lists.a();
    if (paramGraphUserPostParams.a() != null)
      localArrayList.add(new BasicNameValuePair("firstname", paramGraphUserPostParams.a()));
    if (paramGraphUserPostParams.b() != null)
      localArrayList.add(new BasicNameValuePair("lastname", paramGraphUserPostParams.b()));
    return new ApiRequest("graphUserPost", "POST", "me", localArrayList, ApiResponseType.JSON);
  }

  public Boolean a(GraphUserPostParams paramGraphUserPostParams, ApiResponse paramApiResponse)
  {
    return Boolean.valueOf(paramApiResponse.c().asBoolean());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.GraphUserPostMethod
 * JD-Core Version:    0.6.0
 */