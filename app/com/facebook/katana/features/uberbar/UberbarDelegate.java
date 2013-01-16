package com.facebook.katana.features.uberbar;

import android.app.Activity;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.analytics.InteractionLogger;
import com.facebook.katana.activity.apps.CloseWebViewHandler;
import com.facebook.katana.activity.apps.LaunchApplicationHandler;
import com.facebook.katana.activity.apps.OpenWebViewHandler;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.katana.orca.FbandroidPrefKeys;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacewebWebView;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.prefs.OrcaSharedPreferences;

public class UberbarDelegate
{
  private final ViewGroup a;
  private final Activity b;
  private final EditText c;
  private final boolean d;
  private final UberbarResultsAnalyticHelper e;
  private final TextWatcher f = new UberbarDelegate.1(this);
  private View g;
  private FacewebWebView h;
  private Handler i;
  private UberbarResultsFragment j;
  private FragmentManager k;
  private InteractionLogger l;

  public UberbarDelegate(Activity paramActivity, EditText paramEditText, ViewGroup paramViewGroup, View paramView)
  {
    this(paramActivity, paramEditText, paramViewGroup, false);
    this.g = paramView;
    this.i = new Handler();
    this.g.setOnTouchListener(new UberbarDelegate.2(this));
  }

  public UberbarDelegate(Activity paramActivity, EditText paramEditText, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    this.b = paramActivity;
    this.c = paramEditText;
    this.c.addTextChangedListener(this.f);
    this.a = paramViewGroup;
    this.d = paramBoolean;
    this.l = ((InteractionLogger)FbInjector.a(this.b).a(InteractionLogger.class));
    this.e = new UberbarResultsAnalyticHelper(this.l);
  }

  public UberbarDelegate(FragmentActivity paramFragmentActivity, EditText paramEditText, ViewGroup paramViewGroup, UberbarResultsFragment paramUberbarResultsFragment)
  {
    this(paramFragmentActivity, paramEditText, paramViewGroup, true);
    this.k = ((FragmentManager)FbInjector.a(this.b).a(FragmentManager.class));
    FragmentTransaction localFragmentTransaction = this.k.a();
    this.j = paramUberbarResultsFragment;
    this.j.a(this.e);
    localFragmentTransaction.a(paramViewGroup.getId(), this.j);
    localFragmentTransaction.a();
  }

  public static UberbarDelegate a(OrcaSharedPreferences paramOrcaSharedPreferences, FragmentActivity paramFragmentActivity, EditText paramEditText, ViewGroup paramViewGroup, View paramView)
  {
    if (a(paramOrcaSharedPreferences, paramFragmentActivity));
    for (UberbarDelegate localUberbarDelegate = new UberbarDelegate(paramFragmentActivity, paramEditText, paramViewGroup, new UberbarResultsFragment()); ; localUberbarDelegate = new UberbarDelegate(paramFragmentActivity, paramEditText, paramViewGroup, paramView))
      return localUberbarDelegate;
  }

  private void a(Editable paramEditable)
  {
    if (paramEditable == null)
      d();
    while (true)
    {
      return;
      String str1 = paramEditable.toString().replace("\"", "").trim();
      if (str1.length() > 0)
      {
        if (this.d)
          this.j.a(str1);
        while (true)
        {
          e();
          break;
          String str2 = StringLocaleUtil.a("fwUpdateQuery({'query' : \"%s\" });", new Object[] { str1 });
          f().b(str2, null);
          f().scrollTo(0, 0);
        }
      }
      d();
      if (this.d)
      {
        this.j.a(str1);
        continue;
      }
      f().b("fwUpdateQuery({'query' : \" \" });", null);
    }
  }

  private void a(boolean paramBoolean)
  {
    int m;
    View localView;
    int n;
    if (this.g != null)
    {
      ViewGroup localViewGroup = this.a;
      if (!paramBoolean)
        break label45;
      m = 8;
      localViewGroup.setVisibility(m);
      localView = this.g;
      n = 0;
      if (!paramBoolean)
        break label50;
    }
    while (true)
    {
      localView.setVisibility(n);
      return;
      label45: m = 0;
      break;
      label50: n = 8;
    }
  }

  private static boolean a(OrcaSharedPreferences paramOrcaSharedPreferences, Activity paramActivity)
  {
    boolean bool = true;
    if ((paramOrcaSharedPreferences.a(FbandroidPrefKeys.d, bool)) && (Boolean.TRUE.equals(Gatekeeper.a(paramActivity, "facebook_for_android_native_search"))));
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  private FacewebWebView f()
  {
    if (this.h == null)
    {
      FacebookWebView.setCookiesForWebViews(AppSession.b(this.b, false), this.b.getApplicationContext());
      UberbarDelegate.3 local3 = new UberbarDelegate.3(this);
      this.h = FacewebWebView.a(this.b, local3);
      this.h.setBackgroundColor(0);
      this.h.setBackgroundResource(2131165455);
      this.a.addView(this.h);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
      this.h.setLayoutParams(localLayoutParams);
      this.h.setScrollBarStyle(33554432);
      this.h.a("/search/uberbar", true);
      this.h.a("openDialogWebview", new OpenWebViewHandler(this.i));
      this.h.a("closeDialogWebview", new CloseWebViewHandler(this.i));
      this.h.a("nativethirdparty", new LaunchApplicationHandler(this.i));
      this.h.setOnTouchListener(new UberbarDelegate.4(this));
      this.h.a("ubersearchReady", new UberbarDelegate.SearchHandler(this, null));
    }
    return this.h;
  }

  private void g()
  {
    ((InputMethodManager)this.b.getSystemService("input_method")).hideSoftInputFromWindow(this.c.getWindowToken(), 0);
  }

  public void a()
  {
    if (!this.d);
    while (true)
    {
      return;
      this.e.a();
    }
  }

  public void b()
  {
    if (!this.d);
    while (true)
    {
      return;
      this.e.a(this.c.getText().toString());
    }
  }

  public FacewebWebView c()
  {
    if (this.d);
    for (FacewebWebView localFacewebWebView = null; ; localFacewebWebView = f())
      return localFacewebWebView;
  }

  public void d()
  {
    this.a.setVisibility(8);
  }

  public void e()
  {
    this.a.setVisibility(0);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.uberbar.UberbarDelegate
 * JD-Core Version:    0.6.0
 */