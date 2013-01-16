package com.facebook.bugreporter;

import com.facebook.bugreporter.tasklist.TaskListModule;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;

public class BugReporterModule extends AbstractModule
{
  protected void a()
  {
    a(new TaskListModule());
    a(BugReportUploader.class).a(new BugReporterModule.BugReportUploadProvider(this, null));
    a(BugReportUploadMethod.class).a(new BugReporterModule.BugReportUploadMethodProvider(this, null));
    a(BugReporter.class).a(new BugReporterModule.BugReporterProvider(this, null)).a();
    a(BugReporterFileUtil.class).a(new BugReporterModule.BugReporterFileUtilProvider(this, null)).a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.bugreporter.BugReporterModule
 * JD-Core Version:    0.6.0
 */