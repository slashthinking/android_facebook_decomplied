package com.facebook.friends.protocol;

import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class RemoveFriendListMemberMethod
  implements ApiMethod<RemoveFriendListMemberMethod.Params, Void>
{
  public ApiRequest a(RemoveFriendListMemberMethod.Params paramParams)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Long.valueOf(paramParams.a);
    arrayOfObject[1] = Long.valueOf(paramParams.b);
    String str = StringUtil.a("%s/members/%s", arrayOfObject);
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    return new ApiRequest("removeFriendListMember", "DELETE", str, localArrayList, ApiResponseType.JSON);
  }

  public Void a(RemoveFriendListMemberMethod.Params paramParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    return null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.protocol.RemoveFriendListMemberMethod
 * JD-Core Version:    0.6.0
 */