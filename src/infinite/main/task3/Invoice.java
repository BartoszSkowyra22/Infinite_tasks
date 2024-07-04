package infinite.main.task3;

public class Invoice {
    private String invoiceNumber;
    private Object invoiceData;

    public Invoice(String invoiceNumber, Object invoiceData) {
        this.invoiceNumber = invoiceNumber;
        this.invoiceData = invoiceData;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public Object getInvoiceData() {
        return invoiceData;
    }
}
