package com.facebook.orca.protocol.methods;

import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.users.User;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class LookupUserMethod
  implements ApiMethod<String, User>
{
  public ApiRequest a(String paramString)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("fields", "name,picture"));
    return new ApiRequest("lookupUser", "GET", paramString, localArrayList, ApiResponseType.JSON);
  }

  public User a(String paramString, ApiResponse paramApiResponse)
  {
    JsonNode localJsonNode = paramApiResponse.c();
    if (!localJsonNode.has("name"))
      throw new IOException("Expected response body to contain a name field.");
    UserBuilder localUserBuilder = new UserBuilder();
    localUserBuilder.a(User.Type.FACEBOOK, paramString);
    localUserBuilder.a(localJsonNode.get("name").asText());
    localUserBuilder.d(localJsonNode.get("picture").get("data").get("url").asText());
    return localUserBuilder.w();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.LookupUserMethod
 * JD-Core Version:    0.6.0
 */