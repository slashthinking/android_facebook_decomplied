package com.facebook.orca.protocol.methods;

import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.users.Name;
import com.facebook.orca.users.User;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class SearchUsersMethod
  implements ApiMethod<String, List<User>>
{
  public ApiRequest a(String paramString)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    localArrayList.add(new BasicNameValuePair("context", "messenger_composer"));
    localArrayList.add(new BasicNameValuePair("query", paramString));
    localArrayList.add(new BasicNameValuePair("limit", "20"));
    return new ApiRequest("searchUsersMethod", "GET", "method/ubersearch.get", localArrayList, ApiResponseType.JSON);
  }

  public List<User> a(String paramString, ApiResponse paramApiResponse)
  {
    ArrayList localArrayList = Lists.a();
    JsonNode localJsonNode1 = paramApiResponse.c();
    for (int i = 0; i < localJsonNode1.size(); i++)
    {
      JsonNode localJsonNode2 = localJsonNode1.get(i);
      if (!"user".equals(JSONUtil.b(localJsonNode2.get("type"))))
        continue;
      String str1 = JSONUtil.b(localJsonNode2.get("text"));
      String str2 = JSONUtil.b(localJsonNode2.get("uid"));
      String str3 = JSONUtil.b(localJsonNode2.get("photo"));
      String str4 = JSONUtil.b(localJsonNode2.get("subtext"));
      String str5 = JSONUtil.b(localJsonNode2.get("category"));
      localArrayList.add(new UserBuilder().a(User.Type.FACEBOOK, str2).a(new Name(null, null, str1)).d(str3).f(str4).g(str5).w());
    }
    return localArrayList;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.SearchUsersMethod
 * JD-Core Version:    0.6.0
 */