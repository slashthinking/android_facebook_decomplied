package com.facebook.feed.ui.footer;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.UfiEvents.CommentClickedEvent;

class FeedbackActionButtonBar$3
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    FeedbackActionButtonBar.f(this.a).a(new UfiEvents.CommentClickedEvent());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.footer.FeedbackActionButtonBar.3
 * JD-Core Version:    0.6.0
 */