package com.facebook.maps;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.location.Location;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Projection;

public class FixedMyLocationOverlay extends MyLocationOverlay
{
  private boolean a = false;
  private Paint b;
  private Point c;
  private Point d;
  private Drawable e;
  private int f;
  private int g;

  public FixedMyLocationOverlay(Context paramContext, MapView paramMapView)
  {
    super(paramContext, paramMapView);
  }

  protected void drawMyLocation(Canvas paramCanvas, MapView paramMapView, Location paramLocation, GeoPoint paramGeoPoint, long paramLong)
  {
    if (!this.a);
    try
    {
      super.drawMyLocation(paramCanvas, paramMapView, paramLocation, paramGeoPoint, paramLong);
      if (this.a)
      {
        if (this.e == null)
        {
          this.b = new Paint();
          this.b.setAntiAlias(true);
          this.b.setStrokeWidth(2.0F);
          this.e = paramMapView.getContext().getResources().getDrawable(2130838669);
          this.f = this.e.getIntrinsicWidth();
          this.g = this.e.getIntrinsicHeight();
          this.c = new Point();
          this.d = new Point();
        }
        Projection localProjection = paramMapView.getProjection();
        double d1 = paramLocation.getLatitude();
        double d2 = paramLocation.getLongitude();
        float f1 = paramLocation.getAccuracy();
        float[] arrayOfFloat = new float[1];
        Location.distanceBetween(d1, d2, d1, d2 + 1.0D, arrayOfFloat);
        float f2 = arrayOfFloat[0];
        localProjection.toPixels(new GeoPoint((int)(d1 * 1000000.0D), (int)(1000000.0D * (d2 - f1 / f2))), this.d);
        localProjection.toPixels(paramGeoPoint, this.c);
        int i = this.c.x - this.d.x;
        this.b.setColor(-10066177);
        this.b.setStyle(Paint.Style.STROKE);
        paramCanvas.drawCircle(this.c.x, this.c.y, i, this.b);
        this.b.setColor(409364223);
        this.b.setStyle(Paint.Style.FILL);
        paramCanvas.drawCircle(this.c.x, this.c.y, i, this.b);
        this.e.setBounds(this.c.x - this.f / 2, this.c.y - this.g / 2, this.c.x + this.f / 2, this.c.y + this.g / 2);
        this.e.draw(paramCanvas);
      }
      return;
    }
    catch (Exception localException)
    {
      while (true)
        this.a = true;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.maps.FixedMyLocationOverlay
 * JD-Core Version:    0.6.2
 */