package com.facebook.timeline;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.BaseAdapter;
import com.facebook.common.util.Log;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.feed.renderer.IFeedUnitRenderer;
import com.facebook.feed.ui.AlertDialogMenuBuilder;
import com.facebook.feed.ui.FeedStoryMenuHelper;
import com.facebook.friends.FriendingClient;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLObjectType.ObjectType;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.ReportInfo;
import com.facebook.orca.common.util.StringLocaleUtil;
import java.util.List;

class TimelineFeedStoryMenuHelper extends FeedStoryMenuHelper
{
  private final Context a;
  private final TimelineDataFetcher b;
  private final FriendingClient c;
  private final BaseAdapter d;
  private final TimelineHeaderData e;
  private final TimelineAllSectionsData f;

  public TimelineFeedStoryMenuHelper(Context paramContext, IFeedIntentBuilder paramIFeedIntentBuilder, IFeedUnitRenderer paramIFeedUnitRenderer, boolean paramBoolean, TimelineDataFetcher paramTimelineDataFetcher, FriendingClient paramFriendingClient, BaseAdapter paramBaseAdapter, TimelineHeaderData paramTimelineHeaderData, TimelineAllSectionsData paramTimelineAllSectionsData)
  {
    super(paramContext, paramIFeedIntentBuilder, paramIFeedUnitRenderer, paramBoolean);
    this.a = paramContext;
    this.b = paramTimelineDataFetcher;
    this.c = paramFriendingClient;
    this.d = paramBaseAdapter;
    this.e = paramTimelineHeaderData;
    this.f = paramTimelineAllSectionsData;
  }

  private void d(FeedStory paramFeedStory)
  {
    this.f.a(paramFeedStory.getCacheId());
    this.d.notifyDataSetChanged();
  }

  private boolean e(FeedStory paramFeedStory)
  {
    if ((paramFeedStory.canViewerDelete) && (paramFeedStory.legacyApiStoryId != null));
    for (int i = 1; ; i = 0)
      return i;
  }

  private boolean f(FeedStory paramFeedStory)
  {
    boolean bool = this.e.r();
    int i = 0;
    if (!bool);
    while (true)
    {
      return i;
      GraphQLObjectType localGraphQLObjectType = paramFeedStory.type;
      i = 0;
      if (localGraphQLObjectType == null)
        continue;
      GraphQLObjectType.ObjectType localObjectType1 = paramFeedStory.type.a();
      GraphQLObjectType.ObjectType localObjectType2 = GraphQLObjectType.ObjectType.Story;
      i = 0;
      if (localObjectType1 != localObjectType2)
        continue;
      String str = paramFeedStory.legacyApiStoryId;
      i = 0;
      if (str == null)
        continue;
      i = 1;
    }
  }

  private GraphQLProfile g(FeedStory paramFeedStory)
  {
    if (paramFeedStory != null);
    try
    {
      if ((paramFeedStory.actors != null) && (paramFeedStory.actors.size() == 1) && (paramFeedStory.actors.get(0) != null));
      for (localGraphQLProfile = (GraphQLProfile)paramFeedStory.actors.get(0); ; localGraphQLProfile = null)
        return localGraphQLProfile;
    }
    catch (Exception localException)
    {
      while (true)
        GraphQLProfile localGraphQLProfile = null;
    }
  }

  private boolean h(FeedStory paramFeedStory)
  {
    int i = 0;
    if (paramFeedStory == null);
    GraphQLProfile localGraphQLProfile;
    do
    {
      boolean bool;
      do
      {
        GraphQLObjectType.ObjectType localObjectType1;
        GraphQLObjectType.ObjectType localObjectType2;
        do
        {
          return i;
          localObjectType1 = this.e.e();
          localObjectType2 = GraphQLObjectType.ObjectType.Page;
          i = 0;
        }
        while (localObjectType1 != localObjectType2);
        bool = this.e.r();
        i = 0;
      }
      while (!bool);
      localGraphQLProfile = g(paramFeedStory);
      i = 0;
    }
    while (localGraphQLProfile == null);
    Long localLong = Long.valueOf(Long.parseLong(((GraphQLProfile)paramFeedStory.actors.get(0)).id));
    if ((localLong.longValue() != 0L) && (localLong.longValue() != this.e.d()) && (localLong.longValue() != this.e.c()));
    for (int j = 1; ; j = 0)
    {
      i = j;
      break;
    }
  }

  private void i(FeedStory paramFeedStory)
  {
    GraphQLProfile localGraphQLProfile = g(paramFeedStory);
    if (localGraphQLProfile == null)
      Log.a("Error: ban user action see empty actor");
    while (true)
    {
      return;
      String str1 = this.a.getResources().getString(2131361803);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localGraphQLProfile.name;
      String str2 = StringLocaleUtil.b(str1, arrayOfObject);
      new AlertDialog.Builder(this.a).setMessage(str2).setPositiveButton(2131361801, new TimelineFeedStoryMenuHelper.6(this, paramFeedStory, localGraphQLProfile)).setNegativeButton(2131361850, null).show();
    }
  }

  private void j(FeedStory paramFeedStory)
  {
    new AlertDialog.Builder(this.a).setMessage(this.a.getResources().getString(2131361830)).setPositiveButton(2131361799, new TimelineFeedStoryMenuHelper.7(this, paramFeedStory)).setNegativeButton(2131361850, null).show();
  }

  private void k(FeedStory paramFeedStory)
  {
    new AlertDialog.Builder(this.a).setMessage(this.a.getResources().getString(2131361831)).setPositiveButton(2131361800, new TimelineFeedStoryMenuHelper.8(this, paramFeedStory)).setNegativeButton(2131361850, null).show();
  }

  public void a(View paramView, FeedStory paramFeedStory)
  {
    Context localContext = a();
    AlertDialogMenuBuilder localAlertDialogMenuBuilder = new AlertDialogMenuBuilder(localContext);
    if (e(paramFeedStory))
      localAlertDialogMenuBuilder.a(localContext.getResources().getString(2131361799), new TimelineFeedStoryMenuHelper.1(this, paramFeedStory));
    if (f(paramFeedStory))
      localAlertDialogMenuBuilder.a(localContext.getResources().getString(2131361800), new TimelineFeedStoryMenuHelper.2(this, paramFeedStory));
    if (h(paramFeedStory))
      localAlertDialogMenuBuilder.a(localContext.getResources().getString(2131361801), new TimelineFeedStoryMenuHelper.3(this, paramFeedStory));
    if (a(paramFeedStory))
      localAlertDialogMenuBuilder.a(paramFeedStory.reportInfo.action, new TimelineFeedStoryMenuHelper.4(this, paramFeedStory));
    localAlertDialogMenuBuilder.a(localContext.getResources().getString(2131361850), new TimelineFeedStoryMenuHelper.5(this));
    localAlertDialogMenuBuilder.show();
  }

  protected boolean c(FeedStory paramFeedStory)
  {
    if ((e(paramFeedStory)) || (f(paramFeedStory)) || (h(paramFeedStory)) || (a(paramFeedStory)));
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineFeedStoryMenuHelper
 * JD-Core Version:    0.6.0
 */