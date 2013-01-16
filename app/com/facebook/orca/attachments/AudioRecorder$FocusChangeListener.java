package com.facebook.orca.attachments;

import android.media.AudioManager.OnAudioFocusChangeListener;
import com.facebook.orca.common.util.AndroidThreadUtil;

class AudioRecorder$FocusChangeListener
  implements AudioManager.OnAudioFocusChangeListener
{
  private AudioRecorder$FocusChangeListener(AudioRecorder paramAudioRecorder)
  {
  }

  public void onAudioFocusChange(int paramInt)
  {
    AudioRecorder.j(this.a).a();
    switch (paramInt)
    {
    case -3:
    case -2:
    case 0:
    case 1:
    default:
    case -1:
    }
    while (true)
    {
      return;
      AudioRecorder.a(this.a);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.attachments.AudioRecorder.FocusChangeListener
 * JD-Core Version:    0.6.0
 */