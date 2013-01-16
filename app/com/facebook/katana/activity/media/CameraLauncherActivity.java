package com.facebook.katana.activity.media;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.facebook.camera.activity.CameraActivity;
import com.facebook.common.util.ErrorReporting;
import com.facebook.katana.LoginActivity;
import com.facebook.katana.binding.AppSession;

public class CameraLauncherActivity extends FragmentActivity
{
  private void b(boolean paramBoolean)
  {
    if (AppSession.a(this, true) == null)
      if (paramBoolean)
        LoginActivity.c(this);
    while (true)
    {
      return;
      ErrorReporting.a("CAMERA", "LoginActivity returned OK, but no session found", true);
      finish();
      continue;
      Intent localIntent = CameraActivity.a(this).putExtra("started_from_launcher", true);
      localIntent.putExtra("activity_launcher", "CameraLauncher");
      startActivityForResult(localIntent, 1234);
    }
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 2210) && (paramInt2 == -1))
      b(false);
    while (true)
    {
      return;
      finish();
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    b(true);
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    b(true);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.CameraLauncherActivity
 * JD-Core Version:    0.6.0
 */