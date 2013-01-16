package com.facebook.katana.activity.media;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import java.util.HashMap;
import java.util.Map;

public class CropImageLayout extends RelativeLayout
{
  private static final int[] a = { -1, 1, 1, -1 };
  private static final int[] b = { -1, -1, 1, 1 };
  private ImageView c;
  private CropImageLayout.BlackoutView d;
  private CropImageLayout.CornerView[] e = new CropImageLayout.CornerView[4];
  private boolean f;
  private float g;
  private float h;
  private int i;
  private int j;
  private Map<Integer, CropImageLayout.DragObject> k;
  private Rect l;
  private float m;

  public CropImageLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }

  public CropImageLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }

  public CropImageLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }

  private void a()
  {
    int n = 0;
    setWillNotDraw(false);
    this.c = new ImageView(getContext());
    this.c.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.c.setBackgroundColor(-16777216);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.c, localLayoutParams);
    this.d = new CropImageLayout.BlackoutView(this, getContext());
    addView(this.d, localLayoutParams);
    for (int i1 = 0; i1 < this.e.length; i1++)
    {
      this.e[i1] = new CropImageLayout.CornerView(this, getContext());
      addView(this.e[i1]);
    }
    int i2 = this.e.length;
    if (n < i2)
    {
      if ((n & 0x1) != 0)
      {
        CropImageLayout.CornerView.a(this.e[n], this.e[((n + 1) % i2)]);
        CropImageLayout.CornerView.b(this.e[n], this.e[((n + 3) % i2)]);
      }
      while (true)
      {
        n++;
        break;
        CropImageLayout.CornerView.b(this.e[n], this.e[((n + 1) % i2)]);
        CropImageLayout.CornerView.a(this.e[n], this.e[((n + 3) % i2)]);
      }
    }
    this.k = new HashMap();
  }

  private void a(float paramFloat1, float paramFloat2)
  {
    RectF localRectF = d();
    float f1 = localRectF.width();
    float f2 = localRectF.height();
    if (paramFloat1 < this.l.left)
      paramFloat1 = this.l.left;
    if (paramFloat2 < this.l.top)
      paramFloat2 = this.l.top;
    if (paramFloat1 + f1 >= this.l.right)
      paramFloat1 = this.l.right - f1 - 1.0F;
    if (paramFloat2 + f2 >= this.l.bottom)
      paramFloat2 = this.l.bottom - f2 - 1.0F;
    this.e[0].a(Integer.valueOf((int)(paramFloat1 - 40.0F)), Integer.valueOf((int)(paramFloat2 - 40.0F)), true);
    this.e[1].a(Integer.valueOf((int)(paramFloat1 + f1 - 40.0F)), Integer.valueOf((int)(paramFloat2 - 40.0F)), true);
    this.e[2].a(Integer.valueOf((int)(f1 + paramFloat1 - 40.0F)), Integer.valueOf((int)(paramFloat2 + f2 - 40.0F)), true);
    this.e[3].a(Integer.valueOf((int)(paramFloat1 - 40.0F)), Integer.valueOf((int)(f2 + paramFloat2 - 40.0F)), true);
  }

  private void b()
  {
    if (this.l == null);
    while (true)
    {
      return;
      int n = this.l.width();
      int i1 = this.l.height();
      int i2 = n / 2;
      int i3 = i1 / 2;
      int i4 = n / 4;
      int i5 = i1 / 4;
      for (int i6 = 0; i6 < this.e.length; i6++)
        this.e[i6].a(Integer.valueOf(-40 + (i2 + this.l.left + i4 * a[i6])), Integer.valueOf(-40 + (i3 + this.l.top + i5 * b[i6])), false);
      invalidate();
    }
  }

  private void c()
  {
    if (this.c.getDrawable() == null);
    while (true)
    {
      return;
      float f1 = this.c.getWidth();
      float f2 = this.c.getHeight();
      this.m = Math.max(this.i / f1, this.j / f2);
      float f3 = this.i / this.m;
      float f4 = this.j / this.m;
      this.l = new Rect();
      this.l.left = (int)((f1 - f3) / 2.0F);
      this.l.right = (int)(f3 + this.l.left);
      this.l.top = (int)((f2 - f4) / 2.0F);
      this.l.bottom = (int)(f4 + this.l.top);
    }
  }

  private RectF d()
  {
    RectF localRectF = new RectF(this.e[0].a(), this.e[0].b(), this.e[2].a(), this.e[2].b());
    localRectF.sort();
    return localRectF;
  }

  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int n = 0;
    int i1 = 0xFF & paramMotionEvent.getAction();
    int i2 = (0xFF00 & paramMotionEvent.getAction()) >> 8;
    int i3 = paramMotionEvent.findPointerIndex(i2);
    float f1 = paramMotionEvent.getX(i2);
    float f2 = paramMotionEvent.getY(i2);
    switch (i1)
    {
    case 3:
    case 4:
    default:
    case 0:
    case 5:
    case 1:
    case 6:
    case 2:
    }
    while (true)
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      while (true)
      {
        label99: return bool;
        if (this.f)
          break;
        CropImageLayout.CornerView[] arrayOfCornerView = this.e;
        int i10 = arrayOfCornerView.length;
        while (n < i10)
        {
          CropImageLayout.CornerView localCornerView2 = arrayOfCornerView[n];
          if (localCornerView2.a(f1, f2))
          {
            this.k.put(Integer.valueOf(i3), new CropImageLayout.DragObject(this, localCornerView2, f1 - localCornerView2.getLeft(), f2 - localCornerView2.getTop()));
            bool = true;
            break label99;
          }
          n++;
        }
        this.k.remove(Integer.valueOf(i3));
        this.d.onTouchEvent(paramMotionEvent);
        bool = super.dispatchTouchEvent(paramMotionEvent);
      }
      int i4 = 0;
      if (i4 < paramMotionEvent.getPointerCount())
      {
        int i7 = paramMotionEvent.getPointerId(i4);
        CropImageLayout.DragObject localDragObject = (CropImageLayout.DragObject)this.k.get(Integer.valueOf(i7));
        if (localDragObject == null);
        while (true)
        {
          i4++;
          break;
          CropImageLayout.CornerView localCornerView1 = CropImageLayout.DragObject.a(localDragObject);
          int i8 = (int)(paramMotionEvent.getX(i4) - CropImageLayout.DragObject.b(localDragObject));
          int i9 = (int)(paramMotionEvent.getY(i4) - CropImageLayout.DragObject.c(localDragObject));
          localCornerView1.a(Integer.valueOf(i8), Integer.valueOf(i9), true);
          CropImageLayout.CornerView.a(localCornerView1).a(null, Integer.valueOf(i9), true);
          CropImageLayout.CornerView.b(localCornerView1).a(Integer.valueOf(i8), null, true);
        }
      }
      if (!this.f)
        continue;
      int i5 = (int)(paramMotionEvent.getX() - this.g);
      int i6 = (int)(paramMotionEvent.getY() - this.h);
      a(i5, i6);
    }
  }

  public Rect getCropArea()
  {
    RectF localRectF = d();
    float f1 = localRectF.left - this.l.left;
    float f2 = localRectF.top - this.l.top;
    float f3 = localRectF.width();
    float f4 = localRectF.height();
    float f5 = f1 * this.m;
    float f6 = f2 * this.m;
    float f7 = f3 * this.m;
    float f8 = f4 * this.m;
    return new Rect((int)f5, (int)f6, (int)(f5 + f7), (int)(f8 + f6));
  }

  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.l = null;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    if (this.l == null)
    {
      c();
      b();
    }
  }

  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.i = paramBitmap.getWidth();
    this.j = paramBitmap.getHeight();
    this.c.setImageBitmap(paramBitmap);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.CropImageLayout
 * JD-Core Version:    0.6.0
 */