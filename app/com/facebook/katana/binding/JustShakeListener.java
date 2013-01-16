package com.facebook.katana.binding;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.SystemClock;
import com.facebook.bugreporter.BugReportActivity;
import com.facebook.common.util.Toaster;
import com.facebook.katana.LoginActivity;
import com.facebook.katana.activity.FacebookActivityDelegate;

public class JustShakeListener
  implements SensorEventListener
{
  private boolean a = false;
  private float b = 0.0F;
  private long c = -1L;
  private float d = 0.0F;
  private Activity e;
  private FacebookActivityDelegate f;

  public JustShakeListener(Activity paramActivity, FacebookActivityDelegate paramFacebookActivityDelegate)
  {
    this.e = paramActivity;
    this.f = paramFacebookActivityDelegate;
  }

  private AlertDialog.Builder a()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.e);
    localBuilder.setTitle(2131362037).setMessage(this.e.getString(2131362010)).setPositiveButton(this.e.getString(2131363280), new JustShakeListener.1(this));
    localBuilder.setNegativeButton(this.e.getString(2131363016), new JustShakeListener.2(this));
    localBuilder.setOnCancelListener(new JustShakeListener.3(this));
    return localBuilder;
  }

  public void onAccuracyChanged(Sensor paramSensor, int paramInt)
  {
  }

  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    long l = SystemClock.elapsedRealtime();
    if ((l - this.c > 100L) && (this.e != null) && (!this.a) && (!(this.e instanceof BugReportActivity)))
    {
      this.c = l;
      float f1 = paramSensorEvent.values[0];
      float f2 = paramSensorEvent.values[1];
      float f3 = paramSensorEvent.values[2];
      float f4 = (float)Math.sqrt(f1 * f1 + f2 * f2 + f3 * f3);
      this.d = (f4 - this.b + 0.9F * this.d);
      this.b = f4;
      if (this.d > 13.0F)
      {
        if ((this.e instanceof LoginActivity))
          Toaster.a(this.e, 2131362007);
        this.a = true;
        AlertDialog.Builder localBuilder = a();
        if (localBuilder != null)
          localBuilder.show();
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.binding.JustShakeListener
 * JD-Core Version:    0.6.0
 */