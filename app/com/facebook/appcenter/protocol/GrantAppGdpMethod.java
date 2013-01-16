package com.facebook.appcenter.protocol;

import com.facebook.appcenter.service.GrantAppGdpParams;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class GrantAppGdpMethod
  implements ApiMethod<GrantAppGdpParams, String>
{
  public ApiRequest a(GrantAppGdpParams paramGrantAppGdpParams)
  {
    ArrayList localArrayList = Lists.a();
    String str1 = paramGrantAppGdpParams.a();
    Preconditions.checkNotNull(str1);
    localArrayList.add(new BasicNameValuePair("app_id", str1));
    String str2 = paramGrantAppGdpParams.b();
    if (str2 != null)
      localArrayList.add(new BasicNameValuePair("permissions", str2));
    String str3 = paramGrantAppGdpParams.c();
    if (str3 != null)
      localArrayList.add(new BasicNameValuePair("write_privacy", str3));
    localArrayList.add(new BasicNameValuePair("format", "json"));
    return new ApiRequest("grant_app_gdp", "POST", "method/AuthAppCenterAuthorizeApp", localArrayList, ApiResponseType.JSON);
  }

  public String a(GrantAppGdpParams paramGrantAppGdpParams, ApiResponse paramApiResponse)
  {
    return paramApiResponse.c().get("permissions").toString();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.protocol.GrantAppGdpMethod
 * JD-Core Version:    0.6.0
 */