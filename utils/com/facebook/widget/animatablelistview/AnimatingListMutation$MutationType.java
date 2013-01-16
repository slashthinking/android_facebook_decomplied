package com.facebook.widget.animatablelistview;

public enum AnimatingListMutation$MutationType
{
  static
  {
    ADD_WITH_ANIMATION_DOWN = new MutationType("ADD_WITH_ANIMATION_DOWN", 2);
    REMOVE = new MutationType("REMOVE", 3);
    REMOVE_WITH_ANIMATION_UP = new MutationType("REMOVE_WITH_ANIMATION_UP", 4);
    REMOVE_WITH_ANIMATION_DOWN = new MutationType("REMOVE_WITH_ANIMATION_DOWN", 5);
    REPLACE = new MutationType("REPLACE", 6);
    MARKED_FOR_REPLACE = new MutationType("MARKED_FOR_REPLACE", 7);
    CUSTOM = new MutationType("CUSTOM", 8);
    MutationType[] arrayOfMutationType = new MutationType[9];
    arrayOfMutationType[0] = ADD;
    arrayOfMutationType[1] = ADD_WITH_ANIMATION_UP;
    arrayOfMutationType[2] = ADD_WITH_ANIMATION_DOWN;
    arrayOfMutationType[3] = REMOVE;
    arrayOfMutationType[4] = REMOVE_WITH_ANIMATION_UP;
    arrayOfMutationType[5] = REMOVE_WITH_ANIMATION_DOWN;
    arrayOfMutationType[6] = REPLACE;
    arrayOfMutationType[7] = MARKED_FOR_REPLACE;
    arrayOfMutationType[8] = CUSTOM;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.animatablelistview.AnimatingListMutation.MutationType
 * JD-Core Version:    0.6.2
 */