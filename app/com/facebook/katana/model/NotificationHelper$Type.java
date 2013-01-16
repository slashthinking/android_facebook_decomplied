package com.facebook.katana.model;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

 enum NotificationHelper$Type
{
  private static final ImmutableMap<String, Type> NAME_TO;
  private final String name;

  static
  {
    int i = 0;
    STREAM = new Type("STREAM", 0, "stream");
    PHOTO = new Type("PHOTO", 1, "photo");
    PROFILE = new Type("PROFILE", 2, "friend");
    EVENT = new Type("EVENT", 3, "event");
    GROUP = new Type("GROUP", 4, "group");
    USER = new Type("USER", 5, "user");
    APP_REQUEST = new Type("APP_REQUEST", 6, "app_request");
    POKE = new Type("POKE", 7, "poke");
    PAGE = new Type("PAGE", 8, "page");
    NOTE = new Type("NOTE", 9, "note");
    ALBUM = new Type("ALBUM", 10, "album");
    VIDEO = new Type("VIDEO", 11, "video");
    CHECKIN = new Type("CHECKIN", 12, "checkin");
    UNKNOWN = new Type("UNKNOWN", 13, "");
    Type[] arrayOfType1 = new Type[14];
    arrayOfType1[0] = STREAM;
    arrayOfType1[1] = PHOTO;
    arrayOfType1[2] = PROFILE;
    arrayOfType1[3] = EVENT;
    arrayOfType1[4] = GROUP;
    arrayOfType1[5] = USER;
    arrayOfType1[6] = APP_REQUEST;
    arrayOfType1[7] = POKE;
    arrayOfType1[8] = PAGE;
    arrayOfType1[9] = NOTE;
    arrayOfType1[10] = ALBUM;
    arrayOfType1[11] = VIDEO;
    arrayOfType1[12] = CHECKIN;
    arrayOfType1[13] = UNKNOWN;
    $VALUES = arrayOfType1;
    ImmutableMap.Builder localBuilder = ImmutableMap.k();
    Type[] arrayOfType2 = values();
    int j = arrayOfType2.length;
    while (i < j)
    {
      Type localType = arrayOfType2[i];
      localBuilder.b(localType.name, localType);
      i++;
    }
    NAME_TO = localBuilder.b();
  }

  private NotificationHelper$Type(String paramString)
  {
    this.name = paramString;
  }

  private static Type of(String paramString)
  {
    Type localType = (Type)NAME_TO.get(paramString);
    if (localType != null);
    while (true)
    {
      return localType;
      localType = UNKNOWN;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.NotificationHelper.Type
 * JD-Core Version:    0.6.0
 */