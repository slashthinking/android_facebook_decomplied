package com.facebook.katana.activity.photos;

import android.database.DataSetObserver;
import android.widget.ListView;

class AlbumsFragment$1 extends DataSetObserver
{
  public void onChanged()
  {
    if (AlbumsFragment.a(this.a).getVisibility() != 0)
      AlbumsFragment.b(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.photos.AlbumsFragment.1
 * JD-Core Version:    0.6.0
 */