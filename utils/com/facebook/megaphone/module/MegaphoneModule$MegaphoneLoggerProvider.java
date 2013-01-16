package com.facebook.megaphone.module;

import com.facebook.common.util.FbErrorReporter;
import com.facebook.megaphone.api.LogMegaphoneMethod;
import com.facebook.megaphone.logger.MegaphoneLogger;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperationFactory;

class MegaphoneModule$MegaphoneLoggerProvider extends AbstractProvider<MegaphoneLogger>
{
  private MegaphoneModule$MegaphoneLoggerProvider(MegaphoneModule paramMegaphoneModule)
  {
  }

  public MegaphoneLogger a()
  {
    return new MegaphoneLogger((LogMegaphoneMethod)b(LogMegaphoneMethod.class), a(OrcaServiceOperationFactory.class), (FbErrorReporter)b(FbErrorReporter.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.megaphone.module.MegaphoneModule.MegaphoneLoggerProvider
 * JD-Core Version:    0.6.2
 */