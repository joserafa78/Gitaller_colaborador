/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesExtras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import vistas_usuarios.VistaUsuarioRegistro;

public class ValidarCampos implements ActionListener {//CLASE PRINCIPAL
    //Variables de Clase

    //Metodo Validar Texto
    public void validarLetras(JTextField campo) {

        campo.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                char c = e.getKeyChar();
                
                String texto = campo.getText();
                int longit = texto.length();
                
                if (Character.isDigit(c)) { //Si lo q estoy digitando es un numero, entonces
                    
                String subtexto = texto.substring(0, texto.length() - 1);//longit-2
                    campo.setText("");
                   campo.setText(subtexto);
                    //JOptionPane.showMessageDialog(vur, "Error,Solo Aceptamos Letras.");
                }
            }
        });
    }

    public void validarNumeros(JTextField campo) {

        campo.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) { //keyTyped
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) { //Si lo q estoy digitando es un numero, entonces

                    String texto = campo.getText();
                    int longit = texto.length();
                    // System.out.println("texto:"+texto);
                    // System.out.println("longitud:"+longit);
                    String subtexto = texto.substring(0, texto.length() - 1);//longit-2
                    campo.setText("");
                    //System.out.println("Texto Final:"+texto);
                    campo.setText(subtexto);
                    //e.consume();
                    //JOptionPane.showMessageDialog(vur, "Error,Solo Aceptamos Numero.");
                }
            }

        });

    }

    public void validarLimiteCaracteres(JTextField campo, int cantidad) {
        campo.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                
                String texto = campo.getText();
                int tamano = campo.getText().length();
            
                int longit = texto.length();
                
                
                char c = e.getKeyChar();
                if (tamano >= cantidad) { //Si lo q estoy digitando es un numero, entonces
                   
                String subtexto = texto.substring(0, texto.length() - 1);//longit-2
                    campo.setText("");
                   campo.setText(subtexto);
                    //JOptionPane.showMessageDialog(null, "Erro,Exceso de Numeros.");
                }

            }
        });  //addKeyListener(new KeyAdapter);

    }
    
    public void validaLimiteCaracterPasswor(JPasswordField passwor, int cantidad){
            passwor.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                
                String texto = String.valueOf(passwor.getPassword()) ;
                int tamano =texto.length();
            
                int longit = texto.length();
                
                
                char c = e.getKeyChar();
                if (tamano >= cantidad) { //Si lo q estoy digitando es un numero, entonces
                   
                String subtexto = texto.substring(0, texto.length() - 1);//longit-2
                    passwor.setText("");
                   passwor.setText(subtexto);
                    //JOptionPane.showMessageDialog(null, "Erro,Exceso de Numeros.");
                }

            }
        });  //addKeyListener(new KeyAdapter);
    }
    
    public void validarEspacios(JTextField campo){
            campo.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                char c = e.getKeyChar();
                
                String texto = campo.getText();
                int longit = texto.length();
                
                if (c==' ') { //espaciadora
                    
                String subtexto = texto.substring(0, texto.length() - 1);//longit-2
                    campo.setText("");
                   campo.setText(subtexto);
                    //JOptionPane.showMessageDialog(vur, "Error,Solo Aceptamos Letras.");
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
