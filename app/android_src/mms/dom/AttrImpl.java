package android_src.mms.dom;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.TypeInfo;

public class AttrImpl extends NodeImpl
  implements Attr
{
  private String b;
  private String c;

  protected AttrImpl(DocumentImpl paramDocumentImpl, String paramString)
  {
    super(paramDocumentImpl);
    this.b = paramString;
  }

  public String getName()
  {
    return this.b;
  }

  public Node getNextSibling()
  {
    return null;
  }

  public String getNodeName()
  {
    return this.b;
  }

  public short getNodeType()
  {
    return 2;
  }

  public Element getOwnerElement()
  {
    return null;
  }

  public Node getParentNode()
  {
    return null;
  }

  public Node getPreviousSibling()
  {
    return null;
  }

  public TypeInfo getSchemaTypeInfo()
  {
    return null;
  }

  public boolean getSpecified()
  {
    if (this.c != null);
    for (int i = 1; ; i = 0)
      return i;
  }

  public String getValue()
  {
    return this.c;
  }

  public boolean isId()
  {
    return false;
  }

  public void setNodeValue(String paramString)
  {
    setValue(paramString);
  }

  public void setValue(String paramString)
  {
    this.c = paramString;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.dom.AttrImpl
 * JD-Core Version:    0.6.0
 */