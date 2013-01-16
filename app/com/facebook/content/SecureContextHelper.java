package com.facebook.content;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v4.app.Fragment;
import com.facebook.common.util.FbErrorReporter;
import java.util.List;

public class SecureContextHelper
{
  private static final Class<?> a = SecureContextHelper.class;
  private final SecureContextHelperUtil b;
  private final FbErrorReporter c;

  public SecureContextHelper(SecureContextHelperUtil paramSecureContextHelperUtil, FbErrorReporter paramFbErrorReporter)
  {
    this.b = paramSecureContextHelperUtil;
    this.c = paramFbErrorReporter;
  }

  public void a(Intent paramIntent, int paramInt, Activity paramActivity)
  {
    a(paramIntent, paramInt, new SecureContextHelper.1(this, paramActivity));
  }

  public void a(Intent paramIntent, int paramInt, Fragment paramFragment)
  {
    a(paramIntent, paramInt, new SecureContextHelper.2(this, paramFragment));
  }

  public void a(Intent paramIntent, int paramInt, SecureContextHelper.ActivityWrapper paramActivityWrapper)
  {
    if (paramIntent.getComponent() != null)
      paramActivityWrapper.a(paramIntent, paramInt);
    while (true)
    {
      return;
      List localList = this.b.a(paramIntent, paramActivityWrapper.a());
      if (localList.isEmpty())
      {
        this.c.a(a.getName(), "no activities registered for the action: " + paramIntent.getAction());
        continue;
      }
      if (localList.size() > 1)
      {
        this.c.a(a.getName(), "multiple activities registered for intent. Multiple activities are not supported yet: " + paramIntent.getAction());
        continue;
      }
      ActivityInfo localActivityInfo = (ActivityInfo)localList.get(0);
      paramIntent.setComponent(new ComponentName(localActivityInfo.packageName, localActivityInfo.name));
      paramActivityWrapper.a(paramIntent, paramInt);
    }
  }

  public void a(Intent paramIntent, Context paramContext)
  {
    if (paramIntent.getComponent() != null)
      paramContext.startActivity(paramIntent);
    while (true)
    {
      return;
      List localList = this.b.a(paramIntent, paramContext);
      if (localList.isEmpty())
      {
        this.c.a(a.getName(), "no activities registered for the action: " + paramIntent.getAction());
        continue;
      }
      if (localList.size() > 1)
      {
        this.c.a(a.getName(), "multiple activities registered for intent. Multiple activities are not supported yet: " + paramIntent.getAction());
        continue;
      }
      ActivityInfo localActivityInfo = (ActivityInfo)localList.get(0);
      paramIntent.setComponent(new ComponentName(localActivityInfo.packageName, localActivityInfo.name));
      paramContext.startActivity(paramIntent);
    }
  }

  public void b(Intent paramIntent, int paramInt, Activity paramActivity)
  {
    paramActivity.startActivityForResult(paramIntent, paramInt);
  }

  public void b(Intent paramIntent, Context paramContext)
  {
    paramContext.startActivity(paramIntent);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.content.SecureContextHelper
 * JD-Core Version:    0.6.0
 */