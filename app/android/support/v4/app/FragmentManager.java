package android.support.v4.app;

import android.os.Bundle;

public abstract class FragmentManager
{
  public abstract Fragment.SavedState a(Fragment paramFragment);

  public abstract Fragment a(int paramInt);

  public abstract Fragment a(Bundle paramBundle, String paramString);

  public abstract Fragment a(String paramString);

  public abstract FragmentTransaction a();

  public abstract void a(int paramInt1, int paramInt2);

  public abstract void a(Bundle paramBundle, String paramString, Fragment paramFragment);

  public abstract void a(FragmentManager.OnBackStackChangedListener paramOnBackStackChangedListener);

  public abstract void a(String paramString, int paramInt);

  public abstract void b(FragmentManager.OnBackStackChangedListener paramOnBackStackChangedListener);

  public abstract boolean b();

  public abstract boolean c();

  public abstract void d();

  public abstract boolean e();

  public abstract int f();
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentManager
 * JD-Core Version:    0.6.0
 */