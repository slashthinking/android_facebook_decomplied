package com.facebook.orca.compose;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.LevelListDrawable;
import android.net.Uri;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.ImageView;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.activity.DivebarEnabledActivity;
import com.facebook.orca.attachments.AudioRecorder;
import com.facebook.orca.audio.AudioClipPlayerQueue;
import com.facebook.orca.audio.AudioRecorderTooltipController;
import com.facebook.orca.audio.AudioRecorderTooltipView.ViewStyle;
import com.facebook.orca.audio.AudioRecorderTopBarController;
import com.facebook.orca.common.ui.titlebar.DivebarController;
import com.facebook.orca.common.util.SizeUtil;
import com.facebook.orca.common.util.SystemClock;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.nux.OrcaNuxManager;
import com.facebook.widget.CustomViewGroup;

public class AudioComposerView extends CustomViewGroup
{
  private final AudioRecorder a;
  private final AudioRecorderTooltipController b;
  private final AudioRecorderTopBarController c;
  private final AudioClipPlayerQueue d;
  private final OrcaNuxManager e;
  private final AnalyticsLogger f;
  private final ImageView g;
  private final ImageView h;
  private final Button i;
  private final Runnable j = new AudioComposerView.1(this);
  private boolean k;
  private AudioComposerView.Listener l;
  private boolean m;
  private boolean n;
  private long o;
  private Rect p;
  private final AudioComposerView.MaximumLengthRecording q = new AudioComposerView.MaximumLengthRecording(this, null);

  public AudioComposerView(Context paramContext)
  {
    this(paramContext, null);
  }

  public AudioComposerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public AudioComposerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    FbInjector localFbInjector = getInjector();
    this.a = ((AudioRecorder)localFbInjector.a(AudioRecorder.class));
    this.b = new AudioRecorderTooltipController(this);
    this.c = ((AudioRecorderTopBarController)localFbInjector.a(AudioRecorderTopBarController.class));
    this.c.a(this);
    this.d = ((AudioClipPlayerQueue)localFbInjector.a(AudioClipPlayerQueue.class));
    this.e = ((OrcaNuxManager)localFbInjector.a(OrcaNuxManager.class));
    this.f = ((AnalyticsLogger)localFbInjector.a(AnalyticsLogger.class));
    setContentView(2130903312);
    this.g = ((ImageView)getView(2131297183));
    this.h = ((ImageView)getView(2131297184));
    this.i = ((Button)getView(2131297185));
    this.h.setOnTouchListener(new AudioComposerView.2(this));
    this.i.setOnClickListener(new AudioComposerView.3(this));
  }

  private void a(Uri paramUri)
  {
    this.f.a(new HoneyClientEvent("audio_clips_send").d("audio_clips"));
    this.l.a(this.a.a(paramUri, this.a.c()));
    this.e.m();
  }

  private void a(MotionEvent paramMotionEvent)
  {
    if ((!this.a.b()) && (!this.q.b()));
    while (true)
    {
      return;
      if ((c(paramMotionEvent)) && (!this.k))
      {
        if (this.q.b())
          this.c.c();
        while (true)
        {
          this.k = true;
          this.b.a(AudioRecorderTooltipView.ViewStyle.TOOLTIP);
          break;
          this.c.d();
        }
      }
      if ((c(paramMotionEvent)) || (!this.k))
        continue;
      if ((!this.m) || (!this.n))
      {
        this.a.a();
        continue;
      }
      this.k = false;
      this.b.a(AudioRecorderTooltipView.ViewStyle.TOOLTIP_HOVER_OFF);
      this.c.b();
    }
  }

  private void b(MotionEvent paramMotionEvent)
  {
    if (this.q.b())
      if (c(paramMotionEvent))
      {
        this.q.d();
        g();
      }
    while (true)
    {
      return;
      this.q.c();
      g();
      this.c.a();
      continue;
      if ((!this.a.b()) || (this.o == 0L) || (SystemClock.b().a() - this.o < 500L))
      {
        this.f.a(new HoneyClientEvent("audio_clips_cancelled_too_short").d("audio_clips"));
        this.a.a();
        g();
        this.b.b();
        continue;
      }
      if (!c(paramMotionEvent))
      {
        this.f.a(new HoneyClientEvent("audio_clips_cancelled_by_user").d("audio_clips"));
        this.a.a();
        g();
        this.c.a();
        continue;
      }
      postDelayed(new AudioComposerView.4(this), 300L);
      g();
    }
  }

  private void c()
  {
    if ((getContext() instanceof DivebarEnabledActivity))
      ((DivebarEnabledActivity)getContext()).m().l();
  }

  private boolean c(MotionEvent paramMotionEvent)
  {
    if (this.p == null)
    {
      int i3 = SizeUtil.a(getContext(), 60.0F);
      this.p = new Rect(this.h.getLeft(), this.h.getTop() - i3, this.h.getRight(), this.h.getBottom());
    }
    int i1 = Math.round(paramMotionEvent.getX()) + this.h.getLeft();
    int i2 = Math.round(paramMotionEvent.getY()) + this.h.getTop();
    return this.p.contains(i1, i2);
  }

  private void d()
  {
    if ((getContext() instanceof DivebarEnabledActivity))
      ((DivebarEnabledActivity)getContext()).m().m();
  }

  private void e()
  {
    this.b.e();
    this.h.setImageDrawable(getResources().getDrawable(2130838718));
  }

  private void f()
  {
    this.h.setImageDrawable(getResources().getDrawable(2130838717));
    c();
    this.d.b();
    this.k = true;
    this.b.f();
    this.c.d();
    postDelayed(this.j, 500L);
    Handler localHandler = new Handler();
    this.a.a(new AudioComposerView.5(this, localHandler));
  }

  private void g()
  {
    removeCallbacks(this.j);
    this.o = 0L;
    this.n = false;
    this.m = false;
    setVolumeLevel(0);
    this.b.d();
    this.b.f();
    this.c.d();
    this.h.setImageDrawable(getResources().getDrawable(2130838716));
    d();
  }

  private void setVolumeLevel(int paramInt)
  {
    ((LevelListDrawable)this.g.getDrawable()).setLevel(paramInt);
  }

  public void a()
  {
    this.f.a(new HoneyClientEvent("audio_clips_show_composer").d("audio_clips"));
    if (this.e.i())
      this.b.a();
  }

  public void b()
  {
    this.b.f();
  }

  protected void onDetachedFromWindow()
  {
    if (this.a.b())
      this.a.a(false);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.p = null;
  }

  public void setListener(AudioComposerView.Listener paramListener)
  {
    this.l = paramListener;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.compose.AudioComposerView
 * JD-Core Version:    0.6.0
 */