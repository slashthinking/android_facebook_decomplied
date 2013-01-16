package com.facebook.feed.ui.ego;

import android.content.Context;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.protocol.UFIService;
import com.facebook.feed.renderer.IFeedUnitRenderer;
import com.facebook.feed.ui.FeedImageLoader;
import com.facebook.feed.ui.FeedImageLoader.FeedImageType;
import com.facebook.feed.util.FeedLinkifyUtil;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.PagesYouMayLikeFeedUnitItem;
import com.facebook.orca.common.ui.util.TouchDelegateUtils;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.ScaleUpDownAnimation;
import com.facebook.widget.UrlImage;

public class PagesYouMayLikeFeedUnitItemView extends CustomLinearLayout
{
  private static long o = 85L;
  private static float p = 1.8F;
  private Context a;
  private final UrlImage b;
  private final TextView c;
  private final TextView d;
  private final ImageView e;
  private final TextView f;
  private final View g;
  private View h;
  private final UFIService i;
  private final AndroidThreadUtil j;
  private final FeedLinkifyUtil k;
  private final IFeedUnitRenderer l;
  private final NewsFeedAnalyticsEventBuilder m;
  private final AnalyticsLogger n;
  private final String q;
  private final FeedImageLoader r;

  public PagesYouMayLikeFeedUnitItemView(Context paramContext)
  {
    this(paramContext, null);
  }

  public PagesYouMayLikeFeedUnitItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    setContentView(2130903238);
    FbInjector localFbInjector = getInjector();
    this.i = ((UFIService)localFbInjector.a(UFIService.class));
    this.j = ((AndroidThreadUtil)localFbInjector.a(AndroidThreadUtil.class));
    this.r = ((FeedImageLoader)localFbInjector.a(FeedImageLoader.class));
    this.k = ((FeedLinkifyUtil)localFbInjector.a(FeedLinkifyUtil.class));
    this.l = ((IFeedUnitRenderer)localFbInjector.a(IFeedUnitRenderer.class));
    this.m = ((NewsFeedAnalyticsEventBuilder)localFbInjector.a(NewsFeedAnalyticsEventBuilder.class));
    this.n = ((AnalyticsLogger)localFbInjector.a(AnalyticsLogger.class));
    this.b = ((UrlImage)b(2131296995));
    this.c = ((TextView)b(2131296997));
    this.d = ((TextView)b(2131296998));
    this.d.setMovementMethod(LinkMovementMethod.getInstance());
    this.e = ((ImageView)b(2131297000));
    this.f = ((TextView)b(2131296999));
    this.g = b(2131296994);
    this.h = b(2131296993);
    this.q = this.a.getString(2131362085);
  }

  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.e.setImageResource(2130838211);
      if (paramBoolean2)
        ScaleUpDownAnimation.a(this.e, p, o, true);
    }
    while (true)
    {
      return;
      this.e.setImageResource(2130838210);
    }
  }

  public void a()
  {
    this.g.setVisibility(0);
  }

  public void a(PagesYouMayLikeFeedUnitItem paramPagesYouMayLikeFeedUnitItem)
  {
    label137: label163: ImageView localImageView;
    if (paramPagesYouMayLikeFeedUnitItem.page.c())
    {
      this.b.setVisibility(0);
      this.b.setImageParams(this.r.a(paramPagesYouMayLikeFeedUnitItem.page.profilePicture, FeedImageLoader.FeedImageType.PagesYouMayLike));
      this.c.setText(paramPagesYouMayLikeFeedUnitItem.page.name);
      HoneyClientEvent localHoneyClientEvent = this.m.e(paramPagesYouMayLikeFeedUnitItem.a());
      this.l.a(this.c, paramPagesYouMayLikeFeedUnitItem.page, localHoneyClientEvent);
      this.l.a(this.h, paramPagesYouMayLikeFeedUnitItem.page, localHoneyClientEvent);
      this.k.a(paramPagesYouMayLikeFeedUnitItem);
      Spannable localSpannable = paramPagesYouMayLikeFeedUnitItem.b();
      if (localSpannable == null)
        break label239;
      this.d.setText(localSpannable);
      this.d.setVisibility(0);
      if (paramPagesYouMayLikeFeedUnitItem.sponsoredData == null)
        break label251;
      this.f.setText(this.q);
      this.f.setVisibility(0);
      a(paramPagesYouMayLikeFeedUnitItem.page.doesViewerLike, false);
      this.e.setBackgroundDrawable(null);
      localImageView = this.e;
      if (!paramPagesYouMayLikeFeedUnitItem.page.doesViewerLike)
        break label263;
    }
    label263: for (int i1 = 2130838211; ; i1 = 2130838210)
    {
      localImageView.setImageResource(i1);
      this.e.setOnClickListener(new PagesYouMayLikeFeedUnitItemView.1(this, paramPagesYouMayLikeFeedUnitItem));
      return;
      this.b.setVisibility(8);
      break;
      label239: this.d.setVisibility(8);
      break label137;
      label251: this.f.setVisibility(8);
      break label163;
    }
  }

  public void b()
  {
    this.g.setVisibility(8);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      TouchDelegate localTouchDelegate = TouchDelegateUtils.a(this.e, 12);
      this.h.setTouchDelegate(localTouchDelegate);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.ego.PagesYouMayLikeFeedUnitItemView
 * JD-Core Version:    0.6.0
 */