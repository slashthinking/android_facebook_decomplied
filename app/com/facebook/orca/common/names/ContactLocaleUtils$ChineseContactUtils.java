package com.facebook.orca.common.names;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

class ContactLocaleUtils$ChineseContactUtils extends ContactLocaleUtils.ContactLocaleUtilsBase
{
  private ContactLocaleUtils$ChineseContactUtils(ContactLocaleUtils paramContactLocaleUtils)
  {
    super(paramContactLocaleUtils);
  }

  public Iterator<String> a(String paramString)
  {
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList = HanziToPinyin.a().a(paramString);
    int i = localArrayList.size();
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    StringBuilder localStringBuilder3 = new StringBuilder();
    int j = i - 1;
    if (j >= 0)
    {
      HanziToPinyin.Token localToken = (HanziToPinyin.Token)localArrayList.get(j);
      if (2 == localToken.a)
      {
        localStringBuilder1.insert(0, localToken.c);
        localStringBuilder2.insert(0, localToken.c.charAt(0));
      }
      while (true)
      {
        localStringBuilder3.insert(0, localToken.b);
        localHashSet.add(localStringBuilder3.toString());
        localHashSet.add(localStringBuilder1.toString());
        localHashSet.add(localStringBuilder2.toString());
        j--;
        break;
        if (1 != localToken.a)
          continue;
        if (localStringBuilder1.length() > 0)
          localStringBuilder1.insert(0, ' ');
        if (localStringBuilder3.length() > 0)
          localStringBuilder3.insert(0, ' ');
        localStringBuilder1.insert(0, localToken.b);
        localStringBuilder2.insert(0, localToken.b.charAt(0));
      }
    }
    return localHashSet.iterator();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.names.ContactLocaleUtils.ChineseContactUtils
 * JD-Core Version:    0.6.0
 */