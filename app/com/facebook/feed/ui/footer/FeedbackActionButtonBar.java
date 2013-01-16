package com.facebook.feed.ui.footer;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.R.styleable;
import com.facebook.feed.annotations.IsUFIShareActionEnabled;
import com.facebook.feed.data.FeedStoryMutator;
import com.facebook.feed.data.FeedStoryMutator.Result;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.feed.prefs.FeedPrefKeys;
import com.facebook.feed.protocol.FeedbackLoggingParams;
import com.facebook.feed.renderer.FeedUnitViewStyle;
import com.facebook.feed.renderer.IFeedUnitRenderer;
import com.facebook.feed.util.FeedUtils;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.UfiEvents.LikeClickedEvent;
import com.facebook.feed.util.event.UfiEvents.LikeUpdatedUIEvent;
import com.facebook.graphql.model.FeedOptimisticPublishState;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLProfileCache;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.ScaleUpDownAnimation;
import com.google.common.collect.Lists;

public class FeedbackActionButtonBar extends CustomLinearLayout
{
  private static final FeedbackActionButtonBar.DownstateType[] a;
  private final Context b;
  private final IFeedUnitRenderer c;
  private final IFeedIntentBuilder d;
  private final FeedEventBus e;
  private final FeedStoryMutator f;
  private boolean g = false;
  private final FeedbackCustomPressStateButton h;
  private final View i;
  private final FeedbackCustomPressStateButton j;
  private final View k;
  private final FeedbackCustomPressStateButton l;
  private final FeedbackActionButtonBar.DownstateType m;
  private final boolean n;
  private FeedStory o;
  private UFIStyle p;
  private View.OnClickListener q;
  private View.OnClickListener r;
  private Intent s;
  private FeedOptimisticPublishState t;
  private float u = 1.0F;

  static
  {
    FeedbackActionButtonBar.DownstateType[] arrayOfDownstateType = new FeedbackActionButtonBar.DownstateType[3];
    arrayOfDownstateType[0] = FeedbackActionButtonBar.DownstateType.DEFAULT_ROUNDED_RECT;
    arrayOfDownstateType[1] = FeedbackActionButtonBar.DownstateType.NEWSFEED_SHADOW;
    arrayOfDownstateType[2] = FeedbackActionButtonBar.DownstateType.SUBSTORY_SHADOW;
    a = arrayOfDownstateType;
  }

  public FeedbackActionButtonBar(Context paramContext)
  {
    this(paramContext, null);
  }

