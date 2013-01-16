package android.support.v4.app;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.util.SparseArrayCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class NestedFragment extends Fragment
{
  private FragmentManagerImpl a = new FragmentManagerImpl();
  private NestedFragmentLayoutInflator b;
  private SparseArrayCompat<LoaderManagerImpl> c;

  public void B()
  {
    super.B();
    this.a.h();
    this.a.p();
  }

  public void C()
  {
    super.C();
    this.a.q();
  }

  public void D()
  {
    super.D();
    this.a.t();
  }

  public void I()
  {
    super.I();
    this.a.s();
  }

  public FragmentManager K()
  {
    if (this.a.o == null)
    {
      this.a.a(o());
      this.a.a(this);
    }
    return this.a;
  }

  NestedFragment.NestedFragmentHost a(FragmentHost paramFragmentHost)
  {
    return new NestedFragment.NestedFragmentHost(this, paramFragmentHost);
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.a.a(o());
    this.a.a(this);
    if (paramBundle != null)
    {
      Parcelable localParcelable = paramBundle.getParcelable("android:support:nestedfragments");
      this.a.a(localParcelable, null);
    }
    this.a.m();
  }

  public void a(Fragment paramFragment)
  {
  }

  public void a(Menu paramMenu)
  {
    super.a(paramMenu);
    this.a.a(paramMenu);
  }

  public void a(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    super.a(paramMenu, paramMenuInflater);
    this.a.a(paramMenu, o().g());
  }

  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.a(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    this.a.a(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }

  public boolean a(MenuItem paramMenuItem)
  {
    if ((super.a(paramMenuItem)) || (this.a.a(paramMenuItem)));
    for (int i = 1; ; i = 0)
      return i;
  }

  public int b(int paramInt)
  {
    this.p = (1 + this.a.b(paramInt));
    return this.p;
  }

  public LayoutInflater b(Bundle paramBundle)
  {
    if (this.b == null)
      this.b = new NestedFragmentLayoutInflator(super.b(paramBundle), this);
    return this.b;
  }

  public void b(Menu paramMenu)
  {
    super.b(paramMenu);
    this.a.b(paramMenu);
  }

  public boolean b(MenuItem paramMenuItem)
  {
    if ((super.b(paramMenuItem)) || (this.a.b(paramMenuItem)));
    for (int i = 1; ; i = 0)
      return i;
  }

  public Fragment c(int paramInt)
  {
    Fragment localFragment = super.c(paramInt);
    if (localFragment == null)
      localFragment = this.a.c(paramInt);
    return localFragment;
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.a.n();
  }

  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    this.a.h();
    Parcelable localParcelable = this.a.k();
    if (localParcelable != null)
      paramBundle.putParcelable("android:support:nestedfragments", localParcelable);
  }

  public void f()
  {
    super.f();
    this.a.l();
    this.a.h();
    this.a.o();
    if (this.c != null)
      for (int i = -1 + this.c.a(); i >= 0; i--)
      {
        LoaderManagerImpl localLoaderManagerImpl = (LoaderManagerImpl)this.c.f(i);
        localLoaderManagerImpl.e();
        localLoaderManagerImpl.g();
      }
  }

  public void g()
  {
    super.g();
    this.a.r();
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.a.a(paramConfiguration);
  }

  public void onLowMemory()
  {
    super.onLowMemory();
    this.a.u();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.app.NestedFragment
 * JD-Core Version:    0.6.0
 */