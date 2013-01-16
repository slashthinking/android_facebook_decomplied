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

public abstract class FragmentHost
{
  public abstract Context a();

  abstract LoaderManagerImpl a(int paramInt, boolean paramBoolean1, boolean paramBoolean2);

  abstract void a(int paramInt);

  abstract void a(Fragment paramFragment);

  abstract void a(Fragment paramFragment, Intent paramIntent, int paramInt);

  abstract void a(FragmentManager paramFragmentManager);

  abstract void a(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo);

  public abstract Handler b();

  abstract View b(int paramInt);

  public abstract boolean c();

  public abstract Window d();

  public abstract Resources e();

  public abstract LayoutInflater f();

  public abstract MenuInflater g();

  abstract FragmentManagerImpl h();

  abstract boolean i();

  abstract FragmentManager j();

  abstract void k();
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentHost
 * JD-Core Version:    0.6.0
 */