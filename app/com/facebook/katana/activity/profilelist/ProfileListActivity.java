package com.facebook.katana.activity.profilelist;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import com.facebook.debug.Assert;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.activity.ProfileFacebookListActivity;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.util.ApplicationUtils;

public abstract class ProfileListActivity extends ProfileFacebookListActivity
{
  protected ProfileListActivity.ProfileListAdapter B;

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
  }

  public void b(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    FacebookProfile localFacebookProfile = (FacebookProfile)this.B.e(paramInt);
    ApplicationUtils.a(this, localFacebookProfile.mId, localFacebookProfile);
  }

  protected void onPause()
  {
    super.onPause();
    if (this.n != null)
    {
      Assert.a(this.o);
      this.n.b(this.o);
    }
  }

  public void onResume()
  {
    super.onResume();
    this.n = AppSession.b(this, true);
    if (this.n != null)
    {
      Assert.a(this.o);
      this.n.a(this.o);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.profilelist.ProfileListActivity
 * JD-Core Version:    0.6.0
 */