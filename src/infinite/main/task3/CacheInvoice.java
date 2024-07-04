package infinite.main.task3;

import java.util.HashMap;

public class CacheInvoice implements InvoiceRepository {
    private final InvoiceJpaRepository repository;
    private final HashMap<String, Invoice> cache;

    public CacheInvoice(InvoiceJpaRepository repository) {
        this.repository = repository;
        this.cache = new HashMap<>();
    }

    @Override
    public Invoice find(String invoiceNumber) {
        if (cache.containsKey(invoiceNumber)) {
            System.out.println("W pamięci znajduje się już faktura nr " + invoiceNumber);
            return cache.get(invoiceNumber);
        } else {
            System.out.println("Dodanie do pamięci faktury nr " + invoiceNumber);
            Invoice invoice = repository.find(invoiceNumber);
            cache.put(invoiceNumber, invoice);
            return invoice;
        }
    }
}
