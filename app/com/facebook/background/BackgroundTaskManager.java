package com.facebook.background;

import android.os.Handler;
import android.os.HandlerThread;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.app.UserActivityManager;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.app.UserInteractionController;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.debug.BLog;
import java.lang.annotation.Annotation;
import java.util.Set;

public class BackgroundTaskManager
  implements INeedInit
{
  private static Class<?> a = BackgroundTaskManager.class;
  private final UserInteractionController b;
  private final UserActivityManager c;
  private final LocalBroadcastManager d;
  private final Set<BackgroundTask> e;
  private final AndroidThreadUtil f;
  private final boolean g;
  private final Clock h;
  private BackgroundTaskRunner i;

  public BackgroundTaskManager(UserInteractionController paramUserInteractionController, UserActivityManager paramUserActivityManager, LocalBroadcastManager paramLocalBroadcastManager, Set<BackgroundTask> paramSet, AndroidThreadUtil paramAndroidThreadUtil, boolean paramBoolean, Clock paramClock)
  {
    this.b = paramUserInteractionController;
    this.c = paramUserActivityManager;
    this.d = paramLocalBroadcastManager;
    this.f = paramAndroidThreadUtil;
    this.e = paramSet;
    this.g = paramBoolean;
    this.h = paramClock;
  }

  public void a(Class<? extends Annotation> paramClass)
  {
    if (this.i != null)
      this.i.a(paramClass);
  }

  public void b(Class<? extends Annotation> paramClass)
  {
    if (this.i != null)
      this.i.b(paramClass);
  }

  public void i_()
  {
    if (!this.g)
      BLog.b(a, "Background tasks are not enabled. Not starting background task thread.");
    while (true)
    {
      return;
      if (this.e.isEmpty())
      {
        BLog.b(a, "No background tasks. Not starting background task thread.");
        continue;
      }
      BLog.b(a, "Starting background task thread.");
      HandlerThread localHandlerThread = new HandlerThread("BackgroundTaskManager", 10);
      localHandlerThread.start();
      Handler localHandler = new Handler(localHandlerThread.getLooper());
      this.i = new BackgroundTaskRunner(this.b, this.c, this.d, this.e, this.f, localHandler, this.h);
      this.i.a();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.background.BackgroundTaskManager
 * JD-Core Version:    0.6.0
 */