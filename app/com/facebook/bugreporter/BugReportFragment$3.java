package com.facebook.bugreporter;

import android.content.Intent;
import android.net.Uri;
import com.facebook.orca.common.ui.widgets.text.CustomUrlLikeSpan.OnUrlClickHandler;

class BugReportFragment$3 extends CustomUrlLikeSpan.OnUrlClickHandler
{
  public void a()
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("http://m.facebook.com/about/privacy"));
    this.a.a(localIntent);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.bugreporter.BugReportFragment.3
 * JD-Core Version:    0.6.0
 */