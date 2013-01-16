package com.facebook.orca.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.content.SecureContextHelper;
import com.facebook.orca.annotations.AppInitializationNotRequired;
import com.facebook.orca.annotations.AuthNotRequired;
import com.facebook.orca.app.AppInitLock;
import com.facebook.orca.inject.FbInjector;

@AppInitializationNotRequired
@AuthNotRequired
public abstract class BaseSplashScreenActivity extends FbFragmentActivity
{
  private static final Class<?> n = BaseSplashScreenActivity.class;
  private Intent o;
  private boolean p;
  private final int q;
  private FbInjector r;
  private final Class<? extends Activity> s;

  public BaseSplashScreenActivity(int paramInt, Class<? extends Activity> paramClass)
  {
    this.q = paramInt;
    this.s = paramClass;
  }

  private Intent i()
  {
    Intent localIntent;
    if (this.o != null)
    {
      localIntent = new Intent(this.o);
      localIntent.setFlags(0xEFFFFFFF & localIntent.getFlags());
    }
    while (true)
    {
      return localIntent;
      localIntent = new Intent(this, this.s);
    }
  }

  private void j()
  {
    if (this.p)
      ((SecureContextHelper)this.r.a(SecureContextHelper.class)).a(i(), this);
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      this.o = ((Intent)localIntent.getParcelableExtra("return_intent"));
      this.p = localIntent.getBooleanExtra("should_start_return_intent", true);
    }
    this.r = C();
    AppInitLock localAppInitLock = (AppInitLock)this.r.a(AppInitLock.class);
    if (localAppInitLock.c())
    {
      j();
      finish();
    }
    while (true)
    {
      return;
      localAppInitLock.a(new BaseSplashScreenActivity.1(this));
      setContentView(this.q);
    }
  }

  protected void onPause()
  {
    super.onPause();
    if (!isFinishing())
      setResult(0);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.activity.BaseSplashScreenActivity
 * JD-Core Version:    0.6.2
 */