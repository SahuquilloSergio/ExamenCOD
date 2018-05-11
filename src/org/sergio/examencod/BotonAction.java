/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sergio.examencod;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "File",
        id = "org.sergio.examencod.BotonAction"
)
@ActionRegistration(
        iconBase = "org/sergio/examencod/google.png",
        displayName = "#CTL_BotonAction"
)
@ActionReference(path = "Toolbars/File",
                 position = 0)
@Messages("CTL_BotonAction=Google")
public final class BotonAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
    }
}
