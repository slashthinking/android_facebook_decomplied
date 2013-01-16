package com.facebook.feed.ui.attachments;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.feed.ui.DepthAwareView;
import com.facebook.feed.ui.FeedImageLoader;
import com.facebook.feed.ui.FeedImageLoader.FeedImageType;
import com.facebook.friends.FriendingClient;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedStoryAttachment;
import com.facebook.graphql.model.FeedStoryAttachmentTarget;
import com.facebook.graphql.model.GraphQLActionLink;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLObjectType.ObjectType;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.UrlImage;
import java.util.List;

public class StoryAttachmentViewAddFriend extends StoryAttachmentView
  implements DepthAwareView
{
  private final Context e;
  private final UrlImage f;
  private final TextView g;
  private final TextView h;
  private final TextView i;
  private final ImageView j;
  private final FeedImageLoader k;
  private final FriendingClient l;

  public StoryAttachmentViewAddFriend(Context paramContext)
  {
    this(paramContext, null);
  }

  public StoryAttachmentViewAddFriend(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    FbInjector localFbInjector = getInjector();
    this.e = paramContext;
    this.k = ((FeedImageLoader)localFbInjector.a(FeedImageLoader.class));
    this.l = ((FriendingClient)localFbInjector.a(FriendingClient.class));
    setContentView(2130903162);
    this.f = ((UrlImage)b(2131296738));
    this.g = ((TextView)b(2131296741));
    this.i = ((TextView)b(2131296742));
    this.h = ((TextView)b(2131296743));
    this.j = ((ImageView)b(2131296739));
  }

  public static boolean a(FeedStoryAttachment paramFeedStoryAttachment)
  {
    int m;
    if ((paramFeedStoryAttachment.actionLinks != null) && (paramFeedStoryAttachment.actionLinks.size() > 0))
      if (((GraphQLActionLink)paramFeedStoryAttachment.actionLinks.get(0)).type.a() == GraphQLObjectType.ObjectType.AddFriendActionLink)
        m = 1;
    while (true)
    {
      return m;
      m = 0;
      continue;
      m = 0;
    }
  }

  private void setRequestedState(FeedStoryAttachment paramFeedStoryAttachment)
  {
    if (paramFeedStoryAttachment.k())
    {
      this.i.setText(this.e.getResources().getString(2131362122));
      this.j.setImageResource(2130838205);
      this.j.setBackgroundDrawable(null);
      this.j.setOnClickListener(null);
      this.h.setVisibility(0);
      this.h.setOnClickListener(new StoryAttachmentViewAddFriend.1(this, paramFeedStoryAttachment));
    }
    while (true)
    {
      return;
      this.i.setText("");
      if (paramFeedStoryAttachment.b() != null)
        this.i.setText(paramFeedStoryAttachment.b().text);
      this.h.setVisibility(8);
      this.j.setImageResource(2130838207);
      this.j.setBackgroundResource(2130838202);
      this.j.setOnClickListener(new StoryAttachmentViewAddFriend.2(this, paramFeedStoryAttachment));
    }
  }

  public void a(FeedStoryAttachment paramFeedStoryAttachment, FeedStory paramFeedStory)
  {
    if ((paramFeedStoryAttachment.media != null) && (paramFeedStoryAttachment.media.image != null))
    {
      this.f.setVisibility(0);
      this.f.setImageParams(this.k.a(paramFeedStoryAttachment.media.image, FeedImageLoader.FeedImageType.AddFriend));
      if ((paramFeedStoryAttachment.target == null) || (StringUtil.a(paramFeedStoryAttachment.target.id)))
        break label125;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramFeedStoryAttachment.target.id;
      a(StringLocaleUtil.a("fb://profile/%s", arrayOfObject), paramFeedStory, null);
    }
    while (true)
    {
      this.g.setText(paramFeedStoryAttachment.title);
      setRequestedState(paramFeedStoryAttachment);
      return;
      this.f.setVisibility(8);
      break;
      label125: c();
    }
  }

  public StoryAttachmentView.StoryAttachmentViewType getViewType()
  {
    return StoryAttachmentView.StoryAttachmentViewType.ADD_FRIEND;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.attachments.StoryAttachmentViewAddFriend
 * JD-Core Version:    0.6.0
 */