package aip;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

    public static void main(String[] args) {

        Student s1 = new Student("Sergej");
        Student s2 = new Student("Nidal");
        Student s3 = new Student("Nikolay");
        Notenkonto notenkonto1 = new Notenkonto(15);
        Notenkonto notenkonto2 = new Notenkonto(14);
        Notenkonto notenkonto3 = new Notenkonto(13);


        s1.addNotenkonto(notenkonto1);
        s2.addNotenkonto(notenkonto2);
        s3.addNotenkonto(notenkonto3);

        saveOrUpdate(s1);
        saveOrUpdate(s2);
        saveOrUpdate(s3);
        saveOrUpdate(notenkonto1);
        saveOrUpdate(notenkonto2);
        saveOrUpdate(notenkonto3);

        Kurs kurs1 = new Kurs("IS");
        Kurs kurs2 = new Kurs("AI");
        Kurs kurs3 = new Kurs("CI");
        Kurs kurs4 = new Kurs("BWL");

        s1.addKurs(kurs1);
        s1.addKurs(kurs4);
        s2.addKurs(kurs2);
        s3.addKurs(kurs3);

        saveOrUpdate(kurs1);
        saveOrUpdate(kurs2);
        saveOrUpdate(kurs3);
        saveOrUpdate(kurs4);
        saveOrUpdate(s1);
        saveOrUpdate(s2);
        saveOrUpdate(s3);

        Buch buch1 = new Buch("Kochen für Dummies");
        Buch buch2 = new Buch("Künztliche Intelligenz");
        Buch buch3 = new Buch("Mathematik");
        Buch buch4 = new Buch("BWL für Dummies");

        kurs1.addBuch(buch1);
        kurs1.addBuch(buch2);

        kurs2.addBuch(buch2);
        kurs2.addBuch(buch3);
        
        kurs4.addBuch(buch4);

        saveOrUpdate(buch1);
        saveOrUpdate(buch2);
        saveOrUpdate(buch3);
        saveOrUpdate(buch4);
        saveOrUpdate(kurs1);
        saveOrUpdate(kurs2);
        saveOrUpdate(kurs4);
    }

    private static void saveOrUpdate(Object object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            session.saveOrUpdate(object);
            // Committing the change in the database.
            session.flush();
            transaction.commit();

        } catch (Exception ex) {
            ex.printStackTrace();

            // Rolling back the changes to make the data consistent in case of any failure
            // in between multiple database write operations.
            transaction.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    private static void delete(Object object) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();

            session.delete(object);
            // Committing the change in the database.
            session.flush();
            transaction.commit();

        } catch (Exception ex) {
            ex.printStackTrace();

            // Rolling back the changes to make the data consistent in case of any failure
            // in between multiple database write operations.
            transaction.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
