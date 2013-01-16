package com.facebook.katana.ui;

import android.database.DataSetObserver;

class SectionedListMultiAdapter$AdapterDataObserver extends DataSetObserver
{
  private SectionedListMultiAdapter$AdapterDataObserver(SectionedListMultiAdapter paramSectionedListMultiAdapter)
  {
  }

  public void onChanged()
  {
    SectionedListMultiAdapter.a(this.a);
    this.a.j();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.SectionedListMultiAdapter.AdapterDataObserver
 * JD-Core Version:    0.6.0
 */