package com.dontomate.rcm.ventasv1.ClasesAuxiliares;

/**
 * Created by Ricardo on 01/08/2017.
 */

public class Formulas {
    public int CalcularTotal(int cantidad, int precio, int subtotal)
    {
        subtotal = 0;
        subtotal = (int) (cantidad * precio);
        return subtotal;
    }



    private int CalcularSaldo(int total, int abono, int saldo)
    {
        saldo = 0;
        saldo = total - abono;
        return saldo;
    }
}
