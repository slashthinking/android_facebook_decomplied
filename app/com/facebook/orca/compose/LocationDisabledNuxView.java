package com.facebook.orca.compose;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.TouchDelegate;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.TextView;
import com.facebook.orca.common.ui.widgets.text.CustomUrlLikeSpan;
import com.facebook.orca.common.util.SizeUtil;
import com.facebook.orca.common.util.StyledStringBuilder;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.intents.MessagingIntentUris;
import com.facebook.orca.prefs.UiCounters;
import com.facebook.widget.CustomViewGroup;

public class LocationDisabledNuxView extends CustomViewGroup
{
  private UiCounters a;
  private TextView b;
  private ImageButton c;
  private MessagingIntentUris d;
  private boolean e;
  private boolean f;

  public LocationDisabledNuxView(Context paramContext)
  {
    super(paramContext);
    a();
  }

  public LocationDisabledNuxView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }

  public LocationDisabledNuxView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }

  private void a()
  {
    FbInjector localFbInjector = getInjector();
    this.a = ((UiCounters)localFbInjector.a(UiCounters.class));
    this.d = ((MessagingIntentUris)localFbInjector.a(MessagingIntentUris.class));
    setVisibility(8);
    setClickable(true);
  }

  private void b()
  {
    if (this.f);
    while (true)
    {
      return;
      this.f = true;
      setContentView(2130903355);
      this.c = ((ImageButton)getView(2131297311));
      this.b = ((TextView)getView(2131297312));
      this.b.setMovementMethod(LinkMovementMethod.getInstance());
      CustomUrlLikeSpan localCustomUrlLikeSpan = new CustomUrlLikeSpan();
      localCustomUrlLikeSpan.a(new LocationDisabledNuxView.1(this));
      Resources localResources = getResources();
      StyledStringBuilder localStyledStringBuilder = new StyledStringBuilder(getResources());
      localStyledStringBuilder.a(localResources.getString(2131362557));
      localStyledStringBuilder.a("[[link]]", localResources.getString(2131362558), localCustomUrlLikeSpan, 33);
      this.b.setText(localStyledStringBuilder.b());
      this.c.setOnClickListener(new LocationDisabledNuxView.2(this));
    }
  }

  private void c()
  {
    if (!this.e);
    while (true)
    {
      return;
      setVisibility(0);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(250L);
      localAlphaAnimation.setFillEnabled(true);
      localAlphaAnimation.setInterpolator(new LinearInterpolator());
      setAnimation(localAlphaAnimation);
    }
  }

  private void d()
  {
    this.a.c("dismissed_location_disabled_nux");
    setVisibility(8);
  }

  private void e()
  {
    Context localContext = getContext();
    localContext.startActivity(this.d.a(localContext));
  }

  void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (!paramBoolean)
      setVisibility(8);
    while (true)
    {
      return;
      postDelayed(new LocationDisabledNuxView.3(this), 300L);
    }
  }

  @SuppressLint({"DrawAllocation"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      Rect localRect = new Rect();
      this.c.getHitRect(localRect);
      int i = SizeUtil.a(getContext(), 10.0F);
      localRect.left -= i;
      localRect.top -= i;
      localRect.right = (i + localRect.right);
      localRect.bottom = (i + localRect.bottom);
      setTouchDelegate(new TouchDelegate(localRect, this.c));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.compose.LocationDisabledNuxView
 * JD-Core Version:    0.6.0
 */