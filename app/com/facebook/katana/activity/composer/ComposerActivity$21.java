package com.facebook.katana.activity.composer;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.composer.model.SharePreview;

class ComposerActivity$21
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (this.a != null)
      this.c.startActivity(this.a);
    while (true)
    {
      return;
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setData(Uri.parse(this.b.e));
      this.c.startActivity(localIntent);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.ComposerActivity.21
 * JD-Core Version:    0.6.0
 */