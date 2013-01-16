package com.facebook.feed.protocol;

import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class AddCommentMethod
  implements ApiMethod<AddCommentParams, String>
{
  public ApiRequest a(AddCommentParams paramAddCommentParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("message", paramAddCommentParams.b));
    if (paramAddCommentParams.d != null)
    {
      ArrayNode localArrayNode = paramAddCommentParams.d.a;
      if ((localArrayNode != null) && (localArrayNode.size() > 0))
        localArrayList.add(new BasicNameValuePair("tracking", localArrayNode.toString()));
      String str = paramAddCommentParams.d.b;
      if (!StringUtil.a(str))
        localArrayList.add(new BasicNameValuePair("nectar_module", str));
    }
    localArrayList.add(new BasicNameValuePair("format", "json"));
    return new ApiRequest("graphObjectComments", "POST", paramAddCommentParams.a + "/comments", localArrayList, ApiResponseType.JSON);
  }

  public String a(AddCommentParams paramAddCommentParams, ApiResponse paramApiResponse)
  {
    return JSONUtil.b(paramApiResponse.c().get("id"));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.AddCommentMethod
 * JD-Core Version:    0.6.0
 */