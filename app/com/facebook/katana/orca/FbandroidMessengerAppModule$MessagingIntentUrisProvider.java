package com.facebook.katana.orca;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.intents.MessagingIntentUris;

class FbandroidMessengerAppModule$MessagingIntentUrisProvider extends AbstractProvider<MessagingIntentUris>
{
  private FbandroidMessengerAppModule$MessagingIntentUrisProvider(FbandroidMessengerAppModule paramFbandroidMessengerAppModule)
  {
  }

  public MessagingIntentUris a()
  {
    return new FbandroidMessagingIntentUris();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidMessengerAppModule.MessagingIntentUrisProvider
 * JD-Core Version:    0.6.0
 */