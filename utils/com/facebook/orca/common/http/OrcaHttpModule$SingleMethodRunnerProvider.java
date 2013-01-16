package com.facebook.orca.common.http;

import com.facebook.annotations.ContextAwareAuthTokenString;
import com.facebook.orca.annotations.IsPhpProfilingEnabled;
import com.facebook.orca.annotations.IsTeakProfilingEnabled;
import com.facebook.orca.annotations.IsWirehogProfilingEnabled;
import com.facebook.orca.annotations.MeUserId;
import com.facebook.orca.annotations.ProductionPlatformAppHttpConfig;
import com.facebook.orca.config.PlatformAppConfig;
import com.facebook.orca.config.PlatformAppHttpConfig;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.base.ApiRequestUtils;
import com.facebook.orca.protocol.base.ApiResponseChecker;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

class OrcaHttpModule$SingleMethodRunnerProvider extends AbstractProvider<SingleMethodRunner>
{
  private OrcaHttpModule$SingleMethodRunnerProvider(OrcaHttpModule paramOrcaHttpModule)
  {
  }

  public SingleMethodRunner a()
  {
    return new SingleMethodRunner(a(PlatformAppHttpConfig.class), (PlatformAppHttpConfig)b(PlatformAppHttpConfig.class, ProductionPlatformAppHttpConfig.class), (OrcaHttpRequestProcessor)b(OrcaHttpRequestProcessor.class), a(String.class, MeUserId.class), a(String.class, ContextAwareAuthTokenString.class), a(Boolean.class, IsPhpProfilingEnabled.class), a(Boolean.class, IsTeakProfilingEnabled.class), a(Boolean.class, IsWirehogProfilingEnabled.class), (PlatformAppConfig)b(PlatformAppConfig.class), (JsonFactory)b(JsonFactory.class), (ObjectMapper)b(ObjectMapper.class), (ApiResponseChecker)b(ApiResponseChecker.class), (ApiRequestUtils)b(ApiRequestUtils.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.http.OrcaHttpModule.SingleMethodRunnerProvider
 * JD-Core Version:    0.6.2
 */