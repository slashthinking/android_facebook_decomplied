package com.facebook.camera.facetracking;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.view.View;
import android.view.View.MeasureSpec;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FaceDetectionIndicatorView extends View
  implements FaceTracker.TrackedFacesListener
{
  public static final Class<?> c;
  private static ArrayList<Integer> f = new FaceDetectionIndicatorView.1();
  int a = 0;
  int b = 0;
  private final int d = -16711936;
  private final int e = 3;
  private Map<Long, Paint> g = Maps.a();
  private Map<Long, Rect> h = Maps.a();
  private Map<Long, Rect> i = Maps.a();
  private AnimatorSet j = new AnimatorSet();
  private Collection<Animator> k = Lists.a();
  private boolean l = false;

  static
  {
    c = FaceDetectionIndicatorView.class;
  }

  public FaceDetectionIndicatorView(Context paramContext)
  {
    super(paramContext);
  }

  private static int a(float paramFloat, int paramInt)
  {
    return (int)((1000.0F + paramFloat) * paramInt / 2000.0F);
  }

  private Paint a(int paramInt)
  {
    Paint localPaint = new Paint();
    localPaint.setColor(paramInt);
    localPaint.setStrokeWidth(3.0F);
    localPaint.setStyle(Paint.Style.STROKE);
    return localPaint;
  }

  private Rect a(TrackedFace paramTrackedFace)
  {
    return a(paramTrackedFace, this.a, this.b);
  }

  public static Rect a(TrackedFace paramTrackedFace, int paramInt1, int paramInt2)
  {
    Rect localRect = paramTrackedFace.f;
    return new Rect(a(localRect.left, paramInt1), a(localRect.top, paramInt2), a(localRect.right, paramInt1), a(localRect.bottom, paramInt2));
  }

  private Paint getPaintWithRandomColor()
  {
    int n;
    if (f.size() == 0)
      n = -3355444;
    while (true)
    {
      return a(n);
      int m = (int)(Math.random() * f.size());
      n = ((Integer)f.get(m)).intValue();
      f.remove(m);
    }
  }

  public void a()
  {
    this.l = true;
    invalidate();
  }

  public void a(List<TrackedFace> paramList)
  {
    if (paramList == null)
    {
      this.h.clear();
      Iterator localIterator4 = this.g.keySet().iterator();
      while (localIterator4.hasNext())
      {
        Long localLong2 = (Long)localIterator4.next();
        f.add(Integer.valueOf(((Paint)this.g.get(localLong2)).getColor()));
      }
      this.g.clear();
    }
    while (true)
    {
      invalidate();
      return;
      HashSet localHashSet = Sets.a();
      Iterator localIterator1 = this.h.keySet().iterator();
      while (localIterator1.hasNext())
        localHashSet.add((Long)localIterator1.next());
      Iterator localIterator2 = paramList.iterator();
      while (localIterator2.hasNext())
      {
        TrackedFace localTrackedFace = (TrackedFace)localIterator2.next();
        if (!this.g.containsKey(Long.valueOf(localTrackedFace.l)))
          this.g.put(Long.valueOf(localTrackedFace.l), getPaintWithRandomColor());
        if (this.h.containsKey(Long.valueOf(localTrackedFace.l)))
          this.i.put(Long.valueOf(localTrackedFace.l), this.h.get(Long.valueOf(localTrackedFace.l)));
        this.h.put(Long.valueOf(localTrackedFace.l), a(localTrackedFace));
        localHashSet.remove(Long.valueOf(localTrackedFace.l));
      }
      Iterator localIterator3 = localHashSet.iterator();
      while (localIterator3.hasNext())
      {
        Long localLong1 = (Long)localIterator3.next();
        f.add(Integer.valueOf(((Paint)this.g.get(localLong1)).getColor()));
        this.g.remove(localLong1);
        this.h.remove(localLong1);
        this.i.remove(localLong1);
      }
    }
  }

  public void onDraw(Canvas paramCanvas)
  {
    if (this.l)
      this.l = false;
    while (true)
    {
      return;
      this.k.clear();
      Iterator localIterator = this.h.keySet().iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        Paint localPaint = (Paint)this.g.get(localLong);
        Rect localRect1 = (Rect)this.h.get(localLong);
        Rect localRect2 = (Rect)this.i.get(localLong);
        if (localRect2 == null)
        {
          paramCanvas.drawRect(localRect1, localPaint);
          continue;
        }
        paramCanvas.drawRect(localRect2, localPaint);
        Collection localCollection1 = this.k;
        float[] arrayOfFloat1 = new float[2];
        arrayOfFloat1[0] = localRect2.centerX();
        arrayOfFloat1[1] = localRect1.centerX();
        localCollection1.add(ObjectAnimator.a(localRect2, "translationX", arrayOfFloat1));
        Collection localCollection2 = this.k;
        float[] arrayOfFloat2 = new float[2];
        arrayOfFloat2[0] = localRect2.centerY();
        arrayOfFloat2[1] = localRect1.centerY();
        localCollection2.add(ObjectAnimator.a(localRect2, "translationY", arrayOfFloat2));
      }
      this.j.a(this.k);
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setFrameDimensions(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
  }

  public void setFrameDimensions(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.camera.facetracking.FaceDetectionIndicatorView
 * JD-Core Version:    0.6.0
 */