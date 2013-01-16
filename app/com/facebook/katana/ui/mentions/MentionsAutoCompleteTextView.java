package com.facebook.katana.ui.mentions;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.AutoCompleteTextView;
import com.facebook.common.util.ErrorReporting;
import com.facebook.composer.mentions.MentionsAutoCompleteTextViewInterface;
import com.facebook.feed.ui.OnSoftKeyboardStateChangeListener;
import com.facebook.feed.ui.SoftKeyboardStateAwareEditTextInterface;
import com.facebook.graphql.model.GraphQLEntityRange;
import com.facebook.katana.activity.composer.FeedStoryPreview;
import com.facebook.katana.features.tagging.MentionsTagTypeaheadAdapter;
import com.facebook.widget.tagging.TaggingProfile;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;

public class MentionsAutoCompleteTextView extends AutoCompleteTextView
  implements MentionsAutoCompleteTextViewInterface, SoftKeyboardStateAwareEditTextInterface
{
  public static final Class<?> c = MentionsAutoCompleteTextView.class;
  private MentionsTagTypeaheadAdapter a;
  private Map<String, TaggingProfile> b = Maps.a();
  private OnSoftKeyboardStateChangeListener d;
  private boolean e = false;

  public MentionsAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setInputType(0xFFFEFFFF & getInputType());
    setEditableFactory(new MentionsAutoCompleteTextView.MentionsSpannableFactory(this, null));
  }

  private int a(int paramInt)
  {
    Editable localEditable = getEditableText();
    int i = paramInt - 1;
    while (i >= 0)
      switch (localEditable.charAt(i))
      {
      default:
        i--;
        break;
      case '\n':
      case ' ':
        i++;
      case '@':
      }
    while (true)
    {
      return i;
      i = 0;
    }
  }

  private CharSequence a(int paramInt1, int paramInt2)
  {
    MentionsSpannableStringBuilder localMentionsSpannableStringBuilder = (MentionsSpannableStringBuilder)getEditableText();
    Object localObject;
    if (localMentionsSpannableStringBuilder.length() <= paramInt1)
      localObject = "";
    while (true)
    {
      return localObject;
      if (paramInt1 >= paramInt2)
      {
        localObject = "";
        continue;
      }
      if (localMentionsSpannableStringBuilder.a(paramInt1))
      {
        localObject = "";
        continue;
      }
      if ((paramInt1 > 0) && (localMentionsSpannableStringBuilder.a(paramInt1 - 1)))
      {
        localObject = "";
        continue;
      }
      switch (localMentionsSpannableStringBuilder.charAt(paramInt1))
      {
      default:
      case '@':
      }
      CharSequence localCharSequence;
      do
      {
        localObject = localMentionsSpannableStringBuilder.subSequence(paramInt1, paramInt2);
        if (((CharSequence)localObject).length() >= 4)
          break;
        localObject = "";
        break;
        localCharSequence = localMentionsSpannableStringBuilder.subSequence(paramInt1 + 1, paramInt2);
      }
      while (localCharSequence.length() < 1);
      localObject = localCharSequence;
    }
  }

  public void a(Activity paramActivity)
  {
    b(paramActivity);
  }

  public void b(Activity paramActivity)
  {
    this.a = new MentionsTagTypeaheadAdapter(paramActivity);
    this.a.a(new MentionsAutoCompleteTextView.1(this));
    setAdapter(this.a);
  }

  protected CharSequence convertSelectionToString(Object paramObject)
  {
    TaggingProfile localTaggingProfile = (TaggingProfile)paramObject;
    this.b.put(localTaggingProfile.a(), localTaggingProfile);
    return localTaggingProfile.a();
  }

  public String getEncodedText()
  {
    return MentionsUtils.a(getEditableText());
  }

  public List<GraphQLEntityRange> getMentionsEntityRanges()
  {
    return FeedStoryPreview.a(getEditableText());
  }

  public String getRawText()
  {
    return getEditableText().toString();
  }

  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    boolean bool = true;
    if (this.d == null)
    {
      super.onFocusChanged(paramBoolean, paramInt, paramRect);
      return;
    }
    if ((paramBoolean) && (!this.e))
    {
      this.d.a(this);
      if (!this.e)
        label46: this.e = bool;
    }
    do
    {
      super.onFocusChanged(paramBoolean, paramInt, paramRect);
      break;
      bool = false;
      break label46;
    }
    while ((paramBoolean) || (!this.e));
    this.d.b(this);
    if (!this.e);
    while (true)
    {
      this.e = bool;
      break;
      bool = false;
    }
  }

  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool1;
    if (this.d == null)
    {
      bool1 = super.onKeyPreIme(paramInt, paramKeyEvent);
      return bool1;
    }
    if ((paramInt == 4) && (this.e))
    {
      this.d.b(this);
      if (this.e)
        break label68;
    }
    label68: for (boolean bool2 = true; ; bool2 = false)
    {
      this.e = bool2;
      clearFocus();
      bool1 = super.onKeyPreIme(paramInt, paramKeyEvent);
      break;
    }
  }

  protected void performFiltering(CharSequence paramCharSequence, int paramInt)
  {
    MentionsSpannableStringBuilder localMentionsSpannableStringBuilder = (MentionsSpannableStringBuilder)getEditableText();
    if (localMentionsSpannableStringBuilder.a() >= 10);
    while (true)
    {
      return;
      int i = getSelectionStart();
      if (i > paramCharSequence.length())
        continue;
      int j = a(i);
      CharSequence localCharSequence = a(j, i);
      if (localCharSequence.toString().equals(""))
      {
        dismissDropDown();
        continue;
      }
      this.a.a(false).b(false);
      if ((localMentionsSpannableStringBuilder.charAt(j) == '@') || (localCharSequence.length() >= 5))
        this.a.a(true);
      if (localMentionsSpannableStringBuilder.charAt(j) == '@')
        this.a.b(true);
      super.performFiltering(localCharSequence, paramInt);
    }
  }

  protected void replaceText(CharSequence paramCharSequence)
  {
    int i = 1;
    MentionsSpannableStringBuilder localMentionsSpannableStringBuilder = (MentionsSpannableStringBuilder)getEditableText();
    if (localMentionsSpannableStringBuilder == null)
      throw new IllegalStateException("not editable text");
    TaggingProfile localTaggingProfile = (TaggingProfile)this.b.remove(paramCharSequence.toString());
    int j = getSelectionStart();
    int k = a(j);
    CharSequence localCharSequence = a(k, j);
    if (localCharSequence.toString().equals(""))
      ErrorReporting.a("MentionsAutoCompleteTextView", "attempted to complete mention that isn't valid with start at : " + k + "in text: '" + localMentionsSpannableStringBuilder + "'.", i);
    label196: 
    while (true)
    {
      return;
      int m = localMentionsSpannableStringBuilder.length() - localCharSequence.length();
      if (localMentionsSpannableStringBuilder.charAt(k) == '@');
      while (true)
      {
        if (m - i + paramCharSequence.length() > getResources().getInteger(2131558408))
          break label196;
        localMentionsSpannableStringBuilder.a(k, j, localTaggingProfile, getResources());
        this.a.clear();
        break;
        i = 0;
      }
    }
  }

  public void setOnSoftKeyboardVisibleListener(OnSoftKeyboardStateChangeListener paramOnSoftKeyboardStateChangeListener)
  {
    this.d = paramOnSoftKeyboardStateChangeListener;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.mentions.MentionsAutoCompleteTextView
 * JD-Core Version:    0.6.0
 */