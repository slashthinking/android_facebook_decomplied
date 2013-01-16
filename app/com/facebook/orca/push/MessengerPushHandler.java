package com.facebook.orca.push;

import android.os.Bundle;
import com.facebook.analytics.ReliabilityAnalyticsLogger;
import com.facebook.orca.app.AppInitLock;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.notify.OrcaNotificationManager;
import com.facebook.orca.ops.OrcaServiceOperation;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.ParticipantInfo;
import com.google.common.base.Objects;
import javax.inject.Provider;

public class MessengerPushHandler extends AbstractPushHandler
{
  private final DataCache a;
  private final OrcaNotificationManager b;
  private final Provider<OrcaServiceOperation> c;
  private final AppInitLock d;
  private final ReliabilityAnalyticsLogger e;

  public MessengerPushHandler(DataCache paramDataCache, OrcaNotificationManager paramOrcaNotificationManager, Provider<OrcaServiceOperation> paramProvider, AppInitLock paramAppInitLock, ReliabilityAnalyticsLogger paramReliabilityAnalyticsLogger)
  {
    this.a = paramDataCache;
    this.b = paramOrcaNotificationManager;
    this.c = paramProvider;
    this.d = paramAppInitLock;
    this.e = paramReliabilityAnalyticsLogger;
  }

  private OrcaServiceOperation a()
  {
    OrcaServiceOperation localOrcaServiceOperation = (OrcaServiceOperation)this.c.b();
    localOrcaServiceOperation.c(true);
    return localOrcaServiceOperation;
  }

  private void a(String paramString, Message paramMessage, PushSource paramPushSource)
  {
    if (Objects.equal(this.a.b(), paramMessage.f().e()))
      this.e.a(paramMessage.b(), paramMessage.a(), paramPushSource.toString(), "from_viewer");
    while (true)
    {
      return;
      this.b.a(paramString, paramMessage, paramPushSource);
    }
  }

  public void a(String paramString1, String paramString2, Message paramMessage, PushSource paramPushSource)
  {
    this.d.b();
    OrcaServiceOperation localOrcaServiceOperation = a();
    Bundle localBundle = new Bundle();
    localBundle.putString("threadId", paramString2);
    localBundle.putParcelable("message", paramMessage);
    localOrcaServiceOperation.a("pushed_message", localBundle);
    if (paramString1 != null)
      a(paramString1, paramMessage, paramPushSource);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.MessengerPushHandler
 * JD-Core Version:    0.6.0
 */