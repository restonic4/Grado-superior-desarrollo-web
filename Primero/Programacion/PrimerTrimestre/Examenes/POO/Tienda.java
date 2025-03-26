package Primero.Programacion.PrimerTrimestre.Examenes.POO;

import java.util.Arrays;

public class Tienda
{
	private Clienta tClientas[];
	private Vendedora tVendedoras[];
	private Prenda tPrendas[];
	private Venta tVentas[];


	public float totalComprasPorClienta(Clienta clienta)
	{
		float dineroTotal = 0;

		for (Venta venta : tVentas) {
			if (venta.getClienta().equals(clienta)) {
				Prenda prenda = venta.getPrenda();

				dineroTotal += prenda.getPrecio() * venta.getCantidad();
			}
		}

		return dineroTotal;
	}

	public Clienta[] clientasPremium(float minimo)
	{
		Clienta[] clientas = new Clienta[0];

		for (Clienta clienta : tClientas) {
			float importePorClienta = 0;

            for (Venta venta : tVentas) {
                if (venta.getClienta().equals(clienta)) {
                    importePorClienta += venta.getPrenda().getPrecio() * venta.getCantidad();
                }
            }

			if (importePorClienta > minimo) {
				Clienta[] clientasNuevas = Arrays.copyOf(clientas, clientas.length+1);
				clientasNuevas[clientas.length] = clienta;
				clientas = clientasNuevas;
			}
		}

		return clientas;
	}

	public float totalVentas(Fecha desde, Fecha hasta)
	{
		float importeTotal = 0;

		for (Venta venta : tVentas) {
			Fecha fechaVenta = venta.getFecha();

			if (fechaVenta.compareTo(desde) >= 0 && fechaVenta.compareTo(hasta) <= 0) {
				Prenda prenda = venta.getPrenda();

				importeTotal += prenda.getPrecio() * venta.getCantidad();
			}
		}

		return importeTotal;
	}

	public Vendedora vendedoraDelMes(int mes) 
	{
		Vendedora bestVendedora = null;
		float bestImporte = 0;

		for (Vendedora vendedora : tVendedoras) {
			float importeVendoraEnMes = totalComprasPorVendedoraYMes(vendedora, mes);

			if (importeVendoraEnMes > bestImporte) {
				bestVendedora = vendedora;
				bestImporte = importeVendoraEnMes;
			}
		}
		return bestVendedora;
	}

	public float totalComprasPorVendedoraYMes(Vendedora vendedora, int mes)
	{
		float totalVentas = 0;

		for (Venta venta : tVentas) {
			if (venta.getVendedora().equals(vendedora)) {
				int ventaMes = venta.getFecha().getMes();

				if (ventaMes == mes) {
					totalVentas += venta.getPrenda().getPrecio() * venta.getCantidad();
				}
			}
		}

		return totalVentas;
	}
	
	public Prenda[] paraRebajas()
	{
		Prenda[] rebajas = new Prenda[0];

		for (Prenda prenda : tPrendas) {
			boolean sold = false;

			for (int i = 0; i < tVentas.length && !sold; i++) {
				Venta venta = tVentas[i];
				Prenda prendaVendida = venta.getPrenda();

				if (prenda.equals(prendaVendida)) {
					sold = true;
				}
			}

			if (!sold) {
				Prenda[] rebajasNuevas = Arrays.copyOf(rebajas, rebajas.length+1);
				rebajasNuevas[rebajas.length] = prenda;
				rebajas = rebajasNuevas;
			}
		}

		return rebajas;
	}
	
	
	public Tienda()
	{
		this.tClientas = new Clienta[0];
		this.tPrendas = new Prenda[0];
		this.tVentas = new Venta[0];
		this.tVendedoras = new Vendedora[0];
	}

	public void anadeClienta(Clienta clienta)
	{
		Clienta[] tNueva = Arrays.copyOf(tClientas, tClientas.length+1);
		tNueva[tClientas.length] = clienta;
		this.tClientas = tNueva;
	}

	public void anadePrenda(Prenda prenda)
	{
		Prenda[] tNueva = Arrays.copyOf(tPrendas, tPrendas.length+1);
		tNueva[tPrendas.length] = prenda;
		this.tPrendas = tNueva;
	}

	public void anadeVenta(Venta venta)
	{
		Venta[] tNueva = Arrays.copyOf(tVentas, tVentas.length+1);
		tNueva[tVentas.length] = venta;
		this.tVentas = tNueva;
	}

	public void anadeVendedora(Vendedora vendedora)
	{
		Vendedora[] tNueva = Arrays.copyOf(tVendedoras, tVendedoras.length+1);
		tNueva[tVendedoras.length] = vendedora;
		this.tVendedoras = tNueva;
	}

	public Clienta[] gettClientas()
	{
		return tClientas;
	}

	public Vendedora[] gettVendedoras()
	{
		return tVendedoras;
	}

	public Prenda[] gettPrendas()
	{
		return tPrendas;
	}

	public Venta[] gettVentas()
	{
		return tVentas;
	}




}
