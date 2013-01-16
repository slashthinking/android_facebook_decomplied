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

public class FragmentActivityHost extends FragmentHost
{
  private final FragmentActivity a;

  public FragmentActivityHost(FragmentActivity paramFragmentActivity)
  {
    this.a = paramFragmentActivity;
  }

  public Context a()
  {
    return this.a;
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
    this.a.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }

  public Handler b()
  {
    return this.a.a;
  }

  public View b(int paramInt)
  {
    return this.a.findViewById(paramInt);
  }

  public boolean c()
  {
    return this.a.isFinishing();
  }

  public Window d()
  {
    return this.a.getWindow();
  }

  public Resources e()
  {
    return this.a.getResources();
  }

  public LayoutInflater f()
  {
    return this.a.getLayoutInflater();
  }

  public MenuInflater g()
  {
    return this.a.getMenuInflater();
  }

  FragmentManagerImpl h()
  {
    return this.a.b;
  }

  boolean i()
  {
    return this.a.h;
  }

  FragmentManager j()
  {
    return this.a.a_();
  }

  void k()
  {
    this.a.b_();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentActivityHost
 * JD-Core Version:    0.6.0
 */