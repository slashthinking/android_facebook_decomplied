package com.facebook.orca.notify;

import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.v4.app.NotificationCompat.Builder;
import android.widget.RemoteViews;
import com.facebook.concurrent.FutureUtils;
import com.facebook.orca.common.util.SizeUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.images.FetchImageExecutor;
import com.facebook.orca.images.FetchImageParams;
import com.facebook.orca.intents.MessagingIntentUris;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.photos.tiles.UserTileViewLogic;
import com.facebook.orca.photos.tiles.UserTileViewParams;
import com.facebook.orca.prefs.MessagesPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.prefs.PrefKey;
import com.facebook.orca.push.PushSource;
import com.facebook.orca.server.DataFreshnessParam;
import com.facebook.orca.server.FetchThreadParamsBuilder;
import com.facebook.orca.server.FetchThreadResult;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.ThreadCriteria;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.ParticipantInfo;
import com.facebook.orca.threads.ThreadParticipant;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.users.UserKey;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;

public class DefaultMessagingNotificationHandler extends AbstractMessagingNotificationHandler
{
  private static final Class<?> a = DefaultMessagingNotificationHandler.class;
  private final Context b;
  private final NotificationManager c;
  private final MessagingNotificationPreferences d;
  private final MessagingNotificationFeedback e;
  private final MessagingIntentUris f;
  private final OrcaSharedPreferences g;
  private final FetchImageExecutor h;
  private final UserTileViewLogic i;
  private final OrcaServiceOperationFactory j;
  private final KeyguardManager k;
  private final PowerManager l;

  public DefaultMessagingNotificationHandler(Context paramContext, NotificationManager paramNotificationManager, MessagingNotificationPreferences paramMessagingNotificationPreferences, MessagingNotificationFeedback paramMessagingNotificationFeedback, MessagingIntentUris paramMessagingIntentUris, OrcaSharedPreferences paramOrcaSharedPreferences, FetchImageExecutor paramFetchImageExecutor, UserTileViewLogic paramUserTileViewLogic, OrcaServiceOperationFactory paramOrcaServiceOperationFactory, KeyguardManager paramKeyguardManager, PowerManager paramPowerManager)
  {
    this.b = paramContext;
    this.c = paramNotificationManager;
    this.e = paramMessagingNotificationFeedback;
    this.d = paramMessagingNotificationPreferences;
    this.f = paramMessagingIntentUris;
    this.g = paramOrcaSharedPreferences;
    this.h = paramFetchImageExecutor;
    this.i = paramUserTileViewLogic;
    this.j = paramOrcaServiceOperationFactory;
    this.k = paramKeyguardManager;
    this.l = paramPowerManager;
  }

  private Bitmap a(ParticipantInfo paramParticipantInfo)
  {
    Bitmap localBitmap;
    if ((paramParticipantInfo == null) || (!paramParticipantInfo.b()))
    {
      localBitmap = null;
      return localBitmap;
    }
    UserKey localUserKey = paramParticipantInfo.e();
    Resources localResources = this.b.getResources();
    int m;
    if (Build.VERSION.SDK_INT >= 11)
      m = (int)localResources.getDimension(17104902);
    for (int n = (int)localResources.getDimension(17104901); ; n = SizeUtil.a(this.b, 48.0F))
    {
      FetchImageParams localFetchImageParams = this.i.a(UserTileViewParams.a(localUserKey), n, m);
      localBitmap = this.h.a(localFetchImageParams);
      break;
      m = SizeUtil.a(this.b, 48.0F);
    }
  }

  private DefaultMessagingNotificationHandler.NotificationInfo a(String paramString, Message paramMessage, boolean paramBoolean)
  {
    ParticipantInfo localParticipantInfo = a(paramMessage);
    String str1;
    if ((localParticipantInfo != null) && (!StringUtil.a(localParticipantInfo.d())))
    {
      String str2 = localParticipantInfo.d();
      paramString = paramMessage.h();
      str1 = str2;
      if (!paramBoolean)
        break label82;
    }
    label82: for (Bitmap localBitmap = a(localParticipantInfo); ; localBitmap = null)
    {
      return new DefaultMessagingNotificationHandler.NotificationInfo(str1, paramString, localBitmap, null);
      str1 = this.b.getResources().getString(2131362037);
      break;
    }
  }

