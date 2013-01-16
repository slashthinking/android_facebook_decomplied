package com.google.common.collect;

import java.util.Comparator;
import java.util.List;

public enum SortedLists$KeyPresentBehavior
{
  static
  {
    FIRST_PRESENT = new SortedLists.KeyPresentBehavior.3("FIRST_PRESENT", 2);
    FIRST_AFTER = new SortedLists.KeyPresentBehavior.4("FIRST_AFTER", 3);
    LAST_BEFORE = new SortedLists.KeyPresentBehavior.5("LAST_BEFORE", 4);
    KeyPresentBehavior[] arrayOfKeyPresentBehavior = new KeyPresentBehavior[5];
    arrayOfKeyPresentBehavior[0] = ANY_PRESENT;
    arrayOfKeyPresentBehavior[1] = LAST_PRESENT;
    arrayOfKeyPresentBehavior[2] = FIRST_PRESENT;
    arrayOfKeyPresentBehavior[3] = FIRST_AFTER;
    arrayOfKeyPresentBehavior[4] = LAST_BEFORE;
  }

  abstract <E> int resultIndex(Comparator<? super E> paramComparator, E paramE, List<? extends E> paramList, int paramInt);
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.SortedLists.KeyPresentBehavior
 * JD-Core Version:    0.6.2
 */