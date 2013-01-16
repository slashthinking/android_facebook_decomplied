package com.facebook.feed.flyout;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import com.facebook.feed.data.FeedbackMutator;
import com.facebook.feed.util.FeedLinkifyUtil;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomRelativeLayout;
import java.util.List;

public class FeedFlyoutHeaderView extends CustomRelativeLayout
{
  public static final Class<?> a = FeedFlyoutHeaderView.class;
  private static long b = 85L;
  private static float c = 1.5F;
  private ImageButton d;
  private TextView e;
  private View f;
  private View g;
  private final FeedEventBus h;
  private final FeedLinkifyUtil i;
  private final FeedbackMutator j;
  private Feedback k;
  private final View.OnClickListener l;

  public FeedFlyoutHeaderView(Context paramContext)
  {
    this(paramContext, null);
  }

  public FeedFlyoutHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public FeedFlyoutHeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903216);
    FbInjector localFbInjector = getInjector();
    this.h = ((FeedEventBus)localFbInjector.a(FeedEventBus.class));
    this.i = ((FeedLinkifyUtil)localFbInjector.a(FeedLinkifyUtil.class));
    this.j = ((FeedbackMutator)localFbInjector.a(FeedbackMutator.class));
    a(new FeedFlyoutHeaderView.SetUpHeaderViewEventSubscriber(this, null));
    a(new FeedFlyoutHeaderView.LikeActionResultEventSubscriber(this, null));
    a(new FeedFlyoutHeaderView.LikeClickedEventSubscriber(this, null));
    d();
    this.d = ((ImageButton)b(2131296938));
    this.e = ((TextView)b(2131296940));
    this.f = b(2131296939);
    FeedFlyoutHeaderView.1 local1 = new FeedFlyoutHeaderView.1(this);
    this.d.setOnClickListener(local1);
    b(2131296937).setOnClickListener(local1);
    this.l = new FeedFlyoutHeaderView.2(this);
    this.e.setMovementMethod(LinkMovementMethod.getInstance());
    this.g = b(2131296941);
  }

  private void c()
  {
    this.f.setOnClickListener(null);
    this.g.setVisibility(8);
    GraphQLTextWithEntities localGraphQLTextWithEntities;
    if ((this.k.doesViewerLike) && (this.k.viewerLikersSentence != null))
    {
      localGraphQLTextWithEntities = this.k.viewerLikersSentence;
      if (localGraphQLTextWithEntities != null)
        break label131;
    }
    while (true)
    {
      return;
      if ((!this.k.doesViewerLike) && (this.k.viewerDoesNotLikeSentence != null))
      {
        localGraphQLTextWithEntities = this.k.viewerDoesNotLikeSentence;
        break;
      }
      if ((this.k.doesViewerLike) && (this.k.likeSentence != null))
      {
        localGraphQLTextWithEntities = this.k.likeSentence;
        break;
      }
      this.e.setText(getResources().getString(2131362081));
      continue;
      label131: Spannable localSpannable = this.i.b(localGraphQLTextWithEntities);
      if ((localGraphQLTextWithEntities.aggregatedRanges != null) && (localGraphQLTextWithEntities.aggregatedRanges.size() != 0))
      {
        this.f.setOnClickListener(this.l);
        this.e.setOnClickListener(this.l);
        this.g.setVisibility(0);
      }
      this.e.setText(localSpannable);
    }
  }

  private void setLikerButton(boolean paramBoolean)
  {
    ImageButton localImageButton = this.d;
    if (paramBoolean);
    for (int m = 2130838198; ; m = 2130838197)
    {
      localImageButton.setBackgroundResource(m);
      return;
    }
  }

  public void a(FlyoutParams paramFlyoutParams)
  {
    if (paramFlyoutParams == null);
    while (true)
    {
      return;
      this.k = FlyoutParams.a(paramFlyoutParams);
      this.d.setEnabled(this.k.canViewerLike);
      setLikerButton(this.k.doesViewerLike);
    }
  }

  protected FeedEventBus getEventBus()
  {
    return this.h;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.flyout.FeedFlyoutHeaderView
 * JD-Core Version:    0.6.0
 */