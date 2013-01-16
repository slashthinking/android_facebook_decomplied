package com.facebook.katana.server.protocol;

import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class UserSetContactInfoMethod
  implements ApiMethod<UserSetContactInfoMethod.Params, Boolean>
{
  public ApiRequest a(UserSetContactInfoMethod.Params paramParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("cell", paramParams.a));
    if (paramParams.b);
    for (String str = "true"; ; str = "false")
    {
      localArrayList.add(new BasicNameValuePair("quiet", str));
      localArrayList.add(new BasicNameValuePair("format", "JSON"));
      return new ApiRequest("uset_set_contact_info", "POST", "method/user.setContactInfo", localArrayList, ApiResponseType.JSON);
    }
  }

  public Boolean a(UserSetContactInfoMethod.Params paramParams, ApiResponse paramApiResponse)
  {
    JsonNode localJsonNode = paramApiResponse.c();
    if (!localJsonNode.isBoolean())
      throw new Exception("Invalid response: boolean expected");
    return Boolean.valueOf(localJsonNode.asBoolean());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.server.protocol.UserSetContactInfoMethod
 * JD-Core Version:    0.6.0
 */