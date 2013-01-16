package com.facebook.orca.protocol.methods;

import com.facebook.orca.notify.NotificationSetting;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.server.SetSettingsParams;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class SetUserSettingsMethod
  implements ApiMethod<SetSettingsParams, Void>
{
  private String b(SetSettingsParams paramSetSettingsParams)
  {
    return Long.toString(paramSetSettingsParams.b().d());
  }

  public ApiRequest a(SetSettingsParams paramSetSettingsParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    if (paramSetSettingsParams.a())
      localArrayList.add(new BasicNameValuePair("mute_until", b(paramSetSettingsParams)));
    return new ApiRequest("setUserSettings", "POST", "method/messaging.setsettings", localArrayList, ApiResponseType.STRING);
  }

  public Void a(SetSettingsParams paramSetSettingsParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    return null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.SetUserSettingsMethod
 * JD-Core Version:    0.6.0
 */