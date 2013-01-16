package com.facebook.katana.activity.media;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.analytics.AnalyticsSubModuleActivity;
import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.camera.support.CameraFlowLogger;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities;
import com.facebook.photos.analytics.PhotoFlowLogger;
import com.facebook.photos.analytics.WaterfallIdGenerator;
import java.util.Date;

public class Fb4aCameraFlowLogger
  implements AnalyticsSubModuleActivity, CameraFlowLogger
{
  static final String a = Fb4aCameraSupport.class.getSimpleName();
  final PhotoFlowLogger b;
  final PerformanceLogger c;
  final WaterfallIdGenerator d;
  private String e;
  private boolean f = false;
  private long g;
  private final Date h;

  Fb4aCameraFlowLogger(PhotoFlowLogger paramPhotoFlowLogger, PerformanceLogger paramPerformanceLogger, WaterfallIdGenerator paramWaterfallIdGenerator)
  {
    this.b = paramPhotoFlowLogger;
    this.c = paramPerformanceLogger;
    this.d = paramWaterfallIdGenerator;
    this.h = new Date();
  }

  private void d(String paramString)
  {
    this.e = this.d.a();
    this.b.a(this.e);
    this.b.e(paramString);
  }

  public String a()
  {
    return FB4A_AnalyticEntities.o;
  }

  public void a(int paramInt)
  {
    this.b.d(paramInt);
  }

  public void a(Intent paramIntent)
  {
    paramIntent.putExtra("camera_session_id", this.e);
  }

  public void a(Uri paramUri)
  {
    this.b.b(paramUri);
  }

  public void a(Bundle paramBundle)
  {
    paramBundle.putString("camera_session_id", this.e);
  }

  public void a(Bundle paramBundle, String paramString)
  {
    this.c.a(a());
    this.f = true;
    if (paramBundle != null)
    {
      this.e = paramBundle.getString("camera_session_id");
      if (this.e == null)
        d(paramString);
    }
    while (true)
    {
      return;
      d(paramString);
    }
  }

  public void a(String paramString)
  {
    this.b.b(paramString);
  }

  public void a(String paramString, Exception paramException)
  {
    this.b.a(paramString, paramException);
  }

  public void b()
  {
    this.c.c(a());
  }

  public void b(int paramInt)
  {
    this.b.a(paramInt);
  }

  public void b(Uri paramUri)
  {
    this.b.c(paramUri);
  }

  public void b(String paramString)
  {
    this.b.c(paramString);
  }

  public void c()
  {
    if (this.f)
    {
      this.c.b(a());
      this.f = false;
    }
  }

  public void c(String paramString)
  {
    this.b.f(paramString);
  }

  public void d()
  {
    this.b.g();
    this.g = this.h.getTime();
  }

  public void e()
  {
    long l = this.h.getTime() - this.g;
    this.b.a(l);
  }

  public void f()
  {
    this.b.a(-1);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.Fb4aCameraFlowLogger
 * JD-Core Version:    0.6.0
 */