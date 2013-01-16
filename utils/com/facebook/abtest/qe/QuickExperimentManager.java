package com.facebook.abtest.qe;

import com.facebook.abtest.qe.data.QuickExperimentInfo;
import com.facebook.abtest.qe.data.QuickExperimentInfoValidator;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.ListenableFuture;

public abstract interface QuickExperimentManager
{
  public abstract ImmutableSet<String> a();

  public abstract ListenableFuture<QuickExperimentInfo> a(String paramString, QuickExperimentInfoValidator paramQuickExperimentInfoValidator);
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.abtest.qe.QuickExperimentManager
 * JD-Core Version:    0.6.2
 */