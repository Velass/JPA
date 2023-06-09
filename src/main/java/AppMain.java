
import com.mycompany.mavenproject1.model.Address;
import com.mycompany.mavenproject1.model.Address2;
import com.mycompany.mavenproject1.model.Artist;
import com.mycompany.mavenproject1.model.Book;
import com.mycompany.mavenproject1.model.BookCategory;
import com.mycompany.mavenproject1.model.CD;
import com.mycompany.mavenproject1.model.Customer;
import com.mycompany.mavenproject1.model.Customer2;
import com.mycompany.mavenproject1.model.JPAUtils;
import com.mycompany.mavenproject1.model.OrderLine;
import com.mycompany.mavenproject1.model.PurchaseOrder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Enumerated;
import jakarta.persistence.TypedQuery;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author pc
 */
public class AppMain {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        EntityManager em = JPAUtils.getInstance().getEntityManager();

        Book b = new Book();
        b.setTitle("Limitless");
        b.setDescription("un bouqin");
        b.setPrice(25F);
        b.setIllustrations(Boolean.TRUE);
        b.setNbOfPages(250);
        b.setCategory(BookCategory.ART);
        Book b1 = new Book();
        b1.setTitle("livre2");
        b.getTags().add("Cerveau");
        b.getTags().add("lecture");
        b.getTags().add("habitude");

        CD cd = new CD();
        cd.setTitle("test1");
        cd.setPrice(10F);
        cd.setDescription("unedescribe");
        cd.getTracks().put(1, "test");
        cd.getTracks().put(2, "test2");
        CD cd2 = new CD();
        cd2.setTitle("test2");
        cd2.setPrice(20F);
        cd2.setDescription("unedescribetest");
        Artist artist = new Artist();
        artist.setFirstName("test");
        cd.getArtists().add(artist);
        artist.getCds().add(cd2);

        Address address = new Address();
        address.setCity("Montpellier");
        address.setCountry("France");
        address.setZipcode("test");
        Customer customer = new Customer();
        customer.setEmail("test@test");
        customer.setFirstName("test");
        customer.setAddress(address);

        Address2 address1 = new Address2();
        address1.setCity("Montpellier");
        address1.setCountry("France");
        Customer2 customer2 = new Customer2();
        customer2.setEmail("test@test");
        customer2.setFirstName("test");
        customer2.setAddress(address1);
        OrderLine orderLine = new OrderLine();
        orderLine.setItem("test");
        orderLine.setUnitPrice(10.00);
        orderLine.setQuantity(10);
        OrderLine orderLine2 = new OrderLine();
        orderLine2.setItem("test2");
        orderLine2.setUnitPrice(10.00);
        orderLine2.setQuantity(10);
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.getOrderLines().add(orderLine);
        purchaseOrder.getOrderLines().add(orderLine2);

        // entre .begin et .commit tout va persister et grace a ca il y aura la ligne dans la base de données
        em.getTransaction().begin();
        em.persist(b);
        em.persist(b1);
        em.persist(address1);
        em.persist(customer2);
        em.persist(customer);
        em.persist(artist);
        em.persist(purchaseOrder);
        em.persist(orderLine);
        em.persist(orderLine2);
        em.persist(cd2);
        em.persist(cd);

        em.getTransaction().commit();

        TypedQuery<Customer> findCustomerByCity = em.createNamedQuery("customerfindByCity", Customer.class);
        findCustomerByCity.setParameter("city", "Montpellier");
        List<Customer> customers = findCustomerByCity.getResultList();
        for (Customer customer1 : customers) {
            System.out.println("customer :  " + customer1.toString());

        }

        TypedQuery<Customer> customerfindByZipode = em.createNamedQuery("customerfindByZipode", Customer.class);
        customerfindByZipode.setParameter("zipcode", "Montpellier");
        List<Customer> customers1 = customerfindByZipode.getResultList();
        for (Customer customer1 : customers1) {
            System.out.println("customer :  " + customer1.toString());

        }
        
        
        
        
        Book b2 = em.find(Book.class, 1);
        if (b2 == null) {
            System.out.println("on trouve pas le bouquin");
        }
        if (b2 != null) {
            System.out.println("livre ok" + b2.toString());
        }
        em.close();
    }
}
