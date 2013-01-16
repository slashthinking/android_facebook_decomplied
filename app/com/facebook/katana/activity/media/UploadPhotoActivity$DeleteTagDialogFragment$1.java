package com.facebook.katana.activity.media;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.facebook.katana.ui.TaggableView;

class UploadPhotoActivity$DeleteTagDialogFragment$1
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    TaggableView localTaggableView = (TaggableView)this.a.findViewById(2131297931);
    long l = this.b.m().getLong("photo_tag_user_id", -1L);
    if (l != -1L)
      localTaggableView.a(l);
    this.b.a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.UploadPhotoActivity.DeleteTagDialogFragment.1
 * JD-Core Version:    0.6.0
 */