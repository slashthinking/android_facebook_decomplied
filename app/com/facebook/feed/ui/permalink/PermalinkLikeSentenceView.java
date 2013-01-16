package com.facebook.feed.ui.permalink;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.feed.util.FeedLinkifyUtil;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;
import java.util.List;

public class PermalinkLikeSentenceView extends CustomLinearLayout
{
  private final Context a;
  private final SecureContextHelper b;
  private final IFeedIntentBuilder c;
  private final FeedLinkifyUtil d;
  private final View e;
  private final TextView f;
  private String g;
  private boolean h = false;
  private View.OnClickListener i = new PermalinkLikeSentenceView.1(this);

  public PermalinkLikeSentenceView(Context paramContext)
  {
    this(paramContext, null);
  }

  public PermalinkLikeSentenceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    FbInjector localFbInjector = getInjector();
    this.c = ((IFeedIntentBuilder)localFbInjector.a(IFeedIntentBuilder.class));
    this.d = ((FeedLinkifyUtil)localFbInjector.a(FeedLinkifyUtil.class));
    this.b = ((SecureContextHelper)localFbInjector.a(SecureContextHelper.class));
    setContentView(2130903157);
    this.e = b(2131296727);
    this.f = ((TextView)b(2131296728));
    setPadding(0, 0, 0, paramContext.getResources().getDimensionPixelSize(2131230759));
    setOrientation(1);
  }

  private void b(Feedback paramFeedback)
  {
    setOnClickListener(null);
    setBackgroundDrawable(null);
    GraphQLTextWithEntities localGraphQLTextWithEntities;
    Spannable localSpannable;
    if ((paramFeedback.doesViewerLike) && (paramFeedback.viewerLikersSentence != null))
    {
      localGraphQLTextWithEntities = paramFeedback.viewerLikersSentence;
      localSpannable = this.d.b(localGraphQLTextWithEntities, 2131165254, true);
      if ((localGraphQLTextWithEntities.aggregatedRanges == null) || (localGraphQLTextWithEntities.aggregatedRanges.size() == 0))
        break label131;
      setOnClickListener(this.i);
      this.f.setMovementMethod(null);
    }
    for (this.h = true; ; this.h = false)
    {
      this.f.setText(localSpannable);
      while (true)
      {
        return;
        if ((!paramFeedback.doesViewerLike) && (paramFeedback.viewerDoesNotLikeSentence != null))
        {
          localGraphQLTextWithEntities = paramFeedback.viewerDoesNotLikeSentence;
          break;
        }
        this.f.setText(getResources().getString(2131362081));
      }
      label131: this.f.setMovementMethod(LinkMovementMethod.getInstance());
    }
  }

  public void a(Feedback paramFeedback)
  {
    this.g = paramFeedback.id;
    b(paramFeedback);
  }

  public void setNoContentBelow()
  {
    View localView = this.e;
    if (this.h);
    for (int j = 2130838218; ; j = 2130838217)
    {
      localView.setBackgroundResource(j);
      return;
    }
  }

  public void setWithContentBelow()
  {
    View localView = this.e;
    if (this.h);
    for (int j = 2130838220; ; j = 2130838219)
    {
      localView.setBackgroundResource(j);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.permalink.PermalinkLikeSentenceView
 * JD-Core Version:    0.6.0
 */