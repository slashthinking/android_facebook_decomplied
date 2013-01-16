package com.facebook.feed.ui.attachments;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.friends.FriendingClient;
import com.facebook.graphql.model.FeedStoryAttachment;
import com.facebook.graphql.model.FeedStoryAttachmentTarget;

class StoryAttachmentViewAddFriend$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    StoryAttachmentViewAddFriend.a(this.b).a(Long.valueOf(this.a.target.id).longValue());
    this.a.a(false);
    StoryAttachmentViewAddFriend.a(this.b, this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.attachments.StoryAttachmentViewAddFriend.1
 * JD-Core Version:    0.6.0
 */