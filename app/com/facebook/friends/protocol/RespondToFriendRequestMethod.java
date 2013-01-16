package com.facebook.friends.protocol;

import com.facebook.friends.FriendRequestResponse;
import com.facebook.friends.FriendRequestResponseRef;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class RespondToFriendRequestMethod
  implements ApiMethod<RespondToFriendRequestMethod.Params, Void>
{
  public ApiRequest a(RespondToFriendRequestMethod.Params paramParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("uid", String.valueOf(paramParams.c)));
    localArrayList.add(new BasicNameValuePair("confirm", paramParams.a.value));
    localArrayList.add(new BasicNameValuePair("ref", paramParams.b.value));
    localArrayList.add(new BasicNameValuePair("format", "json"));
    return new ApiRequest("respondToFriendRequest", "POST", "method/facebook.friends.confirm", localArrayList, ApiResponseType.JSON);
  }

  public Void a(RespondToFriendRequestMethod.Params paramParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    return null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.protocol.RespondToFriendRequestMethod
 * JD-Core Version:    0.6.0
 */