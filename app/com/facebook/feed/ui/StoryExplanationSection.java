package com.facebook.feed.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.feed.util.FeedUtils;
import com.facebook.widget.CustomLinearLayout;

public class StoryExplanationSection extends CustomLinearLayout
  implements DepthAwareView
{
  private final Context a;
  private final View b;

  public StoryExplanationSection(Context paramContext)
  {
    this(paramContext, null);
  }

  public StoryExplanationSection(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    setContentView(2130903171);
    this.b = b(2131296786);
  }

  public void a(int paramInt)
  {
    FeedUtils.a(this.a, this, paramInt, 0);
  }

  public View getMenuButtonView()
  {
    return this.b;
  }

  public void setMenuButtonVisibility(boolean paramBoolean)
  {
    View localView = this.b;
    if (paramBoolean);
    for (int i = 0; ; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.StoryExplanationSection
 * JD-Core Version:    0.6.0
 */