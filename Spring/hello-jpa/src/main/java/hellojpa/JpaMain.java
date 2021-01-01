package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            /*
             * create new member
             */
//            Member member = new Member();
//            member.setId(3L);
//            member.setName("memberC");
//            em.persist(member);

            /*
             * read member
             */
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember = " + findMember.getId() + ": " + findMember.getName());

            /*
             * update member
             */
//            Member findMember = em.find(Member.class, 2L);
//            findMember.setName("memberY");

            /*
             * delete member
             */
//            Member findMember = em.find(Member.class, 1L);
//            em.remove(findMember);

            /*
             * JPQL read all members
             */
            List<Member> members = em.createQuery("select m from Member as m", Member.class)
                    .getResultList();
            for (Member member: members) {
                System.out.println("member = " + member.getId() + ": " + member.getName());
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
