package com.facebook.katana.activity.media.crop;

import [F;
import android.graphics.RectF;
import android.view.MotionEvent;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

public class CropRectTouchManager
{
  private final CropState a;
  private final CropHelper b;
  private float[][] c;
  private Corner[] d;
  private Edge[] e;
  private Map<Integer, DragObject> f;
  private boolean g;
  private CropRectTouchManager.OnAnimationRequestedListener h;

  public CropRectTouchManager(CropHelper paramCropHelper, CropState paramCropState)
  {
    int[] arrayOfInt = { 2, 2 };
    this.c = ((float[][])Array.newInstance(Float.TYPE, arrayOfInt));
    this.d = new Corner[4];
    this.e = new Edge[4];
    this.g = false;
    this.h = null;
    this.b = paramCropHelper;
    this.a = paramCropState;
    this.f = new HashMap();
    int j;
    for (int i = 0; ; i++)
    {
      j = 0;
      if (i >= 4)
        break;
      this.d[i] = new Corner(i / 2, i % 2);
    }
    if (j < 4)
    {
      int k;
      if (j < 2)
      {
        k = -1;
        label132: if (j < 2)
          break label174;
      }
      label174: for (int m = -1; ; m = j)
      {
        this.e[j] = new Edge(k, m);
        j++;
        break;
        k = j - 2;
        break label132;
      }
    }
  }

  private RectF a(float[][] paramArrayOfFloat)
  {
    return new RectF(paramArrayOfFloat[0][0], paramArrayOfFloat[1][0], paramArrayOfFloat[0][1], paramArrayOfFloat[1][1]);
  }

  private void a(RectF paramRectF)
  {
    this.c[0][0] = paramRectF.left;
    this.c[0][1] = paramRectF.right;
    this.c[1][0] = paramRectF.top;
    this.c[1][1] = paramRectF.bottom;
  }

  private boolean a(int paramInt, float paramFloat1, float paramFloat2)
  {
    int i = 1;
    Corner[] arrayOfCorner = this.d;
    int j = arrayOfCorner.length;
    int k = 0;
    if (k < j)
    {
      Corner localCorner = arrayOfCorner[k];
      if (localCorner.a(paramFloat1, paramFloat2, this.c))
        this.f.put(Integer.valueOf(paramInt), new DragObject(localCorner, paramFloat1, paramFloat2, this.a.i()));
    }
    while (true)
    {
      return i;
      k++;
      break;
      Edge[] arrayOfEdge = this.e;
      int m = arrayOfEdge.length;
      for (int n = 0; ; n++)
      {
        if (n >= m)
          break label169;
        Edge localEdge = arrayOfEdge[n];
        if (!localEdge.a(paramFloat1, paramFloat2, this.c))
          continue;
        this.f.put(Integer.valueOf(paramInt), new DragObject(localEdge, paramFloat1, paramFloat2, this.a.i()));
        break;
      }
      label169: i = 0;
    }
  }

  private boolean b(MotionEvent paramMotionEvent)
  {
    int i = 0;
    int j = paramMotionEvent.getPointerCount();
    int k = 0;
    if (i < j)
    {
      int m = paramMotionEvent.getPointerId(i);
      DragObject localDragObject = (DragObject)this.f.get(Integer.valueOf(m));
      if (localDragObject == null);
      Touchable localTouchable;
      int n;
      int i1;
      do
      {
        i++;
        break;
        localTouchable = localDragObject.a();
        n = (int)(paramMotionEvent.getX(i) - localDragObject.a);
        i1 = (int)(paramMotionEvent.getY(i) - localDragObject.b);
      }
      while (a(localTouchable, n, i1, this.c));
      if (localTouchable.a[0] != -1)
      {
        float[] arrayOfFloat2 = this.c[0];
        int i3 = localTouchable.a[0];
        arrayOfFloat2[i3] += n;
      }
      if (localTouchable.a[1] != -1)
      {
        float[] arrayOfFloat1 = this.c[1];
        int i2 = localTouchable.a[1];
        arrayOfFloat1[i2] += i1;
      }
      localDragObject.a += n;
      localDragObject.b += i1;
      this.a.b(b());
      this.a.c();
      this.g = true;
      k = 1;
    }
    return k;
  }

  private void d()
  {
    this.h.a();
  }

  public void a(CropRectTouchManager.OnAnimationRequestedListener paramOnAnimationRequestedListener)
  {
    this.h = paramOnAnimationRequestedListener;
  }

  public boolean a()
  {
    return this.g;
  }

  public boolean a(MotionEvent paramMotionEvent)
  {
    int i = 1;
    this.g = false;
    int j = (0xFF00 & paramMotionEvent.getAction()) >> 8;
    int k = paramMotionEvent.findPointerIndex(j);
    float f1 = paramMotionEvent.getX(j);
    float f2 = paramMotionEvent.getY(j);
    switch (paramMotionEvent.getActionMasked())
    {
    case 3:
    case 4:
    default:
      i = 0;
    case 0:
    case 5:
    case 1:
    case 6:
    case 2:
    }
    while (true)
    {
      return i;
      if (!a(k, f1, f2))
        break;
      continue;
      DragObject localDragObject = (DragObject)this.f.get(Integer.valueOf(k));
      if (localDragObject != null)
      {
        RectF localRectF1 = localDragObject.c;
        RectF localRectF2 = b();
        if ((localRectF2.centerX() != localRectF1.centerX()) || (localRectF2.centerY() != localRectF1.centerY()))
          d();
      }
      this.f.remove(Integer.valueOf(k));
      i = 0;
      continue;
      if (!b(paramMotionEvent))
        break;
    }
  }

  protected boolean a(Touchable paramTouchable, float paramFloat1, float paramFloat2, float[][] paramArrayOfFloat)
  {
    float[][] arrayOfFloat = new float[2][];
    float[] arrayOfFloat1 = new float[2];
    arrayOfFloat1[0] = paramArrayOfFloat[0][0];
    arrayOfFloat1[1] = paramArrayOfFloat[0][1];
    arrayOfFloat[0] = arrayOfFloat1;
    float[] arrayOfFloat2 = new float[2];
    arrayOfFloat2[0] = paramArrayOfFloat[1][0];
    arrayOfFloat2[1] = paramArrayOfFloat[1][1];
    arrayOfFloat[1] = arrayOfFloat2;
    if (paramTouchable.a[0] != -1)
    {
      [F local[F2 = arrayOfFloat[0];
      int k = paramTouchable.a[0];
      local[F2[k] = (paramFloat1 + local[F2[k]);
    }
    if (paramTouchable.a[1] != -1)
    {
      [F local[F1 = arrayOfFloat[1];
      int j = paramTouchable.a[1];
      local[F1[j] = (paramFloat2 + local[F1[j]);
    }
    CropState localCropState = this.a.a(this.a, a(arrayOfFloat));
    int i;
    if (!this.b.a(localCropState))
    {
      boolean bool = this.b.b(localCropState);
      i = 0;
      if (!bool);
    }
    else
    {
      i = 1;
    }
    return i;
  }

  protected RectF b()
  {
    return a(this.c);
  }

  public void c()
  {
    if (this.a.i() == null)
      this.a.b(new RectF(0.0F, 0.0F, 0.0F, 0.0F));
    a(this.a.i());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.crop.CropRectTouchManager
 * JD-Core Version:    0.6.0
 */