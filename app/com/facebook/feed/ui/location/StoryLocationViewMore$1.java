package com.facebook.feed.ui.location;

import android.graphics.Point;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.flyout.FlyoutAggrEntParams;
import com.facebook.feed.flyout.FlyoutAnimationHandler;
import java.util.List;

class StoryLocationViewMore$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    arrayOfInt[0] += paramView.getWidth() / 2;
    arrayOfInt[1] += paramView.getHeight() / 2;
    FlyoutAggrEntParams localFlyoutAggrEntParams = new FlyoutAggrEntParams(this.a);
    StoryLocationViewMore.a(this.b).a(paramView.getContext(), localFlyoutAggrEntParams, new Point(arrayOfInt[0], arrayOfInt[1]));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.location.StoryLocationViewMore.1
 * JD-Core Version:    0.6.0
 */