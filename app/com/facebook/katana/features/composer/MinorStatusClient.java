package com.facebook.katana.features.composer;

import android.content.Context;
import android.os.Bundle;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.ManagedDataStore.Client;
import com.facebook.katana.binding.ManagedDataStore.DeserializeException;
import com.facebook.katana.binding.NetworkRequestCallback;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.server.protocol.FetchMinorStatusMethod.Params;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

class MinorStatusClient
  implements ManagedDataStore.Client<Object, Boolean>
{
  private ListenableFuture<OperationResult> a;

  public int a(Object paramObject, Boolean paramBoolean)
  {
    if (Boolean.FALSE.equals(paramBoolean));
    for (int i = 604800; ; i = 10800)
      return i;
  }

  public Boolean a(String paramString)
  {
    if ((!paramString.equals("true")) && (!paramString.equals("false")))
      throw new ManagedDataStore.DeserializeException(paramString, null);
    return Boolean.valueOf(paramString);
  }

  public int b(Object paramObject, Boolean paramBoolean)
  {
    return a(paramObject, paramBoolean);
  }

  public boolean c(Object paramObject, Boolean paramBoolean)
  {
    return false;
  }

  public String getDiskKeyPrefix()
  {
    return MinorStatus.class.getSimpleName();
  }

  public String getDiskKeySuffix(Object paramObject)
  {
    return "user_minor_status";
  }

  public void initiateNetworkRequest(Context paramContext, Object paramObject, NetworkRequestCallback<Object, Boolean> paramNetworkRequestCallback)
  {
    if (this.a != null);
    while (true)
    {
      return;
      AppSession localAppSession = AppSession.b(paramContext, false);
      if (localAppSession == null)
        continue;
      Context localContext = paramContext.getApplicationContext();
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("fetch_minor_status", new FetchMinorStatusMethod.Params(localAppSession.b().userId));
      this.a = ((OrcaServiceOperationFactory)FbInjector.a(paramContext).a(OrcaServiceOperationFactory.class)).a("fetch_minor_status", localBundle).d();
      Futures.a(this.a, new MinorStatusClient.1(this, paramNetworkRequestCallback, localContext, paramObject));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.composer.MinorStatusClient
 * JD-Core Version:    0.6.0
 */