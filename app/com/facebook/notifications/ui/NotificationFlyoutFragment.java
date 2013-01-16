package com.facebook.notifications.ui;

import android.content.Context;
import android.graphics.Point;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.facebook.feed.renderer.IFeedUnitRenderer;
import com.facebook.graphql.model.FeedStory;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.flyout.FlyoutFragment;
import com.facebook.widget.flyout.IFlyoutInterface;

public class NotificationFlyoutFragment extends FlyoutFragment
  implements IFlyoutInterface
{
  private FeedStory b;

  public static void a(Context paramContext, FeedStory paramFeedStory, View paramView)
  {
    if (!(paramContext instanceof FragmentActivity));
    while (true)
    {
      return;
      NotificationFlyoutFragment localNotificationFlyoutFragment = new NotificationFlyoutFragment();
      localNotificationFlyoutFragment.a(paramFeedStory);
      if (paramView != null)
      {
        int[] arrayOfInt = new int[2];
        paramView.getLocationInWindow(arrayOfInt);
        arrayOfInt[0] += paramView.getWidth() / 2;
        arrayOfInt[1] += paramView.getHeight() / 2;
        localNotificationFlyoutFragment.a(new Point(arrayOfInt[0], arrayOfInt[1]));
      }
      localNotificationFlyoutFragment.a((FragmentActivity)paramContext);
    }
  }

  private void a(FeedStory paramFeedStory)
  {
    this.b = paramFeedStory;
  }

  protected void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    ((ListView)paramLayoutInflater.inflate(2130903219, paramViewGroup).findViewById(16908298)).setAdapter(new NotificationStoryAdapter(this.b, (IFeedUnitRenderer)R().a(IFeedUnitRenderer.class)));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.notifications.ui.NotificationFlyoutFragment
 * JD-Core Version:    0.6.0
 */