package com.facebook.bugreporter;

import android.content.res.Resources;
import com.facebook.orca.annotations.DefaultExecutorService;
import com.facebook.orca.annotations.ForUiThread;
import com.facebook.orca.inject.AbstractProvider;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Executor;

class BugReporterModule$BugReporterProvider extends AbstractProvider<BugReporter>
{
  private BugReporterModule$BugReporterProvider(BugReporterModule paramBugReporterModule)
  {
  }

  public BugReporter a()
  {
    return new BugReporter((Resources)b(Resources.class), (ListeningExecutorService)b(ListeningExecutorService.class, DefaultExecutorService.class), (Executor)b(Executor.class, ForUiThread.class), (BugReporterFileUtil)b(BugReporterFileUtil.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.bugreporter.BugReporterModule.BugReporterProvider
 * JD-Core Version:    0.6.0
 */