package com.facebook.megaphone.api;

import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class LogMegaphoneMethod
  implements ApiMethod<LogMegaphoneParams, Void>
{
  public ApiRequest a(LogMegaphoneParams paramLogMegaphoneParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramLogMegaphoneParams.a;
    String str = StringUtil.a("", arrayOfObject);
    localArrayList.add(new BasicNameValuePair("log_event", paramLogMegaphoneParams.b.toString()));
    return new ApiRequest("graphObjectLike", "POST", str, localArrayList, ApiResponseType.JSON);
  }

  public Void a(LogMegaphoneParams paramLogMegaphoneParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    return null;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.megaphone.api.LogMegaphoneMethod
 * JD-Core Version:    0.6.2
 */