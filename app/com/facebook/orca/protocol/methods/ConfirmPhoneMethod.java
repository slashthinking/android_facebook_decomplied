package com.facebook.orca.protocol.methods;

import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.server.ConfirmPhoneParams;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class ConfirmPhoneMethod
  implements ApiMethod<ConfirmPhoneParams, Void>
{
  public ApiRequest a(ConfirmPhoneParams paramConfirmPhoneParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    localArrayList.add(new BasicNameValuePair("code", paramConfirmPhoneParams.a()));
    if (paramConfirmPhoneParams.b());
    for (String str = "1"; ; str = "0")
    {
      localArrayList.add(new BasicNameValuePair("add_to_profile", str));
      localArrayList.add(new BasicNameValuePair("source", "Orca Android"));
      return new ApiRequest("requestSmsConfirmationCode", "POST", "method/user.confirmPhone", localArrayList, ApiResponseType.STRING);
    }
  }

  public Void a(ConfirmPhoneParams paramConfirmPhoneParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    return null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.ConfirmPhoneMethod
 * JD-Core Version:    0.6.0
 */