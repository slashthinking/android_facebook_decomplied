package com.facebook.katana.ui;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SectionedListMultiAdapter extends SectionedListAdapter
{
  private List<SectionedListAdapter> a = new ArrayList();
  private SectionedListMultiAdapter.AdapterDataObserver b = new SectionedListMultiAdapter.AdapterDataObserver(this, null);
  private int c;
  private int d;
  private int[] e;
  private int[] f;

  private int d(int paramInt1, int paramInt2)
  {
    return paramInt2 - this.e[paramInt1];
  }

  private void e()
  {
    this.e = new int[this.a.size()];
    this.f = new int[this.a.size()];
    this.d = 0;
    this.c = 0;
    if (this.a.size() == 0);
    while (true)
    {
      return;
      for (int i = 0; i < this.a.size(); i++)
      {
        SectionedListAdapter localSectionedListAdapter = (SectionedListAdapter)this.a.get(i);
        int j = localSectionedListAdapter.d_();
        this.e[i] = this.c;
        this.c = (j + this.c);
        this.f[i] = this.d;
        this.d += localSectionedListAdapter.c();
      }
    }
  }

  private int i(int paramInt)
  {
    for (int i = -1 + this.a.size(); i >= 0; i--)
      if (this.e[i] <= paramInt)
        return i;
    throw new IndexOutOfBoundsException();
  }

  public int a(int paramInt)
  {
    int i = i(paramInt);
    int j = d(i, paramInt);
    return this.f[i] + ((SectionedListAdapter)this.a.get(i)).a(j);
  }

  public View a(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    int i = i(paramInt1);
    int j = d(i, paramInt1);
    return ((SectionedListAdapter)this.a.get(i)).a(j, paramInt2, paramBoolean, paramView, paramViewGroup);
  }

  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = i(paramInt);
    int j = d(i, paramInt);
    return ((SectionedListAdapter)this.a.get(i)).a(j, paramView, paramViewGroup);
  }

  public Object a(int paramInt1, int paramInt2)
  {
    int i = i(paramInt1);
    int j = d(i, paramInt1);
    return ((SectionedListAdapter)this.a.get(i)).a(j, paramInt2);
  }

  public void a(SectionedListAdapter paramSectionedListAdapter)
  {
    this.a.add(paramSectionedListAdapter);
    paramSectionedListAdapter.a(this.b);
    e();
    j();
  }

  public int b(int paramInt)
  {
    int i = i(paramInt);
    int j = d(i, paramInt);
    return ((SectionedListAdapter)this.a.get(i)).b(j);
  }

  public int b(int paramInt1, int paramInt2)
  {
    int i = i(paramInt1);
    int j = d(i, paramInt1);
    return this.f[i] + ((SectionedListAdapter)this.a.get(i)).b(j, paramInt2);
  }

  public int c()
  {
    return this.d;
  }

  public Object c(int paramInt)
  {
    int i = i(paramInt);
    int j = d(i, paramInt);
    return ((SectionedListAdapter)this.a.get(i)).c(j);
  }

  public boolean c(int paramInt1, int paramInt2)
  {
    return true;
  }

  public boolean d()
  {
    Iterator localIterator = this.a.iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      SectionedListAdapter localSectionedListAdapter = (SectionedListAdapter)localIterator.next();
      if ((i != 0) && (localSectionedListAdapter.d()));
      for (int j = 1; ; j = 0)
      {
        i = j;
        break;
      }
    }
    return i;
  }

  public int d_()
  {
    return this.c;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.SectionedListMultiAdapter
 * JD-Core Version:    0.6.0
 */