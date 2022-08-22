package com.gitlab.gduran.lambdas;


import java.util.Collection;

public class CarritoCompra {

    private final Collection<Integer> precios;

    public CarritoCompra(Collection<Integer> precios) {
        this.precios = precios;
    }

    public int calcularPrecioTotal(){
        int precioTotal = 0;
        for (Integer precio: precios ) {
            precioTotal += precio;
        }
        return  precioTotal;
    }

    public int contarNumeroProductos(){
        return precios.size();
    }

    public int calcularPrecioTotalLambda(){
        int precioTotal2  = this.precios.stream().mapToInt(Integer::intValue).sum();
        return precioTotal2;

    }

    public long calcularDescuentoTotal(int cantidadDescuento){
        long descuentoTotal = 0;

        for (Integer precio: precios) {
            if(precio>= cantidadDescuento){
                descuentoTotal += (cantidadDescuento* 5)/100;
            }
        }
        return descuentoTotal;
    }

    public long calcularDescuentoTotalLambda (int cantidadDescuento){
        long descuentoTotal = 0;
        long numeroDescuentos = this.precios.stream()
                                .filter(precio -> precio.intValue() >= cantidadDescuento)
                                .count();
       return descuentoTotal = (cantidadDescuento*5/100)*numeroDescuentos;
    }
}
