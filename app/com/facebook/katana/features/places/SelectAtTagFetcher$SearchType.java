package com.facebook.katana.features.places;

public enum SelectAtTagFetcher$SearchType
{
  private final String name;

  static
  {
    PHOTO = new SearchType("PHOTO", 2, "mobile_photo");
    VIDEO = new SearchType("VIDEO", 3, "mobile_video");
    EVENT = new SearchType("EVENT", 4, "mobile_event");
    SearchType[] arrayOfSearchType = new SearchType[5];
    arrayOfSearchType[0] = CHECKIN;
    arrayOfSearchType[1] = STATUS;
    arrayOfSearchType[2] = PHOTO;
    arrayOfSearchType[3] = VIDEO;
    arrayOfSearchType[4] = EVENT;
    $VALUES = arrayOfSearchType;
  }

  private SelectAtTagFetcher$SearchType(String paramString)
  {
    this.name = paramString;
  }

  public String toString()
  {
    return this.name;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.places.SelectAtTagFetcher.SearchType
 * JD-Core Version:    0.6.0
 */