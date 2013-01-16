package com.facebook.katana.activity.composer;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.facebook.ipc.composer.model.ComposerConstants;
import com.facebook.ipc.katana.model.FacebookPlace;

public class ComposerIntent$Builder
{
  private final Context a;
  private Bundle b;

  public ComposerIntent$Builder(Context paramContext)
  {
    this.a = paramContext;
    this.b = new Bundle();
  }

  public Builder a(Location paramLocation)
  {
    this.b.putParcelable("tagged_place_location", paramLocation);
    return this;
  }

  public Builder a(FacebookPlace paramFacebookPlace)
  {
    this.b.putParcelable("tagged_place_profile", paramFacebookPlace);
    return this;
  }

  public Builder a(String paramString)
  {
    this.b.putString("nectar_module", paramString);
    return this;
  }

  public Builder a(boolean paramBoolean)
  {
    this.b.putBoolean("extra_is_share", paramBoolean);
    return this;
  }

  public Builder a(long[] paramArrayOfLong)
  {
    this.b.putLongArray("extra_tagged_ids", paramArrayOfLong);
    return this;
  }

  public ComposerIntent a()
  {
    ComposerIntent localComposerIntent = new ComposerIntent(this, null);
    localComposerIntent.putExtras(this.b);
    return localComposerIntent;
  }

  public Builder b(String paramString)
  {
    this.b.putString("extra_link_for_share", paramString);
    return this;
  }

  public Builder b(boolean paramBoolean)
  {
    this.b.putBoolean(ComposerConstants.b, paramBoolean);
    return this;
  }

  public Builder c(boolean paramBoolean)
  {
    this.b.putBoolean(ComposerConstants.c, paramBoolean);
    return this;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.ComposerIntent.Builder
 * JD-Core Version:    0.6.0
 */