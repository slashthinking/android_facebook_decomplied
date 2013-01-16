package com.facebook.orca.protocol.methods;

import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.server.UpdateFavoriteContactsParams;
import com.facebook.orca.users.User;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class UpdateMessagingFavoritesMethod
  implements ApiMethod<UpdateFavoriteContactsParams, Void>
{
  public ApiRequest a(UpdateFavoriteContactsParams paramUpdateFavoriteContactsParams)
  {
    ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
    Iterator localIterator = paramUpdateFavoriteContactsParams.a().iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      User localUser = (User)localIterator.next();
      j = i + 1;
      localObjectNode.put(Integer.toString(i), localUser.b());
    }
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    localArrayList.add(new BasicNameValuePair("favorites", localObjectNode.toString()));
    return new ApiRequest("updateMessagingFavorites", "POST", "/me/messagingfavorites", localArrayList, ApiResponseType.JSON);
  }

  public Void a(UpdateFavoriteContactsParams paramUpdateFavoriteContactsParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    return null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.UpdateMessagingFavoritesMethod
 * JD-Core Version:    0.6.0
 */