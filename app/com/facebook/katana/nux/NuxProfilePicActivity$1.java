package com.facebook.katana.nux;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.content.SecureContextHelper;
import com.facebook.katana.activity.media.MediaPickerActivity;
import com.facebook.katana.activity.media.MediaPickerEnvironment;
import com.facebook.katana.activity.media.MediaPickerEnvironment.Builder;

class NuxProfilePicActivity$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    MediaPickerEnvironment localMediaPickerEnvironment = new MediaPickerEnvironment.Builder(-1L).b(true).a(false).c(true).d(false).a();
    Intent localIntent = new Intent(this.a.getApplicationContext(), MediaPickerActivity.class);
    localIntent.putExtra("extra_for_result", true);
    localIntent.putExtra("extra_environment", localMediaPickerEnvironment);
    localIntent.putExtra("extra_source_activity", getClass().getSimpleName());
    NuxProfilePicActivity.a(this.a).a(localIntent, 124, this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.nux.NuxProfilePicActivity.1
 * JD-Core Version:    0.6.0
 */