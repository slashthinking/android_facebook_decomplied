package com.facebook.katana.activity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.ipc.katana.model.FacebookPlace;
import com.facebook.orca.common.util.LocationUtils;

class ProfileFacebookListActivity$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    FacebookPlace localFacebookPlace = (FacebookPlace)this.a.getIntent().getParcelableExtra("extra_place");
    Uri localUri = LocationUtils.a(localFacebookPlace.mName, localFacebookPlace.mLatitude, localFacebookPlace.mLongitude);
    try
    {
      this.a.startActivity(new Intent("android.intent.action.VIEW", localUri));
      label49: return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      break label49;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.ProfileFacebookListActivity.1
 * JD-Core Version:    0.6.0
 */