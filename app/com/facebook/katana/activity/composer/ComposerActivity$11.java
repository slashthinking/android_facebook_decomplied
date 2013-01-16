package com.facebook.katana.activity.composer;

import android.database.Cursor;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.facebook.katana.activity.media.AlbumsAdapter;
import com.facebook.katana.model.FacebookAlbum;

class ComposerActivity$11
  implements AdapterView.OnItemClickListener
{
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView != null)
    {
      Cursor localCursor = (Cursor)ComposerActivity.s(this.a).getItem(paramInt);
      String str = ComposerActivity.s(this.a).a(localCursor);
      FacebookAlbum localFacebookAlbum = FacebookAlbum.a(this.a, str);
      if ((localFacebookAlbum == null) || (!"normal".equals(localFacebookAlbum.l())))
        break label95;
      ComposerActivity.a(this.a, localFacebookAlbum);
    }
    while (true)
    {
      ComposerActivity.t(this.a);
      this.a.r();
      ComposerActivity.u(this.a);
      return;
      label95: ComposerActivity.a(this.a, null);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.ComposerActivity.11
 * JD-Core Version:    0.6.0
 */