package android_src.mms.dom.smil.parser;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.smil.SMILDocument;
import org.w3c.dom.smil.SMILElement;

public class SmilXmlSerializer
{
  private static void a(Writer paramWriter, Element paramElement)
  {
    paramWriter.write(60);
    paramWriter.write(paramElement.getTagName());
    if (paramElement.hasAttributes())
    {
      NamedNodeMap localNamedNodeMap = paramElement.getAttributes();
      for (int i = 0; i < localNamedNodeMap.getLength(); i++)
      {
        Attr localAttr = (Attr)localNamedNodeMap.item(i);
        paramWriter.write(" " + localAttr.getName());
        paramWriter.write("=\"" + localAttr.getValue() + "\"");
      }
    }
    SMILElement localSMILElement = (SMILElement)paramElement.getFirstChild();
    if (localSMILElement != null)
    {
      paramWriter.write(62);
      do
      {
        a(paramWriter, localSMILElement);
        localSMILElement = (SMILElement)localSMILElement.getNextSibling();
      }
      while (localSMILElement != null);
      paramWriter.write("</");
      paramWriter.write(paramElement.getTagName());
      paramWriter.write(62);
    }
    while (true)
    {
      return;
      paramWriter.write("/>");
    }
  }

  public static void a(SMILDocument paramSMILDocument, OutputStream paramOutputStream)
  {
    try
    {
      BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(paramOutputStream, "UTF-8"), 2048);
      a(localBufferedWriter, paramSMILDocument.getDocumentElement());
      localBufferedWriter.flush();
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
        localUnsupportedEncodingException.printStackTrace();
    }
    catch (IOException localIOException)
    {
      while (true)
        localIOException.printStackTrace();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.dom.smil.parser.SmilXmlSerializer
 * JD-Core Version:    0.6.0
 */