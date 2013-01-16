package com.facebook.orca.app;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.util.HandlerExecutorService;
import com.facebook.orca.inject.AbstractProvider;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

class FbBaseModule$UiThreadListeningScheduledExecutorServiceProvider extends AbstractProvider<ListeningScheduledExecutorService>
{
  private FbBaseModule$UiThreadListeningScheduledExecutorServiceProvider(FbBaseModule paramFbBaseModule)
  {
  }

  public ListeningScheduledExecutorService a()
  {
    return MoreExecutors.a(new HandlerExecutorService(new Handler(Looper.getMainLooper())));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.UiThreadListeningScheduledExecutorServiceProvider
 * JD-Core Version:    0.6.0
 */