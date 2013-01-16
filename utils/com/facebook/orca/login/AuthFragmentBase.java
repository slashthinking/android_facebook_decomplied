package com.facebook.orca.login;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.facebook.fragment.NavigableFragmentController.FragmentActionBuilder;
import com.facebook.orca.activity.OrcaNavigableFragment;
import java.lang.reflect.Constructor;

public abstract class AuthFragmentBase extends OrcaNavigableFragment
  implements AuthFragmentControlBase
{
  private AuthStateMachineConfig b;
  private Class c;

  private Class a()
  {
    if (this.c == null)
      this.c = L().a;
    return this.c;
  }

  public AuthFragmentConfig L()
  {
    return d().a(getClass());
  }

  protected void M()
  {
    b(new NavigableFragmentController.FragmentActionBuilder(FirstPartySsoFragment.class).b().c());
  }

  protected View a(Class<? extends AuthFragmentControlBase> paramClass, ViewGroup paramViewGroup)
  {
    StringBuilder localStringBuilder;
    try
    {
      Constructor localConstructor = a().getConstructor(new Class[] { Context.class, paramClass });
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = p();
      arrayOfObject[1] = this;
      View localView = (View)localConstructor.newInstance(arrayOfObject);
      localView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      return localView;
    }
    catch (Exception localException)
    {
      localStringBuilder = new StringBuilder().append("Unable to create ");
      if (this.c == null);
    }
    for (String str = this.c.getName(); ; str = "<unknown class>")
      throw new RuntimeException(str, localException);
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    String str;
    if (paramBundle != null)
      str = paramBundle.getString("viewClassName");
    try
    {
      this.c = Class.forName(str);
      return;
    }
    catch (Exception localException)
    {
      while (true)
        this.c = null;
    }
  }

  protected boolean c()
  {
    if (super.c());
    while (true)
    {
      return true;
      M();
    }
  }

  public AuthStateMachineConfig d()
  {
    if (this.b == null)
      this.b = ((AuthNavigationController)l()).a();
    return this.b;
  }

  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    if (this.c != null)
      paramBundle.putString("viewClassName", this.c.getCanonicalName());
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.login.AuthFragmentBase
 * JD-Core Version:    0.6.2
 */