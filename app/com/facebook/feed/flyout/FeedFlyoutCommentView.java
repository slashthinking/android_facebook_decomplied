package com.facebook.feed.flyout;

import android.content.Context;
import android.net.Uri;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.common.util.DefaultTimeFormatUtil;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.common.util.TimeFormatUtil.TimeFormatStyle;
import com.facebook.feed.renderer.IFeedUnitRenderer;
import com.facebook.feed.util.FeedLinkifyUtil;
import com.facebook.feed.util.FeedUtils;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.FlyoutEvents.CommentLikeClickedEvent;
import com.facebook.feed.util.event.FlyoutEvents.SwitchInlineCommentLikersEvent;
import com.facebook.graphql.model.FeedComment;
import com.facebook.graphql.model.FeedOptimisticPublishState;
import com.facebook.graphql.model.FeedStoryLikers;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLProfileCache;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.UrlImage;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;

public class FeedFlyoutCommentView extends CustomRelativeLayout
{
  public static final Class<?> a = FeedFlyoutCommentView.class;
  private final UrlImage b;
  private final TextView c;
  private final TextView d;
  private final TextView e;
  private final TextView f;
  private final TextView g;
  private final TextView h;
  private final ImageView i;
  private final TextView j;
  private final View k;
  private final View l;
  private final IFeedUnitRenderer m;
  private final FeedLinkifyUtil n;
  private final FeedEventBus o;
  private final FbErrorReporter p;
  private final GraphQLProfile q;
  private FeedComment r;

  public FeedFlyoutCommentView(Context paramContext)
  {
    this(paramContext, null);
  }

  public FeedFlyoutCommentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public FeedFlyoutCommentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903215);
    this.b = ((UrlImage)b(2131296926));
    this.c = ((TextView)b(2131296927));
    this.c.setMovementMethod(LinkMovementMethod.getInstance());
    this.d = ((TextView)b(2131296928));
    this.e = ((TextView)b(2131296929));
    this.f = ((TextView)b(2131296930));
    this.g = ((TextView)b(2131296932));
    this.h = ((TextView)b(2131296933));
    this.i = ((ImageView)b(2131296935));
    this.j = ((TextView)b(2131296936));
    this.l = b(2131296934);
    this.k = b(2131296931);
    FeedFlyoutCommentView.1 local1 = new FeedFlyoutCommentView.1(this);
    this.i.setOnClickListener(local1);
    this.j.setOnClickListener(local1);
    this.l.setOnClickListener(local1);
    this.k.setOnClickListener(new FeedFlyoutCommentView.2(this));
    this.d.setMovementMethod(LinkMovementMethod.getInstance());
    FbInjector localFbInjector = FbInjector.a(paramContext);
    this.m = ((IFeedUnitRenderer)localFbInjector.a(IFeedUnitRenderer.class));
    this.n = ((FeedLinkifyUtil)localFbInjector.a(FeedLinkifyUtil.class));
    this.o = ((FeedEventBus)localFbInjector.a(FeedEventBus.class));
    this.q = ((GraphQLProfileCache)localFbInjector.a(GraphQLProfileCache.class)).a();
    this.p = ((FbErrorReporter)localFbInjector.a(FbErrorReporter.class));
    a(new FeedFlyoutCommentView.CommentLikeActionResultEventSubscriber(this, null));
  }

  private void a()
  {
    TextView localTextView = this.g;
    if (this.r.S().doesViewerLike);
    for (String str = getContext().getString(2131362076); ; str = getContext().getString(2131362075))
    {
      localTextView.setText(str);
      return;
    }
  }

  private void a(View paramView)
  {
    Preconditions.checkNotNull(paramView);
    paramView.setVisibility(8);
  }

  private void b()
  {
    a(this.f);
    a(this.g);
    a(this.h);
    a(this.i);
    a(this.j);
    a(this.f);
    a(this.l);
  }

  private boolean b(FeedComment paramFeedComment)
  {
    if (paramFeedComment == null)
    {
      b();
      this.p.a("FeedFlyoutCommentView", "comment cannot be null");
    }
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  private void c()
  {
    Feedback localFeedback = this.r.S();
    if ((!localFeedback.doesViewerLike) && ((localFeedback == null) || (localFeedback.likers == null) || (localFeedback.a() == 0)))
    {
      this.h.setVisibility(8);
      this.i.setVisibility(8);
      this.j.setVisibility(8);
      this.j.setText("");
      this.l.setVisibility(8);
    }
    while (true)
    {
      return;
      this.h.setVisibility(0);
      this.i.setVisibility(0);
      this.j.setVisibility(0);
      this.l.setVisibility(0);
      if ((localFeedback.doesViewerLike) && (localFeedback.likers == null))
      {
        this.j.setText("1");
        continue;
      }
      this.j.setText(String.valueOf(localFeedback.a()));
    }
  }

  private void f()
  {
    if (this.r == null);
    while (true)
    {
      return;
      this.o.a(new FlyoutEvents.CommentLikeClickedEvent(this.r));
    }
  }

  private void g()
  {
    Feedback localFeedback = this.r.S();
    if ((!localFeedback.doesViewerLike) && (localFeedback.likers == null))
      return;
    if ((localFeedback.likers != null) && (localFeedback.likers.likers != null) && (!localFeedback.likers.likers.isEmpty()));
    for (Object localObject = localFeedback.likers.likers; ; localObject = ImmutableList.d())
    {
      this.o.a(new FlyoutEvents.SwitchInlineCommentLikersEvent(FeedUtils.a(this.r.S().doesViewerLike, this.q, (List)localObject)));
      break;
    }
  }

  private void setupCommentLikeAnimation(FeedComment paramFeedComment)
  {
    if (paramFeedComment.c() == FeedOptimisticPublishState.POSTING)
    {
      this.f.setVisibility(0);
      this.g.setVisibility(0);
    }
    View[] arrayOfView = new View[2];
    arrayOfView[0] = this.f;
    arrayOfView[1] = this.g;
    FeedUtils.a(paramFeedComment, 0.0F, arrayOfView);
  }

  public void a(FeedComment paramFeedComment)
  {
    if (b(paramFeedComment))
      return;
    this.r = paramFeedComment;
    if (paramFeedComment.author == null)
    {
      this.b.setImageParams(null, null);
      this.c.setText("");
      this.b.setOnClickListener(null);
    }
    while (true)
    {
      Spannable localSpannable = this.n.a(paramFeedComment.body);
      this.d.setText(localSpannable);
      this.e.setText(DefaultTimeFormatUtil.a(getContext(), TimeFormatUtil.TimeFormatStyle.STREAM_RELATIVE_STYLE, 1000L * paramFeedComment.createdTime));
      b();
      setupCommentLikeAnimation(paramFeedComment);
      Feedback localFeedback = paramFeedComment.S();
      if ((localFeedback == null) || ((!localFeedback.canViewerLike) && (localFeedback.likers == null)))
        break;
      if (localFeedback.canViewerLike)
      {
        this.f.setVisibility(0);
        this.g.setVisibility(0);
        a();
      }
      c();
      break;
      if (paramFeedComment.author.profilePicture != null)
        this.b.setImageParams(Uri.parse(paramFeedComment.author.profilePicture.uri));
      this.c.setText(this.n.a(paramFeedComment.author, 2131165254));
      this.m.a(this.b, paramFeedComment.author, null);
    }
  }

  protected FeedEventBus getEventBus()
  {
    return this.o;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.flyout.FeedFlyoutCommentView
 * JD-Core Version:    0.6.0
 */