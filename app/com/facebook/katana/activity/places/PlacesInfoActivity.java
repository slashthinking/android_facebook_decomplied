package com.facebook.katana.activity.places;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.ipc.katana.model.FacebookPlace;
import com.facebook.katana.activity.ProfileFacebookListActivity;
import com.facebook.katana.binding.AppSession;

public class PlacesInfoActivity extends ProfileFacebookListActivity
{
  private PlacesInfoAdapter t;
  private FacebookPlace u;

  private void a(FacebookPlace paramFacebookPlace)
  {
    this.t.a(paramFacebookPlace);
  }

  private void i()
  {
    ((TextView)findViewById(2131296644)).setText(2131363083);
  }

  public void a(Bundle paramBundle)
  {
    this.s = true;
    this.u = ((FacebookPlace)getIntent().getParcelableExtra("extra_place"));
    this.p = this.u.mPageId;
    super.a(paramBundle);
    setContentView(2130903520);
    this.n = AppSession.a(this, true);
    if (getIntent().getBooleanExtra("within_tab", false))
      findViewById(2131296299).setVisibility(8);
    l();
    j();
    this.t = new PlacesInfoAdapter(this);
    this.t.a(this.u);
    m().setAdapter(this.t);
    PlacesInfoActivity.ActivityBlob localActivityBlob = (PlacesInfoActivity.ActivityBlob)f_();
    if (localActivityBlob != null)
      a(localActivityBlob.a);
    i();
  }

  public Object c()
  {
    if (this.u != null);
    for (PlacesInfoActivity.ActivityBlob localActivityBlob = new PlacesInfoActivity.ActivityBlob(this, this.u); ; localActivityBlob = null)
      return localActivityBlob;
  }

  public void onResume()
  {
    super.onResume();
    this.n = AppSession.a(this, true);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.places.PlacesInfoActivity
 * JD-Core Version:    0.6.0
 */