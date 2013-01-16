package com.facebook.katana.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMAutogen.ListType;
import com.facebook.ipc.katana.model.FacebookPage;
import java.util.ArrayList;
import java.util.List;

public class FacebookPageFull extends FacebookPage
  implements Parcelable
{
  public static final Parcelable.Creator<FacebookPage> CREATOR = new FacebookPageFull.1();

  @JMAutogen.InferredType(jsonFieldName="artists_we_like")
  public final String mArtistWeLike = null;

  @JMAutogen.InferredType(jsonFieldName="attire")
  public final String mAttire = null;

  @JMAutogen.InferredType(jsonFieldName="awards")
  public final String mAwards = null;

  @JMAutogen.InferredType(jsonFieldName="band_interests")
  public final String mBandInterests = null;

  @JMAutogen.InferredType(jsonFieldName="band_members")
  public final String mBandMembers = null;

  @JMAutogen.InferredType(jsonFieldName="bio")
  public final String mBio = null;

  @JMAutogen.InferredType(jsonFieldName="birthday")
  public final String mBirthday = null;

  @JMAutogen.InferredType(jsonFieldName="booking_agent")
  public final String mBookingAgent = null;

  @JMAutogen.InferredType(jsonFieldName="built")
  public final String mBuilt = null;

  @JMAutogen.InferredType(jsonFieldName="company_overview")
  public final String mCompanyOverview = null;

  @JMAutogen.InferredType(jsonFieldName="culinary_team")
  public final String mCulinaryTeam = null;

  @JMAutogen.InferredType(jsonFieldName="current_location")
  public final String mCurrentLocation = null;

  @JMAutogen.InferredType(jsonFieldName="directed_by")
  public final String mDirectedBy = null;

  @JMAutogen.InferredType(jsonFieldName="features")
  public final String mFeatures = null;

  @JMAutogen.InferredType(jsonFieldName="founded")
  public final String mFounded = null;

  @JMAutogen.InferredType(jsonFieldName="general_info")
  public final String mGeneralInfo = null;

  @JMAutogen.InferredType(jsonFieldName="genre")
  public final String mGenre = null;

  @JMAutogen.InferredType(jsonFieldName="hometown")
  public final String mHomeTown = null;

  @JMAutogen.InferredType(jsonFieldName="influences")
  public final String mInfluences = null;

  @JMAutogen.InferredType(jsonFieldName="members")
  public final String mMembers = null;

  @JMAutogen.InferredType(jsonFieldName="mission")
  public final String mMission = null;

  @JMAutogen.InferredType(jsonFieldName="mpg")
  public final String mMpg = null;

  @JMAutogen.InferredType(jsonFieldName="network")
  public final String mNetwork = null;

  @JMAutogen.InferredType(jsonFieldName="personal_info")
  public final String mPersonalInfo = null;

  @JMAutogen.InferredType(jsonFieldName="personal_interests")
  public final String mPersonalInterests = null;

  @JMAutogen.InferredType(jsonFieldName="phone")
  public final String mPhone = null;

  @JMAutogen.InferredType(jsonFieldName="plot_outline")
  public final String mPlotOutline = null;

  @JMAutogen.InferredType(jsonFieldName="press_contact")
  public final String mPressContact = null;

  @JMAutogen.InferredType(jsonFieldName="price_range")
  public final String mPriceRange = null;

  @JMAutogen.InferredType(jsonFieldName="produced_by")
  public final String mProducedBy = null;

  @JMAutogen.InferredType(jsonFieldName="products")
  public final String mProducts = null;

  @JMAutogen.InferredType(jsonFieldName="record_label")
  public final String mRecordLabel = null;

  @JMAutogen.InferredType(jsonFieldName="release_date")
  public final String mReleaseDate = null;

  @JMAutogen.InferredType(jsonFieldName="schedule")
  public final String mSchedule = null;

  @JMAutogen.InferredType(jsonFieldName="screenplay_by")
  public final String mScreenplayBy = null;

  @JMAutogen.InferredType(jsonFieldName="season")
  public final String mSeason = null;

  @JMAutogen.InferredType(jsonFieldName="starring")
  public final String mStarring = null;

  @JMAutogen.InferredType(jsonFieldName="studio")
  public final String mStudio = null;

  @JMAutogen.ListType(b={PageTopic.class}, jsonFieldName="categories")
  public final List<PageTopic> mTopicList = new ArrayList();

  @JMAutogen.InferredType(jsonFieldName="website")
  public final String mWebsite = null;

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mWebsite);
    paramParcel.writeString(this.mFounded);
    paramParcel.writeString(this.mCompanyOverview);
    paramParcel.writeString(this.mMission);
    paramParcel.writeString(this.mProducts);
    paramParcel.writeString(this.mAttire);
    paramParcel.writeString(this.mCulinaryTeam);
    paramParcel.writeString(this.mPriceRange);
    paramParcel.writeString(this.mReleaseDate);
    paramParcel.writeString(this.mGenre);
    paramParcel.writeString(this.mStarring);
    paramParcel.writeString(this.mScreenplayBy);
    paramParcel.writeString(this.mDirectedBy);
    paramParcel.writeString(this.mProducedBy);
    paramParcel.writeString(this.mStudio);
    paramParcel.writeString(this.mAwards);
    paramParcel.writeString(this.mPlotOutline);
    paramParcel.writeString(this.mNetwork);
    paramParcel.writeString(this.mSeason);
    paramParcel.writeString(this.mSchedule);
    paramParcel.writeString(this.mBandMembers);
    paramParcel.writeString(this.mHomeTown);
    paramParcel.writeString(this.mCurrentLocation);
    paramParcel.writeString(this.mRecordLabel);
    paramParcel.writeString(this.mBookingAgent);
    paramParcel.writeString(this.mPressContact);
    paramParcel.writeString(this.mArtistWeLike);
    paramParcel.writeString(this.mInfluences);
    paramParcel.writeString(this.mBandInterests);
    paramParcel.writeString(this.mBio);
    paramParcel.writeString(this.mBirthday);
    paramParcel.writeString(this.mPersonalInfo);
    paramParcel.writeString(this.mPersonalInterests);
    paramParcel.writeString(this.mMembers);
    paramParcel.writeString(this.mBuilt);
    paramParcel.writeString(this.mFeatures);
    paramParcel.writeString(this.mMpg);
    paramParcel.writeString(this.mGeneralInfo);
    paramParcel.writeString(this.mPhone);
    paramParcel.writeList(this.mTopicList);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.FacebookPageFull
 * JD-Core Version:    0.6.0
 */