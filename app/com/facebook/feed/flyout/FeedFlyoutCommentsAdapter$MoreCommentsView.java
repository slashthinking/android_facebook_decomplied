package com.facebook.feed.flyout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.widget.CustomRelativeLayout;

class FeedFlyoutCommentsAdapter$MoreCommentsView extends CustomRelativeLayout
{
  private ImageView b;
  private ProgressBar c;
  private TextView d;

  public FeedFlyoutCommentsAdapter$MoreCommentsView(FeedFlyoutCommentsAdapter paramFeedFlyoutCommentsAdapter, Context paramContext)
  {
    this(paramFeedFlyoutCommentsAdapter, paramContext, null);
  }

  public FeedFlyoutCommentsAdapter$MoreCommentsView(FeedFlyoutCommentsAdapter paramFeedFlyoutCommentsAdapter, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setContentView(2130903218);
    this.b = ((ImageView)b(2131296944));
    this.c = ((ProgressBar)b(2131296945));
    this.d = ((TextView)b(2131296946));
  }

  public void a()
  {
    this.b.setVisibility(8);
    this.c.setVisibility(0);
    this.d.setText(2131362087);
  }

  public void b()
  {
    this.b.setVisibility(0);
    this.c.setVisibility(8);
    this.d.setText(2131362086);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.flyout.FeedFlyoutCommentsAdapter.MoreCommentsView
 * JD-Core Version:    0.6.0
 */