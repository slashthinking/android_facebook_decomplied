package com.facebook.photos.photogallery;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.widget.UrlImage;
import com.facebook.widget.ZoomableImageView;

public class PhotoFragment<T extends Photo> extends Fragment
{
  private Photo a;
  private UrlImage b;

  public PhotoFragment()
  {
  }

  public PhotoFragment(T paramT)
  {
    this.a = paramT;
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903480, paramViewGroup, false);
    this.b = ((UrlImage)localView.findViewById(2131296658));
    this.b.setPlaceholderImageParams(this.a.a(Photo.PhotoSize.THUMBNAIL));
    this.b.setImageParams(this.a.a(Photo.PhotoSize.SCREENNAIL));
    return localView;
  }

  public ZoomableImageView a()
  {
    return (ZoomableImageView)this.b.getImageView();
  }

  public void b()
  {
    a().a();
  }

  public void c()
  {
    a().b();
  }

  protected T d()
  {
    return this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.PhotoFragment
 * JD-Core Version:    0.6.0
 */