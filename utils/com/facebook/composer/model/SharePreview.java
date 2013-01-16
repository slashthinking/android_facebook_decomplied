package com.facebook.composer.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedStoryAttachment;
import com.facebook.graphql.model.FeedStoryAttachmentTarget;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLObjectType.ObjectType;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.Shareable;
import com.facebook.orca.common.util.StringUtil;

public class SharePreview
  implements Parcelable
{
  public static final Parcelable.Creator<SharePreview> CREATOR = new SharePreview.1();
  public final String a;
  public final String b;
  public final String c;
  public final String d;
  public final String e;

  private SharePreview(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
  }

  public SharePreview(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
  }

  public static SharePreview a(LinksPreview paramLinksPreview)
  {
    String str = paramLinksPreview.a();
    return new SharePreview(paramLinksPreview.name, paramLinksPreview.caption, paramLinksPreview.description, str, paramLinksPreview.href);
  }

  public static SharePreview a(FeedStory paramFeedStory)
  {
    boolean bool1 = paramFeedStory.M();
    SharePreview localSharePreview = null;
    if (!bool1);
    while (true)
    {
      return localSharePreview;
      FeedStoryAttachment localFeedStoryAttachment = paramFeedStory.N();
      localSharePreview = null;
      if (localFeedStoryAttachment != null)
      {
        String str = localFeedStoryAttachment.title;
        localSharePreview = null;
        if (str != null)
        {
          Shareable localShareable = paramFeedStory.shareable;
          GraphQLObjectType.ObjectType localObjectType = localShareable.b();
          FeedStoryAttachmentTarget localFeedStoryAttachmentTarget1 = localFeedStoryAttachment.target;
          switch (SharePreview.2.a[localObjectType.ordinal()])
          {
          default:
            localSharePreview = null;
            break;
          case 1:
          case 2:
          case 3:
          case 4:
            GraphQLMedia localGraphQLMedia = localFeedStoryAttachment.media;
            if ((localGraphQLMedia == null) || (!localShareable.id.equals(localGraphQLMedia.id)))
            {
              FeedStoryAttachmentTarget localFeedStoryAttachmentTarget2 = localFeedStoryAttachment.target;
              localSharePreview = null;
              if (localFeedStoryAttachmentTarget2 != null)
              {
                boolean bool2 = localShareable.id.equals(localFeedStoryAttachmentTarget1.id);
                localSharePreview = null;
                if (!bool2);
              }
            }
            else
            {
              localSharePreview = new SharePreview(localFeedStoryAttachment.title, a(localFeedStoryAttachment), b(localFeedStoryAttachment), a(localGraphQLMedia), null);
            }
            break;
          }
        }
      }
    }
  }

  private static String a(FeedStoryAttachment paramFeedStoryAttachment)
  {
    String str = a(paramFeedStoryAttachment.b());
    if (str != null);
    while (true)
    {
      return str;
      str = b(paramFeedStoryAttachment.a);
    }
  }

  private static String a(GraphQLMedia paramGraphQLMedia)
  {
    if ((paramGraphQLMedia != null) && (paramGraphQLMedia.image != null));
    for (String str = paramGraphQLMedia.image.uri; ; str = null)
      return str;
  }

  private static String a(GraphQLTextWithEntities paramGraphQLTextWithEntities)
  {
    String str = null;
    if (paramGraphQLTextWithEntities == null);
    while (true)
    {
      return str;
      boolean bool = StringUtil.a(paramGraphQLTextWithEntities.text);
      str = null;
      if (!bool)
        str = paramGraphQLTextWithEntities.text;
    }
  }

  private static String b(FeedStory paramFeedStory)
  {
    String str = null;
    if (paramFeedStory == null);
    while (true)
    {
      return str;
      GraphQLProfile localGraphQLProfile = paramFeedStory.a();
      str = null;
      if (localGraphQLProfile != null)
        str = localGraphQLProfile.name;
    }
  }

  private static String b(FeedStoryAttachment paramFeedStoryAttachment)
  {
    String str = a(paramFeedStoryAttachment.description);
    if (str != null);
    while (true)
    {
      return str;
      if (paramFeedStoryAttachment.a != null)
        str = a(paramFeedStoryAttachment.a.title);
      else
        str = null;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return "SharePreview{title='" + this.a + '\'' + ", subTitle='" + this.b + '\'' + ", summary='" + this.c + '\'' + ", imageUrl='" + this.d + '\'' + ", clickTarget='" + this.e + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.composer.model.SharePreview
 * JD-Core Version:    0.6.2
 */