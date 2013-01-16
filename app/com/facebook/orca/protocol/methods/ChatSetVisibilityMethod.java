package com.facebook.orca.protocol.methods;

import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class ChatSetVisibilityMethod
  implements ApiMethod<Boolean, Boolean>
{
  public ApiRequest a(Boolean paramBoolean)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    if (paramBoolean.booleanValue());
    for (String str = "1"; ; str = "0")
    {
      localArrayList.add(new BasicNameValuePair("visible", str));
      return new ApiRequest("chatSetVisibility", "POST", "method/chat.setVisibility", localArrayList, ApiResponseType.STRING);
    }
  }

  public Boolean a(Boolean paramBoolean, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    return paramBoolean;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.ChatSetVisibilityMethod
 * JD-Core Version:    0.6.0
 */