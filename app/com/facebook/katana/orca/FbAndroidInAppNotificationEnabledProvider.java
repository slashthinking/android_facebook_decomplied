package com.facebook.katana.orca;

import android.content.Context;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.annotations.MeUser;
import com.facebook.orca.users.User;
import javax.inject.Inject;
import javax.inject.Provider;

public class FbAndroidInAppNotificationEnabledProvider
  implements Provider<Boolean>
{
  private final Provider<User> a;
  private final Context b;

  @Inject
  public FbAndroidInAppNotificationEnabledProvider(@MeUser Provider<User> paramProvider, @FromApplication Context paramContext)
  {
    this.a = paramProvider;
    this.b = paramContext;
  }

  public Boolean a()
  {
    Object localObject = this.a.b();
    boolean bool = false;
    if (localObject != null)
    {
      Boolean localBoolean1 = Gatekeeper.a(this.b, "messenger_inapp_notify_android");
      Boolean localBoolean2 = Boolean.TRUE;
      bool = false;
      if (localBoolean2 == localBoolean1)
        bool = true;
    }
    return Boolean.valueOf(bool);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbAndroidInAppNotificationEnabledProvider
 * JD-Core Version:    0.6.0
 */