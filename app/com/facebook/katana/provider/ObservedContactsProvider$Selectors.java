package com.facebook.katana.provider;

 enum ObservedContactsProvider$Selectors
{
  final String category;
  final String uriMatcherSuffix;
  final String uriSuffix;

  static
  {
    OBSERVED_CONTACTS_CONTACT_ID = new Selectors("OBSERVED_CONTACTS_CONTACT_ID", 1, "observed_contacts", "/cid", "/#");
    Selectors[] arrayOfSelectors = new Selectors[2];
    arrayOfSelectors[0] = OBSERVED_CONTACTS_CONTENT;
    arrayOfSelectors[1] = OBSERVED_CONTACTS_CONTACT_ID;
    $VALUES = arrayOfSelectors;
  }

  private ObservedContactsProvider$Selectors(String paramString1, String paramString2, String paramString3)
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
 * Qualified Name:     com.facebook.katana.provider.ObservedContactsProvider.Selectors
 * JD-Core Version:    0.6.0
 */