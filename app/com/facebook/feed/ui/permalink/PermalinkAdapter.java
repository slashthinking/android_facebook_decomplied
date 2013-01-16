package com.facebook.feed.ui.permalink;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.debug.Assert;
import com.facebook.feed.data.PagedCommentCollection;
import com.facebook.feed.renderer.FeedUnitViewStyle;
import com.facebook.feed.renderer.IFeedUnitRenderer;
import com.facebook.graphql.model.FeedComment;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedStoryBuilder;
import com.facebook.graphql.model.FeedStoryLikers;
import com.facebook.graphql.model.Feedback;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.google.common.base.Preconditions;

public class PermalinkAdapter extends BaseAdapter
{
  private static final Class<?> a = PermalinkAdapter.class;
  private static final Object j = new Object();
  private FeedStory b;
  private Feedback c;
  private Context d;
  private LayoutInflater e;
  private PagedCommentCollection f;
  private final IFeedUnitRenderer g;
  private View.OnClickListener h;
  private boolean i;

  public PermalinkAdapter(Context paramContext, FeedStory paramFeedStory, PagedCommentCollection paramPagedCommentCollection)
  {
    Preconditions.checkNotNull(paramPagedCommentCollection);
    this.d = paramContext;
    this.e = LayoutInflater.from(paramContext);
    this.b = paramFeedStory;
    this.c = paramFeedStory.S();
    this.f = paramPagedCommentCollection;
    this.g = ((IFeedUnitRenderer)FbInjector.a(paramContext).a(IFeedUnitRenderer.class));
  }

  private int a(int paramInt)
  {
    return paramInt - f();
  }

  private View a(View paramView)
  {
    PermalinkLikeSentenceView localPermalinkLikeSentenceView;
    if (paramView != null)
    {
      localPermalinkLikeSentenceView = (PermalinkLikeSentenceView)paramView;
      localPermalinkLikeSentenceView.a(this.c);
      if ((!this.f.g()) || (this.i) || (this.b.P()))
        break label65;
      localPermalinkLikeSentenceView.setNoContentBelow();
    }
    while (true)
    {
      return localPermalinkLikeSentenceView;
      localPermalinkLikeSentenceView = new PermalinkLikeSentenceView(this.d);
      break;
      label65: localPermalinkLikeSentenceView.setWithContentBelow();
    }
  }

  private View a(View paramView, int paramInt)
  {
    PermalinkCommentView localPermalinkCommentView;
    FeedComment localFeedComment;
    if (paramView != null)
    {
      localPermalinkCommentView = (PermalinkCommentView)paramView;
      localFeedComment = this.f.a(paramInt);
      if (this.c == null)
        break label100;
    }
    label100: for (String str = this.c.id; ; str = null)
    {
      localPermalinkCommentView.a(str, localFeedComment);
      return localPermalinkCommentView;
      if ((paramInt == -1 + this.f.a()) && (!this.b.P()))
      {
        localPermalinkCommentView = new PermalinkCommentView(this.d, true);
        break;
      }
      localPermalinkCommentView = new PermalinkCommentView(this.d, false);
      break;
    }
  }

  private View b(View paramView)
  {
    PermalinkAdapter.MoreCommentsViewHolder localMoreCommentsViewHolder;
    if (paramView != null)
    {
      localMoreCommentsViewHolder = (PermalinkAdapter.MoreCommentsViewHolder)paramView.getTag();
      if (!d())
        break label115;
      localMoreCommentsViewHolder.d.setVisibility(8);
      label28: if ((!this.f.g()) || (this.b.P()))
        break label126;
      paramView.findViewById(2131296730).setBackgroundResource(2130838218);
      label59: if (!this.i)
        break label140;
      localMoreCommentsViewHolder.a();
    }
    while (true)
    {
      if (this.h != null)
        paramView.setOnClickListener(this.h);
      return paramView;
      paramView = this.e.inflate(2130903158, null);
      localMoreCommentsViewHolder = new PermalinkAdapter.MoreCommentsViewHolder(paramView);
      paramView.setTag(localMoreCommentsViewHolder);
      break;
      label115: localMoreCommentsViewHolder.d.setVisibility(0);
      break label28;
      label126: paramView.findViewById(2131296730).setBackgroundResource(2130838220);
      break label59;
      label140: localMoreCommentsViewHolder.b();
    }
  }

  private boolean b()
  {
    Feedback localFeedback = this.b.S();
    int k = 0;
    if (localFeedback != null)
    {
      FeedStoryLikers localFeedStoryLikers = this.b.S().likers;
      k = 0;
      if (localFeedStoryLikers != null)
      {
        int m = this.b.S().likers.count;
        k = 0;
        if (m > 0)
          k = 1;
      }
    }
    return k;
  }

  private boolean c()
  {
    if (this.b.S() != null);
    for (boolean bool = this.b.S().canViewerLike; ; bool = false)
      return bool;
  }

