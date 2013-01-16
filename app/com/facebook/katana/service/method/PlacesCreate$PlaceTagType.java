package com.facebook.katana.service.method;

public enum PlacesCreate$PlaceTagType
{
  public final String apiValue;

  static
  {
    COUNTRY = new PlaceTagType("COUNTRY", 2, "COUNTRY");
    PLACE = new PlaceTagType("PLACE", 3, "PLACE");
    EVENT = new PlaceTagType("EVENT", 4, "EVENT");
    UNCONFIRMED_RESIDENCE = new PlaceTagType("UNCONFIRMED_RESIDENCE", 5, "UNCONFIRMED_RESIDENCE");
    RESIDENCE = new PlaceTagType("RESIDENCE", 6, "RESIDENCE");
    TEXT = new PlaceTagType("TEXT", 7, "TEXT");
    PlaceTagType[] arrayOfPlaceTagType = new PlaceTagType[8];
    arrayOfPlaceTagType[0] = CITY;
    arrayOfPlaceTagType[1] = STATE_PROVINCE;
    arrayOfPlaceTagType[2] = COUNTRY;
    arrayOfPlaceTagType[3] = PLACE;
    arrayOfPlaceTagType[4] = EVENT;
    arrayOfPlaceTagType[5] = UNCONFIRMED_RESIDENCE;
    arrayOfPlaceTagType[6] = RESIDENCE;
    arrayOfPlaceTagType[7] = TEXT;
    $VALUES = arrayOfPlaceTagType;
  }

  private PlacesCreate$PlaceTagType(String paramString)
  {
    this.apiValue = paramString;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.PlacesCreate.PlaceTagType
 * JD-Core Version:    0.6.0
 */