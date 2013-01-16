package com.facebook.notifications.protocol;

import com.facebook.common.json.FBJsonFactory;
import com.facebook.notifications.model.FacebookNotificationSetting;
import com.facebook.notifications.server.GetNotificationsSettingsParams;
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
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class GetNotificationsSettingsMethod
  implements ApiMethod<GetNotificationsSettingsParams, GetNotificationsSettingsResult>
{
  public GetNotificationsSettingsResult a(GetNotificationsSettingsParams paramGetNotificationsSettingsParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    JsonNode localJsonNode1 = new FqlResultHelper(paramApiResponse.c()).a("notificationssettings");
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator = localJsonNode1.iterator();
    while (localIterator.hasNext())
    {
      JsonNode localJsonNode2 = (JsonNode)localIterator.next();
      localBuilder.b(FacebookNotificationSetting.a(FBJsonFactory.a.createJsonParser(localJsonNode2.toString())));
    }
    return new GetNotificationsSettingsResult(DataFreshnessResult.FROM_SERVER, localBuilder.b(), System.currentTimeMillis());
  }

  public ApiRequest a(GetNotificationsSettingsParams paramGetNotificationsSettingsParams)
  {
    FqlMultiQueryHelper localFqlMultiQueryHelper = new FqlMultiQueryHelper();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramGetNotificationsSettingsParams.b();
    arrayOfObject[1] = paramGetNotificationsSettingsParams.a();
    localFqlMultiQueryHelper.a("notificationssettings", StringUtil.a("SELECT setting_id, setting_value FROM notification_setting WHERE user_id=%s AND type='%s'", arrayOfObject));
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    localArrayList.add(new BasicNameValuePair("queries", localFqlMultiQueryHelper.a().toString()));
    return new ApiRequest("getNotificationsSettings", "GET", "method/fql.multiquery", localArrayList, ApiResponseType.JSON);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.protocol.GetNotificationsSettingsMethod
 * JD-Core Version:    0.6.2
 */