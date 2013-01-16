package com.facebook.orca.common.ui.overlay;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.facebook.orca.debug.Tracer;
import com.facebook.widget.CustomViewGroup;

public class OverlayLayout extends CustomViewGroup
{
  public OverlayLayout(Context paramContext)
  {
    super(paramContext);
  }

  public OverlayLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public OverlayLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected OverlayLayout.LayoutParams a()
  {
    return new OverlayLayout.LayoutParams(-1, -1);
  }

  public OverlayLayout.LayoutParams a(AttributeSet paramAttributeSet)
  {
    return new OverlayLayout.LayoutParams(getContext(), paramAttributeSet);
  }

  protected OverlayLayout.LayoutParams a(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new OverlayLayout.LayoutParams(paramLayoutParams);
  }

  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof OverlayLayout.LayoutParams;
  }

  protected void dispatchDraw(Canvas paramCanvas)
  {
    Tracer localTracer = Tracer.a("Overlayout.dispatchDraw");
    try
    {
      super.dispatchDraw(paramCanvas);
      return;
    }
    finally
    {
      localTracer.a();
    }
    throw localObject;
  }

  protected void layoutChild(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    OverlayLayout.LayoutParams localLayoutParams = (OverlayLayout.LayoutParams)paramView.getLayoutParams();
    if (!localLayoutParams.a)
      super.layoutChild(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    View localView;
    do
    {
      int i;
      do
      {
        return;
        i = localLayoutParams.b;
      }
      while (i == -1);
      localView = findViewById(i);
    }
    while (localView == null);
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    localView.getGlobalVisibleRect(localRect1);
    getGlobalVisibleRect(localRect2);
    localRect1.offset(-localRect2.left, -localRect2.top);
    int j = localLayoutParams.c;
    int k = paramView.getMeasuredWidth();
    int m = paramView.getMeasuredHeight();
    if ((j & 0x1) == 1)
    {
      paramInt3 = localRect1.bottom + localLayoutParams.topMargin;
      label147: if ((j & 0x10) != 16)
        break label313;
      paramInt1 = localRect1.left - k - localLayoutParams.rightMargin;
    }
    while (true)
    {
      paramView.layout(paramInt1, paramInt3, paramInt1 + k, paramInt3 + m);
      break;
      if ((j & 0x2) == 2)
      {
        paramInt3 = localRect1.top - m - localLayoutParams.bottomMargin;
        break label147;
      }
      if ((j & 0x4) == 4)
      {
        paramInt3 = localRect1.top + localLayoutParams.topMargin;
        break label147;
      }
      if ((j & 0x8) == 8)
      {
        paramInt3 = localRect1.bottom - m - localLayoutParams.bottomMargin;
        break label147;
      }
      if ((j & 0x100) != 256)
        break label147;
      paramInt3 = (localRect1.bottom + localRect1.top - m) / 2 + (localLayoutParams.topMargin - localLayoutParams.bottomMargin) / 2;
      break label147;
      label313: if ((j & 0x20) == 32)
      {
        paramInt1 = localRect1.right + localLayoutParams.leftMargin;
        continue;
      }
      if ((j & 0x40) == 64)
      {
        paramInt1 = localRect1.left + localLayoutParams.leftMargin;
        continue;
      }
      if ((j & 0x80) == 128)
      {
        paramInt1 = localRect1.right - k - localLayoutParams.rightMargin;
        continue;
      }
      if ((j & 0x200) != 512)
        continue;
      paramInt1 = (localRect1.right + localRect1.left - k) / 2 + (localLayoutParams.leftMargin - localLayoutParams.rightMargin) / 2;
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Tracer localTracer = Tracer.a("Overlayout.onLayout");
    try
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    finally
    {
      localTracer.a();
    }
    throw localObject;
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Tracer localTracer = Tracer.a("Overlayout.onMeasure");
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    finally
    {
      localTracer.a();
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.overlay.OverlayLayout
 * JD-Core Version:    0.6.0
 */