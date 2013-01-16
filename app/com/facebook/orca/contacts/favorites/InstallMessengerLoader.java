package com.facebook.orca.contacts.favorites;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.Tracer;
import com.facebook.orca.users.FacebookUserIterator;
import com.facebook.orca.users.User;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.io.IOException;
import javax.inject.Provider;

public class InstallMessengerLoader extends AsyncTaskLoader<InstallMessengerLoader.Result>
{
  private final Provider<FacebookUserIterator> f;
  private final MobileAppDataCache g;
  private InstallMessengerLoader.Result h;

  public InstallMessengerLoader(Context paramContext, Provider<FacebookUserIterator> paramProvider, MobileAppDataCache paramMobileAppDataCache)
  {
    super(paramContext);
    this.f = paramProvider;
    this.g = paramMobileAppDataCache;
  }

  private ImmutableList<User> w()
  {
    Tracer localTracer1 = Tracer.a("getFriendMobileAppData");
    ImmutableList.Builder localBuilder = ImmutableList.e();
    FacebookUserIterator localFacebookUserIterator = (FacebookUserIterator)this.f.b();
    localFacebookUserIterator.b();
    try
    {
      localTracer2 = Tracer.a("#fetch");
      while (true)
      {
        User localUser = localFacebookUserIterator.d();
        if (localUser == null)
          break;
        localBuilder.b(localUser);
      }
    }
    catch (IOException localIOException)
    {
      Tracer localTracer2;
      BLog.c("orca:FriendListsLoader", "Exception reading favorite users", localIOException);
      localFacebookUserIterator.e();
      while (true)
      {
        localTracer1.a();
        return localBuilder.b();
        localTracer2.a();
        localFacebookUserIterator.e();
      }
    }
    finally
    {
      localFacebookUserIterator.e();
    }
    throw localObject;
  }

  public InstallMessengerLoader.Result f()
  {
    BLog.b("orca:FriendListsLoader", "starting loadInBackground");
    InstallMessengerLoader.Result localResult = v();
    BLog.b("orca:FriendListsLoader", "loadInBackground. loadLocalData loaded");
    this.g.a(localResult.a());
    this.g.b(localResult.b());
    this.h = new InstallMessengerLoader.Result(localResult.a());
    BLog.b("orca:FriendListsLoader", "loadInBackground result=" + this.h.toString());
    return this.h;
  }

  protected void g()
  {
    super.g();
    BLog.b("orca:FriendListsLoader", "onStartLoading");
    if (this.h != null)
    {
      BLog.b("orca:FriendListsLoader", "Using cached result");
      b(this.h);
    }
    if (this.h == null)
    {
      BLog.b("orca:FriendListsLoader", "Forcing a load");
      o();
    }
  }

  protected void h()
  {
    super.h();
    BLog.b("orca:FriendListsLoader", "onStopLoading");
    b();
  }

  protected void i()
  {
    BLog.b("orca:FriendListsLoader", "onReset");
    h();
    this.h = null;
  }

  InstallMessengerLoader.Result v()
  {
    Tracer.b(3L);
    Tracer localTracer = Tracer.a("loadInBackground");
    ImmutableList localImmutableList = w();
    localTracer.a();
    Tracer.b("orca:FriendListsLoader");
    return new InstallMessengerLoader.Result(localImmutableList);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.favorites.InstallMessengerLoader
 * JD-Core Version:    0.6.0
 */