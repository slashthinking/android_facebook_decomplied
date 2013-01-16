package com.facebook.feed.ui.footer;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.feed.renderer.FeedUnitViewStyle;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.inject.FbInjector;

class FeedbackActionButtonBar$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (FeedbackActionButtonBar.a(this.b) == null)
    {
      FeedbackActionButtonBar.a(this.b, FeedbackActionButtonBar.c(this.b).b(FeedbackActionButtonBar.b(this.b)));
      String str = FeedbackActionButtonBar.a(this.b, this.a);
      if (!StringUtil.a(str))
        FeedbackActionButtonBar.a(this.b).putExtra("nectar_module", str);
    }
    ((SecureContextHelper)FeedbackActionButtonBar.d(this.b).a(SecureContextHelper.class)).a(FeedbackActionButtonBar.a(this.b), 1756, (Activity)this.b.getContext());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.footer.FeedbackActionButtonBar.1
 * JD-Core Version:    0.6.0
 */