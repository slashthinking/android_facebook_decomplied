package com.facebook.widget.listview.recycle;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.LinearLayout;

final class FbListItemViewPoolManager$PreinflationHelperViewGroup extends LinearLayout
{
  public FbListItemViewPoolManager$PreinflationHelperViewGroup(Context paramContext)
  {
    super(paramContext);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    throw new RuntimeException("this helper view shall not show up in view hierarchy");
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.listview.recycle.FbListItemViewPoolManager.PreinflationHelperViewGroup
 * JD-Core Version:    0.6.2
 */