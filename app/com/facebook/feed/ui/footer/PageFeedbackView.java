package com.facebook.feed.ui.footer;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.feed.data.FeedStoryMutator;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.GraphQLActionLink;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.orca.common.ui.util.TouchDelegateUtils;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.ScaleUpDownAnimation;

public class PageFeedbackView extends CustomLinearLayout
{
  private static long h = 85L;
  private static float i = 1.8F;
  private final FeedEventBus a;
  private final FeedStoryMutator b;
  private final LinearLayout c;
  private final ImageView d;
  private final TextView e;
  private final Context f;
  private FeedStory g;

  public PageFeedbackView(Context paramContext)
  {
    this(paramContext, null);
  }

  public PageFeedbackView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setContentView(2130903182);
    this.f = paramContext;
    FbInjector localFbInjector = getInjector();
    this.a = ((FeedEventBus)localFbInjector.a(FeedEventBus.class));
    this.b = ((FeedStoryMutator)localFbInjector.a(FeedStoryMutator.class));
    this.c = ((LinearLayout)b(2131296816));
    this.d = ((ImageView)b(2131296817));
    this.e = ((TextView)b(2131296818));
    this.c.setOnTouchListener(new PageFeedbackView.1(this));
  }

  private void a(GraphQLProfile paramGraphQLProfile, boolean paramBoolean)
  {
    if (paramGraphQLProfile.doesViewerLike)
    {
      this.d.setImageResource(2130839008);
      this.e.setText(2131362115);
      this.e.setTextColor(this.f.getResources().getColor(2131165290));
      if (paramBoolean)
        ScaleUpDownAnimation.a(this.d, i, h, true);
    }
    while (true)
    {
      return;
      this.d.setImageResource(2130839007);
      this.e.setText(2131362114);
      this.e.setTextColor(this.f.getResources().getColor(2131165289));
    }
  }

  public void a(FeedStory paramFeedStory)
  {
    this.g = paramFeedStory;
    GraphQLProfile localGraphQLProfile = paramFeedStory.f().page;
    if (localGraphQLProfile == null);
    while (true)
    {
      return;
      a(localGraphQLProfile, false);
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    setTouchDelegate(TouchDelegateUtils.a(this.c, 0, getMeasuredHeight(), 30));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.footer.PageFeedbackView
 * JD-Core Version:    0.6.0
 */