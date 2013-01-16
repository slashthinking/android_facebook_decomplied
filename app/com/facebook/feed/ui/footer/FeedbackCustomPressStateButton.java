package com.facebook.feed.ui.footer;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.R.styleable;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Preconditions;
import java.util.List;

public class FeedbackCustomPressStateButton extends CustomLinearLayout
{
  private static final FeedbackCustomPressStateButton.ButtonType[] a;
  private final Context b;
  private final ImageView c;
  private final TextView d;
  private Drawable e;
  private FeedbackCustomPressStateButton.ButtonPosition f;
  private List<View> g;
  private final Drawable[] h;
  private FeedbackActionButtonBar.DownstateType i;

  static
  {
    FeedbackCustomPressStateButton.ButtonType[] arrayOfButtonType = new FeedbackCustomPressStateButton.ButtonType[3];
    arrayOfButtonType[0] = FeedbackCustomPressStateButton.ButtonType.LIKE;
    arrayOfButtonType[1] = FeedbackCustomPressStateButton.ButtonType.COMMENT;
    arrayOfButtonType[2] = FeedbackCustomPressStateButton.ButtonType.SHARE;
    a = arrayOfButtonType;
  }

  public FeedbackCustomPressStateButton(Context paramContext)
  {
    this(paramContext, null);
  }

  public FeedbackCustomPressStateButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b = paramContext;
    setContentView(2130903149);
    this.c = ((ImageView)b(2131296706));
    this.d = ((TextView)b(2131296707));
    this.h = new Drawable[FeedbackCustomPressStateButton.ButtonPosition.values().length];
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FeedbackCustomPressStateButton);
    int j = localTypedArray.getInt(0, -1);
    localTypedArray.recycle();
    FeedbackCustomPressStateButton.ButtonType localButtonType = a[j];
    this.c.setImageResource(localButtonType.drawableIconId);
    this.d.setText(localButtonType.textStringId);
  }

  private void a()
  {
    Preconditions.checkNotNull(this.i, "Downstate type must be set on this button before a touch event");
  }

  private void b()
  {
    if (this.g != null)
    {
      int j = this.g.size();
      for (int k = 0; k < j; k++)
      {
        View localView = (View)this.g.get(k);
        if (localView.getVisibility() == 8)
          continue;
        localView.setVisibility(4);
      }
    }
  }

  private void c()
  {
    if (this.g != null)
    {
      int j = this.g.size();
      for (int k = 0; k < j; k++)
      {
        View localView = (View)this.g.get(k);
        if (localView.getVisibility() == 8)
          continue;
        localView.setVisibility(0);
      }
    }
  }

  private void d()
  {
    if (this.e == null)
    {
      LayerDrawable localLayerDrawable = (LayerDrawable)this.b.getResources().getDrawable(2130838194).mutate();
      int j = this.b.getResources().getDimensionPixelSize(2131230803);
      localLayerDrawable.setLayerInset(0, j, j, j, j);
      this.e = localLayerDrawable;
    }
  }

  private void e()
  {
    if (this.h[this.f.ordinal()] == null)
    {
      if (this.i != FeedbackActionButtonBar.DownstateType.NEWSFEED_SHADOW)
        break label55;
      this.h[this.f.ordinal()] = this.b.getResources().getDrawable(this.f.newsfeedShadowResId);
    }
    while (true)
    {
      return;
      label55: if (this.i == FeedbackActionButtonBar.DownstateType.SUBSTORY_SHADOW)
      {
        this.h[this.f.ordinal()] = this.b.getResources().getDrawable(this.f.substoryShadowResId);
        continue;
      }
    }
  }

  public ImageView getIcon()
  {
    return this.c;
  }

  public TextView getTextView()
  {
    return this.d;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 2:
    default:
    case 0:
    case 1:
    case 3:
    }
    while (true)
    {
      return super.onTouchEvent(paramMotionEvent);
      a();
      switch (FeedbackCustomPressStateButton.1.a[this.i.ordinal()])
      {
      default:
        break;
      case 1:
        d();
        setBackgroundDrawable(this.e);
        break;
      case 2:
      case 3:
        if (this.f == null)
        {
          d();
          setBackgroundDrawable(this.e);
        }
        e();
        b();
        setBackgroundDrawable(this.h[this.f.ordinal()]);
        continue;
        setBackgroundDrawable(null);
        c();
      }
    }
  }

  public void setBorderingDividers(List<View> paramList)
  {
    this.g = paramList;
  }

  public void setButtonPosition(FeedbackCustomPressStateButton.ButtonPosition paramButtonPosition)
  {
    this.f = paramButtonPosition;
  }

  public void setDownstateType(FeedbackActionButtonBar.DownstateType paramDownstateType)
  {
    this.i = paramDownstateType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.footer.FeedbackCustomPressStateButton
 * JD-Core Version:    0.6.0
 */