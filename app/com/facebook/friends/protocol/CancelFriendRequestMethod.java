package com.facebook.friends.protocol;

import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class CancelFriendRequestMethod
  implements ApiMethod<CancelFriendRequestMethod.Params, Void>
{
  public ApiRequest a(CancelFriendRequestMethod.Params paramParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("uid", String.valueOf(paramParams.a)));
    localArrayList.add(new BasicNameValuePair("format", "json"));
    return new ApiRequest("cancelFriendRequest", "POST", "method/facebook.friends.cancel.request", localArrayList, ApiResponseType.JSON);
  }

  public Void a(CancelFriendRequestMethod.Params paramParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    return null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.protocol.CancelFriendRequestMethod
 * JD-Core Version:    0.6.0
 */