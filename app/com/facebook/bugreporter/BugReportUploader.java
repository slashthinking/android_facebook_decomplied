package com.facebook.bugreporter;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat.Builder;
import com.facebook.base.BuildConstants;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableList;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

public class BugReportUploader
{
  private static final Class<?> a = BugReportUploader.class;
  private final Context b;
  private final SingleMethodRunner c;
  private final BugReportUploadMethod d;
  private final FbErrorReporter e;
  private final NotificationManager f;
  private final BugReporterFileUtil g;

  public BugReportUploader(Context paramContext, SingleMethodRunner paramSingleMethodRunner, BugReportUploadMethod paramBugReportUploadMethod, FbErrorReporter paramFbErrorReporter, NotificationManager paramNotificationManager, BugReporterFileUtil paramBugReporterFileUtil)
  {
    this.b = paramContext;
    this.c = paramSingleMethodRunner;
    this.d = paramBugReportUploadMethod;
    this.e = paramFbErrorReporter;
    this.f = paramNotificationManager;
    this.g = paramBugReporterFileUtil;
  }

  private String a(Uri paramUri)
  {
    Object localObject;
    if (paramUri == null)
      localObject = "";
    while (true)
    {
      return localObject;
      try
      {
        String str = Files.a(new File(new URI(paramUri.toString())), Charset.defaultCharset());
        localObject = str;
      }
      catch (URISyntaxException localURISyntaxException)
      {
        BLog.a("Invalid file", localURISyntaxException);
        localObject = "";
      }
      catch (IOException localIOException)
      {
        BLog.a("Failed to laod file", localIOException);
        localObject = "";
      }
    }
  }

  private void a(String paramString)
  {
    BLog.e(a, paramString);
    this.e.a(a.getSimpleName(), paramString, false);
  }

  public void a(BugReport paramBugReport)
  {
    ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
    localObjectNode.put("log", a(paramBugReport.c()));
    ImmutableList localImmutableList = ImmutableList.d();
    if (paramBugReport.d() != null)
      localImmutableList = ImmutableList.a(paramBugReport.d());
    BugReportUploadParams localBugReportUploadParams = new BugReportUploadParams(paramBugReport.b(), localImmutableList, localObjectNode.toString(), paramBugReport.f(), paramBugReport.g(), paramBugReport.h());
    try
    {
      boolean bool2 = ((Boolean)this.c.a(this.d, localBugReportUploadParams)).booleanValue();
      bool1 = bool2;
      if (bool1)
      {
        this.g.b(paramBugReport.a());
        return;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        a(StringLocaleUtil.b("Error running SingleMethodRunner: %s", new Object[] { localException }));
        boolean bool1 = false;
        continue;
        a("Failed to upload bug report.");
        Intent localIntent = new Intent(this.b, BugReportActivity.class);
        localIntent.putExtra("report", paramBugReport);
        localIntent.putExtra("retry", true);
        Context localContext = this.b;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = paramBugReport.b();
        String str = localContext.getString(2131362000, arrayOfObject);
        if (BuildConstants.a())
          str = StringLocaleUtil.a("%s - beta", new Object[] { str });
        Notification localNotification = new NotificationCompat.Builder(this.b).a(str).b(this.b.getString(2131362001)).a(17301642).b(true).c(this.b.getString(2131361999)).a(System.currentTimeMillis()).a(PendingIntent.getActivity(this.b, (int)System.currentTimeMillis(), localIntent, 268435456)).b();
        this.f.notify(50000, localNotification);
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.bugreporter.BugReportUploader
 * JD-Core Version:    0.6.0
 */