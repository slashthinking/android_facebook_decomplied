package com.facebook.orca.protocol.methods;

import com.facebook.orca.auth.FacebookCredentials;
import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.config.PlatformAppConfig;
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

public class AuthenticateSsoMethod
  implements ApiMethod<AuthenticateSsoMethod.Params, AuthenticationResult>
{
  private final PlatformAppConfig a;

  public AuthenticateSsoMethod(PlatformAppConfig paramPlatformAppConfig)
  {
    this.a = paramPlatformAppConfig;
  }

  public ApiRequest a(AuthenticateSsoMethod.Params paramParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    localArrayList.add(new BasicNameValuePair("access_token", AuthenticateSsoMethod.Params.a(paramParams)));
    localArrayList.add(new BasicNameValuePair("new_app_id", this.a.b()));
    if (AuthenticateSsoMethod.Params.b(paramParams))
      localArrayList.add(new BasicNameValuePair("generate_session_cookies", "1"));
    if (AuthenticateSsoMethod.Params.c(paramParams) != null)
      localArrayList.add(new BasicNameValuePair("machine_id", AuthenticateSsoMethod.Params.c(paramParams)));
    while (true)
    {
      return new ApiRequest("authenticate", "POST", "method/auth.getSessionForApp", localArrayList, ApiResponseType.JSON);
      localArrayList.add(new BasicNameValuePair("generate_machine_id", "1"));
    }
  }

  public AuthenticationResult a(AuthenticateSsoMethod.Params paramParams, ApiResponse paramApiResponse)
  {
    JsonNode localJsonNode = paramApiResponse.c();
    String str1 = JSONUtil.b(localJsonNode.get("access_token"));
    String str2 = JSONUtil.b(localJsonNode.get("machine_id"));
    ArrayNode localArrayNode = (ArrayNode)localJsonNode.get("session_cookies");
    if (localArrayNode == null);
    for (String str3 = null; ; str3 = localArrayNode.toString())
      return new AuthenticationResult(new FacebookCredentials(str1, 0L, str3), str2);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.AuthenticateSsoMethod
 * JD-Core Version:    0.6.2
 */