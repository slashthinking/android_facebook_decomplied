package com.facebook.katana.model;

import com.facebook.common.json.jsonmirror.JMAutogen.ExplicitType;
import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMAutogen.ListType;
import com.facebook.common.json.jsonmirror.JMDictDestination.PostProcessable;
import com.facebook.common.json.jsonmirror.types.JMDict;
import com.facebook.ipc.katana.model.FacebookUser;
import com.facebook.katana.util.StringUtils.JMNulledString;
import java.util.List;
import java.util.Map;

public class FacebookUserFull extends FacebookUser
  implements JMDictDestination.PostProcessable
{

  @JMAutogen.ExplicitType(jsonFieldName="about_me", type=StringUtils.JMNulledString.class)
  public final String mAboutMe = null;

  @JMAutogen.ExplicitType(jsonFieldName="activities", type=FacebookUserFull.JMTrimWhiteString.class)
  public final String mActivities = null;

  @JMAutogen.ListType(b={FacebookUserFull.Affiliation.class}, jsonFieldName="affiliations")
  public final List<FacebookUserFull.Affiliation> mAffiliations = null;

  @JMAutogen.ExplicitType(jsonFieldName="birthday", type=StringUtils.JMNulledString.class)
  public final String mBirthday = null;

  @JMAutogen.ExplicitType(jsonFieldName="profile_blurb", type=StringUtils.JMNulledString.class)
  public final String mBlurb = null;

  @JMAutogen.ExplicitType(jsonFieldName="books", type=StringUtils.JMNulledString.class)
  public final String mBooks = null;

  @JMAutogen.ExplicitType(jsonFieldName="cell", type=StringUtils.JMNulledString.class)
  public final String mCellPhone = null;

  @JMAutogen.ExplicitType(jsonFieldName="contact_email", type=StringUtils.JMNulledString.class)
  public final String mContactEmail = null;
  public final String mCurrentLocation = null;

  @JMAutogen.InferredType(jsonFieldName="current_location")
  private final Map<String, Object> mCurrentLocation_internal = null;
  public final String mHometownLocation = null;

  @JMAutogen.InferredType(jsonFieldName="hometown_location")
  private final Map<String, Object> mHometownLocation_internal = null;

  @JMAutogen.ExplicitType(jsonFieldName="interests", type=StringUtils.JMNulledString.class)
  public final String mInterests = null;

  @JMAutogen.ExplicitType(jsonFieldName="pic", type=StringUtils.JMNulledString.class)
  public final String mLargePic = null;

  @JMAutogen.ExplicitType(jsonFieldName="movies", type=StringUtils.JMNulledString.class)
  public final String mMovies = null;

  @JMAutogen.ExplicitType(jsonFieldName="music", type=StringUtils.JMNulledString.class)
  public final String mMusic = null;

  @JMAutogen.ExplicitType(jsonFieldName="other_phone", type=StringUtils.JMNulledString.class)
  public final String mOtherPhone = null;

  @JMAutogen.ExplicitType(jsonFieldName="political", type=StringUtils.JMNulledString.class)
  public final String mPoliticalViews = null;

  @JMAutogen.ExplicitType(jsonFieldName="quotes", type=FacebookUserFull.JMTrimWhiteAndNLString.class)
  public final String mQuotes = null;

  @JMAutogen.ExplicitType(jsonFieldName="relationship_status", type=StringUtils.JMNulledString.class)
  public final String mRelationshipStatus = null;

  @JMAutogen.ExplicitType(jsonFieldName="religion", type=StringUtils.JMNulledString.class)
  public final String mReligion = null;
  protected FacebookUser mSignificantOther;

  @JMAutogen.InferredType(jsonFieldName="significant_other_id")
  public final long mSignificantOtherId = -1L;

  @JMAutogen.ExplicitType(jsonFieldName="tv", type=StringUtils.JMNulledString.class)
  public final String mTv = null;

  @JMAutogen.ExplicitType(jsonFieldName="profile_url", type=StringUtils.JMNulledString.class)
  public final String mUrl = null;

  protected static String a(String paramString, boolean paramBoolean)
  {
    String str;
    StringBuffer localStringBuffer;
    if (paramBoolean)
    {
      str = paramString.replaceAll("\n", ", ");
      localStringBuffer = new StringBuffer(128);
    }
    for (int i = 0; ; i++)
    {
      if (i < str.length())
      {
        int m = str.charAt(i);
        if ((m == 32) || (m == 44) || (m == 10))
          continue;
        localStringBuffer.append(str.subSequence(i, str.length()));
      }
      for (int j = -1 + localStringBuffer.length(); j >= 0; j--)
      {
        int k = localStringBuffer.charAt(j);
        if ((k != 32) && (k != 44) && (k != 10))
          break;
        localStringBuffer.deleteCharAt(j);
      }
      str = paramString.replaceAll("[\r|\013|\f]", "");
      break;
    }
    return localStringBuffer.toString();
  }

  protected static String a(Map<String, Object> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = paramMap.get("city");
    Object localObject2 = paramMap.get("state");
    String str;
    if ((localObject1 != null) && (localObject2 != null))
    {
      localStringBuilder.append(localObject1).append(", ").append(localObject2);
      str = localStringBuilder.toString();
    }
    while (true)
    {
      return str;
      if (localObject1 != null)
      {
        str = localObject1.toString();
        continue;
      }
      if (localObject2 != null)
      {
        str = localObject2.toString();
        continue;
      }
      str = null;
    }
  }

  public void a(JMDict paramJMDict)
  {
    if (this.mCurrentLocation_internal != null)
      paramJMDict.a(this, "mCurrentLocation", a(this.mCurrentLocation_internal));
    if (this.mHometownLocation_internal != null)
      paramJMDict.a(this, "mHometownLocation", a(this.mHometownLocation_internal));
  }

  public void a(FacebookUser paramFacebookUser)
  {
    this.mSignificantOther = paramFacebookUser;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.FacebookUserFull
 * JD-Core Version:    0.6.0
 */