  public FeedbackActionButtonBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setContentView(2130903150);
    this.b = paramContext;
    FbInjector localFbInjector = getInjector();
    this.c = ((IFeedUnitRenderer)localFbInjector.a(IFeedUnitRenderer.class));
    this.d = ((IFeedIntentBuilder)localFbInjector.a(IFeedIntentBuilder.class));
    this.e = ((FeedEventBus)localFbInjector.a(FeedEventBus.class));
    this.p = ((UFIStyle)localFbInjector.a(UFIStyle.class));
    this.f = ((FeedStoryMutator)localFbInjector.a(FeedStoryMutator.class));
    this.n = ((OrcaSharedPreferences)localFbInjector.a(OrcaSharedPreferences.class)).a(FeedPrefKeys.b, true);
    this.h = ((FeedbackCustomPressStateButton)b(2131296708));
    this.i = b(2131296709);
    this.j = ((FeedbackCustomPressStateButton)b(2131296710));
    this.k = b(2131296711);
    this.l = ((FeedbackCustomPressStateButton)b(2131296712));
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FeedbackActionButtonBar);
    int i1 = localTypedArray.getInt(0, -1);
    if (i1 == -1);
    for (FeedbackActionButtonBar.DownstateType localDownstateType = FeedbackActionButtonBar.DownstateType.DEFAULT_ROUNDED_RECT; ; localDownstateType = a[i1])
    {
      this.m = localDownstateType;
      localTypedArray.recycle();
      setupDownstates(this.m);
      return;
    }
  }

  private View.OnClickListener a(FeedUnitViewStyle paramFeedUnitViewStyle)
  {
    if (this.r != null);
    for (View.OnClickListener localOnClickListener = this.r; ; localOnClickListener = this.r)
    {
      return localOnClickListener;
      this.r = new FeedbackActionButtonBar.1(this, paramFeedUnitViewStyle);
    }
  }

  private void a(View paramView, int paramInt)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    localMarginLayoutParams.topMargin = paramInt;
    localMarginLayoutParams.bottomMargin = paramInt;
    paramView.setLayoutParams(localMarginLayoutParams);
  }

  private void a(FeedUnitViewStyle paramFeedUnitViewStyle, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i1 = 8;
    if (paramBoolean3)
    {
      this.l.setVisibility(0);
      View localView = this.k;
      if ((paramBoolean1) || (paramBoolean2))
        i1 = 0;
      localView.setVisibility(i1);
      this.l.setOnClickListener(a(paramFeedUnitViewStyle));
    }
    while (true)
    {
      return;
      this.l.setVisibility(i1);
      this.k.setVisibility(i1);
      this.l.setOnClickListener(null);
    }
  }

  private void a(FeedStory paramFeedStory, FeedUnitViewStyle paramFeedUnitViewStyle, boolean paramBoolean1, boolean paramBoolean2)
  {
    FeedbackCustomPressStateButton localFeedbackCustomPressStateButton = this.j;
    int i1;
    int i2;
    if (paramBoolean2)
    {
      i1 = 0;
      localFeedbackCustomPressStateButton.setVisibility(i1);
      View localView = this.i;
      if (!paramBoolean1)
        break label103;
      i2 = 0;
      if (!paramBoolean2)
        break label103;
      label39: localView.setVisibility(i2);
      if ((paramBoolean2) && (b()))
      {
        if (paramFeedUnitViewStyle != FeedUnitViewStyle.PERMALINK_STORY)
          break label110;
        if (this.q == null)
          this.q = new FeedbackActionButtonBar.3(this);
        this.j.setOnClickListener(this.q);
      }
    }
    while (true)
    {
      return;
      i1 = 8;
      break;
      label103: i2 = 8;
      break label39;
      label110: if (this.n)
      {
        this.c.a(this.j, paramFeedStory.S(), new FeedbackLoggingParams(paramFeedStory.k(), b(paramFeedUnitViewStyle)), null);
        continue;
      }
      this.c.b(this.j, paramFeedStory, null);
    }
  }

  private void a(FeedStory paramFeedStory, FeedUnitViewStyle paramFeedUnitViewStyle, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    setVisibility(0);
    b(paramBoolean1);
    a(paramFeedStory.D());
    a(paramFeedStory, paramFeedUnitViewStyle, paramBoolean1, paramBoolean2);
    a(paramFeedUnitViewStyle, paramBoolean1, paramBoolean2, paramBoolean3);
  }

  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramBoolean1) && (paramBoolean2) && (paramBoolean3))
    {
      this.h.setButtonPosition(FeedbackCustomPressStateButton.ButtonPosition.LEFT);
      this.j.setButtonPosition(FeedbackCustomPressStateButton.ButtonPosition.MIDDLE);
      this.l.setButtonPosition(FeedbackCustomPressStateButton.ButtonPosition.RIGHT);
    }
    while (true)
    {
      return;
      if ((paramBoolean1) && (paramBoolean2))
      {
        this.h.setButtonPosition(FeedbackCustomPressStateButton.ButtonPosition.LEFT);
        this.j.setButtonPosition(FeedbackCustomPressStateButton.ButtonPosition.RIGHT);
        continue;
      }
      if ((paramBoolean2) && (paramBoolean3))
      {
        this.j.setButtonPosition(FeedbackCustomPressStateButton.ButtonPosition.LEFT);
        this.l.setButtonPosition(FeedbackCustomPressStateButton.ButtonPosition.RIGHT);
        continue;
      }
      if ((paramBoolean1) && (paramBoolean3))
      {
        this.h.setButtonPosition(FeedbackCustomPressStateButton.ButtonPosition.LEFT);
        this.l.setButtonPosition(FeedbackCustomPressStateButton.ButtonPosition.RIGHT);
        continue;
      }
      if (paramBoolean1)
      {
        this.h.setButtonPosition(FeedbackCustomPressStateButton.ButtonPosition.WHOLE);
        continue;
      }
      if (paramBoolean2)
      {
        this.j.setButtonPosition(FeedbackCustomPressStateButton.ButtonPosition.WHOLE);
        continue;
      }
      this.l.setButtonPosition(FeedbackCustomPressStateButton.ButtonPosition.WHOLE);
    }
  }

  private String b(FeedUnitViewStyle paramFeedUnitViewStyle)
  {
    String str;
    switch (FeedbackActionButtonBar.4.b[paramFeedUnitViewStyle.ordinal()])
    {
    default:
      str = null;
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      return str;
      str = "newsfeed_ufi";
      continue;
      str = "permalink_ufi";
      continue;
      str = "timeline_ufi";
    }
  }

  private void b(boolean paramBoolean)
  {
    FeedbackCustomPressStateButton localFeedbackCustomPressStateButton = this.h;
    if (paramBoolean);
    for (int i1 = 0; ; i1 = 8)
    {
      localFeedbackCustomPressStateButton.setVisibility(i1);
      return;
    }
  }

  private boolean b()
  {
    if ((this.t == FeedOptimisticPublishState.SUCCESS) || (this.t == FeedOptimisticPublishState.NONE));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  private void c()
  {
    FeedStoryMutator.Result localResult;
    FeedEventBus localFeedEventBus;
    String str1;
    String str2;
    String str3;
    if (this.o.b())
    {
      GraphQLProfile localGraphQLProfile = ((GraphQLProfileCache)getInjector().a(GraphQLProfileCache.class)).a();
      localResult = this.f.a(this.o, localGraphQLProfile);
      this.o = localResult.b();
      localFeedEventBus = this.e;
      str1 = this.o.getCacheId();
      if (this.o.S() != null)
        break label178;
      str2 = null;
      FeedStory localFeedStory = localResult.a();
      str3 = null;
      if (localFeedStory != null)
        break label193;
    }
    while (true)
    {
      localFeedEventBus.a(new UfiEvents.LikeClickedEvent(str1, str2, str3));
      a(this.o.D());
      if (this.o.D())
        ScaleUpDownAnimation.a(this.h.getIcon(), 1.8F, 85L, true);
      this.e.a(new UfiEvents.LikeUpdatedUIEvent(this.o.S().legacyApiPostId, this.o.D()));
      return;
      label178: str2 = this.o.S().legacyApiPostId;
      break;
      label193: str3 = localResult.a().getCacheId();
    }
  }

  private void setupDownstates(FeedbackActionButtonBar.DownstateType paramDownstateType)
  {
    this.h.setDownstateType(paramDownstateType);
    this.j.setDownstateType(paramDownstateType);
    this.l.setDownstateType(paramDownstateType);
    if ((paramDownstateType == FeedbackActionButtonBar.DownstateType.NEWSFEED_SHADOW) || (paramDownstateType == FeedbackActionButtonBar.DownstateType.SUBSTORY_SHADOW))
    {
      FeedbackCustomPressStateButton localFeedbackCustomPressStateButton1 = this.h;
      View[] arrayOfView1 = new View[1];
      arrayOfView1[0] = this.i;
      localFeedbackCustomPressStateButton1.setBorderingDividers(Lists.a(arrayOfView1));
      FeedbackCustomPressStateButton localFeedbackCustomPressStateButton2 = this.j;
      View[] arrayOfView2 = new View[2];
      arrayOfView2[0] = this.i;
      arrayOfView2[1] = this.k;
      localFeedbackCustomPressStateButton2.setBorderingDividers(Lists.a(arrayOfView2));
      FeedbackCustomPressStateButton localFeedbackCustomPressStateButton3 = this.l;
      View[] arrayOfView3 = new View[1];
      arrayOfView3[0] = this.k;
      localFeedbackCustomPressStateButton3.setBorderingDividers(Lists.a(arrayOfView3));
    }
  }

  private void setupFeedbackBarPublishState(FeedStory paramFeedStory)
  {
    switch (FeedbackActionButtonBar.4.a[paramFeedStory.c().ordinal()])
    {
    default:
    case 1:
    case 2:
    }
    while (true)
    {
      this.u = FeedUtils.a(this.e, paramFeedStory, this.u, new View[] { this });
      this.t = paramFeedStory.c();
      return;
      this.h.setOnClickListener(null);
      this.j.setOnClickListener(null);
      this.l.setOnClickListener(null);
      this.g = false;
    }
  }

  public void a()
  {
    setVisibility(8);
  }

  public void a(FeedStory paramFeedStory, FeedUnitViewStyle paramFeedUnitViewStyle)
  {
    this.o = paramFeedStory;
    boolean bool1 = this.o.b();
    boolean bool2 = this.o.P();
    boolean bool3;
    if ((this.o.M()) && (((Boolean)getInjector().a(Boolean.class, IsUFIShareActionEnabled.class)).booleanValue()))
    {
      bool3 = true;
      this.t = paramFeedStory.c();
      this.s = null;
      if ((bool1) || (bool2) || (bool3))
        break label95;
      a();
    }
    while (true)
    {
      return;
      bool3 = false;
      break;
      label95: a(bool1, bool2, bool3);
      a(paramFeedStory, paramFeedUnitViewStyle, bool1, bool2, bool3);
      setupFeedbackBarPublishState(paramFeedStory);
    }
  }

  public void a(boolean paramBoolean)
  {
    FeedbackCustomPressStateButton localFeedbackCustomPressStateButton = this.h;
    TextView localTextView = localFeedbackCustomPressStateButton.getTextView();
    Resources localResources = this.b.getResources();
    int i1;
    ImageView localImageView;
    if (paramBoolean)
    {
      i1 = 2131165290;
      localTextView.setTextColor(localResources.getColor(i1));
      localImageView = localFeedbackCustomPressStateButton.getIcon();
      if (!paramBoolean)
        break label101;
    }
    label101: for (int i2 = 2130839008; ; i2 = 2130839007)
    {
      localImageView.setImageResource(i2);
      if ((!this.g) && (b()))
      {
        localFeedbackCustomPressStateButton.setOnClickListener(new FeedbackActionButtonBar.2(this));
        this.g = true;
      }
      return;
      i1 = 2131165289;
      break;
    }
  }

  protected FeedEventBus getEventBus()
  {
    return this.e;
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.o != null)
    {
      int i1 = View.MeasureSpec.getSize(paramInt1);
      this.p.a(this.o.b(), this.o.P(), this.o.M()).a(i1, this.h, this.j, this.l);
    }
    super.onMeasure(paramInt1, paramInt2);
  }

  public void setDividerMargins(int paramInt)
  {
    a(this.i, paramInt);
    a(this.k, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.footer.FeedbackActionButtonBar
 * JD-Core Version:    0.6.0
 */