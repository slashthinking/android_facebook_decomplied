package com.facebook.orca.protocol.methods;

import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.server.DeleteThreadParams;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class DeleteThreadMethod
  implements ApiMethod<DeleteThreadParams, Void>
{
  public ApiRequest a(DeleteThreadParams paramDeleteThreadParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("id", paramDeleteThreadParams.a()));
    localArrayList.add(new BasicNameValuePair("format", "json"));
    return new ApiRequest("deleteThread", "DELETE", "", localArrayList, ApiResponseType.STRING);
  }

  public Void a(DeleteThreadParams paramDeleteThreadParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    return null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.DeleteThreadMethod
 * JD-Core Version:    0.6.0
 */