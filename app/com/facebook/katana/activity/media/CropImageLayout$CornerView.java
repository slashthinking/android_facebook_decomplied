package com.facebook.katana.activity.media;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;

class CropImageLayout$CornerView extends View
{
  final int a = 27;
  final int b = 53;
  private CornerView d;
  private CornerView e;
  private int f = getResources().getColor(2131165464);

  public CropImageLayout$CornerView(CropImageLayout paramCropImageLayout, Context paramContext)
  {
    super(paramContext);
    setLayoutParams(new RelativeLayout.LayoutParams(80, 80));
  }

  private boolean a(float paramFloat)
  {
    if ((paramFloat >= CropImageLayout.b(this.c).left) && (paramFloat < CropImageLayout.b(this.c).left + CropImageLayout.b(this.c).width()) && (Math.abs(this.d.a() - paramFloat) > 80.0F));
    for (int i = 1; ; i = 0)
      return i;
  }

  private boolean b(float paramFloat)
  {
    if ((paramFloat >= CropImageLayout.b(this.c).top) && (paramFloat < CropImageLayout.b(this.c).top + CropImageLayout.b(this.c).height()) && (Math.abs(this.e.b() - paramFloat) > 80.0F));
    for (int i = 1; ; i = 0)
      return i;
  }

  private RelativeLayout.LayoutParams c()
  {
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(localLayoutParams1);
    localLayoutParams2.leftMargin = localLayoutParams1.leftMargin;
    localLayoutParams2.topMargin = localLayoutParams1.topMargin;
    return localLayoutParams2;
  }

  public float a()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
    return localLayoutParams.leftMargin + localLayoutParams.width / 2;
  }

  public void a(Integer paramInteger1, Integer paramInteger2, boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams = c();
    if ((paramInteger1 != null) && ((!paramBoolean) || (a(paramInteger1.intValue() + localLayoutParams.width / 2))))
      localLayoutParams.leftMargin = paramInteger1.intValue();
    if ((paramInteger2 != null) && ((!paramBoolean) || (b(paramInteger2.intValue() + localLayoutParams.height / 2))))
      localLayoutParams.topMargin = paramInteger2.intValue();
    setLayoutParams(localLayoutParams);
  }

  public boolean a(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 >= getLeft()) && (paramFloat1 <= getRight()) && (paramFloat2 >= getTop()) && (paramFloat2 <= getBottom()));
    for (int i = 1; ; i = 0)
      return i;
  }

  public float b()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
    return localLayoutParams.topMargin + localLayoutParams.height / 2;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    paramCanvas.clipRect(27, 27, 53, 53);
    RectF localRectF = CropImageLayout.a(this.c);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
    localRectF.offset(-localLayoutParams.leftMargin, -localLayoutParams.topMargin);
    paramCanvas.clipRect(localRectF);
    paramCanvas.drawColor(this.f);
    paramCanvas.restore();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.CropImageLayout.CornerView
 * JD-Core Version:    0.6.0
 */