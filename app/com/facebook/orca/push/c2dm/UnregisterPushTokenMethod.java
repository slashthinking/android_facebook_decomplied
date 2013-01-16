package com.facebook.orca.push.c2dm;

import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class UnregisterPushTokenMethod
  implements ApiMethod<UnregisterPushTokenParams, Boolean>
{
  public ApiRequest a(UnregisterPushTokenParams paramUnregisterPushTokenParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    localArrayList.add(new BasicNameValuePair("token", paramUnregisterPushTokenParams.a()));
    return new ApiRequest("unregisterPush", "POST", "method/user.unregisterPushCallback", localArrayList, ApiResponseType.STRING);
  }

  public Boolean a(UnregisterPushTokenParams paramUnregisterPushTokenParams, ApiResponse paramApiResponse)
  {
    return Boolean.valueOf("true".equals(paramApiResponse.b()));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.c2dm.UnregisterPushTokenMethod
 * JD-Core Version:    0.6.0
 */