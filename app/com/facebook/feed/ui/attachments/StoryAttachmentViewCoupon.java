package com.facebook.feed.ui.attachments;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.TouchDelegate;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.feed.prefs.FeedRendererOptions;
import com.facebook.feed.ui.DepthAwareView;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedStoryAttachment;
import com.facebook.graphql.model.GraphQLActionLink;
import com.facebook.graphql.model.GraphQLCoupon;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.orca.common.ui.util.TouchDelegateUtils;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.UrlImage;
import java.text.NumberFormat;
import java.util.List;

public class StoryAttachmentViewCoupon extends StoryAttachmentView
  implements DepthAwareView
{
  private static final Class<?> e = StoryAttachmentViewCoupon.class;
  private final UrlImage f;
  private final TextView g;
  private final TextView h;
  private final TextView i;
  private final TextView j;
  private final TextView k;
  private final RelativeLayout l;
  private FeedStoryAttachment m;
  private boolean n = false;
  private final FeedRendererOptions o;

  public StoryAttachmentViewCoupon(Context paramContext)
  {
    this(paramContext, null);
  }

  public StoryAttachmentViewCoupon(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setContentView(2130903166);
    this.f = ((UrlImage)b(2131296753));
    this.f.setPlaceHolderDrawable(null);
    this.f.setPlaceholderBackgroundResourceId(2131165264);
    this.g = ((TextView)b(2131296754));
    this.h = ((TextView)b(2131296755));
    this.i = ((TextView)b(2131296758));
    this.o = ((FeedRendererOptions)getInjector().a(FeedRendererOptions.class));
    this.f.setLoadResolutionDuringScroll(this.o.d);
    this.j = ((TextView)b(2131296759));
    this.k = ((TextView)b(2131296760));
    this.l = ((RelativeLayout)b(2131296757));
  }

  public static boolean a(FeedStoryAttachment paramFeedStoryAttachment)
  {
    if ((paramFeedStoryAttachment.actionLinks != null) && (!paramFeedStoryAttachment.actionLinks.isEmpty()))
    {
      GraphQLActionLink localGraphQLActionLink = (GraphQLActionLink)paramFeedStoryAttachment.actionLinks.get(0);
      if ((localGraphQLActionLink != null) && (localGraphQLActionLink.coupon != null))
      {
        GraphQLCoupon localGraphQLCoupon = localGraphQLActionLink.coupon;
        if ((!localGraphQLCoupon.isActive) && (!localGraphQLCoupon.isExpired) && (!localGraphQLCoupon.isStopped));
      }
    }
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public void a(FeedStoryAttachment paramFeedStoryAttachment, FeedStory paramFeedStory)
  {
    GraphQLCoupon localGraphQLCoupon = ((GraphQLActionLink)paramFeedStoryAttachment.actionLinks.get(0)).coupon;
    if (this.m == paramFeedStoryAttachment)
      if (localGraphQLCoupon.hasViewerClaimed)
      {
        this.i.setText(2131362090);
        this.i.setOnTouchListener(new StoryAttachmentViewCoupon.ClaimListener(this, localGraphQLCoupon, "resend"));
      }
    while (true)
    {
      return;
      this.i.setText(2131362089);
      this.i.setOnTouchListener(new StoryAttachmentViewCoupon.ClaimListener(this, localGraphQLCoupon, "claim"));
      continue;
      this.m = paramFeedStoryAttachment;
      this.n = false;
      if ((paramFeedStoryAttachment.media != null) && (paramFeedStoryAttachment.media.image != null) && (this.o.a))
      {
        this.f.setVisibility(0);
        this.f.setImageParams(Uri.parse(paramFeedStoryAttachment.media.image.uri));
        label155: this.g.setText(paramFeedStoryAttachment.title);
        if (localGraphQLCoupon.claimCount <= 0)
          break label267;
        String str = NumberFormat.getInstance().format(localGraphQLCoupon.claimCount);
        this.h.setText(getContext().getString(2131362088, new Object[] { str }));
      }
      while (true)
      {
        if (!localGraphQLCoupon.isActive)
          break label309;
        if (!localGraphQLCoupon.hasViewerClaimed)
          break label279;
        this.i.setText(2131362090);
        this.i.setOnTouchListener(new StoryAttachmentViewCoupon.ClaimListener(this, localGraphQLCoupon, "resend"));
        break;
        this.f.setVisibility(8);
        break label155;
        label267: this.h.setText(2131362092);
      }
      label279: this.i.setText(2131362089);
      this.i.setOnTouchListener(new StoryAttachmentViewCoupon.ClaimListener(this, localGraphQLCoupon, "claim"));
      continue;
      label309: this.i.setText(2131362091);
      this.i.setTextColor(getResources().getColor(2131165254));
    }
  }

  public StoryAttachmentView.StoryAttachmentViewType getViewType()
  {
    return StoryAttachmentView.StoryAttachmentViewType.COUPON;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    TouchDelegate localTouchDelegate = TouchDelegateUtils.a(this.i, 0, this.l.getMeasuredHeight(), 48);
    this.l.setTouchDelegate(localTouchDelegate);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.attachments.StoryAttachmentViewCoupon
 * JD-Core Version:    0.6.0
 */