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
//            List<Member> members = em.createQuery("select m from Member as m", Member.class)
//                    .getResultList();
//            for (Member member: members) {
//                System.out.println("member = " + member.getId() + ": " + member.getName());
//            }

            /*
             * compare two members in same entity manager
             */
//            Member findMember1 = em.find(Member.class, 2L);
//            System.out.println("findMember1 = " + findMember1.getId() + ": " + findMember1.getName());
//            Member findMember2 = em.find(Member.class, 2L);
//            System.out.println("findMember = " + findMember2.getId() + ": " + findMember2.getName());
//            System.out.println("is Equal ? " + (findMember1 == findMember2));     // true

            /*
             * compare two members in different entity manager (case 1)
             */
//            EntityManager newEm = emf.createEntityManager();
//            EntityTransaction newTx = newEm.getTransaction();
//            newTx.begin();
//            Member findMember1 = newEm.find(Member.class, 2L);
//            System.out.println("findMember1 = " + findMember1.getId() + ": " + findMember1.getName());
//            Member findMember2 = em.find(Member.class, 2L);
//            System.out.println("findMember = " + findMember2.getId() + ": " + findMember2.getName());
//            System.out.println("is Equal ? " + (findMember1 == findMember2));   // false
//            newTx.commit();
//            newEm.close();

            /*
             * compare two members in different entity manager (case 2)
             */
//            Member findMember1 = em.find(Member.class, 2L);
//            System.out.println("findMember1 = " + findMember1.getId() + ": " + findMember1.getName());
//            em.clear();
//            Member findMember2 = em.find(Member.class, 2L);
//            System.out.println("findMember = " + findMember2.getId() + ": " + findMember2.getName());
//            System.out.println("is Equal ? " + (findMember1 == findMember2));     // false

            /*
             * Dirty checking
             */
//            Member member = em.find(Member.class, 2L);
//            member.setName("memberJ");
//            System.out.println("member = " + member.getId() + ": " + member.getName());
//            member.setName("memberN");
//            System.out.println("member = " + member.getId() + ": " + member.getName());

            /*
             * semi-persistent state (case 1)
             */
//            Member member = em.find(Member.class, 2L);
//            member.setName("memberY");
//            System.out.println("member = " + member.getId() + ": " + member.getName());
//            em.flush();
//            member.setName("memberB");
//            Member mergeMember = em.merge(member);
//            Member findMember = em.find(Member.class, 2L);
//            System.out.println("mergeMember = " + mergeMember.getId() + ": " + mergeMember.getName());
//            System.out.println("findMember = " + findMember.getId() + ": " + findMember.getName());
//            System.out.println("is Equal ? " + (member == mergeMember));        // true
//            System.out.println("is Equal ? " + (mergeMember == findMember));    // true

            /*
             * semi-persistent state (case 2)
             */
//            Member member = em.find(Member.class, 2L);
//            System.out.println("member = " + member.getId() + ": " + member.getName());
//            member.setName("memberY");
//            System.out.println("member = " + member.getId() + ": " + member.getName());
//
//            EntityManager newEm = emf.createEntityManager();
//            EntityTransaction newTx = newEm.getTransaction();
//            newTx.begin();
//
//            Member mergeMember = newEm.find(Member.class, 2L);
//            System.out.println("mergeMember = " + mergeMember.getId() + ": " + mergeMember.getName());
//            mergeMember = newEm.merge(member);
//            System.out.println("mergeMember = " + mergeMember.getId() + ": " + mergeMember.getName());
//            System.out.println("is Equal ? " + (member == mergeMember));
//            newTx.commit();
//            newEm.close();

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
