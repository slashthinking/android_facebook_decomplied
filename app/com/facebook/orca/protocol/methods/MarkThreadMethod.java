package com.facebook.orca.protocol.methods;

import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.server.MarkThreadParams;
import com.facebook.orca.server.MarkThreadParams.Mark;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class MarkThreadMethod
  implements ApiMethod<MarkThreadParams, Void>
{
  public ApiRequest a(MarkThreadParams paramMarkThreadParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("id", paramMarkThreadParams.a()));
    localArrayList.add(new BasicNameValuePair("name", paramMarkThreadParams.b().getApiName()));
    if (paramMarkThreadParams.c());
    for (String str = "1"; ; str = "0")
    {
      localArrayList.add(new BasicNameValuePair("state", str));
      localArrayList.add(new BasicNameValuePair("action_id", String.valueOf(paramMarkThreadParams.d())));
      localArrayList.add(new BasicNameValuePair("format", "json"));
      return new ApiRequest("markThread", "POST", "tags", localArrayList, ApiResponseType.STRING);
    }
  }

  public Void a(MarkThreadParams paramMarkThreadParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    return null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.MarkThreadMethod
 * JD-Core Version:    0.6.0
 */