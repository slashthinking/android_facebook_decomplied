package com.facebook.katana.activity.notifications;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.notifications.provider.GQLNotificationsContentProviderHelper;

public class NotificationsAdapter$GraphQLNotificationsRenderer extends NotificationsAdapter.NotificationsRenderer
{
  private GQLNotificationsContentProviderHelper a;

  public NotificationsAdapter$GraphQLNotificationsRenderer(Context paramContext, GQLNotificationsContentProviderHelper paramGQLNotificationsContentProviderHelper)
  {
    super(paramContext);
    this.a = paramGQLNotificationsContentProviderHelper;
  }

  void a(View paramView, Context paramContext, Cursor paramCursor)
  {
    FeedStory localFeedStory = this.a.a(paramCursor);
    if (localFeedStory == null)
    {
      paramView.setVisibility(8);
      return;
    }
    GraphQLProfile localGraphQLProfile = localFeedStory.a();
    if ((localGraphQLProfile != null) && (localGraphQLProfile.profilePicture != null));
    for (String str1 = localGraphQLProfile.profilePicture.uri; ; str1 = null)
    {
      if (localFeedStory.icon != null);
      for (String str2 = localFeedStory.icon.uri; ; str2 = null)
      {
        a(paramView, paramContext, "SEEN_AND_READ".equals(localFeedStory.seenState), str1, str2, a(localFeedStory.title), localFeedStory.creationTime, null);
        paramView.setVisibility(0);
        break;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.notifications.NotificationsAdapter.GraphQLNotificationsRenderer
 * JD-Core Version:    0.6.0
 */