package com.facebook.camera.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.facebook.orca.activity.FbFragmentActivity;

public class VideoCameraActivity extends FbFragmentActivity
{
  private void i()
  {
    startActivityForResult(new Intent("android.media.action.VIDEO_CAPTURE"), 1336);
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    Toast.makeText(this, "Custom video recording is not supported yet. Launching the default camera instead.", 0).show();
    i();
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1336)
    {
      setResult(paramInt2, paramIntent);
      finish();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.camera.activity.VideoCameraActivity
 * JD-Core Version:    0.6.0
 */