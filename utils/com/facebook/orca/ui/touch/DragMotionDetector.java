package com.facebook.orca.ui.touch;

import android.view.MotionEvent;
import com.facebook.debug.Assert;
import java.util.Arrays;
import java.util.List;

public class DragMotionDetector
{
  boolean a = false;
  private float b = 15.0F;
  private float c = 15.0F;
  private float d = -1.0F;
  private float e;
  private float f;
  private float g;
  private float h;
  private float[] i;
  private float[] j;
  private int k;
  private float l;
  private float m;
  private Draggable n;
  private List<Integer> o;
  private float p;
  private float q;
  private float r;
  private float s;
  private DragMotionDetector.ListenState t = DragMotionDetector.ListenState.MONITORING;
  private int u = 0;

  public DragMotionDetector(Draggable paramDraggable, List<Integer> paramList, float paramFloat1, float paramFloat2)
  {
    this.n = paramDraggable;
    Assert.a(this.n);
    this.i = new float[6];
    this.j = new float[6];
    this.o = paramList;
    this.b = paramFloat1;
    this.c = paramFloat2;
  }

  private boolean a(float paramFloat1, float paramFloat2)
  {
    boolean bool = true;
    if (this.p < this.q)
      if (this.r < this.s)
        if ((paramFloat1 <= this.p) || (paramFloat1 >= this.q) || (paramFloat2 <= this.r) || (paramFloat2 >= this.s))
          break label100;
    while (true)
    {
      return bool;
      label156: if ((paramFloat1 <= this.p) || (paramFloat1 >= this.q) || (paramFloat2 >= this.r) || (paramFloat2 <= this.s))
        label100: 
        do
        {
          do
          {
            bool = false;
            break;
            if (this.r >= this.s)
              break label156;
          }
          while ((paramFloat1 >= this.p) || (paramFloat1 <= this.q) || (paramFloat2 <= this.r) || (paramFloat2 >= this.s));
          break;
        }
        while ((paramFloat1 >= this.p) || (paramFloat1 <= this.q) || (paramFloat2 >= this.r) || (paramFloat2 <= this.s));
    }
  }

  private boolean b(float paramFloat)
  {
    boolean bool = true;
    if ((this.d <= 0.0F) || (paramFloat <= this.d));
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  public float a()
  {
    return this.l;
  }

  public void a(float paramFloat)
  {
    this.d = paramFloat;
  }

  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = true;
    this.p = paramFloat1;
    this.q = paramFloat3;
    this.r = paramFloat2;
    this.s = paramFloat4;
  }

  public boolean a(MotionEvent paramMotionEvent)
  {
    int i1 = 1;
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    default:
      if (this.t != DragMotionDetector.ListenState.INTERCEPTING)
        break;
    case 0:
    case 2:
    case 1:
    case 3:
    }
    while (true)
    {
      return i1;
      this.e = f1;
      this.f = f2;
      this.g = this.e;
      this.h = this.f;
      this.t = DragMotionDetector.ListenState.MONITORING;
      this.l = 0.0F;
      this.m = 0.0F;
      Arrays.fill(this.i, 0.0F);
      Arrays.fill(this.j, 0.0F);
      if ((!this.a) || (a(this.e, this.f)))
        break;
      this.t = DragMotionDetector.ListenState.DEFERRING;
      break;
      switch (DragMotionDetector.1.a[this.t.ordinal()])
      {
      case 1:
      default:
      case 2:
      case 3:
      }
      while (true)
      {
        this.g = f1;
        this.h = f2;
        break;
        float f5 = f1 - this.e;
        float f6 = f2 - this.f;
        float f7 = Math.abs(f5);
        float f8 = Math.abs(f6);
        this.t = DragMotionDetector.ListenState.INTERCEPTING;
        if ((f8 > this.b) && (b(f7)))
          if (f6 > 0.0F)
            this.u = 10;
        while (true)
        {
          if (!this.o.contains(Integer.valueOf(this.u)))
            break label384;
          this.t = DragMotionDetector.ListenState.INTERCEPTING;
          this.n.a(this.e, this.f);
          break;
          this.u = -10;
          continue;
          if ((f7 > this.c) && (b(f8)))
          {
            if (f5 > 0.0F)
              this.u = -1;
            else
              this.u = i1;
          }
          else
          {
            this.t = DragMotionDetector.ListenState.MONITORING;
            this.u = 0;
          }
        }
        label384: if (this.t == DragMotionDetector.ListenState.INTERCEPTING)
        {
          this.t = DragMotionDetector.ListenState.DEFERRING;
          continue;
          this.n.b(f1, f2);
          float f3 = f1 - this.g;
          float f4 = f2 - this.h;
          this.l += f3 - this.i[this.k];
          this.i[this.k] = f3;
          this.k = ((1 + this.k) % this.i.length);
          this.m += f4 - this.j[this.k];
          this.j[this.k] = f4;
          this.k = ((1 + this.k) % this.j.length);
        }
      }
      if ((this.t != DragMotionDetector.ListenState.DEFERRING) && (this.u != 0))
        this.n.c(f1, f2);
      while (true)
      {
        this.u = 0;
        break;
        if (this.t != DragMotionDetector.ListenState.DEFERRING)
        {
          this.n.d(f1, f2);
          this.t = DragMotionDetector.ListenState.MONITORING;
        }
      }
      i1 = 0;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.ui.touch.DragMotionDetector
 * JD-Core Version:    0.6.2
 */