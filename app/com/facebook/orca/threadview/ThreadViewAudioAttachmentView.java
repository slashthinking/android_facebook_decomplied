package com.facebook.orca.threadview;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.Toast;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.annotations.ForUiThread;
import com.facebook.orca.attachments.AudioAttachmentData;
import com.facebook.orca.attachments.AudioPlayerBubbleView;
import com.facebook.orca.attachments.AudioPlayerBubbleView.Type;
import com.facebook.orca.attachments.ClipProgressLayout;
import com.facebook.orca.audio.AudioClipPlayer;
import com.facebook.orca.audio.AudioClipPlayer.Callback;
import com.facebook.orca.audio.AudioClipPlayerQueue;
import com.facebook.orca.audio.AudioUriCache;
import com.facebook.orca.audio.FetchAudioExecutor;
import com.facebook.orca.audio.FetchAudioParams;
import com.facebook.orca.common.util.SizeUtil;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomViewGroup;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

public class ThreadViewAudioAttachmentView extends CustomViewGroup
{
  private static final Class<?> a = ThreadViewAudioAttachmentView.class;
  private final AudioUriCache b;
  private final AudioClipPlayerQueue c;
  private final FetchAudioExecutor d;
  private final Executor e;
  private final AnalyticsLogger f;
  private final AudioPlayerBubbleView g;
  private final AudioPlayerBubbleView h;
  private final ClipProgressLayout i;
  private final AudioClipPlayer.Callback j = new ThreadViewAudioAttachmentView.1(this);
  private AudioClipPlayer k;
  private ListenableFuture<Uri> l;
  private ThreadViewAudioAttachmentView.AudioState m = ThreadViewAudioAttachmentView.AudioState.INIT;
  private AudioAttachmentData n;
  private Uri o;
  private long p = -1L;

  public ThreadViewAudioAttachmentView(Context paramContext)
  {
    this(paramContext, null);
  }

  public ThreadViewAudioAttachmentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    FbInjector localFbInjector = FbInjector.a(paramContext);
    this.b = ((AudioUriCache)localFbInjector.a(AudioUriCache.class));
    this.c = ((AudioClipPlayerQueue)localFbInjector.a(AudioClipPlayerQueue.class));
    this.d = ((FetchAudioExecutor)localFbInjector.a(FetchAudioExecutor.class));
    this.e = ((Executor)localFbInjector.a(Executor.class, ForUiThread.class));
    this.f = ((AnalyticsLogger)localFbInjector.a(AnalyticsLogger.class));
    setContentView(2130903313);
    this.g = ((AudioPlayerBubbleView)getView(2131297186));
    this.h = ((AudioPlayerBubbleView)getView(2131297188));
    this.i = ((ClipProgressLayout)getView(2131297187));
    ThreadViewAudioAttachmentView.2 local2 = new ThreadViewAudioAttachmentView.2(this);
    this.g.setOnClickListener(local2);
    this.h.setOnClickListener(local2);
    ThreadViewAudioAttachmentView.3 local3 = new ThreadViewAudioAttachmentView.3(this);
    this.g.setOnLongClickListener(local3);
    this.h.setOnLongClickListener(local3);
  }

  private int a(int paramInt)
  {
    int i1 = SizeUtil.a(getContext(), 60.0F);
    if ((this.p != -1L) && (paramInt > 0))
      i1 = Math.min(Math.max(i1, i1 + (int)((1.0D - Math.pow(10.0D, Math.max(5000.0D, this.p) / 1000.0D / -30.0D)) * (paramInt - i1))), paramInt);
    return i1;
  }

  private void a(long paramLong)
  {
    if (paramLong == -1L);
    while (true)
    {
      return;
      String str = b(paramLong);
      this.g.setTimerText(str);
      this.h.setTimerText(str);
    }
  }

  private void a(Uri paramUri)
  {
    this.o = paramUri;
    this.g.setIsLoading(false);
    this.m = ThreadViewAudioAttachmentView.AudioState.DOWNLOADED;
    AudioClipPlayer localAudioClipPlayer = this.c.b(paramUri);
    if (localAudioClipPlayer != null)
    {
      localAudioClipPlayer.a(this.j);
      this.k = localAudioClipPlayer;
    }
  }

  private String b(long paramLong)
  {
    int i1 = (int)(paramLong / 1000L);
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(i1 / 60);
    arrayOfObject[1] = Integer.valueOf(i1 % 60);
    return StringLocaleUtil.a("%d:%02d", arrayOfObject);
  }

  private void b(Uri paramUri)
  {
    if (this.l != null)
      this.l.cancel(false);
    this.l = this.d.a(new FetchAudioParams(paramUri));
    ListenableFuture localListenableFuture = this.l;
    Futures.a(localListenableFuture, new ThreadViewAudioAttachmentView.4(this, localListenableFuture), this.e);
    this.g.setIsLoading(true);
  }

  private void e()
  {
    switch (ThreadViewAudioAttachmentView.5.b[this.m.ordinal()])
    {
    default:
    case 1:
    case 2:
    }
    while (true)
    {
      return;
      if (!h())
      {
        this.f.a(new HoneyClientEvent("audio_clips_playback_start").d("audio_clips"));
        this.k = this.c.a(this.o);
        this.k.a(this.j);
        continue;
      }
      if (this.k.f())
      {
        this.g.setIsPlaying(true);
        this.h.setIsPlaying(true);
        this.k.e();
        this.f.a(new HoneyClientEvent("audio_clips_playback_resume").d("audio_clips"));
        continue;
      }
      this.g.setIsPlaying(false);
      this.h.setIsPlaying(false);
      this.k.d();
      this.f.a(new HoneyClientEvent("audio_clips_playback_pause").d("audio_clips"));
      continue;
      this.f.a(new HoneyClientEvent("audio_clips_playback_error").d("audio_clips"));
      Toast.makeText(getContext(), getContext().getString(2131362715), 0).show();
    }
  }

  private void f()
  {
    boolean bool1 = true;
    AudioPlayerBubbleView localAudioPlayerBubbleView1 = this.g;
    boolean bool2;
    AudioPlayerBubbleView localAudioPlayerBubbleView2;
    if (!this.k.f())
    {
      bool2 = bool1;
      localAudioPlayerBubbleView1.setIsPlaying(bool2);
      localAudioPlayerBubbleView2 = this.h;
      if (this.k.f())
        break label52;
    }
    while (true)
    {
      localAudioPlayerBubbleView2.setIsPlaying(bool1);
      return;
      bool2 = false;
      break;
      label52: bool1 = false;
    }
  }

  private void g()
  {
    b();
    if (this.m == ThreadViewAudioAttachmentView.AudioState.DOWNLOADED)
    {
      this.g.setIsPlaying(false);
      this.h.setIsPlaying(false);
    }
  }

  private boolean h()
  {
    if ((this.o != null) && (this.k != null) && (this.k.b().equals(this.o)) && (this.k.i()));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public void a()
  {
    if (h())
      f();
    while (true)
    {
      return;
      g();
    }
  }

  public void b()
  {
    a(this.p);
    this.i.setProgress(0.0D);
  }

  public void c()
  {
    int i1 = this.k.g();
    int i2 = this.k.h();
    a(i2 - 1000 * (i1 / 1000));
    double d1 = i1 / i2;
    this.i.setProgress(d1);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (View.MeasureSpec.getMode(paramInt1) == 0)
      super.onMeasure(paramInt1, paramInt2);
    while (true)
    {
      return;
      int i1 = View.MeasureSpec.getSize(paramInt1);
      int i2 = getPaddingLeft() + getPaddingRight();
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(i2 + a(i1 - i2), 1073741824), paramInt2);
    }
  }

  public void setAudioAttachmentData(AudioAttachmentData paramAudioAttachmentData)
  {
    Preconditions.checkNotNull(paramAudioAttachmentData);
    if (this.n == paramAudioAttachmentData)
      return;
    this.n = paramAudioAttachmentData;
    this.m = ThreadViewAudioAttachmentView.AudioState.INIT;
    this.p = paramAudioAttachmentData.a();
    a(this.p);
    if (this.k != null)
    {
      this.k.b(this.j);
      this.k = null;
    }
    Uri localUri1 = paramAudioAttachmentData.b();
    if (localUri1 == null)
    {
      g();
      this.g.setIsLoading(true);
    }
    while (true)
    {
      requestLayout();
      break;
      Uri localUri2 = this.b.a(localUri1);
      if (localUri2 == null)
      {
        g();
        b(localUri1);
        continue;
      }
      a(localUri2);
      a();
    }
  }

  public void setForMeUser(boolean paramBoolean)
  {
    AudioPlayerBubbleView localAudioPlayerBubbleView1 = this.g;
    AudioPlayerBubbleView.Type localType1;
    AudioPlayerBubbleView localAudioPlayerBubbleView2;
    if (paramBoolean)
    {
      localType1 = AudioPlayerBubbleView.Type.SELF_NORMAL;
      localAudioPlayerBubbleView1.setType(localType1);
      localAudioPlayerBubbleView2 = this.h;
      if (!paramBoolean)
        break label48;
    }
    label48: for (AudioPlayerBubbleView.Type localType2 = AudioPlayerBubbleView.Type.SELF_HIGHLIGHTED; ; localType2 = AudioPlayerBubbleView.Type.OTHER_HIGHLIGHTED)
    {
      localAudioPlayerBubbleView2.setType(localType2);
      return;
      localType1 = AudioPlayerBubbleView.Type.OTHER_NORMAL;
      break;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadViewAudioAttachmentView
 * JD-Core Version:    0.6.0
 */