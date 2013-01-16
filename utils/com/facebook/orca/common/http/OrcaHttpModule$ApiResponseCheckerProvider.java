package com.facebook.orca.common.http;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.base.ApiResponseChecker;
import com.fasterxml.jackson.databind.ObjectMapper;

class OrcaHttpModule$ApiResponseCheckerProvider extends AbstractProvider<ApiResponseChecker>
{
  private OrcaHttpModule$ApiResponseCheckerProvider(OrcaHttpModule paramOrcaHttpModule)
  {
  }

  public ApiResponseChecker a()
  {
    return new ApiResponseChecker((ObjectMapper)b(ObjectMapper.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.http.OrcaHttpModule.ApiResponseCheckerProvider
 * JD-Core Version:    0.6.2
 */