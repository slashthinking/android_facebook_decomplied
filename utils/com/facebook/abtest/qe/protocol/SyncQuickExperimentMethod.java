package com.facebook.abtest.qe.protocol;

import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class SyncQuickExperimentMethod
  implements ApiMethod<SyncQuickExperimentParams, SyncQuickExperimentResult>
{
  private static final Class<?> a = SyncQuickExperimentMethod.class;
  private final SyncQuickExperimentResultHelper b;

  public SyncQuickExperimentMethod(SyncQuickExperimentResultHelper paramSyncQuickExperimentResultHelper)
  {
    this.b = paramSyncQuickExperimentResultHelper;
  }

  public SyncQuickExperimentResult a(SyncQuickExperimentParams paramSyncQuickExperimentParams, ApiResponse paramApiResponse)
  {
    return this.b.a(paramApiResponse.c(), paramSyncQuickExperimentParams);
  }

  public ApiRequest a(SyncQuickExperimentParams paramSyncQuickExperimentParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    return new ApiRequest("syncQE", "GET", QuickExperimentApiMethodsHelper.a(paramSyncQuickExperimentParams), localArrayList, ApiResponseType.JSON);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.abtest.qe.protocol.SyncQuickExperimentMethod
 * JD-Core Version:    0.6.2
 */