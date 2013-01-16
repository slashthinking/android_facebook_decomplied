package com.facebook.orca.audio;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomViewGroup;

public class AudioRecorderTooltipView extends CustomViewGroup
{
  private final Clock a = (Clock)getInjector().a(Clock.class);
  private final Handler b = new Handler();
  private final TextView c;
  private final View d;
  private final View e;
  private long f;
  private final Runnable g = new AudioRecorderTooltipView.1(this);

  public AudioRecorderTooltipView(Context paramContext)
  {
    this(paramContext, null);
  }

  public AudioRecorderTooltipView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public AudioRecorderTooltipView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903315);
    this.c = ((TextView)getView(2131297192));
    this.d = getView(2131297193);
    this.e = getView(2131297194);
    this.c.bringToFront();
  }

  private void setTimerText(long paramLong)
  {
    TextView localTextView = this.c;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Long.valueOf(paramLong / 1000L);
    arrayOfObject[1] = Long.valueOf(paramLong % 1000L / 100L);
    localTextView.setText(StringLocaleUtil.a("%d.%d", arrayOfObject));
  }

  public void a()
  {
    setStyle(AudioRecorderTooltipView.ViewStyle.TOOLTIP);
    this.f = this.a.a();
    this.b.post(this.g);
  }

  public void a(int paramInt)
  {
    b();
    setTimerText(paramInt);
  }

  public void b()
  {
    this.b.removeCallbacks(this.g);
  }

  public void setShowNux()
  {
    setStyle(AudioRecorderTooltipView.ViewStyle.NUX);
    this.c.setText(2131362724);
  }

  public void setShowTooltipHint()
  {
    setStyle(AudioRecorderTooltipView.ViewStyle.TOOLTIP);
    b();
    this.c.setText(2131362723);
  }

  public void setStyle(AudioRecorderTooltipView.ViewStyle paramViewStyle)
  {
    switch (AudioRecorderTooltipView.2.a[paramViewStyle.ordinal()])
    {
    default:
      throw new IllegalArgumentException("ViewStyle in Tooltip doesn't have a layout defined");
    case 1:
      this.d.setBackgroundDrawable(getResources().getDrawable(2130838726));
      this.e.setBackgroundDrawable(getResources().getDrawable(2130838727));
      this.c.setTextAppearance(getContext(), 2131492943);
    case 2:
    case 3:
    }
    while (true)
    {
      return;
      this.d.setBackgroundDrawable(getResources().getDrawable(2130838724));
      this.e.setBackgroundDrawable(getResources().getDrawable(2130838725));
      this.c.setTextAppearance(getContext(), 2131492941);
      continue;
      this.d.setBackgroundDrawable(getResources().getDrawable(2130838726));
      this.e.setBackgroundDrawable(getResources().getDrawable(2130838727));
      this.c.setTextAppearance(getContext(), 2131492942);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.audio.AudioRecorderTooltipView
 * JD-Core Version:    0.6.0
 */