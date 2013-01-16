package com.facebook.megaphone.logger;

import android.os.Bundle;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.graphql.model.MegaphoneStory;
import com.facebook.megaphone.api.LogMegaphoneMethod;
import com.facebook.megaphone.api.LogMegaphoneParams;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import javax.inject.Provider;

public class MegaphoneLogger
{
  private final Provider<OrcaServiceOperationFactory> a;
  private final FbErrorReporter b;
  private final LogMegaphoneMethod c;

  public MegaphoneLogger(LogMegaphoneMethod paramLogMegaphoneMethod, Provider<OrcaServiceOperationFactory> paramProvider, FbErrorReporter paramFbErrorReporter)
  {
    this.a = paramProvider;
    this.b = paramFbErrorReporter;
    this.c = paramLogMegaphoneMethod;
  }

  public void a(MegaphoneStory paramMegaphoneStory, String paramString)
  {
    LogMegaphoneParams localLogMegaphoneParams = new LogMegaphoneParams(paramMegaphoneStory.id, paramString);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("logMegaphoneParams", localLogMegaphoneParams);
    ((OrcaServiceOperationFactory)this.a.b()).a("log_megaphone", localBundle).d();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.megaphone.logger.MegaphoneLogger
 * JD-Core Version:    0.6.2
 */