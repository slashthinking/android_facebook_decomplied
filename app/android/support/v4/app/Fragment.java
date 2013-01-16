package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.util.DebugUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.HashMap;

public class Fragment
  implements ComponentCallbacks, View.OnCreateContextMenuListener
{
  private static final HashMap<String, Class<?>> a = new HashMap();
  boolean A;
  int B;
  FragmentManagerImpl C;
  FragmentHost D;
  Fragment E;
  int F;
  int G;
  String H;
  boolean I;
  boolean J;
  boolean K;
  boolean L;
  boolean M;
  boolean N = true;
  boolean O;
  int P;
  ViewGroup Q;
  View R;
  View S;
  boolean T;
  boolean U = true;
  LoaderManagerImpl V;
  boolean W;
  boolean X;
  int j = 0;
  View k;
  int l;
  Bundle m;
  SparseArray<Parcelable> n;
  int o = -1;
  int p;
  String q;
  Bundle r;
  Fragment s;
  int t = -1;
  int u;
  boolean v;
  boolean w;
  boolean x;
  boolean y;
  boolean z;

  public static Fragment a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, null);
  }

  public static Fragment a(Context paramContext, String paramString, Bundle paramBundle)
  {
    try
    {
      Class localClass = (Class)a.get(paramString);
      if (localClass == null)
      {
        localClass = paramContext.getClassLoader().loadClass(paramString);
        a.put(paramString, localClass);
      }
      Fragment localFragment = (Fragment)localClass.newInstance();
      if (paramBundle != null)
      {
        paramBundle.setClassLoader(localFragment.getClass().getClassLoader());
        localFragment.r = paramBundle;
      }
      return localFragment;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new Fragment.InstantiationException("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an" + " empty constructor that is public", localClassNotFoundException);
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new Fragment.InstantiationException("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an" + " empty constructor that is public", localInstantiationException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
    }
    throw new Fragment.InstantiationException("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an" + " empty constructor that is public", localIllegalAccessException);
  }

  public View A()
  {
    return this.R;
  }

  public void B()
  {
    this.O = true;
  }

  public void C()
  {
    this.O = true;
  }

  public void D()
  {
    this.O = true;
    if (!this.X)
    {
      this.X = true;
      this.V = this.D.a(this.o, this.W, false);
    }
    if (this.V != null)
      this.V.h();
  }

  void E()
  {
    this.o = -1;
    this.q = null;
    this.v = false;
    this.w = false;
    this.x = false;
    this.y = false;
    this.z = false;
    this.A = false;
    this.B = 0;
    this.C = null;
    this.E = null;
    this.D = null;
    this.F = 0;
    this.G = 0;
    this.H = null;
    this.I = false;
    this.J = false;
    this.L = false;
    this.V = null;
    this.W = false;
    this.X = false;
  }

  public void F()
  {
  }

  void G()
  {
    f();
    if (this.V != null)
      this.V.g();
  }

  void H()
  {
    g();
  }

  void I()
  {
    if (this.W)
    {
      this.W = false;
      if (!this.X)
      {
        this.X = true;
        this.V = this.D.a(this.o, this.W, false);
      }
      if (this.V != null)
      {
        if (this.D.i())
          break label69;
        this.V.c();
      }
    }
    while (true)
    {
      return;
      label69: this.V.d();
    }
  }

  void J()
  {
    h();
    if (this.V != null)
      this.V.f();
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return null;
  }

  public Animation a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return null;
  }

  public final String a(int paramInt, Object[] paramArrayOfObject)
  {
    return q().getString(paramInt, paramArrayOfObject);
  }

  final void a(int paramInt)
  {
    this.o = paramInt;
    this.q = ("android:fragment:" + this.o);
  }

  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
  }

  public void a(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    this.O = true;
  }

  public void a(Context paramContext)
  {
    this.O = true;
  }

  public void a(Intent paramIntent)
  {
    if (this.D == null)
      throw new IllegalStateException("Fragment " + this + " not attached to FragmentHost");
    this.D.a(this, paramIntent, -1);
  }

  public void a(Intent paramIntent, int paramInt)
  {
    if (this.D == null)
      throw new IllegalStateException("Fragment " + this + " not attached to FragmentHost");
    this.D.a(this, paramIntent, paramInt);
  }

  public void a(Bundle paramBundle)
  {
    this.O = true;
  }

  public void a(Fragment.SavedState paramSavedState)
  {
    if (this.o >= 0)
      throw new IllegalStateException("Fragment already active");
    if ((paramSavedState != null) && (paramSavedState.a != null));
    for (Bundle localBundle = paramSavedState.a; ; localBundle = null)
    {
      this.m = localBundle;
      return;
    }
  }

  public void a(Menu paramMenu)
  {
  }

  public void a(Menu paramMenu, MenuInflater paramMenuInflater)
  {
  }

  public void a(View paramView)
  {
    paramView.setOnCreateContextMenuListener(this);
  }

  public void a(View paramView, Bundle paramBundle)
  {
  }

  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mFragmentId=#");
    paramPrintWriter.print(Integer.toHexString(this.F));
    paramPrintWriter.print(" mContainerId=#");
    paramPrintWriter.print(Integer.toHexString(this.G));
    paramPrintWriter.print(" mTag=");
    paramPrintWriter.println(this.H);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mState=");
    paramPrintWriter.print(this.j);
    paramPrintWriter.print(" mIndex=");
    paramPrintWriter.print(this.o);
    paramPrintWriter.print(" mWho=");
    paramPrintWriter.print(this.q);
    paramPrintWriter.print(" mBackStackNesting=");
    paramPrintWriter.println(this.B);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mAdded=");
    paramPrintWriter.print(this.v);
    paramPrintWriter.print(" mRemoving=");
    paramPrintWriter.print(this.w);
    paramPrintWriter.print(" mResumed=");
    paramPrintWriter.print(this.x);
    paramPrintWriter.print(" mFromLayout=");
    paramPrintWriter.print(this.y);
    paramPrintWriter.print(" mInLayout=");
    paramPrintWriter.println(this.z);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mHidden=");
    paramPrintWriter.print(this.I);
    paramPrintWriter.print(" mDetached=");
    paramPrintWriter.print(this.J);
    paramPrintWriter.print(" mMenuVisible=");
    paramPrintWriter.print(this.N);
    paramPrintWriter.print(" mHasMenu=");
    paramPrintWriter.println(this.M);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mRetainInstance=");
    paramPrintWriter.print(this.K);
    paramPrintWriter.print(" mRetaining=");
    paramPrintWriter.print(this.L);
    paramPrintWriter.print(" mUserVisibleHint=");
    paramPrintWriter.println(this.U);
    if (this.C != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mFragmentManager=");
      paramPrintWriter.println(this.C);
    }
    if (this.D != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mActivity=");
      paramPrintWriter.println(this.D);
    }
    if (this.r != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mArguments=");
      paramPrintWriter.println(this.r);
    }
    if (this.m != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedFragmentState=");
      paramPrintWriter.println(this.m);
    }
    if (this.n != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedViewState=");
      paramPrintWriter.println(this.n);
    }
    if (this.s != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mTarget=");
      paramPrintWriter.print(this.s);
      paramPrintWriter.print(" mTargetRequestCode=");
      paramPrintWriter.println(this.u);
    }
    if (this.P != 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mNextAnim=");
      paramPrintWriter.println(this.P);
    }
    if (this.Q != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mContainer=");
      paramPrintWriter.println(this.Q);
    }
    if (this.R != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mView=");
      paramPrintWriter.println(this.R);
    }
    if (this.S != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mInnerView=");
      paramPrintWriter.println(this.R);
    }
    if (this.k != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAnimatingAway=");
      paramPrintWriter.println(this.k);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStateAfterAnimating=");
      paramPrintWriter.println(this.l);
    }
    if (this.V != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Loader Manager:");
      this.V.a(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }

  public boolean a(MenuItem paramMenuItem)
  {
    return false;
  }

  public int b(int paramInt)
  {
    this.p = (paramInt + 1);
    return this.p;
  }

  public LayoutInflater b(Bundle paramBundle)
  {
    return this.D.f();
  }

  public void b(Menu paramMenu)
  {
  }

  public boolean b(MenuItem paramMenuItem)
  {
    return false;
  }

  public Fragment c(int paramInt)
  {
    if (this.p == paramInt);
    while (true)
    {
      return this;
      this = null;
    }
  }

  public final CharSequence d(int paramInt)
  {
    return q().getText(paramInt);
  }

  public void d(Bundle paramBundle)
  {
    this.O = true;
  }

  public void d(boolean paramBoolean)
  {
  }

  public final String e(int paramInt)
  {
    return q().getString(paramInt);
  }

  public void e()
  {
    this.O = true;
  }

  public void e(Bundle paramBundle)
  {
  }

  public void e(boolean paramBoolean)
  {
    this.K = paramBoolean;
  }

  public final boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }

  public void f()
  {
    this.O = true;
    if (!this.W)
    {
      this.W = true;
      if (!this.X)
      {
        this.X = true;
        this.V = this.D.a(this.o, this.W, false);
      }
      if (this.V != null)
        this.V.b();
    }
  }

  public void f(Bundle paramBundle)
  {
    if (this.o >= 0)
      throw new IllegalStateException("Fragment already active");
    this.r = paramBundle;
  }

  public void f(boolean paramBoolean)
  {
    if (this.M != paramBoolean)
    {
      this.M = paramBoolean;
      if ((s()) && (!w()))
        this.D.k();
    }
  }

  public void g()
  {
    this.O = true;
  }

  public void g(boolean paramBoolean)
  {
    if (this.N != paramBoolean)
    {
      this.N = paramBoolean;
      if ((this.M) && (s()) && (!w()))
        this.D.k();
    }
  }

  public void h()
  {
    this.O = true;
  }

  public void h(boolean paramBoolean)
  {
    if ((!this.U) && (paramBoolean) && (this.j < 4))
      this.C.b(this);
    this.U = paramBoolean;
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      this.T = bool;
      return;
    }
  }

  public final int hashCode()
  {
    return super.hashCode();
  }

  final boolean j()
  {
    if (this.B > 0);
    for (int i = 1; ; i = 0)
      return i;
  }

  public final String k()
  {
    return this.H;
  }

  final void k_()
  {
    if (this.n != null)
    {
      this.S.restoreHierarchyState(this.n);
      this.n = null;
    }
  }

  public final Fragment l()
  {
    return this.E;
  }

  public final Bundle m()
  {
    return this.r;
  }

  public final FragmentActivity n()
  {
    Context localContext = p();
    if ((localContext != null) && (!(localContext instanceof FragmentActivity)))
      throw new IllegalStateException("Fragment is not hosted in an activity");
    return (FragmentActivity)localContext;
  }

  public final FragmentHost o()
  {
    return this.D;
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.O = true;
  }

  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    o().a(paramContextMenu, paramView, paramContextMenuInfo);
  }

  public void onLowMemory()
  {
    this.O = true;
  }

  public final Context p()
  {
    if (this.D == null);
    for (Context localContext = null; ; localContext = this.D.a())
      return localContext;
  }

  public final Resources q()
  {
    if (this.D == null)
      throw new IllegalStateException("Fragment " + this + " not attached to FragmentHost");
    return this.D.e();
  }

  public final FragmentManager r()
  {
    return this.C;
  }

  public final boolean s()
  {
    if ((this.D != null) && (this.v));
    for (int i = 1; ; i = 0)
      return i;
  }

  public final boolean t()
  {
    return this.J;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    DebugUtils.a(this, localStringBuilder);
    if (this.o >= 0)
    {
      localStringBuilder.append(" #");
      localStringBuilder.append(this.o);
    }
    if (this.F != 0)
    {
      localStringBuilder.append(" id=0x");
      localStringBuilder.append(Integer.toHexString(this.F));
    }
    if (this.H != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(this.H);
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }

  public final boolean u()
  {
    return this.x;
  }

  public final boolean v()
  {
    if ((s()) && (!w()) && (this.R != null) && (this.R.getWindowToken() != null) && (this.R.getVisibility() == 0));
    for (int i = 1; ; i = 0)
      return i;
  }

  public final boolean w()
  {
    return this.I;
  }

  public final boolean x()
  {
    return this.K;
  }

  public void y()
  {
    if (this.D != null)
      this.D.k();
  }

  public LoaderManager z()
  {
    if (this.V != null);
    for (LoaderManagerImpl localLoaderManagerImpl = this.V; ; localLoaderManagerImpl = this.V)
    {
      return localLoaderManagerImpl;
      if (this.D == null)
        throw new IllegalStateException("Fragment " + this + " not attached to FragmentHost");
      this.X = true;
      this.V = this.D.a(this.o, this.W, true);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.app.Fragment
 * JD-Core Version:    0.6.0
 */