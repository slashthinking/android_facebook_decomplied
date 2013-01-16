package com.facebook.feed.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.feed.renderer.FeedUnitViewStyle;
import com.facebook.feed.renderer.recycle.FeedRecyclableViewPoolManager;
import com.facebook.feed.util.FeedUtils;
import com.facebook.graphql.model.FeedStory;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.FbCustomViewGroup;
import com.facebook.widget.listview.recycle.RecyclableView;
import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.List;

public class SubStoryView extends CustomViewGroup
  implements DepthAwareView, RecyclableView
{
  private static final Class<?> a = SubStoryView.class;
  private final View b;
  private final StoryContentView c;
  private final View d;
  private final Context e;
  private final FeedRecyclableViewPoolManager f;
  private boolean g;

  public SubStoryView(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public SubStoryView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public SubStoryView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903189);
    this.b = getView(2131296822);
    this.c = ((StoryContentView)getView(2131296693));
    this.d = getView(2131296823);
    this.e = paramContext;
    this.f = ((FeedRecyclableViewPoolManager)getInjector().a(FeedRecyclableViewPoolManager.class));
  }

  public void a(int paramInt)
  {
    FeedUtils.a(this.e, this.b, paramInt, 0);
  }

  public void a(FeedStory paramFeedStory, boolean paramBoolean)
  {
    a(paramFeedStory.t());
    this.c.a(paramFeedStory, FeedUnitViewStyle.SUBSTORY);
    if (paramBoolean)
      this.d.setVisibility(8);
    while (true)
    {
      return;
      this.d.setVisibility(0);
    }
  }

  public void a(boolean paramBoolean)
  {
  }

  public boolean a()
  {
    return this.g;
  }

  public void b()
  {
  }

  protected void c()
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    Preconditions.checkState(localViewGroup instanceof FbCustomViewGroup, "SubStoryView must live in a FbCustomViewGroup class");
    FbCustomViewGroup localFbCustomViewGroup = (FbCustomViewGroup)localViewGroup;
    this.f.a(SubStoryView.class, this, localFbCustomViewGroup);
    List localList = getSubstoryViews();
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
        ((SubStoryView)localIterator.next()).c();
    }
  }

  public int getRecyclableViewType()
  {
    return 0;
  }

  protected List<SubStoryView> getSubstoryViews()
  {
    return this.c.getSubstoryViews();
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    setHasBeenAttached(true);
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    setHasBeenAttached(false);
  }

  public void setHasBeenAttached(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.SubStoryView
 * JD-Core Version:    0.6.0
 */