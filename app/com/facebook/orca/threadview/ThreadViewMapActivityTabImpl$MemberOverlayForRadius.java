package com.facebook.orca.threadview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.Projection;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

class ThreadViewMapActivityTabImpl$MemberOverlayForRadius extends Overlay
{
  private final Paint b = new Paint();
  private final List<ThreadViewMapActivityTabImpl.MemberOverlayItem> c = Lists.a();

  ThreadViewMapActivityTabImpl$MemberOverlayForRadius(ThreadViewMapActivityTabImpl paramThreadViewMapActivityTabImpl)
  {
    this.b.setARGB(30, 0, 0, 0);
    this.b.setStyle(Paint.Style.FILL);
  }

  public void a()
  {
    this.c.clear();
  }

  public void a(List<ThreadViewMapActivityTabImpl.MemberOverlayItem> paramList)
  {
    this.c.addAll(paramList);
  }

  public void draw(Canvas paramCanvas, MapView paramMapView, boolean paramBoolean)
  {
    if (paramBoolean);
    while (true)
    {
      return;
      Projection localProjection = paramMapView.getProjection();
      Point localPoint = new Point();
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        ThreadViewMapActivityTabImpl.MemberOverlayItem localMemberOverlayItem = (ThreadViewMapActivityTabImpl.MemberOverlayItem)localIterator.next();
        localProjection.toPixels(localMemberOverlayItem.getPoint(), localPoint);
        float f = localProjection.metersToEquatorPixels(localMemberOverlayItem.c());
        paramCanvas.drawCircle(localPoint.x, localPoint.y, f, this.b);
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadViewMapActivityTabImpl.MemberOverlayForRadius
 * JD-Core Version:    0.6.0
 */