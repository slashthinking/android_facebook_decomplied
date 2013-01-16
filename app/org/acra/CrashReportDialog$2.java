package org.acra;

import android.view.View;
import android.view.View.OnClickListener;

class CrashReportDialog$2
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    ErrorReporter.getInstance().deletePendingReports();
    this.this$0.finish();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     org.acra.CrashReportDialog.2
 * JD-Core Version:    0.6.0
 */