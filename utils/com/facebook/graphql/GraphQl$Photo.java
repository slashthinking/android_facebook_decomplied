package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$Photo
{
  public static final GraphQlQueryPhoto.PhotoField a = new GraphQlQueryPhoto.PhotoField("id");
  public static final GraphQlQueryPhoto.PhotoField b = new GraphQlQueryPhoto.PhotoField("url.site(mobile)");
  public static final GraphQlQueryPhoto.PhotoField c = new GraphQlQueryPhoto.PhotoField("is_playable");
  public static final GraphQlQueryPhoto.PhotoField d = new GraphQlQueryPhoto.PhotoField("playable_url");
  public static final GraphQlQueryPhoto.PhotoField e = new GraphQlQueryPhoto.PhotoField("src");
  public static final GraphQlQueryPhoto.PhotoField f = new GraphQlQueryPhoto.PhotoField("created_time");
  public static final GraphQlQueryPhoto.PhotoField g = new GraphQlQueryPhoto.PhotoField("modified_time");
  public static final GraphQlQueryPhoto.PhotoField h = new GraphQlQueryPhoto.PhotoField("can_viewer_add_tags");

  public static GraphQlQueryPhoto.PhotoField a(GraphQlQueryFeedback paramGraphQlQueryFeedback)
  {
    return new GraphQlQueryPhoto.PhotoField("feedback", paramGraphQlQueryFeedback);
  }

  public static GraphQlQueryPhoto.PhotoField a(GraphQlQueryImage paramGraphQlQueryImage)
  {
    return new GraphQlQueryPhoto.PhotoField("image", paramGraphQlQueryImage);
  }

  public static GraphQlQueryPhoto a(GraphQlQueryPhoto.PhotoField[] paramArrayOfPhotoField)
  {
    return new GraphQlQueryPhoto(ImmutableList.a(paramArrayOfPhotoField), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.Photo
 * JD-Core Version:    0.6.2
 */