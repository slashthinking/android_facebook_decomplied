package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.util.SparseArrayCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FragmentActivity extends Activity
{
  final Handler a = new FragmentActivity.1(this);
  final FragmentManagerImpl b = new FragmentManagerImpl();
  FragmentManagerImpl c = null;
  boolean d;
  boolean e;
  boolean f;
  boolean g;
  boolean h;
  boolean i;
  boolean j;
  boolean k;
  SparseArrayCompat<LoaderManagerImpl> l;
  LoaderManagerImpl m;

  LoaderManagerImpl a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.l == null)
      this.l = new SparseArrayCompat();
    LoaderManagerImpl localLoaderManagerImpl = (LoaderManagerImpl)this.l.a(paramInt);
    if (localLoaderManagerImpl == null)
      if (paramBoolean2)
      {
        localLoaderManagerImpl = new LoaderManagerImpl(this, paramBoolean1);
        this.l.b(paramInt, localLoaderManagerImpl);
      }
    while (true)
    {
      return localLoaderManagerImpl;
      localLoaderManagerImpl.a(this);
    }
  }

  void a(int paramInt)
  {
    if (this.l != null)
    {
      LoaderManagerImpl localLoaderManagerImpl = (LoaderManagerImpl)this.l.a(paramInt);
      if ((localLoaderManagerImpl != null) && (!localLoaderManagerImpl.f))
      {
        localLoaderManagerImpl.h();
        this.l.c(paramInt);
      }
    }
  }

  public void a(Fragment paramFragment)
  {
  }

  public void a(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    if (paramInt == -1)
      super.startActivityForResult(paramIntent, -1);
    while (true)
    {
      return;
      if ((paramInt & 0xFFFF0000) != 0)
        throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
      int n = b(paramFragment);
      if ((0xFFFF0000 & n) != 0)
        throw new IllegalArgumentException("Can only use lower 16 bits for fragment ID");
      super.startActivityForResult(paramIntent, (n << 16) + (0xFFFF & paramInt));
    }
  }

  public void a(FragmentManager paramFragmentManager)
  {
    this.c = ((FragmentManagerImpl)paramFragmentManager);
  }

  void a(boolean paramBoolean)
  {
    if (!this.g)
    {
      this.g = true;
      this.h = paramBoolean;
      this.a.removeMessages(1);
      f();
    }
  }

  public FragmentManager a_()
  {
    return this.c;
  }

  int b(Fragment paramFragment)
  {
    this.b.b(0);
    return paramFragment.p;
  }

  Fragment b(int paramInt)
  {
    return this.b.c(paramInt);
  }

  public void b_()
  {
    if (Build.VERSION.SDK_INT >= 11)
      ActivityCompatHoneycomb.a(this);
    while (true)
    {
      return;
      this.i = true;
    }
  }

  public Object c()
  {
    return null;
  }

  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    if (Build.VERSION.SDK_INT >= 11);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("Local FragmentActivity ");
    paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
    paramPrintWriter.println(" State:");
    String str = paramString + "  ";
    paramPrintWriter.print(str);
    paramPrintWriter.print("mCreated=");
    paramPrintWriter.print(this.d);
    paramPrintWriter.print("mResumed=");
    paramPrintWriter.print(this.e);
    paramPrintWriter.print(" mStopped=");
    paramPrintWriter.print(this.f);
    paramPrintWriter.print(" mReallyStopped=");
    paramPrintWriter.println(this.g);
    paramPrintWriter.print(str);
    paramPrintWriter.print("mLoadersStarted=");
    paramPrintWriter.println(this.k);
    if (this.m != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("Loader Manager ");
      paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this.m)));
      paramPrintWriter.println(":");
      this.m.a(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    this.b.a(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }

  protected void e_()
  {
    this.b.p();
  }

  void f()
  {
    if (this.k)
    {
      this.k = false;
      if (this.m != null)
      {
        if (this.h)
          break label41;
        this.m.c();
      }
    }
    while (true)
    {
      this.b.s();
      return;
      label41: this.m.d();
    }
  }

  public Object f_()
  {
    FragmentActivity.NonConfigurationInstances localNonConfigurationInstances = (FragmentActivity.NonConfigurationInstances)getLastNonConfigurationInstance();
    if (localNonConfigurationInstances != null);
    for (Object localObject = localNonConfigurationInstances.b; ; localObject = null)
      return localObject;
  }

  public FragmentManager g()
  {
    return this.b;
  }

  public LoaderManager h()
  {
    if (this.m != null);
    for (LoaderManagerImpl localLoaderManagerImpl = this.m; ; localLoaderManagerImpl = this.m)
    {
      return localLoaderManagerImpl;
      this.j = true;
      this.m = a(-1, this.k, true);
    }
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int n = paramInt1 >> 16;
    if (n != 0)
      if (n < 0)
        Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(paramInt1));
    while (true)
    {
      return;
      Fragment localFragment = b(n);
      if (localFragment == null)
      {
        Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(paramInt1));
        continue;
      }
      localFragment.a(0xFFFF & paramInt1, paramInt2, paramIntent);
      continue;
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }

  public void onBackPressed()
  {
    if (!this.b.e())
      finish();
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.b.a(paramConfiguration);
  }

  protected void onCreate(Bundle paramBundle)
  {
    this.b.a(new FragmentActivityHost(this));
    if (getLayoutInflater().getFactory() == null)
      getLayoutInflater().setFactory(this);
    super.onCreate(paramBundle);
    FragmentActivity.NonConfigurationInstances localNonConfigurationInstances = (FragmentActivity.NonConfigurationInstances)getLastNonConfigurationInstance();
    if (localNonConfigurationInstances != null)
      this.l = localNonConfigurationInstances.e;
    Parcelable localParcelable;
    FragmentManagerImpl localFragmentManagerImpl;
    if (paramBundle != null)
    {
      localParcelable = paramBundle.getParcelable("android:support:fragments");
      localFragmentManagerImpl = this.b;
      if (localNonConfigurationInstances == null)
        break label102;
    }
    label102: for (ArrayList localArrayList = localNonConfigurationInstances.d; ; localArrayList = null)
    {
      localFragmentManagerImpl.a(localParcelable, localArrayList);
      this.b.m();
      return;
    }
  }

  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    boolean bool;
    if (paramInt == 0)
    {
      bool = super.onCreatePanelMenu(paramInt, paramMenu) | this.b.a(paramMenu, getMenuInflater());
      if (Build.VERSION.SDK_INT < 11);
    }
    while (true)
    {
      return bool;
      bool = true;
      continue;
      bool = super.onCreatePanelMenu(paramInt, paramMenu);
    }
  }

  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if (!"fragment".equals(paramString));
    Object localObject;
    for (View localView = super.onCreateView(paramString, paramContext, paramAttributeSet); ; localView = ((Fragment)localObject).R)
    {
      return localView;
      String str1 = paramAttributeSet.getAttributeValue(null, "class");
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, FragmentActivity.FragmentTag.a);
      if (str1 == null)
        str1 = localTypedArray.getString(0);
      int n = localTypedArray.getResourceId(1, -1);
      String str2 = localTypedArray.getString(2);
      localTypedArray.recycle();
      if (0 != 0);
      for (int i1 = null.getId(); (i1 == -1) && (n == -1) && (str2 == null); i1 = -1)
        throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str1);
      FragmentManagerImpl localFragmentManagerImpl;
      int i2;
      if (this.c != null)
      {
        localFragmentManagerImpl = this.c;
        localObject = null;
        if (n != -1)
          localObject = localFragmentManagerImpl.a(n);
        if ((localObject == null) && (str2 != null))
          localObject = localFragmentManagerImpl.a(str2);
        if ((localObject == null) && (i1 != -1))
          localObject = localFragmentManagerImpl.a(i1);
        if (FragmentManagerImpl.a)
          Log.v("FragmentActivity", "onCreateView: id=0x" + Integer.toHexString(n) + " fname=" + str1 + " existing=" + localObject);
        if (localObject != null)
          break label423;
        Fragment localFragment = Fragment.a(this, str1);
        localFragment.y = true;
        if (n == 0)
          break label416;
        i2 = n;
        label306: localFragment.F = i2;
        localFragment.G = i1;
        localFragment.H = str2;
        localFragment.z = true;
        localFragment.C = localFragmentManagerImpl;
        localFragment.a(this, paramAttributeSet, localFragment.m);
        localFragmentManagerImpl.a(localFragment, true);
        localObject = localFragment;
      }
      while (true)
      {
        if (((Fragment)localObject).R != null)
          break label544;
        throw new IllegalStateException("Fragment " + str1 + " did not create a view.");
        localFragmentManagerImpl = this.b;
        break;
        label416: i2 = i1;
        break label306;
        label423: if (((Fragment)localObject).z)
          throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(n) + ", tag " + str2 + ", or parent id 0x" + Integer.toHexString(i1) + " with another fragment for " + str1);
        ((Fragment)localObject).z = true;
        if (!((Fragment)localObject).L)
          ((Fragment)localObject).a(this, paramAttributeSet, ((Fragment)localObject).m);
        localFragmentManagerImpl.c((Fragment)localObject);
      }
      label544: if (n != 0)
        ((Fragment)localObject).R.setId(n);
      if (((Fragment)localObject).R.getTag() != null)
        continue;
      ((Fragment)localObject).R.setTag(str2);
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
    a(false);
    this.b.t();
    if (this.m != null)
      this.m.h();
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((Build.VERSION.SDK_INT < 5) && (paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
      onBackPressed();
    for (boolean bool = true; ; bool = super.onKeyDown(paramInt, paramKeyEvent))
      return bool;
  }

  public void onLowMemory()
  {
    super.onLowMemory();
    this.b.u();
  }

  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    boolean bool;
    if (super.onMenuItemSelected(paramInt, paramMenuItem))
      bool = true;
    while (true)
    {
      return bool;
      switch (paramInt)
      {
      default:
        bool = false;
        break;
      case 0:
        bool = this.b.a(paramMenuItem);
        break;
      case 6:
        bool = this.b.b(paramMenuItem);
      }
    }
  }

  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    switch (paramInt)
    {
    default:
    case 0:
    }
    while (true)
    {
      super.onPanelClosed(paramInt, paramMenu);
      return;
      this.b.b(paramMenu);
    }
  }

  protected void onPause()
  {
    super.onPause();
    this.e = false;
    if (this.a.hasMessages(2))
    {
      this.a.removeMessages(2);
      e_();
    }
    this.b.q();
  }

  protected void onPostResume()
  {
    super.onPostResume();
    this.a.removeMessages(2);
    e_();
    this.b.h();
  }

  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    if ((paramInt == 0) && (paramMenu != null))
    {
      if (this.i)
      {
        this.i = false;
        paramMenu.clear();
        onCreatePanelMenu(paramInt, paramMenu);
      }
      boolean bool2 = super.onPreparePanel(paramInt, paramView, paramMenu) | this.b.a(paramMenu);
      bool1 = false;
      if (bool2)
      {
        boolean bool3 = paramMenu.hasVisibleItems();
        bool1 = false;
        if (!bool3);
      }
    }
    for (boolean bool1 = true; ; bool1 = super.onPreparePanel(paramInt, paramView, paramMenu))
      return bool1;
  }

  protected void onResume()
  {
    super.onResume();
    this.a.sendEmptyMessage(2);
    this.e = true;
    this.b.h();
  }

  public final Object onRetainNonConfigurationInstance()
  {
    if (this.f)
      a(true);
    Object localObject = c();
    ArrayList localArrayList = this.b.j();
    SparseArrayCompat localSparseArrayCompat = this.l;
    int n = 0;
    if (localSparseArrayCompat != null)
    {
      int i1 = -1 + this.l.a();
      if (i1 >= 0)
      {
        LoaderManagerImpl localLoaderManagerImpl = (LoaderManagerImpl)this.l.f(i1);
        if (localLoaderManagerImpl.f);
        for (int i2 = 1; ; i2 = n)
        {
          i1--;
          n = i2;
          break;
          localLoaderManagerImpl.h();
          this.l.d(i1);
        }
      }
    }
    FragmentActivity.NonConfigurationInstances localNonConfigurationInstances;
    if ((localArrayList == null) && (n == 0) && (localObject == null))
      localNonConfigurationInstances = null;
    while (true)
    {
      return localNonConfigurationInstances;
      localNonConfigurationInstances = new FragmentActivity.NonConfigurationInstances();
      localNonConfigurationInstances.a = null;
      localNonConfigurationInstances.b = localObject;
      localNonConfigurationInstances.c = null;
      localNonConfigurationInstances.d = localArrayList;
      localNonConfigurationInstances.e = this.l;
    }
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    Parcelable localParcelable = this.b.k();
    if (localParcelable != null)
      paramBundle.putParcelable("android:support:fragments", localParcelable);
  }

  protected void onStart()
  {
    super.onStart();
    this.f = false;
    this.g = false;
    this.a.removeMessages(1);
    if (!this.d)
    {
      this.d = true;
      this.b.n();
    }
    this.b.l();
    this.b.h();
    if (!this.k)
    {
      this.k = true;
      if (this.m == null)
        break label141;
      this.m.b();
    }
    while (true)
    {
      this.j = true;
      this.b.o();
      if (this.l == null)
        break;
      for (int n = -1 + this.l.a(); n >= 0; n--)
      {
        LoaderManagerImpl localLoaderManagerImpl = (LoaderManagerImpl)this.l.f(n);
        localLoaderManagerImpl.e();
        localLoaderManagerImpl.g();
      }
      label141: if (this.j)
        continue;
      this.m = a(-1, this.k, false);
    }
  }

  protected void onStop()
  {
    super.onStop();
    this.f = true;
    this.a.sendEmptyMessage(1);
    this.b.r();
  }

  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if ((paramInt != -1) && ((0xFFFF0000 & paramInt) != 0))
      throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    super.startActivityForResult(paramIntent, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentActivity
 * JD-Core Version:    0.6.0
 */