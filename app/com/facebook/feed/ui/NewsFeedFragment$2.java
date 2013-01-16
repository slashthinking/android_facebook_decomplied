package com.facebook.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.content.SecureContextHelper;
import com.facebook.ipc.composer.model.ComposerConstants;
import com.facebook.orca.inject.FbInjector;

class NewsFeedFragment$2
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    SecureContextHelper localSecureContextHelper = (SecureContextHelper)this.b.R().a(SecureContextHelper.class);
    if (this.a.getBooleanExtra(ComposerConstants.c, false))
      localSecureContextHelper.a(this.a, 1756, (Activity)this.b.p());
    while (true)
    {
      return;
      this.b.a(this.a);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.NewsFeedFragment.2
 * JD-Core Version:    0.6.0
 */