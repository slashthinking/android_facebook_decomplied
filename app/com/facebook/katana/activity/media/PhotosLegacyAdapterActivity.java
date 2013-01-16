package com.facebook.katana.activity.media;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.facebook.katana.IntentUriHandler;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookAlbum;
import com.facebook.katana.service.method.FqlGetTaggedUserAlbum;
import com.facebook.orca.common.util.StringLocaleUtil;
import java.util.ArrayList;
import java.util.List;

public class PhotosLegacyAdapterActivity extends BaseFacebookActivity
{
  private AppSession n;
  private AppSessionListener o;
  private String p;
  private long q;
  private boolean r;

  private void a(long paramLong)
  {
    if (this.r)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Long.valueOf(paramLong);
      IntentUriHandler.b(this, StringLocaleUtil.a("fb://album_faceweb/%s", arrayOfObject));
    }
    while (true)
    {
      return;
      startActivity(PhotoSetActivity.a(this, paramLong));
    }
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903266);
    ((TextView)findViewById(2131296644)).setText(2131363044);
    Intent localIntent = getIntent();
    this.q = localIntent.getLongExtra("owner", -1L);
    this.p = localIntent.getStringExtra("album");
    this.r = "faceweb".equals(localIntent.getStringExtra("open_method"));
  }

  protected void onPause()
  {
    super.onPause();
    if ((this.n != null) && (this.o != null))
    {
      this.n.b(this.o);
      this.o = null;
    }
  }

  protected void onResume()
  {
    super.onResume();
    if (FqlGetTaggedUserAlbum.a(this.p, this.q))
    {
      startActivity(PhotoSetActivity.b(this, this.q));
      finish();
    }
    while (true)
    {
      return;
      FacebookAlbum localFacebookAlbum = FacebookAlbum.a(this, this.p);
      if ((localFacebookAlbum != null) && (localFacebookAlbum.m() > 0L))
      {
        a(localFacebookAlbum.m());
        finish();
        continue;
      }
      this.n = AppSession.a(this, true);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.p);
      this.o = new PhotosLegacyAdapterActivity.AppListener(this, null);
      this.n.a(this, this.q, localArrayList);
      this.n.a(this.o);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.PhotosLegacyAdapterActivity
 * JD-Core Version:    0.6.0
 */