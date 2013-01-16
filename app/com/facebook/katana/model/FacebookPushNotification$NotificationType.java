package com.facebook.katana.model;

public enum FacebookPushNotification$NotificationType
{
  static
  {
    MSG = new NotificationType("MSG", 1);
    CHAT = new NotificationType("CHAT", 2);
    WALL = new NotificationType("WALL", 3);
    EVENT = new NotificationType("EVENT", 4);
    FRIEND = new NotificationType("FRIEND", 5);
    GROUP_ACTIVITY = new NotificationType("GROUP_ACTIVITY", 6);
    NEARBY = new NotificationType("NEARBY", 7);
    PHOTO_TAG = new NotificationType("PHOTO_TAG", 8);
    PHOTO_TAG_REQUEST = new NotificationType("PHOTO_TAG_REQUEST", 9);
    PHOTO_TAGGED_BY_NON_OWNER = new NotificationType("PHOTO_TAGGED_BY_NON_OWNER", 10);
    FRIEND_CONFIRMED = new NotificationType("FRIEND_CONFIRMED", 11);
    COMMENT = new NotificationType("COMMENT", 12);
    COMMENT_MENTION = new NotificationType("COMMENT_MENTION", 13);
    MENTION = new NotificationType("MENTION", 14);
    LIKE = new NotificationType("LIKE", 15);
    PLACE_TAG = new NotificationType("PLACE_TAG", 16);
    APP_REQUEST = new NotificationType("APP_REQUEST", 17);
    CODE_GENERATOR = new NotificationType("CODE_GENERATOR", 18);
    CLOSE_FRIEND_ACTIVITY = new NotificationType("CLOSE_FRIEND_ACTIVITY", 19);
    TAGGED_WITH_STORY = new NotificationType("TAGGED_WITH_STORY", 20);
    SHARE_WALL_CREATE = new NotificationType("SHARE_WALL_CREATE", 21);
    ACTIVATE_VAULT = new NotificationType("ACTIVATE_VAULT", 22);
    BIRTHDAY_REMINDER = new NotificationType("BIRTHDAY_REMINDER", 23);
    GIFT_RECIPIENT = new NotificationType("GIFT_RECIPIENT", 24);
    BACKGROUND_LOCATION = new NotificationType("BACKGROUND_LOCATION", 25);
    STALE_CLIENT_NOTIFICATION = new NotificationType("STALE_CLIENT_NOTIFICATION", 26);
    DEFAULT = new NotificationType("DEFAULT", 27);
    NotificationType[] arrayOfNotificationType = new NotificationType[28];
    arrayOfNotificationType[0] = UNKNOWN;
    arrayOfNotificationType[1] = MSG;
    arrayOfNotificationType[2] = CHAT;
    arrayOfNotificationType[3] = WALL;
    arrayOfNotificationType[4] = EVENT;
    arrayOfNotificationType[5] = FRIEND;
    arrayOfNotificationType[6] = GROUP_ACTIVITY;
    arrayOfNotificationType[7] = NEARBY;
    arrayOfNotificationType[8] = PHOTO_TAG;
    arrayOfNotificationType[9] = PHOTO_TAG_REQUEST;
    arrayOfNotificationType[10] = PHOTO_TAGGED_BY_NON_OWNER;
    arrayOfNotificationType[11] = FRIEND_CONFIRMED;
    arrayOfNotificationType[12] = COMMENT;
    arrayOfNotificationType[13] = COMMENT_MENTION;
    arrayOfNotificationType[14] = MENTION;
    arrayOfNotificationType[15] = LIKE;
    arrayOfNotificationType[16] = PLACE_TAG;
    arrayOfNotificationType[17] = APP_REQUEST;
    arrayOfNotificationType[18] = CODE_GENERATOR;
    arrayOfNotificationType[19] = CLOSE_FRIEND_ACTIVITY;
    arrayOfNotificationType[20] = TAGGED_WITH_STORY;
    arrayOfNotificationType[21] = SHARE_WALL_CREATE;
    arrayOfNotificationType[22] = ACTIVATE_VAULT;
    arrayOfNotificationType[23] = BIRTHDAY_REMINDER;
    arrayOfNotificationType[24] = GIFT_RECIPIENT;
    arrayOfNotificationType[25] = BACKGROUND_LOCATION;
    arrayOfNotificationType[26] = STALE_CLIENT_NOTIFICATION;
    arrayOfNotificationType[27] = DEFAULT;
    $VALUES = arrayOfNotificationType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.FacebookPushNotification.NotificationType
 * JD-Core Version:    0.6.0
 */