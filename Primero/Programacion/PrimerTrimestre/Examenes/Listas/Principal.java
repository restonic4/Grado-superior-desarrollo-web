package Primero.Programacion.PrimerTrimestre.Examenes.Listas;

import java.util.*;
	public class Principal {
	    public static void main(String[] args) {
	        Modelo tienda = new Modelo();

	        // Crear productos con ID
	        Producto camiseta = new Producto("p1", "Camiseta Azul", "Ropa", 25.00);
	        Producto pantalon = new Producto("p2", "Pantal�n Negro", "Ropa", 40.00);
	        Producto zapatillas = new Producto("p3", "Zapatillas Blancas", "Calzado", 60.00);
	        Producto movil = new Producto("p4", "M�vil", "Electr�nica", 300.00);
	        Producto tablet = new Producto("p5", "Tablet", "Electr�nica", 200.00);

	        // A�adir atributos a los productos (igual que antes)
	        HashMap<String, String> atributosCamiseta = new HashMap<>();
	        atributosCamiseta.put("Talla", "M");
	        atributosCamiseta.put("Color", "Azul");
	        atributosCamiseta.put("Material", "Algod�n");

	        HashMap<String, String> atributosPantalon = new HashMap<>();
	        atributosPantalon.put("Talla", "L");
	        atributosPantalon.put("Color", "Negro");
	        atributosPantalon.put("Material", "Denim");

	        HashMap<String, String> atributosZapatillas = new HashMap<>();
	        atributosZapatillas.put("Talla", "42");
	        atributosZapatillas.put("Color", "Blanco");
	        atributosZapatillas.put("Material", "Cuero");

	        HashMap<String, String> atributosMovil = new HashMap<>();
	        atributosMovil.put("Marca", "Samsung");
	        atributosMovil.put("Modelo", "Galaxy S21");
	        atributosMovil.put("Almacenamiento", "128GB");

	        HashMap<String, String> atributosTablet = new HashMap<>();
	        atributosTablet.put("Marca", "Apple");
	        atributosTablet.put("Modelo", "iPad Air");
	        atributosTablet.put("Almacenamiento", "64GB");

	        // A�adir productos a la tienda (igual que antes)
	        tienda.put(camiseta, atributosCamiseta);
	        tienda.put(pantalon, atributosPantalon);
	        tienda.put(zapatillas, atributosZapatillas);
	        tienda.put(movil, atributosMovil);
	        tienda.put(tablet, atributosTablet);

	        // Probar los m�todos (igual que antes)
	        System.out.println("valor del Atributo de Camiseta: " + tienda.obtenerAtributo(camiseta, "Color"));
	        System.out.println("Productos con atributo Talla: " + tienda.obtenerProductosConAtributo("Talla"));
	        System.out.println("Producto con precio m�s alto: " + tienda.obtenerProductoPrecioMasAlto());
	        System.out.println("Productos por categor�a: " + tienda.numeroProductosporCategorias());
	    }
	}