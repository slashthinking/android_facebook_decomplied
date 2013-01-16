package com.google.common.collect;

public enum SortedLists$KeyAbsentBehavior
{
  static
  {
    NEXT_HIGHER = new SortedLists.KeyAbsentBehavior.2("NEXT_HIGHER", 1);
    INVERTED_INSERTION_INDEX = new SortedLists.KeyAbsentBehavior.3("INVERTED_INSERTION_INDEX", 2);
    KeyAbsentBehavior[] arrayOfKeyAbsentBehavior = new KeyAbsentBehavior[3];
    arrayOfKeyAbsentBehavior[0] = NEXT_LOWER;
    arrayOfKeyAbsentBehavior[1] = NEXT_HIGHER;
    arrayOfKeyAbsentBehavior[2] = INVERTED_INSERTION_INDEX;
  }

  abstract <E> int resultIndex(int paramInt);
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.SortedLists.KeyAbsentBehavior
 * JD-Core Version:    0.6.2
 */