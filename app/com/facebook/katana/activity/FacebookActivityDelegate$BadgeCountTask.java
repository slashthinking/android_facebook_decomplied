package com.facebook.katana.activity;

import android.os.AsyncTask;
import com.facebook.katana.model.FacebookNotifications;
import com.facebook.katana.service.method.NotificationsGet;

class FacebookActivityDelegate$BadgeCountTask extends AsyncTask<Void, Void, Void>
{
  private int b;
  private int c;
  private int d;

  FacebookActivityDelegate$BadgeCountTask(FacebookActivityDelegate paramFacebookActivityDelegate)
  {
  }

  protected Void a(Void[] paramArrayOfVoid)
  {
    this.b = NotificationsGet.a(FacebookActivityDelegate.b(this.a)).d();
    this.c = NotificationsGet.a(FacebookActivityDelegate.b(this.a)).b();
    this.d = NotificationsGet.a(FacebookActivityDelegate.b(this.a)).c();
    return null;
  }

  protected void a(Void paramVoid)
  {
    FacebookActivityDelegate.a(this.a, this.b, this.c, this.d);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.FacebookActivityDelegate.BadgeCountTask
 * JD-Core Version:    0.6.0
 */