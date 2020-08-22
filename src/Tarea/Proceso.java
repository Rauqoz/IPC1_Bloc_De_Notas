package Tarea;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Proceso {
//ejercicio de bloc de notas
    public String nombre = "", ruta = "";
    JFileChooser escoger;
    File archivo;
    String extension = ".ipc";
    public boolean esNuevo = false;

    public void guardarArchivoComo(String texto) {
        System.out.println("guardar como");
        esNuevo = false;
        escoger = new JFileChooser();
        escoger.setApproveButtonText("Guardar Como");
        escoger.setFileFilter(new FileNameExtensionFilter("ipc", "ipc"));
        int a = escoger.showOpenDialog(null);
        if (a == JFileChooser.APPROVE_OPTION) {
            archivo = new File(escoger.getSelectedFile().toString());
            try {
                if (archivo.exists()) {
                    archivo.delete();
                    PrintWriter escritor = new PrintWriter(new FileWriter(archivo));
                    if (texto.endsWith("")) {
                        escritor.println(texto);
                    }
                    escritor.close();
                } else {
                    PrintWriter escritor = new PrintWriter(new FileWriter(archivo + extension));
                    if (texto.endsWith("")) {
                        escritor.println(texto);
                    }
                    escritor.close();
                }
            } catch (Exception ex) {
            }
            nombre = archivo.getName();
        }

    }

    public String abrirArchivo() {
        System.out.println("abrir");
        esNuevo = false;
        escoger = new JFileChooser();
        escoger.setApproveButtonText("Abrir");
        escoger.setFileFilter(new FileNameExtensionFilter("ipc", "ipc"));
        int a = escoger.showOpenDialog(null);
        if (a == JFileChooser.APPROVE_OPTION) {
            archivo = new File(escoger.getSelectedFile().toString());
            try {
                BufferedReader lector = new BufferedReader(new FileReader(archivo));
                String fila;
                String resultado = "";
                while ((fila = lector.readLine()) != null) {
                    resultado += fila + "\n";
                }
                nombre = archivo.getName();
                ruta = archivo.getPath();
                return resultado;
            } catch (Exception ex) {
                return ex.getMessage();
            }
        }
        return null;
    }

    public void guardarArchivo(String nombreArchivo, String texto) {
        System.out.println("guardar");
        esNuevo = false;
        if (esNuevo) {
            escoger = new JFileChooser();
            escoger.setApproveButtonText("Guardar");
            escoger.setFileFilter(new FileNameExtensionFilter("ipc", "ipc"));
            int a = escoger.showOpenDialog(null);
            if (a == JFileChooser.APPROVE_OPTION) {
                archivo = new File(escoger.getSelectedFile().toString());
                try {
                    if (archivo.exists()) {
                        archivo.delete();
                        PrintWriter escritor = new PrintWriter(new FileWriter(archivo));
                        if (texto.endsWith("")) {
                            escritor.println(texto);
                        }
                        escritor.close();
                    } else {
                        PrintWriter escritor = new PrintWriter(new FileWriter(archivo + extension));
                        if (texto.endsWith("")) {
                            escritor.println(texto);
                        }
                        escritor.close();
                    }
                    nombre = archivo.getName() + ".ipc";
                } catch (Exception ex) {
                }

            } else {
                try {
                    archivo = new File(ruta);
                    archivo.delete();
                    PrintWriter escritor = new PrintWriter(new FileWriter(archivo));
                    if (texto.endsWith("")) {
                        escritor.println(texto);
                    }
                    escritor.close();

                } catch (Exception ex) {

                }

                nombre = archivo.getName();

            }

        }

    }
}
