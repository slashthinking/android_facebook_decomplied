package com.facebook.camera.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.SystemClock;

public class RotationMonitor
  implements SensorEventListener
{
  private SensorManager a;
  private Sensor b;
  private Sensor c;
  private boolean d = false;
  private float[] e = null;
  private float[] f = null;
  private final float[] g = new float[9];
  private final float[] h = new float[9];
  private final float[] i = new float[3];
  private float j = 0.0F;
  private float k = 0.0F;
  private long l = 0L;

  public RotationMonitor(Context paramContext)
  {
    this.a = ((SensorManager)paramContext.getSystemService("sensor"));
    this.b = this.a.getDefaultSensor(1);
    this.c = this.a.getDefaultSensor(2);
    if ((this.b != null) && (this.c != null));
    for (boolean bool = true; ; bool = false)
    {
      this.d = bool;
      return;
    }
  }

  public void a()
  {
    if (this.d)
    {
      this.a.registerListener(this, this.b, 2);
      this.a.registerListener(this, this.c, 2);
    }
  }

  public boolean a(float paramFloat)
  {
    if ((SystemClock.uptimeMillis() < 500L + this.l) && (Math.abs(this.j) < paramFloat) && (Math.abs(this.k) < paramFloat));
    for (int m = 1; ; m = 0)
      return m;
  }

  public void b()
  {
    if (this.d)
      this.a.unregisterListener(this);
  }

  public void onAccuracyChanged(Sensor paramSensor, int paramInt)
  {
  }

  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 1)
      this.e = paramSensorEvent.values;
    if (paramSensorEvent.sensor.getType() == 2)
      this.f = paramSensorEvent.values;
    if ((this.e != null) && (this.f != null) && (SensorManager.getRotationMatrix(this.g, this.h, this.e, this.f)))
    {
      SensorManager.getOrientation(this.g, this.i);
      this.j = (float)(180.0F * this.i[1] / 3.141592653589793D);
      this.k = (float)(180.0F * this.i[2] / 3.141592653589793D);
      this.l = SystemClock.uptimeMillis();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.camera.utils.RotationMonitor
 * JD-Core Version:    0.6.0
 */