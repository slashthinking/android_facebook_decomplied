package com.facebook.katana.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import com.facebook.ipc.katana.model.FacebookPlace;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.binding.ProfileImagesCache;
import com.facebook.katana.binding.StreamPhotosCache;
import com.facebook.katana.model.FacebookProfileUtil;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.model.FacebookUserPersistent;
import com.facebook.katana.platform.PlatformFastTrack;
import com.facebook.katana.service.method.FqlGetProfile;
import com.facebook.widget.MapImage.MapUriBuilder;
import java.util.ArrayList;
import java.util.List;

public class ProfileFacebookListActivity extends BaseFacebookListActivity
{
  protected AppSession n;
  protected AppSessionListener o;
  protected long p;
  protected int q;
  protected FacebookProfile r;
  protected boolean s;

  private boolean i()
  {
    if ((this.p != this.n.b().userId) && (PlatformFastTrack.a(this)));
    for (int i = 1; ; i = 0)
      return i;
  }

  protected void a(Bundle paramBundle)
  {
    this.n = AppSession.a(this, false);
    super.a(paramBundle);
    if (this.s)
    {
      this.p = getIntent().getLongExtra("extra_user_id", this.n.b().userId);
      this.q = 0;
      if (this.p == this.n.b().userId)
        break label200;
      int i = getIntent().getIntExtra("extra_user_type", -1);
      if (i == -1)
        break label173;
      this.q = i;
      this.r = new FacebookProfile(this.p, getIntent().getStringExtra("extra_user_display_name"), getIntent().getStringExtra("extra_image_url"), this.q, getIntent().getBooleanExtra("can_post", false));
      if (!i())
        break label220;
      this.x.add(Integer.valueOf(2130903137));
    }
    while (true)
    {
      this.o = new ProfileFacebookListActivity.FBListActivityAppSessionListener(this);
      return;
      label173: FacebookUserPersistent localFacebookUserPersistent = FacebookUserPersistent.a(this, this.p);
      if (localFacebookUserPersistent == null)
        break;
      this.r = FacebookProfileUtil.a(localFacebookUserPersistent);
      break;
      label200: this.r = FacebookProfileUtil.a(this.n.b().a());
      break;
      label220: this.x.add(Integer.valueOf(2130903138));
    }
  }

  public void j()
  {
    if (!this.s);
    while (true)
    {
      return;
      findViewById(2131296664).setVisibility(8);
      findViewById(2131296662).setVisibility(0);
    }
  }

  public void k()
  {
    if ((!this.s) || (this.n == null))
      return;
    TextView localTextView = (TextView)findViewById(2131296663);
    label53: ImageView localImageView;
    Bitmap localBitmap;
    if ((this.r != null) && (this.r.mDisplayName != null))
    {
      localTextView.setText(this.r.mDisplayName);
      localImageView = (ImageView)findViewById(2131296662);
      if (this.q != 2)
        break label358;
      FacebookPlace localFacebookPlace = (FacebookPlace)getIntent().getParcelableExtra("extra_place");
      Location localLocation = new Location("");
      localLocation.setLatitude(localFacebookPlace.mLatitude);
      localLocation.setLongitude(localFacebookPlace.mLongitude);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localLocation);
      MapImage.MapUriBuilder localMapUriBuilder = MapImage.MapUriBuilder.a(this).a(localLocation).a(14).a(75, 75).a(null, localArrayList);
      localBitmap = this.n.k().a(this, localMapUriBuilder.a().toString());
      localImageView.setOnClickListener(new ProfileFacebookListActivity.1(this));
    }
    while (true)
    {
      if ((localBitmap == null) && (this.r != null))
        localBitmap = this.n.j().a(this, this.p, this.r.mImageUrl);
      if (localBitmap != null)
        localImageView.setImageBitmap(localBitmap);
      while (true)
      {
        if ((!(localImageView instanceof QuickContactBadge)) || (!i()))
          break label356;
        PlatformFastTrack.a(localImageView, this.n.b().username, this.p, new String[] { "vnd.android.cursor.item/vnd.facebook.profile" });
        break;
        localTextView.setText("");
        break label53;
        if (this.q == 2)
        {
          localImageView.setImageDrawable(getResources().getDrawable(2130838856));
          continue;
        }
        if (this.q == 3)
        {
          localImageView.setImageDrawable(getResources().getDrawable(2130838284));
          continue;
        }
        localImageView.setImageDrawable(getResources().getDrawable(2130838447));
      }
      label356: break;
      label358: localBitmap = null;
    }
  }

  protected void o()
  {
  }

  protected void onPause()
  {
    if (this.n != null)
      this.n.b(this.o);
    super.onPause();
  }

  protected void onResume()
  {
    if (this.s)
    {
      this.n = AppSession.a(this, false);
      if (this.n != null)
        this.n.a(this.o);
      if ((this.r != null) && (this.r.mDisplayName != null) && (this.r.mDisplayName.length() != 0) && (this.r.mCanPostKnown))
        break label88;
      FqlGetProfile.a(this, this.p);
    }
    while (true)
    {
      super.onResume();
      return;
      label88: k();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.ProfileFacebookListActivity
 * JD-Core Version:    0.6.0
 */