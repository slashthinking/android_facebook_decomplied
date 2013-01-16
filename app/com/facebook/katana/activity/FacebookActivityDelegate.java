package com.facebook.katana.activity;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.analytics.InteractionLogger;
import com.facebook.analytics.InteractionLogger.ContentFlags;
import com.facebook.analytics.performance.MarkerType;
import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.bugreporter.BugReporter;
import com.facebook.bugreporter.BugReporterRelated;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.common.util.Log;
import com.facebook.debug.Assert;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.katana.FeedComposerActivity;
import com.facebook.katana.HtmlAboutActivity;
import com.facebook.katana.IntentUriHandler;
import com.facebook.katana.LogoutActivity;
import com.facebook.katana.NativeThirdPartyUriHelper;
import com.facebook.katana.SettingsActivity;
import com.facebook.katana.activity.apps.PlatformWebViewDialog;
import com.facebook.katana.activity.faceweb.FacewebAssassin;
import com.facebook.katana.activity.faceweb.FacewebAssassin.BookmarksMenuAssassin;
import com.facebook.katana.annotations.IsFullscreenJewelsEnabled;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSession.LoginStatus;
import com.facebook.katana.binding.JustShakeListener;
import com.facebook.katana.features.bugreporter.Fb4aBugReporterConfig;
import com.facebook.katana.features.bugreporter.annotations.BugReportingNotRequired;
import com.facebook.katana.features.bugreporter.annotations.IsBugReporterAvailable;
import com.facebook.katana.features.faceweb.FacewebUriMap;
import com.facebook.katana.features.faceweb.FacewebUriMap.FacewebUriHandler;
import com.facebook.katana.features.uberbar.UberbarActivity;
import com.facebook.katana.model.FacebookAffiliation;
import com.facebook.katana.model.FacebookNotifications;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.prefs.NotificationPrefKeys;
import com.facebook.katana.service.BackgroundDetectionService;
import com.facebook.katana.service.method.MarkJewelSeen.Jewel;
import com.facebook.katana.service.method.NotificationsGet;
import com.facebook.katana.ui.CustomMenu;
import com.facebook.katana.ui.FullscreenPopupViewDelegate;
import com.facebook.katana.ui.JewelTitleBar;
import com.facebook.katana.ui.ListenableRelativeLayout;
import com.facebook.katana.ui.PopupViewDelegate;
import com.facebook.katana.ui.PopupViewDelegate.PopupState;
import com.facebook.katana.ui.TitleBar;
import com.facebook.katana.ui.TitleBar.OnPrimaryButtonClickListener;
import com.facebook.katana.ui.WindowPopupViewDelegate;
import com.facebook.katana.ui.bookmark.BookmarkMenuController;
import com.facebook.katana.util.DisplayUtils;
import com.facebook.katana.util.EclairKeyHandler;
import com.facebook.katana.util.Utils;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.Modules;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.Parameters;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.UIElements;
import com.facebook.katana.webview.FacewebWebView;
import com.facebook.orca.activity.AbstractFbActivityListener;
import com.facebook.orca.activity.DivebarEnabledActivity;
import com.facebook.orca.activity.ExportMenuToFbHostActivity;
import com.facebook.orca.activity.ExportMenuToFbHostActivity.CustomFbHostMenuItem;
import com.facebook.orca.activity.FbActivityUtils;
import com.facebook.orca.annotations.AuthNotRequired;
import com.facebook.orca.common.ui.titlebar.DivebarController;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpec;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.prefs.SharedPrefKeys;
import com.facebook.orca.threadlist.ThreadListActivity;
import com.facebook.uri.UriTemplateMap;
import com.facebook.uri.UriTemplateMap.InvalidUriException;
import com.facebook.uri.UriTemplateMap.UriMatch;
import com.facebook.widget.ScreenSlider.OnConfigurationChangedListener;
import com.facebook.widget.menu.CustomMenuActivity;
import com.facebook.widget.menu.CustomMenuHandler;
import com.facebook.widget.menu.CustomMenuItem;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;

