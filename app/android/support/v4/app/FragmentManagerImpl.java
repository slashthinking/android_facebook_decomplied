package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.LogWriter;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

final class FragmentManagerImpl extends FragmentManager
{
  static final Interpolator A;
  static final Interpolator B;
  static boolean a = false;
  static final boolean b;
  static final Interpolator y;
  static final Interpolator z;
  ArrayList<Runnable> c;
  Runnable[] d;
  boolean e;
  ArrayList<Fragment> f;
  ArrayList<Fragment> g;
  ArrayList<Integer> h;
  ArrayList<BackStackRecord> i;
  ArrayList<Fragment> j;
  ArrayList<BackStackRecord> k;
  ArrayList<Integer> l;
  ArrayList<FragmentManager.OnBackStackChangedListener> m;
  int n = 0;
  FragmentHost o;
  NestedFragment p;
  boolean q;
  boolean r;
  boolean s;
  String t;
  boolean u;
  Bundle v = null;
  SparseArray<Parcelable> w = null;
  Runnable x = new FragmentManagerImpl.1(this);

  static
  {
    int i1 = Build.VERSION.SDK_INT;
    boolean bool = false;
    if (i1 >= 11)
      bool = true;
    b = bool;
    y = new DecelerateInterpolator(2.5F);
    z = new DecelerateInterpolator(1.5F);
    A = new AccelerateInterpolator(2.5F);
    B = new AccelerateInterpolator(1.5F);
  }

