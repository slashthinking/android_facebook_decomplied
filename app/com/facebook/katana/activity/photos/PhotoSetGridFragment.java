package com.facebook.katana.activity.photos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;
import com.facebook.katana.activity.media.PhotoGalleryActivity;
import com.facebook.katana.activity.media.PhotoSetGridAdapter;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookPhotoSet;
import com.google.common.collect.Sets;
import java.util.List;
import java.util.Set;

public class PhotoSetGridFragment extends Fragment
{
  private PhotoSetGridAdapter a;
  private AppSession b;
  private AppSessionListener c;
  private GridView d;
  private final Set<Set<Long>> e = Sets.a();
  private final Set<String> f = Sets.a();
  private String g;
  private LoadCoordinator h = new LoadCoordinator(40);

  private void a(long paramLong)
  {
    a(PhotoGalleryActivity.a(n(), paramLong, this.g));
  }

  private void a(FacebookPhotoSet paramFacebookPhotoSet)
  {
    this.a.a(paramFacebookPhotoSet);
    this.h.a(paramFacebookPhotoSet.a());
    if (paramFacebookPhotoSet.a().size() > 0)
    {
      A().findViewById(16908292).setVisibility(8);
      this.d.setVisibility(0);
    }
    while (true)
    {
      return;
      this.d.setVisibility(8);
      A().findViewById(16908292).setVisibility(0);
      A().findViewById(2131296644).setVisibility(0);
      A().findViewById(2131296645).setVisibility(8);
    }
  }

  private void b()
  {
    ((TextView)A().findViewById(2131296644)).setText(2131363044);
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903486, paramViewGroup, false);
  }

  public void a()
  {
    FacebookPhotoSet localFacebookPhotoSet = FacebookPhotoSet.a(n(), this.g);
    if (localFacebookPhotoSet != null)
      a(localFacebookPhotoSet);
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.d = ((GridView)A().findViewById(16908298));
    Bundle localBundle = m();
    if (localBundle == null)
      localBundle = new Bundle();
    this.b = AppSession.a(n(), true);
    this.g = localBundle.getString("set_token");
    this.a = new PhotoSetGridAdapter(n(), this.b, this.d);
    this.c = new PhotoSetGridFragment.PhotosActivityAppSessionListener(this, null);
    this.b.a(this.c);
    b();
    this.d.setAdapter(this.a);
    this.d.setOnScrollListener(new PhotoSetGridFragment.ScrollListener(this, null));
    this.d.setOnItemClickListener(new PhotoSetGridFragment.ItemClickListener(this, null));
    this.d.setVisibility(8);
    this.b = AppSession.a(n(), true);
    this.b.a(this.c);
    a();
  }

  public void h()
  {
    this.b.b(this.c);
    super.h();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.photos.PhotoSetGridFragment
 * JD-Core Version:    0.6.0
 */