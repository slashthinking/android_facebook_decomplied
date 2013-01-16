package com.facebook.orca.app;

import android.support.v4.content.LocalBroadcastManager;
import com.facebook.orca.annotations.DefaultExecutorService;
import com.facebook.orca.annotations.ForMessages;
import com.facebook.orca.annotations.ForUiThread;
import com.facebook.orca.annotations.IsPresenceEnabled;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.presence.PresenceManager;
import com.facebook.orca.push.mqtt.MqttConnectionManager;
import com.facebook.orca.users.FacebookUserIterator;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Executor;

class MessagesModule$PresenceManagerProvider extends AbstractProvider<PresenceManager>
{
  private MessagesModule$PresenceManagerProvider(MessagesModule paramMessagesModule)
  {
  }

  public PresenceManager a()
  {
    return new PresenceManager(MessagesModule.a(this.a), (MqttConnectionManager)b(MqttConnectionManager.class), a(FacebookUserIterator.class, ForMessages.class), a(Boolean.class, IsPresenceEnabled.class), (AndroidThreadUtil)b(AndroidThreadUtil.class), (ListeningExecutorService)b(ListeningExecutorService.class, DefaultExecutorService.class), (Executor)b(Executor.class, ForUiThread.class), (OrcaSharedPreferences)b(OrcaSharedPreferences.class), (LocalBroadcastManager)b(LocalBroadcastManager.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.PresenceManagerProvider
 * JD-Core Version:    0.6.0
 */