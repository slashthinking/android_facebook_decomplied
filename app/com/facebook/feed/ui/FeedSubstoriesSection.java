package com.facebook.feed.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.feed.renderer.recycle.FeedRecyclableViewPoolManager;
import com.facebook.graphql.model.FeedStory;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;

public class FeedSubstoriesSection extends CustomLinearLayout
{
  private final Context a;
  private final FeedRecyclableViewPoolManager b;

  public FeedSubstoriesSection(Context paramContext)
  {
    this(paramContext, null);
  }

  public FeedSubstoriesSection(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    this.b = ((FeedRecyclableViewPoolManager)getInjector().a(FeedRecyclableViewPoolManager.class));
  }

  private SubStoryView a(int paramInt1, int paramInt2)
  {
    View localView;
    SubStoryView localSubStoryView;
    if (paramInt1 < paramInt2)
    {
      localView = getChildAt(paramInt1);
      if (localView == null)
        break label29;
      localSubStoryView = (SubStoryView)localView;
    }
    while (true)
    {
      return localSubStoryView;
      localView = null;
      break;
      label29: localSubStoryView = (SubStoryView)this.b.a(SubStoryView.class);
      if (localSubStoryView == null)
      {
        localSubStoryView = new SubStoryView(this.a);
        addView(localSubStoryView);
        continue;
      }
      attachRecyclableViewToParent(localSubStoryView, getChildCount(), localSubStoryView.getLayoutParams());
    }
  }

  public void a(FeedStory paramFeedStory)
  {
    int i;
    if ((!paramFeedStory.F()) || (paramFeedStory.s() >= 2))
    {
      setVisibility(8);
      i = 0;
    }
    while (true)
    {
      for (int j = -1 + getChildCount(); j >= i; j--)
        ((SubStoryView)getChildAt(j)).c();
      List localList = paramFeedStory.substories;
      int k = getChildCount();
      i = 0;
      if (i < localList.size())
      {
        FeedStory localFeedStory = (FeedStory)localList.get(i);
        SubStoryView localSubStoryView = a(i, k);
        if (i == -1 + localList.size());
        for (boolean bool = true; ; bool = false)
        {
          localSubStoryView.a(localFeedStory, bool);
          localSubStoryView.setVisibility(0);
          i++;
          break;
        }
      }
      setVisibility(0);
    }
  }

  protected List<SubStoryView> getSubstoryViews()
  {
    int i = getChildCount();
    if (i == 0);
    ArrayList localArrayList;
    for (Object localObject = null; ; localObject = localArrayList)
    {
      return localObject;
      localArrayList = Lists.a();
      for (int j = 0; j < i; j++)
        localArrayList.add((SubStoryView)getChildAt(j));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.FeedSubstoriesSection
 * JD-Core Version:    0.6.0
 */