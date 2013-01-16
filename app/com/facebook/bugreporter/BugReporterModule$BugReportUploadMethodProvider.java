package com.facebook.bugreporter;

import com.facebook.orca.inject.AbstractProvider;

class BugReporterModule$BugReportUploadMethodProvider extends AbstractProvider<BugReportUploadMethod>
{
  private BugReporterModule$BugReportUploadMethodProvider(BugReporterModule paramBugReporterModule)
  {
  }

  public BugReportUploadMethod a()
  {
    return new BugReportUploadMethod((BugReporterConfig)b(BugReporterConfig.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.bugreporter.BugReporterModule.BugReportUploadMethodProvider
 * JD-Core Version:    0.6.0
 */