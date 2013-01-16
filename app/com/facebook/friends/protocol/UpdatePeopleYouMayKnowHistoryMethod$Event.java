package com.facebook.friends.protocol;

public enum UpdatePeopleYouMayKnowHistoryMethod$Event
{
  public final String value;

  static
  {
    Event[] arrayOfEvent = new Event[2];
    arrayOfEvent[0] = CLICK;
    arrayOfEvent[1] = IMPRESSION;
    $VALUES = arrayOfEvent;
  }

  private UpdatePeopleYouMayKnowHistoryMethod$Event(String paramString)
  {
    this.value = paramString;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.protocol.UpdatePeopleYouMayKnowHistoryMethod.Event
 * JD-Core Version:    0.6.0
 */