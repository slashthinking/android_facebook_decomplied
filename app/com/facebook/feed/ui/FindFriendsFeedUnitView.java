package com.facebook.feed.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.widget.CustomLinearLayout;

public class FindFriendsFeedUnitView extends CustomLinearLayout
{
  private final Context a;

  public FindFriendsFeedUnitView(Context paramContext)
  {
    this(paramContext, null);
  }

  public FindFriendsFeedUnitView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    setContentView(2130903172);
    findViewById(2131296789).setOnClickListener(new FindFriendsFeedUnitView.1(this));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.FindFriendsFeedUnitView
 * JD-Core Version:    0.6.0
 */