package com.facebook.orca.protocol.methods;

import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.FetchLastActiveParams;
import com.facebook.orca.server.FetchLastActiveParams.FriendGroup;
import com.facebook.orca.server.FetchLastActiveResult;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserSerialization;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class FetchLastActiveMethod
  implements ApiMethod<FetchLastActiveParams, FetchLastActiveResult>
{
  private final UserSerialization a;

  public FetchLastActiveMethod(UserSerialization paramUserSerialization)
  {
    this.a = paramUserSerialization;
  }

  private String b(FetchLastActiveParams paramFetchLastActiveParams)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT uid, last_active FROM user WHERE ");
    if (paramFetchLastActiveParams.b().contains(FetchLastActiveParams.FriendGroup.ALL))
    {
      localStringBuilder.append("uid in (SELECT uid2 FROM friend WHERE uid1=me())");
      return localStringBuilder.toString();
    }
    Iterator localIterator = paramFetchLastActiveParams.b().iterator();
    int i = 0;
    label52: FetchLastActiveParams.FriendGroup localFriendGroup;
    if (localIterator.hasNext())
    {
      localFriendGroup = (FetchLastActiveParams.FriendGroup)localIterator.next();
      if (i > 0)
        localStringBuilder.append(" or ");
      if (!localFriendGroup.equals(FetchLastActiveParams.FriendGroup.TOP_FRIENDS))
        break label132;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramFetchLastActiveParams.c());
      localStringBuilder.append(StringLocaleUtil.a("uid in (SELECT uid2 FROM  friend WHERE uid1=me() order by communication_rank desc LIMIT %d)", arrayOfObject));
    }
    while (true)
    {
      i++;
      break label52;
      break;
      label132: if (!localFriendGroup.equals(FetchLastActiveParams.FriendGroup.FAVORITE_FRIENDS))
        continue;
      localStringBuilder.append("uid in (SELECT favorite_id FROM messaging_favorite WHERE uid=me())");
    }
  }

  public ApiRequest a(FetchLastActiveParams paramFetchLastActiveParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    localArrayList.add(new BasicNameValuePair("query", b(paramFetchLastActiveParams)));
    return new ApiRequest("fetchLastActiveMethod", "GET", "method/fql.query", localArrayList, ApiResponseType.JSON);
  }

  public FetchLastActiveResult a(FetchLastActiveParams paramFetchLastActiveParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    ArrayNode localArrayNode = (ArrayNode)paramApiResponse.c();
    ImmutableList localImmutableList = this.a.a(User.Type.FACEBOOK, localArrayNode);
    return new FetchLastActiveResult(DataFreshnessResult.FROM_SERVER, localImmutableList, System.currentTimeMillis());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.FetchLastActiveMethod
 * JD-Core Version:    0.6.0
 */