package com.facebook.orca.audio;

import android.media.AudioManager;
import android.os.SystemClock;
import android.view.KeyEvent;

public class VolumeControlStreamManager
{
  private final AudioManager a;
  private int b = -2147483648;
  private long c;

  public VolumeControlStreamManager(AudioManager paramAudioManager)
  {
    this.a = paramAudioManager;
  }

  private void b(KeyEvent paramKeyEvent)
  {
    int i = paramKeyEvent.getKeyCode();
    switch (i)
    {
    default:
    case 24:
    case 25:
    case 164:
    }
    while (true)
    {
      return;
      AudioManager localAudioManager = this.a;
      if (i == 24);
      for (int j = 1; ; j = -1)
      {
        localAudioManager.adjustSuggestedStreamVolume(j, this.b, 17);
        break;
      }
      if (paramKeyEvent.getRepeatCount() != 0)
        continue;
    }
  }

  private void c(KeyEvent paramKeyEvent)
  {
    switch (paramKeyEvent.getKeyCode())
    {
    default:
    case 24:
    case 25:
    }
    while (true)
    {
      return;
      this.a.adjustSuggestedStreamVolume(0, this.b, 4);
      this.c = SystemClock.uptimeMillis();
    }
  }

  public void a(int paramInt)
  {
    this.b = paramInt;
  }

  public boolean a(KeyEvent paramKeyEvent)
  {
    int i = paramKeyEvent.getKeyCode();
    if ((i != 25) && (i != 24) && (i != 164) && (300L + this.c > SystemClock.uptimeMillis()))
      this.a.adjustSuggestedStreamVolume(0, this.b, 8);
    int j;
    if (i != 25)
    {
      j = 0;
      if (i != 24);
    }
    else
    {
      if (paramKeyEvent.getAction() != 0)
        break label83;
      b(paramKeyEvent);
    }
    while (true)
    {
      j = 1;
      return j;
      label83: c(paramKeyEvent);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.audio.VolumeControlStreamManager
 * JD-Core Version:    0.6.0
 */