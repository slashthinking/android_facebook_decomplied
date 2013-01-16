package com.facebook.katana.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.facebook.widget.GalleryWithSwipingFix;

public class NoFlingIntertiaGallery extends GalleryWithSwipingFix
{
  public NoFlingIntertiaGallery(Context paramContext)
  {
    super(paramContext);
  }

  public NoFlingIntertiaGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public NoFlingIntertiaGallery(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    int i;
    if (paramMotionEvent2.getX() > paramMotionEvent1.getX())
    {
      i = 1;
      if (i == 0)
        break label40;
    }
    label40: for (int j = 21; ; j = 22)
    {
      onKeyDown(j, null);
      return true;
      i = 0;
      break;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.view.NoFlingIntertiaGallery
 * JD-Core Version:    0.6.0
 */