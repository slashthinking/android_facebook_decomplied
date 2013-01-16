package com.facebook.orca.protocol.methods;

import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class PushTraceInfoConfirmationMethod
  implements ApiMethod<String, Void>
{
  public ApiRequest a(String paramString)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    localArrayList.add(new BasicNameValuePair("event_info", "device_received"));
    localArrayList.add(new BasicNameValuePair("event_time", String.valueOf(System.currentTimeMillis())));
    localArrayList.add(new BasicNameValuePair("trace_info", paramString));
    return new ApiRequest("pushTraceInfoConfirmation", "POST", "method/user.tracePush", localArrayList, ApiResponseType.STRING);
  }

  public Void a(String paramString, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    return null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.PushTraceInfoConfirmationMethod
 * JD-Core Version:    0.6.0
 */