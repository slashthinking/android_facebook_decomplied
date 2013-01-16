package com.facebook.orca.nux;

import android.content.Context;
import android.content.Intent;

public class ThreadNuxController
{
  private final OrcaNuxManager a;
  private Context b;
  private ThreadTitleNuxView c;

  public ThreadNuxController(OrcaNuxManager paramOrcaNuxManager)
  {
    this.a = paramOrcaNuxManager;
  }

  private void c()
  {
    this.a.k();
    this.c.i();
    Intent localIntent = new Intent(this.b, SmsNuxDetailActivity.class);
    this.b.startActivity(localIntent);
  }

  private void d()
  {
    this.a.k();
    this.c.i();
  }

  public void a()
  {
    this.c.f();
    this.c.setOnMoreClickListener(new ThreadNuxController.1(this));
    this.c.setOnOkayClickListener(new ThreadNuxController.2(this));
  }

  public void a(Context paramContext, String paramString, ThreadTitleNuxView paramThreadTitleNuxView)
  {
    this.b = paramContext;
    this.c = paramThreadTitleNuxView;
    if (this.a.a(paramString))
      a();
  }

  public void b()
  {
    if ((this.c != null) && (this.c.isShown()))
      this.c.g();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.nux.ThreadNuxController
 * JD-Core Version:    0.6.0
 */