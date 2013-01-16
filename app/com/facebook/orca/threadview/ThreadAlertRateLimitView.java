package com.facebook.orca.threadview;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.compose.ComposeMode;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.notify.NotificationSetting;
import com.facebook.orca.notify.NotificationSettingsUtil;
import com.facebook.orca.prefs.MessagesPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.orca.prefs.PrefKey;
import com.facebook.orca.prefs.UiCounters;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.MessagesCollection;
import com.facebook.orca.threads.ParticipantInfo;
import com.facebook.orca.users.UserKey;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;

public class ThreadAlertRateLimitView extends CustomFrameLayout
{
  private OrcaSharedPreferences a;
  private NotificationSettingsUtil b;
  private DataCache c;
  private UiCounters d;
  private OrcaSharedPreferences.OnSharedPreferenceChangeListener e;
  private String f;
  private PrefKey g;
  private MessagesCollection h;
  private ComposeMode i = ComposeMode.SHRUNK;

  public ThreadAlertRateLimitView(Context paramContext)
  {
    super(paramContext);
    a();
  }

  public ThreadAlertRateLimitView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }

  public ThreadAlertRateLimitView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }

  private void a(PrefKey paramPrefKey)
  {
    if ((MessagesPrefKeys.m.equals(paramPrefKey)) || (paramPrefKey.equals(this.g)))
      c();
  }

  private void b()
  {
    this.d.c("thread_mute_rate_limit_dismissed");
    c();
  }

  private void c()
  {
    if (d());
    for (int j = 0; ; j = 8)
    {
      setVisibility(j);
      return;
    }
  }

  private boolean d()
  {
    long l = System.currentTimeMillis();
    boolean bool1 = l - this.d.b("thread_mute_rate_limit_dismissed") < 86400000L;
    int j = 0;
    if (bool1);
    while (true)
    {
      return j;
      ComposeMode localComposeMode1 = this.i;
      ComposeMode localComposeMode2 = ComposeMode.EXPANDED;
      j = 0;
      if (localComposeMode1 == localComposeMode2)
        continue;
      NotificationSetting localNotificationSetting1 = this.b.a();
      NotificationSetting localNotificationSetting2 = this.b.a(this.f);
      boolean bool2 = this.b.a(localNotificationSetting1);
      j = 0;
      if (!bool2)
        continue;
      boolean bool3 = this.b.a(localNotificationSetting2);
      j = 0;
      if (!bool3)
        continue;
      int k = this.d.a("thread_mute");
      j = 0;
      if (k > 5)
        continue;
      int m = this.d.a("thread_mute", this.f);
      j = 0;
      if (m >= 2)
        continue;
      boolean bool4 = l - this.d.b("thread_mute", this.f) < 86400000L;
      j = 0;
      if (bool4)
        continue;
      boolean bool5 = e();
      j = 0;
      if (!bool5)
        continue;
      j = 1;
    }
  }

  private boolean e()
  {
    MessagesCollection localMessagesCollection = this.h;
    int j = 0;
    if (localMessagesCollection == null);
    UserKey localUserKey;
    do
    {
      return j;
      localUserKey = this.c.b();
      j = 0;
    }
    while (localUserKey == null);
    long l = System.currentTimeMillis() - 180000L;
    Iterator localIterator = this.h.b().iterator();
    int k = 0;
    label51: if (localIterator.hasNext())
    {
      Message localMessage = (Message)localIterator.next();
      if (localMessage.c() > l)
        if (Objects.equal(localMessage.f().e(), localUserKey))
          break label137;
    }
    label137: for (int m = k + 1; ; m = k)
    {
      if (m >= 10)
      {
        k = m;
        j = 0;
        if (k < 10)
          break;
        j = 1;
        break;
      }
      k = m;
      break label51;
    }
  }

  public void a()
  {
    FbInjector localFbInjector = getInjector();
    this.a = ((OrcaSharedPreferences)localFbInjector.a(OrcaSharedPreferences.class));
    this.b = ((NotificationSettingsUtil)localFbInjector.a(NotificationSettingsUtil.class));
    this.c = ((DataCache)localFbInjector.a(DataCache.class));
    this.d = ((UiCounters)localFbInjector.a(UiCounters.class));
    setContentView(2130903403);
    setOnClickListener(new ThreadAlertRateLimitView.1(this));
    this.e = new ThreadAlertRateLimitView.2(this);
    this.a.a(this.e);
  }

  public void setComposeMode(ComposeMode paramComposeMode)
  {
    this.i = paramComposeMode;
    c();
  }

  void setMessages(MessagesCollection paramMessagesCollection)
  {
    this.h = paramMessagesCollection;
    c();
  }

  void setThreadId(String paramString)
  {
    this.f = paramString;
    this.g = MessagesPrefKeys.a(paramString);
    c();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadAlertRateLimitView
 * JD-Core Version:    0.6.0
 */