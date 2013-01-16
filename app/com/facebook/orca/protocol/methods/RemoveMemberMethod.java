package com.facebook.orca.protocol.methods;

import com.facebook.orca.auth.MeUserAuthDataStore;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.server.RemoveMemberParams;
import com.facebook.orca.users.User;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class RemoveMemberMethod
  implements ApiMethod<RemoveMemberParams, Void>
{
  private final MeUserAuthDataStore a;

  public RemoveMemberMethod(MeUserAuthDataStore paramMeUserAuthDataStore)
  {
    this.a = paramMeUserAuthDataStore;
  }

  public ApiRequest a(RemoveMemberParams paramRemoveMemberParams)
  {
    if (!Objects.equal(paramRemoveMemberParams.b(), this.a.g().b()))
      throw new IllegalArgumentException("Can only unsubscribe the user");
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("id", paramRemoveMemberParams.a()));
    return new ApiRequest("removeMembers", "DELETE", "/participants", localArrayList, ApiResponseType.STRING);
  }

  public Void a(RemoveMemberParams paramRemoveMemberParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    return null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.RemoveMemberMethod
 * JD-Core Version:    0.6.0
 */