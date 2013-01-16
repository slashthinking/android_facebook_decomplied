package com.facebook.orca.protocol.methods;

import com.facebook.contacts.server.UsersInviteParams;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.users.User;
import com.facebook.orca.users.UserIdentifier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class UsersInviteMethod
  implements ApiMethod<UsersInviteParams, Void>
{
  private String a(String paramString)
  {
    return paramString.replaceAll("<", "").replaceAll(">", "").replaceAll(",", "");
  }

  public ApiRequest a(UsersInviteParams paramUsersInviteParams)
  {
    ArrayList localArrayList = Lists.a();
    ImmutableList localImmutableList = paramUsersInviteParams.a();
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator1 = localImmutableList.iterator();
    while (localIterator1.hasNext())
    {
      User localUser = (User)localIterator1.next();
      String str1 = a(localUser.g().toString());
      Iterator localIterator2 = localUser.u().iterator();
      while (localIterator2.hasNext())
      {
        String str2 = a(((UserIdentifier)localIterator2.next()).toString());
        localStringBuilder.append(str1).append(" <").append(str2).append(">,");
      }
    }
    localArrayList.add(new BasicNameValuePair("emails", localStringBuilder.toString()));
    localArrayList.add(new BasicNameValuePair("country_code", paramUsersInviteParams.b()));
    return new ApiRequest("usersInvite", "POST", "method/users.invite", localArrayList, ApiResponseType.STRING);
  }

  public Void a(UsersInviteParams paramUsersInviteParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    return null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.UsersInviteMethod
 * JD-Core Version:    0.6.0
 */