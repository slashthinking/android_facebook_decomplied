package com.facebook.katana.nux;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.camera.activity.CameraActivity;
import com.facebook.content.SecureContextHelper;

class NuxProfilePicActivity$2
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    Intent localIntent = CameraActivity.b(this.a).putExtra("mediaContentType", 1).putExtra("extra_disable_video", true).putExtra("extra_show_gallery", false).putExtra("return_after_snap", true).putExtra("profile_crop_overlay", true).putExtra("desired_initial_facing", 1);
    NuxProfilePicActivity.a(this.a).b(localIntent, 123, this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.nux.NuxProfilePicActivity.2
 * JD-Core Version:    0.6.0
 */