public class FacebookActivityDelegate extends AbstractFbActivityListener
  implements CustomMenuActivity, CustomMenuHandler
{
  public static Activity a = null;
  public static String b = null;
  private static long h;
  private final FbErrorReporter A;
  private DivebarController B;
  private SensorManager C = null;
  private SensorEventListener D = null;
  private final AndroidThreadUtil E;
  protected final PerformanceLogger c;
  private final OrcaSharedPreferences d;
  private boolean e;
  private String f;
  private String g;
  private Provider<Boolean> i;
  private Provider<Boolean> j;
  private ScreenSlider.OnConfigurationChangedListener k;
  private CustomMenu l;
  private Map<Integer, CustomMenuItem> m = new LinkedHashMap();
  private Handler n = new Handler();
  private TitleBar o;
  private BookmarkMenuController p = null;
  private PopupViewDelegate q = null;
  private PopupViewDelegate.PopupState r = PopupViewDelegate.PopupState.CLOSED;
  private boolean s = true;
  private final Activity t;
  private final FbInjector u;
  private final Handler v;
  private FacewebAssassin w;
  private Long x = null;
  private Map<Integer, String> y = new HashMap();
  private final InteractionLogger z;

  public FacebookActivityDelegate(Activity paramActivity)
  {
    Preconditions.checkNotNull(paramActivity);
    this.t = paramActivity;
    this.u = FbInjector.a(this.t);
    this.v = new Handler();
    this.z = new InteractionLogger(paramActivity);
    this.i = this.u.b(Boolean.class, IsBugReporterAvailable.class);
    this.j = this.u.b(Boolean.class, IsFullscreenJewelsEnabled.class);
    this.d = ((OrcaSharedPreferences)this.u.a(OrcaSharedPreferences.class));
    this.c = ((PerformanceLogger)this.u.a(PerformanceLogger.class));
    this.A = ((FbErrorReporter)this.u.a(FbErrorReporter.class));
    this.E = ((AndroidThreadUtil)this.u.a(AndroidThreadUtil.class));
    this.C = ((SensorManager)this.t.getSystemService("sensor"));
  }

  private void A()
  {
    new FacebookActivityDelegate.BadgeCountTask(this).execute(new Void[0]);
  }

  private void B()
  {
    this.v.postDelayed(new FacebookActivityDelegate.5(this), 300000L);
  }

  private void C()
  {
    DisplayUtils.a(this.t, 2131296299, 2131230821);
    DisplayUtils.a(this.t, 2131297764, 2131230810);
    DisplayUtils.a(this.t, 2131296898, 2131230967);
    DisplayUtils.a(this.t, 2131297942, 2131230967);
  }

  private void D()
  {
    if (this.l != null)
      this.l.a(new ArrayList(this.m.values()));
  }

  private DivebarController E()
  {
    if ((this.t instanceof DivebarEnabledActivity));
    for (DivebarController localDivebarController = ((DivebarEnabledActivity)this.t).m(); ; localDivebarController = this.B)
      return localDivebarController;
  }

  private String a(String paramString)
  {
    UriTemplateMap localUriTemplateMap = FacewebUriMap.a(this.t);
    Object localObject;
    if (localUriTemplateMap != null)
      try
      {
        UriTemplateMap.UriMatch localUriMatch = localUriTemplateMap.a(paramString);
        if (localUriMatch == null)
        {
          localObject = null;
          break label99;
        }
        String str = ((FacewebUriMap.FacewebUriHandler)localUriMatch.a).a(this.t, localUriMatch.b).getExtras().getString("mobile_page");
        localObject = str;
      }
      catch (UriTemplateMap.InvalidUriException localInvalidUriException)
      {
        ErrorReporting.a(j(), "Error while getting mobile page url from URL=" + paramString, localInvalidUriException);
      }
    else
      localObject = null;
    label99: return localObject;
  }

  private void a(int paramInt)
  {
    if (this.y.containsKey(Integer.valueOf(paramInt)))
    {
      String str = (String)this.y.get(Integer.valueOf(paramInt));
      if (str != null)
        IntentUriHandler.b(this.t, str);
    }
  }

  private void a(HoneyClientEvent paramHoneyClientEvent)
  {
    if (this.q != null)
      paramHoneyClientEvent.a(FB4A_AnalyticEntities.Parameters.c, this.q.d());
  }

  private void a(MarkJewelSeen.Jewel paramJewel)
  {
    int i2;
    switch (FacebookActivityDelegate.13.a[paramJewel.ordinal()])
    {
    default:
      i2 = 0;
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      if (i2 > 0)
        NotificationsGet.a(this.t, paramJewel);
      f();
      return;
      i2 = NotificationsGet.a(this.t).a();
      continue;
      i2 = NotificationsGet.a(this.t).d();
      continue;
      int i1 = NotificationsGet.a(this.t).c();
      ((OrcaSharedPreferences)this.u.a(OrcaSharedPreferences.class)).b().a(NotificationPrefKeys.b, 0).a();
      i2 = i1;
    }
  }

  private void a(DivebarController paramDivebarController)
  {
    paramDivebarController.a(new FacebookActivityDelegate.10(this));
    paramDivebarController.a(new FacebookActivityDelegate.11(this));
  }

  private boolean a(AppSession paramAppSession)
  {
    int i1 = 0;
    if (paramAppSession == null);
    while (true)
    {
      return i1;
      boolean bool1 = paramAppSession.c();
      i1 = 0;
      if (!bool1)
        continue;
      Long localLong = Long.valueOf(paramAppSession.b().userId);
      i1 = 0;
      if (localLong == null)
        continue;
      if (this.x == null)
        this.x = localLong;
      boolean bool2 = this.x.equals(localLong);
      i1 = 0;
      if (bool2)
        continue;
      i1 = 1;
    }
  }

  private boolean a(PopupViewDelegate.PopupState paramPopupState, String paramString, boolean paramBoolean)
  {
    String str = a(paramString);
    int i1;
    if ((str == null) && (WindowPopupViewDelegate.a(paramPopupState)))
    {
      ErrorReporting.a("Popovers", "URIMap has no entry for popover URI " + paramString, true);
      i1 = 0;
      return i1;
    }
    if (((0xF & this.t.getResources().getConfiguration().screenLayout) != 1) || (((Boolean)this.j.b()).booleanValue()))
    {
      if (this.q == null)
        y();
      this.q.a(this.t, paramPopupState, str, paramBoolean);
    }
    while (true)
    {
      i1 = 1;
      break;
      Intent localIntent = IntentUriHandler.a(this.t, paramString);
      localIntent.putExtra("faceweb_modal", true);
      NativeThirdPartyUriHelper.a(this.t, localIntent);
      this.t.startActivity(localIntent);
      this.t.overridePendingTransition(2130968592, 2130968593);
    }
  }

  private boolean a(ExportMenuToFbHostActivity paramExportMenuToFbHostActivity)
  {
    List localList = paramExportMenuToFbHostActivity.b();
    if (localList == null);
    for (int i1 = 0; ; i1 = 1)
    {
      return i1;
      q();
      Iterator localIterator = localList.iterator();
      if (!localIterator.hasNext())
        continue;
      ExportMenuToFbHostActivity.CustomFbHostMenuItem localCustomFbHostMenuItem = (ExportMenuToFbHostActivity.CustomFbHostMenuItem)localIterator.next();
      if (localCustomFbHostMenuItem.c > 0);
      for (int i2 = localCustomFbHostMenuItem.c; ; i2 = 2130838831)
      {
        a(localCustomFbHostMenuItem.a, localCustomFbHostMenuItem.b, i2);
        a(localCustomFbHostMenuItem.a, localCustomFbHostMenuItem.d);
        if (localCustomFbHostMenuItem.e == null)
          break;
        this.y.put(Integer.valueOf(localCustomFbHostMenuItem.a), localCustomFbHostMenuItem.e);
        break;
      }
    }
  }

  private Point b(MarkJewelSeen.Jewel paramJewel)
  {
    View localView = c().a(paramJewel);
    int[] arrayOfInt = new int[2];
    localView.getLocationOnScreen(arrayOfInt);
    Resources localResources = this.t.getResources();
    float f1 = localResources.getDimension(2131230911);
    float f2;
    if (((Boolean)this.j.b()).booleanValue())
      f2 = localResources.getDimension(2131230971);
    while (true)
    {
      return new Point((int)(arrayOfInt[0] + (localView.getWidth() - f1) / 2.0F), (int)f2);
      f2 = localResources.getDimension(2131230968);
    }
  }

  private void b(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((!this.t.getIntent().getBooleanExtra("within_tab", false)) && (c() != null))
    {
      c().setJewelCount(MarkJewelSeen.Jewel.INBOX, NotificationsGet.a(this.t).d());
      c().setJewelCount(MarkJewelSeen.Jewel.FRIEND_REQUESTS, NotificationsGet.a(this.t).b());
      c().setJewelCount(MarkJewelSeen.Jewel.NOTIFICATIONS, NotificationsGet.a(this.t).c());
    }
  }

  private void b(AppSession paramAppSession)
  {
    this.E.a(new FacebookActivityDelegate.6(this), 1000L);
  }

  private void i(Activity paramActivity)
  {
    if (((paramActivity instanceof NotNewNavEnabled)) || (c() == null) || (this.t.getIntent().getBooleanExtra("within_tab", false)))
      this.s = false;
    if (this.s)
    {
      this.p = ((BookmarkMenuController)this.u.a(BookmarkMenuController.class));
      this.p.a(this.t, new FacebookActivityDelegate.BookmarkMenuHostImpl(this, null));
      this.p.a(new FacebookActivityDelegate.1(this));
    }
  }

  private void n(Activity paramActivity)
  {
    String str1 = paramActivity.getLocalClassName();
    String str4;
    if ((paramActivity instanceof FbFragmentChromeActivity))
    {
      String str3 = ((FbFragmentChromeActivity)paramActivity).b();
      if (str3 != null)
      {
        str4 = str3.replaceAll("[\\d]+", "X");
        if (str4.length() > 35)
          str4 = str4.substring(0, 35);
      }
    }
    for (String str2 = str1 + " | " + str4; ; str2 = str1)
    {
      this.A.c(str2);
      return;
    }
  }

  private boolean o(Activity paramActivity)
  {
    if ((paramActivity.getClass().getAnnotation(BugReportingNotRequired.class) == null) && (((Boolean)this.i.b()).booleanValue()));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  private boolean v()
  {
    if ((this.p != null) && (this.p.k()))
      this.p.h();
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  private boolean w()
  {
    boolean bool = true;
    if ((this.q != null) && (this.q.d()))
      this.q.a(this.t, bool);
    while (true)
    {
      return bool;
      if ((this.s) && (v()))
        continue;
      if ((this.B != null) && (this.B.a()))
      {
        this.B.e();
        continue;
      }
      this.z.a("back_button", "android_button", null);
      bool = false;
    }
  }

  private void x()
  {
    JewelTitleBar localJewelTitleBar = (JewelTitleBar)Preconditions.checkNotNull(c());
    if (AppSession.a(this.t, false) != null)
      A();
    localJewelTitleBar.setJewelClickListener(new FacebookActivityDelegate.2(this));
  }

  private void y()
  {
    monitorenter;
    while (true)
    {
      ViewGroup localViewGroup;
      try
      {
        PopupViewDelegate localPopupViewDelegate = this.q;
        if (localPopupViewDelegate != null)
          return;
        localViewGroup = (ViewGroup)this.t.findViewById(16908290);
        if (((Boolean)this.j.b()).booleanValue())
        {
          this.q = new FullscreenPopupViewDelegate(this.t, localViewGroup, new Handler(), z());
          this.q.a(new FacebookActivityDelegate.3(this));
          View localView = this.t.findViewById(2131296299);
          if (!(localView instanceof ListenableRelativeLayout))
            continue;
          ((ListenableRelativeLayout)localView).setOnLayoutChangedListener(new FacebookActivityDelegate.4(this));
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      this.q = new WindowPopupViewDelegate(this.t, localViewGroup, new Handler(), z());
    }
  }

  private ImmutableMap<PopupViewDelegate.PopupState, Point> z()
  {
    return ImmutableMap.a(PopupViewDelegate.PopupState.FRIEND_REQUESTS, b(MarkJewelSeen.Jewel.FRIEND_REQUESTS), PopupViewDelegate.PopupState.MESSAGES, b(MarkJewelSeen.Jewel.INBOX), PopupViewDelegate.PopupState.NOTIFICATIONS, b(MarkJewelSeen.Jewel.NOTIFICATIONS));
  }

  public void K()
  {
    boolean bool1 = true;
    if (SettingsActivity.a(this.t))
      this.m.clear();
    for (boolean bool2 = bool1; ; bool2 = false)
    {
      AppSession localAppSession = AppSession.a(this.t, false);
      boolean bool3;
      if ((localAppSession != null) && (localAppSession.i() == AppSession.LoginStatus.STATUS_LOGGED_IN))
      {
        bool3 = bool1;
        if ((this.m.get(Integer.valueOf(1001)) == null) && (bool3) && (!(this.t instanceof SettingsActivity)))
          a(1001, 2131362963, 2130838831);
        if ((this.s) && (this.m.get(Integer.valueOf(1003)) == null) && (bool3) && (!bool2))
          a(1003, 2131362961, 2130838826);
        if (this.m.get(Integer.valueOf(1002)) == null)
          a(1002, 2131362973, 2130838825);
        if ((this.t instanceof HtmlAboutActivity))
          break label330;
      }
      while (true)
      {
        a(1002, bool1);
        if ((this.m.get(Integer.valueOf(1004)) == null) && (FacebookAffiliation.c()) && (!bool2))
          a(1004, 2131362846, 17301560);
        if ((this.m.get(Integer.valueOf(1005)) == null) && (o(this.t)) && (!(this.t instanceof BugReporterRelated)) && (!bool2))
          a(1005, 2131362008, 2130838823);
        this.y.clear();
        if ((this.t instanceof ExportMenuToFbHostActivity))
          a((ExportMenuToFbHostActivity)this.t);
        D();
        return;
        bool3 = false;
        break;
        label330: bool1 = false;
      }
    }
  }

  public Dialog a(Activity paramActivity, int paramInt)
  {
    switch (paramInt)
    {
    default:
    case 684737812:
    }
    for (PlatformWebViewDialog localPlatformWebViewDialog = null; ; localPlatformWebViewDialog = new PlatformWebViewDialog(this.t, 2131492960))
      return localPlatformWebViewDialog;
  }

  public Intent a(Uri paramUri, Bundle paramBundle, long paramLong)
  {
    AppSession localAppSession = AppSession.b(this.t, false);
    if ((localAppSession == null) || (paramLong == localAppSession.b().userId))
      paramLong = -1L;
    return ((IFeedIntentBuilder)this.u.a(IFeedIntentBuilder.class)).a(paramUri, paramBundle, paramLong);
  }

  public Boolean a(Activity paramActivity, int paramInt, KeyEvent paramKeyEvent)
  {
    Boolean localBoolean;
    if (paramInt == 4)
      if ((this.l != null) && (this.l.a()))
      {
        this.l.c();
        localBoolean = Boolean.valueOf(true);
      }
    while (true)
    {
      return localBoolean;
      if (EclairKeyHandler.a(paramKeyEvent))
      {
        localBoolean = Boolean.valueOf(true);
        continue;
      }
      if ((paramInt == 82) && (paramKeyEvent.isLongPress()))
      {
        localBoolean = Boolean.valueOf(true);
        continue;
      }
      if ((paramInt == 82) && (paramKeyEvent.getRepeatCount() == 0))
      {
        if (this.l == null)
          d();
        if (this.l.a())
        {
          this.z.a(FB4A_AnalyticEntities.Modules.j);
          this.l.c();
        }
        while (true)
        {
          localBoolean = Boolean.valueOf(true);
          break;
          this.z.a(FB4A_AnalyticEntities.Modules.j, true);
          this.l.a(this.t.findViewById(16908290), false, true);
        }
      }
      localBoolean = null;
    }
  }

  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramInt1, this.t.getResources().getString(paramInt2), paramInt3);
  }

  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (this.m.containsKey(Integer.valueOf(paramInt1)));
    while (true)
    {
      return;
      CustomMenuItem localCustomMenuItem = new CustomMenuItem();
      localCustomMenuItem.b(paramInt1);
      localCustomMenuItem.a(paramString);
      localCustomMenuItem.a(paramInt2);
      this.m.put(Integer.valueOf(paramInt1), localCustomMenuItem);
    }
  }

  public void a(int paramInt, boolean paramBoolean)
  {
    CustomMenuItem localCustomMenuItem = (CustomMenuItem)this.m.get(Integer.valueOf(paramInt));
    if (localCustomMenuItem != null)
      localCustomMenuItem.a(paramBoolean);
  }

  public void a(Activity paramActivity, Intent paramIntent)
  {
    super.a(paramActivity, paramIntent);
    if ((this.p != null) && (this.p.k()))
      this.p.n();
  }

  public void a(Activity paramActivity, Configuration paramConfiguration)
  {
    C();
    if (this.k != null)
      this.k.a(paramConfiguration);
    if ((this.l != null) && (this.l.a()))
      if (!this.l.b())
        break label91;
    label91: for (boolean bool = true; ; bool = false)
    {
      this.l.c();
      this.l.a(this.t.findViewById(16908290), bool, false);
      if (this.B != null)
        this.B.d();
      return;
    }
  }

  protected void a(Uri paramUri, Bundle paramBundle, Integer paramInteger, int paramInt, long paramLong)
  {
    AppSession localAppSession = AppSession.b(this.t, false);
    if ((localAppSession == null) || (paramLong == localAppSession.b().userId))
      paramLong = -1L;
    Intent localIntent = ((IFeedIntentBuilder)this.u.a(IFeedIntentBuilder.class)).a(paramUri, paramBundle, paramLong);
    localIntent.setFlags(paramInt);
    if (paramInteger != null)
      this.t.startActivityForResult(localIntent, paramInteger.intValue());
    while (true)
    {
      return;
      this.t.startActivity(localIntent);
    }
  }

  protected void a(Bundle paramBundle, Integer paramInteger)
  {
    Intent localIntent = new Intent(this.t, FeedComposerActivity.class);
    if (paramBundle != null)
      localIntent.putExtras(paramBundle);
    if (paramInteger != null)
      this.t.startActivityForResult(localIntent, paramInteger.intValue());
    while (true)
    {
      return;
      this.t.startActivity(localIntent);
    }
  }

  public void a(TitleBar.OnPrimaryButtonClickListener paramOnPrimaryButtonClickListener)
  {
    if (b() != null)
      b().setPrimaryOnClickListener(paramOnPrimaryButtonClickListener);
  }

  public void a(TitleBarButtonSpec paramTitleBarButtonSpec)
  {
    if (b() != null)
      b().setPrimaryActionButton(paramTitleBarButtonSpec);
  }

  public void a(CustomMenuActivity paramCustomMenuActivity)
  {
    this.l.a(paramCustomMenuActivity);
  }

  public void a(CustomMenuItem paramCustomMenuItem)
  {
    switch (paramCustomMenuItem.c())
    {
    default:
    case 1001:
    case 1002:
    case 1005:
    case 1004:
    case 1003:
    case 1006:
    }
    while (true)
    {
      a(paramCustomMenuItem.c());
      while (true)
      {
        return;
        this.z.a(FB4A_AnalyticEntities.UIElements.l, null);
        Intent localIntent = new Intent(this.t, SettingsActivity.class);
        this.t.startActivity(localIntent);
        continue;
        this.z.a(FB4A_AnalyticEntities.UIElements.m, null);
        this.t.startActivity(new Intent(this.t, HtmlAboutActivity.class));
        continue;
        this.z.a(FB4A_AnalyticEntities.UIElements.n, null);
        try
        {
          if (!o(this.t))
            continue;
          n();
        }
        catch (IOException localIOException)
        {
          Log.d(j(), "Error reporting bug: ", localIOException);
          ErrorReporting.a(j(), "Error reporting bug: ", localIOException);
        }
        continue;
        this.z.a(FB4A_AnalyticEntities.UIElements.o, null);
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.t);
        localBuilder.setMessage("How do you want to fail?").setPositiveButton("Hard crash", new FacebookActivityDelegate.9(this)).setNegativeButton("Soft error", new FacebookActivityDelegate.8(this));
        localBuilder.show();
        continue;
        this.z.a(FB4A_AnalyticEntities.UIElements.p, null);
        LogoutActivity.a(this.t);
      }
      this.z.a(FB4A_AnalyticEntities.UIElements.q, null);
      this.l.c();
      this.l.a(this.t.findViewById(16908290), true, true);
    }
  }

  public void a(boolean paramBoolean)
  {
    if (b() != null)
      b().a(paramBoolean);
  }

  public boolean a()
  {
    if (this.x != null);
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public boolean a(Activity paramActivity, int paramInt, Dialog paramDialog)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default:
      bool = false;
    case 684737812:
    }
    while (true)
    {
      return bool;
      FacewebWebView localFacewebWebView = o();
      if (b == null)
        ErrorReporting.a("MobileCanvas", "Trying to open a Mobile Canvas Dialog with a null URL", bool);
      ((PlatformWebViewDialog)paramDialog).a(b, localFacewebWebView);
    }
  }

  protected TitleBar b()
  {
    if (this.o == null)
    {
      View localView = this.t.findViewById(2131296299);
      if (localView != null)
        this.o = ((TitleBar)localView);
    }
    return this.o;
  }

  public Boolean b(Activity paramActivity, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (EclairKeyHandler.b(paramKeyEvent)))
      if (!w())
        this.t.onBackPressed();
    for (Boolean localBoolean = Boolean.valueOf(true); ; localBoolean = null)
      return localBoolean;
  }

  public void b(Activity paramActivity)
  {
    if (s())
    {
      if (this.D == null)
        this.D = new JustShakeListener(this.t, this);
      this.C.registerListener(this.D, this.C.getDefaultSensor(1), 3);
    }
    BackgroundDetectionService.c(this.t.getApplicationContext());
    this.c.a(this.t.getLocalClassName(), MarkerType.ACTIVITY_RESUMED);
    this.c.b(this.t.getLocalClassName());
    if (this.w != null)
    {
      this.w.b();
      this.w = null;
    }
    Annotation localAnnotation = this.t.getClass().getAnnotation(AuthNotRequired.class);
    AppSession localAppSession = null;
    if (localAnnotation == null)
    {
      localAppSession = AppSession.a(this.t, false);
      if (a(localAppSession))
      {
        Log.c("Finishing stale activity.");
        this.t.finish();
      }
    }
    while (true)
    {
      return;
      C();
      if (this.q != null)
        this.q.a(this.t);
      if ((this.s) && (localAppSession != null))
      {
        A();
        B();
      }
      this.e = true;
      if ((a == null) || (!this.t.equals(a)))
        n(this.t);
      a = this.t;
      if ((!(paramActivity instanceof ThreadListActivity)) || (NotificationsGet.a(this.t).d() <= 0))
        continue;
      a(MarkJewelSeen.Jewel.INBOX);
    }
  }

  public void b(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }

  protected JewelTitleBar c()
  {
    TitleBar localTitleBar = b();
    if ((localTitleBar instanceof JewelTitleBar));
    for (JewelTitleBar localJewelTitleBar = (JewelTitleBar)localTitleBar; ; localJewelTitleBar = null)
      return localJewelTitleBar;
  }

  public void c(Activity paramActivity)
  {
    if (this.D != null)
      this.C.unregisterListener(this.D);
    AppSession localAppSession = AppSession.a(this.t, false);
    if (this.s)
      b(localAppSession);
    if (this.q != null)
      this.q.e();
    if ((this.l != null) && (this.l.a()))
      this.l.c();
    this.v.removeCallbacksAndMessages(null);
    a = null;
    this.e = false;
    BackgroundDetectionService.b(this.t.getApplicationContext());
  }

  public void d()
  {
    if (this.l == null)
      this.l = new CustomMenu(this.t, this, LayoutInflater.from(this.t));
    if ((this.t instanceof CustomMenuHandler))
      ((CustomMenuHandler)this.t).d();
    if ((this.t instanceof ExportMenuToFbHostActivity))
      this.l.a((ExportMenuToFbHostActivity)this.t);
  }

  public void d(int paramInt)
  {
    this.m.remove(Integer.valueOf(paramInt));
  }

  public boolean e()
  {
    return this.e;
  }

  public void f()
  {
    b(NotificationsGet.a(this.t).d(), NotificationsGet.a(this.t).b(), NotificationsGet.a(this.t).c());
  }

  public void g()
  {
    if (this.q != null)
      this.q.b();
  }

  public void g(Activity paramActivity)
  {
    this.c.a(this.t.getLocalClassName());
    this.c.a(this.t.getLocalClassName(), MarkerType.ACTIVITY_CREATED);
    m();
    if ((paramActivity instanceof DivebarEnabledActivity))
      a(((DivebarEnabledActivity)paramActivity).m());
    i(paramActivity);
  }

  protected void h()
  {
    this.z.a(InteractionLogger.ContentFlags.LOCAL_DATA, j(), FbActivityUtils.a(this.t));
  }

  public void h(Activity paramActivity)
  {
    if (this.q != null)
    {
      this.q.f();
      this.q = null;
    }
    if (this.p != null)
    {
      this.p.a();
      this.p = null;
    }
  }

  protected void i()
  {
    this.z.a(InteractionLogger.ContentFlags.NETWORK_DATA, j(), FbActivityUtils.a(this.t));
  }

  public String j()
  {
    if (this.f == null)
    {
      Intent localIntent = this.t.getIntent();
      StringBuilder localStringBuilder = new StringBuilder();
      if (localIntent.getBooleanExtra("within_tab", false))
      {
        localStringBuilder.append(localIntent.getStringExtra("extra_parent_tag"));
        localStringBuilder.append('|');
      }
      localStringBuilder.append(this.t.getClass().getSimpleName());
      String str = Utils.a(this.t);
      if (str != null)
      {
        localStringBuilder.append('@');
        localStringBuilder.append(str);
      }
      this.f = localStringBuilder.toString();
    }
    return this.f;
  }

  public boolean k()
  {
    if ((this.q != null) && (this.q.d()))
    {
      this.r = this.q.i();
      this.q.a(this.t, false);
    }
    for (int i1 = 1; ; i1 = 0)
    {
      return i1;
      this.r = PopupViewDelegate.PopupState.CLOSED;
    }
  }

  public void l()
  {
    if ((this.q != null) && (!this.q.d()));
    String str;
    switch (FacebookActivityDelegate.13.b[this.r.ordinal()])
    {
    default:
      return;
    case 3:
      str = "fb://friends/requests/";
    case 1:
    case 2:
    }
    while (true)
    {
      a(this.r, str, false);
      this.r = PopupViewDelegate.PopupState.CLOSED;
      break;
      str = "fb://messaging/nosearch";
      continue;
      str = "fb://notifications";
    }
  }

  public void m()
  {
    if (b() != null)
    {
      FacebookActivityDelegate.7 local7 = new FacebookActivityDelegate.7(this);
      b().setPrimaryOnClickListener(local7);
      if (c() == null)
        break label36;
      x();
    }
    while (true)
    {
      return;
      label36: if ((this.t instanceof NotNewNavEnabled))
      {
        TextView localTextView = (TextView)this.t.findViewById(2131296686);
        if ((localTextView == null) || (((NotNewNavEnabled)this.t).i() == null))
          continue;
        localTextView.setText(((NotNewNavEnabled)this.t).i());
        continue;
      }
    }
  }

  public void n()
  {
    ((BugReporter)this.u.a(BugReporter.class)).a(this.t);
  }

  public FacewebWebView o()
  {
    FacewebWebView localFacewebWebView;
    if ((this.t instanceof UberbarActivity))
      localFacewebWebView = ((UberbarActivity)this.t).j();
    while (true)
    {
      return localFacewebWebView;
      if ((this.q != null) && (this.q.d()))
      {
        localFacewebWebView = this.q.g();
        continue;
      }
      boolean bool = this.t instanceof FbFragmentChromeActivity;
      localFacewebWebView = null;
      if (!bool)
        continue;
      localFacewebWebView = ((FbFragmentChromeActivity)this.t).j();
    }
  }

  public void p()
  {
    Assert.b(this.w);
    this.w = FacewebAssassin.a(new Handler(), new FacewebAssassin.BookmarksMenuAssassin(), 35000);
  }

  public void q()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = this.m.keySet().iterator();
    while (localIterator1.hasNext())
    {
      int i1 = ((Integer)localIterator1.next()).intValue();
      if ((i1 >= 1001) && (i1 <= 1006))
        continue;
      localArrayList.add(Integer.valueOf(i1));
    }
    Iterator localIterator2 = localArrayList.iterator();
    while (localIterator2.hasNext())
      d(((Integer)localIterator2.next()).intValue());
  }

  public void r()
  {
    DivebarController localDivebarController = E();
    if (localDivebarController == null)
    {
      localDivebarController = (DivebarController)this.u.a(DivebarController.class);
      a(localDivebarController);
      this.B = localDivebarController;
    }
    localDivebarController.a(this.t);
    FacebookActivityDelegate.12 local12 = new FacebookActivityDelegate.12(this);
    if (this.p != null)
      this.p.a(local12);
  }

  public boolean s()
  {
    if ((o(this.t)) && (this.d.a(SharedPrefKeys.v, Fb4aBugReporterConfig.e())));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public void t()
  {
    if ((this.q != null) && (this.q.d()))
      this.q.a(this.t, false);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.FacebookActivityDelegate
 * JD-Core Version:    0.6.0
 */