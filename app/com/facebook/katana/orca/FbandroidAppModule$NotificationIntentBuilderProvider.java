package com.facebook.katana.orca;

import android.content.Context;
import com.facebook.katana.notification.impl.DefaultNotificationRenderer;
import com.facebook.notifications.intent.INotificationRenderer;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;

class FbandroidAppModule$NotificationIntentBuilderProvider extends AbstractProvider<INotificationRenderer>
{
  private FbandroidAppModule$NotificationIntentBuilderProvider(FbandroidAppModule paramFbandroidAppModule)
  {
  }

  public INotificationRenderer a()
  {
    return new DefaultNotificationRenderer((Context)b(Context.class, FromApplication.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidAppModule.NotificationIntentBuilderProvider
 * JD-Core Version:    0.6.0
 */