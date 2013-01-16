package com.facebook.zero;

import android.os.Bundle;
import com.facebook.background.AbstractBackgroundTask;
import com.facebook.background.BackgroundResult;
import com.facebook.common.util.TriState;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.zero.prefs.ZeroPrefKeys;
import com.facebook.zero.protocol.methods.ValidateZeroTokenMethod.Params;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Provider;

public class ZeroValidateTokenBackgroundTask extends AbstractBackgroundTask
{
  private static final Class<?> a = ZeroValidateTokenBackgroundTask.class;
  private final OrcaSharedPreferences b;
  private final Clock c;
  private final ZeroTokenManager d;
  private final OrcaServiceOperationFactory e;
  private final Provider<Boolean> f;

  public ZeroValidateTokenBackgroundTask(OrcaSharedPreferences paramOrcaSharedPreferences, OrcaServiceOperationFactory paramOrcaServiceOperationFactory, Clock paramClock, ZeroTokenManager paramZeroTokenManager, Provider<Boolean> paramProvider)
  {
    super("ZERO_TOKEN_VALIDATOR");
    this.b = paramOrcaSharedPreferences;
    this.e = paramOrcaServiceOperationFactory;
    this.c = paramClock;
    this.d = paramZeroTokenManager;
    this.f = paramProvider;
  }

  public boolean b()
  {
    boolean bool1 = ((Boolean)this.f.b()).booleanValue();
    boolean bool2 = false;
    if (!bool1);
    TriState localTriState1;
    TriState localTriState2;
    do
    {
      return bool2;
      localTriState1 = this.d.d();
      localTriState2 = TriState.YES;
      bool2 = false;
    }
    while (localTriState1 != localTriState2);
    long l = this.b.a(ZeroPrefKeys.c, 0L);
    if (this.c.a() - l > 43200000L);
    for (boolean bool3 = true; ; bool3 = false)
    {
      bool2 = bool3;
      break;
    }
  }

  public ListenableFuture<BackgroundResult> c()
  {
    this.b.b().a(ZeroPrefKeys.c, this.c.a()).a();
    ValidateZeroTokenMethod.Params localParams = new ValidateZeroTokenMethod.Params(this.d.b());
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("validateZeroTokenParams", localParams);
    ListenableFuture localListenableFuture = this.e.a("validate_zero_token", localBundle).d();
    ZeroValidateTokenBackgroundTask.BackgroundResultFutureCallback localBackgroundResultFutureCallback = new ZeroValidateTokenBackgroundTask.BackgroundResultFutureCallback(this.d);
    Futures.a(localListenableFuture, localBackgroundResultFutureCallback);
    return localBackgroundResultFutureCallback;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.zero.ZeroValidateTokenBackgroundTask
 * JD-Core Version:    0.6.2
 */