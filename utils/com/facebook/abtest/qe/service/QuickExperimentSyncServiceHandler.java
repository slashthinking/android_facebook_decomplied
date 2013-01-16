package com.facebook.abtest.qe.service;

import android.os.Bundle;
import android.util.Pair;
import com.facebook.abtest.qe.QuickExperimentManager;
import com.facebook.abtest.qe.data.QuickExperimentConfigPrefKeys;
import com.facebook.abtest.qe.protocol.SyncQuickExperimentMethod;
import com.facebook.abtest.qe.protocol.SyncQuickExperimentParams;
import com.facebook.abtest.qe.protocol.SyncQuickExperimentResult;
import com.facebook.abtest.qe.utils.LocaleUtil;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.protocol.base.BatchOperation;
import com.facebook.orca.protocol.base.BatchOperation.Builder;
import com.facebook.orca.protocol.base.BatchRunner;
import com.facebook.orca.server.ErrorCode;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import com.google.common.collect.ImmutableSet;
import java.util.Iterator;
import javax.inject.Provider;

public class QuickExperimentSyncServiceHandler
  implements OrcaServiceHandler
{
  private final Provider<BatchRunner> a;
  private final Provider<String> b;
  private final LocaleUtil c;
  private final OrcaSharedPreferences d;
  private final SyncQuickExperimentMethod e;
  private final QuickExperimentManager f;

  public QuickExperimentSyncServiceHandler(Provider<BatchRunner> paramProvider, Provider<String> paramProvider1, LocaleUtil paramLocaleUtil, OrcaSharedPreferences paramOrcaSharedPreferences, SyncQuickExperimentMethod paramSyncQuickExperimentMethod, QuickExperimentManager paramQuickExperimentManager)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
    this.c = paramLocaleUtil;
    this.d = paramOrcaSharedPreferences;
    this.e = paramSyncQuickExperimentMethod;
    this.f = paramQuickExperimentManager;
  }

  private OperationResult b(OperationParams paramOperationParams)
  {
    BatchRunner localBatchRunner = (BatchRunner)this.a.b();
    if ((String)this.b.b() == null);
    Bundle localBundle1;
    Pair[] arrayOfPair;
    for (OperationResult localOperationResult = OperationResult.a(ErrorCode.OTHER, "No user ID available"); ; localOperationResult = OperationResult.a(localBundle1, arrayOfPair))
    {
      return localOperationResult;
      OrcaSharedPreferences.Editor localEditor = this.d.b();
      localEditor.a(QuickExperimentConfigPrefKeys.b, System.currentTimeMillis());
      localEditor.a(QuickExperimentConfigPrefKeys.c, this.c.a());
      localEditor.a();
      Iterator localIterator1 = this.f.a().iterator();
      while (localIterator1.hasNext())
      {
        String str2 = (String)localIterator1.next();
        SyncQuickExperimentParams localSyncQuickExperimentParams = new SyncQuickExperimentParams(str2, (String)this.b.b());
        localBatchRunner.a(BatchOperation.a(this.e, localSyncQuickExperimentParams).a("sync_" + str2).a());
      }
      localBatchRunner.b("handleGetQEs");
      localBundle1 = new Bundle();
      Bundle localBundle2 = new Bundle();
      Iterator localIterator2 = this.f.a().iterator();
      while (localIterator2.hasNext())
      {
        String str1 = (String)localIterator2.next();
        SyncQuickExperimentResult localSyncQuickExperimentResult = (SyncQuickExperimentResult)localBatchRunner.a("sync_" + str1);
        if (localSyncQuickExperimentResult != null)
        {
          localBundle1.putBoolean(str1, true);
          localBundle2.putParcelable(str1, localSyncQuickExperimentResult);
        }
      }
      arrayOfPair = new Pair[1];
      arrayOfPair[0] = Pair.create("sync", localBundle2);
    }
  }

  public OperationResult a(OperationParams paramOperationParams)
  {
    String str = paramOperationParams.a();
    if ("sync_qe".equals(str))
      return b(paramOperationParams);
    throw new IllegalArgumentException("Unknown operation type: " + str);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.abtest.qe.service.QuickExperimentSyncServiceHandler
 * JD-Core Version:    0.6.2
 */