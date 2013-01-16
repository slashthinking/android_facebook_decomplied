package com.facebook.contacts.protocol;

import com.facebook.contacts.server.CreateContactClaimParams;
import com.facebook.contacts.server.PrivacyParam;
import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class CreateContactClaimMethod
  implements ApiMethod<CreateContactClaimParams, String>
{
  public ApiRequest a(CreateContactClaimParams paramCreateContactClaimParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("field", paramCreateContactClaimParams.c()));
    localArrayList.add(new BasicNameValuePair("privacy", paramCreateContactClaimParams.d().a()));
    return new ApiRequest("createContactClaim", "POST", paramCreateContactClaimParams.b() + "/contactfields", localArrayList, ApiResponseType.JSON);
  }

  public String a(CreateContactClaimParams paramCreateContactClaimParams, ApiResponse paramApiResponse)
  {
    return JSONUtil.b(paramApiResponse.c().get("id"));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.protocol.CreateContactClaimMethod
 * JD-Core Version:    0.6.0
 */