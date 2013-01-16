package com.facebook.feed.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.base.BuildConstants;
import com.facebook.feed.model.FeedRowType;
import com.facebook.megaphone.ui.MegaphoneStoryView;

public class FeedUnitViewFactory
{
  private final PerformanceLogger a;

  public FeedUnitViewFactory(PerformanceLogger paramPerformanceLogger)
  {
    this.a = paramPerformanceLogger;
  }

  private View a(ViewGroup paramViewGroup)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramViewGroup.getContext());
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
    return localLinearLayout;
  }

  private View b(LayoutInflater paramLayoutInflater, int paramInt, ViewGroup paramViewGroup)
  {
    FeedRowType localFeedRowType = FeedRowType.values()[paramInt];
    Object localObject;
    switch (FeedUnitViewFactory.1.a[localFeedRowType.ordinal()])
    {
    default:
      if (!BuildConstants.a())
        break;
      localObject = new UnknownFeedUnitView(paramViewGroup.getContext());
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    case 10:
    case 11:
    case 12:
    case 13:
    }
    while (true)
    {
      return localObject;
      localObject = paramLayoutInflater.inflate(2130903151, paramViewGroup, false);
      continue;
      localObject = paramLayoutInflater.inflate(2130903146, paramViewGroup, false);
      continue;
      localObject = paramLayoutInflater.inflate(2130903190, paramViewGroup, false);
      continue;
      localObject = paramLayoutInflater.inflate(2130903183, paramViewGroup, false);
      continue;
      localObject = new PeopleYouMayKnowFeedUnitView(paramViewGroup.getContext());
      continue;
      localObject = new PagesYouMayLikeFeedUnitView(paramViewGroup.getContext());
      continue;
      localObject = new CelebrationsFeedUnitView(paramViewGroup.getContext());
      continue;
      localObject = new FindFriendsFeedUnitView(paramViewGroup.getContext());
      continue;
      localObject = new RecommendedApplicationsFeedUnitView(paramViewGroup.getContext());
      continue;
      localObject = new FeedStoryView(paramViewGroup.getContext());
      continue;
      localObject = new FeedStoryView(paramViewGroup.getContext());
      ((FeedStoryView)localObject).b();
      ((FeedStoryView)localObject).d();
      continue;
      localObject = new FeedStoryView(paramViewGroup.getContext());
      ((FeedStoryView)localObject).b();
      ((FeedStoryView)localObject).c();
      continue;
      localObject = new MegaphoneStoryView(paramViewGroup.getContext());
      continue;
      localObject = a(paramViewGroup);
    }
  }

  public View a(LayoutInflater paramLayoutInflater, int paramInt, ViewGroup paramViewGroup)
  {
    this.a.a("NNFFeedUnitViewInflation");
    View localView = b(paramLayoutInflater, paramInt, paramViewGroup);
    this.a.b("NNFFeedUnitViewInflation");
    return localView;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.FeedUnitViewFactory
 * JD-Core Version:    0.6.0
 */