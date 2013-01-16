package com.facebook.bugreporter;

import android.widget.TextView;
import com.facebook.common.util.FileSizeUtil;
import com.google.common.util.concurrent.FutureCallback;

class BugReportFragment$5
  implements FutureCallback<Long>
{
  public void a(Long paramLong)
  {
    String str1 = BugReportFragment.c(this.a).a((int)paramLong.longValue());
    String str2 = this.a.a(2131361997, new Object[] { str1 });
    BugReportFragment.d(this.a).setText(str2);
  }

  public void a(Throwable paramThrowable)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.bugreporter.BugReportFragment.5
 * JD-Core Version:    0.6.0
 */