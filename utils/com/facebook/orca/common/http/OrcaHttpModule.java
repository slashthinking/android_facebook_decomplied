package com.facebook.orca.common.http;

import android.content.Context;
import android.net.http.AndroidHttpClient;
import com.facebook.common.util.NetAccessLogger;
import com.facebook.orca.annotations.IsPhpProfilingEnabled;
import com.facebook.orca.annotations.IsTeakProfilingEnabled;
import com.facebook.orca.annotations.IsWirehogProfilingEnabled;
import com.facebook.orca.annotations.SslSocketFactory;
import com.facebook.orca.config.NetworkConfig;
import com.facebook.orca.config.NetworkConfigUpdater;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;
import com.facebook.orca.protocol.base.ApiRequestUtils;
import com.facebook.orca.protocol.base.ApiResponseChecker;
import com.facebook.orca.protocol.base.BatchRunner;
import com.facebook.orca.protocol.base.ISingleMethodRunner;
import com.facebook.orca.protocol.base.IsPhpProfilingEnabledProvider;
import com.facebook.orca.protocol.base.IsTeakProfilingEnabledProvider;
import com.facebook.orca.protocol.base.IsWirehogProfilingEnabledProvider;
import com.facebook.orca.protocol.base.RealBatchRunner;
import com.facebook.orca.protocol.base.SimulatedBatchRunner;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.params.HttpParams;

public class OrcaHttpModule extends AbstractModule
{
  private final Context a;

  public OrcaHttpModule(Context paramContext)
  {
    this.a = paramContext;
  }

  private static SocketFactory b(Context paramContext, String paramString)
  {
    try
    {
      AndroidHttpClient localAndroidHttpClient = (AndroidHttpClient)AndroidHttpClient.class.getMethod("newInstance", new Class[] { String.class, Context.class }).invoke(null, new Object[] { paramString, paramContext });
      SocketFactory localSocketFactory = localAndroidHttpClient.getConnectionManager().getSchemeRegistry().get("https").getSocketFactory();
      localAndroidHttpClient.close();
      return localSocketFactory;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new RuntimeException(localNoSuchMethodException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new RuntimeException(localInvocationTargetException);
    }
  }

  private static SocketFactory b(String paramString)
  {
    AndroidHttpClient localAndroidHttpClient = AndroidHttpClient.newInstance(paramString);
    SocketFactory localSocketFactory = localAndroidHttpClient.getConnectionManager().getSchemeRegistry().get("https").getSocketFactory();
    localAndroidHttpClient.close();
    return localSocketFactory;
  }

  protected void a()
  {
    a(CookieStore.class).b(OrcaCookieStore.class);
    a(HttpClient.class).b(OrcaHttpClient.class);
    a(OrcaHttpClient.class).a(new OrcaHttpModule.OrcaHttpClientProvider(this, null)).a();
    a(OrcaHttpRequestProcessor.class).a(new OrcaHttpModule.OrcaHttpRequestProcessorProvider(this, null)).a();
    a(OrcaCookieStore.class).a(new OrcaHttpModule.OrcaCookieStoreProvider(this, null)).a();
    a(ClientConnectionManager.class).a(new OrcaHttpModule.ClientConnectionManagerProvider(this, null));
    a(HttpParams.class).a(new OrcaHttpModule.HttpParamsProvider(this, null));
    a(SocketFactory.class).a(SslSocketFactory.class).a(new OrcaHttpModule.SslSocketFactoryProvider(this, null));
    a(NetworkConfig.class).a(new OrcaHttpModule.DefaultNetworkConfigProvider(null)).a();
    a(NetworkConfigUpdater.class).a(new OrcaHttpModule.NetworkConfigUpdaterProvider(this, null)).d();
    a(ApiRequestUtils.class).a(new OrcaHttpModule.ApiRequestUtilsProvider(this, null)).a();
    a(OrcaHttpDebugProcessorHook.class).a(new OrcaHttpModule.OrcaHttpDebugProcessorHookProvider(this, null)).a();
    a(NetAccessLogger.class).a(new OrcaHttpModule.NetAccessLoggerProvider(this, null)).a();
    a(ApiResponseChecker.class).a(new OrcaHttpModule.ApiResponseCheckerProvider(this, null)).a();
    a(RealBatchRunner.class).a(new OrcaHttpModule.RealBatchRunnerProvider(this, null));
    a(SimulatedBatchRunner.class).a(new OrcaHttpModule.SimulatedBatchRunnerProvider(this, null));
    a(SingleMethodRunner.class).a(new OrcaHttpModule.SingleMethodRunnerProvider(this, null));
    a(BatchRunner.class).b(RealBatchRunner.class);
    a(Boolean.class).a(IsPhpProfilingEnabled.class).c(IsPhpProfilingEnabledProvider.class);
    a(Boolean.class).a(IsTeakProfilingEnabled.class).c(IsTeakProfilingEnabledProvider.class);
    a(Boolean.class).a(IsWirehogProfilingEnabled.class).c(IsWirehogProfilingEnabledProvider.class);
    a(ISingleMethodRunner.class).b(SingleMethodRunner.class);
    c(OrcaHttpClientObserver.class);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.http.OrcaHttpModule
 * JD-Core Version:    0.6.2
 */