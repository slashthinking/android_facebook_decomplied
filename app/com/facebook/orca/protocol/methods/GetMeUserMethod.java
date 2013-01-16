package com.facebook.orca.protocol.methods;

import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.GetMeUserResult;
import com.facebook.orca.users.User;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserSerialization;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class GetMeUserMethod
  implements ApiMethod<Void, GetMeUserResult>
{
  private final UserFqlHelper a;
  private final UserSerialization b;

  public GetMeUserMethod(UserFqlHelper paramUserFqlHelper, UserSerialization paramUserSerialization)
  {
    this.a = paramUserFqlHelper;
    this.b = paramUserSerialization;
  }

  private String a()
  {
    FqlMultiQueryHelper localFqlMultiQueryHelper = new FqlMultiQueryHelper();
    localFqlMultiQueryHelper.a("user", "SELECT uid, first_name, last_name, contact_email, phones, is_pushable, affiliations FROM user WHERE uid=me()");
    localFqlMultiQueryHelper.a("profile", "SELECT id, name, type, pic_big, pic_square, pic_crop FROM profile WHERE id=me()");
    return localFqlMultiQueryHelper.a().toString();
  }

  public ApiRequest a(Void paramVoid)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    localArrayList.add(new BasicNameValuePair("queries", a()));
    return new ApiRequest("meUser", "GET", "method/fql.multiquery", localArrayList, ApiResponseType.JSON);
  }

  public GetMeUserResult a(Void paramVoid, ApiResponse paramApiResponse)
  {
    FqlResultHelper localFqlResultHelper = new FqlResultHelper(paramApiResponse.c());
    JsonNode localJsonNode1 = localFqlResultHelper.a("user");
    JsonNode localJsonNode2 = localFqlResultHelper.a("profile");
    JsonNode localJsonNode3 = this.a.a(localJsonNode1, localJsonNode2);
    ImmutableList localImmutableList = this.b.a(User.Type.FACEBOOK, localJsonNode3);
    if (localImmutableList.size() != 1)
      throw new Exception("Invalid api response - multiple result users");
    User localUser = (User)localImmutableList.get(0);
    return new GetMeUserResult(DataFreshnessResult.FROM_SERVER, localUser, System.currentTimeMillis());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.GetMeUserMethod
 * JD-Core Version:    0.6.0
 */