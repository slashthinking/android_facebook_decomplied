package com.facebook.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.Display;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.common.util.DefaultTimeFormatUtil;
import com.facebook.common.util.TimeFormatUtil.TimeFormatStyle;
import com.facebook.feed.data.FeedStoryMutator;
import com.facebook.feed.flyout.FlyoutClickSource;
import com.facebook.feed.prefs.FeedPrefKeys;
import com.facebook.feed.prefs.FeedRendererOptions;
import com.facebook.feed.renderer.IFeedUnitRenderer;
import com.facebook.feed.renderer.PrivacyScopeMapper;
import com.facebook.feed.util.FeedLinkifyUtil;
import com.facebook.feed.util.FeedUtils;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedStory.PageStoryType;
import com.facebook.graphql.model.FeedStoryAttachment;
import com.facebook.graphql.model.GraphQLActionLink;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLPrivacyScope;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.orca.common.ui.util.TouchDelegateUtils;
import com.facebook.orca.common.util.SizeUtil;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.images.FetchImageParams;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.ScaleUpDownAnimation;
import com.facebook.widget.UrlImage;

public class StoryHeaderSection extends CustomRelativeLayout
  implements DepthAwareView
{
  private static int t;
  private static int u = -1;
  private static long y = 85L;
  private static float z = 1.8F;
  private final boolean A;
  private final boolean B;
  private final FeedRendererOptions C;
  private final FeedEventBus D;
  private final int E;
  private StoryHeaderSection.UpperRightButtonType F;
  private TouchDelegate G;
  private final Context a;
  private final IFeedUnitRenderer b;
  private final FeedLinkifyUtil c;
  private final FeedStoryMutator d;
  private final UrlImage e;
  private final TextView f;
  private final View g;
  private final ImageView h;
  private final TextView i;
  private final ImageView j;
  private final TextView k;
  private final String l;
  private final ImageView m;
  private final String n;
  private final String o;
  private FeedStory p;
  private GraphQLActionLink q;
  private final Display r;
  private final Paint s;
  private final int v;
  private final int w;
  private final int x;

  public StoryHeaderSection(Context paramContext)
  {
    this(paramContext, null);
  }

  public StoryHeaderSection(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setContentView(2130903175);
    this.e = ((UrlImage)b(2131296798));
    this.f = ((TextView)b(2131296801));
    this.f.setTag(2131296266, FlyoutClickSource.TITLE);
    this.f.setMovementMethod(LinkMovementMethod.getInstance());
    this.g = b(2131296799);
    this.h = ((ImageView)b(2131296800));
    this.i = ((TextView)b(2131296802));
    this.i.setMovementMethod(LinkMovementMethod.getInstance());
    this.j = ((ImageView)b(2131296803));
    this.k = ((TextView)b(2131296804));
    this.m = ((ImageView)b(2131296805));
    FbInjector localFbInjector = getInjector();
    this.b = ((IFeedUnitRenderer)localFbInjector.a(IFeedUnitRenderer.class));
    this.c = ((FeedLinkifyUtil)localFbInjector.a(FeedLinkifyUtil.class));
    this.d = ((FeedStoryMutator)localFbInjector.a(FeedStoryMutator.class));
    this.a = paramContext;
    this.r = ((Activity)this.a).getWindowManager().getDefaultDisplay();
    this.s = this.i.getPaint();
    t = this.r.getWidth();
    this.n = this.a.getString(2131362079);
    this.o = this.a.getString(2131362085);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.n;
    this.l = StringLocaleUtil.a(" %s ", arrayOfObject);
    this.k.setText(this.l);
    OrcaSharedPreferences localOrcaSharedPreferences = (OrcaSharedPreferences)localFbInjector.a(OrcaSharedPreferences.class);
    this.C = ((FeedRendererOptions)localFbInjector.a(FeedRendererOptions.class));
    this.D = ((FeedEventBus)localFbInjector.a(FeedEventBus.class));
    this.A = localOrcaSharedPreferences.a(FeedPrefKeys.t, true);
    this.B = localOrcaSharedPreferences.a(FeedPrefKeys.u, true);
    this.e.setLoadResolutionDuringScroll(this.C.d);
    this.E = getResources().getDimensionPixelSize(2131230796);
    u = getResources().getDimensionPixelSize(2131230762);
    this.v = SizeUtil.a(getResources(), getResources().getDrawable(2130838210).getIntrinsicWidth());
    this.w = getResources().getDimensionPixelSize(2131230763);
    this.x = getResources().getDimensionPixelSize(2131230783);
    this.h.setOnClickListener(new StoryHeaderSection.1(this));
  }

  private void a(Context paramContext, FeedStory paramFeedStory)
  {
    if (!this.B);
    String str;
    while (true)
    {
      return;
      label31: Object localObject;
      if (paramFeedStory.B())
      {
        str = DefaultTimeFormatUtil.a(paramContext, TimeFormatUtil.TimeFormatStyle.STREAM_RELATIVE_STYLE, 1000L * paramFeedStory.creationTime);
        localObject = paramFeedStory.K();
        if (localObject == null)
          localObject = this.c.c(paramFeedStory);
        if (localObject != null)
        {
          int i2 = localObject.toString().indexOf("%s");
          if (i2 != -1)
          {
            SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder((CharSequence)localObject);
            localObject = localSpannableStringBuilder.replace(i2, i2 + 2, str);
            if (a((Spannable)localObject))
              localObject = localSpannableStringBuilder.append(" ");
          }
        }
        if ((paramFeedStory.privacyScope == null) || (localObject == null) || (((Spannable)localObject).length() <= 0))
          break label228;
        int i1 = PrivacyScopeMapper.a(paramFeedStory.privacyScope.type);
        this.m.setBackgroundResource(i1);
        this.m.setVisibility(0);
      }
      while (true)
      {
        b((Spannable)localObject);
        if (!a((Spannable)localObject, paramFeedStory.t(), this.E))
          break label260;
        if ((localObject != null) && (((Spannable)localObject).length() != 0))
          break label240;
        this.i.setVisibility(8);
        break;
        str = "";
        break label31;
        label228: this.m.setVisibility(8);
      }
      label240: this.i.setText((CharSequence)localObject);
      this.i.setVisibility(0);
    }
    label260: if (paramFeedStory.privacyScope != null)
      if (paramFeedStory.C())
      {
        TextView localTextView3 = this.i;
        Object[] arrayOfObject3 = new Object[4];
        arrayOfObject3[0] = str;
        arrayOfObject3[1] = this.n;
        arrayOfObject3[2] = this.o;
        arrayOfObject3[3] = this.n;
        localTextView3.setText(StringLocaleUtil.a("%s %s %s %s ", arrayOfObject3));
      }
    while (true)
    {
      this.i.setVisibility(0);
      break;
      TextView localTextView2 = this.i;
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = str;
      arrayOfObject2[1] = this.n;
      localTextView2.setText(StringLocaleUtil.a("%s %s ", arrayOfObject2));
      continue;
      if (paramFeedStory.C())
      {
        TextView localTextView1 = this.i;
        Object[] arrayOfObject1 = new Object[3];
        arrayOfObject1[0] = str;
        arrayOfObject1[1] = this.n;
        arrayOfObject1[2] = this.o;
        localTextView1.setText(StringLocaleUtil.a("%s %s %s", arrayOfObject1));
        continue;
      }
      this.i.setText(str);
    }
  }

  private void a(FeedStory paramFeedStory)
  {
    if ((!this.A) || (paramFeedStory == null));
    while (true)
    {
      return;
      this.c.b(paramFeedStory);
      Spannable localSpannable = paramFeedStory.H();
      if (localSpannable != null)
      {
        this.f.setText(localSpannable);
        this.f.setVisibility(0);
        continue;
      }
      this.f.setVisibility(8);
    }
  }

  private void a(boolean paramBoolean)
  {
    if (this.q.page.doesViewerLike)
    {
      this.h.setImageResource(2130838211);
      if (paramBoolean)
        ScaleUpDownAnimation.a(this.h, z, y, true);
    }
    while (true)
    {
      this.h.setVisibility(0);
      return;
      this.h.setImageResource(2130838210);
    }
  }

  private boolean a(Spannable paramSpannable)
  {
    return false;
  }

  private boolean a(Spannable paramSpannable, int paramInt1, int paramInt2)
  {
    float f1;
    if (paramSpannable != null)
    {
      f1 = this.s.measureText(paramSpannable.toString());
      if (f1 + paramInt2 + c(paramSpannable) > c(paramInt1))
        break label51;
    }
    label51: for (int i1 = 1; ; i1 = 0)
    {
      return i1;
      f1 = 0.0F;
      break;
    }
  }

  private void b(Spannable paramSpannable)
  {
    if (a(paramSpannable))
    {
      this.j.setImageResource(2130838208);
      this.j.setVisibility(0);
      this.k.setVisibility(0);
    }
    while (true)
    {
      return;
      this.j.setVisibility(8);
      this.k.setVisibility(8);
    }
  }

  private int c(int paramInt)
  {
    int i1 = FeedUtils.a(this.a, 0);
    int i2;
    if (StoryHeaderSection.UpperRightButtonType.PAGE_LIKE_BUTTON.equals(this.F))
      i2 = this.v;
    while (true)
    {
      return t - u - i2 - i1 * 3 - 2 * FeedUtils.a(this.a, paramInt);
      boolean bool = StoryHeaderSection.UpperRightButtonType.MENU_BUTTON.equals(this.F);
      i2 = 0;
      if (!bool)
        continue;
      i2 = this.w;
    }
  }

  private int c(Spannable paramSpannable)
  {
    boolean bool = a(paramSpannable);
    int i1 = 0;
    if (bool)
      i1 = (int)(0 + this.j.getMeasuredWidth() + this.s.measureText(this.l));
    return i1;
  }

  public void a(int paramInt)
  {
    FeedUtils.a(this.a, this, paramInt, 0);
  }

  public void a(FeedStory paramFeedStory, boolean paramBoolean)
  {
    int i1 = 1;
    this.p = paramFeedStory;
    a(paramFeedStory.t());
    label80: int i2;
    label100: label120: FeedStoryAttachment localFeedStoryAttachment;
    label138: TextView localTextView;
    int i3;
    if (paramFeedStory.g())
    {
      GraphQLProfile localGraphQLProfile = paramFeedStory.a();
      if (this.C.a)
      {
        this.e.setImageParams(Uri.parse(localGraphQLProfile.profilePicture.uri));
        this.b.a(this.e, localGraphQLProfile, null);
        this.e.setVisibility(0);
        if ((paramFeedStory.A() != FeedStory.PageStoryType.NCPP) || (paramFeedStory.f() == null))
          break label227;
        i2 = i1;
        if ((paramFeedStory.a == null) || (!FeedStory.PageStoryType.GROUPER_ATTACHED_STORY.equals(paramFeedStory.A())))
          break label233;
        if (i2 == 0)
          break label238;
        this.q = paramFeedStory.f();
        a(false);
        if (!paramFeedStory.h())
          break label285;
        localFeedStoryAttachment = paramFeedStory.e();
        localTextView = this.f;
        String str = localFeedStoryAttachment.title;
        i3 = 0;
        if (str == null)
          break label278;
      }
    }
    while (true)
    {
      localTextView.setVisibility(i3);
      this.f.setText(localFeedStoryAttachment.title);
      this.i.setVisibility(8);
      return;
      this.e.setImageParams((FetchImageParams)null);
      break;
      this.e.setVisibility(8);
      break label80;
      label227: i2 = 0;
      break label100;
      label233: i1 = 0;
      break label120;
      label238: if (i1 != 0)
      {
        this.q = paramFeedStory.a.f();
        a(false);
        break label138;
      }
      this.q = null;
      this.h.setVisibility(8);
      break label138;
      label278: i3 = 8;
    }
    label285: Context localContext = getContext();
    a(paramFeedStory);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.f.getLayoutParams();
    if (paramBoolean)
    {
      this.F = StoryHeaderSection.UpperRightButtonType.MENU_BUTTON;
      localMarginLayoutParams.rightMargin = this.w;
    }
    while (true)
    {
      a(localContext, paramFeedStory);
      break;
      if ((i2 != 0) || (i1 != 0))
      {
        this.F = StoryHeaderSection.UpperRightButtonType.PAGE_LIKE_BUTTON;
        localMarginLayoutParams.rightMargin = this.v;
        continue;
      }
      this.F = StoryHeaderSection.UpperRightButtonType.NONE;
      localMarginLayoutParams.rightMargin = this.x;
    }
  }

  public View getMenuButtonView()
  {
    return this.g;
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    t = this.r.getWidth();
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!paramBoolean);
    while (true)
    {
      return;
      if (this.h.getVisibility() != 8)
      {
        if (this.G == null)
          this.G = TouchDelegateUtils.a(this.h, 8);
        setTouchDelegate(this.G);
        continue;
      }
      setTouchDelegate(null);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.StoryHeaderSection
 * JD-Core Version:    0.6.0
 */