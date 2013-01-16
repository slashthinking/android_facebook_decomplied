package com.facebook.katana.activity.media;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.facebook.katana.ui.TagView;

class UploadPhotoActivity$3$1
  implements View.OnLongClickListener
{
  public boolean onLongClick(View paramView)
  {
    new Bundle().putLong("photo_tag_user_id", this.a.a);
    UploadPhotoActivity.DeleteTagDialogFragment.a(this.a.a).a(this.b.b.g(), "delete_tag_frag");
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.UploadPhotoActivity.3.1
 * JD-Core Version:    0.6.0
 */