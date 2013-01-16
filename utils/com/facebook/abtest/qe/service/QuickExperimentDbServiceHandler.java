package com.facebook.abtest.qe.service;

import android.os.Bundle;
import com.facebook.abtest.qe.data.QuickExperimentInfo;
import com.facebook.abtest.qe.db.QuickExperimentStorage;
import com.facebook.abtest.qe.protocol.SyncQuickExperimentResult;
import com.facebook.abtest.qe.utils.LocaleUtil;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.OrcaServiceHandler.Filter;
import java.util.Iterator;
import java.util.Set;

public class QuickExperimentDbServiceHandler
  implements OrcaServiceHandler.Filter
{
  private final LocaleUtil a;
  private final QuickExperimentStorage b;

  public QuickExperimentDbServiceHandler(LocaleUtil paramLocaleUtil, QuickExperimentStorage paramQuickExperimentStorage)
  {
    this.a = paramLocaleUtil;
    this.b = paramQuickExperimentStorage;
  }

  private OperationResult b(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
    if (localOperationResult.c())
    {
      Bundle localBundle1 = (Bundle)localOperationResult.b("result");
      Bundle localBundle2 = (Bundle)localOperationResult.b("sync");
      String str = this.a.a();
      Iterator localIterator = localBundle1.keySet().iterator();
      while (localIterator.hasNext())
      {
        QuickExperimentInfo localQuickExperimentInfo = a((SyncQuickExperimentResult)localBundle2.get((String)localIterator.next()), str);
        if (localQuickExperimentInfo != null)
          this.b.a(localQuickExperimentInfo);
      }
    }
    return localOperationResult;
  }

  QuickExperimentInfo a(SyncQuickExperimentResult paramSyncQuickExperimentResult, String paramString)
  {
    if (paramSyncQuickExperimentResult == null);
    for (QuickExperimentInfo localQuickExperimentInfo = null; ; localQuickExperimentInfo = new QuickExperimentInfo(paramSyncQuickExperimentResult.a(), paramSyncQuickExperimentResult.b(), paramSyncQuickExperimentResult.c(), paramString, paramSyncQuickExperimentResult.d()))
      return localQuickExperimentInfo;
  }

  public OperationResult a(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    String str = paramOperationParams.a();
    if ("sync_qe".equals(str))
      return b(paramOperationParams, paramOrcaServiceHandler);
    throw new IllegalArgumentException("Unknown operation type: " + str);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.abtest.qe.service.QuickExperimentDbServiceHandler
 * JD-Core Version:    0.6.2
 */