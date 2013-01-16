package com.facebook.ipc.connections;

public enum ConnectionsContract$Selectors
{
  public final String category;
  public final String uriMatcherSuffix;
  public final String uriSuffix;

  static
  {
    FRIENDS_SEARCH = new Selectors("FRIENDS_SEARCH", 4, "friends", "/search", "/*");
    FRIENDS_PREFIX_SEARCH = new Selectors("FRIENDS_PREFIX_SEARCH", 5, "friends", "/search", "/*");
    FRIENDS_BIRTHDAYS = new Selectors("FRIENDS_BIRTHDAYS", 6, "friends", "/birthdays", "");
    SEARCH_SUGGESTIONS = new Selectors("SEARCH_SUGGESTIONS", 7, "search_suggest_query", "", "");
    PAGES_CONTENT = new Selectors("PAGES_CONTENT", 8, "pages", "", "");
    PAGE_ID = new Selectors("PAGE_ID", 9, "pages", "/id", "/#");
    PAGES_SEARCH = new Selectors("PAGES_SEARCH", 10, "pages", "/search", "/*");
    SEARCH_CONTENT = new Selectors("SEARCH_CONTENT", 11, "search_results", "", "");
    Selectors[] arrayOfSelectors = new Selectors[12];
    arrayOfSelectors[0] = CONNECTIONS_CONTENT;
    arrayOfSelectors[1] = CONNECTION_ID;
    arrayOfSelectors[2] = FRIENDS_CONTENT;
    arrayOfSelectors[3] = FRIEND_UID;
    arrayOfSelectors[4] = FRIENDS_SEARCH;
    arrayOfSelectors[5] = FRIENDS_PREFIX_SEARCH;
    arrayOfSelectors[6] = FRIENDS_BIRTHDAYS;
    arrayOfSelectors[7] = SEARCH_SUGGESTIONS;
    arrayOfSelectors[8] = PAGES_CONTENT;
    arrayOfSelectors[9] = PAGE_ID;
    arrayOfSelectors[10] = PAGES_SEARCH;
    arrayOfSelectors[11] = SEARCH_CONTENT;
    $VALUES = arrayOfSelectors;
  }

  private ConnectionsContract$Selectors(String paramString1, String paramString2, String paramString3)
  {
    this.category = paramString1;
    this.uriSuffix = paramString2;
    this.uriMatcherSuffix = paramString3;
  }

  public int uriMatcherIndex()
  {
    return 1 + ordinal();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.ipc.connections.ConnectionsContract.Selectors
 * JD-Core Version:    0.6.0
 */