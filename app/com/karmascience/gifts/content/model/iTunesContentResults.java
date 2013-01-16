package com.karmascience.gifts.content.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

public class iTunesContentResults
{

  @JsonProperty("data")
  private final Map<String, List<iTunesContent>> mContentMap = null;

  public List<iTunesContent> a()
  {
    return a("album");
  }

  public List<iTunesContent> a(String paramString)
  {
    if (this.mContentMap != null);
    for (List localList = (List)this.mContentMap.get(paramString); ; localList = null)
      return localList;
  }

  public List<iTunesContent> b()
  {
    return a("movie");
  }

  public List<iTunesContent> c()
  {
    return a("tv_season");
  }

  public List<iTunesContent> d()
  {
    return a("ios_app");
  }

  public List<iTunesContent> e()
  {
    return a("mac_app");
  }

  public List<iTunesContent> f()
  {
    return a("song");
  }

  public List<iTunesContent> g()
  {
    return a("ebook");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.content.model.iTunesContentResults
 * JD-Core Version:    0.6.0
 */