package com.facebook.katana.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class SectionedListView extends ListView
{
  protected SectionedListAdapter a;
  protected BaseAdapter b;

  public SectionedListView(Context paramContext)
  {
    super(paramContext);
  }

  public SectionedListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public SectionedListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public ListAdapter getAdapter()
  {
    return this.b;
  }

  public SectionedListAdapter getSectionedListAdapter()
  {
    return this.a;
  }

  public void setAdapter(ListAdapter paramListAdapter)
  {
  }

  public void setSectionedListAdapter(SectionedListAdapter paramSectionedListAdapter)
  {
    if (this.a != null)
      this.a.a(null);
    this.a = paramSectionedListAdapter;
    this.b = new SectionedListInternalAdapter(paramSectionedListAdapter);
    this.a.a(this.b);
    super.setAdapter(this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.SectionedListView
 * JD-Core Version:    0.6.0
 */