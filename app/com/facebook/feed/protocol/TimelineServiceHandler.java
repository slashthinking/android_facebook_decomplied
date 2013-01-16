package com.facebook.feed.protocol;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.composer.server.ComposerPublishServiceHandler;
import com.facebook.friends.protocol.AddFriendListMemberMethod;
import com.facebook.friends.protocol.FetchFriendListsMethod;
import com.facebook.friends.protocol.FetchFriendListsWithMemberMethod;
import com.facebook.friends.protocol.RemoveFriendListMemberMethod;
import com.facebook.orca.app.UserInteractionController;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ISingleMethodRunner;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import javax.inject.Provider;

public class TimelineServiceHandler
  implements OrcaServiceHandler
{
  private final FetchTimelineHeaderMethod a;
  private final FetchTimelineSectionMethod b;
  private final FetchTimelineFirstUnitsMethod c;
  private final FetchTimelineSectionListMethod d;
  private final DeleteStoryMethod e;
  private final HideTimelineStoryMethod f;
  private final AddFriendListMemberMethod g;
  private final RemoveFriendListMemberMethod h;
  private final FetchFriendListsMethod i;
  private final FetchFriendListsWithMemberMethod j;
  private final Provider<ISingleMethodRunner> k;
  private final FbErrorReporter l;
  private final ComposerPublishServiceHandler m;
  private UserInteractionController n;

  public TimelineServiceHandler(FetchTimelineHeaderMethod paramFetchTimelineHeaderMethod, FetchTimelineSectionMethod paramFetchTimelineSectionMethod, FetchTimelineFirstUnitsMethod paramFetchTimelineFirstUnitsMethod, FetchTimelineSectionListMethod paramFetchTimelineSectionListMethod, DeleteStoryMethod paramDeleteStoryMethod, HideTimelineStoryMethod paramHideTimelineStoryMethod, AddFriendListMemberMethod paramAddFriendListMemberMethod, RemoveFriendListMemberMethod paramRemoveFriendListMemberMethod, FetchFriendListsMethod paramFetchFriendListsMethod, FetchFriendListsWithMemberMethod paramFetchFriendListsWithMemberMethod, ComposerPublishServiceHandler paramComposerPublishServiceHandler, Provider<ISingleMethodRunner> paramProvider, FbErrorReporter paramFbErrorReporter, UserInteractionController paramUserInteractionController)
  {
    this.a = paramFetchTimelineHeaderMethod;
    this.b = paramFetchTimelineSectionMethod;
    this.c = paramFetchTimelineFirstUnitsMethod;
    this.d = paramFetchTimelineSectionListMethod;
    this.e = paramDeleteStoryMethod;
    this.f = paramHideTimelineStoryMethod;
    this.g = paramAddFriendListMemberMethod;
    this.h = paramRemoveFriendListMemberMethod;
    this.i = paramFetchFriendListsMethod;
    this.j = paramFetchFriendListsWithMemberMethod;
    this.m = paramComposerPublishServiceHandler;
    this.k = paramProvider;
    this.l = paramFbErrorReporter;
    this.n = paramUserInteractionController;
  }

  private OperationResult a(Bundle paramBundle, ApiMethod paramApiMethod, String paramString)
  {
    if (paramString != null);
    for (Parcelable localParcelable = paramBundle.getParcelable(paramString); ; localParcelable = null)
    {
      this.n.c();
      return OperationResult.a((Parcelable)((ISingleMethodRunner)this.k.b()).a(new TimelineServiceHandler.WrapperMethod(paramApiMethod, this.n), localParcelable));
    }
  }

  public OperationResult a(OperationParams paramOperationParams)
  {
    Bundle localBundle = paramOperationParams.b();
    String str = paramOperationParams.a();
    OperationResult localOperationResult;
    try
    {
      if ("fetch_timeline_header".equals(str))
        localOperationResult = a(localBundle, this.a, "fetchTimelineHeaderParams");
      else if ("fetch_section".equals(str))
        localOperationResult = a(localBundle, this.b, "fetchTimelineSectionParams");
      else if ("fetch_first_units".equals(str))
        localOperationResult = a(localBundle, this.c, "fetchTimelineFirstUnitsParams");
      else if ("fetch_section_list".equals(str))
        localOperationResult = a(localBundle, this.d, "fetchTimelineSectionListParams");
      else if ("delete_story".equals(str))
        localOperationResult = a(localBundle, this.e, "deleteStoryParams");
      else if ("hide_story".matches(str))
        localOperationResult = a(localBundle, this.f, "hideStoryParams");
      else if ("add_friend_list_member".equals(str))
        localOperationResult = a(localBundle, this.g, "addFriendListMemberParams");
      else if ("remove_friend_list_member".equals(str))
        localOperationResult = a(localBundle, this.h, "removeFriendListMemberParams");
      else if ("fetch_friendlists".equals(str))
        localOperationResult = a(localBundle, this.i, null);
      else if ("fetch_friendlists_with_member".equals(str))
        localOperationResult = a(localBundle, this.j, "fetchFriendListsWithMemberParams");
      else if ("timeline_publish_checkin".equals(str))
        localOperationResult = this.m.c(paramOperationParams);
      else if ("timeline_publish_post".equals(str))
        localOperationResult = this.m.b(paramOperationParams);
      else if ("timeline_publish_share".equals(str))
        localOperationResult = this.m.a(paramOperationParams);
      else if ("timeline_publish_photo".equals(str))
        localOperationResult = this.m.d(paramOperationParams);
      else
        throw new ApiMethodNotFoundException(str);
    }
    catch (Exception localException)
    {
      this.l.a("TimelineServiceHandler", "Error in " + str, localException);
      throw localException;
    }
    return localOperationResult;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.TimelineServiceHandler
 * JD-Core Version:    0.6.0
 */