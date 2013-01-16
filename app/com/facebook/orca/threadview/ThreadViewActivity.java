package com.facebook.orca.threadview;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.activity.ExportMenuToFbHostActivity;
import com.facebook.orca.activity.ExportMenuToFbHostActivity.CustomFbHostMenuItem;
import com.facebook.orca.activity.FbFragmentActivity;
import com.facebook.orca.attachments.AudioRecorder;
import com.facebook.orca.audio.AudioClipPlayerQueue;
import com.facebook.orca.common.ui.titlebar.DivebarController;
import com.facebook.orca.common.ui.titlebar.FbTitleBar;
import com.facebook.orca.common.ui.titlebar.FbTitleBarUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.intents.MessagingIntents;
import com.facebook.orca.nux.OrcaNuxManager;
import com.facebook.orca.nux.ThreadNuxController;
import com.facebook.orca.nux.ThreadTitleNuxView;
import java.util.List;

public class ThreadViewActivity extends FbFragmentActivity
  implements AnalyticsActivity, ExportMenuToFbHostActivity
{
  private ThreadViewFragment n;
  private ThreadTitleNuxView o;
  private ThreadNuxController p;
  private AnalyticsLogger q;
  private DivebarController r;
  private AudioClipPlayerQueue s;
  private AudioRecorder t;

  public String a()
  {
    return "thread_view";
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903415);
    FbInjector localFbInjector = C();
    this.q = ((AnalyticsLogger)localFbInjector.a(AnalyticsLogger.class));
    this.r = ((DivebarController)localFbInjector.a(DivebarController.class));
    this.s = ((AudioClipPlayerQueue)localFbInjector.a(AudioClipPlayerQueue.class));
    this.t = ((AudioRecorder)localFbInjector.a(AudioRecorder.class));
    FbTitleBarUtil.a(this);
    this.o = ((ThreadTitleNuxView)f(2131297486));
    this.p = new ThreadNuxController((OrcaNuxManager)C().a(OrcaNuxManager.class));
    this.p.a(this, getIntent().getStringExtra("thread_id"), this.o);
    this.n = ((ThreadViewFragment)g().a(2131297485));
    this.n.a((FbTitleBar)f(2131296299));
    this.n.a(getIntent().getStringExtra("thread_id"));
    Intent localIntent = getIntent();
    if (MessagingIntents.a(localIntent, "from_notification", false))
      this.n.c();
    if (MessagingIntents.a(localIntent, "focus_compose", false))
      this.n.d();
    this.n.a(MessagingIntents.a(localIntent));
    this.n.c(getIntent().getStringExtra("override_access_token"));
    this.r.a(this);
    getWindow().getDecorView().setBackgroundDrawable(new ColorDrawable(Color.rgb(255, 255, 255)));
  }

  public void a_(int paramInt)
  {
    this.n.a_(paramInt);
  }

  public List<ExportMenuToFbHostActivity.CustomFbHostMenuItem> b()
  {
    return this.n.b();
  }

  public String i()
  {
    return this.n.M();
  }

  public void onBackPressed()
  {
    if (this.r.e());
    while (true)
    {
      return;
      if (!this.n.N())
      {
        super.onBackPressed();
        continue;
      }
    }
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.r != null)
      this.r.d();
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getKeyCode() == 4))
      this.q.a(new HoneyClientEvent("click").d(a()).e("android_button").f("back"));
    if ((this.n.a(paramInt, paramKeyEvent)) || (super.onKeyDown(paramInt, paramKeyEvent)));
    for (int i = 1; ; i = 0)
      return i;
  }

  protected void onPause()
  {
    super.onPause();
    this.s.a();
    this.t.a();
  }

  protected void onResume()
  {
    super.onResume();
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      String str = MessagingIntents.a(localIntent, "trigger");
      if (str != null)
        this.q.a(new HoneyClientEvent("show_module").d(a()).h(e()).b("trigger", str));
      this.n.d(str);
    }
  }

  public void onUserInteraction()
  {
    super.onUserInteraction();
    if (this.n != null)
      this.n.L();
  }

  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    this.n.b(paramBoolean);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadViewActivity
 * JD-Core Version:    0.6.0
 */