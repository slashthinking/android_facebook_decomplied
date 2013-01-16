package com.facebook.bugreporter;

import android.content.Context;
import com.facebook.orca.annotations.DefaultExecutorService;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

class BugReporterModule$BugReporterFileUtilProvider extends AbstractProvider<BugReporterFileUtil>
{
  private BugReporterModule$BugReporterFileUtilProvider(BugReporterModule paramBugReporterModule)
  {
  }

  public BugReporterFileUtil a()
  {
    return new BugReporterFileUtil((Context)b(Context.class, FromApplication.class), (Executor)b(ExecutorService.class, DefaultExecutorService.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.bugreporter.BugReporterModule.BugReporterFileUtilProvider
 * JD-Core Version:    0.6.0
 */