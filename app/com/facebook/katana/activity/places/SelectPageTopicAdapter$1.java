package com.facebook.katana.activity.places;

import com.facebook.katana.model.PageTopic;
import java.util.Comparator;

class SelectPageTopicAdapter$1
  implements Comparator<PageTopic>
{
  public int a(PageTopic paramPageTopic1, PageTopic paramPageTopic2)
  {
    return Integer.valueOf(paramPageTopic2.pageCount).compareTo(Integer.valueOf(paramPageTopic1.pageCount));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.places.SelectPageTopicAdapter.1
 * JD-Core Version:    0.6.0
 */