  private boolean d()
  {
    if (((b()) || (c())) && (this.c.viewerLikersSentence != null));
    for (int k = 1; ; k = 0)
      return k;
  }

  private boolean e()
  {
    if ((this.i) || ((this.f.e()) && (!this.f.g())));
    for (int k = 1; ; k = 0)
      return k;
  }

  private int f()
  {
    int k = 1;
    if (d())
      k = 2;
    if (e())
      k++;
    return k;
  }

  public int a()
  {
    if (this.f.a() > 0);
    for (int k = f(); ; k = -1)
      return k;
  }

  public void a(View.OnClickListener paramOnClickListener)
  {
    this.h = paramOnClickListener;
  }

  public void a(FeedStory paramFeedStory)
  {
    Preconditions.checkNotNull(paramFeedStory);
    this.b = paramFeedStory;
    if (paramFeedStory.S() != this.c)
      this.c = paramFeedStory.S();
    notifyDataSetChanged();
  }

  public void a(Feedback paramFeedback)
  {
    if ((this.c == paramFeedback) && (this.b.S() == paramFeedback));
    while (true)
    {
      return;
      this.c = paramFeedback;
      if ((this.b != null) && (this.b.S() != paramFeedback))
        this.b = new FeedStoryBuilder(this.b).a(paramFeedback).G();
      notifyDataSetChanged();
    }
  }

  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }

  public int getCount()
  {
    return this.f.a() + f();
  }

  public Object getItem(int paramInt)
  {
    int k = a(paramInt);
    Object localObject;
    if (paramInt == 0)
      localObject = this.b;
    while (true)
    {
      return localObject;
      if ((paramInt == 1) && (d()))
      {
        Assert.a(this.b.S());
        localObject = this.b.S().likers;
        continue;
      }
      if ((paramInt == 1) && (!d()) && (e()))
      {
        localObject = j;
        continue;
      }
      if ((paramInt == 2) && (d()) && (e()))
      {
        localObject = j;
        continue;
      }
      if (k < this.f.a())
      {
        localObject = this.f.a(k);
        continue;
      }
      BLog.a(a, "Called getItem with position " + paramInt + ".  Out of bounds.");
      localObject = null;
    }
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    int k = a(paramInt);
    int m = -1 + getCount();
    int n;
    if (paramInt == 0)
      n = PermalinkAdapter.PermalinkViewTypes.STORY.ordinal();
    while (true)
    {
      return n;
      if ((paramInt == 1) && (d()))
      {
        n = PermalinkAdapter.PermalinkViewTypes.LIKES.ordinal();
        continue;
      }
      if ((paramInt == 1) && (!d()) && (e()))
      {
        n = PermalinkAdapter.PermalinkViewTypes.MORE_COMMENTS.ordinal();
        continue;
      }
      if ((paramInt == 2) && (d()) && (e()))
      {
        n = PermalinkAdapter.PermalinkViewTypes.MORE_COMMENTS.ordinal();
        continue;
      }
      if (k < this.f.a())
      {
        if (paramInt == m)
        {
          n = PermalinkAdapter.PermalinkViewTypes.COMMENT_LAST.ordinal();
          continue;
        }
        n = PermalinkAdapter.PermalinkViewTypes.COMMENT_MIDDLE.ordinal();
        continue;
      }
      BLog.a(a, "Called getItemViewType with postiion " + paramInt + ".  Out of bounds.");
      n = -1;
    }
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = null;
    switch (PermalinkAdapter.1.a[PermalinkAdapter.PermalinkViewTypes.values()[getItemViewType(paramInt)].ordinal()])
    {
    default:
      BLog.b(a, "Unknown item type for PermalinkAdapter at position " + paramInt);
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    }
    while (true)
    {
      return localObject;
      if (paramView == null);
      for (localObject = new PermalinkStoryView(paramViewGroup.getContext()); ; localObject = paramView)
      {
        if (this.b.attachedStory != null)
          ((PermalinkStoryView)localObject).a();
        this.g.a(this.b, (View)localObject, paramViewGroup, FeedUnitViewStyle.PERMALINK_STORY, false);
        PermalinkStoryView localPermalinkStoryView = (PermalinkStoryView)localObject;
        boolean bool1;
        if ((!e()) && (this.f.g()) && (!d()))
        {
          boolean bool2 = this.b.P();
          bool1 = false;
          if (!bool2);
        }
        else
        {
          bool1 = true;
        }
        localPermalinkStoryView.setHasContentBelowStory(bool1);
        break;
      }
      localObject = a(paramView);
      continue;
      localObject = b(paramView);
      continue;
      int k = this.f.a();
      localObject = null;
      if (k <= 0)
        continue;
      localObject = a(paramView, a(paramInt));
    }
  }

  public int getViewTypeCount()
  {
    return PermalinkAdapter.PermalinkViewTypes.values().length;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.permalink.PermalinkAdapter
 * JD-Core Version:    0.6.0
 */