package com.facebook.orca.protocol.methods;

import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.FetchMessagingFavoritesResult;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class FetchMessagingFavoritesMethod
  implements ApiMethod<Void, FetchMessagingFavoritesResult>
{
  private String a()
  {
    return "SELECT favorite_id, ordering FROM messaging_favorite WHERE uid=me() ORDER BY ordering ASC";
  }

  public ApiRequest a(Void paramVoid)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    localArrayList.add(new BasicNameValuePair("query", a()));
    return new ApiRequest("fetchMessagingFavorites", "GET", "method/fql.query", localArrayList, ApiResponseType.JSON);
  }

  public FetchMessagingFavoritesResult a(Void paramVoid, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    ArrayNode localArrayNode = (ArrayNode)paramApiResponse.c();
    ImmutableList.Builder localBuilder = ImmutableList.e();
    for (int i = 0; i < localArrayNode.size(); i++)
    {
      JsonNode localJsonNode = localArrayNode.get(i);
      UserBuilder localUserBuilder = new UserBuilder();
      localUserBuilder.a(User.Type.FACEBOOK, JSONUtil.b(localJsonNode.get("favorite_id")));
      localBuilder.b(localUserBuilder.w());
    }
    return new FetchMessagingFavoritesResult(DataFreshnessResult.FROM_SERVER, localBuilder.b(), System.currentTimeMillis());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.FetchMessagingFavoritesMethod
 * JD-Core Version:    0.6.0
 */