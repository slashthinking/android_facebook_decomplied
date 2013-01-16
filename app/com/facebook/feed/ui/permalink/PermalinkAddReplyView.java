package com.facebook.feed.ui.permalink;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.composer.mentions.MentionsAutoCompleteTextViewInterface;
import com.facebook.feed.ui.SoftKeyboardStateAwareEditTextInterface;
import com.facebook.feed.util.FeedUtils;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.UfiEvents.CommentPostEvent;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.collect.Lists;
import java.util.List;

public class PermalinkAddReplyView extends CustomLinearLayout
{
  private final Activity a;
  private final FeedEventBus b;
  private final String c;
  private EditText d;
  private final TextView e;

  public PermalinkAddReplyView(Context paramContext, AttributeSet paramAttributeSet, String paramString)
  {
    super(paramContext, paramAttributeSet);
    this.a = ((Activity)paramContext);
    this.b = ((FeedEventBus)getInjector().a(FeedEventBus.class));
    this.c = paramString;
    setContentView(2130903152);
    setOrientation(1);
    this.d = ((EditText)b(2131296713));
    this.d = FeedUtils.a(this.a, this.d, 2130903153);
    this.e = ((TextView)b(2131296714));
    this.d.setImeOptions(6);
    this.d.setOnEditorActionListener(new PermalinkAddReplyView.1(this));
    ((SoftKeyboardStateAwareEditTextInterface)this.d).setOnSoftKeyboardVisibleListener(new PermalinkAddReplyView.2(this));
    this.e.setOnClickListener(new PermalinkAddReplyView.3(this));
    a(new PermalinkAddReplyView.CommentFocusSubscriber(this, null));
  }

  public PermalinkAddReplyView(Context paramContext, String paramString)
  {
    this(paramContext, null, paramString);
  }

  private void a()
  {
    this.d.clearFocus();
    FeedUtils.a(this.a);
    String str1 = this.d.getEditableText().toString();
    Object localObject = Lists.a();
    String str2;
    if ((this.d instanceof MentionsAutoCompleteTextViewInterface))
    {
      MentionsAutoCompleteTextViewInterface localMentionsAutoCompleteTextViewInterface = (MentionsAutoCompleteTextViewInterface)this.d;
      str2 = localMentionsAutoCompleteTextViewInterface.getEncodedText();
      str1 = localMentionsAutoCompleteTextViewInterface.getRawText();
      localObject = localMentionsAutoCompleteTextViewInterface.getMentionsEntityRanges();
    }
    while (true)
    {
      if (!StringUtil.a(str2))
      {
        this.b.a(new UfiEvents.CommentPostEvent(this.c, str2, str1, (List)localObject));
        this.d.setText("");
      }
      return;
      str2 = str1;
    }
  }

  protected FeedEventBus getEventBus()
  {
    return this.b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.permalink.PermalinkAddReplyView
 * JD-Core Version:    0.6.0
 */