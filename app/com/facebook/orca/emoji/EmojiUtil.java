package com.facebook.orca.emoji;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.text.Editable;
import android.text.Spannable;
import android.widget.EditText;
import com.facebook.orca.common.util.SizeUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiUtil
{
  private final Emojis a;
  private final Resources b;

  EmojiUtil(Emojis paramEmojis, Resources paramResources)
  {
    this.a = paramEmojis;
    this.b = paramResources;
  }

  private EmojiSpan a(Emoji paramEmoji, int paramInt)
  {
    BitmapDrawable localBitmapDrawable = (BitmapDrawable)this.b.getDrawable(paramEmoji.a());
    int i = localBitmapDrawable.getIntrinsicWidth();
    int j = localBitmapDrawable.getIntrinsicHeight();
    int k = SizeUtil.a(this.b, 16.0F);
    localBitmapDrawable.setBounds(0, 0, i * paramInt / k, j * paramInt / k);
    return new EmojiSpan(localBitmapDrawable);
  }

  public void a(int paramInt1, int paramInt2, int paramInt3, Spannable paramSpannable, int paramInt4)
  {
    Emoji localEmoji = this.a.a(paramInt2);
    if (localEmoji != null)
      paramSpannable.setSpan(a(localEmoji, paramInt4), paramInt1, paramInt1 + paramInt3, 33);
  }

  public void a(Spannable paramSpannable, int paramInt)
  {
    for (int i = 0; i < paramSpannable.length(); i++)
    {
      int j = Character.codePointAt(paramSpannable, i);
      int k = Character.charCount(j);
      Emoji localEmoji2 = this.a.a(j);
      if (localEmoji2 != null)
        paramSpannable.setSpan(a(localEmoji2, paramInt), i, i + k, 33);
      (j + k);
    }
    Matcher localMatcher = Emojis.j.matcher(paramSpannable);
    while (localMatcher.find())
    {
      Emoji localEmoji1 = this.a.a(localMatcher.group(1));
      if (localEmoji1 == null)
        continue;
      paramSpannable.setSpan(a(localEmoji1, paramInt), localMatcher.start(1), localMatcher.end(1), 33);
    }
  }

  public void a(EditText paramEditText, Emoji paramEmoji)
  {
    int i = paramEditText.getSelectionStart();
    int j = paramEditText.getSelectionEnd();
    char[] arrayOfChar = Character.toChars(paramEmoji.c());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(arrayOfChar);
    paramEditText.getEditableText().replace(i, j, localStringBuilder);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.emoji.EmojiUtil
 * JD-Core Version:    0.6.0
 */