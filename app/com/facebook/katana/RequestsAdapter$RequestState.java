package com.facebook.katana;

 enum RequestsAdapter$RequestState
{
  static
  {
    RESPONSE_CONFIRMED = new RequestState("RESPONSE_CONFIRMED", 3);
    RESPONSE_IGNORED = new RequestState("RESPONSE_IGNORED", 4);
    RequestState[] arrayOfRequestState = new RequestState[5];
    arrayOfRequestState[0] = NOT_RESPONDED;
    arrayOfRequestState[1] = RESPONSE_CONFIRMING;
    arrayOfRequestState[2] = RESPONSE_IGNORING;
    arrayOfRequestState[3] = RESPONSE_CONFIRMED;
    arrayOfRequestState[4] = RESPONSE_IGNORED;
    $VALUES = arrayOfRequestState;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.RequestsAdapter.RequestState
 * JD-Core Version:    0.6.0
 */