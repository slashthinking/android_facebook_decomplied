package com.facebook.fragment;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NestedFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.orca.debug.BLog;

public class NavigableFragmentController extends NestedFragment
  implements NavigableFragment
{
  private static final Class<?> a = NavigableFragmentController.class;
  private Fragment b;
  private final NavigableFragment.Listener c = new NavigableFragmentController.1(this);
  private NavigableFragment.Listener d;

  private void a(NavigableFragment paramNavigableFragment, Intent paramIntent)
  {
    if (paramNavigableFragment != null)
    {
      Class localClass = a;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramNavigableFragment.getClass().getName();
      arrayOfObject[1] = paramIntent;
      BLog.b(localClass, "Finished fragment '%s' with %s", arrayOfObject);
      if (K().c())
        break label62;
    }
    label174: 
    while (true)
    {
      return;
      BLog.b(a, "Starting Navigable Fragment Controller");
      break;
      label62: if ("com.facebook.fragment.FRAGMENT_ACTION".equals(paramIntent.getAction()))
      {
        String str = paramIntent.getComponent().getClassName();
        BLog.b(a, "Navigating to " + str);
        if (str != null)
        {
          Bundle localBundle = paramIntent.getExtras();
          boolean bool1;
          label125: boolean bool2;
          if (localBundle == null)
          {
            bool1 = false;
            bool2 = false;
            if (localBundle != null)
              break label174;
          }
          while (true)
          {
            paramIntent.removeExtra("com.facebook.fragment.PUSH_BACK_STACK");
            paramIntent.removeExtra("com.facebook.fragment.CLEAR_BACK_STACK");
            a(str, paramIntent.getExtras(), bool1, bool2);
            break;
            bool1 = localBundle.getBoolean("com.facebook.fragment.PUSH_BACK_STACK", false);
            break label125;
            bool2 = localBundle.getBoolean("com.facebook.fragment.CLEAR_BACK_STACK", false);
          }
        }
      }
      else
      {
        this.d.a(this, paramIntent);
      }
    }
  }

  private void a(String paramString, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    BLog.c(a, "Starting controlled fragment " + paramString);
    this.b = Fragment.a(p(), paramString, paramBundle);
    ((NavigableFragment)this.b).a(this.c);
    if (paramBoolean2)
      K().a(null, 1);
    FragmentTransaction localFragmentTransaction = K().a().b(2131297062, this.b);
    if (paramBoolean1)
      localFragmentTransaction.a(null);
    localFragmentTransaction.a();
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903272, paramViewGroup, false);
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (paramBundle != null)
      this.b = K().a(2131297062);
  }

  public void a(Fragment paramFragment)
  {
    super.a(paramFragment);
    if ((paramFragment instanceof NavigableFragment))
      ((NavigableFragment)paramFragment).a(this.c);
  }

  public void a(NavigableFragment.Listener paramListener)
  {
    this.d = paramListener;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.fragment.NavigableFragmentController
 * JD-Core Version:    0.6.2
 */