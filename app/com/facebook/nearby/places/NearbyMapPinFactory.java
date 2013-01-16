package com.facebook.nearby.places;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;

public class NearbyMapPinFactory
{
  private final Resources a;
  private final AndroidThreadUtil b;

  public NearbyMapPinFactory(Resources paramResources, AndroidThreadUtil paramAndroidThreadUtil)
  {
    this.a = paramResources;
    this.b = paramAndroidThreadUtil;
  }

  private static Drawable b(Drawable paramDrawable)
  {
    paramDrawable.setBounds(-paramDrawable.getIntrinsicWidth() / 2, -paramDrawable.getIntrinsicHeight(), paramDrawable.getIntrinsicWidth() / 2, 0);
    return paramDrawable;
  }

  public Drawable a()
  {
    return b(this.a.getDrawable(2130838436));
  }

  public ListenableFuture<Drawable> a(Bitmap paramBitmap)
  {
    Preconditions.checkNotNull(paramBitmap);
    SettableFuture localSettableFuture = SettableFuture.c();
    this.b.a(new NearbyMapPinFactory.1(this, paramBitmap, localSettableFuture));
    return localSettableFuture;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.places.NearbyMapPinFactory
 * JD-Core Version:    0.6.0
 */