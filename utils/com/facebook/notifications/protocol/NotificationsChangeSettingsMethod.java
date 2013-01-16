package com.facebook.notifications.protocol;

import com.facebook.common.util.Log;
import com.facebook.notifications.server.NotificationsChangeSettingsParams;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class NotificationsChangeSettingsMethod
  implements ApiMethod<NotificationsChangeSettingsParams, Boolean>
{
  private static final Class<?> a = NotificationsChangeSettingsMethod.class;

  private boolean a(String paramString)
  {
    if (paramString == null);
    for (boolean bool = true; ; bool = paramString.isEmpty())
      return bool;
  }

  public ApiRequest a(NotificationsChangeSettingsParams paramNotificationsChangeSettingsParams)
  {
    Preconditions.checkNotNull(paramNotificationsChangeSettingsParams);
    ArrayList localArrayList = Lists.a();
    if (!a(paramNotificationsChangeSettingsParams.a()))
      localArrayList.add(new BasicNameValuePair("alert_types_on", paramNotificationsChangeSettingsParams.a()));
    if (!a(paramNotificationsChangeSettingsParams.b()))
      localArrayList.add(new BasicNameValuePair("alert_types_off", paramNotificationsChangeSettingsParams.b()));
    if (!a(paramNotificationsChangeSettingsParams.c()))
      localArrayList.add(new BasicNameValuePair("type", paramNotificationsChangeSettingsParams.c()));
    if (!a(paramNotificationsChangeSettingsParams.d()))
      localArrayList.add(new BasicNameValuePair("setting_id", paramNotificationsChangeSettingsParams.d()));
    if (!a(paramNotificationsChangeSettingsParams.e()))
      localArrayList.add(new BasicNameValuePair("setting_value", paramNotificationsChangeSettingsParams.e()));
    return new ApiRequest("graphNotificationsSettings", "POST", "me/notificationssettings", localArrayList, ApiResponseType.JSON);
  }

  public Boolean a(NotificationsChangeSettingsParams paramNotificationsChangeSettingsParams, ApiResponse paramApiResponse)
  {
    Preconditions.checkNotNull(paramApiResponse);
    paramApiResponse.g();
    boolean bool = paramApiResponse.c().asBoolean();
    if ((bool) && (paramNotificationsChangeSettingsParams != null));
    for (Boolean localBoolean = Boolean.valueOf(bool); ; localBoolean = Boolean.valueOf(bool))
    {
      return localBoolean;
      Log.a(NotificationsChangeSettingsMethod.class.getSimpleName(), "Failed to change notification settings");
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.protocol.NotificationsChangeSettingsMethod
 * JD-Core Version:    0.6.2
 */