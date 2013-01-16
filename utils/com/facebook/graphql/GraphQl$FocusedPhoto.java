package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$FocusedPhoto
{
  public static GraphQlQueryFocusedPhoto.FocusedPhotoField a(GraphQlQueryPhoto paramGraphQlQueryPhoto)
  {
    return new GraphQlQueryFocusedPhoto.FocusedPhotoField("photo", paramGraphQlQueryPhoto);
  }

  public static GraphQlQueryFocusedPhoto.FocusedPhotoField a(GraphQlQueryVect2 paramGraphQlQueryVect2)
  {
    return new GraphQlQueryFocusedPhoto.FocusedPhotoField("focus", paramGraphQlQueryVect2);
  }

  public static GraphQlQueryFocusedPhoto a(GraphQlQueryFocusedPhoto.FocusedPhotoField[] paramArrayOfFocusedPhotoField)
  {
    return new GraphQlQueryFocusedPhoto(ImmutableList.a(paramArrayOfFocusedPhotoField), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.FocusedPhoto
 * JD-Core Version:    0.6.2
 */