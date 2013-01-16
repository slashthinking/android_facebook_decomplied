package com.facebook.composer.mentions;

import android.app.Activity;
import com.facebook.graphql.model.GraphQLEntityRange;
import java.util.List;

public abstract interface MentionsAutoCompleteTextViewInterface
{
  public abstract void a(Activity paramActivity);

  public abstract String getEncodedText();

  public abstract List<GraphQLEntityRange> getMentionsEntityRanges();

  public abstract String getRawText();
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.composer.mentions.MentionsAutoCompleteTextViewInterface
 * JD-Core Version:    0.6.2
 */