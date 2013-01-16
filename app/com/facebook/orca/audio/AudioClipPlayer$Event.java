package com.facebook.orca.audio;

public enum AudioClipPlayer$Event
{
  static
  {
    PLAYBACK_ERROR = new Event("PLAYBACK_ERROR", 1);
    PLAYBACK_STOPPED = new Event("PLAYBACK_STOPPED", 2);
    PLAYBACK_COMPLETED = new Event("PLAYBACK_COMPLETED", 3);
    PLAYBACK_POSITION_UPDATED = new Event("PLAYBACK_POSITION_UPDATED", 4);
    Event[] arrayOfEvent = new Event[5];
    arrayOfEvent[0] = PLAYBACK_STARTED;
    arrayOfEvent[1] = PLAYBACK_ERROR;
    arrayOfEvent[2] = PLAYBACK_STOPPED;
    arrayOfEvent[3] = PLAYBACK_COMPLETED;
    arrayOfEvent[4] = PLAYBACK_POSITION_UPDATED;
    $VALUES = arrayOfEvent;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.audio.AudioClipPlayer.Event
 * JD-Core Version:    0.6.0
 */