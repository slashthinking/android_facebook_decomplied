package com.facebook.orca.camera;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.facebook.orca.images.RotateBitmap;
import java.util.ArrayList;
import java.util.Iterator;

class CropImageView extends ImageViewTouchBase
{
  ArrayList<HighlightView> a = new ArrayList();
  HighlightView b = null;
  float c;
  float d;
  int e;

  public CropImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private void a(MotionEvent paramMotionEvent)
  {
    int k;
    for (int i = 0; ; i++)
    {
      int j = this.a.size();
      k = 0;
      if (i >= j)
        break;
      HighlightView localHighlightView2 = (HighlightView)this.a.get(i);
      localHighlightView2.a(false);
      localHighlightView2.c();
    }
    while (true)
    {
      k++;
      if (k >= this.a.size())
        break;
      HighlightView localHighlightView1 = (HighlightView)this.a.get(k);
      if (localHighlightView1.a(paramMotionEvent.getX(), paramMotionEvent.getY()) == 1)
        continue;
      if (localHighlightView1.a())
        break;
      localHighlightView1.a(true);
      localHighlightView1.c();
    }
    invalidate();
  }

  private void b(HighlightView paramHighlightView)
  {
    Rect localRect = paramHighlightView.d;
    int i = Math.max(0, getLeft() - localRect.left);
    int j = Math.min(0, getRight() - localRect.right);
    int k = Math.max(0, getTop() - localRect.top);
    int m = Math.min(0, getBottom() - localRect.bottom);
    if (i != 0)
      if (k == 0)
        break label98;
    while (true)
    {
      if ((i != 0) || (k != 0))
        b(i, k);
      return;
      i = j;
      break;
      label98: k = m;
    }
  }

  private void c(HighlightView paramHighlightView)
  {
    Rect localRect = paramHighlightView.d;
    float f1 = localRect.width();
    float f2 = localRect.height();
    float f3 = getWidth();
    float f4 = getHeight();
    float f5 = Math.max(1.0F, Math.min(0.6F * (f3 / f1), 0.6F * (f4 / f2)) * b());
    if (Math.abs(f5 - b()) / f5 > 0.1D)
    {
      float[] arrayOfFloat = new float[2];
      arrayOfFloat[0] = paramHighlightView.e.centerX();
      arrayOfFloat[1] = paramHighlightView.e.centerY();
      getImageMatrix().mapPoints(arrayOfFloat);
      a(f5, arrayOfFloat[0], arrayOfFloat[1], 300.0F);
    }
    b(paramHighlightView);
  }

  protected void a(float paramFloat1, float paramFloat2)
  {
    super.a(paramFloat1, paramFloat2);
    for (int i = 0; i < this.a.size(); i++)
    {
      HighlightView localHighlightView = (HighlightView)this.a.get(i);
      localHighlightView.f.postTranslate(paramFloat1, paramFloat2);
      localHighlightView.c();
    }
  }

  protected void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super.a(paramFloat1, paramFloat2, paramFloat3);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      HighlightView localHighlightView = (HighlightView)localIterator.next();
      localHighlightView.f.set(getImageMatrix());
      localHighlightView.c();
    }
  }

  public void a(HighlightView paramHighlightView)
  {
    this.a.add(paramHighlightView);
    invalidate();
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    for (int i = 0; i < this.a.size(); i++)
      ((HighlightView)this.a.get(i)).a(paramCanvas);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.h.b() != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        HighlightView localHighlightView = (HighlightView)localIterator.next();
        localHighlightView.f.set(getImageMatrix());
        localHighlightView.c();
        if (!localHighlightView.b)
          continue;
        c(localHighlightView);
      }
    }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    CropImage localCropImage = (CropImage)getContext();
    boolean bool = localCropImage.b;
    int i = 0;
    if (bool)
      return i;
    switch (paramMotionEvent.getAction())
    {
    default:
      label52: switch (paramMotionEvent.getAction())
      {
      default:
      case 1:
      case 2:
      }
    case 0:
    case 1:
    case 2:
    }
    while (true)
    {
      i = 1;
      break;
      if (localCropImage.a)
      {
        a(paramMotionEvent);
        break label52;
      }
      for (int m = 0; m < this.a.size(); m++)
      {
        HighlightView localHighlightView2 = (HighlightView)this.a.get(m);
        int n = localHighlightView2.a(paramMotionEvent.getX(), paramMotionEvent.getY());
        if (n == 1)
          continue;
        this.e = n;
        this.b = localHighlightView2;
        this.c = paramMotionEvent.getX();
        this.d = paramMotionEvent.getY();
        HighlightView localHighlightView3 = this.b;
        if (n == 32);
        for (HighlightView.ModifyMode localModifyMode = HighlightView.ModifyMode.Move; ; localModifyMode = HighlightView.ModifyMode.Grow)
        {
          localHighlightView3.a(localModifyMode);
          break;
        }
      }
      if (localCropImage.a)
        for (int j = 0; ; j++)
        {
          if (j >= this.a.size())
            break label372;
          HighlightView localHighlightView1 = (HighlightView)this.a.get(j);
          if (!localHighlightView1.a())
            continue;
          localCropImage.c = localHighlightView1;
          int k = 0;
          if (k < this.a.size())
          {
            if (k == j);
            while (true)
            {
              k++;
              break;
              ((HighlightView)this.a.get(k)).b(true);
            }
          }
          c(localHighlightView1);
          ((CropImage)getContext()).a = false;
          i = 1;
          break;
        }
      if (this.b != null)
      {
        c(this.b);
        this.b.a(HighlightView.ModifyMode.None);
      }
      label372: this.b = null;
      break label52;
      if (localCropImage.a)
      {
        a(paramMotionEvent);
        break label52;
      }
      if (this.b == null)
        break label52;
      this.b.a(this.e, paramMotionEvent.getX() - this.c, paramMotionEvent.getY() - this.d);
      this.c = paramMotionEvent.getX();
      this.d = paramMotionEvent.getY();
      b(this.b);
      break label52;
      a(true, true);
      continue;
      if (b() != 1.0F)
        continue;
      a(true, true);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.camera.CropImageView
 * JD-Core Version:    0.6.0
 */