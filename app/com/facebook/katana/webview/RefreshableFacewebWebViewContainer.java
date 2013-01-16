package com.facebook.katana.webview;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.analytics.InteractionLogger;
import com.facebook.analytics.InteractionLogger.ContentFlags;
import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.Log;
import com.facebook.debug.Assert;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.util.StringUtils;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities;
import com.facebook.orca.activity.FbActivityUtils;
import com.facebook.orca.common.ui.widgets.refreshablelistview.RefreshableListViewItem;
import com.facebook.orca.common.ui.widgets.refreshablelistview.RefreshableListViewState;
import com.facebook.orca.inject.FbInjector;
import java.util.ArrayList;
import java.util.List;

public class RefreshableFacewebWebViewContainer extends RelativeLayout
{
  private static final Class<?> f = RefreshableFacewebWebViewContainer.class;
  private boolean A = true;
  private AlertDialog B;
  private RefreshableListViewState C = RefreshableListViewState.NORMAL;
  TranslateAnimation a;
  RotateAnimation b;
  public RefreshableFacewebWebViewContainer.ContentState c = RefreshableFacewebWebViewContainer.ContentState.CONTENT_STATE_LOADING;
  public RefreshableFacewebWebViewContainer.ContentState d = RefreshableFacewebWebViewContainer.ContentState.CONTENT_STATE_LOADING;
  private Handler e;
  private int g;
  private int h;
  private int i;
  private int j = 0;
  private float k;
  private boolean l = false;
  private RefreshableListViewItem m;
  private FacewebWebView n;
  private FacewebWebView.FacewebWebViewListener o;
  private View p;
  private RefreshableFacewebWebViewContainer.WebViewPlacement q;
  private View r;
  private View s;
  private View t;
  private boolean u = false;
  private boolean v = false;
  private InteractionLogger.ContentFlags w = InteractionLogger.ContentFlags.UNDEFINED;
  private InteractionLogger x;
  private boolean y = false;
  private boolean z = false;

