package com.facebook.orca.common.ui.widgets.text;

import android.content.Context;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.threadview.RowReceiptParticipant;
import com.facebook.widget.VariableTextLayoutComputer;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RowReceiptTextViewComputer
  implements VariableTextLayoutComputer<RowReceiptTextView.Data>
{
  private static final Class<?> a = RowReceiptTextViewComputer.class;
  private final Context b;
  private final DataCache c;
  private final TextListWithMoreComputer d;

  public RowReceiptTextViewComputer(Context paramContext, DataCache paramDataCache, TextListWithMoreComputer paramTextListWithMoreComputer)
  {
    this.b = paramContext;
    this.c = paramDataCache;
    this.d = paramTextListWithMoreComputer;
  }

  private Layout a(String paramString, Layout.Alignment paramAlignment, int paramInt, TextPaint paramTextPaint)
  {
    return new StaticLayout(paramString, 0, paramString.length(), paramTextPaint, 16384, paramAlignment, 1.0F, 0.0F, false, TextUtils.TruncateAt.END, paramInt);
  }

  private String a(String paramString, int paramInt)
  {
    Context localContext;
    Object[] arrayOfObject;
    if (paramInt > 0)
    {
      localContext = this.b;
      arrayOfObject = new Object[2];
      arrayOfObject[0] = paramString;
      arrayOfObject[1] = Integer.valueOf(paramInt);
    }
    for (String str = localContext.getString(2131362687, arrayOfObject); ; str = this.b.getString(2131362686, new Object[] { paramString }))
      return str;
  }

  private List<String> a(List<RowReceiptParticipant> paramList)
  {
    ArrayList localArrayList = Lists.a();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      RowReceiptParticipant localRowReceiptParticipant = (RowReceiptParticipant)localIterator.next();
      localArrayList.add(this.c.b(localRowReceiptParticipant.a()));
    }
    return localArrayList;
  }

  private void a(RowReceiptTextView.Data paramData)
  {
    StringBuilder localStringBuilder = new StringBuilder(200);
    localStringBuilder.append("RowReceiptTextView.Data\n");
    if (!StringUtil.a(paramData.a()))
      localStringBuilder.append("getSimpleText ").append(paramData.a()).append('\n');
    if (paramData.b() != null)
    {
      localStringBuilder.append("getRowReceiptParticipantList\n");
      Iterator localIterator = paramData.b().iterator();
      while (localIterator.hasNext())
        localStringBuilder.append((RowReceiptParticipant)localIterator.next()).append('\n');
    }
    BLog.d(a, localStringBuilder.toString());
  }

  public Layout a(RowReceiptTextView.Data paramData, List<TextPaint> paramList, int paramInt1, Layout.Alignment paramAlignment, int paramInt2, int paramInt3)
  {
    boolean bool1;
    boolean bool2;
    label29: Layout localLayout;
    if (paramList.size() == 1)
    {
      bool1 = true;
      Preconditions.checkArgument(bool1, "Since only one textPaint is picked, it should only include one");
      if (paramInt2 != 1)
        break label70;
      bool2 = true;
      Preconditions.checkArgument(bool2, "Only one line is laid out by this logic.");
      if (paramData != null)
        break label76;
      localLayout = a("", paramAlignment, paramInt1, (TextPaint)paramList.get(0));
    }
    while (true)
    {
      return localLayout;
      bool1 = false;
      break;
      label70: bool2 = false;
      break label29;
      label76: if ((paramData.b() == null) && (!StringUtil.a(paramData.a())))
      {
        localLayout = a(paramData.a(), paramAlignment, paramInt1, (TextPaint)paramList.get(0));
        continue;
      }
      if ((paramData.b() != null) && (!paramData.b().isEmpty()))
      {
        int i = (int)((TextPaint)paramList.get(0)).measureText(this.b.getString(2131362686, new Object[] { "" }));
        TextPaint localTextPaint1 = (TextPaint)paramList.get(0);
        Context localContext1 = this.b;
        Object[] arrayOfObject1 = new Object[2];
        arrayOfObject1[0] = "";
        arrayOfObject1[1] = Integer.valueOf(8);
        int j = (int)localTextPaint1.measureText(localContext1.getString(2131362687, arrayOfObject1));
        TextPaint localTextPaint2 = (TextPaint)paramList.get(0);
        Context localContext2 = this.b;
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = "";
        arrayOfObject2[1] = Integer.valueOf(88);
        int k = (int)localTextPaint2.measureText(localContext2.getString(2131362687, arrayOfObject2));
        int[] arrayOfInt = new int[2];
        arrayOfInt[0] = (j - i);
        arrayOfInt[1] = (k - i);
        TextListWithMoreComputer.Result localResult = this.d.a(a(paramData.b()), paramInt1 - i, 1, paramInt3, (TextPaint)paramList.get(0), arrayOfInt);
        if (localResult.a().isEmpty())
        {
          a(paramData);
          localLayout = a(a("", 0), paramAlignment, paramInt1, (TextPaint)paramList.get(0));
          continue;
        }
        localLayout = a(a((String)localResult.a().get(0), localResult.b()), paramAlignment, paramInt1, (TextPaint)paramList.get(0));
        continue;
      }
      a(paramData);
      localLayout = a("", paramAlignment, paramInt1, (TextPaint)paramList.get(0));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.widgets.text.RowReceiptTextViewComputer
 * JD-Core Version:    0.6.0
 */