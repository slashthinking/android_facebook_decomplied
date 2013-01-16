package com.facebook.katana.model;

public class FacebookPhonebookContactUser extends FacebookPhonebookContact
{
  public final String imageUrl;
  public final String mLargeImageUrl;

  public FacebookPhonebookContactUser(FacebookPhonebookContact paramFacebookPhonebookContact, FacebookUserWithLargeProfilePic paramFacebookUserWithLargeProfilePic)
  {
    super(paramFacebookUserWithLargeProfilePic.mDisplayName, paramFacebookPhonebookContact.recordId, false, paramFacebookPhonebookContact.userId, paramFacebookPhonebookContact.phone, paramFacebookPhonebookContact.email, paramFacebookPhonebookContact.ordinal);
    this.imageUrl = paramFacebookUserWithLargeProfilePic.mImageUrl;
    this.mLargeImageUrl = paramFacebookUserWithLargeProfilePic.mBigImageURL;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.FacebookPhonebookContactUser
 * JD-Core Version:    0.6.0
 */