package com.facebook.orca.compose;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.TouchDelegate;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.TextView;
import com.facebook.orca.common.util.SizeUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.prefs.UiCounters;
import com.facebook.widget.CustomViewGroup;

public class LocationNuxView extends CustomViewGroup
{
  private UiCounters a;
  private TextView b;
  private ImageButton c;
  private boolean d;
  private boolean e;

  public LocationNuxView(Context paramContext)
  {
    super(paramContext);
    a();
  }

  public LocationNuxView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }

  public LocationNuxView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }

  private void a()
  {
    this.a = ((UiCounters)getInjector().a(UiCounters.class));
    setVisibility(8);
    setClickable(true);
  }

  private void b()
  {
    if (this.e);
    while (true)
    {
      return;
      this.e = true;
      setContentView(2130903356);
      this.b = ((TextView)getView(2131297314));
      this.c = ((ImageButton)getView(2131297311));
      Resources localResources = getResources();
      String str1 = localResources.getString(2131362551);
      String str2 = localResources.getString(2131362552);
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = TextUtils.htmlEncode(str1);
      arrayOfObject[1] = TextUtils.htmlEncode(str2);
      Spanned localSpanned = Html.fromHtml(localResources.getString(2131362553, arrayOfObject));
      this.b.setText(localSpanned);
      this.c.setOnClickListener(new LocationNuxView.1(this));
    }
  }

  private void c()
  {
    if (!this.d);
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
    this.a.c("dismissed_location_nux");
    setVisibility(8);
  }

  void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    if (!paramBoolean)
      setVisibility(8);
    while (true)
    {
      return;
      postDelayed(new LocationNuxView.2(this), 300L);
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
 * Qualified Name:     com.facebook.orca.compose.LocationNuxView
 * JD-Core Version:    0.6.0
 */