package com.facebook.katana.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.analytics.AnalyticsActivityContentUri;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.ManualAnalyticsNavigationActivity;
import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.diagnostics.FPSSupport;
import com.facebook.feed.activity.FbChromeActivityFragmentFactory;
import com.facebook.feed.renderer.recycle.FeedRecyclableViewPoolManager;
import com.facebook.katana.activity.faceweb.FacewebFragment;
import com.facebook.katana.activity.faceweb.FacewebFragment.PrimaryActionDisplayType;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSession.LoginStatus;
import com.facebook.katana.fragment.FacebookFragment;
import com.facebook.katana.model.FacebookAffiliation;
import com.facebook.katana.service.autoupdate.AutoUpdateNotifier;
import com.facebook.katana.service.autoupdate.AutoUpdateServiceStarter;
import com.facebook.katana.service.method.PlacesTellServerLastLocation;
import com.facebook.katana.util.FBLocationManager;
import com.facebook.katana.util.FBLocationManager.FBLocationListener;
import com.facebook.katana.util.GrowthUtils;
import com.facebook.katana.util.IntentUtils;
import com.facebook.katana.util.Utils;
import com.facebook.katana.webview.FacewebWebView;
import com.facebook.orca.activity.DivebarEnabledActivity;
import com.facebook.orca.common.ui.titlebar.DivebarController;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpec;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpecBuilder;
import com.facebook.orca.inject.FbInjector;
import com.facebook.photos.photogallery.GalleryLauncher;
import com.facebook.photos.photogallery.GalleryLauncherHost;
import com.facebook.widget.listview.recycle.FbListItemViewPoolManager;
import com.facebook.widget.listview.recycle.ViewPoolCleaner;
import com.facebook.widget.menu.CustomMenuActivity;
import com.facebook.widget.menu.CustomMenuActivityNeedsHandler;
import com.facebook.widget.menu.CustomMenuItem;
import java.util.Stack;

