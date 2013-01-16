package com.facebook.timeline;

public enum TimelineAnalyticsLogger$RelationshipType
{
  private int mType;

  static
  {
    SELF = new RelationshipType("SELF", 1, 1);
    FRIEND = new RelationshipType("FRIEND", 2, 2);
    SUBSCRIBED_TO = new RelationshipType("SUBSCRIBED_TO", 3, 3);
    UNKNOWN_RELATIONSHIP = new RelationshipType("UNKNOWN_RELATIONSHIP", 4, 4);
    RelationshipType[] arrayOfRelationshipType = new RelationshipType[5];
    arrayOfRelationshipType[0] = UNDEFINED;
    arrayOfRelationshipType[1] = SELF;
    arrayOfRelationshipType[2] = FRIEND;
    arrayOfRelationshipType[3] = SUBSCRIBED_TO;
    arrayOfRelationshipType[4] = UNKNOWN_RELATIONSHIP;
    $VALUES = arrayOfRelationshipType;
  }

  private TimelineAnalyticsLogger$RelationshipType(int paramInt)
  {
    this.mType = paramInt;
  }

  public int getValue()
  {
    return this.mType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineAnalyticsLogger.RelationshipType
 * JD-Core Version:    0.6.0
 */