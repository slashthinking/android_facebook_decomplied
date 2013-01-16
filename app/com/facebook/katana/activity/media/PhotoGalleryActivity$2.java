package com.facebook.katana.activity.media;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.katana.IntentUriHandler;
import com.facebook.katana.model.FacebookPhotoTag;

class PhotoGalleryActivity$2
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    IntentUriHandler.b(this.b, "fb://profile/" + this.a.f());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.PhotoGalleryActivity.2
 * JD-Core Version:    0.6.0
 */