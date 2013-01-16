package com.facebook.katana.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import com.facebook.debug.Assert;

class SectionedListInternalAdapter extends BaseAdapter
  implements SectionIndexer
{
  protected final SectionedListAdapter a;

  public SectionedListInternalAdapter(SectionedListAdapter paramSectionedListAdapter)
  {
    this.a = paramSectionedListAdapter;
  }

  public boolean areAllItemsEnabled()
  {
    return false;
  }

  public int getCount()
  {
    if (this.a.d());
    for (int i = 0; ; i = this.a.b())
      return i;
  }

  public Object getItem(int paramInt)
  {
    return this.a.e(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    return this.a.h(paramInt);
  }

  public int getPositionForSection(int paramInt)
  {
    if (paramInt < 0)
      paramInt = 0;
    while (true)
    {
      return this.a.g(paramInt);
      if (paramInt < this.a.d_())
        continue;
      paramInt = -1 + this.a.d_();
    }
  }

  public int getSectionForPosition(int paramInt)
  {
    int i;
    if (paramInt < 0)
      i = 0;
    while (true)
    {
      return i;
      if (paramInt >= getCount())
      {
        i = -1 + this.a.d_();
        continue;
      }
      int[] arrayOfInt = this.a.d(paramInt);
      Assert.a(2, arrayOfInt.length);
      i = arrayOfInt[1];
    }
  }

  public Object[] getSections()
  {
    int i = this.a.d_();
    Object[] arrayOfObject = new Object[i];
    for (int j = 0; j < i; j++)
      arrayOfObject[j] = this.a.c(j);
    return arrayOfObject;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return this.a.b(paramInt, paramView, paramViewGroup);
  }

  public int getViewTypeCount()
  {
    return this.a.c();
  }

  public boolean isEnabled(int paramInt)
  {
    int i = 1;
    try
    {
      boolean bool = this.a.f(paramInt);
      i = bool;
      label15: return i;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      break label15;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      break label15;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.SectionedListInternalAdapter
 * JD-Core Version:    0.6.0
 */