package com.facebook.katana.platform;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.facebook.katana.server.protocol.AuthorizeAppMethod.Params;
import com.facebook.katana.server.protocol.AuthorizeAppMethod.Params.Builder;
import com.facebook.orca.app.AppInitLockHelper;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

public class PlatformService extends Service
{
  private static final Class<?> a = PlatformService.class;
  private PlatformPackageUtilities b;
  private OrcaServiceOperationFactory c;

  private void a(String paramString, Message paramMessage)
  {
    PlatformServiceGetAccessTokenRequest localPlatformServiceGetAccessTokenRequest = new PlatformServiceGetAccessTokenRequest();
    if (!localPlatformServiceGetAccessTokenRequest.d(paramMessage))
      if (paramMessage.replyTo == null);
    while (true)
    {
      try
      {
        paramMessage.replyTo.send(localPlatformServiceGetAccessTokenRequest.c());
        return;
      }
      catch (RemoteException localRemoteException)
      {
        BLog.d(a, "Unable to send token refresh error reply", localRemoteException);
        continue;
      }
      BLog.d(a, "Error parsing token refresh message");
      continue;
      AuthorizeAppMethod.Params localParams = new AuthorizeAppMethod.Params.Builder(localPlatformServiceGetAccessTokenRequest.b(), paramString).a(true).a();
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("app_info", localParams);
      ListenableFuture localListenableFuture = this.c.a("platform_authorize_app", localBundle).d();
      if (paramMessage.replyTo == null)
        continue;
      Futures.a(localListenableFuture, new PlatformService.1(this, PlatformServiceGetAccessTokenRequest.b(paramMessage), paramMessage.replyTo));
    }
  }

  public IBinder onBind(Intent paramIntent)
  {
    return new Messenger(new PlatformService.MessageHandler(this)).getBinder();
  }

  public void onCreate()
  {
    super.onCreate();
    AppInitLockHelper.a(this);
    FbInjector localFbInjector = FbInjector.a(this);
    this.b = ((PlatformPackageUtilities)localFbInjector.a(PlatformPackageUtilities.class));
    this.c = ((OrcaServiceOperationFactory)localFbInjector.a(OrcaServiceOperationFactory.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.PlatformService
 * JD-Core Version:    0.6.0
 */