package com.facebook.bugreporter;

import android.net.Uri;
import java.io.File;
import java.net.URI;
import java.util.concurrent.Callable;

class BugReportFragment$4
  implements Callable<Long>
{
  public Long a()
  {
    return Long.valueOf(new File(new URI(this.a.toString())).length());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.bugreporter.BugReportFragment.4
 * JD-Core Version:    0.6.0
 */