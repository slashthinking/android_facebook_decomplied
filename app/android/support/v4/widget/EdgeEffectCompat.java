package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;

public class EdgeEffectCompat
{
  private static final EdgeEffectCompat.EdgeEffectImpl b;
  private Object a;

  static
  {
    if (Build.VERSION.SDK_INT >= 14)
      b = new EdgeEffectCompat.EdgeEffectIcsImpl();
    while (true)
    {
      return;
      b = new EdgeEffectCompat.BaseEdgeEffectImpl();
    }
  }

  public EdgeEffectCompat(Context paramContext)
  {
    this.a = b.a(paramContext);
  }

  public void a(int paramInt1, int paramInt2)
  {
    b.a(this.a, paramInt1, paramInt2);
  }

  public boolean a()
  {
    return b.a(this.a);
  }

  public boolean a(float paramFloat)
  {
    return b.a(this.a, paramFloat);
  }

  public boolean a(Canvas paramCanvas)
  {
    return b.a(this.a, paramCanvas);
  }

  public void b()
  {
    b.b(this.a);
  }

  public boolean c()
  {
    return b.c(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.EdgeEffectCompat
 * JD-Core Version:    0.6.0
 */