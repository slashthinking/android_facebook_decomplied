package com.facebook.friends.protocol;

import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class IgnoreFriendSuggestionMethod
  implements ApiMethod<IgnoreFriendSuggestionMethod.Params, Void>
{
  public ApiRequest a(IgnoreFriendSuggestionMethod.Params paramParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("uid", String.valueOf(paramParams.a)));
    localArrayList.add(new BasicNameValuePair("format", "json"));
    return new ApiRequest("ignoreFriendSuggestion", "POST", "method/facebook.friends.ignore.suggestion", localArrayList, ApiResponseType.JSON);
  }

  public Void a(IgnoreFriendSuggestionMethod.Params paramParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    return null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.protocol.IgnoreFriendSuggestionMethod
 * JD-Core Version:    0.6.0
 */