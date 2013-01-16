package com.fasterxml.jackson.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@JacksonAnnotation
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.ANNOTATION_TYPE, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.PARAMETER})
public @interface JsonFormat
{
  public static final String DEFAULT_LOCALE = "##default";
  public static final String DEFAULT_TIMEZONE = "##default";

  public abstract String locale();

  public abstract String pattern();

  public abstract JsonFormat.Shape shape();

  public abstract String timezone();
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.fasterxml.jackson.annotation.JsonFormat
 * JD-Core Version:    0.6.0
 */