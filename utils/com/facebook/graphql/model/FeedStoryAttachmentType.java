package com.facebook.graphql.model;

import com.google.common.collect.ImmutableSet;
import java.util.Set;

public class FeedStoryAttachmentType
{
  public static final Set<String> a = ImmutableSet.a(str1, str2, str3, str4, str5, str6, arrayOfString);

  static
  {
    String str1 = FeedStoryAttachmentType.KnownAttachmentType.SHARE.toString();
    String str2 = FeedStoryAttachmentType.KnownAttachmentType.PHOTO.toString();
    String str3 = FeedStoryAttachmentType.KnownAttachmentType.ALBUM.toString();
    String str4 = FeedStoryAttachmentType.KnownAttachmentType.COUPON.toString();
    String str5 = FeedStoryAttachmentType.KnownAttachmentType.LIST.toString();
    String str6 = FeedStoryAttachmentType.KnownAttachmentType.ITEM_LIST.toString();
    String[] arrayOfString = new String[3];
    arrayOfString[0] = FeedStoryAttachmentType.KnownAttachmentType.POPULAR_OBJECTS.toString();
    arrayOfString[1] = FeedStoryAttachmentType.KnownAttachmentType.QUESTION.toString();
    arrayOfString[2] = FeedStoryAttachmentType.KnownAttachmentType.AVATAR_LIST.toString();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.FeedStoryAttachmentType
 * JD-Core Version:    0.6.2
 */