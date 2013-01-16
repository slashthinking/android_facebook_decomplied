package com.facebook.katana.fragment;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.facebook.debug.Assert;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.orca.activity.FbFragment;
import com.facebook.orca.common.util.StringLocaleUtil;

public abstract class BaseFacebookFragment extends FbFragment
  implements FacebookFragment
{
  private String a;

  private static String j(int paramInt)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    return StringLocaleUtil.a("dialogFragment:tag:%s", arrayOfObject);
  }

  public BaseFacebookActivity P()
  {
    FragmentActivity localFragmentActivity = n();
    if ((localFragmentActivity instanceof BaseFacebookActivity));
    for (BaseFacebookActivity localBaseFacebookActivity = (BaseFacebookActivity)localFragmentActivity; ; localBaseFacebookActivity = null)
      return localBaseFacebookActivity;
  }

  public String Q()
  {
    BaseFacebookActivity localBaseFacebookActivity;
    if (this.a == null)
    {
      localBaseFacebookActivity = P();
      if (localBaseFacebookActivity == null)
        break label31;
    }
    label31: for (String str = localBaseFacebookActivity.x(); ; str = "NONE_FACEBOOK_ACTIVITY")
    {
      this.a = str;
      return this.a;
    }
  }

  public void a(int paramInt, Bundle paramBundle)
  {
    DialogFragment localDialogFragment = f(paramInt);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    Assert.a(StringLocaleUtil.a("Cannot create dialog for %s. Check onCreateDialogFragment(int) method", arrayOfObject), localDialogFragment);
    FragmentManager localFragmentManager = r();
    FragmentTransaction localFragmentTransaction = localFragmentManager.a();
    String str = j(paramInt);
    Fragment localFragment = localFragmentManager.a(str);
    if (localFragment != null)
      localFragmentTransaction.a(localFragment);
    localFragmentTransaction.a(4097);
    localDialogFragment.a(localFragmentTransaction, str, true);
  }

  public DialogFragment f(int paramInt)
  {
    return null;
  }

  public void g(int paramInt)
  {
    a(paramInt, null);
  }

  public void h(int paramInt)
  {
    FragmentManager localFragmentManager = r();
    if (localFragmentManager == null);
    while (true)
    {
      return;
      String str = j(paramInt);
      Fragment localFragment = localFragmentManager.a(str);
      if ((localFragment instanceof DialogFragment))
      {
        ((DialogFragment)localFragment).a();
        continue;
      }
      Assert.b("Expect a DialogFragment for tag: " + str, localFragment);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.fragment.BaseFacebookFragment
 * JD-Core Version:    0.6.0
 */