package com.facebook.widget.animatablelistview;

public enum AnimationType
{
  static
  {
    REVEAL_WITH_ANIMATION_DOWN = new AnimationType("REVEAL_WITH_ANIMATION_DOWN", 1);
    HIDE_WITH_ANIMATION_UP = new AnimationType("HIDE_WITH_ANIMATION_UP", 2);
    HIDE_WITH_ANIMATION_DOWN = new AnimationType("HIDE_WITH_ANIMATION_DOWN", 3);
    AnimationType[] arrayOfAnimationType = new AnimationType[4];
    arrayOfAnimationType[0] = REVEAL_WITH_ANIMATION_UP;
    arrayOfAnimationType[1] = REVEAL_WITH_ANIMATION_DOWN;
    arrayOfAnimationType[2] = HIDE_WITH_ANIMATION_UP;
    arrayOfAnimationType[3] = HIDE_WITH_ANIMATION_DOWN;
  }

  public AnimatingListMutation.MutationType toMutationType()
  {
    AnimatingListMutation.MutationType localMutationType;
    switch (AnimationType.1.a[ordinal()])
    {
    default:
      throw new RuntimeException("Unknown type");
    case 1:
      localMutationType = AnimatingListMutation.MutationType.ADD_WITH_ANIMATION_DOWN;
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      return localMutationType;
      localMutationType = AnimatingListMutation.MutationType.ADD_WITH_ANIMATION_UP;
      continue;
      localMutationType = AnimatingListMutation.MutationType.REMOVE_WITH_ANIMATION_DOWN;
      continue;
      localMutationType = AnimatingListMutation.MutationType.REMOVE_WITH_ANIMATION_UP;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.animatablelistview.AnimationType
 * JD-Core Version:    0.6.2
 */