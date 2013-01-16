package custom.android;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.widget.Adapter;

class AdapterView$AdapterDataSetObserver extends DataSetObserver
{
  private Parcelable b = null;

  AdapterView$AdapterDataSetObserver(AdapterView paramAdapterView)
  {
  }

  public void onChanged()
  {
    this.a.v = true;
    this.a.B = this.a.A;
    this.a.A = this.a.getAdapter().getCount();
    if ((this.a.getAdapter().hasStableIds()) && (this.b != null) && (this.a.B == 0) && (this.a.A > 0))
    {
      AdapterView.a(this.a, this.b);
      this.b = null;
    }
    while (true)
    {
      this.a.d();
      this.a.requestLayout();
      return;
      this.a.i();
    }
  }

  public void onInvalidated()
  {
    this.a.v = true;
    if (this.a.getAdapter().hasStableIds())
      this.b = AdapterView.a(this.a);
    this.a.B = this.a.A;
    this.a.A = 0;
    this.a.y = -1;
    this.a.z = -9223372036854775808L;
    this.a.w = -1;
    this.a.x = -9223372036854775808L;
    this.a.p = false;
    this.a.d();
    this.a.requestLayout();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     custom.android.AdapterView.AdapterDataSetObserver
 * JD-Core Version:    0.6.0
 */