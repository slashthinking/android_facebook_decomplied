package com.facebook.katana.service.autoupdate;

import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.katana.model.FacebookApp;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.google.common.collect.ImmutableList;

public class AppApiMethod
  implements ApiMethod<Void, FacebookApp>
{
  public FacebookApp a(Void paramVoid, ApiResponse paramApiResponse)
  {
    return (FacebookApp)JMParser.a(paramApiResponse.d(), FacebookApp.class);
  }

  public ApiRequest a(Void paramVoid)
  {
    return new ApiRequest("app", "GET", "app", ImmutableList.d(), ApiResponseType.JSONPARSER);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.autoupdate.AppApiMethod
 * JD-Core Version:    0.6.0
 */