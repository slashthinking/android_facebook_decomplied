package com.facebook.webrtc;

public enum IWebrtcUiInterface$EndCallReason
{
  static
  {
    CallEndHangupCall = new EndCallReason("CallEndHangupCall", 1);
    CallEndNoAnswerTimeout = new EndCallReason("CallEndNoAnswerTimeout", 2);
    CallEndIncomingTimeout = new EndCallReason("CallEndIncomingTimeout", 3);
    CallEndOtherPersonHungUp = new EndCallReason("CallEndOtherPersonHungUp", 4);
    CallEndOtherPersonIgnored = new EndCallReason("CallEndOtherPersonIgnored", 5);
    CallEndOtherPersonInAnotherCall = new EndCallReason("CallEndOtherPersonInAnotherCall", 6);
    CallEndOtherInstanceHandled = new EndCallReason("CallEndOtherInstanceHandled", 7);
    CallEndSignalingMessageFailed = new EndCallReason("CallEndSignalingMessageFailed", 8);
    CallEndConnectionDropped = new EndCallReason("CallEndConnectionDropped", 9);
    CallEndWebRTCError = new EndCallReason("CallEndWebRTCError", 10);
    CallEndClientError = new EndCallReason("CallEndClientError", 11);
    CallEndNoPermission = new EndCallReason("CallEndNoPermission", 12);
    EndCallReason[] arrayOfEndCallReason = new EndCallReason[13];
    arrayOfEndCallReason[0] = CallEndIgnoreCall;
    arrayOfEndCallReason[1] = CallEndHangupCall;
    arrayOfEndCallReason[2] = CallEndNoAnswerTimeout;
    arrayOfEndCallReason[3] = CallEndIncomingTimeout;
    arrayOfEndCallReason[4] = CallEndOtherPersonHungUp;
    arrayOfEndCallReason[5] = CallEndOtherPersonIgnored;
    arrayOfEndCallReason[6] = CallEndOtherPersonInAnotherCall;
    arrayOfEndCallReason[7] = CallEndOtherInstanceHandled;
    arrayOfEndCallReason[8] = CallEndSignalingMessageFailed;
    arrayOfEndCallReason[9] = CallEndConnectionDropped;
    arrayOfEndCallReason[10] = CallEndWebRTCError;
    arrayOfEndCallReason[11] = CallEndClientError;
    arrayOfEndCallReason[12] = CallEndNoPermission;
    $VALUES = arrayOfEndCallReason;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.webrtc.IWebrtcUiInterface.EndCallReason
 * JD-Core Version:    0.6.0
 */