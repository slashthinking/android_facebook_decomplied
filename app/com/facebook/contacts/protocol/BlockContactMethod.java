package com.facebook.contacts.protocol;

import com.facebook.contacts.server.BlockContactParams;
import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.users.UserKey;
import com.google.common.collect.Lists;
import java.util.ArrayList;

public class BlockContactMethod
  implements ApiMethod<BlockContactParams, Boolean>
{
  public ApiRequest a(BlockContactParams paramBlockContactParams)
  {
    ArrayList localArrayList = Lists.a();
    String str = paramBlockContactParams.a().b();
    return new ApiRequest("blockContact", "POST", "me/blocked/" + str, localArrayList, ApiResponseType.JSON);
  }

  public Boolean a(BlockContactParams paramBlockContactParams, ApiResponse paramApiResponse)
  {
    return Boolean.valueOf(JSONUtil.f(paramApiResponse.c()));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.protocol.BlockContactMethod
 * JD-Core Version:    0.6.0
 */