@FPSSupport
public class FbFragmentChromeActivity extends BaseFacebookActivity
  implements AnalyticsActivity, AnalyticsActivityContentUri, ManualAnalyticsNavigationActivity, FBLocationManager.FBLocationListener, DivebarEnabledActivity, GalleryLauncherHost, ViewPoolCleaner, CustomMenuActivity
{
  private final Stack<Intent> n = new Stack();
  private Intent o;
  private DivebarController p;
  private FbChromeActivityFragmentFactory q;
  private GalleryLauncher r;

  private static boolean a(String paramString)
  {
    if (paramString == null);
    for (boolean bool = false; ; bool = paramString.startsWith("fb://feed"))
      return bool;
  }

  private void o()
  {
    ((AutoUpdateNotifier)C().a(AutoUpdateNotifier.class)).a(this);
    if ((FacebookAffiliation.b()) && (Build.VERSION.SDK_INT >= 14))
      ((AutoUpdateServiceStarter)C().a(AutoUpdateServiceStarter.class)).a();
  }

  private void p()
  {
    Intent localIntent = getIntent();
    if (this.o != localIntent)
    {
      this.n.push(localIntent);
      setIntent(this.o);
    }
    Fragment localFragment1 = this.q.a(this.o);
    FragmentManager localFragmentManager = g();
    FragmentTransaction localFragmentTransaction = localFragmentManager.a().b(2131296394, localFragment1, "chromed:content:fragment:tag").a(null);
    Fragment localFragment2 = a(localFragmentManager, "chromeless:content:fragment:tag");
    if (localFragment2 != null)
      localFragmentTransaction.a(localFragment2);
    localFragmentTransaction.a();
    this.o = null;
  }

  private Fragment q()
  {
    return a(g(), "chromed:content:fragment:tag");
  }

  private void r()
  {
    Fragment localFragment = q();
    if (this.p == null);
    while (true)
    {
      return;
      if ((1 == getIntent().getIntExtra("target_fragment", -1)) || (a(b())))
      {
        a(TitleBarButtonSpec.newBuilder().a(1).a(getResources().getDrawable(2130838593)).i());
        t().a(new FbFragmentChromeActivity.1(this));
        if ((localFragment instanceof FacewebFragment))
          ((FacewebFragment)localFragment).a(FacewebFragment.PrimaryActionDisplayType.NONE);
        this.p.a(this);
        continue;
      }
    }
  }

  public void K()
  {
    t().q();
    Fragment localFragment = q();
    if ((localFragment instanceof CustomMenuActivity))
    {
      if ((localFragment instanceof CustomMenuActivityNeedsHandler))
        ((CustomMenuActivityNeedsHandler)localFragment).a(this);
      ((CustomMenuActivity)localFragment).K();
    }
  }

  public String a()
  {
    Fragment localFragment = q();
    if ((localFragment instanceof CustomMenuActivity));
    for (String str = ((CustomMenuActivity)localFragment).a(); ; str = null)
      return str;
  }

  public void a(Location paramLocation)
  {
    if (paramLocation != null)
    {
      AppSession localAppSession = AppSession.a(this, false);
      if ((localAppSession != null) && (localAppSession.i() == AppSession.LoginStatus.STATUS_LOGGED_IN))
      {
        PlacesTellServerLastLocation.b(this, paramLocation);
        FBLocationManager.a(this);
      }
    }
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (paramBundle == null)
      this.o = getIntent();
    setContentView(2130903211);
    FbInjector localFbInjector = C();
    this.p = ((DivebarController)localFbInjector.a(DivebarController.class));
    this.q = ((FbChromeActivityFragmentFactory)localFbInjector.a(FbChromeActivityFragmentFactory.class));
    this.r = ((GalleryLauncher)f(2131296902));
    this.r.a(g(), findViewById(2131296901));
    String str1 = getIntent().getStringExtra("mobile_page");
    if (str1 != null)
    {
      String str2 = "FacewebChromeLoad." + str1;
      this.w.a(str2);
    }
  }

  public void a(CustomMenuItem paramCustomMenuItem)
  {
    Fragment localFragment = q();
    if ((localFragment instanceof CustomMenuActivity))
      ((CustomMenuActivity)localFragment).a(paramCustomMenuItem);
  }

  protected void a_(Bundle paramBundle)
  {
    super.a_(paramBundle);
    this.w.a("FB4AChromeCreate");
  }

  public String b()
  {
    return Utils.a(this);
  }

  public void d()
  {
    a(this);
  }

  public void i()
  {
    FbInjector localFbInjector = C();
    ((FeedRecyclableViewPoolManager)localFbInjector.a(FeedRecyclableViewPoolManager.class)).a();
    ((FbListItemViewPoolManager)localFbInjector.a(FbListItemViewPoolManager.class)).a();
  }

  public FacewebWebView j()
  {
    Fragment localFragment = q();
    if ((localFragment instanceof FacewebFragment));
    for (FacewebWebView localFacewebWebView = ((FacewebFragment)localFragment).M(); ; localFacewebWebView = null)
      return localFacewebWebView;
  }

  public void k()
  {
  }

  public boolean l()
  {
    int i = 1;
    if (y())
      i = 0;
    while (true)
    {
      return i;
      FragmentManager localFragmentManager = g();
      if ((!this.n.isEmpty()) && (localFragmentManager.f() > i))
      {
        setIntent((Intent)this.n.pop());
        localFragmentManager.e();
        r();
        t().l();
        ((AnalyticsLogger)C().a(AnalyticsLogger.class)).a(this);
        i = 0;
        continue;
      }
      finish();
    }
  }

  public DivebarController m()
  {
    return this.p;
  }

  public GalleryLauncher n()
  {
    return this.r;
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Fragment localFragment = q();
    if (localFragment != null)
      localFragment.a(paramInt1, paramInt2, paramIntent);
  }

  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    getWindow().setFormat(1);
  }

  public void onBackPressed()
  {
    if (isFinishing());
    while (true)
    {
      return;
      if (!this.p.e())
      {
        if (this.r.a())
        {
          this.r.b();
          continue;
        }
        l();
        continue;
      }
    }
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.p != null)
      this.p.d();
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    t().k();
    if (this.p != null)
      this.p.i();
    if (IntentUtils.a(paramIntent, getIntent(), new String[] { "extra_launch_uri" }))
    {
      Fragment localFragment = q();
      if ((localFragment instanceof FacebookFragment))
      {
        ((FacebookFragment)localFragment).c();
        t().k();
      }
    }
    while (true)
    {
      return;
      this.o = paramIntent;
      if (!g().c())
        continue;
      p();
    }
  }

  protected void onPause()
  {
    super.onPause();
    this.w.c("FB4AChromeCreate");
    FBLocationManager.a(this);
  }

  protected void onResume()
  {
    this.w.a("FB4AFbFragmentChromeActivityResume");
    super.onResume();
    this.w.b("FB4AChromeCreate");
    a(null);
    GrowthUtils.a().b(this);
    r();
    if (u())
      new FbFragmentChromeActivity.AddLocationListenerIfNeededTask(this, null).execute(new Void[0]);
    o();
    ((AnalyticsLogger)C().a(AnalyticsLogger.class)).a(this);
    this.w.b("FB4AFbFragmentChromeActivityResume");
  }

  protected void onStart()
  {
    super.onStart();
    if (this.o != null)
      p();
  }

  protected void onStop()
  {
    super.onStop();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.FbFragmentChromeActivity
 * JD-Core Version:    0.6.0
 */