package com.facebook.katana.activity;

import android.os.AsyncTask;
import com.facebook.katana.service.method.PlacesTellServerLastLocation;
import com.facebook.katana.util.FBLocationManager;

class FbFragmentChromeActivity$AddLocationListenerIfNeededTask extends AsyncTask<Void, Void, Void>
{
  boolean a;

  private FbFragmentChromeActivity$AddLocationListenerIfNeededTask(FbFragmentChromeActivity paramFbFragmentChromeActivity)
  {
  }

  protected Void a(Void[] paramArrayOfVoid)
  {
    this.a = PlacesTellServerLastLocation.a(this.b);
    return null;
  }

  protected void a(Void paramVoid)
  {
    if (this.a)
    {
      FbFragmentChromeActivity localFbFragmentChromeActivity = this.b;
      FBLocationManager.a(localFbFragmentChromeActivity, localFbFragmentChromeActivity);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.FbFragmentChromeActivity.AddLocationListenerIfNeededTask
 * JD-Core Version:    0.6.0
 */