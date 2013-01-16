package com.facebook.orca.attachments;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.widget.CustomLinearLayout;

public class AudioPlayerBubbleView extends CustomLinearLayout
{
  private final ImageView a;
  private final View b;
  private final TextView c;
  private Drawable d;
  private Drawable e;
  private boolean f;
  private boolean g;

  public AudioPlayerBubbleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setContentView(2130903314);
    this.a = ((ImageView)b(2131297189));
    this.b = b(2131297190);
    this.c = ((TextView)b(2131297191));
    this.f = false;
  }

  private void a()
  {
    Drawable localDrawable1 = this.a.getBackground();
    if ((this.g) && ((localDrawable1 instanceof AnimationDrawable)))
    {
      this.a.setImageDrawable(null);
      ((AnimationDrawable)localDrawable1).start();
      return;
    }
    if ((localDrawable1 instanceof AnimationDrawable))
      ((AnimationDrawable)localDrawable1).stop();
    ImageView localImageView = this.a;
    if (this.f);
    for (Drawable localDrawable2 = this.e; ; localDrawable2 = this.d)
    {
      localImageView.setImageDrawable(localDrawable2);
      break;
    }
  }

  public void setIsLoading(boolean paramBoolean)
  {
    this.g = paramBoolean;
    a();
  }

  public void setIsPlaying(boolean paramBoolean)
  {
    this.f = paramBoolean;
    a();
  }

  public void setTimerText(String paramString)
  {
    this.c.setText(paramString);
  }

  public void setType(AudioPlayerBubbleView.Type paramType)
  {
    int i;
    int j;
    int k;
    int m;
    int n;
    int i1;
    switch (AudioPlayerBubbleView.1.a[paramType.ordinal()])
    {
    default:
      return;
    case 1:
      this.a.setBackgroundResource(2130838480);
      i = 2130838759;
      j = 2130838766;
      k = 2130838778;
      m = 2130839060;
      n = 2130838774;
      i1 = 2130838770;
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      setBackgroundDrawable(getResources().getDrawable(i));
      BitmapDrawable localBitmapDrawable = (BitmapDrawable)getResources().getDrawable(j);
      localBitmapDrawable.setTileModeX(Shader.TileMode.REPEAT);
      this.b.setBackgroundDrawable(localBitmapDrawable);
      this.c.setBackgroundDrawable(getResources().getDrawable(k));
      this.c.setTextColor(getResources().getColor(m));
      this.d = getResources().getDrawable(n);
      this.e = getResources().getDrawable(i1);
      a();
      break;
      this.a.setBackgroundResource(2130838479);
      i = 2130838752;
      j = 2130838764;
      k = 2130838776;
      m = 2130839058;
      n = 2130838772;
      i1 = 2130838768;
      continue;
      i = 2130838762;
      j = 2130838767;
      k = 2130838779;
      m = 2130839061;
      n = 2130838775;
      i1 = 2130838771;
      continue;
      i = 2130838755;
      j = 2130838765;
      k = 2130838777;
      m = 2130839059;
      n = 2130838773;
      i1 = 2130838769;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.attachments.AudioPlayerBubbleView
 * JD-Core Version:    0.6.0
 */