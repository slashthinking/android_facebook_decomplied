package com.facebook.orca.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.fragment.NavigableFragment;
import com.facebook.fragment.NavigableFragment.Listener;
import com.facebook.fragment.NavigableFragmentController.FragmentActionBuilder;
import com.facebook.orca.common.util.ExceptionUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;

public class OrcaNavigableFragment extends OrcaFragment
  implements NavigableFragment
{
  private static final Class<?> b = OrcaNavigableFragment.class;
  protected NavigableFragment.Listener a;
  private Intent c;
  private String d;
  private FbErrorReporter e;
  private boolean f = false;

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.d = ExceptionUtil.a(new Throwable());
    this.e = ((FbErrorReporter)Q().a(FbErrorReporter.class));
  }

  public void a(NavigableFragment.Listener paramListener)
  {
    this.a = paramListener;
    if ((paramListener != null) && (this.c != null))
    {
      String str = getClass().getName() + ": Saved intent found: " + this.c;
      BLog.e(b, str, new Throwable());
      this.e.a("FRAGMENT_NAVIGATION", str);
      new Handler().post(new OrcaNavigableFragment.1(this, paramListener));
    }
  }

  protected void a(Class<? extends OrcaNavigableFragment> paramClass)
  {
    b(new NavigableFragmentController.FragmentActionBuilder(paramClass).c());
  }

  protected void b(Intent paramIntent)
  {
    if (b())
    {
      String str2 = getClass().getName() + ": Fragment already finished";
      if (this.c != null)
        str2 = str2 + " with saved intent: " + this.c;
      BLog.e(b, str2);
      this.e.a("FRAGMENT_NAVIGATION", str2);
      return;
    }
    if (this.a == null)
    {
      String str1 = getClass().getName() + ": No navigation listener set; saving intent." + "  Created at:\n" + this.d;
      BLog.e(b, str1, new Throwable());
      this.e.a("FRAGMENT_NAVIGATION", str1);
      this.c = paramIntent;
    }
    while (true)
    {
      this.f = true;
      break;
      this.a.a(this, paramIntent);
    }
  }

  public boolean b()
  {
    return this.f;
  }

  protected boolean c()
  {
    FragmentManager localFragmentManager = r();
    if (localFragmentManager.f() == 0);
    for (boolean bool = false; ; bool = true)
    {
      return bool;
      localFragmentManager.d();
    }
  }

  public void h()
  {
    super.h();
    this.f = false;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.activity.OrcaNavigableFragment
 * JD-Core Version:    0.6.2
 */