package com.facebook.orca.audio;

import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.net.Uri;
import java.util.HashMap;
import javax.inject.Provider;

public class AudioClipPlayerQueue
{
  private final AudioManager a;
  private final Provider<AudioClipPlayer> b;
  private final VolumeControlStreamManager c;
  private final HashMap<Uri, AudioClipPlayer> d;
  private AudioClipPlayer e;
  private AudioManager.OnAudioFocusChangeListener f = new AudioClipPlayerQueue.1(this);

  public AudioClipPlayerQueue(AudioManager paramAudioManager, Provider<AudioClipPlayer> paramProvider, VolumeControlStreamManager paramVolumeControlStreamManager)
  {
    this.a = paramAudioManager;
    this.b = paramProvider;
    this.c = paramVolumeControlStreamManager;
    this.d = new HashMap();
  }

  private AudioClipPlayer c(Uri paramUri)
  {
    AudioClipPlayer localAudioClipPlayer = (AudioClipPlayer)this.b.b();
    localAudioClipPlayer.a(paramUri);
    localAudioClipPlayer.a(new AudioClipPlayerQueue.2(this, paramUri));
    this.d.put(paramUri, localAudioClipPlayer);
    return localAudioClipPlayer;
  }

  private void c()
  {
    this.c.a(3);
  }

  private void d()
  {
    this.c.a(-2147483648);
  }

  private boolean e()
  {
    int i = 1;
    if (this.a.requestAudioFocus(this.f, 0, 2) == i);
    while (true)
    {
      return i;
      i = 0;
    }
  }

  private void f()
  {
    this.a.abandonAudioFocus(this.f);
  }

  public AudioClipPlayer a(Uri paramUri)
  {
    if (this.e != null)
      this.e.c();
    while (true)
    {
      this.e = c(paramUri);
      this.e.a();
      for (AudioClipPlayer localAudioClipPlayer = this.e; ; localAudioClipPlayer = null)
      {
        return localAudioClipPlayer;
        if (e())
          break;
      }
      c();
    }
  }

  public void a()
  {
    b();
    d();
  }

  public AudioClipPlayer b(Uri paramUri)
  {
    return (AudioClipPlayer)this.d.get(paramUri);
  }

  public void b()
  {
    if (this.e != null)
      this.e.c();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.audio.AudioClipPlayerQueue
 * JD-Core Version:    0.6.0
 */