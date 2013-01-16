package com.facebook.timeline;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.base.BuildConstants;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.feed.renderer.FeedUnitViewStyle;
import com.facebook.feed.renderer.IFeedUnitRenderer;
import com.facebook.feed.ui.FeedStoryView;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.LifeEventFeedUnit;
import com.facebook.orca.debug.BLog;
import com.facebook.widget.listview.FbBaseAdapter;
import com.google.common.base.Preconditions;

public class TimelineAdapter extends FbBaseAdapter
{
  private static final Class<?> a = TimelineAdapter.class;
  private static final Object n = new Object();
  private final LayoutInflater b;
  private final IFeedUnitRenderer c;
  private final IFeedIntentBuilder d;
  private final SecureContextHelper e;
  private final FbErrorReporter f;
  private final TimelineDataFetcher g;
  private final TimelineFriendingClient h;
  private final TimelineHeaderData i;
  private final TimelineAllSectionsData j;
  private final TimelineFeedStoryMenuHelper k;
  private final Context l;
  private final FragmentManager m;

  public TimelineAdapter(Context paramContext, FragmentManager paramFragmentManager, TimelineDataFetcher paramTimelineDataFetcher, TimelineFriendingClient paramTimelineFriendingClient, TimelineHeaderData paramTimelineHeaderData, TimelineAllSectionsData paramTimelineAllSectionsData, LayoutInflater paramLayoutInflater, IFeedUnitRenderer paramIFeedUnitRenderer, IFeedIntentBuilder paramIFeedIntentBuilder, SecureContextHelper paramSecureContextHelper, FbErrorReporter paramFbErrorReporter, boolean paramBoolean)
  {
    Preconditions.checkNotNull(paramTimelineHeaderData);
    Preconditions.checkNotNull(paramTimelineAllSectionsData);
    Preconditions.checkNotNull(paramTimelineDataFetcher);
    this.l = paramContext;
    this.m = paramFragmentManager;
    this.g = paramTimelineDataFetcher;
    this.h = paramTimelineFriendingClient;
    this.i = paramTimelineHeaderData;
    this.j = paramTimelineAllSectionsData;
    this.b = paramLayoutInflater;
    this.d = paramIFeedIntentBuilder;
    this.e = paramSecureContextHelper;
    this.c = paramIFeedUnitRenderer;
    this.f = paramFbErrorReporter;
    this.k = new TimelineFeedStoryMenuHelper(this.l, this.d, this.c, paramBoolean, this.g, this.h.a(), this, this.i, this.j);
  }

  private View a(String paramString)
  {
    TextView localTextView = new TextView(this.l);
    localTextView.setTag("error_view");
    localTextView.setText(paramString);
    localTextView.setTextColor(Color.rgb(200, 0, 0));
    return localTextView;
  }

  private String a(Object paramObject)
  {
    FeedStory localFeedStory;
    String str;
    if ((paramObject instanceof FeedStory))
    {
      localFeedStory = (FeedStory)paramObject;
      if (localFeedStory.title != null)
        str = localFeedStory.title.text;
    }
    while (true)
    {
      return str;
      if (localFeedStory.message != null)
      {
        str = localFeedStory.message.text;
        continue;
        if ((paramObject instanceof LifeEventFeedUnit))
        {
          LifeEventFeedUnit localLifeEventFeedUnit = (LifeEventFeedUnit)paramObject;
          if (localLifeEventFeedUnit.title != null)
          {
            str = localLifeEventFeedUnit.title.text;
            continue;
          }
        }
      }
      str = null;
    }
  }

  private boolean a(View paramView)
  {
    int i1 = 1;
    if (b(paramView));
    while (true)
    {
      return i1;
      if (((paramView instanceof TimelineHeaderView)) && (((TimelineHeaderView)paramView).getHeaderData() != this.i))
        continue;
      i1 = 0;
    }
  }

  private boolean b(View paramView)
  {
    if (((paramView instanceof TextView)) && (paramView.getTag() != null) && (paramView.getTag().equals("error_view")));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    TimelineAdapter.ViewTypes localViewTypes = TimelineAdapter.ViewTypes.values()[paramInt];
    Object localObject;
    switch (TimelineAdapter.1.a[localViewTypes.ordinal()])
    {
    default:
      this.f.a("TimelineAdapter", "Unknown item type for TimelineAdapter of type " + paramInt, true);
      localObject = a("Unknown item type");
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    }
    while (true)
    {
      return localObject;
      localObject = TimelineHeaderView.a(this.l, this.e, this.m, this.i.e());
      continue;
      localObject = new FeedStoryView(this.l);
      continue;
      localObject = new FeedStoryView(this.l);
      ((FeedStoryView)localObject).b();
      ((FeedStoryView)localObject).d();
      continue;
      localObject = this.b.inflate(2130903267, null);
      continue;
      localObject = this.b.inflate(2130903603, null);
      continue;
      localObject = this.b.inflate(2130903602, null);
      continue;
      localObject = this.b.inflate(2130903598, null);
    }
  }

