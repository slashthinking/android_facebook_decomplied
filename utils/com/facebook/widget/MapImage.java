package com.facebook.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.location.Location;
import android.util.AttributeSet;
import com.facebook.R.styleable;
import com.google.common.collect.Lists;
import java.util.List;

public class MapImage extends CustomViewGroup
{
  public static final Location a = new Location("");
  private Location b;
  private int c;
  private List<Location> d;
  private String e;
  private boolean f;
  private boolean g;
  private boolean h = false;
  private UrlImage i;

  public MapImage(Context paramContext)
  {
    this(paramContext, null);
  }

  public MapImage(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public MapImage(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903274);
    this.i = ((UrlImage)getView(2131297063));
    this.d = Lists.a();
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MapImage);
    this.f = localTypedArray.getBoolean(2, false);
    this.g = localTypedArray.getBoolean(3, false);
    this.i.setRetainImageDuringUpdate(this.g);
    this.i.setPlaceHolderDrawable(null);
    this.i.setPlaceholderBackgroundResourceId(2130838366);
    this.c = localTypedArray.getInteger(0, 12);
    this.e = localTypedArray.getString(1);
    if ((this.e != null) && (this.e.startsWith("#")))
      this.e = ("0x" + this.e.substring(1));
    localTypedArray.recycle();
  }

  private void b()
  {
    if (this.h);
    while (true)
    {
      return;
      post(new MapImage.1(this));
      this.h = true;
    }
  }

  private void c()
  {
    if ((this.b != null) || (!this.d.isEmpty()))
      d();
  }

  private void d()
  {
    int j = getWidth() - getPaddingLeft() - getPaddingRight();
    int k = getHeight() - getPaddingBottom() - getPaddingTop();
    Object localObject = this.d;
    if (this.f)
    {
      localObject = Lists.a(this.d);
      ((List)localObject).add(this.b);
    }
    if ((k > 0) && (j > 0))
    {
      MapImage.MapUriBuilder localMapUriBuilder = MapImage.MapUriBuilder.a(getContext()).a(j, k).a(this.e, (List)localObject).a(this.b).a(this.c);
      this.i.setImageParams(localMapUriBuilder.a());
    }
  }

  public void a()
  {
    this.d.clear();
    b();
  }

  public void a(Location paramLocation)
  {
    this.d.add(paramLocation);
    b();
  }

  public Location getCenter()
  {
    return this.b;
  }

  public boolean getKeepMarkerAtCenter()
  {
    return this.f;
  }

  public String getMarkerColor()
  {
    return this.e;
  }

  public boolean getRetainMapDuringUpdate()
  {
    return this.g;
  }

  public int getZoom()
  {
    return this.c;
  }

  @SuppressLint({"DrawAllocation"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
      b();
  }

  public void setCenter(double paramDouble1, double paramDouble2)
  {
    Location localLocation = new Location("");
    localLocation.setLatitude(paramDouble1);
    localLocation.setLongitude(paramDouble2);
    setCenter(localLocation);
  }

  public void setCenter(Location paramLocation)
  {
    this.b = paramLocation;
    b();
  }

  public void setKeepMarkerAtCenter(boolean paramBoolean)
  {
    this.f = paramBoolean;
    b();
  }

  public void setMarkerColor(String paramString)
  {
    this.e = paramString;
    b();
  }

  public void setRetainMapDuringUpdate(boolean paramBoolean)
  {
    this.g = paramBoolean;
    this.i.setRetainImageDuringUpdate(paramBoolean);
  }

  public void setZoom(int paramInt)
  {
    this.c = paramInt;
    b();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.MapImage
 * JD-Core Version:    0.6.2
 */