  private ParticipantInfo a(Message paramMessage)
  {
    ParticipantInfo localParticipantInfo1 = paramMessage.f();
    ParticipantInfo localParticipantInfo2;
    if (localParticipantInfo1 == null)
      localParticipantInfo2 = null;
    while (true)
    {
      return localParticipantInfo2;
      ThreadSummary localThreadSummary = e(paramMessage.b());
      if (localThreadSummary == null)
      {
        localParticipantInfo2 = localParticipantInfo1;
        continue;
      }
      Iterator localIterator = localThreadSummary.i().iterator();
      while (true)
        if (localIterator.hasNext())
        {
          ThreadParticipant localThreadParticipant = (ThreadParticipant)localIterator.next();
          if (!Objects.equal(localThreadParticipant.d(), localParticipantInfo1.e()))
            continue;
          localParticipantInfo2 = localThreadParticipant.a();
          break;
        }
      localParticipantInfo2 = localParticipantInfo1;
    }
  }

  private void a(String paramString, Message paramMessage, Notification paramNotification, PendingIntent paramPendingIntent)
  {
    paramNotification.contentIntent = paramPendingIntent;
    DefaultMessagingNotificationHandler.NotificationInfo localNotificationInfo = a(paramString, paramMessage, true);
    int m = d(paramMessage.b());
    RemoteViews localRemoteViews = new RemoteViews(this.b.getPackageName(), 2130903301);
    if (Build.VERSION.SDK_INT >= 11)
      if (DefaultMessagingNotificationHandler.NotificationInfo.a(localNotificationInfo) != null)
      {
        localRemoteViews.setImageViewBitmap(2131296625, DefaultMessagingNotificationHandler.NotificationInfo.a(localNotificationInfo));
        localRemoteViews.setTextViewText(2131296686, DefaultMessagingNotificationHandler.NotificationInfo.b(localNotificationInfo));
        localRemoteViews.setTextViewText(2131296432, DefaultMessagingNotificationHandler.NotificationInfo.c(localNotificationInfo));
        if (m < 0)
          break label188;
        localRemoteViews.setTextViewText(2131296617, Integer.toString(m));
      }
    while (true)
    {
      paramNotification.contentView = localRemoteViews;
      return;
      localRemoteViews.setImageViewResource(2131296625, this.d.e());
      break;
      localRemoteViews.setImageViewResource(2131296488, this.d.e());
      if (DefaultMessagingNotificationHandler.NotificationInfo.a(localNotificationInfo) != null)
      {
        localRemoteViews.setImageViewBitmap(2131296625, DefaultMessagingNotificationHandler.NotificationInfo.a(localNotificationInfo));
        break;
      }
      localRemoteViews.setViewVisibility(2131296625, 4);
      break;
      label188: localRemoteViews.setViewVisibility(2131296617, 8);
    }
  }

  private List<String> b()
  {
    SortedSet localSortedSet = this.g.b(MessagesPrefKeys.u);
    if (localSortedSet.isEmpty());
    ImmutableList.Builder localBuilder;
    for (ImmutableList localImmutableList = ImmutableList.d(); ; localImmutableList = localBuilder.b())
    {
      return localImmutableList;
      localBuilder = ImmutableList.e();
      Iterator localIterator = localSortedSet.iterator();
      while (localIterator.hasNext())
        localBuilder.b(Uri.decode(((PrefKey)localIterator.next()).b(MessagesPrefKeys.u)));
    }
  }

  private void b(NewMessageNotification paramNewMessageNotification)
  {
    String str = paramNewMessageNotification.a();
    Message localMessage = paramNewMessageNotification.b();
    AlertDisposition localAlertDisposition = paramNewMessageNotification.e();
    long l1 = System.currentTimeMillis();
    Notification localNotification = new Notification(this.d.e(), str, l1);
    this.e.a(localNotification, localAlertDisposition);
    Intent localIntent = new Intent("android.intent.action.VIEW", this.f.a(localMessage.b()));
    localIntent.setFlags(67108864);
    localIntent.putExtra("from_notification", true);
    localIntent.putExtra("trigger", "notification");
    PendingIntent localPendingIntent = PendingIntent.getActivity(this.b, 0, localIntent, 0);
    if (Build.VERSION.SDK_INT >= 9)
      a(str, localMessage, localNotification, localPendingIntent);
    while (true)
    {
      BLog.b(a, "Calling android NotificationManager notify");
      this.c.notify(localMessage.b(), 10000, localNotification);
      return;
      b(str, localMessage, localNotification, localPendingIntent);
    }
  }

  private void b(String paramString)
  {
    String str1 = this.b.getResources().getString(2131362510);
    long l1 = System.currentTimeMillis();
    Notification localNotification = new Notification(this.d.e(), str1, l1);
    this.e.a(localNotification, new AlertDisposition());
    Intent localIntent = new Intent("android.intent.action.VIEW", this.f.a(paramString));
    localIntent.setFlags(67108864);
    localIntent.putExtra("from_notification", true);
    String str2 = this.b.getResources().getString(2131362037);
    PendingIntent localPendingIntent = PendingIntent.getActivity(this.b, 0, localIntent, 0);
    localNotification.setLatestEventInfo(this.b, str2, str1, localPendingIntent);
    this.c.notify(10001, localNotification);
  }

