package com.facebook.katana.activity.media;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.FacebookPhoto;

class PhotoGalleryActivity$5
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    FacebookPhoto localFacebookPhoto = PhotoGalleryActivity.y(this.a);
    if (localFacebookPhoto == null);
    while (true)
    {
      return;
      PhotoGalleryActivity.a(this.a, PhotoGalleryActivity.g(this.a).a(this.a, localFacebookPhoto.b(), localFacebookPhoto.a()));
      this.a.removeDialog(2);
      this.a.showDialog(3);
      PhotoGalleryActivity.f(this.a).remove(Long.valueOf(localFacebookPhoto.j()));
      if (PhotoGalleryActivity.f(this.a).getCount() != 0)
        continue;
      this.a.finish();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.PhotoGalleryActivity.5
 * JD-Core Version:    0.6.0
 */