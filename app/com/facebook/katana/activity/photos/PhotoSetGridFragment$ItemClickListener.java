package com.facebook.katana.activity.photos;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class PhotoSetGridFragment$ItemClickListener
  implements AdapterView.OnItemClickListener
{
  private PhotoSetGridFragment$ItemClickListener(PhotoSetGridFragment paramPhotoSetGridFragment)
  {
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramLong > 0L)
      PhotoSetGridFragment.a(this.a, paramLong);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.photos.PhotoSetGridFragment.ItemClickListener
 * JD-Core Version:    0.6.0
 */