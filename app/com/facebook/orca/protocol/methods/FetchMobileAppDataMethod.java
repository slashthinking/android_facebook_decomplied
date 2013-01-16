package com.facebook.orca.protocol.methods;

import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.FetchMobileAppDataResult;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserSerialization;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class FetchMobileAppDataMethod
  implements ApiMethod<Integer, FetchMobileAppDataResult>
{
  private final UserSerialization a;

  public FetchMobileAppDataMethod(UserSerialization paramUserSerialization)
  {
    this.a = paramUserSerialization;
  }

  private String b(Integer paramInteger)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT uid, mobile_app_data FROM user WHERE ");
    localStringBuilder.append(StringLocaleUtil.a("uid in (SELECT uid2 FROM  friend WHERE uid1=me() order by communication_rank desc LIMIT %d)", new Object[] { paramInteger }));
    return localStringBuilder.toString();
  }

  public ApiRequest a(Integer paramInteger)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    localArrayList.add(new BasicNameValuePair("query", b(paramInteger)));
    return new ApiRequest("fetchMobileAppDataMethod", "GET", "method/fql.query", localArrayList, ApiResponseType.JSON);
  }

  public FetchMobileAppDataResult a(Integer paramInteger, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    ArrayNode localArrayNode = (ArrayNode)paramApiResponse.c();
    ImmutableList localImmutableList = this.a.a(User.Type.FACEBOOK, localArrayNode);
    return new FetchMobileAppDataResult(DataFreshnessResult.FROM_SERVER, localImmutableList, System.currentTimeMillis());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.FetchMobileAppDataMethod
 * JD-Core Version:    0.6.0
 */