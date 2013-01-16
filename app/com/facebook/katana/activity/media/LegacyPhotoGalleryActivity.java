package com.facebook.katana.activity.media;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.common.util.Toaster;
import com.facebook.katana.IntentUriHandler;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookAlbum;
import com.facebook.katana.model.FacebookPhoto;
import com.facebook.katana.model.FacebookPhotoSet;
import com.facebook.orca.common.util.StringLocaleUtil;
import java.util.Arrays;

public class LegacyPhotoGalleryActivity extends BaseFacebookActivity
{
  private String n;
  private String o;
  private long p;
  private long q;
  private long r;
  private String s;
  private String t;
  private AppSession u;
  private AppSessionListener v;
  private boolean x = false;
  private boolean y = false;

  public static Intent a(Context paramContext, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Long.valueOf(paramLong);
    arrayOfObject[1] = paramString1;
    arrayOfObject[2] = paramString2;
    arrayOfObject[3] = paramString3;
    return IntentUriHandler.a(paramContext, StringLocaleUtil.a("fb://photo/%1$d/%2$s/%3$s?action=%4$s", arrayOfObject));
  }

  private void i()
  {
    if ((this.y) && (this.x))
      if (this.n == null)
        break label47;
    label47: for (Intent localIntent = PhotoGalleryActivity.a(this, this.r, FacebookPhotoSet.b(this.q)); ; localIntent = PhotoGalleryActivity.a(this, this.r))
    {
      startActivity(localIntent);
      finish();
      return;
    }
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    Intent localIntent = getIntent();
    setContentView(2130903485);
    Uri localUri = localIntent.getData();
    String str;
    if (localUri != null)
    {
      this.o = localUri.getQueryParameter("photo");
      this.n = localUri.getQueryParameter("album");
      str = localUri.getQueryParameter("user");
      if (str != null)
        break label123;
      this.p = -1L;
    }
    while (true)
    {
      if ((this.p < 0L) || (this.o == null))
      {
        Toaster.a(this, 2131363040);
        finish();
      }
      return;
      str = localIntent.getStringExtra("owner");
      this.n = localIntent.getStringExtra("album");
      this.o = localIntent.getStringExtra("photo");
      break;
      try
      {
        label123: this.p = Long.valueOf(str).longValue();
      }
      catch (NumberFormatException localNumberFormatException)
      {
        this.p = -1L;
      }
    }
  }

  protected void onPause()
  {
    super.onPause();
    if ((this.u != null) && (this.v != null))
    {
      this.u.b(this.v);
      this.v = null;
    }
  }

  protected void onResume()
  {
    super.onResume();
    this.u = AppSession.a(this, true);
    this.u.a(new LegacyPhotoGalleryActivity.AppListener(this, null));
    FacebookPhoto localFacebookPhoto = FacebookPhoto.a(this, this.o);
    if (localFacebookPhoto != null)
    {
      this.r = localFacebookPhoto.j();
      this.x = true;
      if (this.n == null)
        break label188;
      FacebookAlbum localFacebookAlbum = FacebookAlbum.a(this, this.n);
      if (localFacebookAlbum == null)
        break label142;
      this.q = localFacebookAlbum.m();
      this.y = true;
    }
    while (true)
    {
      i();
      return;
      AppSession localAppSession1 = this.u;
      String str = this.n;
      String[] arrayOfString1 = new String[1];
      arrayOfString1[0] = this.o;
      this.s = localAppSession1.a(this, str, Arrays.asList(arrayOfString1), this.p);
      break;
      label142: AppSession localAppSession2 = this.u;
      long l = this.p;
      String[] arrayOfString2 = new String[1];
      arrayOfString2[0] = this.n;
      this.t = localAppSession2.a(this, l, Arrays.asList(arrayOfString2));
      continue;
      label188: this.y = true;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.LegacyPhotoGalleryActivity
 * JD-Core Version:    0.6.0
 */