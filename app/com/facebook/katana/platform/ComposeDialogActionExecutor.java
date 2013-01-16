package com.facebook.katana.platform;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.provider.ConnectionsProviderInjectable;
import com.facebook.orca.creation.CreateThreadActivity;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.users.User;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserBuilder;
import com.facebook.orca.users.UserWithIdentifier;
import java.util.ArrayList;

public class ComposeDialogActionExecutor extends AbstractPlatformActionExecutor
{
  private static final Class<?> a = ComposeDialogActionExecutor.class;
  private final Activity b;
  private AbstractPlatformActionExecutor.CompletionCallback c;
  private final String d;
  private final String e;
  private final ConnectionsProviderInjectable f;

  public ComposeDialogActionExecutor(Activity paramActivity, ConnectionsProviderInjectable paramConnectionsProviderInjectable, PlatformActivityComposeDialogRequest paramPlatformActivityComposeDialogRequest)
  {
    this.b = paramActivity;
    this.f = paramConnectionsProviderInjectable;
    ArrayList localArrayList = paramPlatformActivityComposeDialogRequest.b();
    if ((localArrayList != null) && (!localArrayList.isEmpty()));
    for (this.d = ((String)localArrayList.get(0)); ; this.d = null)
    {
      this.e = paramPlatformActivityComposeDialogRequest.c();
      return;
    }
  }

  public void D()
  {
  }

  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default:
    case 83:
    }
    while (true)
    {
      return;
      if (paramInt2 == 0)
      {
        this.c.c(AuthorizeAppResults.a("User canceled message"));
        continue;
      }
      BLog.b(a, "ComposeDialogAction returned a result! " + paramIntent);
      if (this.c == null)
        continue;
      this.c.b(new Bundle());
    }
  }

  public void a(Bundle paramBundle)
  {
    Context localContext = this.b.getApplicationContext();
    Intent localIntent = new Intent(localContext, CreateThreadActivity.class);
    try
    {
      Long localLong = Long.valueOf(Long.parseLong(this.d));
      localFacebookProfile = this.f.a(localContext, localLong.longValue());
      if (localFacebookProfile == null)
      {
        this.c.c(AuthorizeAppResults.a("ApplicationError", "The given user id (" + this.d + ") could not be found in the user's friends list"));
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (true)
      {
        FacebookProfile localFacebookProfile;
        this.c.c(AuthorizeAppResults.a("ProtocolError", "The given user id (" + this.d + ") could not be parsed"));
        continue;
        User localUser = new UserBuilder().a(User.Type.FACEBOOK, this.d).a(localFacebookProfile.mDisplayName).w();
        localIntent.putExtra("to", new UserWithIdentifier(localUser, localUser.h()));
        localIntent.putExtra("composer_initial_text", this.e);
        localIntent.putExtra("show_composer", true);
        localIntent.putExtra("disable_redirect_to_thread_view", true);
        this.b.startActivityForResult(localIntent, 83);
      }
    }
  }

  public void a(AbstractPlatformActionExecutor.CompletionCallback paramCompletionCallback)
  {
    this.c = paramCompletionCallback;
  }

  public void e(Bundle paramBundle)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.ComposeDialogActionExecutor
 * JD-Core Version:    0.6.0
 */