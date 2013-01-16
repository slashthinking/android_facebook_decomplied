package com.facebook.megaphone.module;

import com.facebook.megaphone.api.LogMegaphoneMethod;
import com.facebook.orca.inject.AbstractProvider;

class MegaphoneModule$LogMegaphoneMethodProvider extends AbstractProvider<LogMegaphoneMethod>
{
  private MegaphoneModule$LogMegaphoneMethodProvider(MegaphoneModule paramMegaphoneModule)
  {
  }

  public LogMegaphoneMethod a()
  {
    return new LogMegaphoneMethod();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.megaphone.module.MegaphoneModule.LogMegaphoneMethodProvider
 * JD-Core Version:    0.6.2
 */