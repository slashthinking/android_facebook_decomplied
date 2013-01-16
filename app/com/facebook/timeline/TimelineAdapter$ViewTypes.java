package com.facebook.timeline;

public enum TimelineAdapter$ViewTypes
{
  static
  {
    STORY_EDGE_NARROW_OR_AGG = new ViewTypes("STORY_EDGE_NARROW_OR_AGG", 3);
    SCRUBBER = new ViewTypes("SCRUBBER", 4);
    LOADING = new ViewTypes("LOADING", 5);
    NO_STORIES = new ViewTypes("NO_STORIES", 6);
    LIFE_EVENT = new ViewTypes("LIFE_EVENT", 7);
    ViewTypes[] arrayOfViewTypes = new ViewTypes[8];
    arrayOfViewTypes[0] = HEADER;
    arrayOfViewTypes[1] = STORY_BASE;
    arrayOfViewTypes[2] = STORY_EDGE_WIDE;
    arrayOfViewTypes[3] = STORY_EDGE_NARROW_OR_AGG;
    arrayOfViewTypes[4] = SCRUBBER;
    arrayOfViewTypes[5] = LOADING;
    arrayOfViewTypes[6] = NO_STORIES;
    arrayOfViewTypes[7] = LIFE_EVENT;
    $VALUES = arrayOfViewTypes;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineAdapter.ViewTypes
 * JD-Core Version:    0.6.0
 */