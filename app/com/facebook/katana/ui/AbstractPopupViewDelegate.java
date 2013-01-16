package com.facebook.katana.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.analytics.InteractionLogger;
import com.facebook.debug.Assert;
import com.facebook.katana.activity.apps.CloseWebViewHandler;
import com.facebook.katana.activity.apps.LaunchApplicationHandler;
import com.facebook.katana.activity.apps.OpenWebViewHandler;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.katana.friendrequests.FriendRequestsFragment;
import com.facebook.katana.orca.ForceMessenger;
import com.facebook.katana.orca.InstallMessengerFragment;
import com.facebook.katana.orca.InstallMessengerFragment.ClickThroughDestination;
import com.facebook.katana.orca.InstallMessengerPromoFragment;
import com.facebook.katana.util.ApplicationUtils;
import com.facebook.katana.util.Utils;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.Actions;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.Modules;
import com.facebook.katana.webview.FacewebWebView;
import com.facebook.katana.webview.RefreshableFacewebWebViewContainer;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.intents.MessagingIntentUris;
import com.facebook.orca.threadlist.ThreadListFragment;
import com.facebook.widget.ViewTransform;
import com.google.common.collect.ImmutableMap;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.AnimatorSet.Builder;
import com.nineoldandroids.animation.ObjectAnimator;
import java.util.Map;

