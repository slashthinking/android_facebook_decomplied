package custom.android;

import android.util.SparseArray;
import android.view.View;

class AbsSpinner$RecycleBin
{
  private final SparseArray<View> b = new SparseArray();

  AbsSpinner$RecycleBin(AbsSpinner paramAbsSpinner)
  {
  }

  public View a()
  {
    View localView;
    if (this.b.size() < 1)
      localView = null;
    while (true)
    {
      return localView;
      localView = (View)this.b.valueAt(0);
      int i = this.b.keyAt(0);
      if (localView == null)
        continue;
      this.b.delete(i);
    }
  }

  public void a(int paramInt, View paramView)
  {
    this.b.put(paramInt, paramView);
  }

  public void a(View paramView)
  {
    this.b.put(this.b.size(), paramView);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     custom.android.AbsSpinner.RecycleBin
 * JD-Core Version:    0.6.0
 */