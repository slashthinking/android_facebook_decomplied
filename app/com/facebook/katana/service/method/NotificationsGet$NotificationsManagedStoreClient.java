package com.facebook.katana.service.method;

import android.content.Context;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.ManagedDataStore.Client;
import com.facebook.katana.binding.NetworkRequestCallback;
import com.facebook.katana.model.FacebookNotifications;

class NotificationsGet$NotificationsManagedStoreClient
  implements ManagedDataStore.Client<String, FacebookNotifications>
{
  public String a(String paramString)
  {
    return paramString;
  }

  public void a(Context paramContext, String paramString, NetworkRequestCallback<String, FacebookNotifications> paramNetworkRequestCallback)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    if (localAppSession != null)
      localAppSession.b(paramContext, 0, false);
  }

  public boolean a(String paramString, FacebookNotifications paramFacebookNotifications)
  {
    return true;
  }

  public int b(String paramString, FacebookNotifications paramFacebookNotifications)
  {
    return 300;
  }

  public FacebookNotifications b(String paramString)
  {
    try
    {
      FacebookNotifications localFacebookNotifications2 = NotificationsGet.c(paramString);
      localFacebookNotifications1 = localFacebookNotifications2;
      return localFacebookNotifications1;
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        FacebookNotifications localFacebookNotifications1 = new FacebookNotifications();
      }
    }
  }

  public int c(String paramString, FacebookNotifications paramFacebookNotifications)
  {
    return 3600;
  }

  public String getDiskKeyPrefix()
  {
    return NotificationsGet.class.getSimpleName();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.NotificationsGet.NotificationsManagedStoreClient
 * JD-Core Version:    0.6.0
 */