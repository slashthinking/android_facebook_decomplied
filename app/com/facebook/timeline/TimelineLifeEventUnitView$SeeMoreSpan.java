package com.facebook.timeline;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

class TimelineLifeEventUnitView$SeeMoreSpan extends ClickableSpan
{
  private final Context b;
  private final TextView c;
  private final Spannable d;

  public TimelineLifeEventUnitView$SeeMoreSpan(TimelineLifeEventUnitView paramTimelineLifeEventUnitView, Context paramContext, TextView paramTextView, Spannable paramSpannable)
  {
    this.b = paramContext;
    this.c = paramTextView;
    this.d = paramSpannable;
  }

  public void onClick(View paramView)
  {
    this.c.setText(this.d);
  }

  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setColor(this.b.getResources().getColor(2131165265));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineLifeEventUnitView.SeeMoreSpan
 * JD-Core Version:    0.6.0
 */