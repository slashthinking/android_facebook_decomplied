package com.facebook.orca.notify;

import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.Context;
import android.os.PowerManager;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.images.FetchImageExecutor;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.intents.MessagingIntentUris;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.photos.tiles.UserTileViewLogic;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class MessageNotificationModule$DefaultMessagingNotificationRendererProvider extends AbstractProvider<DefaultMessagingNotificationHandler>
{
  private MessageNotificationModule$DefaultMessagingNotificationRendererProvider(MessageNotificationModule paramMessageNotificationModule)
  {
  }

  public DefaultMessagingNotificationHandler a()
  {
    return new DefaultMessagingNotificationHandler(MessageNotificationModule.a(this.a), (NotificationManager)MessageNotificationModule.a(this.a).getSystemService("notification"), (MessagingNotificationPreferences)b(MessagingNotificationPreferences.class), (MessagingNotificationFeedback)b(MessagingNotificationFeedback.class), (MessagingIntentUris)b(MessagingIntentUris.class), (OrcaSharedPreferences)b(OrcaSharedPreferences.class), (FetchImageExecutor)b(FetchImageExecutor.class), (UserTileViewLogic)b(UserTileViewLogic.class), (OrcaServiceOperationFactory)b(OrcaServiceOperationFactory.class, FromApplication.class), (KeyguardManager)b(KeyguardManager.class, FromApplication.class), (PowerManager)b(PowerManager.class, FromApplication.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.notify.MessageNotificationModule.DefaultMessagingNotificationRendererProvider
 * JD-Core Version:    0.6.0
 */