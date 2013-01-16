package com.facebook.orca.protocol.methods;

import com.facebook.orca.notify.NotificationSetting;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.server.ModifyThreadParams;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class SetThreadMuteUntilMethod
  implements ApiMethod<ModifyThreadParams, Void>
{
  private String b(ModifyThreadParams paramModifyThreadParams)
  {
    return Long.toString(paramModifyThreadParams.g().d());
  }

  public ApiRequest a(ModifyThreadParams paramModifyThreadParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    localArrayList.add(new BasicNameValuePair("tid", paramModifyThreadParams.a()));
    localArrayList.add(new BasicNameValuePair("mute_until", b(paramModifyThreadParams)));
    return new ApiRequest("muteThread", "POST", "method/messaging.mutethread", localArrayList, ApiResponseType.STRING);
  }

  public Void a(ModifyThreadParams paramModifyThreadParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    return null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.SetThreadMuteUntilMethod
 * JD-Core Version:    0.6.0
 */