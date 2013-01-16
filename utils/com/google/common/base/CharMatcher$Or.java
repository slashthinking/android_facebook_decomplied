package com.google.common.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class CharMatcher$Or extends CharMatcher
{
  List<CharMatcher> components;

  CharMatcher$Or(List<CharMatcher> paramList)
  {
    this.components = paramList;
  }

  public boolean matches(char paramChar)
  {
    Iterator localIterator = this.components.iterator();
    do
      if (!localIterator.hasNext())
        break;
    while (!((CharMatcher)localIterator.next()).matches(paramChar));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public CharMatcher or(CharMatcher paramCharMatcher)
  {
    ArrayList localArrayList = new ArrayList(this.components);
    localArrayList.add(Preconditions.checkNotNull(paramCharMatcher));
    return new Or(localArrayList);
  }

  void setBits(CharMatcher.LookupTable paramLookupTable)
  {
    Iterator localIterator = this.components.iterator();
    while (localIterator.hasNext())
      ((CharMatcher)localIterator.next()).setBits(paramLookupTable);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.CharMatcher.Or
 * JD-Core Version:    0.6.2
 */