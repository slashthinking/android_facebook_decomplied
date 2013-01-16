package com.facebook.katana.activity.faceweb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.analytics.InteractionLogger;
import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.analytics.performance.PerformanceLogger.MarkerConfig;
import com.facebook.base.BuildConstants;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.common.util.Log;
import com.facebook.common.util.Toaster;
import com.facebook.composer.protocol.PublishPostParams;
import com.facebook.debug.Assert;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.IntentUriHandler;
import com.facebook.katana.NativeThirdPartyUriHelper;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.activity.FbFragmentChromeActivity;
import com.facebook.katana.activity.apps.CloseWebViewHandler;
import com.facebook.katana.activity.apps.LaunchApplicationHandler;
import com.facebook.katana.activity.apps.OpenWebViewHandler;
import com.facebook.katana.activity.composer.ComposerPublisherResult;
import com.facebook.katana.activity.composer.SharePostMethod;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.fragment.BaseFacebookFragment;
import com.facebook.katana.fragment.dialog.AlertDialogFragment;
import com.facebook.katana.fragment.dialog.ProgressDialogFragment;
import com.facebook.katana.model.FacebookAffiliation;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.service.method.AudienceSettings;
import com.facebook.katana.util.StringUtils;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.UIElements;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacewebPalCall;
import com.facebook.katana.webview.FacewebWebView;
import com.facebook.katana.webview.RefreshableFacewebWebViewContainer;
import com.facebook.katana.webview.RefreshableFacewebWebViewContainer.ContentState;
import com.facebook.orca.common.dialogs.ErrorMessageGenerator;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.menu.CustomMenuActivity;
import com.facebook.widget.menu.CustomMenuItem;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Timer;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FacewebFragment extends BaseFacebookFragment
  implements AnalyticsActivity, CustomMenuActivity
{
  private static final Set<String> ax = new HashSet();
  private static final HashSet<String> ay;
  private long Y = -1L;
  private AudienceSettings Z;
  private final Handler a = new Handler();
  private ErrorMessageGenerator aA;
  private FacewebWebView aa;
  private FbErrorReporter ab;
  private RefreshableFacewebWebViewContainer ac = null;
  private long ad = -1L;
  private String ae;
  private String af;
  private FacewebFragment.PrimaryActionDisplayType ag = FacewebFragment.PrimaryActionDisplayType.TITLE_BUTTON;
  private FacewebFragment.PrimaryActionMenuItem ah = null;
  private String ai;
  private FacewebFragment.FeedFilterPickerHandler aj;
  private boolean ak;
  private boolean al;
  private AppSession am;
  private List<AppSessionListener> an;
  private String ao;
  private String ap;
  private boolean aq = false;
  private boolean ar;
  private InteractionLogger as;
  private AndroidThreadUtil at;
  private JSONObject[] au = null;
  private long av = -1L;
  private Map<String, String> aw = new HashMap();
  private PerformanceLogger az;
  private int b = 0;
  private final FacewebFragment.SetBookmarksMenuButton c = new FacewebFragment.SetBookmarksMenuButton(this, this.a);
  private boolean d = false;
  private final FacewebFragment.ShowPublisherHandler e = new FacewebFragment.ShowPublisherHandler(this, this.a);
  private final FacewebFragment.SetToolbarSegmentsHandler f = new FacewebFragment.SetToolbarSegmentsHandler(this, this.a);
  private final FacewebFragment.ShowCommentPublisherHandler g = new FacewebFragment.ShowCommentPublisherHandler(this, this.a);
  private final FacewebFragment.ShowReplyPublisherHandler h = new FacewebFragment.ShowReplyPublisherHandler(this, this.a);
  private final FacewebFragment.ShowShareComposerHandler i = new FacewebFragment.ShowShareComposerHandler(this, this.a);

  static
  {
    ax.add("fw_photo_uploaded");
    ay = new HashSet();
  }

  private void S()
  {
    BaseFacebookActivity localBaseFacebookActivity = P();
    Assert.a(localBaseFacebookActivity);
    View localView = localBaseFacebookActivity.findViewById(2131296299);
    if (localView != null)
    {
      if (localView.getVisibility() != this.b)
        localView.setVisibility(this.b);
      if (localView.getVisibility() == 0)
        this.c.b(localBaseFacebookActivity, this.aa);
    }
    this.e.b(localBaseFacebookActivity, this.aa);
    this.f.b(localBaseFacebookActivity, this.aa);
    this.g.b(localBaseFacebookActivity, this.aa);
    this.h.b(localBaseFacebookActivity, this.aa);
  }

  private void T()
  {
    if (this.ac != null)
    {
      ViewGroup localViewGroup = (ViewGroup)this.ac.getParent();
      if (localViewGroup != null)
        localViewGroup.removeAllViews();
    }
  }

  private void U()
  {
    ViewGroup localViewGroup = (ViewGroup)A().findViewById(2131296897);
    View localView = (View)this.ac.getParent();
    if (localView == null)
    {
      localViewGroup.addView(this.ac, new LinearLayout.LayoutParams(-1, -1));
      this.aa = this.ac.getWebView();
      return;
    }
    if (localView == localViewGroup);
    for (boolean bool = true; ; bool = false)
    {
      Assert.b(bool);
      break;
    }
  }

  private boolean V()
  {
    if (this.Z != null);
    for (boolean bool1 = this.Z.a(this.Y); ; bool1 = false)
    {
      int j;
      if ((!bool1) && (this.Y >= 0L))
      {
        boolean bool2 = this.am.b().userId < this.Y;
        j = 0;
        if (bool2);
      }
      else
      {
        j = 1;
      }
      return j;
    }
  }

  protected static long a(String paramString)
  {
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = l2;
      return l1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (true)
        long l1 = -1L;
    }
    catch (NullPointerException localNullPointerException)
    {
      label13: break label13;
    }
  }

  public static FacewebFragment a(String paramString, boolean paramBoolean)
  {
    FacewebFragment localFacewebFragment = new FacewebFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("mobile_page", paramString);
    localBundle.putBoolean("faceweb_modal", paramBoolean);
    localFacewebFragment.f(localBundle);
    return localFacewebFragment;
  }

  private void a(BaseFacebookActivity paramBaseFacebookActivity)
  {
    this.aa.a("setToolbarSegments", this.f);
    this.aa.a("showComposer", new FacewebFragment.ShowFeedCommentComposerHandler(this, this.a));
    this.aa.a("showCommentPublisher", this.g);
    this.aa.a("showCheckinComposer", new FacewebFragment.ShowCheckinComposerHandler(this, this.a));
    this.aa.a("showFriendPicker", new FacewebFragment.ShowFriendPickerHandler(this, this.a));
    this.aa.a("addNativeEventListener", new FacewebFragment.AddNativeEventListenerHandler(this, this.a));
    this.aa.a("showPublisher", this.e);
    this.aa.a("removePublisher", new FacewebFragment.5(this, this.a, paramBaseFacebookActivity));
    this.aa.a("showMsgComposer", new FacewebFragment.ShowMessageComposerHandler(this, this.a));
    this.aa.a("callCell", new FacewebFragment.CallTextCellHandler(this, this.a, "android.intent.action.DIAL", "tel:"));
    this.aa.a("callSMS", new FacewebFragment.CallTextCellHandler(this, this.a, "android.intent.action.VIEW", "sms:"));
    this.aa.a("showActionSheet", new FacewebFragment.ShowActionSheetHandler(this, this.a));
    this.aa.a("uploadPhoto", new FacewebFragment.ShowUploadPhotoHandler(this, this.a));
    this.aa.a("reviewVaultImage", new FacewebFragment.ShowVaultReviewHandler(this, this.a));
    this.aa.a("showStatusComposer", new FacewebFragment.ShowStatusComposerHandler(this, this.a));
    this.aa.a("showShareComposer", this.i);
    this.aa.a("showMsgReplyPublisher", this.h);
    FacewebFragment.UpdateNativeLoadingIndicator localUpdateNativeLoadingIndicator = new FacewebFragment.UpdateNativeLoadingIndicator(this, this.a);
    this.aa.a("pageLoading", localUpdateNativeLoadingIndicator);
    this.aa.a("pageLoaded", localUpdateNativeLoadingIndicator);
    this.aa.a("appLog", new AppLogHandler(Q()));
    this.aa.a("setNavBarButton", this.c);
    this.aa.a("setActionMenu", new FacewebFragment.SetActionMenuHandler(this, this.a));
    this.aa.a("openDialogWebview", new OpenWebViewHandler(this.a));
    this.aa.a("closeDialogWebview", new CloseWebViewHandler(this.a));
    this.aa.a("showPickerView", this.aj);
    this.aa.a("enablePullToRefresh", new FacewebFragment.6(this));
    this.aa.a("close", new FacewebFragment.CloseAndBackHandler(this, this.a, false));
    this.aa.a("back", new FacewebFragment.CloseAndBackHandler(this, this.a, true));
    this.aa.setScrollBarStyle(33554432);
    this.aa.a("setNavBarHidden", new FacewebFragment.SetBookmarksMenuHiddenHandler(this, this.a));
    this.aa.a("dismissModalDialog", new FacewebFragment.DismissModalDialog(this, this.a));
    this.aa.a("addFriend", new FacewebFragment.7(this, this.a, paramBaseFacebookActivity));
    this.aa.a("showAlert", new FacewebFragment.ShowAlertHandler(this, this.a));
    this.aa.a("openInNewWebView", new FacewebFragment.OpenInNewWebViewHandler(this, this.a));
    this.aa.a("hideSoftKeyboard", new FacewebFragment.HideSoftKeyboardHandler(this, this.a));
    this.aa.a("nativethirdparty", new LaunchApplicationHandler(this.a));
    this.aa.g();
  }

  private boolean a(Exception paramException)
  {
    if (((paramException instanceof UnknownHostException)) || ((paramException instanceof ClientProtocolException)));
    for (int j = 1; ; j = 0)
      return j;
  }

  public void B()
  {
    super.B();
    if (BuildConstants.a())
      this.ab.b("news_feed_implementation", "faceweb");
    this.az.b("FWFragmentCreate");
    FragmentActivity localFragmentActivity = n();
    if (!this.aq)
    {
      AppSession localAppSession = AppSession.b(localFragmentActivity, false);
      this.am = localAppSession;
      if (localAppSession != null);
    }
    else if ((localFragmentActivity instanceof FbFragmentChromeActivity))
    {
      if (!((FbFragmentChromeActivity)localFragmentActivity).l())
        localFragmentActivity.finish();
    }
    while (true)
    {
      return;
      ErrorReporting.a("fragment", "parent of FwCF not a FbFCA", true);
      localFragmentActivity.finish();
      continue;
      FacewebAssassin.b(this);
      Iterator localIterator = this.an.iterator();
      while (localIterator.hasNext())
      {
        AppSessionListener localAppSessionListener = (AppSessionListener)localIterator.next();
        this.am.a(localAppSessionListener);
      }
      b();
      S();
      this.aa.f();
      if (Build.VERSION.SDK_INT >= 11)
        this.aa.onResume();
      if (this.av <= 0L)
        continue;
      long l = (System.currentTimeMillis() - this.av) / 1000L;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Long.valueOf(l);
      arrayOfObject[1] = "true";
      String str = StringLocaleUtil.a("(function() { if (window.fwDidEnterForeground) { fwDidEnterForeground(%d, %s); } })()", arrayOfObject);
      this.aa.b(str, null);
    }
  }

  public void C()
  {
    if (BuildConstants.a())
      this.ab.b("news_feed_implementation");
    this.az.c("FWFragmentCreate");
    if (this.am != null)
    {
      Iterator localIterator = this.an.iterator();
      while (localIterator.hasNext())
      {
        AppSessionListener localAppSessionListener = (AppSessionListener)localIterator.next();
        this.am.b(localAppSessionListener);
      }
    }
    this.av = System.currentTimeMillis();
    if (this.aa != null)
    {
      if (Build.VERSION.SDK_INT >= 11)
        this.aa.onPause();
      this.aa.freeMemory();
    }
    FacewebAssassin.a(this);
    super.C();
  }

  public void D()
  {
    FacewebAssassin.b(this);
    if (this.aa != null)
    {
      FacewebWebView localFacewebWebView = this.aa;
      this.a.postDelayed(new FacewebFragment.8(this, localFacewebWebView), 30000L);
      this.aa = null;
      T();
    }
    super.D();
  }

  public void K()
  {
    BaseFacebookActivity localBaseFacebookActivity = P();
    boolean bool;
    int j;
    label99: int k;
    JSONObject localJSONObject;
    if (this.al)
    {
      localBaseFacebookActivity.a(100, 2131363208, 2130838829);
      if (!this.ar)
      {
        bool = true;
        localBaseFacebookActivity.b(100, bool);
      }
    }
    else
    {
      if (FacebookAffiliation.c())
        localBaseFacebookActivity.a(101, "Faceweb!", 2130838306);
      if (this.ah != null)
        localBaseFacebookActivity.a(2100, this.ah.b(), this.ah.a());
      JSONObject[] arrayOfJSONObject = this.au;
      j = 0;
      if (arrayOfJSONObject == null)
        return;
      if (j >= this.au.length)
        return;
      k = j + 2000;
      localJSONObject = this.au[j];
      if (!localJSONObject.has("icon"))
        break label168;
      localBaseFacebookActivity.a(k, localJSONObject.optString("title"), localJSONObject.optInt("icon"));
    }
    while (true)
    {
      j++;
      break label99;
      bool = false;
      break;
      label168: localBaseFacebookActivity.a(k, localJSONObject.optString("title"), 2130838832);
    }
  }

  protected void L()
  {
    T();
    FacewebWebView localFacewebWebView = this.ac.getWebView();
    if (localFacewebWebView != null)
      localFacewebWebView.destroy();
    this.ac = null;
    this.aa = null;
  }

  public FacewebWebView M()
  {
    return this.aa;
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903209, paramViewGroup, false);
  }

  public String a()
  {
    return FB4A_AnalyticEntities.z;
  }

  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 0)
      if (paramInt1 == 11)
        this.i.a();
    while (true)
    {
      return;
      switch (paramInt1)
      {
      default:
        break;
      case 10:
        if (!paramIntent.hasExtra("extra_composer_publisher_result"))
          continue;
        g(2);
        ComposerPublisherResult localComposerPublisherResult = (ComposerPublisherResult)paramIntent.getParcelableExtra("extra_composer_publisher_result");
        if ((localComposerPublisherResult == null) || (!localComposerPublisherResult.a()))
          continue;
        this.ao = localComposerPublisherResult.b();
        break;
      case 30:
        String str = paramIntent.getStringExtra("extra_comment_text");
        if (str.length() <= 0)
          continue;
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("text", str);
          localJSONObject.put("post_id", this.af);
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(localJSONObject);
          this.aa.a(this.ai, localArrayList, new FacewebFragment.ShareHandler(this));
        }
        catch (JSONException localJSONException)
        {
          while (true)
            Log.a(Q(), "inconceivable exception", localJSONException);
        }
      case 11:
        PublishPostParams localPublishPostParams;
        if (paramIntent.hasExtra("publishPostParams"))
          localPublishPostParams = (PublishPostParams)paramIntent.getParcelableExtra("publishPostParams");
        try
        {
          SharePostMethod.a(this.am, p(), localPublishPostParams);
          g(2);
          this.i.a();
        }
        catch (Exception localException)
        {
          while (true)
            Toaster.a(p(), 2131363206);
        }
      case 40:
        a(paramInt2, paramIntent);
      }
    }
  }

  protected void a(int paramInt, Intent paramIntent)
  {
    long[] arrayOfLong;
    JSONObject localJSONObject;
    JSONArray localJSONArray;
    if ((paramInt == -1) && (paramIntent.hasExtra("profiles")))
    {
      arrayOfLong = paramIntent.getLongArrayExtra("profiles");
      localJSONObject = new JSONObject();
      localJSONArray = new JSONArray();
    }
    try
    {
      localJSONObject.put("action", "didPickFriends");
      int j = arrayOfLong.length;
      for (int k = 0; k < j; k++)
        localJSONArray.put(arrayOfLong[k]);
      localJSONObject.put("pickedFriends", localJSONArray);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localJSONObject);
      if (this.ai != null)
      {
        g(2);
        this.aa.a(this.ai, localArrayList, new FacewebFragment.ShareHandler(this));
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      while (true)
      {
        Log.a(Q(), "inconceivable exception", localJSONException);
        continue;
        g(6);
        ErrorReporting.a("FacewebError", "Invite friend callback unset.", true);
      }
    }
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    FbInjector localFbInjector = R();
    this.ab = ((FbErrorReporter)localFbInjector.a(FbErrorReporter.class));
    this.aA = ((ErrorMessageGenerator)localFbInjector.a(ErrorMessageGenerator.class));
    this.az = ((PerformanceLogger)localFbInjector.a(PerformanceLogger.class));
    this.az.a(new PerformanceLogger.MarkerConfig("FWFragmentCreate").a(new Class[] { FbFragmentChromeActivity.class }));
    this.at = ((AndroidThreadUtil)localFbInjector.a(AndroidThreadUtil.class));
  }

  protected void a(Bundle paramBundle, FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall)
  {
    boolean bool = Boolean.parseBoolean(paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "acts_as_target", "false"));
    if (bool)
    {
      paramBundle.putBoolean("extra_acts_as_target", bool);
      paramBundle.putString("extra_actor_profile_pic_uri", paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "actor_profile_pic_uri"));
    }
    String str1 = paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "enable_friend_tagging");
    if (str1 != null)
      paramBundle.putBoolean("extra_enable_friend_tagging", Boolean.parseBoolean(str1));
    String str2 = paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "enable_privacy");
    if (str2 != null)
      paramBundle.putBoolean("extra_enable_privacy", Boolean.parseBoolean(str2));
    String str3 = paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "enable_attach_to_album");
    if (str3 != null)
      paramBundle.putBoolean("extra_enable_attach_album_photos", Boolean.parseBoolean(str3));
  }

  protected void a(BaseFacebookActivity paramBaseFacebookActivity, FacebookWebView paramFacebookWebView)
  {
    this.d = false;
    this.e.b(paramBaseFacebookActivity, paramFacebookWebView);
  }

  public void a(FacewebFragment.PrimaryActionDisplayType paramPrimaryActionDisplayType)
  {
    this.ag = paramPrimaryActionDisplayType;
  }

  public void a(CustomMenuItem paramCustomMenuItem)
  {
    switch (paramCustomMenuItem.c())
    {
    default:
    case 100:
    case 101:
    case 2100:
    }
    while ((this.au != null) && (this.au.length > 0))
    {
      for (int j = 0; j < this.au.length; j++)
      {
        int k = j + 2000;
        if (paramCustomMenuItem.c() != k)
          continue;
        this.aa.b(this.au[j].optString("callback"), null);
      }
      this.as.a(FB4A_AnalyticEntities.UIElements.r, null);
      this.ac.b();
      continue;
      this.as.a(FB4A_AnalyticEntities.UIElements.s, null);
      Toaster.a(n(), "Faceweb href: " + this.ap);
      Log.e("Faceweb href: " + this.ap);
      continue;
      this.as.a(FB4A_AnalyticEntities.UIElements.t, null);
      if ((this.ah == null) || (this.ah.c() == null))
        continue;
      this.aa.b(this.ah.c(), null);
    }
  }

  protected boolean a(Uri paramUri, Bundle paramBundle, Integer paramInteger)
  {
    return a(paramUri, paramBundle, paramInteger, 0, this.ad);
  }

  protected boolean a(Uri paramUri, Bundle paramBundle, Integer paramInteger, int paramInt, long paramLong)
  {
    BaseFacebookActivity localBaseFacebookActivity = P();
    int j;
    if (localBaseFacebookActivity != null)
    {
      localBaseFacebookActivity.a(paramUri, paramBundle, paramInteger, paramInt, paramLong);
      j = 1;
      return j;
    }
    FragmentActivity localFragmentActivity = n();
    if (localFragmentActivity != null);
    for (String str = localFragmentActivity.getClass().getSimpleName(); ; str = Q())
    {
      ErrorReporting.a(str, "launchComposer: null facebook activity", false);
      j = 0;
      break;
    }
  }

  protected void b()
  {
    int j;
    int m;
    int k;
    if ((this.av > 0L) && (System.currentTimeMillis() - this.av > 300000L))
    {
      j = 1;
      BaseFacebookActivity localBaseFacebookActivity = P();
      if (this.ac != null)
        break label271;
      this.ac = new RefreshableFacewebWebViewContainer(localBaseFacebookActivity);
      m = 1;
      k = 0;
      label55: U();
      if (m != 0)
        a(localBaseFacebookActivity);
      if ((k == 0) || (!this.ac.a()))
        break label279;
    }
    label271: label279: for (int n = 1; ; n = 0)
    {
      int i1;
      if ((m == 0) && (j == 0))
      {
        i1 = 0;
        if (n == 0);
      }
      else
      {
        i1 = 1;
      }
      if (i1 != 0)
      {
        if (n != 0)
          this.ac.a(RefreshableFacewebWebViewContainer.ContentState.CONTENT_STATE_LOADING);
        FacebookWebView.setCookiesForWebViews(this.am, n().getApplicationContext());
        this.az.b("FacewebChromeLoad." + this.ap);
        if ((!Constants.URL.b(this.ap)) && (Constants.URL.a(this.ap)) && (!Constants.URL.c(this.ap)))
        {
          this.aq = true;
          Timer localTimer = new Timer();
          localTimer.schedule(new FacewebFragment.3(this), 10000L);
          FragmentManager localFragmentManager = r();
          localFragmentManager.a(new FacewebFragment.4(this, localTimer, localFragmentManager));
        }
        this.aa.a(this.ap, true);
      }
      return;
      j = 0;
      break;
      k = 1;
      m = 0;
      break label55;
    }
  }

  void b(String paramString)
  {
    Intent localIntent = IntentUriHandler.a(n(), paramString);
    if (localIntent == null)
    {
      localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      localIntent.setFlags(524288);
    }
    NativeThirdPartyUriHelper.a(n(), localIntent);
    a(localIntent);
  }

  public void c()
  {
    if (this.aa != null)
      this.aa.d();
  }

  public void d()
  {
  }

  public void d(Bundle paramBundle)
  {
    super.a(paramBundle);
    BaseFacebookActivity localBaseFacebookActivity = P();
    this.am = AppSession.a(localBaseFacebookActivity, false);
    this.as = new InteractionLogger(localBaseFacebookActivity);
    if (paramBundle != null)
    {
      this.ad = paramBundle.getLong("PROFILE_ID", -1L);
      this.ai = paramBundle.getString("publisher_callback");
      ArrayList localArrayList1 = paramBundle.getStringArrayList("native_event_listener_keys");
      ArrayList localArrayList2 = paramBundle.getStringArrayList("native_event_listener_values");
      if ((localArrayList1 != null) && (localArrayList2 != null) && (localArrayList2.size() == localArrayList1.size()))
        for (int j = 0; j < localArrayList1.size(); j++)
          this.aw.put(localArrayList1.get(j), localArrayList2.get(j));
    }
    Bundle localBundle = m();
    this.ap = localBundle.getString("mobile_page");
    if (StringUtils.c(this.ap))
      this.ap = "/home.php";
    if (localBundle.getBoolean("faceweb_modal", false))
    {
      localBaseFacebookActivity.b(false);
      this.b = 8;
    }
    this.aj = new FacewebFragment.FeedFilterPickerHandler(this, this.a);
    Context localContext = n().getApplicationContext();
    this.at.a(new FacewebFragment.1(this, localContext));
    this.an = new ArrayList();
    this.an.add(new FacewebFragment.FacewebAppSessionListener(this));
    this.av = System.currentTimeMillis();
    FacewebAssassin.a(this.a, new FacewebFragment.2(this), 35000);
  }

  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    paramBundle.putLong("PROFILE_ID", this.ad);
    paramBundle.putBoolean("save_active_state", true);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = this.aw.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localArrayList1.add(localEntry.getKey());
      localArrayList2.add(localEntry.getValue());
    }
    paramBundle.putStringArrayList("native_event_listener_keys", localArrayList1);
    paramBundle.putStringArrayList("native_event_listener_values", localArrayList2);
    paramBundle.putString("publisher_callback", this.ai);
  }

  public DialogFragment f(int paramInt)
  {
    DialogFragment localDialogFragment;
    switch (paramInt)
    {
    default:
    case 5:
      for (localDialogFragment = super.f(paramInt); ; localDialogFragment = AlertDialogFragment.f(2131363206))
        return localDialogFragment;
    case 2:
    case 3:
    case 4:
    }
    int j = -1;
    if (paramInt == 2)
      j = 2131363207;
    while (true)
    {
      localDialogFragment = ProgressDialogFragment.a(j, true, false);
      break;
      if (paramInt == 3)
      {
        j = 2131363200;
        continue;
      }
      if (paramInt != 4)
        continue;
      j = 2131363009;
    }
  }

  public void h()
  {
    T();
    super.h();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment
 * JD-Core Version:    0.6.0
 */