public abstract class AbstractPopupViewDelegate
  implements PopupViewDelegate
{
  private static final int[] d = { 2131297696, 2131297699, 2131297704 };
  protected ListenableRelativeLayout a;
  protected final int b;
  protected PopupViewDelegate.PopupState c = PopupViewDelegate.PopupState.CLOSED;
  private ImmutableMap<PopupViewDelegate.PopupState, Point> e;
  private final Handler f;
  private final Runnable g = new AbstractPopupViewDelegate.1(this);
  private String h = null;
  private String i = null;
  private final InteractionLogger j;
  private final ForceMessenger k;
  private MessagingIntentUris l;
  private ObjectAnimator m = null;
  private PopupViewDelegate.OnStateChangedListener n = null;
  private AnimatorSet o;

  public AbstractPopupViewDelegate(Context paramContext, ViewGroup paramViewGroup, Handler paramHandler, Map<PopupViewDelegate.PopupState, Point> paramMap)
  {
    this.f = paramHandler;
    this.j = new InteractionLogger(paramContext);
    FbInjector localFbInjector = FbInjector.a(paramContext);
    this.k = ((ForceMessenger)localFbInjector.a(ForceMessenger.class));
    this.l = ((MessagingIntentUris)localFbInjector.a(MessagingIntentUris.class));
    this.b = paramContext.getResources().getDimensionPixelSize(2131230912);
    this.a = a(LayoutInflater.from(paramContext), paramViewGroup);
    a(paramMap);
    this.a.setOnLayoutChangedListener(new AbstractPopupViewDelegate.2(this));
    this.a.findViewById(2131297701).setOnClickListener(new AbstractPopupViewDelegate.3(this));
    if (Boolean.TRUE.equals(Gatekeeper.a(paramContext, "fbandroid_notif_settings")))
    {
      this.a.findViewById(2131297705).setVisibility(0);
      this.a.findViewById(2131297705).setOnClickListener(new AbstractPopupViewDelegate.4(this, localFbInjector));
    }
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    paramViewGroup.addView(this.a, paramViewGroup.getChildCount(), localLayoutParams);
  }

  private ObjectAnimator a(View paramView, int paramInt)
  {
    ObjectAnimator localObjectAnimator;
    if (!a(this.a.getContext()))
      localObjectAnimator = null;
    while (true)
    {
      return localObjectAnimator;
      localObjectAnimator = ObjectAnimator.a(paramView, "alpha", new float[] { 0.0F, 1.0F });
      localObjectAnimator.d(250L);
      localObjectAnimator.a(new AbstractPopupViewDelegate.8(this, paramInt));
      if (this.m != null)
        this.m.e();
      this.m = localObjectAnimator;
    }
  }

  private void a(int paramInt)
  {
    this.a.setVisibility(paramInt);
    for (int i1 = 0; i1 < this.a.getChildCount(); i1++)
      this.a.getChildAt(i1).setVisibility(paramInt);
  }

  private void a(Context paramContext, int paramInt, String paramString)
  {
    FacewebWebView localFacewebWebView1 = c(paramInt);
    if (localFacewebWebView1 == null)
    {
      ViewGroup localViewGroup = (ViewGroup)this.a.findViewById(paramInt).findViewById(2131297698);
      Assert.a(localViewGroup.getChildCount(), 0);
      RefreshableFacewebWebViewContainer localRefreshableFacewebWebViewContainer = new RefreshableFacewebWebViewContainer(paramContext);
      localViewGroup.addView(localRefreshableFacewebWebViewContainer, new LinearLayout.LayoutParams(-1, -1));
      FacewebWebView localFacewebWebView2 = localRefreshableFacewebWebViewContainer.getWebView();
      localFacewebWebView2.setScrollBarStyle(33554432);
      localFacewebWebView2.a("openDialogWebview", new OpenWebViewHandler(new Handler()));
      localFacewebWebView2.a("closeDialogWebview", new CloseWebViewHandler(new Handler()));
      localFacewebWebView2.a("nativethirdparty", new LaunchApplicationHandler(new Handler()));
      localFacewebWebView2.f();
      if (paramString != null)
        localFacewebWebView2.a(paramString, true);
    }
    while (true)
    {
      return;
      if (Build.VERSION.SDK_INT >= 11)
      {
        localFacewebWebView1.onResume();
        continue;
      }
    }
  }

  private void a(String paramString, boolean paramBoolean)
  {
    this.i = paramString;
    HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent("show_module").b("dest_module", this.i).a("is_modal", false);
    if (this.i.equals(FB4A_AnalyticEntities.Modules.f))
      localHoneyClientEvent.a("msgr_promo", paramBoolean);
    this.j.a(localHoneyClientEvent);
  }

  private void a(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i1 = 0; ; i1 = 8)
    {
      this.a.findViewById(2131297701).setVisibility(i1);
      if (this.a.findViewById(2131297700) != null)
        this.a.findViewById(2131297700).setVisibility(i1);
      return;
    }
  }

  public static boolean a(PopupViewDelegate.PopupState paramPopupState)
  {
    if ((paramPopupState != PopupViewDelegate.PopupState.NOTIFICATIONS) && (paramPopupState != PopupViewDelegate.PopupState.MESSAGES));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  private Fragment b(FragmentActivity paramFragmentActivity)
  {
    InstallMessengerFragment localInstallMessengerFragment = new InstallMessengerFragment(InstallMessengerFragment.ClickThroughDestination.THREAD_LIST_JEWEL);
    a(false);
    ((InstallMessengerFragment)localInstallMessengerFragment).a(new AbstractPopupViewDelegate.9(this, paramFragmentActivity));
    return localInstallMessengerFragment;
  }

  private void b(int paramInt)
  {
    if ((this.a == null) || (paramInt <= 0));
    while (true)
    {
      return;
      View localView1 = this.a.findViewById(paramInt);
      if (localView1 == null)
        continue;
      ViewGroup localViewGroup = (ViewGroup)localView1.findViewById(2131297698);
      if ((localViewGroup == null) || (localViewGroup.getChildCount() <= 0))
        continue;
      View localView2 = localViewGroup.getChildAt(0);
      if (!(localView2 instanceof RefreshableFacewebWebViewContainer))
        continue;
      localViewGroup.removeAllViews();
      FacewebWebView localFacewebWebView = ((RefreshableFacewebWebViewContainer)localView2).getWebView();
      localFacewebWebView.freeMemory();
      localFacewebWebView.destroy();
    }
  }

  private void b(Context paramContext, boolean paramBoolean)
  {
    Point localPoint = (Point)this.e.get(this.c);
    if ((localPoint == null) || (this.a == null))
      return;
    if ((this.o != null) && (this.o.f()))
      this.o.d();
    ViewTransform localViewTransform = new ViewTransform(this.a);
    localViewTransform.setPivotX((int)paramContext.getResources().getDimension(2131230911) / 2 + localPoint.x);
    localViewTransform.setPivotY(localPoint.y);
    if (paramBoolean)
    {
      localViewTransform.setAlpha(1.0F);
      AnimatorSet localAnimatorSet2 = new AnimatorSet();
      Animator[] arrayOfAnimator2 = new Animator[2];
      arrayOfAnimator2[0] = ObjectAnimator.a(localViewTransform, "scaleX", new float[] { 0.0F, 1.0F });
      arrayOfAnimator2[1] = ObjectAnimator.a(localViewTransform, "scaleY", new float[] { 0.0F, 1.0F });
      localAnimatorSet2.a(arrayOfAnimator2);
      localAnimatorSet2.a(new AccelerateInterpolator());
      localAnimatorSet2.a(150L);
      ObjectAnimator localObjectAnimator = ObjectAnimator.a(localViewTransform, "scaleX", new float[] { 1.0F, 1.0F });
      localObjectAnimator.d(1L);
      int i1 = o();
      this.o = new AnimatorSet();
      this.o.a(localObjectAnimator).c(localAnimatorSet2);
      this.o.a(new AbstractPopupViewDelegate.5(this, i1));
    }
    while (true)
    {
      this.o.c();
      break;
      this.o = new AnimatorSet();
      AnimatorSet localAnimatorSet1 = this.o;
      Animator[] arrayOfAnimator1 = new Animator[3];
      arrayOfAnimator1[0] = ObjectAnimator.a(localViewTransform, "scaleX", new float[] { 1.0F, 0.0F });
      arrayOfAnimator1[1] = ObjectAnimator.a(localViewTransform, "scaleY", new float[] { 1.0F, 0.0F });
      arrayOfAnimator1[2] = ObjectAnimator.a(localViewTransform, "alpha", new float[] { 1.0F, 0.4F });
      localAnimatorSet1.a(arrayOfAnimator1);
      this.o.a(new DecelerateInterpolator());
      this.o.a(150L);
      this.o.a(new AbstractPopupViewDelegate.6(this, localViewTransform));
    }
  }

  private FacewebWebView c(int paramInt)
  {
    ViewGroup localViewGroup = (ViewGroup)this.a.findViewById(paramInt).findViewById(2131297698);
    FacewebWebView localFacewebWebView;
    if (localViewGroup == null)
      localFacewebWebView = null;
    while (true)
    {
      return localFacewebWebView;
      if (localViewGroup.getChildCount() > 0)
      {
        View localView = localViewGroup.getChildAt(0);
        if ((localView instanceof RefreshableFacewebWebViewContainer))
        {
          localFacewebWebView = ((RefreshableFacewebWebViewContainer)localView).getWebView();
          continue;
        }
      }
      localFacewebWebView = null;
    }
  }

  private void d(int paramInt)
  {
    for (int i3 : d)
    {
      if (i3 == paramInt)
        continue;
      this.a.findViewById(i3).setVisibility(4);
    }
  }

  private boolean n()
  {
    int i1 = AbstractPopupViewDelegate.10.a[this.c.ordinal()];
    int i2 = 0;
    switch (i1)
    {
    case 2:
    case 3:
    default:
    case 1:
    }
    while (true)
    {
      return i2;
      boolean bool = a(this.a.getContext());
      i2 = 0;
      if (bool)
        continue;
      i2 = 1;
    }
  }

  private int o()
  {
    int i1;
    switch (AbstractPopupViewDelegate.10.a[this.c.ordinal()])
    {
    default:
      i1 = -1;
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      return i1;
      i1 = 2131297696;
      continue;
      i1 = 2131297699;
      continue;
      i1 = 2131297704;
    }
  }

  private void p()
  {
    if (this.i != null)
    {
      this.j.a(this.i);
      this.i = null;
    }
  }

  protected Fragment a(FragmentActivity paramFragmentActivity)
  {
    Context localContext = this.a.getContext();
    if ((this.k.a(localContext)) && (!ApplicationUtils.c(localContext)));
    for (Object localObject = b(paramFragmentActivity); ; localObject = j())
      return localObject;
  }

  protected abstract ListenableRelativeLayout a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup);

  protected abstract void a();

  public void a(Activity paramActivity)
  {
    this.f.removeCallbacks(this.g);
    if (n())
      a(paramActivity, o(), this.h);
  }

  public void a(Activity paramActivity, PopupViewDelegate.PopupState paramPopupState, String paramString, boolean paramBoolean)
  {
    PopupViewDelegate.PopupState localPopupState = this.c;
    if ((paramPopupState == PopupViewDelegate.PopupState.CLOSED) || (paramPopupState == this.c))
      a(paramActivity, paramBoolean);
    while (true)
    {
      return;
      Utils.b(paramActivity);
      if (!paramBoolean)
        c();
      a(paramActivity, paramPopupState, paramString);
      if ((localPopupState != PopupViewDelegate.PopupState.CLOSED) || (!paramBoolean))
        continue;
      b(paramActivity, true);
    }
  }

  protected final void a(Context paramContext, PopupViewDelegate.PopupState paramPopupState, String paramString)
  {
    PopupViewDelegate.PopupState localPopupState = this.c;
    a(paramPopupState, localPopupState);
    int i1;
    Object localObject;
    boolean bool1;
    label150: String str;
    ViewGroup localViewGroup2;
    boolean bool2;
    switch (AbstractPopupViewDelegate.10.a[paramPopupState.ordinal()])
    {
    default:
      throw new RuntimeException("The Popup view state isn't supported!");
    case 1:
      i1 = 2131297696;
      localObject = FB4A_AnalyticEntities.Modules.e;
      b(PopupViewDelegate.PopupState.FRIEND_REQUESTS);
      bool1 = false;
      this.h = paramString;
      p();
      if (n())
        a(paramContext, i1, paramString);
      a();
      View localView = this.a.findViewById(i1);
      localView.bringToFront();
      if (localPopupState != PopupViewDelegate.PopupState.CLOSED)
      {
        ObjectAnimator localObjectAnimator = a(localView, i1);
        if (localObjectAnimator != null)
          localObjectAnimator.c();
      }
      else
      {
        a(0);
        this.a.bringToFront();
        localView.setVisibility(0);
        a((String)localObject, bool1);
        return;
      }
    case 2:
      str = FB4A_AnalyticEntities.Modules.f;
      ViewGroup localViewGroup1 = (ViewGroup)this.a.findViewById(2131297699).findViewById(2131297702);
      if ((localViewGroup1 != null) && (localViewGroup1.getChildCount() == 0))
      {
        Assert.b(paramContext instanceof FragmentActivity);
        FragmentActivity localFragmentActivity = (FragmentActivity)paramContext;
        Fragment localFragment = a(localFragmentActivity);
        localFragmentActivity.g().a().a(2131297702, localFragment).a();
      }
      if (l())
      {
        localViewGroup2 = (ViewGroup)this.a.findViewById(2131297703);
        if (!InstallMessengerPromoFragment.b(this.a.getContext()))
          break;
        if (localViewGroup2.getChildCount() == 0)
        {
          Assert.b(paramContext instanceof FragmentActivity);
          ((FragmentActivity)paramContext).g().a().a(2131297703, InstallMessengerPromoFragment.f(m())).a();
        }
        localViewGroup2.setVisibility(0);
        bool2 = true;
      }
    case 3:
    }
    while (true)
    {
      b(PopupViewDelegate.PopupState.MESSAGES);
      i1 = 2131297699;
      bool1 = bool2;
      localObject = str;
      break;
      localViewGroup2.setVisibility(8);
      bool2 = false;
      continue;
      i1 = 2131297704;
      localObject = FB4A_AnalyticEntities.Modules.c;
      b(PopupViewDelegate.PopupState.NOTIFICATIONS);
      bool1 = false;
      break;
      d(i1);
      break label150;
      bool2 = false;
    }
  }

  public void a(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
      b(paramContext, false);
    while (true)
    {
      b(PopupViewDelegate.PopupState.CLOSED);
      this.h = null;
      if (this.i != null)
      {
        this.j.a(this.i);
        this.i = null;
      }
      if (this.m != null)
      {
        this.m.l();
        this.m.e();
        this.m = null;
      }
      return;
      a(8);
    }
  }

  protected void a(FragmentActivity paramFragmentActivity, Fragment paramFragment)
  {
    paramFragmentActivity.g().a().b(2131297702, paramFragment).a();
    a(true);
  }

  public void a(PopupViewDelegate.OnStateChangedListener paramOnStateChangedListener)
  {
    this.n = paramOnStateChangedListener;
  }

  public void a(PopupViewDelegate.PopupState paramPopupState1, PopupViewDelegate.PopupState paramPopupState2)
  {
    if (paramPopupState1 == PopupViewDelegate.PopupState.CLOSED)
      return;
    Point localPoint1 = (Point)this.e.get(paramPopupState1);
    ImmutableMap localImmutableMap = this.e;
    label33: Point localPoint2;
    if (paramPopupState2 == PopupViewDelegate.PopupState.CLOSED)
    {
      localPoint2 = (Point)localImmutableMap.get(paramPopupState1);
      if (a(this.a.getContext()))
        break label244;
    }
    label244: for (Point localPoint3 = localPoint1; ; localPoint3 = localPoint2)
    {
      View localView = this.a.findViewById(2131297708);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.leftMargin = localPoint3.x;
      localLayoutParams.topMargin = localPoint3.y;
      localLayoutParams.bottomMargin = 0;
      localLayoutParams.rightMargin = 0;
      localView.setLayoutParams(localLayoutParams);
      AnimatorSet localAnimatorSet = new AnimatorSet();
      Animator[] arrayOfAnimator = new Animator[2];
      float[] arrayOfFloat1 = new float[2];
      arrayOfFloat1[0] = 0.0F;
      arrayOfFloat1[1] = (localPoint1.x - localPoint3.x);
      arrayOfAnimator[0] = ObjectAnimator.a(localView, "translationX", arrayOfFloat1);
      float[] arrayOfFloat2 = new float[2];
      arrayOfFloat2[0] = 0.0F;
      arrayOfFloat2[1] = (localPoint1.y - localPoint3.y);
      arrayOfAnimator[1] = ObjectAnimator.a(localView, "translationY", arrayOfFloat2);
      localAnimatorSet.a(arrayOfAnimator);
      localAnimatorSet.a(100L);
      localAnimatorSet.c();
      break;
      paramPopupState1 = paramPopupState2;
      break label33;
    }
  }

  protected void a(ThreadListFragment paramThreadListFragment)
  {
    paramThreadListFragment.a(new AbstractPopupViewDelegate.7(this));
    paramThreadListFragment.a("thread_list_jewel");
  }

  public void a(Map<PopupViewDelegate.PopupState, Point> paramMap)
  {
    this.e = ImmutableMap.a(paramMap);
  }

  protected abstract boolean a(Context paramContext);

  public void b()
  {
    if ((this.a != null) && (!a(this.a.getContext())));
    FriendRequestsFragment localFriendRequestsFragment = (FriendRequestsFragment)((FragmentActivity)this.a.getContext()).g().a(2131297697);
    if (localFriendRequestsFragment != null)
      localFriendRequestsFragment.a(false);
  }

  protected void b(PopupViewDelegate.PopupState paramPopupState)
  {
    this.c = paramPopupState;
    if (this.n != null)
      this.n.a(paramPopupState);
  }

  protected void c()
  {
  }

  public boolean d()
  {
    if (this.c != PopupViewDelegate.PopupState.CLOSED);
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public void e()
  {
    int i3;
    label47: int i4;
    switch (AbstractPopupViewDelegate.10.a[this.c.ordinal()])
    {
    default:
      int i1 = o();
      int[] arrayOfInt = d;
      int i2 = arrayOfInt.length;
      i3 = 0;
      if (i3 >= i2)
        break label133;
      i4 = arrayOfInt[i3];
      if (i4 == i1)
      {
        if (Build.VERSION.SDK_INT < 11)
          break;
        FacewebWebView localFacewebWebView = c(i1);
        if (localFacewebWebView == null)
          break;
        localFacewebWebView.onPause();
      }
    case 2:
    case 3:
    }
    while (true)
    {
      i3++;
      break label47;
      this.j.a(FB4A_AnalyticEntities.Actions.e, null);
      break;
      this.j.a(FB4A_AnalyticEntities.Actions.f, null);
      break;
      b(i4);
    }
    label133: this.f.postDelayed(this.g, 300000L);
  }

  public void f()
  {
    this.g.run();
    this.a = null;
  }

  public FacewebWebView g()
  {
    int i1 = o();
    if (i1 > 0);
    for (FacewebWebView localFacewebWebView = c(i1); ; localFacewebWebView = null)
      return localFacewebWebView;
  }

  public View h()
  {
    return this.a;
  }

  public PopupViewDelegate.PopupState i()
  {
    return this.c;
  }

  protected ThreadListFragment j()
  {
    ThreadListFragment localThreadListFragment = new ThreadListFragment();
    a(localThreadListFragment);
    return localThreadListFragment;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.AbstractPopupViewDelegate
 * JD-Core Version:    0.6.0
 */