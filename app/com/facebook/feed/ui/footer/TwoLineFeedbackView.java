package com.facebook.feed.ui.footer;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.widget.TextView;
import com.facebook.R.styleable;
import com.facebook.feed.animation.CollapseAnimation;
import com.facebook.feed.animation.ExpandAnimation;
import com.facebook.feed.data.FeedStoryMutator;
import com.facebook.feed.prefs.FeedPrefKeys;
import com.facebook.feed.protocol.FeedbackLoggingParams;
import com.facebook.feed.renderer.FeedUnitViewStyle;
import com.facebook.feed.renderer.IFeedUnitRenderer;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.model.FeedStory;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.ScaleUpDownAnimation;
import com.nineoldandroids.view.ViewPropertyAnimator;

public class TwoLineFeedbackView extends CustomLinearLayout
{
  protected static final TwoLineFeedbackView.FeedbackBarType[] a;
  private static int b;
  private static int c;
  private final Context d;
  private final FeedEventBus e;
  private final FeedStoryMutator f;
  private final IFeedUnitRenderer g;
  private final boolean h;
  private FeedStory i;
  private final TwoLineFeedbackView.FeedbackBarType j;
  private final View k;
  private final View l;
  private final TextView m;
  private final TextView n;
  private final TextView o;
  private final View p;
  private final FeedbackActionButtonBar q;
  private Animation r;
  private CollapseAnimation s;
  private ViewPropertyAnimator t;

  static
  {
    TwoLineFeedbackView.FeedbackBarType[] arrayOfFeedbackBarType = new TwoLineFeedbackView.FeedbackBarType[3];
    arrayOfFeedbackBarType[0] = TwoLineFeedbackView.FeedbackBarType.DEFAULT_STORY;
    arrayOfFeedbackBarType[1] = TwoLineFeedbackView.FeedbackBarType.SUB_STORY;
    arrayOfFeedbackBarType[2] = TwoLineFeedbackView.FeedbackBarType.PERMALINK;
    a = arrayOfFeedbackBarType;
    b = -1;
    c = -1;
  }

  public TwoLineFeedbackView(Context paramContext)
  {
    this(paramContext, null);
  }

