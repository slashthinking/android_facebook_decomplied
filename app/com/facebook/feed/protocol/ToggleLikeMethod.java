package com.facebook.feed.protocol;

import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class ToggleLikeMethod
  implements ApiMethod<ToggleLikeParams, Boolean>
{
  public ApiRequest a(ToggleLikeParams paramToggleLikeParams)
  {
    ArrayList localArrayList = Lists.a();
    if (paramToggleLikeParams.d != null)
    {
      ArrayNode localArrayNode = paramToggleLikeParams.d.a;
      if ((localArrayNode != null) && (localArrayNode.size() > 0))
        localArrayList.add(new BasicNameValuePair("tracking", localArrayNode.toString()));
      String str3 = paramToggleLikeParams.d.b;
      if (!StringUtil.a(str3))
        localArrayList.add(new BasicNameValuePair("nectar_module", str3));
    }
    localArrayList.add(new BasicNameValuePair("format", "json"));
    String str1 = paramToggleLikeParams.a + "/likes";
    if (paramToggleLikeParams.b);
    for (String str2 = "POST"; ; str2 = "DELETE")
      return new ApiRequest("graphObjectLike", str2, str1, localArrayList, ApiResponseType.JSON);
  }

  public Boolean a(ToggleLikeParams paramToggleLikeParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    return Boolean.valueOf(paramToggleLikeParams.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.ToggleLikeMethod
 * JD-Core Version:    0.6.0
 */