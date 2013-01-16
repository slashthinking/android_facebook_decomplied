package com.facebook.katana.binding;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import android.util.DisplayMetrics;
import android.widget.RemoteViews;
import com.facebook.common.util.DefaultTimeFormatUtil;
import com.facebook.common.util.TimeFormatUtil.TimeFormatStyle;
import com.facebook.ipc.katana.model.FacebookStatus;
import com.facebook.ipc.katana.model.FacebookUser;
import com.facebook.katana.FacebookControlWidgetProvider;
import com.facebook.katana.FacebookWidgetProvider;
import com.facebook.katana.IntentUriHandler;
import com.facebook.katana.LoginActivity;
import com.facebook.katana.activity.composer.ComposerActivity;
import com.facebook.katana.activity.media.MediaPickerActivity;
import com.facebook.katana.model.FacebookNotifications;
import com.facebook.katana.provider.UserStatusesProvider;
import com.facebook.katana.service.FacebookService;
import com.facebook.katana.service.method.NotificationsGet;
import com.facebook.katana.util.IntentUtils;
import com.facebook.katana.util.NotificationUtils;
import com.facebook.orca.common.util.StringLocaleUtil;
import java.util.ArrayList;
import java.util.List;

public class Widget
{
  private static Widget d;
  private final List<FacebookStatus> a = new ArrayList();
  private int b;
  private TextAppearanceSpan c;

  public static Widget a()
  {
    if (d == null)
      d = new Widget();
    return d;
  }

  private void a(Context paramContext, RemoteViews paramRemoteViews)
  {
    monitorenter;
    try
    {
      int i = NotificationsGet.a(paramContext).c();
      paramRemoteViews.setTextViewText(2131297996, NotificationUtils.a(paramContext, i));
      if (i == 0)
      {
        j = 8;
        paramRemoteViews.setViewVisibility(2131297996, j);
        return;
      }
      int j = 0;
    }
    finally
    {
      monitorexit;
    }
  }

