package com.facebook.orca.ops;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NestedFragment;
import com.facebook.orca.inject.FbInjector;

public class OrcaServiceFragment extends Fragment
{
  private OrcaServiceOperation a;
  private OrcaServiceOperation.OnCompletedListener b;
  private OrcaServiceOperation.OnProgressListener c;
  private OperationProgressIndicator d;
  private boolean e;
  private String f;
  private Bundle g;

  public static OrcaServiceFragment a(FragmentActivity paramFragmentActivity, String paramString)
  {
    return a(paramFragmentActivity.g(), paramString);
  }

  public static OrcaServiceFragment a(FragmentManager paramFragmentManager, String paramString)
  {
    OrcaServiceFragment localOrcaServiceFragment = (OrcaServiceFragment)paramFragmentManager.a(paramString);
    if (localOrcaServiceFragment == null)
    {
      localOrcaServiceFragment = new OrcaServiceFragment();
      FragmentTransaction localFragmentTransaction = paramFragmentManager.a();
      localFragmentTransaction.a(localOrcaServiceFragment, paramString);
      localFragmentTransaction.a();
    }
    return localOrcaServiceFragment;
  }

  public static OrcaServiceFragment a(NestedFragment paramNestedFragment, String paramString)
  {
    return a(paramNestedFragment.K(), paramString);
  }

  public void D()
  {
    super.D();
    this.a.a();
    this.b = null;
    this.c = null;
  }

  public void a(Context paramContext)
  {
    super.a(paramContext);
    this.a = ((OrcaServiceOperation)c().a(OrcaServiceOperation.class));
  }

  public void a(OperationProgressIndicator paramOperationProgressIndicator)
  {
    if (this.e)
      this.a.a(paramOperationProgressIndicator);
    while (true)
    {
      return;
      this.d = paramOperationProgressIndicator;
    }
  }

  public void a(OrcaServiceOperation.OnCompletedListener paramOnCompletedListener)
  {
    this.b = paramOnCompletedListener;
  }

  public void a(OrcaServiceOperation.OnProgressListener paramOnProgressListener)
  {
    this.c = paramOnProgressListener;
  }

  public void a(String paramString, Bundle paramBundle)
  {
    if (this.e)
      this.a.a(paramString, paramBundle);
    while (true)
    {
      return;
      this.f = paramString;
      this.g = paramBundle;
    }
  }

  public boolean a()
  {
    if ((this.e) && (this.a.b()));
    for (int i = 1; ; i = 0)
      return i;
  }

  public OrcaServiceOperation.State b()
  {
    return this.a.c();
  }

  public FbInjector c()
  {
    return FbInjector.a(p());
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.a.a(true);
    this.a.a(new OrcaServiceFragment.1(this));
    this.a.a(new OrcaServiceFragment.2(this));
    if ((paramBundle != null) && (this.f == null))
      this.a.b(paramBundle);
    this.a.a(this.d);
    this.d = null;
    this.e = true;
    if (this.f != null)
    {
      this.a.a(this.f, this.g);
      this.f = null;
      this.g = null;
    }
  }

  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    this.a.a(paramBundle);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.ops.OrcaServiceFragment
 * JD-Core Version:    0.6.0
 */