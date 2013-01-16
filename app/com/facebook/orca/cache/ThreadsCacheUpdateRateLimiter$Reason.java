package com.facebook.orca.cache;

 enum ThreadsCacheUpdateRateLimiter$Reason
{
  static
  {
    MQTT_RECENTLY_DISCONNECTED = new Reason("MQTT_RECENTLY_DISCONNECTED", 1);
    MQTT_DISCONNECTED_AND_NOT_RECENTLY_UPDATED = new Reason("MQTT_DISCONNECTED_AND_NOT_RECENTLY_UPDATED", 2);
    MQTT_CONNECTED = new Reason("MQTT_CONNECTED", 3);
    OLD_DATA = new Reason("OLD_DATA", 4);
    DATA_KNOWN_TO_BE_STALE = new Reason("DATA_KNOWN_TO_BE_STALE", 5);
    DEFAULT = new Reason("DEFAULT", 6);
    Reason[] arrayOfReason = new Reason[7];
    arrayOfReason[0] = SPECIFIC_INTENTION;
    arrayOfReason[1] = MQTT_RECENTLY_DISCONNECTED;
    arrayOfReason[2] = MQTT_DISCONNECTED_AND_NOT_RECENTLY_UPDATED;
    arrayOfReason[3] = MQTT_CONNECTED;
    arrayOfReason[4] = OLD_DATA;
    arrayOfReason[5] = DATA_KNOWN_TO_BE_STALE;
    arrayOfReason[6] = DEFAULT;
    $VALUES = arrayOfReason;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.cache.ThreadsCacheUpdateRateLimiter.Reason
 * JD-Core Version:    0.6.0
 */