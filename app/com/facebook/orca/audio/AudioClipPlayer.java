package com.facebook.orca.audio;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.debug.BLog;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.io.Closeables;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

public class AudioClipPlayer
{
  private static final Class<?> a = AudioClipPlayer.class;
  private final AndroidThreadUtil b;
  private final ListeningExecutorService c;
  private final Executor d;
  private final AudioPlaybackTimer e;
  private final Handler f;
  private final List<AudioClipPlayer.Callback> g;
  private Uri h;
  private MediaPlayer i;
  private ListenableFuture<Void> j;
  private final Runnable k = new AudioClipPlayer.1(this);

  AudioClipPlayer(AndroidThreadUtil paramAndroidThreadUtil, ListeningExecutorService paramListeningExecutorService, Executor paramExecutor, AudioPlaybackTimer paramAudioPlaybackTimer, Handler paramHandler)
  {
    this.b = paramAndroidThreadUtil;
    this.c = paramListeningExecutorService;
    this.d = paramExecutor;
    this.e = paramAudioPlaybackTimer;
    this.f = paramHandler;
    this.g = Lists.a();
  }

  private void a(AudioClipPlayer.Event paramEvent)
  {
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
      ((AudioClipPlayer.Callback)localIterator.next()).a(paramEvent);
  }

  private void j()
  {
    this.b.b();
    BLog.a(a, "Playing the audio clip: " + this.h);
    FileInputStream localFileInputStream = new FileInputStream(new File(this.h.getPath()));
    try
    {
      this.i.setDataSource(localFileInputStream.getFD());
      this.i.prepare();
      Closeables.a(localFileInputStream);
      this.i.start();
      return;
    }
    finally
    {
      Closeables.a(localFileInputStream);
    }
    throw localObject;
  }

  private void k()
  {
    this.f.removeCallbacks(this.k);
    if (this.i != null)
    {
      this.i.reset();
      this.i.release();
      this.i = null;
    }
  }

  public void a()
  {
    this.i = new MediaPlayer();
    this.e.a(this.i);
    this.i.setOnCompletionListener(new AudioClipPlayer.2(this));
    this.i.setOnErrorListener(new AudioClipPlayer.3(this));
    this.j = this.c.a(new AudioClipPlayer.4(this));
    AudioClipPlayer.5 local5 = new AudioClipPlayer.5(this);
    Futures.a(this.j, local5, this.d);
  }

  public void a(Uri paramUri)
  {
    Preconditions.checkNotNull(paramUri);
    this.h = paramUri;
  }

  public void a(AudioClipPlayer.Callback paramCallback)
  {
    this.g.add(paramCallback);
  }

  public Uri b()
  {
    return this.h;
  }

  public void b(AudioClipPlayer.Callback paramCallback)
  {
    this.g.remove(paramCallback);
  }

  public void c()
  {
    if (this.j != null)
      this.j.cancel(false);
    k();
    a(AudioClipPlayer.Event.PLAYBACK_STOPPED);
  }

  public void d()
  {
    try
    {
      if ((this.i != null) && (this.i.isPlaying()))
        this.i.pause();
      this.f.removeCallbacks(this.k);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      while (true)
        BLog.e(a, "The player finished playing before pause() was called");
    }
  }

  public void e()
  {
    this.i.start();
    this.e.b();
    this.f.post(this.k);
  }

  public boolean f()
  {
    if ((this.i != null) && (!this.i.isPlaying()));
    for (int m = 1; ; m = 0)
      return m;
  }

  public int g()
  {
    return this.e.a();
  }

  public int h()
  {
    return this.i.getDuration();
  }

  public boolean i()
  {
    if (this.i != null);
    for (int m = 1; ; m = 0)
      return m;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.audio.AudioClipPlayer
 * JD-Core Version:    0.6.0
 */