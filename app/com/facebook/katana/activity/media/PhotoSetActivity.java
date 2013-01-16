package com.facebook.katana.activity.media;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.katana.AlertDialogs;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.activity.photos.PhotoSetGridFragment;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookAlbum;
import com.facebook.katana.model.FacebookPhotoSet;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.provider.PhotosProvider;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities;
import com.facebook.widget.menu.CustomMenuActivity;
import com.facebook.widget.menu.CustomMenuItem;

public class PhotoSetActivity extends BaseFacebookActivity
  implements AnalyticsActivity, CustomMenuActivity
{
  private AppSession n;
  private AppSessionListener o;
  private String p;
  private Long q;
  private FacebookAlbum r;
  private String s;

  public static Intent a(Context paramContext, long paramLong)
  {
    return a(paramContext, FacebookPhotoSet.b(paramLong));
  }

  public static Intent a(Context paramContext, String paramString)
  {
    return new Intent(paramContext, PhotoSetActivity.class).putExtra("set_token", paramString);
  }

  public static Intent b(Context paramContext, long paramLong)
  {
    return a(paramContext, FacebookPhotoSet.a(paramLong));
  }

  private void i()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("set_token", this.p);
    PhotoSetGridFragment localPhotoSetGridFragment = new PhotoSetGridFragment();
    localPhotoSetGridFragment.f(localBundle);
    FragmentTransaction localFragmentTransaction = g().a();
    localFragmentTransaction.a(2131296394, localPhotoSetGridFragment);
    localFragmentTransaction.a();
  }

  public void K()
  {
  }

  public String a()
  {
    return FB4A_AnalyticEntities.i;
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903488);
    this.n = AppSession.b(this, true);
    this.p = getIntent().getStringExtra("set_token");
    i();
    this.q = FacebookPhotoSet.a(this.p);
    this.o = new PhotoSetActivity.PhotosActivityAppSessionListener(this, null);
    this.n.a(this.o);
  }

  public void a(CustomMenuItem paramCustomMenuItem)
  {
    if (this.q == null);
    while (true)
    {
      return;
      switch (paramCustomMenuItem.c())
      {
      default:
        break;
      case 15:
        Intent localIntent = new Intent(this, CreateEditAlbumActivity.class);
        localIntent.setAction("android.intent.action.EDIT");
        localIntent.setData(Uri.withAppendedPath(PhotosProvider.h, Long.toString(this.q.longValue())));
        startActivity(localIntent);
        break;
      case 16:
        this.r = FacebookAlbum.a(this, this.q.longValue());
        showDialog(23);
      }
    }
  }

  public void d()
  {
    a(this);
    if (this.q != null)
    {
      this.r = FacebookAlbum.a(this, this.q.longValue());
      if ((this.r != null) && (this.r.c() == this.n.b().userId))
      {
        a(15, 2131362820, 2130838301);
        a(16, 2131362816, 2130838299);
      }
    }
  }

  protected Dialog onCreateDialog(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    default:
      localObject = super.onCreateDialog(paramInt);
    case 23:
    case 24:
    }
    while (true)
    {
      return localObject;
      PhotoSetActivity.1 local1 = new PhotoSetActivity.1(this);
      localObject = AlertDialogs.a(this, this.r.d(), 17301543, getString(2131362817), getString(2131363280), local1, getString(2131363016), null, null, true);
      continue;
      localObject = new ProgressDialog(this);
      ((ProgressDialog)localObject).setProgressStyle(0);
      ((ProgressDialog)localObject).setMessage(getText(2131362819));
      ((ProgressDialog)localObject).setIndeterminate(true);
      ((ProgressDialog)localObject).setCancelable(false);
    }
  }

  protected void onPause()
  {
    super.onPause();
    if (this.n != null)
      this.n.b(this.o);
  }

  protected void onResume()
  {
    super.onResume();
    if (this.n != null)
    {
      this.n.a(this.o);
      if ((this.s != null) && (!this.n.a(this.s)))
      {
        removeDialog(24);
        this.s = null;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.PhotoSetActivity
 * JD-Core Version:    0.6.0
 */