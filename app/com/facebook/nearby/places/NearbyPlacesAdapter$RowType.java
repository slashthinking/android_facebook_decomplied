package com.facebook.nearby.places;

 enum NearbyPlacesAdapter$RowType
{
  static
  {
    NO_RESULTS = new RowType("NO_RESULTS", 1);
    PLACES_LOADING = new RowType("PLACES_LOADING", 2);
    DETECT_LOCATION = new RowType("DETECT_LOCATION", 3);
    RowType[] arrayOfRowType = new RowType[4];
    arrayOfRowType[0] = PLACE_INFO;
    arrayOfRowType[1] = NO_RESULTS;
    arrayOfRowType[2] = PLACES_LOADING;
    arrayOfRowType[3] = DETECT_LOCATION;
    $VALUES = arrayOfRowType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.places.NearbyPlacesAdapter.RowType
 * JD-Core Version:    0.6.0
 */