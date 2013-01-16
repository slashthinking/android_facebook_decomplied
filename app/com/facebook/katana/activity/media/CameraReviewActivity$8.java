package com.facebook.katana.activity.media;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.facebook.katana.model.FacebookPhotoTag;
import java.util.Map;

class CameraReviewActivity$8
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    FacebookPhotoTag localFacebookPhotoTag = (FacebookPhotoTag)CameraReviewActivity.n(this.b).get(paramView);
    CameraReviewActivity.o(this.b).remove(localFacebookPhotoTag);
    CameraReviewActivity.j(this.b).b(localFacebookPhotoTag);
    this.a.removeView((View)paramView.getParent());
    CameraReviewActivity.p(this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.CameraReviewActivity.8
 * JD-Core Version:    0.6.0
 */