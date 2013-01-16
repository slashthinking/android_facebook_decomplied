package com.facebook.katana.server.protocol;

import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.http.message.BasicNameValuePair;

public class GetPermissionsDescriptionMethod
  implements ApiMethod<GetPermissionsDescriptionMethod.Params, String>
{
  public ApiRequest a(GetPermissionsDescriptionMethod.Params paramParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    localArrayList.add(new BasicNameValuePair("permissions", paramParams.a()));
    if (paramParams.b().isPresent())
    {
      ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
      localObjectNode.put("value", (String)paramParams.b().get());
      localArrayList.add(new BasicNameValuePair("write_privacy", localObjectNode.toString()));
    }
    if (paramParams.c().isPresent())
      localArrayList.add(new BasicNameValuePair("locale", ((Locale)paramParams.c().get()).toString()));
    return new ApiRequest("get_permissions_description_method", "GET", "method/permissions.getandroiddescription", localArrayList, ApiResponseType.STRING);
  }

  public String a(GetPermissionsDescriptionMethod.Params paramParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    return paramApiResponse.b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.server.protocol.GetPermissionsDescriptionMethod
 * JD-Core Version:    0.6.0
 */