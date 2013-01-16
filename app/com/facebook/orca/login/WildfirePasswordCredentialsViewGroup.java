package com.facebook.orca.login;

import android.content.Context;
import android.content.Intent;

public class WildfirePasswordCredentialsViewGroup extends GenericPasswordCredentialsViewGroup
{
  public WildfirePasswordCredentialsViewGroup(Context paramContext, PasswordCredentialsFragmentControl paramPasswordCredentialsFragmentControl)
  {
    super(paramContext, paramPasswordCredentialsFragmentControl);
    setSignupButtonText(2131362346);
  }

  protected void onSignupClick()
  {
    Intent localIntent = new Intent("com.facebook.fragment.FRAGMENT_ACTION", null, getContext(), WildfireRegStartFragment.class);
    localIntent.putExtra("orca:authparam:redirectsignup", true);
    ((PasswordCredentialsFragmentControl)this.control).c(localIntent);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.login.WildfirePasswordCredentialsViewGroup
 * JD-Core Version:    0.6.0
 */