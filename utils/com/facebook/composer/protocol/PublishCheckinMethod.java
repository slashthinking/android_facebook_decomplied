package com.facebook.composer.protocol;

import com.facebook.graphql.GraphQlUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Preconditions;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

public class PublishCheckinMethod
  implements ApiMethod<PublishPostParams, String>
{
  private static final Class<?> a = PublishCheckinMethod.class;

  private List<NameValuePair> b(PublishPostParams paramPublishPostParams)
  {
    List localList = PublishHelper.a(paramPublishPostParams);
    boolean bool1;
    if (paramPublishPostParams.b == paramPublishPostParams.j)
    {
      bool1 = true;
      Preconditions.checkArgument(bool1);
      if (StringUtil.a(paramPublishPostParams.d))
        break label169;
    }
    label169: for (boolean bool2 = true; ; bool2 = false)
    {
      Preconditions.checkArgument(bool2);
      boolean bool3 = StringUtil.a(paramPublishPostParams.k);
      boolean bool4 = false;
      if (!bool3)
        bool4 = true;
      Preconditions.checkArgument(bool4);
      localList.add(new BasicNameValuePair("coordinates", paramPublishPostParams.k));
      if (paramPublishPostParams.f)
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("event_checkins", true);
        localList.add(new BasicNameValuePair("migrations_override", localJSONObject.toString()));
      }
      if (!StringUtil.a(paramPublishPostParams.m))
        localList.add(new BasicNameValuePair("nectar_module", paramPublishPostParams.m));
      return localList;
      bool1 = false;
      break;
    }
  }

  public ApiRequest a(PublishPostParams paramPublishPostParams)
  {
    BLog.a(a, "Publishing check-in using publish check-in method.");
    List localList = b(paramPublishPostParams);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Long.valueOf(paramPublishPostParams.b);
    return new ApiRequest("graphObjectCheckin", "POST", StringUtil.a("%s/checkins", arrayOfObject), localList, ApiResponseType.JSON);
  }

  public String a(PublishPostParams paramPublishPostParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    String str = paramApiResponse.c().get("id").asText();
    return GraphQlUtil.a(paramPublishPostParams.b, str);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.composer.protocol.PublishCheckinMethod
 * JD-Core Version:    0.6.2
 */