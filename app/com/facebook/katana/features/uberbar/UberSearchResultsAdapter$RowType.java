package com.facebook.katana.features.uberbar;

 enum UberSearchResultsAdapter$RowType
{
  static
  {
    LOADING_MORE = new RowType("LOADING_MORE", 2);
    RowType[] arrayOfRowType = new RowType[3];
    arrayOfRowType[0] = NO_RESULTS;
    arrayOfRowType[1] = RESULT;
    arrayOfRowType[2] = LOADING_MORE;
    $VALUES = arrayOfRowType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.uberbar.UberSearchResultsAdapter.RowType
 * JD-Core Version:    0.6.0
 */