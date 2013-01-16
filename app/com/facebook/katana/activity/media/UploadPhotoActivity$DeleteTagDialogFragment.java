package com.facebook.katana.activity.media;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import com.facebook.katana.AlertDialogs;

class UploadPhotoActivity$DeleteTagDialogFragment extends DialogFragment
{
  public static DialogFragment a(long paramLong)
  {
    DeleteTagDialogFragment localDeleteTagDialogFragment = new DeleteTagDialogFragment();
    Bundle localBundle = new Bundle();
    localBundle.putLong("photo_tag_user_id", paramLong);
    localDeleteTagDialogFragment.f(localBundle);
    return localDeleteTagDialogFragment;
  }

  public Dialog c(Bundle paramBundle)
  {
    UploadPhotoActivity localUploadPhotoActivity = (UploadPhotoActivity)n();
    UploadPhotoActivity.DeleteTagDialogFragment.1 local1 = new UploadPhotoActivity.DeleteTagDialogFragment.1(this, localUploadPhotoActivity);
    return AlertDialogs.a(localUploadPhotoActivity, e(2131363028), 17301543, e(2131363029), e(2131363280), local1, e(2131363016), null, null, true);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.UploadPhotoActivity.DeleteTagDialogFragment
 * JD-Core Version:    0.6.0
 */