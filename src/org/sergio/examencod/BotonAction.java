/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sergio.examencod;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "File",
        id = "org.sergio.examencod.BotonAction"
)
@ActionRegistration(
        iconBase = "org/sergio/examencod/caja.png",
        displayName = "#CTL_BotonAction"
)
@ActionReference(path = "Toolbars/File",
                 position = 0)
@Messages("CTL_BotonAction=empaquetar")
public final class BotonAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
    
        //pedimos los datos de los archivos
        String categoria=JOptionPane.showInputDialog("Bcategory: (Education)");
        String outdir=JOptionPane.showInputDialog("outdir: ");
        String outfile=JOptionPane.showInputDialog("outfile: ");
        String srcdir=JOptionPane.showInputDialog("ruta del archivo");
        String srcfiles=JOptionPane.showInputDialog("nombre del archivo.jar");
        String appclass=JOptionPane.showInputDialog("paquete+mainclass");
        String title=JOptionPane.showInputDialog("descripcion");
        String Bicon=JOptionPane.showInputDialog("ruta del icono");
                
        try {
            //ejecutamos el javapackager con las variables que pedimos antes
            String cmd="javapackager -deploy -native deb -Bcategory="+categoria+
                    " -outdir "+outdir+" -outfile "+outfile+" -srcdir "+srcdir+" -srcfiles "+srcfiles+
                    " -appclass "+appclass+" -title "+title+" -Bicon="+Bicon;

            
            Runtime rt = Runtime.getRuntime();
            //Process pr = rt.exec("cmd /c dir");
            Process pr = rt.exec(cmd);
            
            BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            
            String line=null;
            
            while((line=input.readLine()) != null) {
                System.out.println(line);
            }
            
            int exitVal = pr.waitFor();
            System.out.println("Exited with error code "+exitVal);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        } catch (InterruptedException ex) {
            Exceptions.printStackTrace(ex);
        }
 
            

    }
    }


