package com.facebook.friends.model;

import com.fasterxml.jackson.annotation.JsonProperty;

class PersonYouMayKnow$ProfilePicture
{

  @JsonProperty("uri")
  private final String uri;

  private PersonYouMayKnow$ProfilePicture()
  {
    this.uri = "";
  }

  private PersonYouMayKnow$ProfilePicture(String paramString)
  {
    this.uri = paramString;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.model.PersonYouMayKnow.ProfilePicture
 * JD-Core Version:    0.6.0
 */