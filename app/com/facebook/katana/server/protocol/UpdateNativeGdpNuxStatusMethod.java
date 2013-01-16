package com.facebook.katana.server.protocol;

import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class UpdateNativeGdpNuxStatusMethod
  implements ApiMethod<UpdateNativeGdpNuxStatusMethod.Params, Integer>
{
  public ApiRequest a(UpdateNativeGdpNuxStatusMethod.Params paramParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    localArrayList.add(new BasicNameValuePair("proxied_app_id", paramParams.a()));
    localArrayList.add(new BasicNameValuePair("nux_id", "PUBLIC_INFO_GDP_WIZARD"));
    localArrayList.add(new BasicNameValuePair("status", "COMPLETE"));
    return new ApiRequest("update_native_gdp_nux_status_method", "POST", "method/user.updatenuxstatus", localArrayList, ApiResponseType.STRING);
  }

  public Integer a(UpdateNativeGdpNuxStatusMethod.Params paramParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    return Integer.valueOf(Integer.parseInt(paramApiResponse.b()));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.server.protocol.UpdateNativeGdpNuxStatusMethod
 * JD-Core Version:    0.6.0
 */