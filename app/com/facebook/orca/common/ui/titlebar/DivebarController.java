package com.facebook.orca.common.ui.titlebar;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.app.Product;
import com.facebook.diagnostics.FPSView;
import com.facebook.orca.app.OrcaAppType;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.common.util.SizeUtil;
import com.facebook.orca.contacts.divebar.DivebarFragment;
import com.facebook.orca.contacts.divebar.DivebarViewListener;
import com.facebook.orca.contacts.picker.ContactPickerRow;
import com.facebook.orca.contacts.picker.ContactPickerUserRow;
import com.facebook.orca.contacts.picker.ContactPickerUserRow.ContactRowSectionType;
import com.facebook.orca.creation.CreateThreadActivity;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.orca.prefs.PrefKey;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.threadview.ThreadViewActivity;
import com.facebook.orca.ui.touch.DragMotionDetector;
import com.facebook.orca.ui.touch.Draggable;
import com.facebook.orca.ui.touch.SwipableLinearLayout;
import com.facebook.orca.ui.touch.SwipeableLayout;
import com.facebook.orca.users.User;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserIdentifier;
import com.facebook.orca.users.UserIdentifier.IdentifierType;
import com.facebook.orca.users.UserKey;
import com.facebook.orca.users.UserWithIdentifier;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Provider;

