import java.io.*;

public class Main {
    public static void main(String[] args) {
        String cadea = "o tempo está xélido";
        String ficheiro = "texto3.txt";

        // Mensaje de inicio de escritura
        System.out.println("Iniciando o proceso de escritura... crucemos os dedos");
        try (
                // Crear FileOutputStream, BufferedOutputStream y DataOutputStream
                FileOutputStream fileOutputStream = new FileOutputStream(ficheiro);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                DataOutputStream dataOutputStream = new DataOutputStream(bufferedOutputStream)
        ) {
            // Escribir la cadena tres veces
            for (int i = 0; i < 3; i++) {
                System.out.println("Escribindo a cadea: " + cadea);
                dataOutputStream.writeUTF(cadea);
                System.out.println("Tamaño do ficheiro: " + dataOutputStream.size() + " bytes");
            }
            // Mensaje de confirmacion
            System.out.println("Escritura completada con exito!");

        } catch (IOException e) {
            System.out.println("Produciuse un erro durante a escritura: " + e.getMessage());
        }

        // Mensaje de inicio de lectura
        System.out.println("Iniciando o proceso de lectura... crucemos os dedos");
        try (
                // Crear FileInputStream, BufferedInputStream y DataInputStream
                FileInputStream fileInputStream = new FileInputStream(ficheiro);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                DataInputStream dataInputStream = new DataInputStream(bufferedInputStream)
        ) {
            // Leer las tres cadenas
            while (dataInputStream.available() > 0) {
                System.out.println("Quedan: " + dataInputStream.available() + " bytes por ler");
                String cadeaLida = dataInputStream.readUTF();
                System.out.println("Cadea: " + cadeaLida);
            }
            // Mensaje de confirmacion
            System.out.println("Lectura completada con exito!");

        } catch (IOException e) {
            System.out.println("Produciuse un error durante a lectura: " + e.getMessage());
        }
    }
}
