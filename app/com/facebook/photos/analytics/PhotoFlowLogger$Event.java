package com.facebook.photos.analytics;

 enum PhotoFlowLogger$Event
{
  static
  {
    LAUNCHED_MULTIPICKER = new Event("LAUNCHED_MULTIPICKER", 1);
    EXTERNAL_VIDEO = new Event("EXTERNAL_VIDEO", 2);
    EXTERNAL_PHOTO = new Event("EXTERNAL_PHOTO", 3);
    ROTATE = new Event("ROTATE", 4);
    PICKED_MEDIA = new Event("PICKED_MEDIA", 5);
    PICKED_MEDIA_IMPLICIT = new Event("PICKED_MEDIA_IMPLICIT", 6);
    COMPOSER_UPLOAD_SUCCESS = new Event("COMPOSER_UPLOAD_SUCCESS", 7);
    UPLOAD_EXCEPTION = new Event("UPLOAD_EXCEPTION", 8);
    UPLOAD_STARTED = new Event("UPLOAD_STARTED", 9);
    TAG_PHOTO = new Event("TAG_PHOTO", 10);
    CAMERA_FLOW = new Event("CAMERA_FLOW", 11);
    CAMERA_START = new Event("CAMERA_START", 12);
    CAMERA_FLASH = new Event("CAMERA_FLASH", 13);
    CAMERA_TAKE_PHOTO = new Event("CAMERA_TAKE_PHOTO", 14);
    CAMERA_LOADING = new Event("CAMERA_LOADING", 15);
    CAMERA_DONE_LOADING = new Event("CAMERA_DONE_LOADING", 16);
    CAMERA_EXCEPTION = new Event("CAMERA_EXCEPTION", 17);
    COMPOSER_INIT = new Event("COMPOSER_INIT", 18);
    COMPOSER_MEDIA_UPLOAD_INIT = new Event("COMPOSER_MEDIA_UPLOAD_INIT", 19);
    COMPOSER_POST = new Event("COMPOSER_POST", 20);
    COMPOSER_POST_SUCCESS = new Event("COMPOSER_POST_SUCCESS", 21);
    COMPOSER_POST_USER_CANCEL_UPLOAD_MEDIA = new Event("COMPOSER_POST_USER_CANCEL_UPLOAD_MEDIA", 22);
    COMPOSER_POST_FAILURE = new Event("COMPOSER_POST_FAILURE", 23);
    COMPOSER_POST_RETRY = new Event("COMPOSER_POST_RETRY", 24);
    TAG_INITIATED = new Event("TAG_INITIATED", 25);
    TAG_START_TYPING = new Event("TAG_START_TYPING", 26);
    TAG_CREATED = new Event("TAG_CREATED", 27);
    TAG_DELETED = new Event("TAG_DELETED", 28);
    TAG_CANCELLED = new Event("TAG_CANCELLED", 29);
    CAMERA_REVIEW = new Event("CAMERA_REVIEW", 30);
    VIDEO_PLAYED_IN_REVIEW = new Event("VIDEO_PLAYED_IN_REVIEW", 31);
    CAMERA_REVIEW_ACCEPT = new Event("CAMERA_REVIEW_ACCEPT", 32);
    CAMERA_REVIEW_REJECT = new Event("CAMERA_REVIEW_REJECT", 33);
    Event[] arrayOfEvent = new Event[34];
    arrayOfEvent[0] = STARTED_FLOW_MULTIPICKER;
    arrayOfEvent[1] = LAUNCHED_MULTIPICKER;
    arrayOfEvent[2] = EXTERNAL_VIDEO;
    arrayOfEvent[3] = EXTERNAL_PHOTO;
    arrayOfEvent[4] = ROTATE;
    arrayOfEvent[5] = PICKED_MEDIA;
    arrayOfEvent[6] = PICKED_MEDIA_IMPLICIT;
    arrayOfEvent[7] = COMPOSER_UPLOAD_SUCCESS;
    arrayOfEvent[8] = UPLOAD_EXCEPTION;
    arrayOfEvent[9] = UPLOAD_STARTED;
    arrayOfEvent[10] = TAG_PHOTO;
    arrayOfEvent[11] = CAMERA_FLOW;
    arrayOfEvent[12] = CAMERA_START;
    arrayOfEvent[13] = CAMERA_FLASH;
    arrayOfEvent[14] = CAMERA_TAKE_PHOTO;
    arrayOfEvent[15] = CAMERA_LOADING;
    arrayOfEvent[16] = CAMERA_DONE_LOADING;
    arrayOfEvent[17] = CAMERA_EXCEPTION;
    arrayOfEvent[18] = COMPOSER_INIT;
    arrayOfEvent[19] = COMPOSER_MEDIA_UPLOAD_INIT;
    arrayOfEvent[20] = COMPOSER_POST;
    arrayOfEvent[21] = COMPOSER_POST_SUCCESS;
    arrayOfEvent[22] = COMPOSER_POST_USER_CANCEL_UPLOAD_MEDIA;
    arrayOfEvent[23] = COMPOSER_POST_FAILURE;
    arrayOfEvent[24] = COMPOSER_POST_RETRY;
    arrayOfEvent[25] = TAG_INITIATED;
    arrayOfEvent[26] = TAG_START_TYPING;
    arrayOfEvent[27] = TAG_CREATED;
    arrayOfEvent[28] = TAG_DELETED;
    arrayOfEvent[29] = TAG_CANCELLED;
    arrayOfEvent[30] = CAMERA_REVIEW;
    arrayOfEvent[31] = VIDEO_PLAYED_IN_REVIEW;
    arrayOfEvent[32] = CAMERA_REVIEW_ACCEPT;
    arrayOfEvent[33] = CAMERA_REVIEW_REJECT;
    $VALUES = arrayOfEvent;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.analytics.PhotoFlowLogger.Event
 * JD-Core Version:    0.6.0
 */