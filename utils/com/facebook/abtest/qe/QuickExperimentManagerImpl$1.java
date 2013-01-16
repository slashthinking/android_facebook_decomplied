package com.facebook.abtest.qe;

import com.facebook.abtest.qe.data.QuickExperimentInfo;
import com.facebook.abtest.qe.data.QuickExperimentInfoValidator;
import java.util.concurrent.Callable;

class QuickExperimentManagerImpl$1
  implements Callable<QuickExperimentInfo>
{
  QuickExperimentManagerImpl$1(QuickExperimentManagerImpl paramQuickExperimentManagerImpl, String paramString, QuickExperimentInfoValidator paramQuickExperimentInfoValidator)
  {
  }

  public QuickExperimentInfo a()
  {
    return QuickExperimentManagerImpl.a(this.c, this.a, this.b);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.abtest.qe.QuickExperimentManagerImpl.1
 * JD-Core Version:    0.6.2
 */