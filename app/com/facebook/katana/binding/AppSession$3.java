package com.facebook.katana.binding;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.platform.FacebookAuthenticationService;
import com.facebook.katana.provider.FacebookDatabaseHelper;
import com.facebook.katana.service.FacebookService;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.login.AuthComponent;
import java.util.Iterator;
import java.util.Set;

class AppSession$3 extends AsyncTask<Void, Void, Void>
{
  protected Void a(Void[] paramArrayOfVoid)
  {
    Set localSet = AppSession.a(this.c, this.a).c(AuthComponent.class);
    if (localSet != null)
    {
      Iterator localIterator = localSet.iterator();
      while (localIterator.hasNext())
        ((AuthComponent)localIterator.next()).c();
    }
    AppSession.a(this.c, AppSession.LoginStatus.STATUS_LOGGING_OUT);
    FacebookDatabaseHelper.b(this.a);
    FacebookAuthenticationService.e(this.a, null);
    AppSession.b(this.c, this.a);
    return null;
  }

  protected void a(Void paramVoid)
  {
    String str = AppSession.m();
    Intent localIntent = new Intent(this.a, FacebookService.class);
    localIntent.putExtra("type", 2);
    localIntent.putExtra("rid", str);
    localIntent.putExtra("sid", AppSession.a(this.c));
    localIntent.putExtra("logout_reason", this.b.toString());
    if (this.c.c())
      localIntent.putExtra("session_key", AppSession.b(this.c).sessionKey);
    AppSession.a(this.c, this.a, str, localIntent);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.binding.AppSession.3
 * JD-Core Version:    0.6.0
 */