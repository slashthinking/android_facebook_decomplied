package com.facebook.katana.activity.media;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.facebook.photos.analytics.PhotoFlowLogger;

class PhotoGalleryActivity$TypeaheadStartTypingListener
  implements View.OnKeyListener
{
  private PhotoGalleryActivity$TypeaheadStartTypingListener(PhotoGalleryActivity paramPhotoGalleryActivity)
  {
  }

  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (!PhotoGalleryActivity.G(this.a))
    {
      PhotoGalleryActivity.a(this.a, true);
      PhotoGalleryActivity.H(this.a).e();
    }
    return false;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.PhotoGalleryActivity.TypeaheadStartTypingListener
 * JD-Core Version:    0.6.0
 */