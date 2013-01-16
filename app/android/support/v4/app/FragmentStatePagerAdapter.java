package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class FragmentStatePagerAdapter extends PagerAdapter
{
  private final FragmentManager a;
  private FragmentTransaction b = null;
  private ArrayList<Fragment.SavedState> c = new ArrayList();
  private ArrayList<Fragment> d = new ArrayList();
  private Fragment e = null;

  public FragmentStatePagerAdapter(FragmentManager paramFragmentManager)
  {
    this.a = paramFragmentManager;
  }

  public Parcelable a()
  {
    int i = this.c.size();
    Bundle localBundle1 = null;
    if (i > 0)
    {
      localBundle1 = new Bundle();
      Fragment.SavedState[] arrayOfSavedState = new Fragment.SavedState[this.c.size()];
      this.c.toArray(arrayOfSavedState);
      localBundle1.putParcelableArray("states", arrayOfSavedState);
    }
    int j = 0;
    Bundle localBundle2 = localBundle1;
    while (j < this.d.size())
    {
      Fragment localFragment = (Fragment)this.d.get(j);
      if (localFragment != null)
      {
        if (localBundle2 == null)
          localBundle2 = new Bundle();
        String str = "f" + j;
        this.a.a(localBundle2, str, localFragment);
      }
      j++;
    }
    return localBundle2;
  }

  public abstract Fragment a(int paramInt);

  public Object a(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject;
    if (this.d.size() > paramInt)
    {
      localObject = (Fragment)this.d.get(paramInt);
      if (localObject == null);
    }
    while (true)
    {
      return localObject;
      if (this.b == null)
        this.b = this.a.a();
      Fragment localFragment = a(paramInt);
      if (this.c.size() > paramInt)
      {
        Fragment.SavedState localSavedState = (Fragment.SavedState)this.c.get(paramInt);
        if (localSavedState != null)
          localFragment.a(localSavedState);
      }
      while (this.d.size() <= paramInt)
        this.d.add(null);
      localFragment.g(false);
      this.d.set(paramInt, localFragment);
      this.b.a(paramViewGroup.getId(), localFragment);
      localObject = localFragment;
    }
  }

  public void a(Parcelable paramParcelable, ClassLoader paramClassLoader)
  {
    if (paramParcelable != null)
    {
      Bundle localBundle = (Bundle)paramParcelable;
      localBundle.setClassLoader(paramClassLoader);
      Parcelable[] arrayOfParcelable = localBundle.getParcelableArray("states");
      this.c.clear();
      this.d.clear();
      if (arrayOfParcelable != null)
        for (int j = 0; j < arrayOfParcelable.length; j++)
          this.c.add((Fragment.SavedState)arrayOfParcelable[j]);
      Iterator localIterator = localBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!str.startsWith("f"))
          continue;
        int i = Integer.parseInt(str.substring(1));
        Fragment localFragment = this.a.a(localBundle, str);
        if (localFragment != null)
        {
          while (this.d.size() <= i)
            this.d.add(null);
          localFragment.g(false);
          this.d.set(i, localFragment);
          continue;
        }
        Log.w("FragmentStatePagerAdapter", "Bad fragment at key " + str);
      }
    }
  }

  public void a(ViewGroup paramViewGroup)
  {
  }

  public void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    Fragment localFragment = (Fragment)paramObject;
    if (this.b == null)
      this.b = this.a.a();
    while (this.c.size() <= paramInt)
      this.c.add(null);
    this.c.set(paramInt, this.a.a(localFragment));
    this.d.set(paramInt, null);
    this.b.a(localFragment);
  }

  public boolean a(View paramView, Object paramObject)
  {
    if (((Fragment)paramObject).A() == paramView);
    for (int i = 1; ; i = 0)
      return i;
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
    if (localFragment != this.e)
    {
      if (this.e != null)
        this.e.g(false);
      if (localFragment != null)
        localFragment.g(true);
      this.e = localFragment;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentStatePagerAdapter
 * JD-Core Version:    0.6.0
 */