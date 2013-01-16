package com.facebook.orca.activity;

import com.facebook.orca.app.AppInitLock.Listener;

class BaseSplashScreenActivity$1 extends AppInitLock.Listener
{
  BaseSplashScreenActivity$1(BaseSplashScreenActivity paramBaseSplashScreenActivity)
  {
  }

  public void a()
  {
    BaseSplashScreenActivity.a(this.a);
    this.a.setResult(-1);
    this.a.finish();
    this.a.overridePendingTransition(0, 0);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.activity.BaseSplashScreenActivity.1
 * JD-Core Version:    0.6.2
 */