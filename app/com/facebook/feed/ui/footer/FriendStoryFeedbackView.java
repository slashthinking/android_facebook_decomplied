package com.facebook.feed.ui.footer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.graphql.model.FeedStory;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;

public class FriendStoryFeedbackView extends CustomLinearLayout
{
  private final Context a;
  private final IFeedIntentBuilder b;

  public FriendStoryFeedbackView(Context paramContext)
  {
    this(paramContext, null);
  }

  public FriendStoryFeedbackView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setContentView(2130903174);
    this.a = paramContext;
    this.b = ((IFeedIntentBuilder)getInjector().a(IFeedIntentBuilder.class));
    setOnClickListener(getFindFriendsClickListener());
  }

  private View.OnClickListener getFindFriendsClickListener()
  {
    return new FriendStoryFeedbackView.1(this);
  }

  public void a(FeedStory paramFeedStory)
  {
    setVisibility(0);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.footer.FriendStoryFeedbackView
 * JD-Core Version:    0.6.0
 */