  private void b(String paramString, Message paramMessage, Notification paramNotification, PendingIntent paramPendingIntent)
  {
    DefaultMessagingNotificationHandler.NotificationInfo localNotificationInfo = a(paramString, paramMessage, false);
    paramNotification.setLatestEventInfo(this.b, DefaultMessagingNotificationHandler.NotificationInfo.b(localNotificationInfo), DefaultMessagingNotificationHandler.NotificationInfo.c(localNotificationInfo), paramPendingIntent);
  }

  private void c()
  {
    OrcaSharedPreferences.Editor localEditor = this.g.b();
    localEditor.b(MessagesPrefKeys.u);
    localEditor.a();
  }

  private void c(String paramString)
  {
    PrefKey localPrefKey = MessagesPrefKeys.c(paramString);
    int m = this.g.a(localPrefKey, 0);
    OrcaSharedPreferences.Editor localEditor = this.g.b();
    localEditor.a(localPrefKey, m + 1);
    localEditor.a();
  }

  private int d(String paramString)
  {
    PrefKey localPrefKey = MessagesPrefKeys.c(paramString);
    return this.g.a(localPrefKey, 0);
  }

  private ThreadSummary e(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("fetchThreadParams", new FetchThreadParamsBuilder().a(ThreadCriteria.a(paramString)).a(DataFreshnessParam.DO_NOT_CHECK_SERVER).a(0).h());
    OperationResult localOperationResult = (OperationResult)FutureUtils.a(this.j.a("fetch_thread", localBundle).e());
    if (localOperationResult == null);
    for (ThreadSummary localThreadSummary = null; ; localThreadSummary = ((FetchThreadResult)localOperationResult.h()).a())
      return localThreadSummary;
  }

  public void a()
  {
    BLog.b(a, "Clearing all notifications");
    Iterator localIterator = b().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.c.cancel(str, 10000);
    }
    this.c.cancel(10001);
    this.c.cancel(10002);
    c();
  }

  public void a(NewMessageNotification paramNewMessageNotification)
  {
    NewMessageNotification.PresenceLevel localPresenceLevel = paramNewMessageNotification.c();
    AlertDisposition localAlertDisposition = paramNewMessageNotification.e();
    if ((localPresenceLevel == NewMessageNotification.PresenceLevel.IN_APP_ACTIVE_30S) || (localPresenceLevel == NewMessageNotification.PresenceLevel.IN_APP_ACTIVE_10S))
    {
      if ((!localAlertDisposition.b()) && (localPresenceLevel == NewMessageNotification.PresenceLevel.IN_APP_ACTIVE_30S))
        this.e.a(localAlertDisposition);
      if (!localAlertDisposition.d())
      {
        if (localPresenceLevel != NewMessageNotification.PresenceLevel.IN_APP_ACTIVE_10S)
          break label69;
        this.e.b(localAlertDisposition);
      }
    }
    while (true)
    {
      return;
      label69: this.e.c(localAlertDisposition);
      continue;
      if ((paramNewMessageNotification.d() == PushSource.MQTT) || (localAlertDisposition.h()))
        continue;
      c(paramNewMessageNotification.b().b());
      b(paramNewMessageNotification);
      localAlertDisposition.i();
    }
  }

  public void a(String paramString)
  {
    BLog.b(a, "Clearing thread notification for %s", new Object[] { paramString });
    this.c.cancel(paramString, 10000);
  }

  public boolean a(FailedToSendMessageNotification paramFailedToSendMessageNotification)
  {
    b(paramFailedToSendMessageNotification.a());
    return true;
  }

  public boolean a(LoggedOutMessageNotification paramLoggedOutMessageNotification)
  {
    int m = this.d.e();
    Intent localIntent = new Intent("android.intent.action.VIEW", this.f.a());
    localIntent.putExtra("from_notification", true);
    PendingIntent localPendingIntent = PendingIntent.getActivity(this.b, 0, localIntent, 134217728);
    Notification localNotification = new NotificationCompat.Builder(this.b).a(paramLoggedOutMessageNotification.a()).b(paramLoggedOutMessageNotification.b()).c(paramLoggedOutMessageNotification.c()).a(m).a(localPendingIntent).b(true).a();
    this.e.a(localNotification, new AlertDisposition());
    this.c.notify(null, 10004, localNotification);
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.notify.DefaultMessagingNotificationHandler
 * JD-Core Version:    0.6.0
 */