package com.facebook.contacts.protocol;

import com.facebook.contacts.server.DeleteContactClaimParams;
import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class DeleteContactClaimMethod
  implements ApiMethod<DeleteContactClaimParams, Boolean>
{
  public ApiRequest a(DeleteContactClaimParams paramDeleteContactClaimParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("contact_id", paramDeleteContactClaimParams.b()));
    localArrayList.add(new BasicNameValuePair("field_type", "PHONE"));
    return new ApiRequest("deleteContactClaim", "DELETE", paramDeleteContactClaimParams.a(), localArrayList, ApiResponseType.JSON);
  }

  public Boolean a(DeleteContactClaimParams paramDeleteContactClaimParams, ApiResponse paramApiResponse)
  {
    return Boolean.valueOf(JSONUtil.f(paramApiResponse.c()));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.protocol.DeleteContactClaimMethod
 * JD-Core Version:    0.6.0
 */