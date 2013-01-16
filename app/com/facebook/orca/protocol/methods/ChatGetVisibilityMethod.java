package com.facebook.orca.protocol.methods;

import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class ChatGetVisibilityMethod
  implements ApiMethod<Void, Boolean>
{
  public ApiRequest a(Void paramVoid)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    return new ApiRequest("chatGetVisibility", "POST", "method/chat.getVisibility", localArrayList, ApiResponseType.STRING);
  }

  public Boolean a(Void paramVoid, ApiResponse paramApiResponse)
  {
    return Boolean.valueOf("true".equals(paramApiResponse.b()));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.ChatGetVisibilityMethod
 * JD-Core Version:    0.6.0
 */