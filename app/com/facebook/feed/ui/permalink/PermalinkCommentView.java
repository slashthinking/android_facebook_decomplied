package com.facebook.feed.ui.permalink;

import android.content.Context;
import android.net.Uri;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.TouchDelegate;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.common.util.DefaultTimeFormatUtil;
import com.facebook.common.util.TimeFormatUtil.TimeFormatStyle;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.feed.renderer.IFeedUnitRenderer;
import com.facebook.feed.util.FeedLinkifyUtil;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.model.FeedComment;
import com.facebook.graphql.model.FeedOptimisticPublishState;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLProfileCache;
import com.facebook.orca.common.ui.util.CompoundTouchDelegate;
import com.facebook.orca.common.ui.util.TouchDelegateUtils;
import com.facebook.orca.common.util.SizeUtil;
import com.facebook.orca.images.FetchImageParams;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.UrlImage;

public class PermalinkCommentView extends CustomLinearLayout
{
  private final TextView a;
  private final UrlImage b;
  private final TextView c;
  private final TextView d;
  private final TextView e;
  private final TextView f;
  private final TextView g;
  private final LinearLayout h;
  private final ImageView i;
  private final TextView j;
  private final Context k;
  private final FeedLinkifyUtil l;
  private final IFeedUnitRenderer m;
  private final IFeedIntentBuilder n;
  private final GraphQLProfile o;
  private final FeedEventBus p;
  private FeedComment q;
  private String r;

  public PermalinkCommentView(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet);
    if (paramBoolean)
      setContentView(2130903155);
    while (true)
    {
      setOrientation(1);
      this.a = ((TextView)b(2131296716));
      this.b = ((UrlImage)b(2131296715));
      this.c = ((TextView)b(2131296717));
      this.d = ((TextView)b(2131296718));
      this.e = ((TextView)b(2131296720));
      this.f = ((TextView)b(2131296719));
      this.g = ((TextView)b(2131296721));
      this.h = ((LinearLayout)b(2131296722));
      this.i = ((ImageView)b(2131296723));
      this.j = ((TextView)b(2131296724));
      this.a.setMovementMethod(LinkMovementMethod.getInstance());
      this.c.setMovementMethod(LinkMovementMethod.getInstance());
      this.k = paramContext;
      FbInjector localFbInjector = getInjector();
      this.l = ((FeedLinkifyUtil)localFbInjector.a(FeedLinkifyUtil.class));
      this.m = ((IFeedUnitRenderer)localFbInjector.a(IFeedUnitRenderer.class));
      this.n = ((IFeedIntentBuilder)localFbInjector.a(IFeedIntentBuilder.class));
      this.o = ((GraphQLProfileCache)localFbInjector.a(GraphQLProfileCache.class)).a();
      this.p = ((FeedEventBus)localFbInjector.a(FeedEventBus.class));
      return;
      setContentView(2130903156);
    }
  }

  public PermalinkCommentView(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, null, paramBoolean);
  }

  private void a()
  {
    this.g.setVisibility(0);
    this.i.setVisibility(0);
    this.j.setVisibility(0);
  }

  private void b()
  {
    this.g.setVisibility(8);
    this.i.setVisibility(8);
    this.j.setVisibility(8);
  }

  private void c()
  {
    this.f.setVisibility(0);
    this.e.setVisibility(0);
  }

  private void d()
  {
    this.f.setVisibility(8);
    this.e.setVisibility(8);
  }

  private void e()
  {
    Feedback localFeedback;
    int i1;
    if (this.q == null)
    {
      localFeedback = null;
      if (localFeedback != null)
      {
        TextView localTextView = this.e;
        if (!localFeedback.doesViewerLike)
          break label94;
        i1 = 2131362076;
        label29: localTextView.setText(i1);
      }
      if ((localFeedback == null) || (localFeedback.a() <= 0))
        break label101;
      a();
      this.j.setText(Integer.toString(localFeedback.a()));
      PermalinkCommentView.2 local2 = new PermalinkCommentView.2(this, localFeedback);
      this.h.setOnClickListener(local2);
    }
    while (true)
    {
      return;
      localFeedback = this.q.S();
      break;
      label94: i1 = 2131362075;
      break label29;
      label101: b();
      this.h.setOnClickListener(null);
    }
  }

  public void a(String paramString, FeedComment paramFeedComment)
  {
    this.r = paramString;
    this.q = paramFeedComment;
    this.c.setText(this.l.a(this.q.body));
    FeedOptimisticPublishState localFeedOptimisticPublishState;
    if (this.q.author != null)
    {
      this.a.setVisibility(0);
      this.a.setText(this.l.a(this.q.author, 2131165274));
      if (this.q.author.profilePicture != null)
      {
        this.b.setImageParams(Uri.parse(this.q.author.profilePicture.uri));
        String str = this.l.a(this.q.author.objectType, this.q.author.id);
        if (str != null)
          this.m.a(this.b, str, null);
      }
      else
      {
        localFeedOptimisticPublishState = paramFeedComment.c();
        if (localFeedOptimisticPublishState != FeedOptimisticPublishState.POSTING)
          break label232;
        this.d.setText(2131362144);
        b();
        d();
      }
    }
    while (true)
    {
      return;
      this.b.setOnClickListener(null);
      break;
      this.a.setVisibility(8);
      this.a.setText("");
      this.b.setImageParams((FetchImageParams)null);
      break;
      label232: if (localFeedOptimisticPublishState == FeedOptimisticPublishState.FAILED)
      {
        this.d.setText(2131362145);
        b();
        d();
        continue;
      }
      this.d.setText(DefaultTimeFormatUtil.a(this.k, TimeFormatUtil.TimeFormatStyle.STREAM_RELATIVE_STYLE, 1000L * paramFeedComment.createdTime));
      e();
      if ((paramFeedComment.b()) && (this.r != null))
        break label310;
      d();
    }
    label310: c();
    TextView localTextView = this.e;
    if (paramFeedComment.S().doesViewerLike);
    for (int i1 = 2131362076; ; i1 = 2131362075)
    {
      localTextView.setText(i1);
      this.e.setOnClickListener(new PermalinkCommentView.1(this));
      break;
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      int i1 = SizeUtil.a(getContext(), 8.0F);
      setTouchDelegate(new CompoundTouchDelegate(this, new TouchDelegate[] { TouchDelegateUtils.a(this.e, i1), TouchDelegateUtils.a(this.h, i1) }));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.permalink.PermalinkCommentView
 * JD-Core Version:    0.6.0
 */