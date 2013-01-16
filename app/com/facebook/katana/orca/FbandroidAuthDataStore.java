package com.facebook.katana.orca;

import android.content.Context;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.common.util.TriState;
import com.facebook.ipc.katana.model.FacebookUser;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSession.LoginStatus;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.provider.UserValuesManager;
import com.facebook.orca.auth.FacebookCredentials;
import com.facebook.orca.auth.MeUserAuthDataStore;
import com.facebook.orca.users.User;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserBuilder;
import java.util.List;

public class FbandroidAuthDataStore
  implements MeUserAuthDataStore
{
  private final Context a;
  private final FbErrorReporter b;
  private User c;

  public FbandroidAuthDataStore(Context paramContext, FbErrorReporter paramFbErrorReporter)
  {
    this.a = paramContext;
    this.b = paramFbErrorReporter;
  }

  public void a()
  {
    throw new RuntimeException("Should not be called from within FB4A");
  }

  public void a(FacebookCredentials paramFacebookCredentials, boolean paramBoolean)
  {
    throw new RuntimeException("Should not be called from within fbandroid");
  }

  public void a(User paramUser)
  {
    throw new RuntimeException("Should never be called in fbandroid");
  }

  public void b()
  {
    throw new RuntimeException("Should not be called from within FB4A");
  }

  public void b(User paramUser)
  {
    if (this.c != null)
    {
      UserBuilder localUserBuilder = new UserBuilder().a(paramUser);
      if (localUserBuilder.o() == TriState.UNSET)
        localUserBuilder.a(this.c.w());
      if (localUserBuilder.c().isEmpty())
        localUserBuilder.a(this.c.i());
      if (localUserBuilder.d().isEmpty())
        localUserBuilder.b(this.c.j());
      localUserBuilder.a(this.c.x());
      this.c = localUserBuilder.w();
    }
  }

  public FacebookCredentials c()
  {
    monitorenter;
    try
    {
      AppSession localAppSession = AppSession.b(this.a, true);
      if (localAppSession != null)
      {
        AppSession.LoginStatus localLoginStatus1 = localAppSession.i();
        AppSession.LoginStatus localLoginStatus2 = AppSession.LoginStatus.STATUS_LOGGED_IN;
        if (localLoginStatus1 == localLoginStatus2)
          break label39;
      }
      label39: for (FacebookCredentials localFacebookCredentials = null; ; localFacebookCredentials = new FacebookCredentials(localAppSession.b().oAuthToken, 0L))
        return localFacebookCredentials;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public boolean d()
  {
    if ((e()) && (g() != null));
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean e()
  {
    if (c() != null);
    for (int i = 1; ; i = 0)
      return i;
  }

  public void f()
  {
    this.c = null;
  }

  public User g()
  {
    AppSession localAppSession = AppSession.b(this.a, false);
    User localUser = null;
    if (localAppSession != null)
    {
      AppSession.LoginStatus localLoginStatus1 = localAppSession.i();
      AppSession.LoginStatus localLoginStatus2 = AppSession.LoginStatus.STATUS_LOGGED_IN;
      localUser = null;
      if (localLoginStatus1 == localLoginStatus2)
        break label35;
    }
    while (true)
    {
      return localUser;
      label35: if (localAppSession.b().a() == null)
      {
        String str = UserValuesManager.d(this.a);
        this.b.a("GetMeUserNullProfile", str, true);
        localUser = null;
        continue;
      }
      localUser = new UserBuilder().a(User.Type.FACEBOOK, String.valueOf(localAppSession.b().a().mUserId)).a(localAppSession.b().a().mDisplayName).w();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidAuthDataStore
 * JD-Core Version:    0.6.0
 */