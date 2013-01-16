package com.facebook.notifications.protocol;

import com.facebook.common.json.FBJsonFactory;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.notifications.model.FacebookNotification;
import com.facebook.notifications.server.FetchNotificationsParams;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.protocol.methods.FqlMultiQueryHelper;
import com.facebook.orca.protocol.methods.FqlResultHelper;
import com.facebook.orca.server.DataFreshnessResult;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class FetchNotificationsMethod
  implements ApiMethod<FetchNotificationsParams, FetchNotificationsResult>
{
  public FetchNotificationsResult a(FetchNotificationsParams paramFetchNotificationsParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    FqlResultHelper localFqlResultHelper = new FqlResultHelper(paramApiResponse.c());
    JsonNode localJsonNode1 = localFqlResultHelper.a("notifications");
    JsonNode localJsonNode2 = localFqlResultHelper.a("profiles");
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator1 = localJsonNode1.iterator();
    while (localIterator1.hasNext())
    {
      JsonNode localJsonNode4 = (JsonNode)localIterator1.next();
      localBuilder.b(FacebookNotification.a(FBJsonFactory.a.createJsonParser(localJsonNode4.toString())));
    }
    ImmutableMap.Builder localBuilder1 = ImmutableMap.k();
    Iterator localIterator2 = localJsonNode2.iterator();
    while (localIterator2.hasNext())
    {
      JsonNode localJsonNode3 = (JsonNode)localIterator2.next();
      FacebookProfile localFacebookProfile = FacebookProfile.a(FBJsonFactory.a.createJsonParser(localJsonNode3.toString()));
      localBuilder1.b(Long.valueOf(localFacebookProfile.mId), localFacebookProfile);
    }
    return new FetchNotificationsResult(DataFreshnessResult.FROM_SERVER, localBuilder.b(), localBuilder1.b(), System.currentTimeMillis());
  }

  public ApiRequest a(FetchNotificationsParams paramFetchNotificationsParams)
  {
    FqlMultiQueryHelper localFqlMultiQueryHelper = new FqlMultiQueryHelper();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramFetchNotificationsParams.b();
    arrayOfObject[1] = Integer.valueOf(30);
    localFqlMultiQueryHelper.a("notifications", StringUtil.a("SELECT notification_id, sender_id, updated_time, title_text, is_unread, object_id, object_type, icon_url, join_data, mobile_href FROM notification WHERE recipient_id=%s AND is_hidden=0 AND is_mobile_ready ORDER BY created_time DESC LIMIT %d", arrayOfObject));
    localFqlMultiQueryHelper.a("profiles", "SELECT id, name, pic_square, type FROM profile WHERE id IN (SELECT sender_id FROM #notifications)");
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    localArrayList.add(new BasicNameValuePair("queries", localFqlMultiQueryHelper.a().toString()));
    return new ApiRequest("fetchNotifications", "GET", "method/fql.multiquery", localArrayList, ApiResponseType.JSON);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.protocol.FetchNotificationsMethod
 * JD-Core Version:    0.6.2
 */