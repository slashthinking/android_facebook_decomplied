package com.facebook.orca.server;

import android.support.v4.content.LocalBroadcastManager;
import com.facebook.app.UserActivityManager;
import com.facebook.background.AreBackgroundTasksEnabled;
import com.facebook.background.BackgroundTask;
import com.facebook.background.BackgroundTaskManager;
import com.facebook.orca.app.UserInteractionController;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.AbstractProvider;

class ServicesModule$BackgroundTaskManagerProvider extends AbstractProvider<BackgroundTaskManager>
{
  private ServicesModule$BackgroundTaskManagerProvider(ServicesModule paramServicesModule)
  {
  }

  public BackgroundTaskManager a()
  {
    return new BackgroundTaskManager((UserInteractionController)b(UserInteractionController.class), (UserActivityManager)b(UserActivityManager.class), (LocalBroadcastManager)b(LocalBroadcastManager.class), c(BackgroundTask.class), (AndroidThreadUtil)b(AndroidThreadUtil.class), ((Boolean)b(Boolean.class, AreBackgroundTasksEnabled.class)).booleanValue(), (Clock)b(Clock.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.ServicesModule.BackgroundTaskManagerProvider
 * JD-Core Version:    0.6.0
 */