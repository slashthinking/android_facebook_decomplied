package com.facebook.orca.protocol.methods;

import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.server.RequestSmsConfirmationCodeParams;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class RequestSmsConfirmationCodeMethod
  implements ApiMethod<RequestSmsConfirmationCodeParams, Void>
{
  public ApiRequest a(RequestSmsConfirmationCodeParams paramRequestSmsConfirmationCodeParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    localArrayList.add(new BasicNameValuePair("country", paramRequestSmsConfirmationCodeParams.a()));
    localArrayList.add(new BasicNameValuePair("phone_number", paramRequestSmsConfirmationCodeParams.b()));
    if (paramRequestSmsConfirmationCodeParams.c() != null)
      localArrayList.add(new BasicNameValuePair("marker", paramRequestSmsConfirmationCodeParams.c()));
    if (paramRequestSmsConfirmationCodeParams.d() != null)
      localArrayList.add(new BasicNameValuePair("flow", paramRequestSmsConfirmationCodeParams.d()));
    if (paramRequestSmsConfirmationCodeParams.e() != null)
      localArrayList.add(new BasicNameValuePair("reg_instance", paramRequestSmsConfirmationCodeParams.e()));
    return new ApiRequest("requestSmsConfirmationCode", "POST", "method/mobile.sendPhoneConfirmationCode", localArrayList, ApiResponseType.STRING);
  }

  public Void a(RequestSmsConfirmationCodeParams paramRequestSmsConfirmationCodeParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    return null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.RequestSmsConfirmationCodeMethod
 * JD-Core Version:    0.6.0
 */