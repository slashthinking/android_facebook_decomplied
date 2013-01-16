package com.facebook.widget;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.R.styleable;

public class ConfirmationView extends CustomViewGroup
{
  private final TextView a;
  private final TextView b;
  private final TextView c;
  private ConfirmationView.Listener d;

  public ConfirmationView(Context paramContext)
  {
    this(paramContext, null);
  }

  public ConfirmationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ConfirmationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903106);
    this.a = ((TextView)getView(2131296549));
    this.b = ((TextView)getView(2131296550));
    this.c = ((TextView)getView(2131296551));
    TypedArray localTypedArray = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.ConfirmationView, 0, 0);
    try
    {
      setMessage(localTypedArray.getString(0));
      setNegativeButtonTitle(localTypedArray.getString(2));
      setPositiveButtonTitle(localTypedArray.getString(1));
      localTypedArray.recycle();
      this.b.setOnClickListener(new ConfirmationView.1(this));
      this.c.setOnClickListener(new ConfirmationView.2(this));
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  public void setListener(ConfirmationView.Listener paramListener)
  {
    this.d = paramListener;
  }

  public void setMessage(String paramString)
  {
    this.a.setText(paramString);
  }

  public void setNegativeButtonTitle(String paramString)
  {
    this.b.setText(paramString);
  }

  public void setPositiveButtonTitle(String paramString)
  {
    this.c.setText(paramString);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.ConfirmationView
 * JD-Core Version:    0.6.2
 */