package android.support.v4.app;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public abstract class FragmentPagerAdapter extends PagerAdapter
{
  private final FragmentManager a;
  private FragmentTransaction b = null;
  private Fragment c = null;

  public FragmentPagerAdapter(FragmentManager paramFragmentManager)
  {
    this.a = paramFragmentManager;
  }

  private static String a(int paramInt, long paramLong)
  {
    return "android:switcher:" + paramInt + ":" + paramLong;
  }

  public Parcelable a()
  {
    return null;
  }

  public abstract Fragment a(int paramInt);

  public Object a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.b == null)
      this.b = this.a.a();
    long l = b(paramInt);
    String str = a(paramViewGroup.getId(), l);
    Fragment localFragment = this.a.a(str);
    if (localFragment != null)
      this.b.e(localFragment);
    while (true)
    {
      if (localFragment != this.c)
      {
        localFragment.g(false);
        localFragment.h(false);
      }
      return localFragment;
      localFragment = a(paramInt);
      this.b.a(paramViewGroup.getId(), localFragment, a(paramViewGroup.getId(), l));
    }
  }

  public void a(Parcelable paramParcelable, ClassLoader paramClassLoader)
  {
  }

  public void a(ViewGroup paramViewGroup)
  {
  }

  public void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (this.b == null)
      this.b = this.a.a();
    this.b.d((Fragment)paramObject);
  }

  public boolean a(View paramView, Object paramObject)
  {
    if (((Fragment)paramObject).A() == paramView);
    for (int i = 1; ; i = 0)
      return i;
  }

  public long b(int paramInt)
  {
    return paramInt;
  }

  public void b(ViewGroup paramViewGroup)
  {
    if (this.b != null)
    {
      this.b.b();
      this.b = null;
      this.a.b();
    }
  }

  public void b(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    Fragment localFragment = (Fragment)paramObject;
    if (localFragment != this.c)
    {
      if (this.c != null)
      {
        this.c.g(false);
        this.c.h(false);
      }
      if (localFragment != null)
      {
        localFragment.g(true);
        localFragment.h(true);
      }
      this.c = localFragment;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentPagerAdapter
 * JD-Core Version:    0.6.0
 */