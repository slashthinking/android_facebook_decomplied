package com.facebook.notifications.protocol;

import com.facebook.common.util.Log;
import com.facebook.notifications.server.NotificationsChangeReadParams;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class NotificationsChangeReadMethod
  implements ApiMethod<NotificationsChangeReadParams, ImmutableSet<String>>
{
  public ApiRequest a(NotificationsChangeReadParams paramNotificationsChangeReadParams)
  {
    Preconditions.checkNotNull(paramNotificationsChangeReadParams);
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("notification_ids", Joiner.on(",").join(paramNotificationsChangeReadParams.a())));
    localArrayList.add(new BasicNameValuePair("format", "json"));
    return new ApiRequest("notificationsMarkAsRead", "GET", "method/notifications.markRead", localArrayList, ApiResponseType.JSON);
  }

  public ImmutableSet<String> a(NotificationsChangeReadParams paramNotificationsChangeReadParams, ApiResponse paramApiResponse)
  {
    Preconditions.checkNotNull(paramApiResponse);
    paramApiResponse.g();
    if ((paramApiResponse.c().asBoolean()) && (paramNotificationsChangeReadParams != null));
    for (ImmutableSet localImmutableSet = paramNotificationsChangeReadParams.a(); ; localImmutableSet = ImmutableSet.d())
    {
      return localImmutableSet;
      Log.a(NotificationsChangeReadMethod.class.getSimpleName(), "Did not change read state successfully");
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.protocol.NotificationsChangeReadMethod
 * JD-Core Version:    0.6.2
 */