  static Animation a(Context paramContext, float paramFloat1, float paramFloat2)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat1, paramFloat2);
    localAlphaAnimation.setInterpolator(z);
    localAlphaAnimation.setDuration(220L);
    return localAlphaAnimation;
  }

  static Animation a(Context paramContext, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setInterpolator(y);
    localScaleAnimation.setDuration(220L);
    localAnimationSet.addAnimation(localScaleAnimation);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat3, paramFloat4);
    localAlphaAnimation.setInterpolator(z);
    localAlphaAnimation.setDuration(220L);
    localAnimationSet.addAnimation(localAlphaAnimation);
    return localAnimationSet;
  }

  public static int b(int paramInt, boolean paramBoolean)
  {
    int i1 = -1;
    switch (paramInt)
    {
    default:
    case 4097:
    case 8194:
    case 4099:
    }
    while (true)
    {
      return i1;
      if (paramBoolean)
      {
        i1 = 1;
        continue;
      }
      i1 = 2;
      continue;
      if (paramBoolean)
      {
        i1 = 3;
        continue;
      }
      i1 = 4;
      continue;
      if (paramBoolean)
      {
        i1 = 5;
        continue;
      }
      i1 = 6;
    }
  }

  public static int e(int paramInt)
  {
    int i1 = 0;
    switch (paramInt)
    {
    default:
    case 4097:
    case 8194:
    case 4099:
    }
    while (true)
    {
      return i1;
      i1 = 8194;
      continue;
      i1 = 4097;
      continue;
      i1 = 4099;
    }
  }

  private void v()
  {
    if (this.r)
      throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    if (this.t != null)
      throw new IllegalStateException("Can not perform this action inside of " + this.t);
  }

  public int a(BackStackRecord paramBackStackRecord)
  {
    monitorenter;
    int i1;
    try
    {
      if ((this.l == null) || (this.l.size() <= 0))
      {
        if (this.k == null)
          this.k = new ArrayList();
        i1 = this.k.size();
        if (a)
          Log.v("FragmentManager", "Setting back stack index " + i1 + " to " + paramBackStackRecord);
        this.k.add(paramBackStackRecord);
        monitorexit;
      }
      else
      {
        i1 = ((Integer)this.l.remove(-1 + this.l.size())).intValue();
        if (a)
          Log.v("FragmentManager", "Adding back stack index " + i1 + " with " + paramBackStackRecord);
        this.k.set(i1, paramBackStackRecord);
        monitorexit;
      }
    }
    finally
    {
      localObject = finally;
      monitorexit;
      throw localObject;
    }
    return i1;
  }

  public Fragment.SavedState a(Fragment paramFragment)
  {
    if (paramFragment.o < 0)
      throw new IllegalStateException("Fragment " + paramFragment + " is not currently in the FragmentManager");
    int i1 = paramFragment.j;
    Fragment.SavedState localSavedState = null;
    if (i1 > 0)
    {
      Bundle localBundle = g(paramFragment);
      localSavedState = null;
      if (localBundle != null)
        localSavedState = new Fragment.SavedState(localBundle);
    }
    return localSavedState;
  }

  public Fragment a(int paramInt)
  {
    int i2;
    Fragment localFragment;
    if (this.g != null)
    {
      i2 = -1 + this.g.size();
      if (i2 >= 0)
      {
        localFragment = (Fragment)this.g.get(i2);
        if ((localFragment == null) || (localFragment.F != paramInt));
      }
    }
    while (true)
    {
      return localFragment;
      i2--;
      break;
      if (this.f != null)
        for (int i1 = -1 + this.f.size(); ; i1--)
        {
          if (i1 < 0)
            break label107;
          localFragment = (Fragment)this.f.get(i1);
          if ((localFragment != null) && (localFragment.F == paramInt))
            break;
        }
      label107: localFragment = null;
    }
  }

  public Fragment a(Bundle paramBundle, String paramString)
  {
    int i1 = paramBundle.getInt(paramString, -1);
    Fragment localFragment;
    if (i1 == -1)
      localFragment = null;
    do
    {
      return localFragment;
      if (i1 >= this.f.size())
        throw new IllegalStateException("Fragement no longer exists for key " + paramString + ": index " + i1);
      localFragment = (Fragment)this.f.get(i1);
    }
    while (localFragment != null);
    throw new IllegalStateException("Fragement no longer exists for key " + paramString + ": index " + i1);
  }

  public Fragment a(String paramString)
  {
    int i2;
    Fragment localFragment;
    if ((this.g != null) && (paramString != null))
    {
      i2 = -1 + this.g.size();
      if (i2 >= 0)
      {
        localFragment = (Fragment)this.g.get(i2);
        if ((localFragment == null) || (!paramString.equals(localFragment.H)));
      }
    }
    while (true)
    {
      return localFragment;
      i2--;
      break;
      if ((this.f != null) && (paramString != null))
        for (int i1 = -1 + this.f.size(); ; i1--)
        {
          if (i1 < 0)
            break label121;
          localFragment = (Fragment)this.f.get(i1);
          if ((localFragment != null) && (paramString.equals(localFragment.H)))
            break;
        }
      label121: localFragment = null;
    }
  }

  public FragmentTransaction a()
  {
    return new BackStackRecord(this);
  }

  Animation a(Fragment paramFragment, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Animation localAnimation = paramFragment.a(paramInt1, paramBoolean, paramFragment.P);
    if (localAnimation != null);
    while (true)
    {
      return localAnimation;
      if (paramFragment.P != 0)
      {
        localAnimation = AnimationUtils.loadAnimation(this.o.a(), paramFragment.P);
        if (localAnimation != null)
          continue;
      }
      if (paramInt1 == 0)
      {
        localAnimation = null;
        continue;
      }
      int i1 = b(paramInt1, paramBoolean);
      if (i1 < 0)
      {
        localAnimation = null;
        continue;
      }
      switch (i1)
      {
      default:
        if ((paramInt2 == 0) && (this.o.d() != null))
          paramInt2 = this.o.d().getAttributes().windowAnimations;
        if (paramInt2 == 0)
          localAnimation = null;
        break;
      case 1:
        localAnimation = a(this.o.a(), 1.125F, 1.0F, 0.0F, 1.0F);
        break;
      case 2:
        localAnimation = a(this.o.a(), 1.0F, 0.975F, 1.0F, 0.0F);
        break;
      case 3:
        localAnimation = a(this.o.a(), 0.975F, 1.0F, 0.0F, 1.0F);
        break;
      case 4:
        localAnimation = a(this.o.a(), 1.0F, 1.075F, 1.0F, 0.0F);
        break;
      case 5:
        localAnimation = a(this.o.a(), 0.0F, 1.0F);
        break;
      case 6:
        localAnimation = a(this.o.a(), 1.0F, 0.0F);
        continue;
        localAnimation = null;
      }
    }
  }

  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
      throw new IllegalArgumentException("Bad id: " + paramInt1);
    a(new FragmentManagerImpl.4(this, paramInt1, paramInt2), false);
  }

  void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if ((this.o == null) && (paramInt1 != 0))
      throw new IllegalStateException("No activity");
    if ((!paramBoolean) && (this.n == paramInt1));
    do
    {
      return;
      this.n = paramInt1;
    }
    while (this.f == null);
    int i1 = 0;
    boolean bool1 = false;
    label54: Fragment localFragment;
    if (i1 < this.f.size())
    {
      localFragment = (Fragment)this.f.get(i1);
      if (localFragment == null)
        break label172;
      a(localFragment, paramInt1, paramInt2, paramInt3, false);
      if (localFragment.V == null)
        break label172;
    }
    label172: for (boolean bool2 = bool1 | localFragment.V.a(); ; bool2 = bool1)
    {
      i1++;
      bool1 = bool2;
      break label54;
      if (!bool1)
        g();
      if ((!this.q) || (this.o == null) || (this.n != 5))
        break;
      this.o.k();
      this.q = false;
      break;
    }
  }

  public void a(int paramInt, BackStackRecord paramBackStackRecord)
  {
    monitorenter;
    try
    {
      if (this.k == null)
        this.k = new ArrayList();
      int i1 = this.k.size();
      if (paramInt < i1)
      {
        if (a)
          Log.v("FragmentManager", "Setting back stack index " + paramInt + " to " + paramBackStackRecord);
        this.k.set(paramInt, paramBackStackRecord);
        return;
      }
      while (i1 < paramInt)
      {
        this.k.add(null);
        if (this.l == null)
          this.l = new ArrayList();
        if (a)
          Log.v("FragmentManager", "Adding available back stack index " + i1);
        this.l.add(Integer.valueOf(i1));
        i1++;
      }
      if (a)
        Log.v("FragmentManager", "Adding back stack index " + paramInt + " with " + paramBackStackRecord);
      this.k.add(paramBackStackRecord);
    }
    finally
    {
      monitorexit;
    }
  }

  void a(int paramInt, boolean paramBoolean)
  {
    a(paramInt, 0, 0, paramBoolean);
  }

  public void a(Configuration paramConfiguration)
  {
    if (this.g != null)
      for (int i1 = 0; i1 < this.g.size(); i1++)
      {
        Fragment localFragment = (Fragment)this.g.get(i1);
        if (localFragment == null)
          continue;
        localFragment.onConfigurationChanged(paramConfiguration);
      }
  }

  public void a(Bundle paramBundle, String paramString, Fragment paramFragment)
  {
    if (paramFragment.o < 0)
      throw new IllegalStateException("Fragment " + paramFragment + " is not currently in the FragmentManager");
    paramBundle.putInt(paramString, paramFragment.o);
  }

  void a(Parcelable paramParcelable, ArrayList<Fragment> paramArrayList)
  {
    int i1 = 0;
    if (paramParcelable == null);
    while (true)
    {
      return;
      FragmentManagerState localFragmentManagerState = (FragmentManagerState)paramParcelable;
      if (localFragmentManagerState.a == null)
        continue;
      if (paramArrayList != null)
        for (int i5 = 0; i5 < paramArrayList.size(); i5++)
        {
          Fragment localFragment4 = (Fragment)paramArrayList.get(i5);
          if (a)
            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + localFragment4);
          FragmentState localFragmentState2 = localFragmentManagerState.a[localFragment4.o];
          localFragmentState2.l = localFragment4;
          localFragment4.n = null;
          localFragment4.B = 0;
          localFragment4.z = false;
          localFragment4.v = false;
          localFragment4.s = null;
          if (localFragmentState2.k == null)
            continue;
          localFragmentState2.k.setClassLoader(this.o.a().getClassLoader());
          localFragment4.n = localFragmentState2.k.getSparseParcelableArray("android:view_state");
        }
      this.f = new ArrayList(localFragmentManagerState.a.length);
      if (this.h != null)
        this.h.clear();
      int i2 = 0;
      if (i2 < localFragmentManagerState.a.length)
      {
        FragmentState localFragmentState1 = localFragmentManagerState.a[i2];
        if (localFragmentState1 != null)
        {
          Fragment localFragment3 = localFragmentState1.a(this.o);
          if (a)
            Log.v("FragmentManager", "restoreAllState: adding #" + i2 + ": " + localFragment3);
          this.f.add(localFragment3);
          localFragmentState1.l = null;
        }
        while (true)
        {
          i2++;
          break;
          if (a)
            Log.v("FragmentManager", "restoreAllState: adding #" + i2 + ": (null)");
          this.f.add(null);
          if (this.h == null)
            this.h = new ArrayList();
          if (a)
            Log.v("FragmentManager", "restoreAllState: adding avail #" + i2);
          this.h.add(Integer.valueOf(i2));
        }
      }
      if (paramArrayList != null)
      {
        int i4 = 0;
        if (i4 < paramArrayList.size())
        {
          Fragment localFragment2 = (Fragment)paramArrayList.get(i4);
          if (localFragment2.t >= 0)
            if (localFragment2.t >= this.f.size())
              break label507;
          for (localFragment2.s = ((Fragment)this.f.get(localFragment2.t)); ; localFragment2.s = null)
          {
            i4++;
            break;
            label507: Log.w("FragmentManager", "Re-attaching retained fragment " + localFragment2 + " target no longer exists: " + localFragment2.t);
          }
        }
      }
      if (localFragmentManagerState.b != null)
      {
        this.g = new ArrayList(localFragmentManagerState.b.length);
        for (int i3 = 0; i3 < localFragmentManagerState.b.length; i3++)
        {
          Fragment localFragment1 = (Fragment)this.f.get(localFragmentManagerState.b[i3]);
          if (localFragment1 == null)
            throw new IllegalStateException("No instantiated fragment for index #" + localFragmentManagerState.b[i3]);
          localFragment1.v = true;
          if (a)
            Log.v("FragmentManager", "restoreAllState: making added #" + i3 + ": " + localFragment1);
          this.g.add(localFragment1);
        }
      }
      this.g = null;
      if (localFragmentManagerState.c != null)
      {
        this.i = new ArrayList(localFragmentManagerState.c.length);
        while (i1 < localFragmentManagerState.c.length)
        {
          BackStackRecord localBackStackRecord = localFragmentManagerState.c[i1].a(this);
          if (a)
            Log.v("FragmentManager", "restoreAllState: adding bse #" + i1 + " (index " + localBackStackRecord.o + "): " + localBackStackRecord);
          this.i.add(localBackStackRecord);
          if (localBackStackRecord.o >= 0)
            a(localBackStackRecord.o, localBackStackRecord);
          i1++;
        }
        continue;
      }
      this.i = null;
    }
  }

  public void a(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (a)
      Log.v("FragmentManager", "remove: " + paramFragment + " nesting=" + paramFragment.B);
    int i1;
    if (!paramFragment.j())
    {
      i1 = 1;
      if ((!paramFragment.J) || (i1 != 0))
      {
        if (this.g != null)
          this.g.remove(paramFragment);
        if ((paramFragment.M) && (paramFragment.N))
          this.q = true;
        paramFragment.v = false;
        paramFragment.w = true;
        if (i1 == 0)
          break label137;
      }
    }
    label137: for (int i2 = 0; ; i2 = 1)
    {
      a(paramFragment, i2, paramInt1, paramInt2, false);
      return;
      i1 = 0;
      break;
    }
  }

  void a(Fragment paramFragment, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if ((!paramFragment.v) && (paramInt1 > 1))
      paramInt1 = 1;
    if ((paramFragment.w) && (paramInt1 > paramFragment.j))
      paramInt1 = paramFragment.j;
    if ((paramFragment.T) && (paramFragment.j < 4) && (paramInt1 > 3))
      paramInt1 = 3;
    if (paramFragment.j < paramInt1)
    {
      if ((paramFragment.y) && (!paramFragment.z))
        return;
      if (paramFragment.k != null)
      {
        paramFragment.k = null;
        a(paramFragment, paramFragment.l, 0, 0, true);
      }
      switch (paramFragment.j)
      {
      default:
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      }
    }
    while (true)
    {
      paramFragment.j = paramInt1;
      break;
      if (a)
        Log.v("FragmentManager", "moveto CREATED: " + paramFragment);
      if (paramFragment.m != null)
      {
        paramFragment.n = paramFragment.m.getSparseParcelableArray("android:view_state");
        paramFragment.s = a(paramFragment.m, "android:target_state");
        if (paramFragment.s != null)
          paramFragment.u = paramFragment.m.getInt("android:target_req_state", 0);
        paramFragment.U = paramFragment.m.getBoolean("android:user_visible_hint", true);
        if (!paramFragment.U)
        {
          paramFragment.T = true;
          if (paramInt1 > 3)
            paramInt1 = 3;
        }
      }
      Context localContext;
      if (this.p != null)
      {
        paramFragment.D = this.p.a(this.o);
        paramFragment.C = this.o.h();
        paramFragment.E = this.p;
        paramFragment.O = false;
        localContext = this.o.a();
        if (!(localContext instanceof Activity))
          break label399;
      }
      label399: for (Activity localActivity = (Activity)localContext; ; localActivity = null)
      {
        paramFragment.a(localActivity);
        if (paramFragment.O)
          break label405;
        throw new SuperNotCalledException("Fragment " + paramFragment + " did not call through to super.onAttach()");
        paramFragment.D = this.o;
        break;
      }
      label405: this.o.a(paramFragment);
      if (this.p != null)
        this.p.a(paramFragment);
      if (!paramFragment.L)
      {
        paramFragment.O = false;
        paramFragment.a(paramFragment.m);
        if (!paramFragment.O)
          throw new SuperNotCalledException("Fragment " + paramFragment + " did not call through to super.onCreate()");
      }
      paramFragment.L = false;
      if (paramFragment.y)
      {
        paramFragment.R = paramFragment.a(paramFragment.b(paramFragment.m), null, paramFragment.m);
        if (paramFragment.R != null)
        {
          paramFragment.S = paramFragment.R;
          paramFragment.R = NoSaveStateFrameLayout.a(paramFragment.R);
          if (paramFragment.I)
            paramFragment.R.setVisibility(8);
          paramFragment.a(paramFragment.R, paramFragment.m);
        }
      }
      else
      {
        if (paramInt1 <= 1)
          break label936;
        if (a)
          Log.v("FragmentManager", "moveto ACTIVITY_CREATED: " + paramFragment);
        if (paramFragment.y)
          break label859;
        if (paramFragment.G == 0)
          break label735;
        if (this.p == null)
          break label716;
      }
      label716: for (ViewGroup localViewGroup = (ViewGroup)this.p.A().findViewById(paramFragment.G); ; localViewGroup = (ViewGroup)this.o.b(paramFragment.G))
      {
        if ((localViewGroup != null) || (paramFragment.A))
          break label738;
        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(paramFragment.G) + " for fragment " + paramFragment);
        paramFragment.S = null;
        break;
      }
      label735: localViewGroup = null;
      label738: paramFragment.Q = localViewGroup;
      paramFragment.R = paramFragment.a(paramFragment.b(paramFragment.m), localViewGroup, paramFragment.m);
      if (paramFragment.R != null)
      {
        paramFragment.S = paramFragment.R;
        paramFragment.R = NoSaveStateFrameLayout.a(paramFragment.R);
        if (localViewGroup != null)
        {
          Animation localAnimation2 = a(paramFragment, paramInt2, true, paramInt3);
          if (localAnimation2 != null)
            paramFragment.R.startAnimation(localAnimation2);
          localViewGroup.addView(paramFragment.R);
        }
        if (paramFragment.I)
          paramFragment.R.setVisibility(8);
        paramFragment.a(paramFragment.R, paramFragment.m);
      }
      while (true)
      {
        label859: paramFragment.O = false;
        paramFragment.d(paramFragment.m);
        if (paramFragment.O)
          break;
        throw new SuperNotCalledException("Fragment " + paramFragment + " did not call through to super.onActivityCreated()");
        paramFragment.S = null;
      }
      if (paramFragment.R != null)
        paramFragment.k_();
      paramFragment.m = null;
      label936: if (paramInt1 > 3)
      {
        if (a)
          Log.v("FragmentManager", "moveto STARTED: " + paramFragment);
        paramFragment.O = false;
        paramFragment.G();
        if (!paramFragment.O)
          throw new SuperNotCalledException("Fragment " + paramFragment + " did not call through to super.onStart()");
      }
      if (paramInt1 <= 4)
        continue;
      if (a)
        Log.v("FragmentManager", "moveto RESUMED: " + paramFragment);
      paramFragment.O = false;
      paramFragment.x = true;
      paramFragment.B();
      if (!paramFragment.O)
        throw new SuperNotCalledException("Fragment " + paramFragment + " did not call through to super.onResume()");
      paramFragment.m = null;
      paramFragment.n = null;
      continue;
      if (paramFragment.j <= paramInt1)
        continue;
      switch (paramFragment.j)
      {
      default:
      case 1:
      case 5:
      case 4:
      case 3:
      case 2:
      }
    }
    label1175: 
    do
    {
      if (paramInt1 >= 1)
        break;
      if ((this.s) && (paramFragment.k != null))
      {
        View localView = paramFragment.k;
        paramFragment.k = null;
        localView.clearAnimation();
      }
      if (paramFragment.k == null)
        break label1669;
      paramFragment.l = paramInt1;
      paramInt1 = 1;
      break;
      if (paramInt1 < 5)
      {
        if (a)
          Log.v("FragmentManager", "movefrom RESUMED: " + paramFragment);
        paramFragment.O = false;
        paramFragment.C();
        if (!paramFragment.O)
          throw new SuperNotCalledException("Fragment " + paramFragment + " did not call through to super.onPause()");
        paramFragment.x = false;
      }
      if (paramInt1 < 4)
      {
        if (a)
          Log.v("FragmentManager", "movefrom STARTED: " + paramFragment);
        paramFragment.O = false;
        paramFragment.H();
        if (!paramFragment.O)
          throw new SuperNotCalledException("Fragment " + paramFragment + " did not call through to super.onStop()");
      }
      if (paramInt1 >= 3)
        continue;
      if (a)
        Log.v("FragmentManager", "movefrom STOPPED: " + paramFragment);
      paramFragment.I();
    }
    while (paramInt1 >= 2);
    if (a)
      Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: " + paramFragment);
    if ((paramFragment.R != null) && (!this.o.c()) && (paramFragment.n == null))
      f(paramFragment);
    paramFragment.O = false;
    paramFragment.J();
    if (!paramFragment.O)
      throw new SuperNotCalledException("Fragment " + paramFragment + " did not call through to super.onDestroyView()");
    if ((paramFragment.R != null) && (paramFragment.Q != null))
      if ((this.n <= 0) || (this.s))
        break label1844;
    label1669: label1844: for (Animation localAnimation1 = a(paramFragment, paramInt2, false, paramInt3); ; localAnimation1 = null)
    {
      if (localAnimation1 != null)
      {
        paramFragment.k = paramFragment.R;
        paramFragment.l = paramInt1;
        localAnimation1.setAnimationListener(new FragmentManagerImpl.5(this, paramFragment));
        paramFragment.R.startAnimation(localAnimation1);
      }
      paramFragment.Q.removeView(paramFragment.R);
      paramFragment.Q = null;
      paramFragment.R = null;
      paramFragment.S = null;
      break label1175;
      if (a)
        Log.v("FragmentManager", "movefrom CREATED: " + paramFragment);
      if (!paramFragment.L)
      {
        paramFragment.O = false;
        paramFragment.D();
        if (!paramFragment.O)
          throw new SuperNotCalledException("Fragment " + paramFragment + " did not call through to super.onDestroy()");
      }
      paramFragment.O = false;
      paramFragment.e();
      if (!paramFragment.O)
        throw new SuperNotCalledException("Fragment " + paramFragment + " did not call through to super.onDetach()");
      if (paramBoolean)
        break;
      if (!paramFragment.L)
      {
        e(paramFragment);
        break;
      }
      paramFragment.D = null;
      paramFragment.E = null;
      paramFragment.C = null;
      break;
    }
  }

  public void a(Fragment paramFragment, boolean paramBoolean)
  {
    if (this.g == null)
      this.g = new ArrayList();
    if (a)
      Log.v("FragmentManager", "add: " + paramFragment);
    d(paramFragment);
    if (!paramFragment.J)
    {
      this.g.add(paramFragment);
      paramFragment.v = true;
      paramFragment.w = false;
      if ((paramFragment.M) && (paramFragment.N))
        this.q = true;
      if (paramBoolean)
        c(paramFragment);
    }
  }

  public void a(FragmentHost paramFragmentHost)
  {
    if (this.o != null)
      throw new IllegalStateException();
    this.o = paramFragmentHost;
  }

  public void a(FragmentManager.OnBackStackChangedListener paramOnBackStackChangedListener)
  {
    if (this.m == null)
      this.m = new ArrayList();
    this.m.add(paramOnBackStackChangedListener);
  }

  public void a(NestedFragment paramNestedFragment)
  {
    this.p = paramNestedFragment;
  }

  // ERROR //
  public void a(Runnable paramRunnable, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifne +7 -> 8
    //   4: aload_0
    //   5: invokespecial 703	android/support/v4/app/FragmentManagerImpl:v	()V
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield 267	android/support/v4/app/FragmentManagerImpl:o	Landroid/support/v4/app/FragmentHost;
    //   14: ifnonnull +19 -> 33
    //   17: new 134	java/lang/IllegalStateException
    //   20: dup
    //   21: ldc_w 705
    //   24: invokespecial 139	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   27: athrow
    //   28: astore_3
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_3
    //   32: athrow
    //   33: aload_0
    //   34: getfield 707	android/support/v4/app/FragmentManagerImpl:c	Ljava/util/ArrayList;
    //   37: ifnonnull +14 -> 51
    //   40: aload_0
    //   41: new 159	java/util/ArrayList
    //   44: dup
    //   45: invokespecial 166	java/util/ArrayList:<init>	()V
    //   48: putfield 707	android/support/v4/app/FragmentManagerImpl:c	Ljava/util/ArrayList;
    //   51: aload_0
    //   52: getfield 707	android/support/v4/app/FragmentManagerImpl:c	Ljava/util/ArrayList;
    //   55: aload_1
    //   56: invokevirtual 187	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   59: pop
    //   60: aload_0
    //   61: getfield 707	android/support/v4/app/FragmentManagerImpl:c	Ljava/util/ArrayList;
    //   64: invokevirtual 163	java/util/ArrayList:size	()I
    //   67: iconst_1
    //   68: if_icmpne +32 -> 100
    //   71: aload_0
    //   72: getfield 267	android/support/v4/app/FragmentManagerImpl:o	Landroid/support/v4/app/FragmentHost;
    //   75: invokevirtual 710	android/support/v4/app/FragmentHost:b	()Landroid/os/Handler;
    //   78: aload_0
    //   79: getfield 94	android/support/v4/app/FragmentManagerImpl:x	Ljava/lang/Runnable;
    //   82: invokevirtual 716	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   85: aload_0
    //   86: getfield 267	android/support/v4/app/FragmentManagerImpl:o	Landroid/support/v4/app/FragmentHost;
    //   89: invokevirtual 710	android/support/v4/app/FragmentHost:b	()Landroid/os/Handler;
    //   92: aload_0
    //   93: getfield 94	android/support/v4/app/FragmentManagerImpl:x	Ljava/lang/Runnable;
    //   96: invokevirtual 720	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   99: pop
    //   100: aload_0
    //   101: monitorexit
    //   102: return
    //
    // Exception table:
    //   from	to	target	type
    //   10	31	28	finally
    //   33	102	28	finally
  }

  public void a(String paramString, int paramInt)
  {
    a(new FragmentManagerImpl.3(this, paramString, paramInt), false);
  }

  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int i1 = 0;
    String str = paramString + "    ";
    if (this.f != null)
    {
      int i11 = this.f.size();
      if (i11 > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("Active Fragments in ");
        paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
        paramPrintWriter.println(":");
        for (int i12 = 0; i12 < i11; i12++)
        {
          Fragment localFragment3 = (Fragment)this.f.get(i12);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i12);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(localFragment3);
          if (localFragment3 == null)
            continue;
          localFragment3.a(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        }
      }
    }
    if (this.g != null)
    {
      int i9 = this.g.size();
      if (i9 > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Added Fragments:");
        for (int i10 = 0; i10 < i9; i10++)
        {
          Fragment localFragment2 = (Fragment)this.g.get(i10);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i10);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(localFragment2.toString());
        }
      }
    }
    if (this.j != null)
    {
      int i7 = this.j.size();
      if (i7 > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Fragments Created Menus:");
        for (int i8 = 0; i8 < i7; i8++)
        {
          Fragment localFragment1 = (Fragment)this.j.get(i8);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i8);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(localFragment1.toString());
        }
      }
    }
    if (this.i != null)
    {
      int i5 = this.i.size();
      if (i5 > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Back Stack:");
        for (int i6 = 0; i6 < i5; i6++)
        {
          BackStackRecord localBackStackRecord2 = (BackStackRecord)this.i.get(i6);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i6);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(localBackStackRecord2.toString());
          localBackStackRecord2.a(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        }
      }
    }
    monitorenter;
    try
    {
      if (this.k != null)
      {
        int i3 = this.k.size();
        if (i3 > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Back Stack Indices:");
          for (int i4 = 0; i4 < i3; i4++)
          {
            BackStackRecord localBackStackRecord1 = (BackStackRecord)this.k.get(i4);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  #");
            paramPrintWriter.print(i4);
            paramPrintWriter.print(": ");
            paramPrintWriter.println(localBackStackRecord1);
          }
        }
      }
      if ((this.l != null) && (this.l.size() > 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mAvailBackStackIndices: ");
        paramPrintWriter.println(Arrays.toString(this.l.toArray()));
      }
      monitorexit;
      if (this.c != null)
      {
        int i2 = this.c.size();
        if (i2 > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Pending Actions:");
          while (i1 < i2)
          {
            Runnable localRunnable = (Runnable)this.c.get(i1);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  #");
            paramPrintWriter.print(i1);
            paramPrintWriter.print(": ");
            paramPrintWriter.println(localRunnable);
            i1++;
          }
        }
      }
    }
    finally
    {
      monitorexit;
    }
    paramPrintWriter.print(paramString);
    paramPrintWriter.println("FragmentManager misc state:");
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mCurState=");
    paramPrintWriter.print(this.n);
    paramPrintWriter.print(" mStateSaved=");
    paramPrintWriter.print(this.r);
    paramPrintWriter.print(" mDestroyed=");
    paramPrintWriter.println(this.s);
    if (this.q)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mNeedMenuInvalidate=");
      paramPrintWriter.println(this.q);
    }
    if (this.t != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mNoTransactionsBecause=");
      paramPrintWriter.println(this.t);
    }
    if ((this.h != null) && (this.h.size() > 0))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mAvailIndices: ");
      paramPrintWriter.println(Arrays.toString(this.h.toArray()));
    }
  }

  boolean a(Handler paramHandler, String paramString, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList1 = this.i;
    int i1 = 0;
    if (localArrayList1 == null);
    while (true)
    {
      return i1;
      if ((paramString != null) || (paramInt1 >= 0) || ((paramInt2 & 0x1) != 0))
        break;
      int i8 = -1 + this.i.size();
      i1 = 0;
      if (i8 < 0)
        continue;
      ((BackStackRecord)this.i.remove(i8)).b(true);
      i();
    }
    while (true)
    {
      i1 = 1;
      break;
      int i2 = -1;
      if ((paramString != null) || (paramInt1 >= 0))
      {
        for (int i3 = -1 + this.i.size(); ; i3--)
        {
          BackStackRecord localBackStackRecord3;
          if (i3 >= 0)
          {
            localBackStackRecord3 = (BackStackRecord)this.i.get(i3);
            if ((paramString == null) || (!paramString.equals(localBackStackRecord3.c())))
              break label206;
          }
          label206: 
          do
          {
            i1 = 0;
            if (i3 < 0)
              break;
            if ((paramInt2 & 0x1) == 0)
              break label225;
            i3--;
            while (i3 >= 0)
            {
              BackStackRecord localBackStackRecord2 = (BackStackRecord)this.i.get(i3);
              if (((paramString == null) || (!paramString.equals(localBackStackRecord2.c()))) && ((paramInt1 < 0) || (paramInt1 != localBackStackRecord2.o)))
                break;
              i3--;
            }
          }
          while ((paramInt1 >= 0) && (paramInt1 == localBackStackRecord3.o));
        }
        label225: i2 = i3;
      }
      int i4 = -1 + this.i.size();
      i1 = 0;
      if (i2 == i4)
        break;
      ArrayList localArrayList2 = new ArrayList();
      for (int i5 = -1 + this.i.size(); i5 > i2; i5--)
        localArrayList2.add(this.i.remove(i5));
      int i6 = -1 + localArrayList2.size();
      int i7 = 0;
      if (i7 <= i6)
      {
        if (a)
          Log.v("FragmentManager", "Popping back stack state: " + localArrayList2.get(i7));
        BackStackRecord localBackStackRecord1 = (BackStackRecord)localArrayList2.get(i7);
        if (i7 == i6);
        for (boolean bool = true; ; bool = false)
        {
          localBackStackRecord1.b(bool);
          i7++;
          break;
        }
      }
      i();
    }
  }

  public boolean a(Menu paramMenu)
  {
    if (this.g != null)
    {
      int i2 = 0;
      i1 = 0;
      while (i2 < this.g.size())
      {
        Fragment localFragment = (Fragment)this.g.get(i2);
        if ((localFragment != null) && (!localFragment.I) && (localFragment.M) && (localFragment.N))
        {
          i1 = 1;
          localFragment.a(paramMenu);
        }
        i2++;
      }
    }
    int i1 = 0;
    return i1;
  }

  public boolean a(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    ArrayList localArrayList1 = null;
    if (this.g != null)
    {
      int i3 = 0;
      int i4;
      for (i1 = 0; i3 < this.g.size(); i1 = i4)
      {
        Fragment localFragment2 = (Fragment)this.g.get(i3);
        if ((localFragment2 != null) && (!localFragment2.I) && (localFragment2.M) && (localFragment2.N))
        {
          i1 = 1;
          localFragment2.a(paramMenu, paramMenuInflater);
          if (localArrayList1 == null)
            localArrayList1 = new ArrayList();
          localArrayList1.add(localFragment2);
        }
        i4 = i1;
        i3++;
      }
    }
    int i1 = 0;
    ArrayList localArrayList2 = this.j;
    int i2 = 0;
    if (localArrayList2 != null)
      while (i2 < this.j.size())
      {
        Fragment localFragment1 = (Fragment)this.j.get(i2);
        if ((localArrayList1 == null) || (!localArrayList1.contains(localFragment1)))
          localFragment1.F();
        i2++;
      }
    this.j = localArrayList1;
    return i1;
  }

  public boolean a(MenuItem paramMenuItem)
  {
    ArrayList localArrayList = this.g;
    int i1 = 0;
    if (localArrayList != null);
    for (int i2 = 0; ; i2++)
    {
      int i3 = this.g.size();
      i1 = 0;
      if (i2 < i3)
      {
        Fragment localFragment = (Fragment)this.g.get(i2);
        if ((localFragment == null) || (localFragment.I) || (!localFragment.M) || (!localFragment.N) || (!localFragment.a(paramMenuItem)))
          continue;
        i1 = 1;
      }
      return i1;
    }
  }

  public int b(int paramInt)
  {
    if (this.f == null);
    while (true)
    {
      return paramInt;
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext())
      {
        Fragment localFragment = (Fragment)localIterator.next();
        if (localFragment == null)
          continue;
        paramInt = localFragment.b(paramInt);
      }
    }
  }

  void b(BackStackRecord paramBackStackRecord)
  {
    if (this.i == null)
      this.i = new ArrayList();
    this.i.add(paramBackStackRecord);
    i();
  }

  public void b(Fragment paramFragment)
  {
    if (paramFragment.T)
    {
      if (!this.e)
        break label20;
      this.u = true;
    }
    while (true)
    {
      return;
      label20: paramFragment.T = false;
      a(paramFragment, this.n, 0, 0, false);
    }
  }

  public void b(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (a)
      Log.v("FragmentManager", "hide: " + paramFragment);
    if (!paramFragment.I)
    {
      paramFragment.I = true;
      if (paramFragment.R != null)
      {
        Animation localAnimation = a(paramFragment, paramInt1, true, paramInt2);
        if (localAnimation != null)
          paramFragment.R.startAnimation(localAnimation);
        paramFragment.R.setVisibility(8);
      }
      if ((paramFragment.v) && (paramFragment.M) && (paramFragment.N))
        this.q = true;
      paramFragment.d(true);
    }
  }

  public void b(FragmentManager.OnBackStackChangedListener paramOnBackStackChangedListener)
  {
    if (this.m != null)
      this.m.remove(paramOnBackStackChangedListener);
  }

  public void b(Menu paramMenu)
  {
    if (this.g != null)
      for (int i1 = 0; i1 < this.g.size(); i1++)
      {
        Fragment localFragment = (Fragment)this.g.get(i1);
        if ((localFragment == null) || (localFragment.I) || (!localFragment.M) || (!localFragment.N))
          continue;
        localFragment.b(paramMenu);
      }
  }

  public boolean b()
  {
    return h();
  }

  public boolean b(MenuItem paramMenuItem)
  {
    ArrayList localArrayList = this.g;
    int i1 = 0;
    if (localArrayList != null);
    for (int i2 = 0; ; i2++)
    {
      int i3 = this.g.size();
      i1 = 0;
      if (i2 < i3)
      {
        Fragment localFragment = (Fragment)this.g.get(i2);
        if ((localFragment == null) || (localFragment.I) || (!localFragment.U) || (!localFragment.b(paramMenuItem)))
          continue;
        i1 = 1;
      }
      return i1;
    }
  }

  public Fragment c(int paramInt)
  {
    Fragment localFragment1;
    if (this.f == null)
      localFragment1 = null;
    while (true)
    {
      return localFragment1;
      Iterator localIterator = this.f.iterator();
      while (true)
        if (localIterator.hasNext())
        {
          Fragment localFragment2 = (Fragment)localIterator.next();
          if ((localFragment2 == null) || (localFragment2.p < paramInt))
            continue;
          localFragment1 = localFragment2.c(paramInt);
          break;
        }
      localFragment1 = null;
    }
  }

  void c(Fragment paramFragment)
  {
    a(paramFragment, this.n, 0, 0, false);
  }

  public void c(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (a)
      Log.v("FragmentManager", "show: " + paramFragment);
    if (paramFragment.I)
    {
      paramFragment.I = false;
      if (paramFragment.R != null)
      {
        Animation localAnimation = a(paramFragment, paramInt1, true, paramInt2);
        if (localAnimation != null)
          paramFragment.R.startAnimation(localAnimation);
        paramFragment.R.setVisibility(0);
      }
      if ((paramFragment.v) && (paramFragment.M) && (paramFragment.N))
        this.q = true;
      paramFragment.d(false);
    }
  }

  public boolean c()
  {
    if ((!this.r) && (this.t == null));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public void d()
  {
    a(new FragmentManagerImpl.2(this), false);
  }

  public void d(int paramInt)
  {
    monitorenter;
    try
    {
      this.k.set(paramInt, null);
      if (this.l == null)
        this.l = new ArrayList();
      if (a)
        Log.v("FragmentManager", "Freeing back stack index " + paramInt);
      this.l.add(Integer.valueOf(paramInt));
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  void d(Fragment paramFragment)
  {
    if (paramFragment.o >= 0);
    label138: 
    while (true)
    {
      return;
      if ((this.h == null) || (this.h.size() <= 0))
      {
        if (this.f == null)
          this.f = new ArrayList();
        paramFragment.a(this.f.size());
        this.f.add(paramFragment);
      }
      while (true)
      {
        if (!a)
          break label138;
        Log.v("FragmentManager", "Allocated fragment index " + paramFragment);
        break;
        paramFragment.a(((Integer)this.h.remove(-1 + this.h.size())).intValue());
        this.f.set(paramFragment.o, paramFragment);
      }
    }
  }

  public void d(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (a)
      Log.v("FragmentManager", "detach: " + paramFragment);
    if (!paramFragment.J)
    {
      paramFragment.J = true;
      if (paramFragment.v)
      {
        if (this.g != null)
          this.g.remove(paramFragment);
        if ((paramFragment.M) && (paramFragment.N))
          this.q = true;
        paramFragment.v = false;
        a(paramFragment, 1, paramInt1, paramInt2, false);
      }
    }
  }

  void e(Fragment paramFragment)
  {
    if (paramFragment.o < 0);
    while (true)
    {
      return;
      if (a)
        Log.v("FragmentManager", "Freeing fragment index " + paramFragment);
      this.f.set(paramFragment.o, null);
      paramFragment.p = -1;
      if (this.h == null)
        this.h = new ArrayList();
      this.h.add(Integer.valueOf(paramFragment.o));
      this.o.a(paramFragment.o);
      paramFragment.E();
    }
  }

  public void e(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (a)
      Log.v("FragmentManager", "attach: " + paramFragment);
    if (paramFragment.J)
    {
      paramFragment.J = false;
      if (!paramFragment.v)
      {
        if (this.g == null)
          this.g = new ArrayList();
        this.g.add(paramFragment);
        paramFragment.v = true;
        if ((paramFragment.M) && (paramFragment.N))
          this.q = true;
        a(paramFragment, this.n, paramInt1, paramInt2, false);
      }
    }
  }

  public boolean e()
  {
    v();
    b();
    return a(this.o.b(), null, -1, 0);
  }

  public int f()
  {
    if (this.i != null);
    for (int i1 = this.i.size(); ; i1 = 0)
      return i1;
  }

  void f(Fragment paramFragment)
  {
    if (paramFragment.S == null)
      return;
    if (this.w == null)
      this.w = new SparseArray();
    while (true)
    {
      paramFragment.S.saveHierarchyState(this.w);
      if (this.w.size() <= 0)
        break;
      paramFragment.n = this.w;
      this.w = null;
      break;
      this.w.clear();
    }
  }

  Bundle g(Fragment paramFragment)
  {
    if (this.v == null)
      this.v = new Bundle();
    paramFragment.e(this.v);
    Bundle localBundle;
    if (!this.v.isEmpty())
    {
      localBundle = this.v;
      this.v = null;
    }
    while (true)
    {
      if (paramFragment.R != null)
        f(paramFragment);
      if (paramFragment.n != null)
      {
        if (localBundle == null)
          localBundle = new Bundle();
        localBundle.putSparseParcelableArray("android:view_state", paramFragment.n);
      }
      if (!paramFragment.U)
      {
        if (localBundle == null)
          localBundle = new Bundle();
        localBundle.putBoolean("android:user_visible_hint", paramFragment.U);
      }
      return localBundle;
      localBundle = null;
    }
  }

  void g()
  {
    if (this.f == null);
    while (true)
    {
      return;
      for (int i1 = 0; i1 < this.f.size(); i1++)
      {
        Fragment localFragment = (Fragment)this.f.get(i1);
        if (localFragment == null)
          continue;
        b(localFragment);
      }
    }
  }

  public boolean h()
  {
    if (this.e)
      throw new IllegalStateException("Recursive entry to executePendingTransactions");
    if (Looper.myLooper() != this.o.b().getLooper())
      throw new IllegalStateException("Must be called from main thread of process");
    int i1 = 0;
    while (true)
    {
      monitorenter;
      boolean bool;
      try
      {
        if ((this.c == null) || (this.c.size() == 0))
        {
          monitorexit;
          if (!this.u)
            break;
          int i2 = 0;
          bool = false;
          while (i2 < this.f.size())
          {
            Fragment localFragment = (Fragment)this.f.get(i2);
            if ((localFragment != null) && (localFragment.V != null))
              bool |= localFragment.V.a();
            i2++;
          }
        }
        int i3 = this.c.size();
        if ((this.d == null) || (this.d.length < i3))
          this.d = new Runnable[i3];
        this.c.toArray(this.d);
        this.c.clear();
        this.o.b().removeCallbacks(this.x);
        monitorexit;
        this.e = true;
        for (int i4 = 0; i4 < i3; i4++)
        {
          this.d[i4].run();
          this.d[i4] = null;
        }
      }
      finally
      {
        monitorexit;
      }
      this.e = false;
      i1 = 1;
      continue;
      if (bool)
        break;
      this.u = false;
      g();
    }
    return i1;
  }

  void i()
  {
    if (this.m != null)
      for (int i1 = 0; i1 < this.m.size(); i1++)
        ((FragmentManager.OnBackStackChangedListener)this.m.get(i1)).a();
  }

  ArrayList<Fragment> j()
  {
    ArrayList localArrayList1 = this.f;
    ArrayList localArrayList2 = null;
    if (localArrayList1 != null)
    {
      int i1 = 0;
      if (i1 < this.f.size())
      {
        Fragment localFragment = (Fragment)this.f.get(i1);
        if ((localFragment != null) && (localFragment.K))
        {
          if (localArrayList2 == null)
            localArrayList2 = new ArrayList();
          localArrayList2.add(localFragment);
          localFragment.L = true;
          if (localFragment.s == null)
            break label139;
        }
        label139: for (int i2 = localFragment.s.o; ; i2 = -1)
        {
          localFragment.t = i2;
          if (a)
            Log.v("FragmentManager", "retainNonConfig: keeping retained " + localFragment);
          i1++;
          break;
        }
      }
    }
    return localArrayList2;
  }

  Parcelable k()
  {
    h();
    if (b)
      this.r = true;
    ArrayList localArrayList1 = this.f;
    Object localObject = null;
    if (localArrayList1 != null)
    {
      int i1 = this.f.size();
      localObject = null;
      if (i1 > 0);
    }
    else
    {
      return localObject;
    }
    int i2 = this.f.size();
    FragmentState[] arrayOfFragmentState = new FragmentState[i2];
    int i3 = 0;
    int i4 = 0;
    label67: Fragment localFragment;
    FragmentState localFragmentState;
    if (i3 < i2)
    {
      localFragment = (Fragment)this.f.get(i3);
      if (localFragment == null)
        break label877;
      if (localFragment.o < 0)
      {
        String str3 = "Failure saving state: active " + localFragment + " has cleared index: " + localFragment.o;
        Log.e("FragmentManager", str3);
        a("  ", null, new PrintWriter(new LogWriter("FragmentManager")), new String[0]);
        throw new IllegalStateException(str3);
      }
      localFragmentState = new FragmentState(localFragment);
      arrayOfFragmentState[i3] = localFragmentState;
      if ((localFragment.j > 0) && (localFragmentState.k == null))
      {
        localFragmentState.k = g(localFragment);
        if (localFragment.s != null)
        {
          if (localFragment.s.o < 0)
          {
            String str2 = "Failure saving state: " + localFragment + " has target not in fragment manager: " + localFragment.s;
            Log.e("FragmentManager", str2);
            a("  ", null, new PrintWriter(new LogWriter("FragmentManager")), new String[0]);
            throw new IllegalStateException(str2);
          }
          if (localFragmentState.k == null)
            localFragmentState.k = new Bundle();
          a(localFragmentState.k, "android:target_state", localFragment.s);
          if (localFragment.u != 0)
            localFragmentState.k.putInt("android:target_req_state", localFragment.u);
        }
        label392: if (a)
          Log.v("FragmentManager", "Saved state of " + localFragment + ": " + localFragmentState.k);
      }
    }
    label877: for (int i9 = 1; ; i9 = i4)
    {
      i3++;
      i4 = i9;
      break label67;
      localFragmentState.k = localFragment.m;
      break label392;
      if (i4 == 0)
      {
        boolean bool = a;
        localObject = null;
        if (!bool)
          break;
        Log.v("FragmentManager", "saveAllState: no fragments!");
        localObject = null;
        break;
      }
      if (this.g != null)
      {
        int i7 = this.g.size();
        if (i7 > 0)
        {
          arrayOfInt = new int[i7];
          for (int i8 = 0; i8 < i7; i8++)
          {
            arrayOfInt[i8] = ((Fragment)this.g.get(i8)).o;
            if (arrayOfInt[i8] < 0)
            {
              String str1 = "Failure saving state: active " + this.g.get(i8) + " has cleared index: " + arrayOfInt[i8];
              Log.e("FragmentManager", str1);
              a("  ", null, new PrintWriter(new LogWriter("FragmentManager")), new String[0]);
              throw new IllegalStateException(str1);
            }
            if (!a)
              continue;
            Log.v("FragmentManager", "saveAllState: adding fragment #" + i8 + ": " + this.g.get(i8));
          }
        }
      }
      int[] arrayOfInt = null;
      ArrayList localArrayList2 = this.i;
      BackStackState[] arrayOfBackStackState = null;
      if (localArrayList2 != null)
      {
        int i5 = this.i.size();
        arrayOfBackStackState = null;
        if (i5 > 0)
        {
          arrayOfBackStackState = new BackStackState[i5];
          for (int i6 = 0; i6 < i5; i6++)
          {
            arrayOfBackStackState[i6] = new BackStackState(this, (BackStackRecord)this.i.get(i6));
            if (!a)
              continue;
            Log.v("FragmentManager", "saveAllState: adding back stack #" + i6 + ": " + this.i.get(i6));
          }
        }
      }
      FragmentManagerState localFragmentManagerState = new FragmentManagerState();
      localFragmentManagerState.a = arrayOfFragmentState;
      localFragmentManagerState.b = arrayOfInt;
      localFragmentManagerState.c = arrayOfBackStackState;
      localObject = localFragmentManagerState;
      break;
    }
  }

  public void l()
  {
    this.r = false;
  }

  public void m()
  {
    this.r = false;
    a(1, false);
  }

  public void n()
  {
    this.r = false;
    a(2, false);
  }

  public void o()
  {
    this.r = false;
    a(4, false);
  }

  public void p()
  {
    this.r = false;
    a(5, false);
  }

  public void q()
  {
    a(4, false);
  }

  public void r()
  {
    this.r = true;
    a(3, false);
  }

  public void s()
  {
    a(2, false);
  }

  public void t()
  {
    this.s = true;
    h();
    a(0, false);
    this.o = null;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("FragmentManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    DebugUtils.a(this.o, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }

  public void u()
  {
    if (this.g != null)
      for (int i1 = 0; i1 < this.g.size(); i1++)
      {
        Fragment localFragment = (Fragment)this.g.get(i1);
        if (localFragment == null)
          continue;
        localFragment.onLowMemory();
      }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentManagerImpl
 * JD-Core Version:    0.6.0
 */