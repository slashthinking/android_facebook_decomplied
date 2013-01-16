package com.facebook.katana.server.protocol;

import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class AuthorizeAppMethod
  implements ApiMethod<AuthorizeAppMethod.Params, AuthorizeAppMethod.Result>
{
  public AuthorizeAppMethod.Result a(AuthorizeAppMethod.Params paramParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    JsonNode localJsonNode = paramApiResponse.c();
    String str = localJsonNode.get("access_token").asText();
    long l = localJsonNode.get("expires").asLong();
    ArrayList localArrayList = Lists.a();
    Iterator localIterator = localJsonNode.get("permissions").iterator();
    while (localIterator.hasNext())
      localArrayList.add(((JsonNode)localIterator.next()).asText());
    return new AuthorizeAppMethod.Result(str, l, localArrayList, null);
  }

  public ApiRequest a(AuthorizeAppMethod.Params paramParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    localArrayList.add(new BasicNameValuePair("proxied_app_id", paramParams.a()));
    localArrayList.add(new BasicNameValuePair("android_key_hash", paramParams.b()));
    if (paramParams.c().isPresent())
      localArrayList.add(new BasicNameValuePair("permissions", (String)paramParams.c().get()));
    if (paramParams.d().isPresent())
    {
      ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
      localObjectNode.put("value", (String)paramParams.d().get());
      localArrayList.add(new BasicNameValuePair("write_privacy", localObjectNode.toString()));
    }
    if (paramParams.e().isPresent())
      localArrayList.add(new BasicNameValuePair("is_refresh_only", ((Boolean)paramParams.e().get()).toString()));
    return new ApiRequest("authorize_app_method", "POST", "method/auth.androidauthorizeapp", localArrayList, ApiResponseType.JSON);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.server.protocol.AuthorizeAppMethod
 * JD-Core Version:    0.6.0
 */