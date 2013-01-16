package com.facebook.contacts.contactcard;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.contacts.contactcard.entry.LabelValueRowView;
import com.facebook.orca.activity.FbFragmentActivity;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.notify.NotificationSetting;
import com.facebook.orca.notify.NotificationSettingsUtil;
import com.facebook.orca.prefs.MessagesPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.prefs.PrefKey;
import com.facebook.orca.prefs.UiCounters;
import com.facebook.orca.threadview.GlobalAlertMessageView;
import java.util.Date;

public class ConversationSettingsView extends SectionView
{
  private final OrcaSharedPreferences a;
  private final NotificationSettingsUtil b;
  private final UiCounters c;
  private final LabelValueRowView d;
  private final GlobalAlertMessageView e;
  private ContactCardFragment.ContactCardListener f;
  private String g;
  private NotificationSetting h;
  private int i;
  private ConversationSettingsView.NotificationsSettingsDialogFragment.NotificationsSettingsDialogListener j;
  private AnalyticsLogger k;

  public ConversationSettingsView(Context paramContext)
  {
    this(paramContext, null);
  }

  public ConversationSettingsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ConversationSettingsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    FbInjector localFbInjector = getInjector();
    this.a = ((OrcaSharedPreferences)localFbInjector.a(OrcaSharedPreferences.class));
    this.b = ((NotificationSettingsUtil)localFbInjector.a(NotificationSettingsUtil.class));
    this.c = ((UiCounters)localFbInjector.a(UiCounters.class));
    this.k = ((AnalyticsLogger)localFbInjector.a(AnalyticsLogger.class));
    this.d = new LabelValueRowView(paramContext);
    this.d.setLabelText(2131362474);
    this.d.setOnClickListener(new ConversationSettingsView.1(this));
    a(this.d, false);
    this.e = new GlobalAlertMessageView(paramContext);
    this.e.setHideableView(this.d);
    a(this.e, false);
    this.j = new ConversationSettingsView.2(this);
  }

  private void a(int paramInt)
  {
    switch (paramInt)
    {
    default:
    case 0:
    case 2:
    case 3:
    case 1:
    }
    while (true)
    {
      PrefKey localPrefKey = MessagesPrefKeys.a(this.g);
      OrcaSharedPreferences.Editor localEditor = this.a.b();
      localEditor.a(localPrefKey, this.h.d());
      localEditor.a();
      this.k.a(new HoneyClientEvent("set").e("notification_settings").b("thread_id", this.g).a("value", paramInt).d("ConverstaionSettingsView"));
      this.c.c("thread_mute");
      this.c.c("thread_mute", this.g);
      a(true);
      return;
      this.h = NotificationSetting.a;
      continue;
      this.h = NotificationSetting.a(3600L + System.currentTimeMillis() / 1000L);
      continue;
      this.h = NotificationSetting.a(this.b.b().getTime() / 1000L);
      continue;
      this.h = NotificationSetting.b;
    }
  }

  private void a(boolean paramBoolean)
  {
    Context localContext = getContext();
    this.e.a();
    Date localDate1;
    if (this.b.b(this.h))
    {
      localDate1 = new Date(1000L * this.h.b());
      if (localDate1.equals(this.b.b()))
      {
        Date localDate2 = this.b.b();
        String str2 = localContext.getString(2131362473, new Object[] { android.text.format.DateFormat.getTimeFormat(localContext).format(localDate2) });
        this.d.setValueText(str2);
        this.i = 3;
      }
    }
    while (true)
    {
      if ((paramBoolean) && (this.f != null))
        this.f.b();
      return;
      if (paramBoolean)
        this.d.setValueText(2131362472);
      while (true)
      {
        this.i = 2;
        break;
        String str1 = localContext.getString(2131362473, new Object[] { android.text.format.DateFormat.getTimeFormat(localContext).format(localDate1) });
        this.d.setValueText(str1);
      }
      if (this.h.a())
      {
        this.d.setValueText(2131362470);
        this.i = 0;
        continue;
      }
      this.d.setValueText(2131362471);
      this.i = 1;
    }
  }

  private void c()
  {
    ConversationSettingsView.NotificationsSettingsDialogFragment localNotificationsSettingsDialogFragment = (ConversationSettingsView.NotificationsSettingsDialogFragment)((FbFragmentActivity)getContext()).g().a("notifications_dialog");
    if (localNotificationsSettingsDialogFragment != null)
    {
      localNotificationsSettingsDialogFragment.a(this.j);
      localNotificationsSettingsDialogFragment.a(this.g, this.i);
    }
  }

  private void d()
  {
    FragmentManager localFragmentManager = ((FbFragmentActivity)getContext()).g();
    ConversationSettingsView.NotificationsSettingsDialogFragment localNotificationsSettingsDialogFragment = new ConversationSettingsView.NotificationsSettingsDialogFragment();
    localNotificationsSettingsDialogFragment.a(this.g, this.i);
    localNotificationsSettingsDialogFragment.a(this.j);
    localNotificationsSettingsDialogFragment.a(localFragmentManager, "notifications_dialog");
  }

  public void a()
  {
    this.h = this.b.a(this.g);
    a(false);
  }

  public void setContactCardListener(ContactCardFragment.ContactCardListener paramContactCardListener)
  {
    this.f = paramContactCardListener;
  }

  public void setThreadId(String paramString)
  {
    this.g = paramString;
    a();
    c();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.contactcard.ConversationSettingsView
 * JD-Core Version:    0.6.0
 */