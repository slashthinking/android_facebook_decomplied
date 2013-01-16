package android.support.v4.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;

public class DelegatingFragmentHost extends FragmentHost
{
  private final FragmentHost a;

  public DelegatingFragmentHost(FragmentHost paramFragmentHost)
  {
    this.a = paramFragmentHost;
  }

  public Context a()
  {
    return this.a.a();
  }

  LoaderManagerImpl a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return this.a.a(paramInt, paramBoolean1, paramBoolean2);
  }

  void a(int paramInt)
  {
    this.a.a(paramInt);
  }

  void a(Fragment paramFragment)
  {
    this.a.a(paramFragment);
  }

  void a(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    this.a.a(paramFragment, paramIntent, paramInt);
  }

  void a(FragmentManager paramFragmentManager)
  {
    this.a.a(paramFragmentManager);
  }

  void a(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    this.a.a(paramContextMenu, paramView, paramContextMenuInfo);
  }

  public Handler b()
  {
    return this.a.b();
  }

  View b(int paramInt)
  {
    return this.a.b(paramInt);
  }

  public boolean c()
  {
    return this.a.c();
  }

  public Window d()
  {
    return this.a.d();
  }

  public Resources e()
  {
    return this.a.e();
  }

  public LayoutInflater f()
  {
    return this.a.f();
  }

  public MenuInflater g()
  {
    return this.a.g();
  }

  FragmentManagerImpl h()
  {
    return this.a.h();
  }

  boolean i()
  {
    return this.a.i();
  }

  FragmentManager j()
  {
    return this.a.j();
  }

  void k()
  {
    this.a.k();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.app.DelegatingFragmentHost
 * JD-Core Version:    0.6.0
 */