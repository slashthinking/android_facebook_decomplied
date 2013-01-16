package com.facebook.orca.common.http;

import com.facebook.orca.annotations.PhoneIsoCountryCode;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.base.ApiRequestUtils;
import java.util.Locale;

class OrcaHttpModule$ApiRequestUtilsProvider extends AbstractProvider<ApiRequestUtils>
{
  private OrcaHttpModule$ApiRequestUtilsProvider(OrcaHttpModule paramOrcaHttpModule)
  {
  }

  public ApiRequestUtils a()
  {
    return new ApiRequestUtils(a(Locale.class), a(String.class, PhoneIsoCountryCode.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.http.OrcaHttpModule.ApiRequestUtilsProvider
 * JD-Core Version:    0.6.2
 */