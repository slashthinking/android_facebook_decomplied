package com.facebook.katana.activity.media;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.FacebookAlbum;

class AlbumsActivity$1
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AlbumsActivity.a(this.a, AlbumsActivity.g(this.a).b(this.a, AlbumsActivity.f(this.a).a()));
    this.a.removeDialog(2);
    this.a.showDialog(3);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.AlbumsActivity.1
 * JD-Core Version:    0.6.0
 */