  public RefreshableFacewebWebViewContainer(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public RefreshableFacewebWebViewContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  public RefreshableFacewebWebViewContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  private void a(int paramInt, boolean paramBoolean)
  {
    monitorenter;
    try
    {
      if ((this.a != null) && (Build.VERSION.SDK_INT >= 8))
        this.a.cancel();
      this.a = new TranslateAnimation(0.0F, 0.0F, this.j, paramInt);
      if (paramBoolean)
      {
        this.a.setDuration(500L);
        this.a.setInterpolator(new AccelerateInterpolator());
      }
      if (paramInt == 0)
        this.a.setAnimationListener(new RefreshableFacewebWebViewContainer.10(this));
      this.a.setFillAfter(true);
      this.p.startAnimation(this.a);
      this.m.startAnimation(this.a);
      if (Build.VERSION.SDK_INT < 11)
        this.n.startAnimation(this.a);
      while (true)
      {
        this.j = paramInt;
        return;
        a(RefreshableFacewebWebViewContainer.ContentState.CONTENT_STATE_WEBVIEW_SNAPSHOT);
        this.q.startAnimation(this.a);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private void a(Context paramContext)
  {
    this.e = new Handler();
    Resources localResources = paramContext.getResources();
    this.g = localResources.getDimensionPixelSize(2131230918);
    this.h = localResources.getDimensionPixelSize(2131230919);
    this.i = localResources.getDimensionPixelSize(2131230920);
    setBackgroundColor(-1);
    this.p = new View(getContext());
    this.p.setBackgroundColor(-1);
    this.p.setVisibility(4);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, this.h + this.i);
    localLayoutParams1.leftMargin = 0;
    localLayoutParams1.topMargin = (-this.h - (-1 + this.i));
    addView(this.p, localLayoutParams1);
    this.o = new RefreshableFacewebWebViewContainer.4(this);
    this.n = FacewebWebView.a(getContext(), this.o);
    this.n.setFocusable(true);
    this.n.setFocusableInTouchMode(true);
    this.n.setOnTouchListener(new RefreshableFacewebWebViewContainer.5(this));
    f();
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.n, localLayoutParams2);
    if (e())
    {
      this.t = new View(getContext());
      this.t.setBackgroundColor(-1);
      this.t.setVisibility(8);
      RelativeLayout.LayoutParams localLayoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
      addView(this.t, localLayoutParams4);
    }
    this.n.a("enablePullToRefresh", new RefreshableFacewebWebViewContainer.6(this));
    this.n.a("disablePullToRefresh", new RefreshableFacewebWebViewContainer.7(this));
    this.n.a("loadCompleted", new RefreshableFacewebWebViewContainer.8(this));
    this.q = new RefreshableFacewebWebViewContainer.WebViewPlacement(this, getContext());
    this.q.setVisibility(8);
    addView(this.q, localLayoutParams2);
    LayoutInflater localLayoutInflater = LayoutInflater.from(getContext());
    a(localLayoutInflater);
    b(localLayoutInflater);
    this.m = new RefreshableListViewItem(this.n.getContext());
    this.m.setState(RefreshableListViewState.NORMAL);
    RelativeLayout.LayoutParams localLayoutParams3 = new RelativeLayout.LayoutParams(-1, this.h);
    localLayoutParams3.leftMargin = 0;
    localLayoutParams3.topMargin = (-this.h);
    addView(this.m, localLayoutParams3);
    this.x = new InteractionLogger(paramContext);
    if (!this.A)
    {
      g();
      a(this.h, false);
    }
    this.b = new RotateAnimation(0.0F, 1.0F);
    this.b.setRepeatCount(-1);
    findViewById(2131297417).startAnimation(this.b);
  }

  private void a(LayoutInflater paramLayoutInflater)
  {
    this.r = paramLayoutInflater.inflate(2130903136, null);
    this.r.setVisibility(8);
    addView(this.r, new RelativeLayout.LayoutParams(-1, -1));
  }

  private void a(RefreshableListViewState paramRefreshableListViewState)
  {
    this.C = paramRefreshableListViewState;
    this.m.setState(paramRefreshableListViewState);
  }

  private void a(String paramString)
  {
    if (paramString == null);
    while (true)
    {
      return;
      Context localContext = getContext();
      try
      {
        Uri localUri = Uri.parse(paramString);
        if ((localUri.getHost().equals("m.facebook.com")) && (localUri.getPath().equals("/l.php")))
        {
          String str = localUri.getQueryParameter("u");
          paramString = str;
        }
        label57: ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        localArrayList1.add(localContext.getString(2131363425));
        localArrayList2.add(Integer.valueOf(2131363425));
        localArrayList1.add(localContext.getString(2131363426));
        localArrayList2.add(Integer.valueOf(2131363426));
        CharSequence[] arrayOfCharSequence = (CharSequence[])localArrayList1.toArray(new CharSequence[localArrayList1.size()]);
        this.B = new AlertDialog.Builder(localContext).setItems(arrayOfCharSequence, new RefreshableFacewebWebViewContainer.2(this, localArrayList2, localContext, paramString)).setOnCancelListener(new RefreshableFacewebWebViewContainer.1(this)).show();
      }
      catch (NullPointerException localNullPointerException)
      {
        break label57;
      }
    }
  }

  private void b(LayoutInflater paramLayoutInflater)
  {
    this.s = paramLayoutInflater.inflate(2130903135, null);
    this.s.setOnClickListener(new RefreshableFacewebWebViewContainer.9(this));
    addView(this.s, new RelativeLayout.LayoutParams(-1, -1));
  }

  private void f()
  {
    this.n.setLongClickable(true);
    this.n.setOnLongClickListener(new RefreshableFacewebWebViewContainer.3(this));
  }

  private void g()
  {
    this.u = true;
    if (e())
      this.v = true;
    a(RefreshableListViewState.LOADING);
  }

  private void h()
  {
    PerformanceLogger localPerformanceLogger = (PerformanceLogger)FbInjector.a(getContext()).a(PerformanceLogger.class);
    this.u = false;
    this.A = true;
    if (this.C == RefreshableListViewState.LOADING)
    {
      a(RefreshableListViewState.NORMAL);
      this.p.setVisibility(0);
      this.q.setVisibility(8);
      if (this.j != 0);
    }
    while (true)
    {
      return;
      if (this.j <= this.h)
      {
        a(RefreshableListViewState.PULL_TO_REFRESH);
        if (this.j != this.h)
          continue;
        a(0, true);
        continue;
      }
      a(RefreshableListViewState.RELEASE_TO_REFRESH);
      continue;
      if (!this.y)
      {
        this.y = true;
        localPerformanceLogger.b("ColdStart");
      }
      String str = StringUtils.a(this.n.getUrl());
      if (str != null)
        localPerformanceLogger.b("FacewebPageRPCLoadCompleted:" + str);
      a(RefreshableFacewebWebViewContainer.ContentState.CONTENT_STATE_WEBVIEW);
    }
  }

  private void i()
  {
    HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent(FB4A_AnalyticEntities.b);
    this.x.b(localHoneyClientEvent);
  }

  private void setEnable(boolean paramBoolean)
  {
    this.l = paramBoolean;
    setOverScroll(paramBoolean);
  }

  private void setErrorTextInErrorView(FacewebWebView.FacewebErrorType paramFacewebErrorType)
  {
    TextView localTextView = (TextView)this.s.findViewById(2131296660);
    if (localTextView == null);
    while (true)
    {
      return;
      if (paramFacewebErrorType == null)
      {
        localTextView.setText("");
        continue;
      }
      localTextView.setText(paramFacewebErrorType.getErrorMessageId());
    }
  }

  private void setOverScroll(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 9);
    while (true)
    {
      return;
      if (paramBoolean)
      {
        this.n.setOverScrollMode(0);
        continue;
      }
      this.n.setOverScrollMode(2);
    }
  }

  public void a(RefreshableFacewebWebViewContainer.ContentState paramContentState)
  {
    if ((paramContentState == RefreshableFacewebWebViewContainer.ContentState.CONTENT_STATE_WEBVIEW_SNAPSHOT) && (this.c != RefreshableFacewebWebViewContainer.ContentState.CONTENT_STATE_WEBVIEW) && (this.c != RefreshableFacewebWebViewContainer.ContentState.CONTENT_STATE_WEBVIEW_SNAPSHOT))
    {
      Log.e(f, "RefreshableFacewebWebViewContainer: taking a snapshotwhile not showing a webview.  This will result in a blank screen:" + this.c);
      return;
    }
    if (this.c != paramContentState)
      this.d = this.c;
    this.c = paramContentState;
    if (paramContentState != RefreshableFacewebWebViewContainer.ContentState.CONTENT_STATE_LOADING)
      this.r.setVisibility(8);
    if (paramContentState != RefreshableFacewebWebViewContainer.ContentState.CONTENT_STATE_ERROR)
      this.s.setVisibility(8);
    if ((paramContentState != RefreshableFacewebWebViewContainer.ContentState.CONTENT_STATE_WEBVIEW) && (paramContentState != RefreshableFacewebWebViewContainer.ContentState.CONTENT_STATE_WEBVIEW_SNAPSHOT))
    {
      this.n.setVisibility(8);
      if (e())
        this.t.setVisibility(8);
    }
    if ((paramContentState != RefreshableFacewebWebViewContainer.ContentState.CONTENT_STATE_WEBVIEW_SNAPSHOT) && (c()))
    {
      this.q.setVisibility(8);
      this.q.c();
    }
    InteractionLogger.ContentFlags localContentFlags1 = InteractionLogger.ContentFlags.UNDEFINED;
    InteractionLogger.ContentFlags localContentFlags2;
    label209: Context localContext;
    if (paramContentState == RefreshableFacewebWebViewContainer.ContentState.CONTENT_STATE_LOADING)
    {
      this.r.setVisibility(0);
      this.r.bringToFront();
      localContentFlags2 = InteractionLogger.ContentFlags.LOCAL_DATA;
      if (localContentFlags2 == InteractionLogger.ContentFlags.UNDEFINED)
        break label505;
      localContext = getContext();
      if ((localContext == null) || ((localContext instanceof BaseFacebookActivity)))
        break label507;
      ErrorReporting.a("RefreshableFacewebWebViewContainer", "RefreshableFacewebWebViewContainer in non-BaseFacebookActivity activity");
    }
    while (true)
    {
      this.w = localContentFlags2;
      break;
      if (paramContentState == RefreshableFacewebWebViewContainer.ContentState.CONTENT_STATE_ERROR)
      {
        this.s.setVisibility(0);
        this.s.bringToFront();
        i();
        localContentFlags2 = InteractionLogger.ContentFlags.NETWORK_DATA;
        break label209;
      }
      if (paramContentState == RefreshableFacewebWebViewContainer.ContentState.CONTENT_STATE_WEBVIEW)
      {
        if (d())
        {
          if (this.n.getAnimation() == null)
          {
            Animation localAnimation2 = AnimationUtils.loadAnimation(getContext(), 2130968585);
            this.n.startAnimation(localAnimation2);
          }
          this.n.setVisibility(0);
          this.n.bringToFront();
        }
        while (true)
        {
          localContentFlags2 = InteractionLogger.ContentFlags.NETWORK_DATA;
          break;
          if (e())
          {
            this.n.setVisibility(0);
            this.n.bringToFront();
            if (!this.v)
              continue;
            this.v = false;
            this.t.setVisibility(0);
            this.t.bringToFront();
            Animation localAnimation1 = AnimationUtils.loadAnimation(getContext(), 2130968590);
            localAnimation1.setAnimationListener(new RefreshableFacewebWebViewContainer.11(this));
            this.t.startAnimation(localAnimation1);
            continue;
          }
          this.n.setVisibility(0);
          this.n.bringToFront();
        }
      }
      if (paramContentState == RefreshableFacewebWebViewContainer.ContentState.CONTENT_STATE_WEBVIEW_SNAPSHOT)
      {
        Assert.b(c());
        if (!this.q.b())
          this.q.a();
        this.q.setVisibility(0);
        this.q.bringToFront();
      }
      localContentFlags2 = localContentFlags1;
      break label209;
      label505: break;
      label507: if ((localContext == null) || (localContentFlags2 == this.w))
        continue;
      BaseFacebookActivity localBaseFacebookActivity = (BaseFacebookActivity)localContext;
      this.x.a(localContentFlags2, localBaseFacebookActivity.x(), FbActivityUtils.a(localBaseFacebookActivity));
    }
  }

  public boolean a()
  {
    if (this.c != RefreshableFacewebWebViewContainer.ContentState.CONTENT_STATE_WEBVIEW);
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public boolean a(MotionEvent paramMotionEvent)
  {
    int i1 = 1;
    if (!this.l)
    {
      i1 = this.n.onTouchEvent(paramMotionEvent);
      return i1;
    }
    label52: int i2;
    switch (paramMotionEvent.getAction())
    {
    default:
      i2 = i1;
    case 0:
    case 1:
    case 2:
    }
    label54: 
    while (i2 != 0)
    {
      if (this.C != RefreshableListViewState.NORMAL)
        paramMotionEvent.offsetLocation(0.0F, -this.j);
      i1 = this.n.onTouchEvent(paramMotionEvent);
      break;
      if (this.C == RefreshableListViewState.NORMAL)
      {
        this.k = paramMotionEvent.getY();
        i2 = i1;
        continue;
      }
      if (this.C != RefreshableListViewState.LOADING)
        break label52;
      this.k = (float)(paramMotionEvent.getY() - this.j / 0.75D);
      i2 = i1;
      continue;
      if (this.C == RefreshableListViewState.PULL_TO_REFRESH)
      {
        a(0, i1);
        this.n.setVerticalScrollBarEnabled(i1);
        a(RefreshableListViewState.NORMAL);
        i3 = 0;
        continue;
      }
      if (this.C == RefreshableListViewState.RELEASE_TO_REFRESH)
      {
        b();
        i3 = 0;
        continue;
      }
      if (this.C == RefreshableListViewState.LOADING)
      {
        int i6 = (int)(0.75D * (paramMotionEvent.getY() - this.k));
        if (this.k == paramMotionEvent.getY())
        {
          i3 = i1;
          continue;
        }
        if (i6 <= this.h)
          break label52;
        a(this.h, i1);
        i3 = 0;
        continue;
      }
      if ((this.B == null) || (!this.B.isShowing()))
        break label52;
      int i3 = 0;
      continue;
      switch (RefreshableFacewebWebViewContainer.12.a[this.C.ordinal()])
      {
      default:
        break;
      case 1:
        this.n.setVerticalScrollBarEnabled(i1);
        if (this.j < 0)
        {
          a(0, false);
          a(RefreshableListViewState.NORMAL);
          i3 = i1;
          continue;
        }
        if (paramMotionEvent.getY() - this.k < 0.0F)
        {
          i3 = i1;
          continue;
        }
        a(0, false);
        i3 = i1;
        break;
      case 2:
        if (0.75D * (paramMotionEvent.getY() - this.k) > this.g);
        int i5;
        for (int i4 = i1; (this.n.getScrollY() == 0) && (!this.u) && (i4 != 0); i5 = 0)
        {
          this.k = paramMotionEvent.getY();
          a(i1, false);
          a(RefreshableListViewState.PULL_TO_REFRESH);
          this.n.setVerticalScrollBarEnabled(false);
          i3 = 0;
          break label54;
        }
      case 3:
        if (this.j < 0)
        {
          a(0, false);
          this.n.setVerticalScrollBarEnabled(i1);
          a(RefreshableListViewState.NORMAL);
          i3 = i1;
          continue;
        }
        if (this.j > this.h)
          a(RefreshableListViewState.RELEASE_TO_REFRESH);
        a((int)(0.75D * (paramMotionEvent.getY() - this.k)), false);
        i3 = 0;
        break;
      case 4:
        if (this.j < 0)
        {
          a(0, false);
          this.n.setVerticalScrollBarEnabled(i1);
          a(RefreshableListViewState.NORMAL);
          paramMotionEvent.setAction(i1);
          i3 = i1;
          continue;
        }
        if (this.j < this.h)
          a(RefreshableListViewState.PULL_TO_REFRESH);
        a((int)(0.75D * (paramMotionEvent.getY() - this.k)), false);
        i3 = 0;
      }
    }
  }

  public void b()
  {
    this.n.scrollTo(0, 0);
    g();
    this.n.c();
    a(this.h, true);
    this.n.setVerticalScrollBarEnabled(true);
  }

  public boolean c()
  {
    if (Build.VERSION.SDK_INT >= 11);
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public boolean d()
  {
    if (Build.VERSION.SDK_INT < 11);
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public boolean e()
  {
    if (Build.VERSION.SDK_INT >= 11);
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public FacewebWebView getWebView()
  {
    return this.n;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.RefreshableFacewebWebViewContainer
 * JD-Core Version:    0.6.0
 */