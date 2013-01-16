package android.support.v4.view;

import android.database.DataSetObserver;

class PagerTitleStrip$PageListener extends DataSetObserver
  implements ViewPager.OnAdapterChangeListener, ViewPager.OnPageChangeListener
{
  private int b;

  private PagerTitleStrip$PageListener(PagerTitleStrip paramPagerTitleStrip)
  {
  }

  public void a(int paramInt)
  {
    if (this.b == 0)
      this.a.a(this.a.a.getCurrentItem(), this.a.a.getAdapter());
  }

  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    if (paramFloat > 0.5F)
      paramInt1++;
    this.a.a(paramInt1, paramFloat, false);
  }

  public void a(PagerAdapter paramPagerAdapter1, PagerAdapter paramPagerAdapter2)
  {
    this.a.a(paramPagerAdapter1, paramPagerAdapter2);
  }

  public void b(int paramInt)
  {
    this.b = paramInt;
  }

  public void onChanged()
  {
    this.a.a(this.a.a.getCurrentItem(), this.a.a.getAdapter());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.view.PagerTitleStrip.PageListener
 * JD-Core Version:    0.6.0
 */