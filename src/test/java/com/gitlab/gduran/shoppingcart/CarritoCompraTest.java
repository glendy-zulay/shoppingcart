package com.gitlab.gduran.shoppingcart;

import com.gitlab.gduran.lambdas.CarritoBuilder;
import com.gitlab.gduran.lambdas.CarritoCompra;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

public class CarritoCompraTest {

    @Test
    public void shouldReturnTheCountOfAllItems() throws Exception {
        CarritoBuilder builder = new CarritoBuilder(30);
        CarritoCompra carritoCompra = builder.build();
        Assert.assertEquals(30,carritoCompra.contarNumeroProductos());
    }

    @Test
    public void shouldCalculatePriceTotal() throws Exception {
        CarritoBuilder builder = new CarritoBuilder(60,5);
        CarritoCompra carritoCompra = builder.build();
        Assert.assertEquals(300,carritoCompra.calcularPrecioTotal());
    }

    @Test
    public void shoulCalculatePriceTotalLambda() throws Exception {
        CarritoBuilder builder = new CarritoBuilder(60,5);
        CarritoCompra carritoCompra= builder.build();
        Assert.assertEquals(300, carritoCompra.calcularPrecioTotalLambda());
    }

    @Test
    public void shouldCalculateTotalDiscount()throws Exception {
        CarritoBuilder builder = new CarritoBuilder(20,100);
        CarritoCompra carritoCompra= builder.build();
        Assert.assertEquals(100, carritoCompra.calcularDescuentoTotal(100));
    }

    @Test
    public void shouldCalcultareTotalDiscountLambda() throws Exception {
        CarritoBuilder builder = new CarritoBuilder( 20, 100);
        CarritoCompra carritoCompra = builder.build();
        Assert.assertEquals(40, carritoCompra.calcularDescuentoTotalLambda(50));
    }
}
