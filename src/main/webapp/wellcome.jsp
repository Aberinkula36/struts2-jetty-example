<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html>
<html>
<head>
  <title>Resumen de factura</title>
  <s:head/>
  <sx:head/>
</head>

<body>

    <h1>Resumen de factura:</h1>

    <p><strong>Importe bruto:</strong> <s:property value="invoiceBean.grossAmount"/></p>
    <p><strong>Fecha 'Date to':</strong> <s:date name="invoiceBean.dateTo" format="dd/MM/yyyy"/></p>
    <p><strong>Importe con IVA (21%):</strong> <s:property value="grossAmountWithVAT"/></p>

</body>
</html>
