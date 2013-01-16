package com.facebook.katana.platform;

 enum GDPState
{
  static
  {
    DISPLAYING_PERMISSIONS_LOAD_FAILURE = new GDPState("DISPLAYING_PERMISSIONS_LOAD_FAILURE", 2);
    DISPLAYING_PERMISSIONS = new GDPState("DISPLAYING_PERMISSIONS", 3);
    SENDING_APPROVAL = new GDPState("SENDING_APPROVAL", 4);
    DISPLAYING_SEND_APPROVAL_FAILURE = new GDPState("DISPLAYING_SEND_APPROVAL_FAILURE", 5);
    APPROVED = new GDPState("APPROVED", 6);
    CANCELED = new GDPState("CANCELED", 7);
    GDPState[] arrayOfGDPState = new GDPState[8];
    arrayOfGDPState[0] = CREATED;
    arrayOfGDPState[1] = LOADING_PERMISSIONS;
    arrayOfGDPState[2] = DISPLAYING_PERMISSIONS_LOAD_FAILURE;
    arrayOfGDPState[3] = DISPLAYING_PERMISSIONS;
    arrayOfGDPState[4] = SENDING_APPROVAL;
    arrayOfGDPState[5] = DISPLAYING_SEND_APPROVAL_FAILURE;
    arrayOfGDPState[6] = APPROVED;
    arrayOfGDPState[7] = CANCELED;
    $VALUES = arrayOfGDPState;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.GDPState
 * JD-Core Version:    0.6.0
 */