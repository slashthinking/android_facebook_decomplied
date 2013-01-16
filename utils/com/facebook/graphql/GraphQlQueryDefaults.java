package com.facebook.graphql;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.google.common.collect.ImmutableList;

public final class GraphQlQueryDefaults
{
  public static final GraphQlQueryTextWithEntities a;
  public static final GraphQlQueryTextWithEntities b;
  public static final ImmutableList<GraphQlQueryImage.ImageField> c;
  public static final GraphQlQueryImage d;
  public static final GraphQlQueryParam e;
  public static final GraphQlQueryImage f;
  public static final GraphQlQueryIcon g;
  public static final GraphQlQueryIcon h;
  public static final GraphQlQueryActor i;
  public static final GraphQlQueryProfile j;
  public static final GraphQlQueryPageInfo k;
  public static final GraphQlQueryAndroidAppConfig l;
  public static final GraphQlQueryReportInfo m;
  public static final GraphQlQueryVect2 n;
  public static final GraphQlQueryFeedback o;
  public static final GraphQlQueryPhoto p = GraphQl.Photo.a(arrayOfPhotoField);

  static
  {
    GraphQlQueryTextWithEntities.TextWithEntitiesField[] arrayOfTextWithEntitiesField = new GraphQlQueryTextWithEntities.TextWithEntitiesField[1];
    arrayOfTextWithEntitiesField[0] = GraphQl.TextWithEntities.a;
    a = GraphQl.TextWithEntities.a(arrayOfTextWithEntitiesField);
    GraphQlQueryTextWithEntities localGraphQlQueryTextWithEntities = a;
    GraphQlQueryEntityAtRange.EntityAtRangeField[] arrayOfEntityAtRangeField = new GraphQlQueryEntityAtRange.EntityAtRangeField[3];
    arrayOfEntityAtRangeField[0] = GraphQl.EntityAtRange.a;
    arrayOfEntityAtRangeField[1] = GraphQl.EntityAtRange.b;
    GraphQlQueryFieldEntity[] arrayOfGraphQlQueryFieldEntity = new GraphQlQueryFieldEntity[3];
    arrayOfGraphQlQueryFieldEntity[0] = GraphQl.User.a;
    arrayOfGraphQlQueryFieldEntity[1] = GraphQl.User.c;
    arrayOfGraphQlQueryFieldEntity[2] = GraphQl.User.b;
    arrayOfEntityAtRangeField[2] = GraphQl.EntityAtRange.a(GraphQl.Entity.a(arrayOfGraphQlQueryFieldEntity));
    b = localGraphQlQueryTextWithEntities.a(GraphQl.TextWithEntities.a(GraphQl.EntityAtRange.a(arrayOfEntityAtRangeField)));
    c = ImmutableList.a(GraphQl.Image.a, GraphQl.Image.b, GraphQl.Image.c);
    d = GraphQl.Image.a(c);
    e = GraphQlQueryParam.a("profile_image_size");
    GraphQlQueryImage.CallOnImage[] arrayOfCallOnImage = new GraphQlQueryImage.CallOnImage[1];
    arrayOfCallOnImage[0] = GraphQl.Image.a(e, e);
    f = GraphQl.Image.a(arrayOfCallOnImage).a(c);
    GraphQlQueryIcon.IconField[] arrayOfIconField = new GraphQlQueryIcon.IconField[3];
    arrayOfIconField[0] = GraphQl.Icon.b;
    arrayOfIconField[1] = GraphQl.Icon.c;
    arrayOfIconField[2] = GraphQl.Icon.d;
    g = GraphQl.Icon.a(arrayOfIconField);
    h = a();
    GraphQlQueryFieldActor[] arrayOfGraphQlQueryFieldActor = new GraphQlQueryFieldActor[3];
    arrayOfGraphQlQueryFieldActor[0] = GraphQl.User.a;
    arrayOfGraphQlQueryFieldActor[1] = GraphQl.Actor.a;
    arrayOfGraphQlQueryFieldActor[2] = GraphQl.Actor.a(f);
    i = GraphQl.Actor.a(arrayOfGraphQlQueryFieldActor);
    GraphQlQueryFieldProfile[] arrayOfGraphQlQueryFieldProfile = new GraphQlQueryFieldProfile[3];
    arrayOfGraphQlQueryFieldProfile[0] = GraphQl.User.a;
    arrayOfGraphQlQueryFieldProfile[1] = GraphQl.Profile.a;
    arrayOfGraphQlQueryFieldProfile[2] = GraphQl.Profile.a(f);
    j = GraphQl.Profile.a(arrayOfGraphQlQueryFieldProfile);
    GraphQlQueryPageInfo.PageInfoField[] arrayOfPageInfoField = new GraphQlQueryPageInfo.PageInfoField[4];
    arrayOfPageInfoField[0] = GraphQl.PageInfo.a;
    arrayOfPageInfoField[1] = GraphQl.PageInfo.b;
    arrayOfPageInfoField[2] = GraphQl.PageInfo.d;
    arrayOfPageInfoField[3] = GraphQl.PageInfo.c;
    k = GraphQl.PageInfo.a(arrayOfPageInfoField);
    GraphQlQueryAndroidAppConfig.AndroidAppConfigField[] arrayOfAndroidAppConfigField = new GraphQlQueryAndroidAppConfig.AndroidAppConfigField[4];
    arrayOfAndroidAppConfigField[0] = GraphQl.AndroidAppConfig.d;
    arrayOfAndroidAppConfigField[1] = GraphQl.AndroidAppConfig.b;
    arrayOfAndroidAppConfigField[2] = GraphQl.AndroidAppConfig.c;
    arrayOfAndroidAppConfigField[3] = GraphQl.AndroidAppConfig.a;
    l = GraphQl.AndroidAppConfig.a(arrayOfAndroidAppConfigField);
    GraphQlQueryReportInfo.ReportInfoField[] arrayOfReportInfoField = new GraphQlQueryReportInfo.ReportInfoField[1];
    arrayOfReportInfoField[0] = GraphQl.ReportInfo.a;
    m = GraphQl.ReportInfo.a(arrayOfReportInfoField);
    GraphQlQueryVect2.Vect2Field[] arrayOfVect2Field = new GraphQlQueryVect2.Vect2Field[2];
    arrayOfVect2Field[0] = GraphQl.Vect2.a;
    arrayOfVect2Field[1] = GraphQl.Vect2.b;
    n = GraphQl.Vect2.a(arrayOfVect2Field);
    GraphQlQueryFeedback.FeedbackField[] arrayOfFeedbackField = new GraphQlQueryFeedback.FeedbackField[7];
    arrayOfFeedbackField[0] = GraphQl.Feedback.a;
    arrayOfFeedbackField[1] = GraphQl.Feedback.d;
    arrayOfFeedbackField[2] = GraphQl.Feedback.c;
    arrayOfFeedbackField[3] = GraphQl.Feedback.e;
    arrayOfFeedbackField[4] = GraphQl.Feedback.g;
    GraphQlQueryCommentsConnection.CommentsConnectionField[] arrayOfCommentsConnectionField = new GraphQlQueryCommentsConnection.CommentsConnectionField[1];
    arrayOfCommentsConnectionField[0] = GraphQl.CommentsConnection.a;
    arrayOfFeedbackField[5] = GraphQl.Feedback.a(GraphQl.CommentsConnection.a(arrayOfCommentsConnectionField));
    GraphQlQueryLikersOfContentConnection.LikersOfContentConnectionField[] arrayOfLikersOfContentConnectionField = new GraphQlQueryLikersOfContentConnection.LikersOfContentConnectionField[1];
    arrayOfLikersOfContentConnectionField[0] = GraphQl.LikersOfContentConnection.a;
    arrayOfFeedbackField[6] = GraphQl.Feedback.a(GraphQl.LikersOfContentConnection.a(arrayOfLikersOfContentConnectionField));
    o = GraphQl.Feedback.a(arrayOfFeedbackField);
    GraphQlQueryPhoto.PhotoField[] arrayOfPhotoField = new GraphQlQueryPhoto.PhotoField[4];
    arrayOfPhotoField[0] = GraphQl.Photo.a;
    arrayOfPhotoField[1] = GraphQl.Photo.b;
    arrayOfPhotoField[2] = GraphQl.Photo.a(d);
    arrayOfPhotoField[3] = GraphQl.Photo.a(o);
  }

