package com.facebook.orca.common.ui.widgets.text;

public enum ThreadNameView$TextOptions
{
  private final int value;

  static
  {
    USE_PARTICIPANTS_NAMES_ONLY = new TextOptions("USE_PARTICIPANTS_NAMES_ONLY", 1, 1);
    TextOptions[] arrayOfTextOptions = new TextOptions[2];
    arrayOfTextOptions[0] = USE_THREAD_NAME_IF_AVAILABLE;
    arrayOfTextOptions[1] = USE_PARTICIPANTS_NAMES_ONLY;
    $VALUES = arrayOfTextOptions;
  }

  private ThreadNameView$TextOptions(int paramInt)
  {
    this.value = paramInt;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.widgets.text.ThreadNameView.TextOptions
 * JD-Core Version:    0.6.0
 */