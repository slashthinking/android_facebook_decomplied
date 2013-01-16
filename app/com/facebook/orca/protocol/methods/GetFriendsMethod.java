package com.facebook.orca.protocol.methods;

import android.util.Pair;
import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.GetFriendsParams;
import com.facebook.orca.server.GetFriendsResult;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserSerialization;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class GetFriendsMethod
  implements ApiMethod<GetFriendsParams, GetFriendsResult>
{
  private static final Class<?> a = GetFriendsMethod.class;
  private final UserFqlHelper b;
  private final UserSerialization c;

  public GetFriendsMethod(UserFqlHelper paramUserFqlHelper, UserSerialization paramUserSerialization)
  {
    this.b = paramUserFqlHelper;
    this.c = paramUserSerialization;
  }

  private void a(GetFriendsParams paramGetFriendsParams, FqlMultiQueryHelper paramFqlMultiQueryHelper)
  {
    Pair localPair = b(paramGetFriendsParams);
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = localPair.first;
    arrayOfObject[1] = localPair.second;
    paramFqlMultiQueryHelper.a("friends", StringLocaleUtil.a("SELECT uid2, communication_rank FROM friend WHERE uid1=me() ORDER BY communication_rank DESC LIMIT %1$d,%2$s", arrayOfObject));
  }

  private Pair<Integer, Integer> b(GetFriendsParams paramGetFriendsParams)
  {
    String str = paramGetFriendsParams.b();
    int i;
    if (str == null)
      i = 0;
    for (int j = paramGetFriendsParams.a(); ; j = paramGetFriendsParams.a())
    {
      return Pair.create(Integer.valueOf(i), Integer.valueOf(j));
      i = Integer.parseInt(str);
    }
  }

  private void b(GetFriendsParams paramGetFriendsParams, FqlMultiQueryHelper paramFqlMultiQueryHelper)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Long.valueOf(paramGetFriendsParams.d() / 1000L);
    paramFqlMultiQueryHelper.a("friends_sync", String.format("SELECT uid2, is_removed FROM friend_sync where uid1=me() AND update_time >= %1$d", arrayOfObject));
    paramFqlMultiQueryHelper.a("friends", "SELECT uid2, communication_rank FROM friend WHERE uid1=me() AND uid2 IN (SELECT uid2 FROM #friends_sync)");
  }

  public ApiRequest a(GetFriendsParams paramGetFriendsParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    FqlMultiQueryHelper localFqlMultiQueryHelper = new FqlMultiQueryHelper();
    if (paramGetFriendsParams.c())
      b(paramGetFriendsParams, localFqlMultiQueryHelper);
    while (true)
    {
      localFqlMultiQueryHelper.a("users", "SELECT uid, first_name, last_name, name, contact_email, phones, is_pushable, birthday_date FROM user WHERE uid IN (SELECT uid2 FROM #friends)");
      localFqlMultiQueryHelper.a("profiles", "SELECT id, name, type, pic_big, pic_square, pic_crop FROM profile WHERE id IN (SELECT uid2 FROM #friends)");
      localArrayList.add(new BasicNameValuePair("queries", localFqlMultiQueryHelper.a().toString()));
      return new ApiRequest("getFriends", "GET", "method/fql.multiquery", localArrayList, ApiResponseType.JSON);
      a(paramGetFriendsParams, localFqlMultiQueryHelper);
    }
  }

  public GetFriendsResult a(GetFriendsParams paramGetFriendsParams, ApiResponse paramApiResponse)
  {
    FqlResultHelper localFqlResultHelper = new FqlResultHelper(paramApiResponse.c());
    JsonNode localJsonNode1 = localFqlResultHelper.a("friends");
    JsonNode localJsonNode2 = localFqlResultHelper.a("users");
    JsonNode localJsonNode3 = localFqlResultHelper.a("profiles");
    if ((localJsonNode2 == null) || (localJsonNode3 == null) || (localJsonNode1 == null))
      throw new Exception("Invalid api response - missing friends");
    JsonNode localJsonNode4 = this.b.a(localJsonNode2, localJsonNode3, localJsonNode1);
    ImmutableList localImmutableList1 = this.c.a(User.Type.FACEBOOK, localJsonNode4);
    ImmutableList localImmutableList2;
    Object localObject;
    if (paramGetFriendsParams.c())
    {
      ImmutableList.Builder localBuilder = ImmutableList.e();
      Iterator localIterator = localFqlResultHelper.a("friends_sync").iterator();
      while (localIterator.hasNext())
      {
        JsonNode localJsonNode5 = (JsonNode)localIterator.next();
        if (!localJsonNode5.get("is_removed").booleanValue())
          continue;
        localBuilder.b(JSONUtil.b(localJsonNode5.get("uid2")));
      }
      localImmutableList2 = localBuilder.b();
      localObject = null;
      return new GetFriendsResult(DataFreshnessResult.FROM_SERVER, localImmutableList1, paramGetFriendsParams.c(), localImmutableList2, (String)localObject, System.currentTimeMillis());
    }
    Pair localPair;
    if (localJsonNode1.size() != 0)
      localPair = b(paramGetFriendsParams);
    for (String str = Integer.toString(((Integer)localPair.first).intValue() + ((Integer)localPair.second).intValue()); ; str = null)
    {
      localImmutableList2 = ImmutableList.d();
      localObject = str;
      break;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.GetFriendsMethod
 * JD-Core Version:    0.6.0
 */