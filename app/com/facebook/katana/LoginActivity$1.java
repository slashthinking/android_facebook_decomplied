package com.facebook.katana;

import com.facebook.katana.security.MalwareDetector;
import com.facebook.orca.app.AppInitLock.Listener;
import com.facebook.orca.inject.FbInjector;

class LoginActivity$1 extends AppInitLock.Listener
{
  public void a()
  {
    new LoginActivity.MalwareDetectorAsyncTask(this.b, (MalwareDetector)this.a.a(MalwareDetector.class), this.b).execute(new Void[0]);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.LoginActivity.1
 * JD-Core Version:    0.6.0
 */