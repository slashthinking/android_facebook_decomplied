package com.facebook.orca.protocol.methods;

import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.server.AddMembersParams;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class AddMembersMethod
  implements ApiMethod<AddMembersParams, Void>
{
  private final PickedUserUtils a;

  public AddMembersMethod(PickedUserUtils paramPickedUserUtils)
  {
    this.a = paramPickedUserUtils;
  }

  public ApiRequest a(AddMembersParams paramAddMembersParams)
  {
    ArrayList localArrayList = Lists.a();
    JsonNode localJsonNode = this.a.a(paramAddMembersParams.b());
    localArrayList.add(new BasicNameValuePair("id", paramAddMembersParams.a()));
    localArrayList.add(new BasicNameValuePair("to", localJsonNode.toString()));
    return new ApiRequest("addMembers", "POST", "/participants", localArrayList, ApiResponseType.STRING);
  }

  public Void a(AddMembersParams paramAddMembersParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    return null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.AddMembersMethod
 * JD-Core Version:    0.6.0
 */