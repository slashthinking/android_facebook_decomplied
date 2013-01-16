package com.facebook.orca.app;

import android.app.Activity;
import android.content.Intent;
import com.facebook.content.SecureContextHelper;
import com.facebook.orca.activity.AbstractFbActivityListener;
import com.facebook.orca.annotations.AppInitializationNotRequired;

public class AppInitializationActivityHelper extends AbstractFbActivityListener
{
  private final AppInitLock a;
  private final Class<? extends Activity> b;
  private final SecureContextHelper c;

  public AppInitializationActivityHelper(AppInitLock paramAppInitLock, SecureContextHelper paramSecureContextHelper, Class<? extends Activity> paramClass)
  {
    this.a = paramAppInitLock;
    this.b = paramClass;
    this.c = paramSecureContextHelper;
  }

  public void f(Activity paramActivity)
  {
    if (this.a.c());
    while (true)
    {
      return;
      if (paramActivity.getClass().getAnnotation(AppInitializationNotRequired.class) == null)
      {
        Intent localIntent1 = paramActivity.getIntent();
        Intent localIntent2 = new Intent(paramActivity, this.b);
        localIntent2.putExtra("return_intent", localIntent1);
        this.c.a(localIntent2, paramActivity);
        paramActivity.finish();
        continue;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.AppInitializationActivityHelper
 * JD-Core Version:    0.6.0
 */