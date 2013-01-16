package com.facebook.katana.activity.media;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.FacebookAlbum;

class PhotoSetActivity$1
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    PhotoSetActivity.a(this.a, PhotoSetActivity.b(this.a).b(this.a, PhotoSetActivity.a(this.a).a()));
    this.a.removeDialog(23);
    this.a.showDialog(24);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.PhotoSetActivity.1
 * JD-Core Version:    0.6.0
 */