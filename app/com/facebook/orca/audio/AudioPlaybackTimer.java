package com.facebook.orca.audio;

import android.media.MediaPlayer;
import com.facebook.orca.common.util.Clock;

public class AudioPlaybackTimer
{
  private final Clock a;
  private MediaPlayer b;
  private long c;
  private int d;
  private int e;

  public AudioPlaybackTimer(Clock paramClock)
  {
    this.a = paramClock;
  }

  public int a()
  {
    int i;
    if (!this.b.isPlaying())
      i = this.e;
    while (true)
    {
      return i;
      i = this.b.getCurrentPosition();
      if (i > 0);
      while (true)
      {
        if (i <= this.e)
          break label71;
        this.d = i;
        this.c = this.a.a();
        this.e = this.d;
        break;
        i = 0;
      }
      label71: i = (int)(this.a.a() - this.c) + this.d;
      if (i > this.b.getDuration())
      {
        i = this.b.getDuration();
        continue;
      }
      this.e = i;
    }
  }

  public void a(MediaPlayer paramMediaPlayer)
  {
    this.b = paramMediaPlayer;
    this.d = -1;
  }

  public void b()
  {
    this.d = this.e;
    this.c = this.a.a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.audio.AudioPlaybackTimer
 * JD-Core Version:    0.6.0
 */