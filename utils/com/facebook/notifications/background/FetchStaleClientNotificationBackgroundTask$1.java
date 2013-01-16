package com.facebook.notifications.background;

import com.facebook.background.SimpleBackgroundResultFutureCallback;
import com.facebook.notifications.intent.INotificationRenderer;
import com.facebook.notifications.prefs.NotificationsPrefs;
import com.facebook.notifications.protocol.FetchStaleClientNotificationMethod.Result;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.server.OperationResult;
import com.google.common.base.Strings;

class FetchStaleClientNotificationBackgroundTask$1 extends SimpleBackgroundResultFutureCallback
{
  FetchStaleClientNotificationBackgroundTask$1(FetchStaleClientNotificationBackgroundTask paramFetchStaleClientNotificationBackgroundTask, Class paramClass)
  {
    super(paramClass);
  }

  private void c()
  {
    FetchStaleClientNotificationBackgroundTask.a(this.a, null);
    FetchStaleClientNotificationBackgroundTask.b(this.a).b().a(NotificationsPrefs.e, FetchStaleClientNotificationBackgroundTask.a(this.a).a()).a();
  }

  public void a(OperationResult paramOperationResult)
  {
    c();
    FetchStaleClientNotificationMethod.Result localResult = (FetchStaleClientNotificationMethod.Result)paramOperationResult.h();
    if (Strings.isNullOrEmpty(localResult.link));
    for (String str = "fb://feed"; ; str = localResult.link)
    {
      FetchStaleClientNotificationBackgroundTask.c(this.a).a(str, localResult.message, Long.valueOf(localResult.notificationID));
      FetchStaleClientNotificationBackgroundTask.a(this.a, "client_notification_received", Long.valueOf(localResult.notificationID));
      super.a(paramOperationResult);
      return;
    }
  }

  public void a(Throwable paramThrowable)
  {
    c();
    FetchStaleClientNotificationBackgroundTask.a(this.a, "client_notification_failed_to_received", Long.valueOf(0L));
    super.a(paramThrowable);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.background.FetchStaleClientNotificationBackgroundTask.1
 * JD-Core Version:    0.6.2
 */