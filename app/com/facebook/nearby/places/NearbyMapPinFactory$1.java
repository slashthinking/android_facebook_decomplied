package com.facebook.nearby.places;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.TypedValue;
import com.google.common.util.concurrent.SettableFuture;

class NearbyMapPinFactory$1
  implements Runnable
{
  public void run()
  {
    LayerDrawable localLayerDrawable = (LayerDrawable)NearbyMapPinFactory.a(this.c).getDrawable(2130838436);
    int i = (int)TypedValue.applyDimension(1, 30.0F, NearbyMapPinFactory.a(this.c).getDisplayMetrics());
    Bitmap localBitmap = Bitmap.createScaledBitmap(this.a, i, i, true);
    localLayerDrawable.mutate();
    localLayerDrawable.setDrawableByLayerId(2131298006, new BitmapDrawable(NearbyMapPinFactory.a(this.c), localBitmap));
    NearbyMapPinFactory.a(localLayerDrawable);
    this.b.a_(localLayerDrawable);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.places.NearbyMapPinFactory.1
 * JD-Core Version:    0.6.0
 */