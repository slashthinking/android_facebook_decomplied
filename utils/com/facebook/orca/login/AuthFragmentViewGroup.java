package com.facebook.orca.login;

import android.content.Context;
import android.os.Bundle;
import com.facebook.widget.CustomViewGroup;

public class AuthFragmentViewGroup<T extends AuthFragmentControlBase> extends CustomViewGroup
{
  protected final T control;

  public AuthFragmentViewGroup(Context paramContext, T paramT)
  {
    super(paramContext);
    this.control = paramT;
  }

  protected Bundle getArguments()
  {
    return this.control.L().b;
  }

  protected int getResource(String paramString, int paramInt)
  {
    Bundle localBundle = getArguments();
    int i = 0;
    if (localBundle != null)
      i = localBundle.getInt(paramString, paramInt);
    if (i == 0);
    while (true)
    {
      return paramInt;
      paramInt = i;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.login.AuthFragmentViewGroup
 * JD-Core Version:    0.6.2
 */