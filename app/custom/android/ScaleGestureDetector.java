package custom.android;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public class ScaleGestureDetector
{
  private Context a;
  private ScaleGestureDetector.OnScaleGestureListener b;
  private boolean c;
  private MotionEvent d;
  private MotionEvent e;
  private float f;
  private float g;
  private float h;
  private float i;
  private float j;
  private float k;
  private float l;
  private float m;
  private float n;
  private float o;
  private float p;
  private long q;
  private float r;
  private float s;
  private float t;
  private boolean u;

  public ScaleGestureDetector(Context paramContext, ScaleGestureDetector.OnScaleGestureListener paramOnScaleGestureListener)
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramContext);
    this.a = paramContext;
    this.b = paramOnScaleGestureListener;
    this.r = localViewConfiguration.getScaledEdgeSlop();
  }

  private static float a(MotionEvent paramMotionEvent, int paramInt)
  {
    return paramMotionEvent.getX() - paramMotionEvent.getRawX() + paramMotionEvent.getX(paramInt);
  }

  private static float b(MotionEvent paramMotionEvent, int paramInt)
  {
    return paramMotionEvent.getY() - paramMotionEvent.getRawY() + paramMotionEvent.getY(paramInt);
  }

  private void b(MotionEvent paramMotionEvent)
  {
    if (this.e != null)
      this.e.recycle();
    this.e = MotionEvent.obtain(paramMotionEvent);
    this.l = -1.0F;
    this.m = -1.0F;
    this.n = -1.0F;
    MotionEvent localMotionEvent = this.d;
    float f1 = localMotionEvent.getX(0);
    float f2 = localMotionEvent.getY(0);
    float f3 = localMotionEvent.getX(1);
    float f4 = localMotionEvent.getY(1);
    float f5 = paramMotionEvent.getX(0);
    float f6 = paramMotionEvent.getY(0);
    float f7 = paramMotionEvent.getX(1);
    float f8 = paramMotionEvent.getY(1);
    float f9 = f3 - f1;
    float f10 = f4 - f2;
    float f11 = f7 - f5;
    float f12 = f8 - f6;
    this.h = f9;
    this.i = f10;
    this.j = f11;
    this.k = f12;
    this.f = (f5 + f11 * 0.5F);
    this.g = (f6 + f12 * 0.5F);
    this.q = (paramMotionEvent.getEventTime() - localMotionEvent.getEventTime());
    this.o = (paramMotionEvent.getPressure(0) + paramMotionEvent.getPressure(1));
    this.p = (localMotionEvent.getPressure(0) + localMotionEvent.getPressure(1));
  }

  private void g()
  {
    if (this.d != null)
    {
      this.d.recycle();
      this.d = null;
    }
    if (this.e != null)
    {
      this.e.recycle();
      this.e = null;
    }
    this.u = false;
    this.c = false;
  }

  public boolean a()
  {
    return this.c;
  }

  public boolean a(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    int i8;
    int i9;
    if (!this.c)
      if (((i1 == 5) || (i1 == 261)) && (paramMotionEvent.getPointerCount() >= 2))
      {
        DisplayMetrics localDisplayMetrics = this.a.getResources().getDisplayMetrics();
        this.s = (localDisplayMetrics.widthPixels - this.r);
        this.t = (localDisplayMetrics.heightPixels - this.r);
        g();
        this.d = MotionEvent.obtain(paramMotionEvent);
        this.q = 0L;
        b(paramMotionEvent);
        float f8 = this.r;
        float f9 = this.s;
        float f10 = this.t;
        float f11 = paramMotionEvent.getRawX();
        float f12 = paramMotionEvent.getRawY();
        float f13 = a(paramMotionEvent, 1);
        float f14 = b(paramMotionEvent, 1);
        if ((f11 < f8) || (f12 < f8) || (f11 > f9) || (f12 > f10))
        {
          i8 = 1;
          if ((f13 >= f8) && (f14 >= f8) && (f13 <= f9) && (f14 <= f10))
            break label245;
          i9 = 1;
          label210: if ((i8 == 0) || (i9 == 0))
            break label251;
          this.f = -1.0F;
          this.g = -1.0F;
          this.u = true;
        }
      }
    while (true)
    {
      return true;
      i8 = 0;
      break;
      label245: i9 = 0;
      break label210;
      label251: if (i8 != 0)
      {
        this.f = paramMotionEvent.getX(1);
        this.g = paramMotionEvent.getY(1);
        this.u = true;
        continue;
      }
      if (i9 != 0)
      {
        this.f = paramMotionEvent.getX(0);
        this.g = paramMotionEvent.getY(0);
        this.u = true;
        continue;
      }
      this.c = this.b.b(this);
      continue;
      if ((i1 == 2) && (this.u))
      {
        float f1 = this.r;
        float f2 = this.s;
        float f3 = this.t;
        float f4 = paramMotionEvent.getRawX();
        float f5 = paramMotionEvent.getRawY();
        float f6 = a(paramMotionEvent, 1);
        float f7 = b(paramMotionEvent, 1);
        int i6;
        if ((f4 < f1) || (f5 < f1) || (f4 > f2) || (f5 > f3))
        {
          i6 = 1;
          label421: if ((f6 >= f1) && (f7 >= f1) && (f6 <= f2) && (f7 <= f3))
            break label487;
        }
        label487: for (int i7 = 1; ; i7 = 0)
        {
          if ((i6 == 0) || (i7 == 0))
            break label493;
          this.f = -1.0F;
          this.g = -1.0F;
          break;
          i6 = 0;
          break label421;
        }
        label493: if (i6 != 0)
        {
          this.f = paramMotionEvent.getX(1);
          this.g = paramMotionEvent.getY(1);
          continue;
        }
        if (i7 != 0)
        {
          this.f = paramMotionEvent.getX(0);
          this.g = paramMotionEvent.getY(0);
          continue;
        }
        this.u = false;
        this.c = this.b.b(this);
        continue;
      }
      if (((i1 != 6) && (i1 != 262)) || (!this.u))
        continue;
      int i4 = (i1 & 0xFF00) >> 8;
      int i5 = 0;
      if (i4 == 0)
        i5 = 1;
      this.f = paramMotionEvent.getX(i5);
      this.g = paramMotionEvent.getY(i5);
      continue;
      switch (i1)
      {
      default:
        break;
      case 2:
        b(paramMotionEvent);
        if ((this.o / this.p <= 0.67F) || (!this.b.a(this)))
          continue;
        this.d.recycle();
        this.d = MotionEvent.obtain(paramMotionEvent);
        break;
      case 6:
      case 262:
        b(paramMotionEvent);
        int i2 = (i1 & 0xFF00) >> 8;
        int i3 = 0;
        if (i2 == 0)
          i3 = 1;
        this.f = paramMotionEvent.getX(i3);
        this.g = paramMotionEvent.getY(i3);
        if (!this.u)
          this.b.c(this);
        g();
        break;
      case 3:
        if (!this.u)
          this.b.c(this);
        g();
      }
    }
  }

  public float b()
  {
    return this.f;
  }

  public float c()
  {
    return this.g;
  }

  public float d()
  {
    if (this.l == -1.0F)
    {
      float f1 = this.j;
      float f2 = this.k;
      this.l = (float)Math.sqrt(f1 * f1 + f2 * f2);
    }
    return this.l;
  }

  public float e()
  {
    if (this.m == -1.0F)
    {
      float f1 = this.h;
      float f2 = this.i;
      this.m = (float)Math.sqrt(f1 * f1 + f2 * f2);
    }
    return this.m;
  }

  public float f()
  {
    if (this.n == -1.0F)
      this.n = (d() / e());
    return this.n;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     custom.android.ScaleGestureDetector
 * JD-Core Version:    0.6.0
 */