package android.support.v4.view;

import android.database.DataSetObserver;

class ViewPager$PagerObserver extends DataSetObserver
{
  private ViewPager$PagerObserver(ViewPager paramViewPager)
  {
  }

  public void onChanged()
  {
    this.a.b();
  }

  public void onInvalidated()
  {
    this.a.b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewPager.PagerObserver
 * JD-Core Version:    0.6.0
 */