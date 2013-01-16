package com.facebook.feed.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.BuildConstants;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.feed.data.PagedFeedUnitCollection;
import com.facebook.feed.model.FeedRowType;
import com.facebook.feed.renderer.FeedUnitViewStyle;
import com.facebook.feed.renderer.IFeedUnitRenderer;
import com.facebook.feed.util.FeedUtils;
import com.facebook.graphql.model.FeedEdge;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.FeedUnitEdge;
import com.facebook.graphql.model.MegaphoneStory;
import com.facebook.megaphone.data.MegaphoneStore;
import com.facebook.megaphone.ui.MegaphoneScreenLayout;
import com.facebook.task.IncrementalTaskExecutor;
import com.facebook.widget.CachingListAdapter;
import com.google.common.base.Preconditions;
import java.util.concurrent.ExecutorService;

public class NewsFeedAdapter extends CachingListAdapter
{
  private static final int a = FeedRowType.values().length;
  private static final Object k = new Object();
  private static final Object l = new Object();
  private static final Object m = new Object();
  private static final Object n = new Object();
  private static final Object o = new Object();
  private final IFeedUnitRenderer b;
  private final PagedFeedUnitCollection c;
  private final LayoutInflater d;
  private final MegaphoneStore e;
  private final FeedUnitViewFactory f;
  private final boolean g;
  private final FeedStoryMenuHelper h;
  private final ExecutorService i;
  private final FbErrorReporter j;
  private boolean p = true;
  private boolean q = false;
  private MegaphoneStory r = null;

  public NewsFeedAdapter(Context paramContext, PagedFeedUnitCollection paramPagedFeedUnitCollection, IFeedUnitRenderer paramIFeedUnitRenderer, IncrementalTaskExecutor paramIncrementalTaskExecutor, FeedStoryMenuHelper paramFeedStoryMenuHelper, MegaphoneStore paramMegaphoneStore, FeedUnitViewFactory paramFeedUnitViewFactory, boolean paramBoolean, ExecutorService paramExecutorService, FbErrorReporter paramFbErrorReporter)
  {
    super(paramIncrementalTaskExecutor);
    this.c = ((PagedFeedUnitCollection)Preconditions.checkNotNull(paramPagedFeedUnitCollection));
    Preconditions.checkNotNull(paramContext);
    this.b = ((IFeedUnitRenderer)Preconditions.checkNotNull(paramIFeedUnitRenderer));
    this.d = LayoutInflater.from(paramContext);
    this.e = paramMegaphoneStore;
    this.f = paramFeedUnitViewFactory;
    this.g = paramBoolean;
    this.h = paramFeedStoryMenuHelper;
    this.i = ((ExecutorService)Preconditions.checkNotNull(paramExecutorService));
    this.j = ((FbErrorReporter)Preconditions.checkNotNull(paramFbErrorReporter));
    a(paramContext);
    this.r = e();
  }

  private void a(Context paramContext)
  {
    if (this.e == null);
    while (true)
    {
      return;
      this.e.a(MegaphoneScreenLayout.a(paramContext));
    }
  }

  private void a(Throwable paramThrowable)
  {
    this.i.submit(new NewsFeedAdapter.1(this, paramThrowable));
  }

