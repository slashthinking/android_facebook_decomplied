package com.facebook.friends.protocol;

import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class BlockUserMethod
  implements ApiMethod<BlockUserMethod.Params, Void>
{
  public ApiRequest a(BlockUserMethod.Params paramParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    localArrayList.add(new BasicNameValuePair("uid", String.valueOf(paramParams.a)));
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Long.valueOf(paramParams.b);
    return new ApiRequest("blockUser", "POST", StringLocaleUtil.a("%d/blocked", arrayOfObject), localArrayList, ApiResponseType.JSON);
  }

  public Void a(BlockUserMethod.Params paramParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    return null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.protocol.BlockUserMethod
 * JD-Core Version:    0.6.0
 */