public class DivebarController
  implements Draggable
{
  private static final Class<?> c = DivebarController.class;
  private boolean A;
  private boolean B;
  private Set<DivebarViewListener> C;
  View a;
  ViewGroup b;
  private FragmentActivity d;
  private final InputMethodManager e;
  private final AnalyticsLogger f;
  private final DataCache g;
  private final OrcaAppType h;
  private final OrcaSharedPreferences.OnSharedPreferenceChangeListener i;
  private final OrcaSharedPreferences j;
  private final Provider<Boolean> k;
  private final LocalBroadcastManager l;
  private SwipableLinearLayout m;
  private DivebarFragment n;
  private DivebarViewListener o;
  private DivebarController.DivebarState p = DivebarController.DivebarState.CLOSED;
  private int q = 0;
  private int r = 0;
  private int s = 0;
  private DivebarController.DivebarAnimationListener t;
  private DivebarController.DivebarOverlayClickListener u;
  private DivebarController.DragListener v;
  private DivebarController.DivebarStateListener w;
  private DragMotionDetector x;
  private DragMotionDetector y;
  private Animation z;

  public DivebarController(InputMethodManager paramInputMethodManager, DataCache paramDataCache, AnalyticsLogger paramAnalyticsLogger, OrcaAppType paramOrcaAppType, OrcaSharedPreferences paramOrcaSharedPreferences, Provider<Boolean> paramProvider, Set<DivebarViewListener> paramSet, LocalBroadcastManager paramLocalBroadcastManager)
  {
    this.e = paramInputMethodManager;
    this.g = paramDataCache;
    this.f = paramAnalyticsLogger;
    this.j = paramOrcaSharedPreferences;
    this.k = paramProvider;
    this.h = paramOrcaAppType;
    this.l = paramLocalBroadcastManager;
    this.i = new DivebarController.1(this);
    paramOrcaSharedPreferences.a(this.i);
    this.A = ((Boolean)this.k.b()).booleanValue();
    this.C = paramSet;
  }

  private void A()
  {
    if (this.n != null)
      this.n.a("");
  }

  private void B()
  {
    if ((this.m != null) && (this.m.getParent() != null))
      ((ViewGroup)this.m.getParent()).removeView(this.m);
  }

  private void C()
  {
    if ((this.a != null) && (this.a.getParent() != null))
      ((ViewGroup)this.a.getParent()).removeView(this.a);
  }

  private Set<View> D()
  {
    if (!F());
    HashSet localHashSet;
    for (Object localObject = new HashSet(); ; localObject = localHashSet)
    {
      return localObject;
      localHashSet = new HashSet();
      int i1 = 0;
      if (i1 >= this.b.getChildCount())
        continue;
      View localView = this.b.getChildAt(i1);
      if ((localView.getVisibility() != 0) || (localView == this.a) || (localView == this.m) || ((localView instanceof FPSView)));
      while (true)
      {
        i1++;
        break;
        if ((this.t != null) && (this.t.a(localView)))
          continue;
        localHashSet.add(localView);
      }
    }
  }

  private String E()
  {
    if ((this.d instanceof AnalyticsActivity));
    for (String str = ((AnalyticsActivity)this.d).a(); ; str = null)
      return str;
  }

  private boolean F()
  {
    if (this.b != null);
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  private boolean G()
  {
    if (this.h.i() == Product.MESSENGER);
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  private int a(boolean paramBoolean)
  {
    if ((this.s <= 0) || (paramBoolean))
      this.s = (r() - this.r);
    return this.s;
  }

  private void a(long paramLong, Runnable paramRunnable)
  {
    g();
    a(DivebarController.DivebarState.OPENED, paramLong, paramRunnable);
  }

  private void a(Animation paramAnimation, boolean paramBoolean)
  {
    if (this.z != null)
      this.z.cancel();
    this.z = paramAnimation;
    if (this.a != null)
    {
      this.a.bringToFront();
      this.a.requestFocus();
    }
    Set localSet = D();
    if (localSet.size() > 0)
    {
      if (paramBoolean)
        this.p = DivebarController.DivebarState.ANIMATING;
      Iterator localIterator = localSet.iterator();
      while (localIterator.hasNext())
      {
        View localView = (View)localIterator.next();
        localView.bringToFront();
        localView.startAnimation(paramAnimation);
      }
    }
  }

  private void a(DivebarController.DivebarState paramDivebarState, long paramLong, Runnable paramRunnable)
  {
    if ((this.b == null) || (this.m == null))
      BLog.e(c, "unable to start animation - failed to locate divebar elements");
    while (true)
    {
      return;
      if (this.n == null)
      {
        BLog.e(c, "unable to start animation - divebar fragment is not ready");
        continue;
      }
      int i1 = a(false);
      int i2 = this.q;
      DivebarController.DivebarState localDivebarState = DivebarController.DivebarState.OPENED;
      int i3 = 0;
      if (paramDivebarState == localDivebarState)
        i3 = -i1;
      this.q = i3;
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(i2, i3, 0.0F, 0.0F);
      localTranslateAnimation.setDuration(paramLong);
      localTranslateAnimation.setInterpolator(new LinearInterpolator());
      localTranslateAnimation.setFillAfter(true);
      localTranslateAnimation.setAnimationListener(new DivebarController.2(this, paramDivebarState, paramRunnable));
      a(localTranslateAnimation, true);
    }
  }

  private void a(PrefKey paramPrefKey)
  {
    if (this.A != ((Boolean)this.k.b()).booleanValue())
    {
      this.A = ((Boolean)this.k.b()).booleanValue();
      if (!a())
        break label62;
      b(0L, new DivebarController.9(this));
    }
    while (true)
    {
      return;
      label62: this.n = null;
    }
  }

  private void a(UserWithIdentifier paramUserWithIdentifier, boolean paramBoolean, ContactPickerRow paramContactPickerRow)
  {
    UserIdentifier localUserIdentifier = paramUserWithIdentifier.b();
    UserIdentifier.IdentifierType localIdentifierType = localUserIdentifier.e();
    UserKey localUserKey;
    if (localIdentifierType == UserIdentifier.IdentifierType.FBID)
      localUserKey = paramUserWithIdentifier.a().c();
    while (true)
    {
      StringBuilder localStringBuilder = new StringBuilder("divebar");
      HoneyClientEvent localHoneyClientEvent1 = new HoneyClientEvent("click").e("divebar_contact");
      String str1;
      label72: Intent localIntent;
      if (localUserKey != null)
      {
        str1 = localUserKey.toString();
        HoneyClientEvent localHoneyClientEvent2 = localHoneyClientEvent1.f(str1).b("contact_type", localIdentifierType.toString()).a("filtered", paramBoolean);
        if ((paramContactPickerRow instanceof ContactPickerUserRow))
        {
          String str3 = ((ContactPickerUserRow)paramContactPickerRow).h().toString();
          localHoneyClientEvent2.b("section_type", str3);
          localStringBuilder.append("_").append(str3);
        }
        String str2 = E();
        if (str2 != null)
        {
          localHoneyClientEvent2.d(str2);
          localStringBuilder.append("_").append(str2);
        }
        this.f.a(localHoneyClientEvent2);
        ThreadSummary localThreadSummary = null;
        if (localUserKey != null)
          localThreadSummary = this.g.c(localUserKey);
        if (localThreadSummary == null)
          break label322;
        localIntent = new Intent(this.d, ThreadViewActivity.class);
        localIntent.putExtra("thread_id", localThreadSummary.a());
      }
      while (true)
      {
        localIntent.putExtra("focus_compose", true);
        localIntent.putExtra("trigger", localStringBuilder.toString());
        localIntent.setFlags(67108864);
        this.d.startActivity(localIntent);
        k();
        return;
        if (localIdentifierType != UserIdentifier.IdentifierType.PHONE)
          break label351;
        localUserKey = new UserKey(User.Type.PHONE_NUMBER, localUserIdentifier.d());
        break;
        str1 = "null";
        break label72;
        label322: localIntent = new Intent(this.d, CreateThreadActivity.class);
        localIntent.putExtra("to", paramUserWithIdentifier);
      }
      label351: localUserKey = null;
    }
  }

  private boolean a(DivebarController.DivebarState paramDivebarState)
  {
    boolean bool;
    if ((this.n == null) && (this.d != null) && (!this.d.g().c()))
      bool = false;
    while (true)
    {
      return bool;
      if (this.w != null)
      {
        bool = this.w.a(paramDivebarState);
        continue;
      }
      bool = true;
    }
  }

  private void b(int paramInt)
  {
    int i1 = paramInt - a(false);
    if (i1 > 0)
      i1 = 0;
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(i1, i1, 0.0F, 0.0F);
    localTranslateAnimation.setFillAfter(true);
    a(localTranslateAnimation, false);
    this.q = i1;
  }

  private void b(long paramLong, Runnable paramRunnable)
  {
    if ((this.p == DivebarController.DivebarState.CLOSED) || (this.p == DivebarController.DivebarState.ANIMATING) || (this.n == null) || (!a(DivebarController.DivebarState.CLOSED)));
    while (true)
    {
      return;
      u();
      a(DivebarController.DivebarState.CLOSED, paramLong, paramRunnable);
    }
  }

  private void b(DivebarController.DivebarState paramDivebarState)
  {
    if (this.p != paramDivebarState)
    {
      this.p = paramDivebarState;
      if (DivebarController.DivebarState.OPENED != paramDivebarState)
        break label66;
      this.f.b("divebar", false);
    }
    while (true)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("com.facebook.orca.common.ui.titlebar.DIVEBAR_STATE_CHANGED");
      localIntent.putExtra("state", paramDivebarState);
      this.l.a(localIntent);
      return;
      label66: if (DivebarController.DivebarState.CLOSED != paramDivebarState)
        continue;
      this.f.b("divebar");
    }
  }

  private void n()
  {
    Integer[] arrayOfInteger = new Integer[1];
    arrayOfInteger[0] = Integer.valueOf(1);
    this.x = new DragMotionDetector(this, Arrays.asList(arrayOfInteger), SizeUtil.a(this.d, 15.0F), SizeUtil.a(this.d, 5.0F));
    this.x.a(SizeUtil.a(this.d, 5.0F));
    y();
    SwipeableLayout localSwipeableLayout = q();
    if (localSwipeableLayout != null)
      localSwipeableLayout.a(this.x);
  }

  private void o()
  {
    if (this.m != null)
    {
      SwipableLinearLayout localSwipableLinearLayout = this.m;
      Integer[] arrayOfInteger = new Integer[1];
      arrayOfInteger[0] = Integer.valueOf(-1);
      this.y = new DragMotionDetector(this, Arrays.asList(arrayOfInteger), SizeUtil.a(this.d, 5.0F), SizeUtil.a(this.d, 5.0F));
      y();
      localSwipableLinearLayout.a(this.y);
    }
  }

  private void p()
  {
    SwipeableLayout localSwipeableLayout = q();
    if (localSwipeableLayout != null)
      localSwipeableLayout.b();
    this.x = null;
    this.y = null;
  }

  private SwipeableLayout q()
  {
    int i1;
    View localView;
    if (this.b != null)
    {
      i1 = 0;
      if (i1 < this.b.getChildCount())
      {
        localView = this.b.getChildAt(i1);
        if ((localView == null) || (!(localView instanceof SwipeableLayout)));
      }
    }
    for (SwipeableLayout localSwipeableLayout = (SwipeableLayout)localView; ; localSwipeableLayout = null)
    {
      return localSwipeableLayout;
      i1++;
      break;
    }
  }

  private int r()
  {
    ViewGroup localViewGroup = this.b;
    int i1 = 0;
    if (localViewGroup != null)
      i1 = this.b.getWidth();
    if (i1 <= 0)
      i1 = s();
    return i1;
  }

  private int s()
  {
    return this.d.getWindowManager().getDefaultDisplay().getWidth();
  }

  private int t()
  {
    return this.d.getWindowManager().getDefaultDisplay().getHeight();
  }

  private void u()
  {
    if (this.d == null)
      throw new IllegalStateException("DivebarController not attached to an activity");
    if (this.b == null);
    while (true)
    {
      return;
      if (this.t != null)
        this.t.a(this.p);
      j();
      z();
      this.e.hideSoftInputFromWindow(this.d.getWindow().getDecorView().getWindowToken(), 0);
    }
  }

  private void v()
  {
    if (this.s != a(true))
    {
      y();
      w();
    }
  }

  private void w()
  {
    if ((this.p == DivebarController.DivebarState.CLOSED) || (this.n == null));
    while (true)
    {
      return;
      a(0L, null);
    }
  }

  private DivebarFragment x()
  {
    DivebarFragment localDivebarFragment = new DivebarFragment();
    FragmentTransaction localFragmentTransaction = this.d.g().a();
    localFragmentTransaction.b(2131297257, localDivebarFragment);
    localFragmentTransaction.a();
    return localDivebarFragment;
  }

  private void y()
  {
    if (this.x != null)
      this.x.a(s() / 2.0F, 0.0F, s(), t());
    if (this.y != null)
      this.y.a(0.0F, 0.0F, this.r, t());
  }

  private void z()
  {
    if (this.a == null)
    {
      this.a = new View(this.d);
      this.a.setBackgroundDrawable(this.d.getResources().getDrawable(2130839055));
      this.a.setOnTouchListener(new DivebarController.8(this));
      if (this.a.getParent() == null)
      {
        this.a.setVisibility(0);
        this.b.addView(this.a, new LinearLayout.LayoutParams(-1, -1));
      }
    }
  }

  public void a(float paramFloat1, float paramFloat2)
  {
    if (!F());
    while (true)
    {
      return;
      if (b())
        g();
      if (this.v == null)
        continue;
      this.v.a(paramFloat1, paramFloat2);
    }
  }

  public void a(int paramInt)
  {
    if ((this.p == DivebarController.DivebarState.OPENED) || (this.p == DivebarController.DivebarState.ANIMATING) || (!a(DivebarController.DivebarState.OPENED)));
    while (true)
    {
      return;
      a(paramInt, null);
    }
  }

  public void a(Activity paramActivity)
  {
    if (!(paramActivity instanceof FragmentActivity))
      throw new IllegalStateException("DivebarController must be attached to a FragmentActivity");
    this.d = ((FragmentActivity)paramActivity);
    this.b = ((ViewGroup)paramActivity.getWindow().getDecorView().findViewById(16908290));
    this.r = paramActivity.getResources().getDimensionPixelSize(2131230891);
    m();
  }

  public void a(DivebarController.DivebarAnimationListener paramDivebarAnimationListener)
  {
    this.t = paramDivebarAnimationListener;
  }

  public void a(DivebarController.DivebarOverlayClickListener paramDivebarOverlayClickListener)
  {
    this.u = paramDivebarOverlayClickListener;
  }

  public void a(DivebarController.DivebarStateListener paramDivebarStateListener)
  {
    this.w = paramDivebarStateListener;
  }

  public boolean a()
  {
    if (this.p == DivebarController.DivebarState.OPENED);
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public void b(float paramFloat1, float paramFloat2)
  {
    if (!F());
    while (true)
    {
      return;
      b(Math.max(0, (int)paramFloat1 - this.r));
    }
  }

  public boolean b()
  {
    if (this.p == DivebarController.DivebarState.CLOSED);
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public DivebarController.DivebarState c()
  {
    return this.p;
  }

  public void c(float paramFloat1, float paramFloat2)
  {
    if ((!F()) || (this.n == null));
    while (true)
    {
      return;
      if ((b()) && (this.x != null) && (this.x.a() < 0.0F))
      {
        a(50L, null);
        continue;
      }
      if ((a()) && (this.y != null) && (this.y.a() > 0.0F))
      {
        b(50L, null);
        continue;
      }
      h();
    }
  }

  public void d()
  {
    this.s = 0;
    y();
    if (this.p == DivebarController.DivebarState.CLOSED)
      this.n = null;
  }

  public void d(float paramFloat1, float paramFloat2)
  {
  }

  public boolean e()
  {
    if (a())
      i();
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public void f()
  {
    a(140);
  }

  public void g()
  {
    u();
    Iterator localIterator = D().iterator();
    while (localIterator.hasNext())
      ((View)localIterator.next()).bringToFront();
    if (this.m != null)
      this.m.setVisibility(0);
    if ((this.n != null) && (this.n.s()))
    {
      this.n.a();
      this.n.b();
    }
  }

  public void h()
  {
    if (this.p != DivebarController.DivebarState.ANIMATING)
    {
      u();
      a(this.p, 25L, null);
    }
  }

  public void i()
  {
    b(140L, null);
  }

  public void j()
  {
    if (this.m == null)
    {
      this.m = ((SwipableLinearLayout)LayoutInflater.from(this.d).inflate(2130903336, null));
      this.m.setVisibility(4);
      this.o = new DivebarController.3(this);
      this.m.setLayoutListener(new DivebarController.4(this));
      View localView = this.m.findViewById(2131297256);
      localView.setOnClickListener(new DivebarController.5(this));
      localView.setOnTouchListener(new DivebarController.6(this));
    }
    if (this.n == null)
    {
      this.n = x();
      this.n.a(this.o);
      this.n.a(new DivebarController.7(this));
    }
    if (this.m.getParent() == null)
    {
      this.m.setVisibility(8);
      this.b.addView(this.m, new LinearLayout.LayoutParams(-1, -1));
    }
  }

  public void k()
  {
    this.B = true;
  }

  public void l()
  {
    if ((G()) && (this.x != null))
      p();
  }

  public void m()
  {
    if ((G()) && (this.x == null))
      n();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.titlebar.DivebarController
 * JD-Core Version:    0.6.0
 */