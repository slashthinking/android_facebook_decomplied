package com.facebook.orca.sms;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri.Builder;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.OnSharedPreferenceChangeListener;

public class MmsSmsLogger
{
  private final AnalyticsLogger a;
  private final Context b;
  private final PackageManager c;
  private final OrcaSharedPreferences.OnSharedPreferenceChangeListener d;

  public MmsSmsLogger(Context paramContext, AnalyticsLogger paramAnalyticsLogger, PackageManager paramPackageManager, OrcaSharedPreferences paramOrcaSharedPreferences)
  {
    this.b = paramContext;
    this.a = paramAnalyticsLogger;
    this.c = paramPackageManager;
    this.d = new MmsSmsLogger.1(this);
    paramOrcaSharedPreferences.a(this.d);
  }

  private String d()
  {
    ResolveInfo localResolveInfo = this.c.resolveActivity(new Intent("android.intent.action.SENDTO", new Uri.Builder().scheme("smsto").build()), 65536);
    if (localResolveInfo == null);
    for (String str = null; ; str = localResolveInfo.activityInfo.packageName)
      return str;
  }

  public void a()
  {
    this.a.b(new HoneyClientEvent("mms_received"));
  }

  public void a(int paramInt)
  {
    this.a.b(new HoneyClientEvent("sms_sent_not_in_app").a("num", paramInt));
  }

  public void a(int paramInt, boolean paramBoolean)
  {
    this.a.b(new HoneyClientEvent("sms_tcreate").a("num_users", paramInt).a("success", paramBoolean));
  }

  public void a(String paramString)
  {
    this.a.b(new HoneyClientEvent("sms_send_timeout").b("thread_id", paramString));
  }

  public void a(String paramString, int paramInt)
  {
    this.a.b(new HoneyClientEvent("sms_delivered").b("thread_id", paramString).a("resultCode", paramInt));
  }

  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean)
  {
    this.a.b(new HoneyClientEvent("mms_sent").b("thread_id", paramString1).a("attachNum", paramInt2).b("attachType", paramString2).a("numUsers", paramInt1).a("success", paramBoolean));
  }

  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    this.a.b(new HoneyClientEvent("mms_sent").b("thread_id", paramString).a("numUsers", paramInt).a("success", paramBoolean));
  }

  public void a(String paramString, long paramLong, boolean paramBoolean)
  {
    this.a.b(new HoneyClientEvent("mms_received_downloaded").b("thread_id", paramString).a("message_id", paramLong).a("success", paramBoolean));
  }

  public void a(String paramString, boolean paramBoolean)
  {
    this.a.b(new HoneyClientEvent("sms_received").b("thread_id", paramString).a("success", paramBoolean));
  }

  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    this.a.b(new HoneyClientEvent("sms_sent").b("thread_id", paramString).a("success", paramBoolean).a("resultCode", paramInt));
  }

  public void a(boolean paramBoolean)
  {
    this.a.b(new HoneyClientEvent("sms_nux_shown").a("is_upgrading_user", paramBoolean));
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.a.b(new HoneyClientEvent("sms_feature").a("beta_enabled", paramBoolean1).a("beta_enabled_set", paramBoolean2).a("alerts_enabled", paramBoolean3).a("alerts_enabled_set", paramBoolean4));
  }

  public void b()
  {
    String str = d();
    AnalyticsLogger localAnalyticsLogger = this.a;
    HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent("sms_default_app").a("is_default", this.b.getPackageName().equals(str));
    if (str != null);
    for (boolean bool = true; ; bool = false)
    {
      localAnalyticsLogger.b(localHoneyClientEvent.a("has_default", bool));
      return;
    }
  }

  public void b(int paramInt)
  {
    this.a.b(new HoneyClientEvent("mms_sent_not_in_app").a("num", paramInt));
  }

  public void b(String paramString, boolean paramBoolean)
  {
    this.a.b(new HoneyClientEvent("sms_tdelete").b("thread_id", paramString).a("success", paramBoolean));
  }

  public void b(boolean paramBoolean)
  {
    this.a.b(new HoneyClientEvent("sms_enabled_during_nux").a("enabled", paramBoolean));
  }

  public void c()
  {
    this.a.b(new HoneyClientEvent("sms_learn_more_nux_shown"));
  }

  public void c(int paramInt)
  {
    this.a.b(new HoneyClientEvent("sms_received_not_in_app").a("num", paramInt));
  }

  public void c(String paramString, boolean paramBoolean)
  {
    this.a.b(new HoneyClientEvent("sms_mdelete").b("message_id", paramString).a("success", paramBoolean));
  }

  public void d(int paramInt)
  {
    this.a.b(new HoneyClientEvent("mms_received_not_in_app").a("num", paramInt));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.MmsSmsLogger
 * JD-Core Version:    0.6.0
 */