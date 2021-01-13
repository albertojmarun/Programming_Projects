/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica9;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
/**
 *
 * @author DAW_16_AlbertoMarun
 */
public class XMLPRUEBA {
    
    
    public static void main(String[] args){
        final String RUTA_XML = "XML_Coches.xml";
        
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            
            Element eRaiz = doc.createElement("Concesionario");
            doc.appendChild(eRaiz);
            
            Element eCoche = doc.createElement("Coche");
            eRaiz.appendChild(eCoche);
            
            Element eMarca = doc.createElement("Marca");
            eMarca.appendChild(doc.createTextNode(("Seat")));
            eCoche.appendChild(eMarca);
            
            Element eModelo = doc.createElement("Modelo");
            eModelo.appendChild(doc.createTextNode(("Leon")));
            eCoche.appendChild(eModelo);
            
            Element eCilindrada = doc.createElement("Cilindrada");
            eCilindrada.appendChild(doc.createTextNode(("1.5")));
            eCoche.appendChild(eCilindrada);
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(RUTA_XML));
            
            transformer.transform(source, result);
            
        } catch(Exception e){
            System.out.printf("Error -> %s\n", e.toString());
        }
    }
}

/**
 * 
 */