package com.facebook.katana.platform;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.Assert;
import com.facebook.katana.activity.FB4ASplashScreenActivity;
import com.facebook.orca.activity.FbFragmentActivity;
import com.facebook.orca.app.AppInitLock;
import com.facebook.orca.inject.FbInjector;

public abstract class PlatformLauncherActivity extends Activity
{
  private Class<?> a = PlatformLauncherActivity.class;
  private final Class<? extends FbFragmentActivity> b;
  private final int c;
  private String d;
  private FbInjector e;

  public PlatformLauncherActivity(Class<? extends FbFragmentActivity> paramClass, int paramInt)
  {
    if (paramInt != 10);
    for (boolean bool = true; ; bool = false)
    {
      Assert.b(bool);
      this.b = paramClass;
      this.c = paramInt;
      return;
    }
  }

  private void a()
  {
    Intent localIntent = new Intent(this, this.b);
    localIntent.putExtras(getIntent().getExtras());
    localIntent.putExtra("calling_package_key", this.d);
    ((SecureContextHelper)this.e.a(SecureContextHelper.class)).a(localIntent, this.c, this);
  }

  private void a(Bundle paramBundle)
  {
    if (paramBundle == null);
    for (this.d = getCallingPackage(); ; this.d = paramBundle.getString("calling_package_key"))
      return;
  }

  private void b()
  {
    Intent localIntent = new Intent(this, FB4ASplashScreenActivity.class);
    localIntent.putExtra("should_start_return_intent", false);
    startActivityForResult(localIntent, 10);
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 10)
      if (paramInt2 == 0)
      {
        setResult(paramInt2, paramIntent);
        finish();
      }
    while (true)
    {
      return;
      a();
      continue;
      if (paramInt1 != this.c)
        continue;
      setResult(paramInt2, paramIntent);
      finish();
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.e = FbInjector.a(this);
    AppInitLock localAppInitLock = (AppInitLock)this.e.a(AppInitLock.class);
    a(paramBundle);
    if (localAppInitLock.c())
      a();
    while (true)
    {
      return;
      b();
    }
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("calling_package_key", this.d);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.PlatformLauncherActivity
 * JD-Core Version:    0.6.0
 */