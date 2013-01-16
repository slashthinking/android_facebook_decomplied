package com.facebook.feed.ui.permalink;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

class PermalinkAdapter$MoreCommentsViewHolder
{
  ImageView a;
  ProgressBar b;
  TextView c;
  View d;

  public PermalinkAdapter$MoreCommentsViewHolder(View paramView)
  {
    this.a = ((ImageView)paramView.findViewById(2131296731));
    this.b = ((ProgressBar)paramView.findViewById(2131296732));
    this.c = ((TextView)paramView.findViewById(2131296733));
    this.d = paramView.findViewById(2131296729);
  }

  public void a()
  {
    this.a.setVisibility(4);
    this.b.setVisibility(0);
    this.c.setText(2131362087);
  }

  public void b()
  {
    this.a.setVisibility(0);
    this.b.setVisibility(4);
    this.c.setText(2131362086);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.permalink.PermalinkAdapter.MoreCommentsViewHolder
 * JD-Core Version:    0.6.0
 */