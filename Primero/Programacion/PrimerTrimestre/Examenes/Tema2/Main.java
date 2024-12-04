package Primero.Programacion.PrimerTrimestre.Examenes.Tema2;

import javax.swing.*;

@SuppressWarnings("SpellCheckingInspection")
public class Main {
    //Fruta: ID, Nombre
    //Almacen: ID

    public static final String MENU_TEXT = """
            Introduce la opccion a ejecutar en la caja de abajo.
            ----------------------------------------------------
            1) Introducir los datos de un producto.
            2) Introducir los datos de un envio.
            3) Listar todo.
            4) Mostrar el nombre del producto del que se ha enviado más cantidad en un sólo envío.
            5) Mostrar la cantidad media de los tres últimos envíos a cada almacén con al menos tres envíos.
            6) Fin.
            """;

    public static final int MAX_PRODUCTS = 15;
    public static final int MAX_ENVIOS = 25;
    public static final int OPTION5_ROWS = 3;

    public static String[][] products = new String[MAX_PRODUCTS][2];
    public static int currentProductIndex = 0;

    public static String[][] envios = new String[MAX_ENVIOS][3];
    public static int currentEnviosIndex = 0;

    public static String[] almacenesRegistrados = new String[MAX_ENVIOS];
    public static int currentAlmacenIndex = 0;

    public static void main(String[] args) {
        promptMenu();
    }

    public static void promptMenu() {
        int option;

        do {
            String optionString = JOptionPane.showInputDialog(MENU_TEXT);
            option = Integer.parseInt(optionString);

            switch (option) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    addEnvio();
                    break;
                case 3:
                    showAll();
                    break;
                case 4:
                    showBiggestEnvio();
                    break;
                case 5:
                    showMediaLastEnvios();
                    break;
                default:
                    break;
            }
        } while (option != 6);
    }

    /**
     * Se añade un producto a la lista, usando un indice que va aumentando
     */
    public static void addProduct() {
        if (currentProductIndex >= products.length) {
            JOptionPane.showMessageDialog(null, "No se ha podido añadir un nuevo producto, se ha llegado al maximo.");
            return;
        }

        String id = JOptionPane.showInputDialog("Introduce el codigo del producto");
        String name = JOptionPane.showInputDialog("Introduce el nombre del producto");

        products[currentProductIndex][0] = id;
        products[currentProductIndex][1] = name;

        currentProductIndex++;

        JOptionPane.showMessageDialog(null, "Producto " + name + " con el codigo " + id + " añadido.");
    }

    /**
     * Se añade un envio a la lista, usando un indice que va aumentando
     */
    public static void addEnvio() {
        if (currentEnviosIndex >= envios.length) {
            JOptionPane.showMessageDialog(null, "No se ha podido añadir un nuevo envio, se ha llegado al maximo.");
            return;
        }

        String idProduct = JOptionPane.showInputDialog("Introduce el codigo del producto");
        String amount = JOptionPane.showInputDialog("Introduce la cantidad del producto en toneladas");
        String idAlmacen = JOptionPane.showInputDialog("Introduce el codigo del almacen");

        envios[currentEnviosIndex][0] = idProduct;
        envios[currentEnviosIndex][1] = amount;
        envios[currentEnviosIndex][2] = idAlmacen;

        currentEnviosIndex++;

        registerAlmacenIfNeeded(idAlmacen);

        JOptionPane.showMessageDialog(null, "Envio al almacen " + idAlmacen + " de " + idProduct + " con un total de" + amount + " toneladas.");
    }

    public static void registerAlmacenIfNeeded(String idAlmacen) {
        boolean found = false;
        int index = 0;

        while (!found && index < almacenesRegistrados.length) {
            if (almacenesRegistrados[index] != null && almacenesRegistrados[index].equals(idAlmacen)) {
                found = true;
            }

            index++;
        }

        if (found) {
            return;
        }

        if (currentAlmacenIndex < almacenesRegistrados.length) {
            almacenesRegistrados[currentAlmacenIndex] = idAlmacen;
            currentAlmacenIndex++;
        } else {
            JOptionPane.showMessageDialog(null, "No se ha podido registrar un nuevo almacen, se ha llegado al limite.");
        }
    }

    public static void showAll() {
        StringBuilder finalString = new StringBuilder();

        for (String idAlmacen : almacenesRegistrados) {
            if (idAlmacen != null) {
                finalString.append("Almacén: ").append(idAlmacen).append("\n");

                for (String[] envio : envios) {
                    if (envio != null && envio[0] != null && envio[2].equals(idAlmacen)) {
                        String productID = envio[0];
                        String productName = getProductNameByID(productID);
                        String productAmount = envio[1];

                        finalString.append("Producto: ").append(productID).append("(").append(productName).append(") ").append(productAmount).append(" Ton. \n");
                    }
                }
            }
        }

        JOptionPane.showMessageDialog(null, finalString.toString());
    }

    public static String getProductNameByID(String productID) {
        for (String[] product : products) {
            if (product[0].equals(productID)) {
                return product[1];
            }
        }

        return "None";
    }

    public static void showBiggestEnvio() {
        float biggestFoundNumber = 0;
        String biggestFoundID = "";

        for (String[] envio : envios) {
            if (envio != null && envio[1] != null) {
                float number = Float.parseFloat(envio[1]);

                if (number > biggestFoundNumber) {
                    biggestFoundNumber = number;
                    biggestFoundID = envio[0];
                }
            }
        }

        String productName = getProductNameByID(biggestFoundID);

        JOptionPane.showMessageDialog(null, "El producto del que se envió más cantidad en un envio es: " + productName + " con un envio de " + biggestFoundNumber + " Tm.");
    }

    public static void showMediaLastEnvios() {
        StringBuilder finalString = new StringBuilder();
        String[] blacklist = new String[OPTION5_ROWS];
        int currentBlackListIndex = 0;

        int rows = 0;

        while (rows < OPTION5_ROWS) {
            String almacenID = "";
            float amount = 0;
            int total = 0;

            for (String[] envio : envios) {
                boolean skip = false;

                if (envio != null && envio[1] != null) {
                    if (almacenID.isEmpty()) {
                        for (String s : blacklist) {
                            if (envio[2] != null && s != null && s.equals(envio[2])) {
                                skip = true;
                            }
                        }

                        if (!skip) {
                            almacenID = envio[2];

                            blacklist[currentBlackListIndex] = almacenID;
                            currentBlackListIndex++;
                        }
                    }

                    if (almacenID.equals(envio[2])) {
                        float number = Float.parseFloat(envio[1]);
                        amount += number;
                        total++;
                    }
                }
            }

            finalString.append("Almacén: ").append(almacenID).append(", Media: ").append(amount / total);
            rows++;
        }

        JOptionPane.showMessageDialog(null, finalString.toString());
    }
}
