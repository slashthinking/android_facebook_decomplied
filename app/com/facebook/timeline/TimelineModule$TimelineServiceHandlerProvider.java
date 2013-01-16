package com.facebook.timeline;

import com.facebook.common.util.FbErrorReporter;
import com.facebook.composer.server.ComposerPublishServiceHandler;
import com.facebook.feed.protocol.DeleteStoryMethod;
import com.facebook.feed.protocol.FetchTimelineFirstUnitsMethod;
import com.facebook.feed.protocol.FetchTimelineHeaderMethod;
import com.facebook.feed.protocol.FetchTimelineSectionListMethod;
import com.facebook.feed.protocol.FetchTimelineSectionMethod;
import com.facebook.feed.protocol.HideTimelineStoryMethod;
import com.facebook.feed.protocol.TimelineServiceHandler;
import com.facebook.friends.protocol.AddFriendListMemberMethod;
import com.facebook.friends.protocol.FetchFriendListsMethod;
import com.facebook.friends.protocol.FetchFriendListsWithMemberMethod;
import com.facebook.friends.protocol.RemoveFriendListMemberMethod;
import com.facebook.orca.app.UserInteractionController;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.base.ISingleMethodRunner;

class TimelineModule$TimelineServiceHandlerProvider extends AbstractProvider<TimelineServiceHandler>
{
  private TimelineModule$TimelineServiceHandlerProvider(TimelineModule paramTimelineModule)
  {
  }

  public TimelineServiceHandler a()
  {
    return new TimelineServiceHandler((FetchTimelineHeaderMethod)b(FetchTimelineHeaderMethod.class), (FetchTimelineSectionMethod)b(FetchTimelineSectionMethod.class), (FetchTimelineFirstUnitsMethod)b(FetchTimelineFirstUnitsMethod.class), (FetchTimelineSectionListMethod)b(FetchTimelineSectionListMethod.class), (DeleteStoryMethod)b(DeleteStoryMethod.class), (HideTimelineStoryMethod)b(HideTimelineStoryMethod.class), (AddFriendListMemberMethod)b(AddFriendListMemberMethod.class), (RemoveFriendListMemberMethod)b(RemoveFriendListMemberMethod.class), (FetchFriendListsMethod)b(FetchFriendListsMethod.class), (FetchFriendListsWithMemberMethod)b(FetchFriendListsWithMemberMethod.class), (ComposerPublishServiceHandler)b(ComposerPublishServiceHandler.class), a(ISingleMethodRunner.class), (FbErrorReporter)b(FbErrorReporter.class), (UserInteractionController)b(UserInteractionController.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineModule.TimelineServiceHandlerProvider
 * JD-Core Version:    0.6.0
 */