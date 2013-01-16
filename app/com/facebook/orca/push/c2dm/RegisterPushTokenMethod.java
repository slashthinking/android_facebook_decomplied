package com.facebook.orca.push.c2dm;

import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class RegisterPushTokenMethod
  implements ApiMethod<RegisterPushTokenParams, RegisterPushTokenResult>
{
  public ApiRequest a(RegisterPushTokenParams paramRegisterPushTokenParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    localArrayList.add(new BasicNameValuePair("return_structure", "1"));
    ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
    if (paramRegisterPushTokenParams.a() == PushTokenHolder.ServiceType.GCM)
      localObjectNode.put("url", "https://android.googleapis.com/gcm/send");
    localObjectNode.put("token", paramRegisterPushTokenParams.b());
    localObjectNode.put("device_id", paramRegisterPushTokenParams.c());
    localObjectNode.put("is_initial_reg", paramRegisterPushTokenParams.d());
    localArrayList.add(new BasicNameValuePair("protocol_params", localObjectNode.toString()));
    return new ApiRequest("registerPush", "POST", "method/user.registerPushCallback", localArrayList, ApiResponseType.JSON);
  }

  public RegisterPushTokenResult a(RegisterPushTokenParams paramRegisterPushTokenParams, ApiResponse paramApiResponse)
  {
    JsonNode localJsonNode = paramApiResponse.c();
    return new RegisterPushTokenResult(JSONUtil.f(localJsonNode.get("success")), JSONUtil.f(localJsonNode.get("previously_disabled")), System.currentTimeMillis());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.c2dm.RegisterPushTokenMethod
 * JD-Core Version:    0.6.0
 */