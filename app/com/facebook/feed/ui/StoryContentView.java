package com.facebook.feed.ui;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.feed.flyout.FlyoutClickSource;
import com.facebook.feed.prefs.FeedRendererOptions;
import com.facebook.feed.renderer.FeedUnitViewStyle;
import com.facebook.feed.renderer.IFeedUnitRenderer;
import com.facebook.feed.ui.attachments.StoryAttachmentsSection;
import com.facebook.feed.ui.footer.StoryFooterSection;
import com.facebook.feed.ui.location.StoryLocationSection;
import com.facebook.feed.util.FeedUtils;
import com.facebook.graphql.model.FeedStory;
import com.facebook.orca.inject.FbInjector;
import com.facebook.task.IncrementalTaskExecutor;
import com.facebook.widget.CustomLinearLayout;
import java.util.List;

public class StoryContentView extends CustomLinearLayout
  implements DepthAwareView
{
  private final Context a;
  private final IFeedUnitRenderer b;
  private final View c;
  private final View d;
  private final View e;
  private final StoryExplanationSection f;
  private final StoryHeaderSection g;
  private final StoryAttachmentsSection h;
  private final StoryLocationSection i;
  private final FeedRendererOptions j;
  private FeedStory k;
  private final StoryFooterSection l;
  private final TextView m;
  private AttachedStoryViewStub n;
  private AttachedStoryView o;
  private final FeedSubstoriesSection p;
  private final IncrementalTaskExecutor q;
  private final StoryContentView.IncrementalBindModelTask r;

  public StoryContentView(Context paramContext)
  {
    this(paramContext, null);
  }

  public StoryContentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    setContentView(2130903169);
    setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    setOrientation(1);
    setClipChildren(true);
    setClipToPadding(true);
    FbInjector localFbInjector = getInjector();
    this.b = ((IFeedUnitRenderer)localFbInjector.a(IFeedUnitRenderer.class));
    this.q = ((IncrementalTaskExecutor)localFbInjector.a(IncrementalTaskExecutor.class));
    this.j = ((FeedRendererOptions)localFbInjector.a(FeedRendererOptions.class));
    this.c = b(2131296765);
    this.d = b(2131296775);
    this.e = b(2131296764);
    this.f = ((StoryExplanationSection)b(2131296766));
    this.g = ((StoryHeaderSection)b(2131296767));
    this.l = ((StoryFooterSection)b(2131296774));
    this.h = ((StoryAttachmentsSection)b(2131296769));
    this.i = ((StoryLocationSection)b(2131296770));
    this.m = ((TextView)b(2131296768));
    this.m.setTag(2131296266, FlyoutClickSource.MESSAGE);
    this.m.setMovementMethod(LinkMovementMethod.getInstance());
    this.n = ((AttachedStoryViewStub)b(2131296771));
    this.o = null;
    this.p = ((FeedSubstoriesSection)b(2131296773));
    this.r = new StoryContentView.IncrementalBindModelTask(this);
  }

  public void a()
  {
    if (this.o == null)
    {
      this.o = ((AttachedStoryView)this.n.a());
      this.n = null;
    }
  }

  public void a(int paramInt)
  {
    FeedUtils.a(this.a, this.m, paramInt, 0);
  }

  public void a(FeedStory paramFeedStory, FeedUnitViewStyle paramFeedUnitViewStyle)
  {
    a(paramFeedStory, paramFeedUnitViewStyle, false);
  }

  public void a(FeedStory paramFeedStory, FeedUnitViewStyle paramFeedUnitViewStyle, boolean paramBoolean)
  {
    this.k = paramFeedStory;
    this.r.a(paramFeedStory, paramFeedUnitViewStyle, paramBoolean);
    this.q.b(this.r);
  }

  public void b()
  {
    this.o.a(true);
  }

  public void c()
  {
    this.o.a(false);
  }

  public View getDefaultMenuButton()
  {
    return this.g.getMenuButtonView();
  }

  public View getExplanationSectionMenuButton()
  {
    return this.f.getMenuButtonView();
  }

  protected List<SubStoryView> getSubstoryViews()
  {
    if (this.p == null);
    for (List localList = null; ; localList = this.p.getSubstoryViews())
      return localList;
  }

  public void setPermalinkHasContentBelowStory(boolean paramBoolean)
  {
    if (paramBoolean)
      setBackgroundResource(2130838227);
    while (true)
    {
      this.d.setVisibility(8);
      this.l.setPermalinkFooterHasContent(paramBoolean);
      return;
      setBackgroundResource(2130838235);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.StoryContentView
 * JD-Core Version:    0.6.0
 */