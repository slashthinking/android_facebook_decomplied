package com.facebook.katana.ui;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.debug.Assert;
import java.util.ArrayList;
import java.util.List;

public abstract class SectionedListAdapter
{
  private List<DataSetObserver> a;
  protected BaseAdapter l;
  protected List<SectionedListAdapter.SectionCache> m;
  protected boolean n;

  public abstract int a(int paramInt);

  public abstract View a(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup);

  public abstract View a(int paramInt, View paramView, ViewGroup paramViewGroup);

  public abstract Object a(int paramInt1, int paramInt2);

  public void a(DataSetObserver paramDataSetObserver)
  {
    if (this.a == null)
      this.a = new ArrayList();
    this.a.add(paramDataSetObserver);
  }

  void a(BaseAdapter paramBaseAdapter)
  {
    this.l = paramBaseAdapter;
  }

  public int b()
  {
    l();
    if (this.m.size() == 0);
    SectionedListAdapter.SectionCache localSectionCache;
    for (int i = 0; ; i = 1 + (localSectionCache.b + localSectionCache.c))
    {
      return i;
      localSectionCache = (SectionedListAdapter.SectionCache)this.m.get(-1 + this.m.size());
    }
  }

  public abstract int b(int paramInt);

  public abstract int b(int paramInt1, int paramInt2);

  View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int[] arrayOfInt = d(paramInt);
    Assert.a(2, arrayOfInt.length);
    View localView;
    if (arrayOfInt[1] == -1)
    {
      localView = a(arrayOfInt[0], paramView, paramViewGroup);
      return localView;
    }
    if (-1 + ((SectionedListAdapter.SectionCache)this.m.get(arrayOfInt[0])).c == arrayOfInt[1]);
    for (boolean bool = true; ; bool = false)
    {
      localView = a(arrayOfInt[0], arrayOfInt[1], bool, paramView, paramViewGroup);
      break;
    }
  }

  public abstract int c();

  public abstract Object c(int paramInt);

  public abstract boolean c(int paramInt1, int paramInt2);

  public abstract boolean d();

  public int[] d(int paramInt)
  {
    l();
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = SectionedListAdapter.SectionCache.a(this.m, paramInt);
    arrayOfInt[1] = (-1 + (paramInt - ((SectionedListAdapter.SectionCache)this.m.get(arrayOfInt[0])).b));
    return arrayOfInt;
  }

  public abstract int d_();

  public Object e(int paramInt)
  {
    int[] arrayOfInt = d(paramInt);
    Assert.a(2, arrayOfInt.length);
    if (arrayOfInt[1] == -1);
    for (Object localObject = null; ; localObject = a(arrayOfInt[0], arrayOfInt[1]))
      return localObject;
  }

  public boolean f(int paramInt)
  {
    int[] arrayOfInt = d(paramInt);
    Assert.a(2, arrayOfInt.length);
    int i = arrayOfInt[1];
    boolean bool = false;
    if (i == -1);
    while (true)
    {
      return bool;
      bool = c(arrayOfInt[0], arrayOfInt[1]);
    }
  }

  public int g(int paramInt)
  {
    l();
    return ((SectionedListAdapter.SectionCache)this.m.get(paramInt)).b;
  }

  int h(int paramInt)
  {
    int[] arrayOfInt = d(paramInt);
    Assert.a(2, arrayOfInt.length);
    if (arrayOfInt[1] == -1);
    for (int i = a(arrayOfInt[0]); ; i = b(arrayOfInt[0], arrayOfInt[1]))
      return i;
  }

  public void j()
  {
    this.n = false;
    if (this.l != null)
      this.l.notifyDataSetChanged();
    if (this.a != null)
      for (int i = 0; i < this.a.size(); i++)
        ((DataSetObserver)this.a.get(i)).onChanged();
  }

  protected void l()
  {
    if (!this.n)
      m();
  }

  protected void m()
  {
    int i = 0;
    Assert.a(this.n);
    if (this.m == null)
      this.m = new ArrayList();
    int j = this.m.size();
    int k = d_();
    while (j < k)
    {
      this.m.add(new SectionedListAdapter.SectionCache(j));
      j++;
    }
    if (this.m.size() >= d_());
    for (boolean bool = true; ; bool = false)
    {
      Assert.b(bool);
      int i1 = this.m.size();
      int i2 = d_();
      while (i1 > i2)
      {
        this.m.remove(i1 - 1);
        i1--;
      }
    }
    Assert.a(d_(), this.m.size());
    for (int i3 = 0; i3 < d_(); i3++)
    {
      int i4 = b(i3);
      SectionedListAdapter.SectionCache localSectionCache = (SectionedListAdapter.SectionCache)this.m.get(i3);
      localSectionCache.b = i;
      localSectionCache.c = i4;
      i += i4 + 1;
    }
    this.n = true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.SectionedListAdapter
 * JD-Core Version:    0.6.0
 */