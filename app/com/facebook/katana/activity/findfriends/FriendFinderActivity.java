package com.facebook.katana.activity.findfriends;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.katana.util.GrowthUtils;

public class FriendFinderActivity extends BaseFacebookActivity
{
  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    HowFound.b(getIntent().getStringExtra("how_found"));
    if (Boolean.TRUE.equals(Gatekeeper.a(this, "new_android_ci_vs_old")))
    {
      GrowthUtils.a(this);
      finish();
    }
    while (true)
    {
      return;
      if (GrowthUtils.a().a(this, 0))
      {
        finish();
        continue;
      }
    }
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 0) && (paramInt2 == -1))
    {
      GrowthUtils.a().a(this);
      GrowthUtils.a().f(this);
      startActivity(new Intent(this, FindFriendsActivity.class));
    }
    finish();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.findfriends.FriendFinderActivity
 * JD-Core Version:    0.6.0
 */