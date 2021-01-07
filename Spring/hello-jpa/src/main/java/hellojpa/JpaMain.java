package hellojpa;

import org.hibernate.Hibernate;

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

//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member1 = new Member();
//            member1.setName("MemberA");
////            member1.setTeam(team);
//            member1.changeTeam(team);
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setName("MemberB");
////            member2.setTeam(team);
//            member2.changeTeam(team);
//            em.persist(member2);
//
//            Member member3 = new Member();
//            member3.setName("MemberC");
////            team.getMembers().add(member3);     // 역방향
//            member3.changeTeam(team);
//            em.persist(member3);
//
//            Team findTeam = em.find(Team.class, team.getId());
//            List<Member> findTeamMembers = findTeam.getMembers();
//            for (Member m : findTeamMembers) {
//                // 순수 객체 상태인 경우(1차 캐시에는), 아직 member3만 list에 존재 --> changeTeam 연관관계 편의 메서드
//                System.out.println("m = " + m + "(" + m.getId() + "): " + m.getName());
//            }
//
//            em.flush();
//            em.clear();
//
//            Member findMember = em.find(Member.class, member1.getId());
//            System.out.println("team = " + team + ": " + team.getId());
//            System.out.println("team = " + findMember.getTeam() + ": " + findMember.getTeam().getId());
//            System.out.println("isEqual = " + (team == findMember.getTeam()));
//
//            List<Member> members = findMember.getTeam().getMembers();
//            for (Member m : members) {
//                System.out.println("m = " + m.getName());
//            }

//            Member member = new Member();
//            member.setName("memberA");
//            member.setAge(23);
//
//            Team team = new Team();
//            team.setName("teamA");
//            member.setTeam(team);
//
//            em.persist(member);
//            em.persist(team);
//
//            em.flush();
//            em.clear();
//
//            Member referMember = em.getReference(Member.class, member.getId());
//            System.out.println("referMember.getClass() = " + referMember.getClass());
//            System.out.println("isLoaded ? = " + emf.getPersistenceUnitUtil().isLoaded(referMember));
//
////            em.detach(referMember);
//            Hibernate.initialize(referMember);
//            System.out.println("isLoaded ? = " + emf.getPersistenceUnitUtil().isLoaded(referMember));
//            System.out.println("referMember = " + referMember.getId() + ": " + referMember.getName());
//            System.out.println("team = " + referMember.getTeam().getId() + ": " + referMember.getTeam().getName());
//
//            Member findMember = em.find(Member.class, member.getId());
//            System.out.println("findMember.getClass() = " + findMember.getClass());
//
//            System.out.println("isEqualClass ? = " + (referMember.getClass() == findMember.getClass()));
//
//            System.out.println("isMemberClass = " + (referMember instanceof Member) + ", " + (findMember instanceof Member));

            Member member1 = new Member();
            Member member2 = new Member();

            Team team = new Team();
            team.setName("teamA");

            team.addMember(member1);
            team.addMember(member2);

            em.persist(team);

            team.getMembers().remove(0);

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
