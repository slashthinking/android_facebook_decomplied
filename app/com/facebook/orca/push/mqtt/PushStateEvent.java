package com.facebook.orca.push.mqtt;

public enum PushStateEvent
{
  private final int value;

  static
  {
    CHANNEL_CONNECTING = new PushStateEvent("CHANNEL_CONNECTING", 1, 1);
    CHANNEL_CONNECTED = new PushStateEvent("CHANNEL_CONNECTED", 2, 2);
    CHANNEL_DISCONNECTED = new PushStateEvent("CHANNEL_DISCONNECTED", 3, 3);
    SERVICE_STOPPED = new PushStateEvent("SERVICE_STOPPED", 4, 4);
    UNKNOWN = new PushStateEvent("UNKNOWN", 5, 5);
    PushStateEvent[] arrayOfPushStateEvent = new PushStateEvent[6];
    arrayOfPushStateEvent[0] = SERVICE_STARTED;
    arrayOfPushStateEvent[1] = CHANNEL_CONNECTING;
    arrayOfPushStateEvent[2] = CHANNEL_CONNECTED;
    arrayOfPushStateEvent[3] = CHANNEL_DISCONNECTED;
    arrayOfPushStateEvent[4] = SERVICE_STOPPED;
    arrayOfPushStateEvent[5] = UNKNOWN;
    $VALUES = arrayOfPushStateEvent;
  }

  private PushStateEvent(int paramInt)
  {
    this.value = paramInt;
  }

  public static PushStateEvent fromValue(int paramInt)
  {
    PushStateEvent[] arrayOfPushStateEvent = values();
    int i = arrayOfPushStateEvent.length;
    int j = 0;
    PushStateEvent localPushStateEvent;
    if (j < i)
    {
      localPushStateEvent = arrayOfPushStateEvent[j];
      if (localPushStateEvent.value != paramInt);
    }
    while (true)
    {
      return localPushStateEvent;
      j++;
      break;
      localPushStateEvent = UNKNOWN;
    }
  }

  public int toValue()
  {
    return this.value;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.mqtt.PushStateEvent
 * JD-Core Version:    0.6.0
 */