package com.facebook.katana.activity.places;

import com.facebook.katana.model.PageTopic;
import java.util.Comparator;

class SelectPageTopicAdapter$2
  implements Comparator<PageTopic>
{
  public int a(PageTopic paramPageTopic1, PageTopic paramPageTopic2)
  {
    return paramPageTopic1.displayName.compareTo(paramPageTopic2.displayName);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.places.SelectPageTopicAdapter.2
 * JD-Core Version:    0.6.0
 */