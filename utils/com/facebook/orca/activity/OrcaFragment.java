package com.facebook.orca.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NestedFragment;
import android.view.View;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.OrcaServiceFragment;

public class OrcaFragment extends NestedFragment
{
  public FbInjector Q()
  {
    return FbInjector.a(p());
  }

  protected <T extends View> T a(View paramView, int paramInt)
  {
    return paramView.findViewById(paramInt);
  }

  protected void a(String paramString, Fragment paramFragment)
  {
    FragmentTransaction localFragmentTransaction = r().a();
    localFragmentTransaction.a(paramFragment, paramString);
    localFragmentTransaction.a();
  }

  protected void a(Fragment[] paramArrayOfFragment)
  {
    FragmentTransaction localFragmentTransaction = K().a();
    int i = paramArrayOfFragment.length;
    for (int j = 0; j < i; j++)
    {
      Fragment localFragment = paramArrayOfFragment[j];
      if (localFragment != null)
        localFragmentTransaction.a(localFragment);
    }
    localFragmentTransaction.b();
  }

  protected OrcaServiceFragment b(String paramString)
  {
    OrcaServiceFragment localOrcaServiceFragment = (OrcaServiceFragment)r().a(paramString);
    if (localOrcaServiceFragment == null)
    {
      localOrcaServiceFragment = new OrcaServiceFragment();
      a(paramString, localOrcaServiceFragment);
    }
    return localOrcaServiceFragment;
  }

  protected <T extends View> T g(int paramInt)
  {
    return A().findViewById(paramInt);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.activity.OrcaFragment
 * JD-Core Version:    0.6.2
 */