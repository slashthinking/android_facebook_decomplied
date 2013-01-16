package com.facebook.katana;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;

class HtmlAboutActivity$2
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.facebook.com/terms.php")));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.HtmlAboutActivity.2
 * JD-Core Version:    0.6.0
 */