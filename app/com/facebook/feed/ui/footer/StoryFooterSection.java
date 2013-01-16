package com.facebook.feed.ui.footer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.feed.protocol.UFIService;
import com.facebook.feed.renderer.FeedUnitViewStyle;
import com.facebook.feed.ui.DepthAwareView;
import com.facebook.feed.util.FeedUtils;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedStory.PageStoryType;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;

public class StoryFooterSection extends CustomLinearLayout
  implements DepthAwareView
{
  private final View a;
  private final View b;
  private final TwoLineFeedbackView c;
  private final TwoLineFeedbackView d;
  private TwoLineFeedbackView e;
  private TwoLineFeedbackViewStub f;
  private final PageFeedbackView g;
  private final StoryInsightsFooterView h;
  private final FriendStoryFeedbackView i;
  private final UFIService j;
  private AndroidThreadUtil k;
  private final Context l;

  public StoryFooterSection(Context paramContext)
  {
    this(paramContext, null);
  }

  public StoryFooterSection(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    FbInjector localFbInjector = getInjector();
    this.j = ((UFIService)localFbInjector.a(UFIService.class));
    this.k = ((AndroidThreadUtil)localFbInjector.a(AndroidThreadUtil.class));
    this.l = paramContext;
    setContentView(2130903173);
    this.a = b(2131296790);
    this.b = b(2131296692);
    this.c = ((TwoLineFeedbackView)b(2131296795));
    this.d = ((TwoLineFeedbackView)b(2131296791));
    this.f = ((TwoLineFeedbackViewStub)b(2131296796));
    this.e = null;
    this.g = ((PageFeedbackView)b(2131296792));
    StoryFooterSection.1 local1 = new StoryFooterSection.1(this);
    this.h = ((StoryInsightsFooterView)b(2131296793));
    this.h.setViewInsightsListener(local1);
    this.i = ((FriendStoryFeedbackView)b(2131296794));
  }

  private void a(FeedStory paramFeedStory)
  {
    a(paramFeedStory.t());
    this.a.setVisibility(0);
    this.b.setVisibility(0);
    this.g.setVisibility(0);
    this.c.setVisibility(8);
    this.d.setVisibility(8);
    this.h.setVisibility(8);
    this.i.setVisibility(8);
    if (this.e != null)
      this.e.setVisibility(8);
    this.g.a(paramFeedStory);
  }

  private void b()
  {
    this.a.setVisibility(0);
    this.b.setVisibility(8);
    this.c.setVisibility(8);
    this.g.setVisibility(8);
    this.d.setVisibility(8);
    this.h.setVisibility(8);
    this.i.setVisibility(8);
    if (this.e != null)
      this.e.setVisibility(8);
  }

  private void b(FeedStory paramFeedStory)
  {
    a(paramFeedStory.t());
    this.a.setVisibility(0);
    this.b.setVisibility(0);
    this.g.setVisibility(8);
    this.c.setVisibility(8);
    this.d.setVisibility(8);
    this.h.setVisibility(8);
    this.i.setVisibility(0);
    if (this.e != null)
      this.e.setVisibility(8);
    this.i.a(paramFeedStory);
  }

  private void b(FeedStory paramFeedStory, FeedUnitViewStyle paramFeedUnitViewStyle)
  {
    a(paramFeedStory.t());
    this.b.setVisibility(8);
    this.c.setVisibility(0);
    this.g.setVisibility(8);
    this.d.setVisibility(8);
    this.i.setVisibility(8);
    if (this.e != null)
      this.e.setVisibility(8);
    this.c.a(paramFeedStory, paramFeedUnitViewStyle);
    this.h.a(paramFeedStory);
  }

  private void c(FeedStory paramFeedStory)
  {
    a();
    a(paramFeedStory.t());
    this.b.setVisibility(8);
    this.c.setVisibility(8);
    this.g.setVisibility(8);
    this.d.setVisibility(8);
    this.i.setVisibility(8);
    this.h.setVisibility(8);
    this.e.setVisibility(0);
    this.e.a(paramFeedStory, FeedUnitViewStyle.PERMALINK_STORY);
  }

  private void c(FeedStory paramFeedStory, FeedUnitViewStyle paramFeedUnitViewStyle)
  {
    this.b.setVisibility(8);
    this.c.setVisibility(8);
    this.g.setVisibility(8);
    this.h.setVisibility(8);
    this.d.setVisibility(0);
    this.i.setVisibility(8);
    if (this.e != null)
      this.e.setVisibility(8);
    this.d.a(paramFeedStory, paramFeedUnitViewStyle);
    this.d.setSubstoryMargins(FeedUtils.a(this.l, paramFeedStory.t()));
  }

  public void a()
  {
    if (this.e == null)
    {
      this.e = ((TwoLineFeedbackView)this.f.a());
      this.e.setOrientation(1);
      this.f = null;
    }
  }

  public void a(int paramInt)
  {
    FeedUtils.a(this.l, this, paramInt, 0);
  }

  public void a(FeedStory paramFeedStory, FeedUnitViewStyle paramFeedUnitViewStyle)
  {
    if (paramFeedStory.A() == FeedStory.PageStoryType.PAGE_LIKE)
      a(paramFeedStory);
    while (true)
    {
      return;
      if (paramFeedStory.i())
      {
        b(paramFeedStory);
        continue;
      }
      if (paramFeedStory.n())
      {
        this.a.setVisibility(8);
        if (paramFeedUnitViewStyle.equals(FeedUnitViewStyle.SUBSTORY))
        {
          c(paramFeedStory, paramFeedUnitViewStyle);
          continue;
        }
        if (paramFeedUnitViewStyle.equals(FeedUnitViewStyle.PERMALINK_STORY))
        {
          c(paramFeedStory);
          continue;
        }
        b(paramFeedStory, paramFeedUnitViewStyle);
        continue;
      }
      b();
    }
  }

  public void setPermalinkFooterHasContent(boolean paramBoolean)
  {
    if ((this.e == null) || (this.e.getVisibility() != 0));
    while (true)
    {
      return;
      this.e.setPermalinkFooterHasContent(paramBoolean);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.footer.StoryFooterSection
 * JD-Core Version:    0.6.0
 */