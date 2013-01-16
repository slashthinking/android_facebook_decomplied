package com.facebook.appcenter.workflow;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.widget.Toast;
import java.io.File;

class AppWorkflowManager$2
  implements AppDownloadController.IAppDownloadListener
{
  public void a(long paramLong, String paramString)
  {
    File localFile = AppWorkflowManager.b(this.a).b(paramString);
    if (localFile != null)
    {
      PackageInfo localPackageInfo = AppWorkflowManager.a(this.a).getPackageManager().getPackageArchiveInfo(localFile.getPath(), 4096);
      if (localPackageInfo != null)
      {
        String str = localPackageInfo.packageName;
        if (str != null)
          AppWorkflowManager.c(this.a).a(paramString, str);
      }
    }
    AppWorkflowManager.a(this.a, paramString);
  }

  public void a(String paramString)
  {
    this.a.b(paramString);
    Toast.makeText(AppWorkflowManager.a(this.a), AppWorkflowManager.a(this.a).getString(2131362054), 0).show();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.workflow.AppWorkflowManager.2
 * JD-Core Version:    0.6.0
 */