  private static GraphQlQueryIcon a()
  {
    GraphQlQueryIcon localGraphQlQueryIcon1;
    if ((Resources.getSystem() == null) || (Resources.getSystem().getDisplayMetrics() == null))
    {
      localGraphQlQueryIcon1 = g;
      return localGraphQlQueryIcon1;
    }
    String str;
    switch (Resources.getSystem().getDisplayMetrics().densityDpi)
    {
    default:
      str = "1";
    case 320:
    case 480:
    case 240:
    }
    while (true)
    {
      GraphQlQueryIcon.CallOnIcon[] arrayOfCallOnIcon = new GraphQlQueryIcon.CallOnIcon[1];
      arrayOfCallOnIcon[0] = GraphQl.Icon.a(str);
      GraphQlQueryIcon localGraphQlQueryIcon2 = GraphQl.Icon.a(arrayOfCallOnIcon);
      GraphQlQueryIcon.IconField[] arrayOfIconField = new GraphQlQueryIcon.IconField[3];
      arrayOfIconField[0] = GraphQl.Icon.b;
      arrayOfIconField[1] = GraphQl.Icon.c;
      arrayOfIconField[2] = GraphQl.Icon.d;
      localGraphQlQueryIcon1 = localGraphQlQueryIcon2.a(arrayOfIconField);
      break;
      str = "2";
      continue;
      str = "1\\.5";
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQlQueryDefaults
 * JD-Core Version:    0.6.2
 */