  public TwoLineFeedbackView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, null);
  }

  public TwoLineFeedbackView(Context paramContext, AttributeSet paramAttributeSet, TwoLineFeedbackView.FeedbackBarType paramFeedbackBarType)
  {
    super(paramContext, paramAttributeSet);
    if (paramFeedbackBarType != null)
    {
      this.j = paramFeedbackBarType;
      switch (TwoLineFeedbackView.4.a[this.j.ordinal()])
      {
      default:
      case 1:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      this.d = paramContext;
      FbInjector localFbInjector = getInjector();
      this.g = ((IFeedUnitRenderer)localFbInjector.a(IFeedUnitRenderer.class));
      this.e = ((FeedEventBus)localFbInjector.a(FeedEventBus.class));
      this.f = ((FeedStoryMutator)localFbInjector.a(FeedStoryMutator.class));
      this.h = ((OrcaSharedPreferences)localFbInjector.a(OrcaSharedPreferences.class)).a(FeedPrefKeys.b, true);
      a(new TwoLineFeedbackView.LikeUpdatedSubscriber(this, null));
      this.k = b(2131296827);
      this.l = b(2131296831);
      this.m = ((TextView)b(2131296828));
      this.n = ((TextView)b(2131296829));
      this.o = ((TextView)b(2131296830));
      this.p = b(2131296735);
      this.q = ((FeedbackActionButtonBar)b(2131296736));
      if (this.j == TwoLineFeedbackView.FeedbackBarType.PERMALINK)
      {
        b(2131296826).setVisibility(8);
        this.q.setDividerMargins(this.d.getResources().getDimensionPixelSize(2131230799));
      }
      return;
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TwoLineFeedbackView);
      int i1 = localTypedArray.getInt(0, -1);
      if (i1 == -1);
      for (TwoLineFeedbackView.FeedbackBarType localFeedbackBarType = TwoLineFeedbackView.FeedbackBarType.DEFAULT_STORY; ; localFeedbackBarType = a[i1])
      {
        this.j = localFeedbackBarType;
        localTypedArray.recycle();
        break;
      }
      setContentView(2130903187);
      continue;
      setContentView(2130903188);
      continue;
      setContentView(2130903160);
    }
  }

  private void a()
  {
    if ((this.r != null) && (!this.r.hasEnded()))
    {
      this.r.cancel();
      this.r = null;
    }
    if ((this.s != null) && (!this.s.hasEnded()))
    {
      this.s.cancel();
      this.s = null;
    }
    if (this.t != null)
    {
      this.t.a();
      d();
      this.t = null;
    }
  }

  private void b()
  {
    int i1 = this.i.m();
    if (i1 == 0)
      setCommentTextVisible(false);
    while (true)
    {
      return;
      setCommentTextVisible(true);
      TextView localTextView = this.o;
      Resources localResources = this.d.getResources();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(i1);
      localTextView.setText(localResources.getQuantityString(2131427344, i1, arrayOfObject));
    }
  }

  private void c()
  {
    this.t = ViewPropertyAnimator.a(this.m);
    if (this.i.m() <= 0);
    for (boolean bool = true; ; bool = false)
    {
      if (bool)
      {
        this.l.setVisibility(0);
        this.l.getLayoutParams().height = getBlingBarTextHeight();
      }
      this.t.a(new TwoLineFeedbackView.2(this, bool));
      this.t.a(170L);
      this.t.b(0.0F);
      this.t.c(0.0F);
      return;
    }
  }

  private void d()
  {
    e();
    ScaleUpDownAnimation.a(this.m, 1.1F, 85L, false, new TwoLineFeedbackView.3(this));
  }

  private void e()
  {
    if ((this.i.l() > 0) && (this.i.m() > 0))
      this.n.setVisibility(0);
    while (true)
    {
      return;
      this.n.setVisibility(8);
    }
  }

  private int getBlingBarTextHeight()
  {
    if (b < 0)
      b = this.d.getResources().getDimensionPixelSize(2131230797);
    return b;
  }

  private void setCommentTextVisible(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.o.setVisibility(0);
      this.k.setVisibility(0);
    }
    while (true)
    {
      return;
      if (this.i.l() == 0)
        this.k.setVisibility(8);
      this.o.setText("");
      this.o.setVisibility(8);
    }
  }

  private void setLikerTextVisible(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.m.setVisibility(0);
      this.k.setVisibility(0);
    }
    while (true)
    {
      return;
      if (this.i.m() == 0)
        this.k.setVisibility(8);
      this.m.setText("");
      this.m.setVisibility(8);
    }
  }

  public void a(FeedStory paramFeedStory, FeedUnitViewStyle paramFeedUnitViewStyle)
  {
    setVisibility(0);
    if (this.h)
      this.g.a(this.k, paramFeedStory.S(), new FeedbackLoggingParams(paramFeedStory.k(), "newsfeed_blingbar"), null);
    while (true)
    {
      this.i = paramFeedStory;
      this.q.a(paramFeedStory, paramFeedUnitViewStyle);
      if (this.p != null)
        this.p.setVisibility(this.q.getVisibility());
      a(false);
      b();
      return;
      this.g.b(this.k, paramFeedStory, null);
    }
  }

  public void a(boolean paramBoolean)
  {
    a();
    if (this.i.l() == 0)
      if (!paramBoolean)
        setLikerTextVisible(false);
    while (true)
    {
      if (!paramBoolean)
        e();
      return;
      c();
      continue;
      int i1 = this.i.l();
      if ((paramBoolean) && (this.i.D()))
      {
        this.l.getLayoutParams().height = 0;
        this.l.setVisibility(0);
        this.r = new ExpandAnimation(this.l, getBlingBarTextHeight());
        this.r.setDuration(200L);
        this.r.setAnimationListener(new TwoLineFeedbackView.1(this, i1));
        startAnimation(this.r);
        continue;
      }
      TextView localTextView = this.m;
      Resources localResources = this.d.getResources();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(i1);
      localTextView.setText(localResources.getQuantityString(2131427343, i1, arrayOfObject));
      setLikerTextVisible(true);
    }
  }

  protected FeedEventBus getEventBus()
  {
    return this.e;
  }

  public void setPermalinkFooterHasContent(boolean paramBoolean)
  {
    if (paramBoolean)
      this.q.setBackgroundResource(2130838224);
    while (true)
    {
      return;
      this.q.setBackgroundResource(2130838225);
    }
  }

  public void setSubstoryMargins(int paramInt)
  {
    if (this.j != TwoLineFeedbackView.FeedbackBarType.SUB_STORY);
    while (true)
    {
      return;
      if (c < 0)
        c = this.d.getResources().getDimensionPixelSize(2131230798);
      ViewGroup.MarginLayoutParams localMarginLayoutParams1 = (ViewGroup.MarginLayoutParams)this.q.getLayoutParams();
      localMarginLayoutParams1.leftMargin = paramInt;
      localMarginLayoutParams1.rightMargin = paramInt;
      this.q.setLayoutParams(localMarginLayoutParams1);
      ViewGroup.MarginLayoutParams localMarginLayoutParams2 = (ViewGroup.MarginLayoutParams)this.k.getLayoutParams();
      localMarginLayoutParams2.leftMargin = (paramInt - c);
      localMarginLayoutParams2.rightMargin = (paramInt - c);
      this.k.setLayoutParams(localMarginLayoutParams2);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.footer.TwoLineFeedbackView
 * JD-Core Version:    0.6.0
 */