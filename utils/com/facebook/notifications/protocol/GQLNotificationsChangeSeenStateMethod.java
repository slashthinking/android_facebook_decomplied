package com.facebook.notifications.protocol;

import com.facebook.graphql.model.FeedStory.SeenState;
import com.facebook.notifications.server.GQLNotificationsChangeSeenStateParams;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class GQLNotificationsChangeSeenStateMethod
  implements ApiMethod<GQLNotificationsChangeSeenStateParams, GQLNotificationsChangeSeenStateMethod.GQLNotificationsChangeSeenStateMethodResult>
{
  public GQLNotificationsChangeSeenStateMethod.GQLNotificationsChangeSeenStateMethodResult a(GQLNotificationsChangeSeenStateParams paramGQLNotificationsChangeSeenStateParams, ApiResponse paramApiResponse)
  {
    Preconditions.checkNotNull(paramApiResponse);
    Preconditions.checkNotNull(paramGQLNotificationsChangeSeenStateParams);
    paramApiResponse.g();
    return new GQLNotificationsChangeSeenStateMethod.GQLNotificationsChangeSeenStateMethodResult(Boolean.valueOf(paramApiResponse.c().asBoolean()), paramGQLNotificationsChangeSeenStateParams);
  }

  public ApiRequest a(GQLNotificationsChangeSeenStateParams paramGQLNotificationsChangeSeenStateParams)
  {
    Preconditions.checkNotNull(paramGQLNotificationsChangeSeenStateParams);
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("notif_ids", Joiner.on(",").join(paramGQLNotificationsChangeSeenStateParams.a())));
    localArrayList.add(new BasicNameValuePair(paramGQLNotificationsChangeSeenStateParams.b().toGQLString(), "true"));
    localArrayList.add(new BasicNameValuePair("format", "json"));
    return new ApiRequest("gqlNotificationsUpdateSeenState", "POST", "me/notifications", localArrayList, ApiResponseType.JSON);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.protocol.GQLNotificationsChangeSeenStateMethod
 * JD-Core Version:    0.6.2
 */