package com.google.i18n.phonenumbers;

import java.util.regex.Pattern;

public class RegexCache
{
  private RegexCache.LRUCache<String, Pattern> cache;

  public RegexCache(int paramInt)
  {
    this.cache = new RegexCache.LRUCache(paramInt);
  }

  public Pattern getPatternForRegex(String paramString)
  {
    Pattern localPattern = (Pattern)this.cache.get(paramString);
    if (localPattern == null)
    {
      localPattern = Pattern.compile(paramString);
      this.cache.put(paramString, localPattern);
    }
    return localPattern;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.i18n.phonenumbers.RegexCache
 * JD-Core Version:    0.6.2
 */