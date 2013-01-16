package com.facebook.katana.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.common.util.ErrorReporting;
import com.facebook.orca.activity.FbActivityListener;
import com.facebook.orca.activity.FbFragmentActivity;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpec;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.flyout.IFlyoutInterface;
import com.facebook.widget.menu.CustomMenuActivity;
import com.facebook.widget.menu.CustomMenuHandler;
import java.util.Iterator;
import java.util.Set;

public class BaseFacebookActivity extends FbFragmentActivity
  implements BookmarksMenuHost, FacebookActivity, CustomMenuHandler
{
  private FacebookActivityDelegate n;
  protected PerformanceLogger w;

  protected static Fragment a(FragmentManager paramFragmentManager, String paramString)
  {
    Fragment localFragment = paramFragmentManager.a(paramString);
    if ((localFragment != null) && (localFragment.v()));
    while (true)
    {
      return localFragment;
      localFragment = null;
    }
  }

  private void i()
  {
    Iterator localIterator = D().iterator();
    while (localIterator.hasNext())
    {
      FbActivityListener localFbActivityListener = (FbActivityListener)localIterator.next();
      if (!(localFbActivityListener instanceof FacebookActivityDelegate))
        continue;
      this.n = ((FacebookActivityDelegate)localFbActivityListener);
      return;
    }
    throw new RuntimeException("Unable to find a FbActivityListener of type FacebookActivityDelegate");
  }

  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    t().a(paramInt1, paramInt2, paramInt3);
  }

  public void a(int paramInt1, String paramString, int paramInt2)
  {
    t().a(paramInt1, paramString, paramInt2);
  }

  public void a(Uri paramUri, Bundle paramBundle, Integer paramInteger, int paramInt, long paramLong)
  {
    t().a(paramUri, paramBundle, paramInteger, paramInt, paramLong);
  }

  public void a(Uri paramUri, Bundle paramBundle, Integer paramInteger, long paramLong)
  {
    t().a(paramUri, paramBundle, paramInteger, 0, paramLong);
  }

  public void a(Bundle paramBundle, Integer paramInteger)
  {
    t().a(paramBundle, paramInteger);
  }

  public void a(TitleBarButtonSpec paramTitleBarButtonSpec)
  {
    t().a(paramTitleBarButtonSpec);
  }

  public void a(CustomMenuActivity paramCustomMenuActivity)
  {
    t().a(paramCustomMenuActivity);
  }

  protected void a_(Bundle paramBundle)
  {
    super.a_(paramBundle);
    this.w = ((PerformanceLogger)C().a(PerformanceLogger.class));
  }

  public void b(int paramInt, boolean paramBoolean)
  {
    t().a(paramInt, paramBoolean);
  }

  public final void b(boolean paramBoolean)
  {
    t().b(paramBoolean);
  }

  public void d(int paramInt)
  {
    t().d(paramInt);
  }

  public FacebookActivityDelegate t()
  {
    monitorenter;
    try
    {
      if (this.n == null)
        i();
      FacebookActivityDelegate localFacebookActivityDelegate = this.n;
      monitorexit;
      return localFacebookActivityDelegate;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void titleBarPrimaryActionClickHandler(View paramView)
  {
    ErrorReporting.a(getClass().getName(), "Either override titleBarPrimaryActionClickHandler or call FBAD.setPrimaryClickHandler for theclick handling.", true);
  }

  public boolean u()
  {
    return t().e();
  }

  protected void v()
  {
    t().h();
  }

  protected void w()
  {
    t().i();
  }

  public String x()
  {
    return t().j();
  }

  protected boolean y()
  {
    Fragment localFragment = a(g(), "chromeless:content:fragment:tag");
    if ((localFragment instanceof IFlyoutInterface))
      ((IFlyoutInterface)localFragment).a();
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.BaseFacebookActivity
 * JD-Core Version:    0.6.0
 */