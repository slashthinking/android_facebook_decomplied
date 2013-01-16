package com.facebook.katana.nux;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.common.util.Toaster;
import com.facebook.katana.binding.AppSession;
import java.io.File;

class SetProfilePicActivity$UploadProfilePicRunnable
  implements Runnable
{
  private final String b;

  private SetProfilePicActivity$UploadProfilePicRunnable(SetProfilePicActivity paramSetProfilePicActivity, String paramString)
  {
    this.b = paramString;
  }

  public void run()
  {
    if (!new File(this.b).exists())
    {
      Toaster.a(this.a.getApplicationContext(), 2131363266);
      SetProfilePicActivity.c(this.a).a(SetProfilePicActivity.i(), "Attempting to upload a profile photo that does not exist: " + this.b);
    }
    while (true)
    {
      return;
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(this.b, localOptions);
      SetProfilePicActivity.b(this.a).a(new SetProfilePicActivity.ProfilePicAppSessionListener(this.a, localOptions.outWidth, null));
      SetProfilePicActivity.b(this.a).a(this.a.getApplicationContext(), 0, null, null, this.b, -1L, -1L, false, -1L, null, -1L, null, 1, 1, null);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.nux.SetProfilePicActivity.UploadProfilePicRunnable
 * JD-Core Version:    0.6.0
 */