package com.facebook.widget;

import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.TextPaint;
import java.util.List;

public abstract interface VariableTextLayoutComputer<T>
{
  public abstract Layout a(T paramT, List<TextPaint> paramList, int paramInt1, Layout.Alignment paramAlignment, int paramInt2, int paramInt3);
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.VariableTextLayoutComputer
 * JD-Core Version:    0.6.2
 */