package com.facebook.widget;

import android.content.Context;
import android.location.Location;
import android.net.Uri;
import android.net.Uri.Builder;
import android.util.DisplayMetrics;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.inject.FbInjector;
import java.util.Iterator;
import java.util.List;

public class MapImage$MapUriBuilder
{
  private Uri.Builder a;
  private DisplayMetrics b;

  public MapImage$MapUriBuilder(DisplayMetrics paramDisplayMetrics)
  {
    this.b = paramDisplayMetrics;
    this.a = Uri.parse("http://maps.google.com/maps/api/staticmap").buildUpon();
    this.a.appendQueryParameter("sensor", "false");
  }

  public static MapUriBuilder a(Context paramContext)
  {
    return (MapUriBuilder)FbInjector.a(paramContext).a(MapUriBuilder.class);
  }

  public Uri a()
  {
    Uri localUri = this.a.build();
    if ((localUri.getQueryParameter("size") == null) || ((localUri.getQueryParameter("center") == null) && (localUri.getQueryParameter("markers") == null)))
      throw new RuntimeException("Must set map size and one of either center or markers.");
    return localUri;
  }

  public MapUriBuilder a(int paramInt)
  {
    if (paramInt >= 0)
      this.a.appendQueryParameter("zoom", String.valueOf(paramInt));
    return this;
  }

  public MapUriBuilder a(int paramInt1, int paramInt2)
  {
    if (this.b.density >= 1.5D)
    {
      paramInt2 /= 2;
      paramInt1 /= 2;
      this.a.appendQueryParameter("scale", "2");
    }
    this.a.appendQueryParameter("size", paramInt1 + "x" + paramInt2);
    return this;
  }

  public MapUriBuilder a(Location paramLocation)
  {
    if (paramLocation != null)
      this.a.appendQueryParameter("center", paramLocation.getLatitude() + "," + paramLocation.getLongitude());
    return this;
  }

  public MapUriBuilder a(String paramString, List<Location> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (!StringUtil.a(paramString))
        localStringBuilder.append("color:" + paramString + "|");
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Location localLocation = (Location)localIterator.next();
        localStringBuilder.append(localLocation.getLatitude() + "," + localLocation.getLongitude() + "|");
      }
      this.a.appendQueryParameter("markers", localStringBuilder.toString());
    }
    return this;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.MapImage.MapUriBuilder
 * JD-Core Version:    0.6.2
 */