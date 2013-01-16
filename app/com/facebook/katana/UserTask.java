package com.facebook.katana;

import android.os.Handler;

public class UserTask extends Thread
{
  private final Handler a;

  public UserTask(Handler paramHandler)
  {
    this.a = paramHandler;
  }

  protected void a()
  {
  }

  protected void b()
  {
  }

  public void c()
  {
    d();
    start();
  }

  protected void d()
  {
  }

  public void run()
  {
    a();
    this.a.post(new UserTask.1(this));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.UserTask
 * JD-Core Version:    0.6.0
 */