package com.facebook.katana.activity.places;

 enum SuggestPlaceInfoActivity$State
{
  static
  {
    FETCHING = new State("FETCHING", 1);
    SAVING = new State("SAVING", 2);
    State[] arrayOfState = new State[3];
    arrayOfState[0] = NONE;
    arrayOfState[1] = FETCHING;
    arrayOfState[2] = SAVING;
    $VALUES = arrayOfState;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.places.SuggestPlaceInfoActivity.State
 * JD-Core Version:    0.6.0
 */