  private void a(Context paramContext, FacebookStatus paramFacebookStatus, int paramInt, Bitmap paramBitmap)
  {
    monitorenter;
    while (true)
    {
      RemoteViews localRemoteViews;
      Intent localIntent4;
      try
      {
        AppWidgetManager localAppWidgetManager = AppWidgetManager.getInstance(paramContext);
        ComponentName localComponentName = new ComponentName(paramContext, FacebookWidgetProvider.class);
        int i = localAppWidgetManager.getAppWidgetIds(localComponentName).length;
        if (i == 0)
          return;
        localRemoteViews = new RemoteViews(paramContext.getPackageName(), 2130903635);
        Intent localIntent1 = IntentUriHandler.a(paramContext, "fb://feed");
        localIntent1.setFlags(335544320);
        localIntent1.setAction("openNewsfeed");
        localRemoteViews.setOnClickPendingIntent(2131297989, PendingIntent.getActivity(paramContext, 0, localIntent1, 268435456));
        NotificationsGet.a(paramContext).c();
        a(paramContext, localRemoteViews);
        Intent localIntent2 = new Intent(paramContext, ComposerActivity.class);
        localIntent2.setFlags(335544320);
        localRemoteViews.setOnClickPendingIntent(2131297998, PendingIntent.getActivity(paramContext, 10, localIntent2, 268435456));
        Intent localIntent3 = new Intent(paramContext, ComposerActivity.class);
        localIntent3.setFlags(268435456);
        localRemoteViews.setOnClickPendingIntent(2131297997, PendingIntent.getActivity(paramContext, 0, localIntent3, 268435456));
        String str1 = paramFacebookStatus.a().mDisplayName;
        String str2 = paramFacebookStatus.b();
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str1);
        if (str2 == null)
          continue;
        localSpannableStringBuilder.append(" ").append(str2);
        if (this.c != null)
          continue;
        Resources localResources = paramContext.getResources();
        this.c = new TextAppearanceSpan(null, 1, (int)(14.0F * localResources.getDisplayMetrics().density), ColorStateList.valueOf(localResources.getColor(2131165437)), null);
        localSpannableStringBuilder.setSpan(this.c, 0, str1.length(), 33);
        localRemoteViews.setTextViewText(2131298001, localSpannableStringBuilder);
        localRemoteViews.setTextViewText(2131298002, DefaultTimeFormatUtil.a(paramContext, TimeFormatUtil.TimeFormatStyle.STREAM_RELATIVE_STYLE, 1000L * paramFacebookStatus.c()));
        if (paramBitmap != null)
        {
          localRemoteViews.setImageViewBitmap(2131298000, paramBitmap);
          localObject2 = IntentUtils.a(paramContext, paramFacebookStatus.a().mUserId);
          ((Intent)localObject2).setFlags(335544320);
          ((Intent)localObject2).setAction("openUserProfile");
          localRemoteViews.setOnClickPendingIntent(2131298000, PendingIntent.getActivity(paramContext, 0, (Intent)localObject2, 268435456));
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = (paramFacebookStatus.a().mUserId + "_" + String.valueOf(paramFacebookStatus.d()));
          localIntent4 = IntentUriHandler.a(paramContext, StringLocaleUtil.a("fb://post/%s", arrayOfObject));
          if (localIntent4 != null)
            break label531;
          localRemoteViews.setOnClickPendingIntent(2131297999, PendingIntent.getActivity(paramContext, 0, (Intent)localObject2, 268435456));
          if (paramInt != 0)
            break label555;
          localRemoteViews.setImageViewResource(2131298003, 2130838323);
          if (paramInt < -1 + this.a.size())
            break label648;
          localRemoteViews.setImageViewResource(2131298004, 2130838317);
          localAppWidgetManager.updateAppWidget(localComponentName, localRemoteViews);
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      localRemoteViews.setImageViewResource(2131298000, 2130838447);
      continue;
      label531: localIntent4.setFlags(335544320);
      localIntent4.setAction("openPost");
      Object localObject2 = localIntent4;
      continue;
      label555: Intent localIntent5 = new Intent(paramContext, FacebookService.class);
      localIntent5.setAction("com.facebook.katana.service." + AppSession.m());
      localIntent5.putExtra("type", 91);
      localIntent5.putExtra("sid", AppSession.p());
      localRemoteViews.setImageViewResource(2131298003, 2130839043);
      localRemoteViews.setOnClickPendingIntent(2131298003, PendingIntent.getService(paramContext, 0, localIntent5, 268435456));
      continue;
      label648: Intent localIntent6 = new Intent(paramContext, FacebookService.class);
      localIntent6.setAction("com.facebook.katana.service." + AppSession.m());
      localIntent6.putExtra("type", 90);
      localIntent6.putExtra("sid", AppSession.p());
      localRemoteViews.setImageViewResource(2131298004, 2130839042);
      localRemoteViews.setOnClickPendingIntent(2131298004, PendingIntent.getService(paramContext, 0, localIntent6, 268435456));
    }
  }

  private void i(Context paramContext)
  {
    FacebookStatus localFacebookStatus = (FacebookStatus)this.a.get(this.b);
    FacebookUser localFacebookUser = localFacebookStatus.a();
    AppSession localAppSession = AppSession.a(paramContext, false);
    String str = localFacebookUser.mImageUrl;
    Bitmap localBitmap = null;
    if (str != null)
    {
      localBitmap = null;
      if (localAppSession != null)
        localBitmap = localAppSession.j().a(paramContext, localFacebookUser.mUserId, localFacebookUser.mImageUrl);
    }
    a(paramContext, localFacebookStatus, this.b, localBitmap);
  }

  private static List<FacebookStatus> j(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = paramContext.getContentResolver().query(UserStatusesProvider.a, Widget.StatusesQuery.a, null, null, null);
    if (localCursor != null)
    {
      if (localCursor.moveToFirst())
        do
        {
          FacebookStatus localFacebookStatus = new FacebookStatus(new FacebookUser(localCursor.getLong(localCursor.getColumnIndex("user_id")), localCursor.getString(localCursor.getColumnIndex("first_name")), localCursor.getString(localCursor.getColumnIndex("last_name")), localCursor.getString(localCursor.getColumnIndex("display_name")), localCursor.getString(localCursor.getColumnIndex("user_pic"))), localCursor.getString(localCursor.getColumnIndex("message")), localCursor.getLong(localCursor.getColumnIndex("timestamp")), localCursor.getLong(localCursor.getColumnIndex("status_id")));
          localArrayList.add(localFacebookStatus);
        }
        while (localCursor.moveToNext());
      localCursor.close();
    }
    return localArrayList;
  }

  public void a(Context paramContext)
  {
    if (this.a.isEmpty())
      a(paramContext, paramContext.getString(2131363275), "");
  }

  public void a(Context paramContext, ProfileImage paramProfileImage)
  {
    if ((this.b < this.a.size()) && (((FacebookStatus)this.a.get(this.b)).a().mUserId == paramProfileImage.a))
      a(paramContext, (FacebookStatus)this.a.get(this.b), this.b, paramProfileImage.c());
  }

  public void a(Context paramContext, String paramString1, String paramString2)
  {
    RemoteViews localRemoteViews = new RemoteViews(paramContext.getPackageName(), 2130903633);
    localRemoteViews.setTextViewText(2131297990, paramString1);
    localRemoteViews.setTextViewText(2131297991, paramString2);
    Intent localIntent = IntentUriHandler.a(paramContext, "fb://feed");
    localIntent.setFlags(335544320);
    localRemoteViews.setOnClickPendingIntent(2131297989, PendingIntent.getActivity(paramContext, 0, localIntent, 268435456));
    localRemoteViews.setOnClickPendingIntent(2131297988, PendingIntent.getActivity(paramContext, 0, new Intent(paramContext, LoginActivity.class), 268435456));
    ComponentName localComponentName = new ComponentName(paramContext, FacebookWidgetProvider.class);
    AppWidgetManager.getInstance(paramContext).updateAppWidget(localComponentName, localRemoteViews);
  }

  public void a(Context paramContext, List<FacebookStatus> paramList)
  {
    this.a.clear();
    this.a.addAll(paramList);
    this.b = 0;
    if (!this.a.isEmpty())
      i(paramContext);
  }

  public void b(Context paramContext)
  {
    int i = this.a.size();
    if (i == 0);
    while (true)
    {
      return;
      if ((this.b >= 0) && (this.b < i - 1))
      {
        this.b = (1 + this.b);
        i(paramContext);
        continue;
      }
      if (this.b != i - 1)
        continue;
    }
  }

  public void c(Context paramContext)
  {
    if (this.a.size() == 0);
    while (true)
    {
      return;
      if ((this.b != 0) && (this.b > 0))
      {
        this.b = (-1 + this.b);
        i(paramContext);
        continue;
      }
    }
  }

  public boolean d(Context paramContext)
  {
    if (AppWidgetManager.getInstance(paramContext).getAppWidgetIds(new ComponentName(paramContext, FacebookWidgetProvider.class)).length != 0);
    for (int i = 1; ; i = 0)
      return i;
  }

  public void e(Context paramContext)
  {
    this.a.addAll(j(paramContext));
    this.b = 0;
    g(paramContext);
  }

  public void f(Context paramContext)
  {
    this.a.clear();
    a(paramContext, paramContext.getString(2131363277), paramContext.getString(2131363276));
  }

  public void g(Context paramContext)
  {
    if (this.a.isEmpty())
      a(paramContext, paramContext.getString(2131363278), "");
    while (true)
    {
      return;
      i(paramContext);
    }
  }

  public void h(Context paramContext)
  {
    RemoteViews localRemoteViews = new RemoteViews(paramContext.getPackageName(), 2130903634);
    Intent localIntent1 = new Intent(paramContext, ComposerActivity.class);
    localIntent1.setAction("openComposer");
    localIntent1.setFlags(335544320);
    localRemoteViews.setOnClickPendingIntent(2131297993, PendingIntent.getActivity(paramContext, 0, localIntent1, 268435456));
    Intent localIntent2 = new Intent(paramContext, MediaPickerActivity.class);
    localIntent2.setAction("openPhoto");
    localIntent2.setFlags(335544320);
    localRemoteViews.setOnClickPendingIntent(2131297994, PendingIntent.getActivity(paramContext, 0, localIntent2, 268435456));
    Intent localIntent3 = new Intent(paramContext, ComposerActivity.class);
    localIntent3.setAction("openCheckin");
    localIntent3.putExtra("extra_is_checkin", true);
    localIntent3.setFlags(335544320);
    localRemoteViews.setOnClickPendingIntent(2131297995, PendingIntent.getActivity(paramContext, 0, localIntent3, 268435456));
    ComponentName localComponentName = new ComponentName(paramContext, FacebookControlWidgetProvider.class);
    AppWidgetManager.getInstance(paramContext).updateAppWidget(localComponentName, localRemoteViews);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.binding.Widget
 * JD-Core Version:    0.6.0
 */