  private int d()
  {
    if (this.r != null);
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  private MegaphoneStory e()
  {
    if (this.e != null);
    for (MegaphoneStory localMegaphoneStory = this.e.a("NEWSFEED"); ; localMegaphoneStory = null)
      return localMegaphoneStory;
  }

  public int a()
  {
    return b() + d();
  }

  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = getItem(paramInt);
    int i1 = getItemViewType(paramInt);
    if (paramView == null)
      paramView = a(i1, paramViewGroup);
    try
    {
      paramView.setVisibility(0);
      a(localObject, paramView, i1, paramViewGroup);
      return paramView;
    }
    catch (Exception localException)
    {
      while (true)
      {
        paramView.setVisibility(8);
        if ((!(localObject instanceof FeedEdge)) || (!((FeedEdge)localObject).d()))
          continue;
        ((FeedEdge)localObject).a(false);
        a(localException);
      }
    }
  }

  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    return this.f.a(this.d, paramInt, paramViewGroup);
  }

  public void a(Object paramObject, View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    boolean bool1 = true;
    boolean bool2;
    if (paramView != null)
    {
      bool2 = bool1;
      Preconditions.checkArgument(bool2);
      if (!(paramView instanceof UnknownFeedUnitView))
        break label46;
      Preconditions.checkState(BuildConstants.a());
      ((UnknownFeedUnitView)paramView).a(paramObject, null, false);
    }
    label46: label115: 
    do
      while (true)
      {
        return;
        bool2 = false;
        break;
        if (paramObject == k)
        {
          IFeedUnitRenderer localIFeedUnitRenderer = this.b;
          if (d() > 0);
          while (true)
          {
            localIFeedUnitRenderer.a(paramView, paramViewGroup, bool1);
            break;
            bool1 = false;
          }
        }
        if (paramObject != o)
          break label115;
        this.b.a(paramView, paramViewGroup, this.r);
      }
    while (!(paramObject instanceof FeedEdge));
    FeedUnit localFeedUnit = ((FeedEdge)paramObject).b();
    if ((this.g) && ((localFeedUnit instanceof FeedStory)) && ((paramView instanceof FeedStoryView)));
    for (boolean bool3 = this.h.a((FeedStory)localFeedUnit, (FeedStoryView)paramView, false); ; bool3 = false)
    {
      this.b.a(localFeedUnit, paramView, paramViewGroup, FeedUnitViewStyle.NEWSFEED_STORY, bool3);
      break;
    }
  }

  public void a(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }

  protected boolean a(int paramInt)
  {
    Object localObject = getItem(paramInt);
    int i1;
    if ((localObject instanceof FeedUnitEdge))
      if (((FeedUnitEdge)localObject).e() != null)
        i1 = 1;
    while (true)
    {
      return i1;
      i1 = 0;
      continue;
      i1 = 1;
    }
  }

  public int b()
  {
    if (this.p);
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public int getCount()
  {
    if (this.c.a() == 0);
    for (int i1 = 0; ; i1 = 1 + this.c.a() + a())
      return i1;
  }

  public Object getItem(int paramInt)
  {
    int i1 = a();
    Object localObject;
    if (paramInt < i1)
      if ((this.r != null) && (((this.p) && (paramInt == 1)) || ((!this.p) && (paramInt == 0))))
        localObject = o;
    while (true)
    {
      return localObject;
      localObject = k;
      continue;
      if (paramInt < i1 + this.c.a())
      {
        localObject = this.c.a(paramInt - i1);
        if (localObject != PagedFeedUnitCollection.a)
          continue;
        localObject = n;
        continue;
      }
      if (this.q)
      {
        localObject = m;
        continue;
      }
      localObject = l;
    }
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    Object localObject = getItem(paramInt);
    int i1;
    if (localObject == l)
      i1 = FeedRowType.LOAD_MORE.ordinal();
    while (true)
    {
      return i1;
      if (localObject == k)
      {
        i1 = FeedRowType.TOP_PADDING.ordinal();
        continue;
      }
      if (localObject == n)
      {
        i1 = FeedRowType.SCISSOR.ordinal();
        continue;
      }
      if (localObject == m)
      {
        i1 = FeedRowType.END_OF_FEED.ordinal();
        continue;
      }
      if (localObject == o)
      {
        i1 = FeedRowType.MEGAPHONE.ordinal();
        continue;
      }
      if ((localObject instanceof FeedEdge))
      {
        i1 = FeedUtils.a(((FeedEdge)localObject).b()).ordinal();
        continue;
      }
      i1 = FeedRowType.UNKNOWN.ordinal();
    }
  }

  public int getViewTypeCount()
  {
    return a;
  }

  public void notifyDataSetChanged()
  {
    this.r = e();
    super.notifyDataSetChanged();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.NewsFeedAdapter
 * JD-Core Version:    0.6.0
 */