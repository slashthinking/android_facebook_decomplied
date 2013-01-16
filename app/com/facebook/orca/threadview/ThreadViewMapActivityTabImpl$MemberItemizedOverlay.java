package com.facebook.orca.threadview;

import android.graphics.drawable.Drawable;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;
import com.google.common.collect.Lists;
import java.util.List;

class ThreadViewMapActivityTabImpl$MemberItemizedOverlay extends ItemizedOverlay
{
  private List<ThreadViewMapActivityTabImpl.MemberOverlayItem> b = Lists.a();

  public ThreadViewMapActivityTabImpl$MemberItemizedOverlay(ThreadViewMapActivityTabImpl paramThreadViewMapActivityTabImpl, Drawable paramDrawable)
  {
    super(boundCenterBottom(paramDrawable));
  }

  public void a()
  {
    this.b.clear();
  }

  public void a(List<ThreadViewMapActivityTabImpl.MemberOverlayItem> paramList)
  {
    this.b.addAll(paramList);
    populate();
  }

  protected OverlayItem createItem(int paramInt)
  {
    return (OverlayItem)this.b.get(paramInt);
  }

  public int size()
  {
    return this.b.size();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadViewMapActivityTabImpl.MemberItemizedOverlay
 * JD-Core Version:    0.6.0
 */