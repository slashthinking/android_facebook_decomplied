package com.facebook.feed.util.event;

public class PhotoEvents$GalleryPhotoAnimationEndedEvent extends FeedEvent
{
  public final long a;
  public final String[] b;
  public final long[] c;
  public final String[] d;
  public final String e;

  public PhotoEvents$GalleryPhotoAnimationEndedEvent(long paramLong, String[] paramArrayOfString1, long[] paramArrayOfLong, String[] paramArrayOfString2, String paramString)
  {
    this.a = paramLong;
    this.b = paramArrayOfString1;
    this.c = paramArrayOfLong;
    this.d = paramArrayOfString2;
    this.e = paramString;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.util.event.PhotoEvents.GalleryPhotoAnimationEndedEvent
 * JD-Core Version:    0.6.0
 */