  public void a(Object paramObject, View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    if (paramObject == n)
      if ((paramView instanceof TimelineHeaderView))
        ((TimelineHeaderView)paramView).a(this.i, this.g, this.h, this.b, this.d);
    while (true)
    {
      return;
      if ((paramObject instanceof LifeEventFeedUnit))
      {
        if (!(paramView instanceof TimelineLifeEventUnitView))
          continue;
        ((TimelineLifeEventUnitView)paramView).a((LifeEventFeedUnit)paramObject);
        continue;
      }
      if ((paramObject instanceof TimelineSectionData.TimelineSectionLabel))
      {
        if (!(paramView instanceof TimelineScrubberView))
          continue;
        ((TimelineScrubberView)paramView).a(this.g, (TimelineSectionData.TimelineSectionLabel)paramObject, this.j);
        continue;
      }
      if ((paramObject instanceof TimelineSectionData.SeeMore))
      {
        if (!(paramView instanceof TimelineScrubberView))
          continue;
        ((TimelineScrubberView)paramView).a(this.g, (TimelineSectionData.SeeMore)paramObject, this.j);
        continue;
      }
      if (!(paramObject instanceof FeedStory))
        continue;
      this.c.a((FeedStory)paramObject, paramView, paramViewGroup, FeedUnitViewStyle.TIMELINE_STORY, this.k.c((FeedStory)paramObject));
    }
  }

  public int getCount()
  {
    TimelineHeaderData.InitializeState localInitializeState1 = this.i.a();
    TimelineHeaderData.InitializeState localInitializeState2 = TimelineHeaderData.InitializeState.UNINITIALIZED;
    int i1 = 0;
    if (localInitializeState1 != localInitializeState2)
      i1 = 1 + this.j.b();
    return i1;
  }

  public Object getItem(int paramInt)
  {
    Object localObject;
    if (paramInt == 0)
      localObject = n;
    while (true)
    {
      return localObject;
      if ((paramInt > 0) && (paramInt <= this.j.b()))
      {
        localObject = this.j.a(paramInt - 1);
        continue;
      }
      BLog.e(a, "getItem() for invalid index");
      localObject = null;
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
    if (localObject == n)
      i1 = TimelineAdapter.ViewTypes.HEADER.ordinal();
    while (true)
    {
      return i1;
      if ((localObject instanceof FeedStory))
      {
        FeedStory localFeedStory = (FeedStory)localObject;
        int i2 = localFeedStory.j();
        if (localFeedStory.attachedStory != null);
        for (int i3 = 1; ; i3 = 0)
        {
          if (i2 <= 0)
            break label74;
          i1 = TimelineAdapter.ViewTypes.STORY_EDGE_NARROW_OR_AGG.ordinal();
          break;
        }
        label74: if (i3 != 0)
        {
          i1 = TimelineAdapter.ViewTypes.STORY_EDGE_WIDE.ordinal();
          continue;
        }
        i1 = TimelineAdapter.ViewTypes.STORY_BASE.ordinal();
        continue;
      }
      if ((localObject instanceof LifeEventFeedUnit))
      {
        i1 = TimelineAdapter.ViewTypes.LIFE_EVENT.ordinal();
        continue;
      }
      if (((localObject instanceof TimelineSectionData.TimelineSectionLabel)) || ((localObject instanceof TimelineSectionData.SeeMore)))
      {
        i1 = TimelineAdapter.ViewTypes.SCRUBBER.ordinal();
        continue;
      }
      if (((localObject instanceof TimelineSectionData.LoadingIndicator)) || ((localObject instanceof TimelineSectionData.ScrollLoadTrigger)))
      {
        i1 = TimelineAdapter.ViewTypes.LOADING.ordinal();
        continue;
      }
      if ((localObject instanceof TimelineSectionData.NoStoriesMarker))
      {
        i1 = TimelineAdapter.ViewTypes.NO_STORIES.ordinal();
        continue;
      }
      i1 = -1;
    }
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    try
    {
      Object localObject = getItem(paramInt);
      int i1 = getItemViewType(paramInt);
      if ((paramView == null) || (a(paramView)))
      {
        localView = a(i1, paramViewGroup);
        a(localObject, localView, i1, paramViewGroup);
        if (((localObject instanceof FeedStory)) && ((localView instanceof FeedStoryView)))
          this.k.a((FeedStory)localObject, (FeedStoryView)localView, false);
        return localView;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        this.f.a("TimelineAdapter", "rendering", localException);
        String str1 = "";
        if (BuildConstants.a())
        {
          str1 = localException.getMessage() + " rendering ";
          String str2 = a(getItem(paramInt));
          if (str2 != null)
            str1 = str1 + "\"" + str2 + "\"";
        }
        View localView = a(str1);
        continue;
        localView = paramView;
      }
    }
  }

  public int getViewTypeCount()
  {
    return TimelineAdapter.ViewTypes.values().length;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineAdapter
 * JD-Core Version:    0.6.0
 */