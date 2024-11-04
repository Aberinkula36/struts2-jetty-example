package org.demo.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.demo.actions.beans.InvoiceBean;

import java.math.BigDecimal;

public class InvoiceAction extends ActionSupport {

    private InvoiceBean invoiceBean;
    private BigDecimal grossAmountWithVAT;

    @Override
    public String execute() throws Exception {
        // Calcula el importe con IVA (21%)
        if (invoiceBean.getGrossAmount() != null) {
            BigDecimal grossAmount = new BigDecimal(invoiceBean.getGrossAmount());
            BigDecimal vatRate = new BigDecimal("0.21");
            grossAmountWithVAT = grossAmount.add(grossAmount.multiply(vatRate));
        }
        System.out.println("execute!!");
        return SUCCESS;
    }

    public InvoiceBean getInvoiceBean() {
        return invoiceBean;
    }

    public void setInvoiceBean(InvoiceBean invoiceBean) {
        this.invoiceBean = invoiceBean;
    }

    public BigDecimal getGrossAmountWithVAT() {
        return grossAmountWithVAT;
    }

    @Override
    public void validate() {
        if (invoiceBean.getSubject() == null || invoiceBean.getSubject().isEmpty()) {
            addFieldError("invoiceBean.subject", "El concepto es obligatorio.");
        }
        if (invoiceBean.getDateFrom() == null) {
            addFieldError("invoiceBean.dateFrom", "La fecha 'Date from' es obligatoria.");
        }
        if (invoiceBean.getDateTo() == null) {
            addFieldError("invoiceBean.dateTo", "La fecha 'Date to' es obligatoria.");
        }
        if (invoiceBean.getGrossAmount() == null) {
            addFieldError("invoiceBean.grossAmount", "El importe bruto es obligatorio.");
        } else if (invoiceBean.getGrossAmount() <= 0) {
            addFieldError("invoiceBean.grossAmount", "El importe bruto debe ser un valor positivo.");
        }
    }
}
