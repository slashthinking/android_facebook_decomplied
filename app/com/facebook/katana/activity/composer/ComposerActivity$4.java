package com.facebook.katana.activity.composer;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.katana.activity.media.CameraReviewActivity;
import com.facebook.katana.model.FacebookPhotoTag;

class ComposerActivity$4
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    FacebookPhotoTag[] arrayOfFacebookPhotoTag = ComposerActivity.l(this.a);
    Intent localIntent = CameraReviewActivity.a(this.a, arrayOfFacebookPhotoTag, ComposerActivity.m(this.a), 2, true, ComposerActivity.n(this.a));
    this.a.startActivityForResult(localIntent, 124);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.ComposerActivity.4
 * JD-Core Version:    0.6.0
 */