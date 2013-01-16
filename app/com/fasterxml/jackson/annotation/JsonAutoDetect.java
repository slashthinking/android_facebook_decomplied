package com.fasterxml.jackson.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@JacksonAnnotation
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.ANNOTATION_TYPE, java.lang.annotation.ElementType.TYPE})
public @interface JsonAutoDetect
{
  public abstract JsonAutoDetect.Visibility creatorVisibility();

  public abstract JsonAutoDetect.Visibility fieldVisibility();

  public abstract JsonAutoDetect.Visibility getterVisibility();

  public abstract JsonAutoDetect.Visibility isGetterVisibility();

  public abstract JsonAutoDetect.Visibility setterVisibility();
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.fasterxml.jackson.annotation.JsonAutoDetect
 * JD-Core Version:    0.6.0
 */