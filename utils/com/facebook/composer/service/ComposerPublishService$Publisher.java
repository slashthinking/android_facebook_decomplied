package com.facebook.composer.service;

public enum ComposerPublishService$Publisher
{
  static
  {
    PERMALINK = new Publisher("PERMALINK", 2);
    IMPLICIT_INTENT = new Publisher("IMPLICIT_INTENT", 3);
    Publisher[] arrayOfPublisher = new Publisher[4];
    arrayOfPublisher[0] = NEWSFEED;
    arrayOfPublisher[1] = TIMELINE;
    arrayOfPublisher[2] = PERMALINK;
    arrayOfPublisher[3] = IMPLICIT_INTENT;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.composer.service.ComposerPublishService.Publisher
 * JD-Core Version:    0.6.2
 */