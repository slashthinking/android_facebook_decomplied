package com.facebook.common.json.jsonmirror;

import com.facebook.common.json.jsonmirror.types.JMBase;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface JMAutogen$ExplicitType
{
  public abstract String jsonFieldName();

  public abstract Class<? extends JMBase> type();
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.common.json.jsonmirror.JMAutogen.ExplicitType
 * JD-Core Version:    0.6.0
 */