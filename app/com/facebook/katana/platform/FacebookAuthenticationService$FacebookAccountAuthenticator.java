package com.facebook.katana.platform;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.katana.LoginActivity;

final class FacebookAuthenticationService$FacebookAccountAuthenticator extends AbstractAccountAuthenticator
{
  private final Context a;

  public FacebookAuthenticationService$FacebookAccountAuthenticator(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
  }

  public Bundle addAccount(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, String paramString1, String paramString2, String[] paramArrayOfString, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    Intent localIntent = new Intent(this.a, LoginActivity.class);
    localIntent.putExtra("add_account", true);
    localIntent.putExtra("accountAuthenticatorResponse", paramAccountAuthenticatorResponse);
    localBundle.putParcelable("intent", localIntent);
    return localBundle;
  }

  public Bundle confirmCredentials(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, Bundle paramBundle)
  {
    return null;
  }

  public Bundle editProperties(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, String paramString)
  {
    throw new UnsupportedOperationException();
  }

  public Bundle getAuthToken(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, String paramString, Bundle paramBundle)
  {
    return null;
  }

  public String getAuthTokenLabel(String paramString)
  {
    return this.a.getString(2131362037);
  }

  public Bundle hasFeatures(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, String[] paramArrayOfString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("booleanResult", false);
    return localBundle;
  }

  public Bundle updateCredentials(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, String paramString, Bundle paramBundle)
  {
    return null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.FacebookAuthenticationService.FacebookAccountAuthenticator
 * JD-Core Version:    0.6.0
 */